package test.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author wang
 * @date  Aug 28, 2017 - 2:16:14 PM
 * @Description 读文件
 */
public class FileUtil {

  private static BufferedReader br;

  public static Map<String,List<String>> readFiles(String fileDirectoryPath, String charsetName) throws IOException {
    File file = new File(fileDirectoryPath);
    Map<String,List<String>> filesMap = new HashMap<>();
    List<String> fileStr;
    if (file.exists()) {
      fileStr = new ArrayList<>();
      File[] files = file.listFiles();
      for (File f : files) {
        if (f.isDirectory()) {
          readFiles(f.getAbsolutePath(), charsetName);
        } else {
          fileStr = readFile(f, charsetName);
          filesMap.put(f.getPath(), fileStr);
        }
      }
    }
    return filesMap;
  }
  
  public static List<String> readFile(File logFile, String fileEncoder) throws IOException {
    List<String> list = null;
    br = new BufferedReader(new InputStreamReader(new FileInputStream(logFile), fileEncoder));
      list = new ArrayList<>();
      String rec;
      while ((rec = br.readLine()) != null) {
        list.add(rec);
      }
    return list;
  }
  
  public static void writeFile(String fileStr,String filePath) throws IOException{
    String path =  filePath.substring(0,filePath.lastIndexOf("\\"));
    String fileName =  filePath.substring(filePath.lastIndexOf("\\")+1,filePath.length());
    writeFile(fileStr,path,fileName);
  }
  
  public static void writeFile(String fileStr,String path,String fileName) throws IOException{
    
    File file = new File(path);
    if(!file.exists()){
      file.mkdirs();
    }
    file = new File(path+"\\"+fileName);
    if(!file.exists()){
      file.createNewFile();
    }
    BufferedWriter bufferWritter = new BufferedWriter(new FileWriter(file));
    bufferWritter.write(fileStr);
    bufferWritter.close();
  }
  
  public static String toString(List<String> file){
    StringBuffer sb = new StringBuffer();
    for(String s:file){
      sb.append(s+",");
    }
    return String.valueOf(sb);
  }
}

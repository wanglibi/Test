package test.a;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import test.utils.FileUtil;

public class TestFile {
 public static void main(String[] args) {
  try {
    Map<String,List<String>> m = FileUtil.readFiles("E:\\dzh365\\data\\SH", "utf-8");
    for(String key:m.keySet()){
      List<String> f =  m.get(key);
      FileUtil.writeFile(FileUtil.toString(f),"E:\\bak\\"+key.substring(key.lastIndexOf("\\")+1,key.length()));
      break;
    }
  } catch (IOException e) {
    e.printStackTrace();
  }
}
}

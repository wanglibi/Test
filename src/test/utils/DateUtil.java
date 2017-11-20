package test.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
  
  public static String currentDate(){
    return parseDate(new Date());
  }
  
  public static String parseDate(Long time){
    return parseDate(new Date(time));
  }
  
  public static String parseDate(Date date){
    return parseDate(date,"yyyy-MM-dd HH:mm:ss");
  } 
  
  public static String parseDate(Date date,String format){
    SimpleDateFormat s = new SimpleDateFormat(format);
    return  s.format(date);
  }
  
  public static Date toDate(String date) throws ParseException{
    return toDate(date,"yyyy-MM-dd HH:mm:ss");
  }
  
  public static Date toDate(String date,String format) throws ParseException{
    SimpleDateFormat s = new SimpleDateFormat(format);
    return s.parse(date);
  }
  
  public static Long toTime(String date) throws ParseException{
    return toDate(date,"yyyy-MM-dd HH:mm:ss.SSS").getTime();
  }
}

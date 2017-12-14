package test.utils;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

public class Utils {

  public static boolean isEmpty(Object obj) {
    if (null == obj) {
      return true;
    }
    if (obj instanceof String) {
      return stringIsEmpty((String) obj);
    } else if (obj instanceof List) {
      return listIsEmpty((List<?>) obj);
    } else if (obj instanceof StringBuffer) {
      return stringBufferIsEmpty((StringBuffer) obj);
    } else if (obj instanceof String[]) {
      return arrayStrIsEmpty((String[]) obj);
    } else if (obj instanceof Map) {
      return mapIsEmpty((Map<?, ?>) obj);
    }
    return false;
  }

  private static boolean arrayStrIsEmpty(String[] str) {
    if (str.length == 0) {
      return true;
    }
    return false;
  }

  private static boolean stringIsEmpty(String str) {
    if ("".equals(str.trim())) {
      return true;
    }
    return false;
  }

  private static boolean listIsEmpty(List<?> list) {
    if (list.isEmpty() || list.size() == 0) {
      return true;
    }
    return false;
  }

  private static boolean stringBufferIsEmpty(StringBuffer sb) {
    if (sb.toString().trim().equals("")) {
      return true;
    }
    return false;
  }

  private static boolean mapIsEmpty(Map<?, ?> map) {
    if (map.isEmpty()) {
      return true;
    }
    return false;
  }

  @SuppressWarnings(value = {"unchecked"})
  public static <T> T conversion(Object object, Class<T> c) {
    if (object == null) {
      return null;
    }
    if (c.equals(String.class)) {
      return (T) object.toString();
    }
    if (object instanceof String) {
      String s = object.toString();
      if (c.equals(Integer.class)) {
        return (T) Integer.valueOf(s);
      } else if (c.equals(Double.class)) {
        return (T) Double.valueOf(s);
      } else if (c.equals(Long.class)) {
        return (T) Long.valueOf(s);
      } else if (c.equals(Short.class)) {
        return (T) Short.valueOf(s);
      } else if (c.equals(Byte.class)) {
        return (T) Byte.valueOf(s);
      } else if (c.equals(BigDecimal.class)) {
        return (T) new BigDecimal(s);
      } else if (c.equals(Boolean.class)) {
        Boolean is = ("true".equals(s) || "1".equals(s)) ? true : false;
        return (T) is;
      }
    }
    return (T) object;
  }

  public static void main(String[] args) {
    System.err.println(JM("7d216efc62c70e1d5961078216db895e"));
  }

  public static String md5(String str) {
    MessageDigest md;
    StringBuffer sb = new StringBuffer();
    try {
      md = MessageDigest.getInstance("MD5");
      md.update(str.getBytes());
      byte[] data = md.digest();
      int index;
      for (byte b : data) {
        index = b;
        if (index < 0) index += 256;
        if (index < 16) sb.append("0");
        sb.append(Integer.toHexString(index));
      }
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    return sb.toString();
  }
  
  // 加密后解密
  public static String JM(String inStr) {
    char[] a = inStr.toCharArray();
    for (int i = 0; i < a.length; i++) {
      a[i] = (char) (a[i] ^ 't');
    }
    String k = new String(a);
    return k;
  }
}

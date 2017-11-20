package test.iterator;

import java.util.Arrays;

public class List implements Collection {

  private Object[] data = new Object[10];
  private Object[] emptyData = {};
  private int index = 0;

  @Override
  public Iterator iterator() {
    return new AbsIterator(this);
  }

  @Override
  public int size() {
    return index;
  }

  @Override
  public Object get(int index) {
    return data[index];
  }

  public void add(Object obj) {
    expandListSize();
    data[index++] = obj;
  }

  public void removeAll() {
    data = emptyData;
    index = 0;
  }

  private void expandListSize() {
    if (index > data.length - 1) {
      data = Arrays.copyOf(data, index + (index >> 1));
      System.err.println("扩充list长度："+data.length);
    }
  }
}

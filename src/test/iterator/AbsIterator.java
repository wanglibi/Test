package test.iterator;

public class AbsIterator implements Iterator {

  private int index = -1;

  private Collection collection;

  public AbsIterator(Collection collection) {
    super();
    this.collection = collection;
  }

  @Override
  public Object previous() {
    if (index > 0) {
      index--;
    }
    return collection.get(index);

  }

  @Override
  public Object next() {
    if (index < collection.size() - 1) {
      index++;
    }
    return collection.get(index);

  }

  @Override
  public boolean hasNext() {
    if (index < collection.size() - 1) {
      return true;
    }
    return false;

  }

  @Override
  public Object first() {
    index = 0;
    return collection.get(index);
  }

}

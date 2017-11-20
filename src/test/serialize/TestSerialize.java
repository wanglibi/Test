package test.serialize;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *1）一旦变量被transient修饰，变量将不再是对象持久化的一部分，该变量内容在序列化后无法获得访问。

 *2）transient关键字只能修饰变量，而不能修饰方法和类。注意，本地变量是不能被transient关键字修饰的。变量如果是用户自定义类变量，则该类需要实现Serializable接口。
  
 *3）被transient关键字修饰的变量不再能被序列化，一个静态变量不管是否被transient修饰，均不能被序列化。
 *
 *反序列化后类中static型变量的值为当前JVM中对应static变量的值，这个值是JVM中的,不是反序列化得出的
 *
 *对象的序列化可以通过实现两种接口来实现，
 *若实现的是Serializable接口，则所有的序列化将会自动进行，
 *若实现的是Externalizable接口，则没有任何东西可以自动序列化，需要在writeExternal方法中进行手工指定所要序列化的变量，这与是否被transient修饰无关。
 */
public class TestSerialize implements Serializable {

    /**
   * @fieldName: serialVersionUID
   * @fieldType: long
   * @Description: TODO 
   */
  private static final long serialVersionUID = 1L;

    private transient String content = "我不会被序列化";
    
    private String content1 = "我会被序列化";
    
    private static String content2 = "会不会被序列化呢？";


    public static void main(String[] args) throws Exception {
      content2="2";
      
      TestSerialize et = new TestSerialize();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
                new File("test")));
        out.writeObject(et);

        ObjectInput in = new ObjectInputStream(new FileInputStream(new File(
                "test")));
        et = (TestSerialize) in.readObject();
        System.out.println(et.content);
        System.out.println(et.content1);
        System.out.println(et.content2);

        out.close();
        in.close();
    }
}

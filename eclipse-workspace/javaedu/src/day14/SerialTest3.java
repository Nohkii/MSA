package day14;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import day7.Student2;

public class SerialTest3 {
   public static void main(String[] args) throws Exception{ 
      FileOutputStream fos =  new FileOutputStream("c:/iotest/test2.ser"); 
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(new Date());
      Thread.sleep(3000);
      oos.writeObject(new Date()); 
      Student2 st = new Student2("duke", 27, "Java프로그래밍"); 
      // 얘는 Serializable을 상속하고 있지않으면 에러남 (Date는 이미 상속하고있음)
      oos.writeObject(st);
      oos.close();
      fos.close();
      System.out.println("직렬화 출력 완료");      
   }
}



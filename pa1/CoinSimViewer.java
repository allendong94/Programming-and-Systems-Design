//Name: HANG DONG
//USC NetID: donghang
//CS 455 PA1
//Fall 2018
import javax.swing.JFrame;
import java.util.Scanner;
public class CoinSimViewer
{
   public static void main(String[] args)
   {
      System.out.print("Enter number of trials: ");
      Scanner input=new Scanner(System.in);//assume input type is integer
      int x=input.nextInt();
      while(x<=0)
      {
         System.out.println("ERROR: Number entered must be greater than 0.");
         System.out.print("Enter number of trials: ");
         x=input.nextInt();
      }
      JFrame frame = new JFrame();//containing the carcomponent.java
      frame.setSize(800, 500);
      frame.setTitle("CoinSim");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      CoinSimComponent csc = new CoinSimComponent(x);
      frame.add(csc);

      frame.setVisible(true);
   }
}
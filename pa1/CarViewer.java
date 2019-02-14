import javax.swing.JFrame;

public class CarViewer
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
         int x=input.nextInt();
      }
      JFrame frame = new JFrame();//containing the carcomponent.java
      frame.setSize(500, 800);
      frame.setTitle("Two cars");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      CarComponent component = new CarComponent();
      frame.add(component);

      frame.setVisible(true);
   }
}

import java.util.Scanner;
public class CoinTossSimulatorTester{
 public static void main(String[] args)
   {
      CoinTossSimulator t=new CoinTossSimulator();
      System.out.println("After constructor");
    

    
      t.run(10);
      System.out.println("After run(10):");
      System.out.println("number of trails [exp:10]: "+t.getNumTrials());
	  System.out.println("Two-head tosses: "+ t.getTwoHeads());
	  System.out.println("Two-tail tosses: "+ t.getTwoTails());
	  System.out.println("One-head one-tail tosses: "+ t.getHeadTails());
	  System.out.println("Tosses add up correctly? "+(t.getNumTrials()==t.getTwoHeads()+t.getTwoTails()+t.getHeadTails()));
	  
      t.run(1);
      System.out.println("After run(1):");
      System.out.println("number of trails [exp:11]: "+t.getNumTrials());
	  System.out.println("Two-head tosses: "+ t.getTwoHeads());
	  System.out.println("Two-tail tosses: "+ t.getTwoTails());
	  System.out.println("One-head one-tail tosses: "+ t.getHeadTails());
	  System.out.println("Tosses add up correctly? "+(t.getNumTrials()==t.getTwoHeads()+t.getTwoTails()+t.getHeadTails()));
      
      t.run(100);
      System.out.println("After run(100):");
      System.out.println("number of trails [exp:111]: "+t.getNumTrials());
	  System.out.println("Two-head tosses: "+ t.getTwoHeads());
	  System.out.println("Two-tail tosses: "+ t.getTwoTails());
	  System.out.println("One-head one-tail tosses: "+ t.getHeadTails());
	  System.out.println("Tosses add up correctly? "+(t.getNumTrials()==t.getTwoHeads()+t.getTwoTails()+t.getHeadTails()));
    
      t.run(5000);
      System.out.println("After run(5000):");
      System.out.println("number of trails [exp:5111]: "+t.getNumTrials());
	 System.out.println("Two-head tosses: "+ t.getTwoHeads());
	  System.out.println("Two-tail tosses: "+ t.getTwoTails());
	  System.out.println("One-head one-tail tosses: "+ t.getHeadTails());
	  System.out.println("Tosses add up correctly? "+(t.getNumTrials()==t.getTwoHeads()+t.getTwoTails()+t.getHeadTails()));
    
      t.reset();
      System.out.println("After reset");
      
      t.run(0);
      System.out.println("After run(0):");
      System.out.println("number of trails [exp:0]: "+t.getNumTrials());
	  System.out.println("Two-head tosses: "+ t.getTwoHeads());
	  System.out.println("Two-tail tosses: "+ t.getTwoTails());
	  System.out.println("One-head one-tail tosses: "+ t.getHeadTails());
	  System.out.println("Tosses add up correctly? "+(t.getNumTrials()==t.getTwoHeads()+t.getTwoTails()+t.getHeadTails()));
	  
      t.run(1);
      System.out.println("After run(1):");
      System.out.println("number of trails [exp:1]: "+t.getNumTrials());
	  System.out.println("Two-head tosses: "+ t.getTwoHeads());
	  System.out.println("Two-tail tosses: "+ t.getTwoTails());
	  System.out.println("One-head one-tail tosses: "+ t.getHeadTails());
	  System.out.println("Tosses add up correctly? "+(t.getNumTrials()==t.getTwoHeads()+t.getTwoTails()+t.getHeadTails()));
      
      t.run(200);
      System.out.println("After run(200):");
      System.out.println("number of trails [exp:201]: "+t.getNumTrials());
	  System.out.println("Two-head tosses: "+ t.getTwoHeads());
	  System.out.println("Two-tail tosses: "+ t.getTwoTails());
	  System.out.println("One-head one-tail tosses: "+ t.getHeadTails());
	  System.out.println("Tosses add up correctly? "+(t.getNumTrials()==t.getTwoHeads()+t.getTwoTails()+t.getHeadTails()));
    
      t.run(3000);
      System.out.println("After run(3000):");
      System.out.println("number of trails [exp:3201]: "+t.getNumTrials());
	  System.out.println("Two-head tosses: "+ t.getTwoHeads());
	  System.out.println("Two-tail tosses: "+ t.getTwoTails());
	  System.out.println("One-head one-tail tosses: "+ t.getHeadTails());
	  System.out.println("Tosses add up correctly? "+(t.getNumTrials()==t.getTwoHeads()+t.getTwoTails()+t.getHeadTails()));
    
   }
}
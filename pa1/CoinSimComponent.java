//Name: HANG DONG
//USC NetID: donghang
//CS 455 PA1
//Fall 2018

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Scanner;
import javax.swing.JComponent;
public class CoinSimComponent extends JComponent
{
   private static int vb=20;
   private static int bw=60;
   private CoinTossSimulator coinSimulator;
   private int sum;
   public CoinSimComponent(int numTrials) 
   {
		
		sum = numTrials;
		coinSimulator = new CoinTossSimulator();
		coinSimulator.run(numTrials);
	}
    public void paintComponent(Graphics g)
    {
        Graphics2D gg=(Graphics2D) g;
        int nt=coinSimulator.getNumTrials();
        int th=coinSimulator.getTwoHeads();
        int tt=coinSimulator.getTwoTails();
        int h_t=coinSimulator.getHeadTails();
        //percent calculation
        int hh_p = (int) Math.round((double)100*th/nt);
		int ht_p = (int) Math.round((double)100*h_t/nt);
		int tt_p = (int) Math.round((double)100*tt/nt);
        
        double scale=(getHeight() - 2*vb )/(double)sum;
        String label1="Two Heads: "+th+"("+hh_p+"%)";
        String label2="A Head and a Tail: "+h_t+"("+ht_p+"%)";
        String label3="Two Tails: "+tt+"("+tt_p+"%)";
        Bar bar1 = new Bar(getHeight()-vb, getWidth()/4-bw/2, bw, th, scale, Color.RED,label1 );
        bar1.draw(gg);
	    Bar bar2 = new Bar(getHeight()-vb, getWidth()*2/4-bw/2, bw, h_t, scale, Color.GREEN, label2);
        bar2.draw(gg);
	    Bar bar3 = new Bar(getHeight()-vb, getWidth()*3/4-bw/2, bw, tt, scale, Color.BLUE,label3);  
	    bar3.draw(gg); 
    } 
}
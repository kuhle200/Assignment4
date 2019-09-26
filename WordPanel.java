//package skeletonCodeAssgnmt2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CountDownLatch;

import javax.swing.JButton;
import javax.swing.JPanel;

public class WordPanel extends JPanel implements Runnable {
		public static volatile boolean done;
		private WordRecord[] words;
		private int noWords;
		private int maxY;

		
		public void paintComponent(Graphics g) {
		    int width = getWidth();
		    int height = getHeight();
		    g.clearRect(0,0,width,height);
		    g.setColor(Color.red);
		    g.fillRect(0,maxY-10,width,height);

		    g.setColor(Color.black);
		    g.setFont(new Font("Helvetica", Font.PLAIN, 26));
		   //draw the words
		   //animation must be added 
		    for (int i=0;i<noWords;i++){	    	
		    	//g.drawString(words[i].getWord(),words[i].getX(),words[i].getY());	
		    	g.drawString(words[i].getWord(),words[i].getX(),words[i].getY()+20);  //y-offset for skeleton so that you can see the words	
			//this is for making word disappeare if the reach the bottom
		    //the red zone start at 480 so when the reach that point 
		    //when it disappear you missed it so you should increment missed
		    //and new word should appear
		    if(words[i].getY()== maxY){
				words[i].resetWord();
				WordApp.score.missedWord();
                WordApp.missed.setText("Missed:" + WordApp.score.getMissed()+ "    ");
				
			}
		    }

		   
		  }
		
		WordPanel(WordRecord[] words, int maxY) {
			this.words=words; //will this work?
			noWords = words.length;
			done=false;
			this.maxY=maxY;		
		}
		
		public void run() {
			//add in code to animate this
			Thread myThread;
			WordPanelThrd wt;
			for(int i=0;i<words.length;i++){
				wt = new WordPanelThrd(words[i]);
				myThread = new Thread(wt);
				myThread.start();				
			}
			
			while(true){
				repaint();
			}
		}

	}



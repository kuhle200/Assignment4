//this code is for compering words that is type that is the same as the ones in the array
import javax.swing.JLabel;
import java.util.*;
public class Checker extends Thread{
	//WordRecord words;
	WordRecord[] words;
	String typedWord;
	JLabel caught;
    JLabel scr;
	
	public Checker(String typedWord,WordRecord[] words,JLabel scr,JLabel caught){
		this.typedWord = typedWord;
		this.words =words;
		this.scr = scr;
		this.caught = caught;
	}
	
	public void run(){
		for(int i=0;i<words.length;i++){
			//used matchWord program to handle the words if the are the same
			//the loop is for hadling if there are two same words on the screen for it will clear them both
			if(words[i].matchWord(typedWord)==true){
				WordApp.score.caughtWord(typedWord.length());
                caught.setText("Caught: " + WordApp.score.getCaught() + "    ");
                scr.setText("Score:" + WordApp.score.getScore()+ "    "); 				
			}
		}
	}
}

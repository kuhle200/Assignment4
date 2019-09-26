public class NewGame extends Thread{
	WordRecord words[];
	
	public NewGame(WordRecord words[]){
		this.words =words;
	}
	
	public void run(){
		
		WordApp.score.resetScore();
        WordApp.caught.setText("Caught: " + WordApp.score.getCaught() + "    ");
	    WordApp.missed.setText("Missed:" + WordApp.score.getMissed()+ "    ");
	    WordApp.scr.setText("Score:" + WordApp.score.getScore()+ "    "); 		
		
		for(int i=0;i<words.length;i++){
			words[i].resetWord();
			words[i].resetPos();
		}
		WordPanelThrd.falling = false;
	}

}

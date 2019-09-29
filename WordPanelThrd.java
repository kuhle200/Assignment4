public class WordPanelThrd extends Thread{
	
	static boolean falling;
    WordRecord words;
    
    public WordPanelThrd(WordRecord words){
		this.words = words;
		this.falling = true;
	}
	
	public void run(){
		while(falling == true && WordApp.score.getTotal() < WordApp.totalWords){
			words.drop(words.getSpeed()/20);
		try{
			Thread.sleep(1000);
		}
		catch(InterruptedException e){
			System.out.println(e);
			System.exit(0);
		}
	}
	}
}

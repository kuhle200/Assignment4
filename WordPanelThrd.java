public class WordPanelThrd extends Thread{
	
	static boolean falling;
    WordRecord words;
    
    public WordPanelThrd(WordRecord words, boolean falling){
		this.words = words;
		this.falling = falling;
	}
	
	public void run(){
		while(falling == true){
			words.drop(words.getSpeed()/800);
		}
		try{
			Thread.sleep(1000);
		}
		catch(InterruptedException e){
			System.out.println(e);
		}
		
	}
}

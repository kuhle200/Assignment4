public class WordPanelThrd extends Thread{
	
	static boolean falling;
    WordRecord words;
    
    public WordPanelThrd(WordRecord words, boolean falling){
		this.words = words;
		this.falling = falling;
	}
	
	public void run(){
		while(falling == true){
			words.drop(words.getSpeed());
		}
		try{
			Thread.sleep(600);
		}
		catch(InterruptedException e){
			System.out.println(e);
		}
		
	}
}

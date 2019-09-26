public class WordPanelThrd extends Thread{
	
	static boolean falling;
    WordRecord words;
    
    public WordPanelThrd(WordRecord words){
		this.words = words;
		this.falling = true;
	}
	
	public void run(){
		while(falling == true){
			words.drop(words.getSpeed()/110);
		}
		try{
			Thread.sleep(1000);
		}
		catch(InterruptedException e){
			System.out.println(e);
			System.exit(0);
		}
		
	}
}

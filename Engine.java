import java.util.Observable;


public class Engine extends Observable{
	private int progress;
	private static Thread thread;
	
	public Engine(){
		progress=0;
	}
	public void start(){
		 thread = new Thread(new Runnable(){
			public void run(){
				while (true){
					progress++;
					System.out.println(getProgress());
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
					}
				}
			}
		});
		thread.start();
	}
	
	public static void stop(){

		thread.stop();
		
	}
	
	public int getProgress(){
		return progress;
	}
	
}


import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JProgressBar;


public class ProgressView implements Observer {
	private int ausgabe;
	private Engine engine;
	
	public ProgressView(Engine engine){
		this.engine = engine;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		
		Thread thread = new Thread(new Runnable(){
			public void run(){
				while (true){
					ausgabe = engine.getProgress();
					System.out.println("update=" +ausgabe);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
				}
			}
		});
		thread.start();
				
	}
	
	public int getAusgabe(){
		return ausgabe;
	}

	
}

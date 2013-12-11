import javax.swing.JFrame;
import javax.swing.JProgressBar;


public class Main {
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		f.setSize(100,100);
		final JProgressBar bar = new JProgressBar(0,100);
		final Engine test = new Engine();
		test.start();
		final ProgressView view = new ProgressView(test);
		
		bar.setStringPainted( true );
	    
		Thread thread = new Thread(new Runnable(){
			public void run(){
				while (true){
					view.update(test , bar);
					bar.setValue(view.getAusgabe());
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
					}
				}
			}
		});
		thread.start();
	    
	    
		 
		 f.add(bar);
		 
		 f.setVisible( true );
	}
}

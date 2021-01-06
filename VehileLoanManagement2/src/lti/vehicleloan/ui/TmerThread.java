package lti.vehicleloan.ui;

public class TmerThread implements Runnable {


	public void run() {
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
		
	}

}

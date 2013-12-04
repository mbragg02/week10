package text_loops;

public class WorkerThread implements Runnable {

	private final String name;
	public static final int COUNT = 10;


	public WorkerThread(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for(int i = 0; i < COUNT; i ++) {
			System.out.println("Loop Started: " + name + ", iteration:" + i + ".");
//		System.out.println("waiting..." + name);
	        processCommand();
			System.out.println("Loop Finished: " + name + ", iteration:" + i + ".");


		}	
	}

	private void processCommand() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

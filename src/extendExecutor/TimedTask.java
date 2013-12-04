package extendExecutor;

public class TimedTask implements Runnable {
	
	
	private final String name;
	public static final int COUNT = 10;


	public TimedTask(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		try {
			System.out.println(name);
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println(name + " finished");
		}
		
	}

}

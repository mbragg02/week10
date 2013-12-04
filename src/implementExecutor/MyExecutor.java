package implementExecutor;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;

public class MyExecutor implements Executor {

	private final Queue<Runnable> taskQue = new ArrayDeque<Runnable>();
	private Runnable active = null;



	@Override
	public synchronized void execute(final Runnable command) {

		//		In the simplest case, an executor can run the submitted task immediately in the caller's thread
		//		command.run();

		//		More typically, tasks are executed in some thread other than the caller's thread. The executor below spawns a new thread for each task.
		//		new Thread(command).start();

		//		Thread.activeCount()

		
		
		
		//		Que	
		taskQue.offer(new Runnable() {

			@Override
			public void run() {
				try{
//					new Thread(command).start();
					command.run();
				} finally {
					scheduleNext();
				}

			}
		});





		//	System.out.println(Thread.activeCount());


		if (active == null) {
			scheduleNext();
		}

//		System.out.println("thread active: " + Thread.activeCount());


	} //  end void execute(final Runnable command)


	protected synchronized void scheduleNext() { 
		active = taskQue.poll();
		if (active != null) {
			active.run();
			//        	new Thread(active).start();
		} 
	} 


	public int getMaxPendingTime() {
		int result = 0;
		int cueSize = taskQue.size();
		result = cueSize;
		return result;
	}

}

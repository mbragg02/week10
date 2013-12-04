package text_loops;

import implementExecutor.MyExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import extendExecutor.TimedTask;

public class SimpleThreadPool {

	public static void main(String[] args) {
//        ExecutorService executor = Executors.newFixedThreadPool(10);
        
//        Executor executor = Executors.newSingleThreadExecutor();
        
		
		Executor executor = new MyExecutor();


		for (int i = 0; i < 10; i++) {
			

			Runnable worker = new WorkerThread("Thread " + i);
//			Runnable worker = new TimedTask("Thread " + i);


            executor.execute(worker);
            
//            System.out.println(((MyExecutor) executor).getMaxPendingTime());

           
		}
		
		
		
		
//		executor.shutdown();
		
		
//		while (!executor.isTerminated()) {
//			// wait for threads to finish 
//		}
//		System.out.println("Finished all threads");

	}

}

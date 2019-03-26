package com.accenture.concurrency.executors;

import java.util.Arrays;
import java.util.List;
/*package com.accenture.concurrency;
import java.util.concurrent.ExecutorService;



public class Executors {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.submit(() -> {
		    String threadName = Thread.currentThread().getName();
		    System.out.println("Hello " + threadName);
		});
	}


}*/
import java.util.concurrent.*;


public class ExecutorsExample {
	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		/*******************Executors***************/
	
	ExecutorService executor = Executors.newSingleThreadExecutor();
	ExecutorService executorService=Executors.newSingleThreadExecutor();
	executor.submit(() -> {
	    String threadName = Thread.currentThread().getName();
	    System.out.println("Hello " + threadName);
	    return 123;
	});
	
	executorService.submit(()-> {
		String threadName1=Thread.currentThread().getName();
		System.out.println("Hello"+threadName1);
	});
	
	
	   
	    
	    
	    System.out.println("\n New Program");
	    
	    /*******************Callable and Future***************/
	    
	    Callable<Integer> task = () -> {
	        try {
	            TimeUnit.SECONDS.sleep(1);
	            return 123;
	        }
	        catch (InterruptedException e) {
	            throw new IllegalStateException("task interrupted", e);
	        }
	    };
	    
	    
	    Callable<Integer> task1 = () -> {
	        try {
	            TimeUnit.SECONDS.sleep(1);
	            return 123;
	        }
	        catch (InterruptedException e) {
	            throw new IllegalStateException("task interrupted", e);
	        }
	    };
	    
	    
	    
	    ExecutorService executorService2 = Executors.newFixedThreadPool(1);
	    Future<Integer> future = executorService2.submit(task);
	    System.out.println("future done? " + future.isDone());
	    System.out.println("future done? " + future.isDone());
	    Integer result = future.get();
	    System.out.print("result: " + result);
	    
	    
	    
	    /*******************TimeOut****************/
	    ExecutorService executorService3 = Executors.newFixedThreadPool(1);
	    Future<Integer> future1 = executorService3.submit(() -> {
	        try {
	            TimeUnit.SECONDS.sleep(1);
	            return 123;
	        }
	        catch (InterruptedException e) {
	            throw new IllegalStateException("task interrupted", e);
	        }
	    });
	    future1.get(2, TimeUnit.SECONDS);
	    
	    
	    
	   System.out.println("invoke all");
	    
	    /*******************InvokeAll****************/
	    ExecutorService executorService4 = Executors.newWorkStealingPool();

	    List<Callable<String>> callables = Arrays.asList(
	            () -> "task1",
	            () -> "task2",
	            () -> "task3");

		
	    executor.invokeAll(callables)
	        .stream()
	        .map(future3 -> {
	            try {
	                return future3.get();
	            }
	            catch (Exception e) {
	                throw new IllegalStateException(e);
	            }
	        })
	        .forEach(System.out::println);
	    
	    System.out.println("invoke all end");
	    
	    /*******************InvokeAny****************/
	    
	    
	   /* Callable<String> callable {
	        return () -> {
	            TimeUnit.SECONDS.sleep(10);
	            return result;
	        };
	    }
	    */
	   
	    
	    
	    
		/*
		 * ExecutorService executorService5 = Executors.newWorkStealingPool();
		 * 
		 * List<Callable<String>> callables = Arrays.asList( callable("task1", 2),
		 * callable("task2", 1), callable("task3", 3));
		 * 
		 * String result = executor.invokeAny(callables); System.out.println(result);
		 */
	    
	    /*******************Schedule Executors***************/
	    System.out.println("Schedule executor start");
	    ScheduledExecutorService executorService5 = Executors.newScheduledThreadPool(1);

	    Runnable task2 = () -> System.out.println("Scheduling:1 " + System.nanoTime());
	    
	    /**************schedule()**************/
		/*
		 * ScheduledFuture<?> future2 = executorService5.schedule(task2, 3,
		 * TimeUnit.SECONDS);
		 * 
		 * TimeUnit.MILLISECONDS.sleep(1);
		 * 
		 * long remainingDelay = future2.getDelay(TimeUnit.MILLISECONDS);
		
	    System.out.printf("Remaining Delay: %sms", remainingDelay);*/
	    
	    /**************scheduleAtFixedRate()**************/
	    /* ScheduledFuture<?> future2=executorService5.scheduleAtFixedRate(task2, 0, 1, TimeUnit.SECONDS);
	   
		
		 * Runnable taskRunnable = () -> System.out.println("Scheduling:2 " +
		 * System.nanoTime());
		 * 
		 * int initialDelay = 0; int period = 1;
		 * executorService5.scheduleAtFixedRate(taskRunnable, initialDelay, period,
		 * TimeUnit.SECONDS);
		 */
	    System.out.println("Schedule executor end");
	    
	    /**************scheduleWithFixedDelay**************/
	    executorService5.scheduleWithFixedDelay(task2, 0, 1, TimeUnit.SECONDS);
	    
	    
	    /*******************ShutDown***************/
	    System.out.println("attempt to shutdown executor");
	    executor.shutdown();
	   
	    if (!executor.isTerminated()) {
	    System.err.println("cancel non-finished tasks");
	   
	    executor.shutdownNow();
	    System.out.println("shutdown finished");
	    
	    
	    
	}
	
	}
}
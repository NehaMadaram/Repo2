package com.accenture.concurrency.synchronize;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class SynchDemo {
	int count=0;
 synchronized void incrementSync() {
	
	
     count = count + 1;
	
}
/**
 * 
 */
public void xy()
{
	
	ExecutorService executor = Executors.newFixedThreadPool(1);
	
	//IntStream.range(0, 10000).forEach(i -> executor.submit(this::incrementSync));
	for(int i=0;i<10000;i++)
	{
		executor.submit(this::incrementSync);
	}
	
	executor.shutdown();
	

	System.out.println(count); 
}
public static void main(String[] args) {
	SynchDemo demo=new SynchDemo();
	demo.xy();
}
}



















/*
 * import java.util.concurrent.ExecutorService; import
 * java.util.concurrent.Executors; import java.util.concurrent.TimeUnit; import
 * java.util.stream.IntStream;
 * 
 * public class SynchDemo {
 * 
 * int count = 0; int sum=0; void increment() { count = count + 1; }
 * ExecutorService executor = Executors.newFixedThreadPool(2);
 * 
 * public synchronized void synchronisedCalculate() { setSum(getSum() + 1); }
 * 
 * 
 * 
 * private void setSum(int i) { // TODO Auto-generated method stub this.sum=i; }
 * 
 * private int getSum() { // TODO Auto-generated method stub return 10; }
 * 
 * 
 * public static void main(String[] args) throws InterruptedException {
 * 
 * 
 * ExecutorService service = Executors.newFixedThreadPool(3);
 * BaeldungSynchronizedMethods summation = new BaeldungSynchronizedMethods();
 * 
 * IntStream.range(0, 1000).forEach(count ->
 * service.submit(summation::calculate)); service.awaitTermination(1000,
 * TimeUnit.MILLISECONDS); System.out.println(summation.getSum());
 * 
 * 
 * // assertEquals(1000, summation.getSum()); }
 * 
 * } class BaeldungSynchronizedMethods {
 * 
 * private int sum = 0;
 * 
 * public void calculate() { setSum(getSum() + 1); }
 * 
 * void setSum(int i) { // TODO Auto-generated method stub this.sum=i; }
 * 
 * int getSum() { // TODO Auto-generated method stub return 10; }
 * 
 * // standard setters and getters }
 */

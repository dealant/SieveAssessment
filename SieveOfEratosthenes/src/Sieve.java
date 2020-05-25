import java.util.*;

/**
 * @author Alan Tsui
 * This class collects all of the primes up to a certain number provided by the client code
 * It will also produce stats on the prime numbers collected 
 *
 */
public class Sieve {
	private Queue<Integer> candidates = new LinkedList<Integer>();
	private Queue<Integer> prime = new LinkedList<Integer>();
	private int max = 0;
	
	public Sieve() {
		clearQueue();
	}
	
	public void computeTo(int n) {
		clearQueue();
		max = n;
		//Create a queue and fill it with the consecutive integers 2 through n inclusive. 
		for(int i = 2; i<=n; i++) {
			candidates.add(i);
		}
		prime.add(2);
		int current = 2;
		do {
			int size = candidates.size();
			for(int i = 0; i<size; i++){
				if(candidates.peek()%current==0) {
					System.out.print(" c:" + candidates.peek());
					System.out.print(" current: "+current);
					candidates.remove();
				}else {
					candidates.add(candidates.poll());
				}
			}
			System.out.println();
			if(!prime.contains(current)) {
				prime.add(current);
			}
			current = candidates.poll();
			System.out.println(prime.toString());
			System.out.println(candidates.toString());
//		} while(candidates.peek()<7);
		} while(candidates.peek()<= Math.sqrt(n)+3);
		prime.addAll(candidates);
	/*
	Do
		Obtain the next prime p by removing the first value in the queue of numbers.
		Put p into the queue of primes.
		Go through the queue of numbers, eliminating numbers divisible by p. 
	while (p <= sqrt(n)).
	All remaining values in numbers queue are prime, so transfer them to primes queue.*/
				
	}
	
	public void reportResults() {
		System.out.println(prime.toString());
	}
	
	public int getMax() {
		//TODO set if max is 0 throw exception
		return max;
	}
	
	public int getCount() {
		return prime.size();
	}
	
	private void clearQueue() {
		candidates.clear();
		prime.clear();
	}
	
}

import java.util.*;

/**
 * @author Alan Tsui
 * This class collects all of the primes up to a certain number provided by the client code
 * It will also produce stats on the prime numbers collected 
 *
 */
public class Sieve {
	private Queue<Integer> candidates = new LinkedList<Integer>();
	//TODO Create an empty queue to store primes.
	private Queue<Integer> prime = new LinkedList<Integer>();
	
	public Sieve(int n) {
		candidates.clear();
		prime.clear();
	}
	
	public void computeTo(int n) {
		//TODO clear both queues
		//Create a queue and fill it with the consecutive integers 2 through n inclusive. 
		for(int i = 2; i<=n; i++) {
			candidates.add(i);
		}
	/*
	Do
		Obtain the next prime p by removing the first value in the queue of numbers.
		Put p into the queue of primes.
		Go through the queue of numbers, eliminating numbers divisible by p. 
	while (p <= sqrt(n)).
	All remaining values in numbers queue are prime, so transfer them to primes queue.*/
				
	}
	
	public void reportResults() {
		
	}
	
	public void getMax() {
		
	}
	
	public void getCount() {
		
	}
	
}

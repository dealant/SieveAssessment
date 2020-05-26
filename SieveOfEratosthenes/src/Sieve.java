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
		//ensure queues are cleared when the new class is started
		clearQueue();
	}
	
	public void computeTo(int n) {
		//clears the queue if the Sieve object computeTo method is called again
		clearQueue();
		max = n;
		//Create a queue and fill it with the consecutive integers 2 through n inclusive. 
		for(int i = 2; i<=n; i++) {
			candidates.add(i);
		}
		while(candidates.peek()<= Math.sqrt(n)) {
			//Obtain the next prime p by removing the first value in the queue of numbers
			int p = candidates.poll();
			int size = candidates.size();
			for(int i = 0; i<size; i++){
				//Go through the queue of numbers, eliminating numbers divisible by p. 
				if(candidates.peek()%p==0) {
					candidates.remove();
				}else {
					candidates.add(candidates.poll());
				}
			}
			//Put p into the queue of primes.
			prime.add(p);
		} 
		//All remaining values in numbers queue are prime, so transfer them to primes queue
		prime.addAll(candidates);	
	}
	
	public void reportResults() {
		if(prime.isEmpty() || candidates.isEmpty()) {
			throw new IllegalStateException("There has been no computeTo call to "
					+ "this object yet. No results to report");
		}
		try {
			Iterator<Integer> itr = prime.iterator();
			while(itr.hasNext()) {
				for(int i = 1; i<=12; i++) {
					System.out.print(itr.next()+" ");
				}
				System.out.println();
			}
		} catch(Exception e) {
			System.out.println();
		}
	}
	
	//returns the number the client code input to compueTo
	public int getMax() {
		//TODO set if max is 0 throw exception
		if(max == 0) {
			throw new IllegalStateException("There has been no call to this object yet, there is no max");
		}
		return max;
	}
	
	//returns the amount of primes compute to found
	public int getCount() {
		if(prime.isEmpty()) {
			throw new IllegalStateException("There has been no call to this object yet, there are no primes");
		}
		return prime.size();
	}
	
	//method to ensure the  Queues for this object are cleared for next call
	private void clearQueue() {
		candidates.clear();
		prime.clear();
	}
	
}

package language;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class chocolate_warehouse{
	private example_pojo wh;

	public chocolate_warehouse(){
		wh=new example_pojo();
		wh.int_field=50; // initial quantity
	}

	public synchronized boolean delivery_eat(int grams) {
		if (wh.int_field + grams < 0){
			return false;
		}
		wh.int_field+=grams;
		return true;
	}

	public int getQuantity() {
		return wh.int_field;
	}
}







class child_thread extends Thread {
	static Random rand = new Random();
	chocolate_warehouse m_cwh;

	public child_thread(chocolate_warehouse cwh) {
		m_cwh=cwh;
	}

	@Override
	public void run() {
		int quantity
		,	num_tries=0
		;
		try{
			while(true) {
				quantity=1+rand.nextInt(20); // avoid eating zero
				if(m_cwh.delivery_eat(-quantity)) {
					System.out.println("Child " + threadId() + ": (try "+num_tries+") Successfully ate `" + quantity + "`");
				} else {
					System.out.println("Child " + threadId() + ":  (try " + num_tries + ") Could not eat `" + quantity + "`");
				}
				if(10<num_tries){
					System.out.println("Child "+threadId()+": enough.");
					return;
				}
				if(10<num_tries++)
						return;
				Thread.sleep(Math.abs(300*quantity));
			}
		}catch(InterruptedException e){
			System.out.println("Child "+threadId()+": trouble");
			e.printStackTrace();
		}
	}
}







class delivery_truck extends Thread {
	static Random rand = new Random();
	chocolate_warehouse m_cwh;

	public delivery_truck(chocolate_warehouse cwh) {
		m_cwh=cwh;
	}

	@Override
	public void run() {
		int quantity
		,	times=0
		;
		try{
			while(true) {
				quantity=rand.nextInt(500);
				if(m_cwh.delivery_eat(quantity))
					System.out.println("Delivery truck "+threadId()+": Successfully delivered `"+quantity+"`");
				else
					System.out.println("Delivery truck "+threadId()+": `"+quantity+"` delivery was not successful");
				if(5<times++){
					System.out.println("Delivery truck "+threadId()+": Enough delivered.");
					return;
				}
				Thread.sleep(Math.abs(40*quantity));
			}
		}catch(InterruptedException e){
			System.out.println("Delivery truck "+threadId()+": trouble");
			e.printStackTrace();
		}
	}
}

public class synchronized_example {


		@Test
		public void main() {
			List<Thread> threads=new ArrayList<>();

			chocolate_warehouse cwh = new chocolate_warehouse();


			threads.add(new delivery_truck(cwh));
			threads.getLast().start();

			for(int i=0; i<20 ; i++) {
				threads.add(new child_thread(cwh));
				threads.getLast().start();
			}

			// Joining the threads to ensure main thread waits for them to finish
			try {
				threads.stream().forEach(e-> {
					try {
						e.join();
					} catch (InterruptedException ex) {
						throw new RuntimeException(ex);
					}
				});
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Displaying final balance
			System.out.println("Final quantity: " + cwh.getQuantity());
		}
}

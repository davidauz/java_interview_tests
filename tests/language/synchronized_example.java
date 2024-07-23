package language;

import org.junit.jupiter.api.Test;

import java.util.Random;

class chocolate_warehouse{
	private example_pojo wh;

	public chocolate_warehouse(){
		wh=new example_pojo();
		wh.int_field=0;
	}

	public synchronized boolean delivery_eat(int grams) {
		if (wh.int_field + grams < 0){
			System.out.println("Not enough chocolate! You want to eat `"+grams+"` but there is only `"+wh.int_field+"`!");
			return false;
		}
		wh.int_field+=grams;
		return true;
	}

	public int getQuantity() {
		return wh.int_field;
	}
}

class delivery_eat_thread extends Thread {
	static Random rand = new Random();
	chocolate_warehouse m_cwh;

	public delivery_eat_thread(chocolate_warehouse cwh) {
		m_cwh=cwh;
	}

	@Override
	public void run() {
		int quantity
				,	times=0
				;
		try{
			while(true) {
				quantity=rand.nextInt(100)-50;
				Thread.sleep(Math.abs(10*quantity));
				if(m_cwh.delivery_eat(quantity))
					System.out.println(threadId()+": Successful transaction `"+quantity+"`");
				else
					System.out.println(threadId()+": `"+quantity+"` was not successful");
				if(10<times++){
					System.out.println(threadId()+": Had enough.");
					return;
				}
			}
		}catch(InterruptedException e){
			System.out.println(threadId()+": trouble");
			e.printStackTrace();
		}
	}
}

public class synchronized_example {


		@Test
		public void main() {
			chocolate_warehouse cwh = new chocolate_warehouse();
			Thread t1 = new delivery_eat_thread(cwh);
			Thread t2 = new delivery_eat_thread(cwh);
			Thread t3 = new delivery_eat_thread(cwh);

			// Starting the threads
			t1.start();
			t2.start();
			t3.start();

			// Joining the threads to ensure main thread waits for them to finish
			try {
				t1.join();
				t2.join();
				t3.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// Displaying final balance
			System.out.println("Final quantity: " + cwh.getQuantity());
		}
}

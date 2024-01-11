package language.threads;

public class threads_class {
	public void demonstrate_virtual_threads(){
//Virtual threads do not sit on an OS thread.
//They still run on an OS thread but when there is a blocking I/O operation the Java runtime suspends
//the virtual thread until it can be resumed while the OS thread associated with the suspended virtual
//thread is free to perform operations for other virtual threads.
		Thread virtualThread = Thread.ofVirtual().start(() -> { // here 'runnable' is a lambda
			for (int i = 0; i < 5; i++) {
				System.out.println("Virtual Thread counter: " + i);
				try {
					Thread.sleep(500); // Simulate some work
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		for (int i = 0; i < 5; i++) {
			System.out.println("Main Thread: " + i);
			try {
				Thread.sleep(1000); // Simulate some work
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		try {
			virtualThread.join();//main thread waits for the virtual thread to complete before exiting
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Main Thread exiting.");
	}

	public void demonstrate_platform_threads(){
//platform thread use underlying OS threads
		Thread platform_thread = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("Platform Thread counter: " + i);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		platform_thread.start();

		for (int i = 0; i < 5; i++) {
			System.out.println("Main Thread: " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		try {
			platform_thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Main Thread exiting.");
	}
}

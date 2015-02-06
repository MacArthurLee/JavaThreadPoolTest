import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class ThreadPoolTest {
	
	public static void main(String[] arsg) {
		new ThreadPoolTest().cachedThreadTest();
	}
	
	public void cachedThreadTest() {
		ExecutorService pool = Executors.newCachedThreadPool();
        RunnaleTest r1 = new RunnaleTest();
		RunnaleTest r2 = new RunnaleTest();
		RunnaleTest r3 = new RunnaleTest();
		RunnaleTest r4 = new RunnaleTest();
		RunnaleTest r5 = new RunnaleTest();
		pool.execute(r1);
		pool.execute(r2);
		pool.execute(r3);
		pool.execute(r4);
		pool.execute(r5);
		pool.execute(r1);
		pool.execute(r2);
		pool.execute(r3);
		pool.execute(r4);
		pool.execute(r5);
		pool.execute(r1);
		pool.execute(r2);
		pool.execute(r3);
		pool.execute(r4);
		pool.execute(r5);
		pool.shutdown();
	}
	
	/**
	 * ����ָ���߳������̳߳أ��̳߳��е��߳�1���߳�2���ִ������r1-r5
	 */
	public void fixedThreadTest() {
		ExecutorService pool = Executors.newFixedThreadPool(2);
		RunnaleTest r1 = new RunnaleTest();
		RunnaleTest r2 = new RunnaleTest();
		RunnaleTest r3 = new RunnaleTest();
		RunnaleTest r4 = new RunnaleTest();
		RunnaleTest r5 = new RunnaleTest();
		pool.execute(r1);
		pool.execute(r2);
		pool.execute(r3);
		pool.execute(r4);
		pool.execute(r5);
		pool.shutdown();
	}
	
	/**
	 * ���̵߳��̳߳أ��̳߳���ֻ��һ���߳���ִ��
	 * pool�е��̰߳�˳��ִ������r1��r5
	 */
	public void singleThreadTest() {
		ExecutorService pool = Executors.newSingleThreadExecutor();
		RunnaleTest r1 = new RunnaleTest();
		RunnaleTest r2 = new RunnaleTest();
		RunnaleTest r3 = new RunnaleTest();
		RunnaleTest r4 = new RunnaleTest();
		RunnaleTest r5 = new RunnaleTest();
		pool.execute(r1);
		pool.execute(r2);
		pool.execute(r3);
		pool.execute(r4);
		pool.execute(r5);
		
		pool.shutdown();
	}

	class RunnaleTest implements Runnable {
		public void run() {
			System.out.println(Thread.currentThread().getName() + " is running!");
		}
	}
}
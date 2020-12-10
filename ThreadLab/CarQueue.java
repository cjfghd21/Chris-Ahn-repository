import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

public class CarQueue {
	Queue<Integer> queue;
	Random direction;
	private int out;
	
	public CarQueue()
	{
		queue = new ArrayDeque<Integer>();
		direction = new Random();
		
		queue.add(direction.nextInt(4));
		queue.add(direction.nextInt(4));
		queue.add(direction.nextInt(4));
		queue.add(direction.nextInt(4));
		queue.add(direction.nextInt(4));
		queue.add(direction.nextInt(4));
		queue.add(direction.nextInt(4));
		queue.add(direction.nextInt(4));
		queue.add(direction.nextInt(4));
		queue.add(direction.nextInt(4));
		queue.add(direction.nextInt(4));
		queue.add(direction.nextInt(4));
	

	
	}
	
	
	public void addToQueue()
	{
		class carQueueRunnable implements Runnable{

			@Override
			public void run() {
				try 
				{	
					while(true)
					{	
						queue.add(direction.nextInt(4));
						Thread.sleep(200);
					}
				}
				catch(InterruptedException exception)
				{	
					
				}
				finally
				{
					
				}
			}
		}
		Runnable r = new carQueueRunnable();
		Thread t = new Thread(r);
		t.start();
	}
	
	public Integer deleteQueue()
	{	
		return queue.remove();
	}
	
	
}

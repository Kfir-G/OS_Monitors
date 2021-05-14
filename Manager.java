import java.util.*;
public class Manager{

	private static final int MAX_ENT = 5;
	private Entity[] entities;
	private Dispatcher dispatcher;
    private Thread dispatcherThread;
    private static Random rand;

    public Manager() {
        rand = new Random();
        dispatcher = new Dispatcher(MAX_ENT);
        entities = new Entity[MAX_ENT];
        for (int i = 0; i < MAX_ENT; i++) {
            entities[i] = new Entity(i, dispatcher, MAX_ENT);
        }
        for (int i = 0; i < MAX_ENT; i++) {
            entities[i].start();
        }

        dispatcherThread = new Thread(dispatcher);
        dispatcherThread.start();

        
    }
    public static void sleepFunc(int sleepTime)
	{
			int sleep = rand.nextInt(sleepTime) + 1;
			try {
					Thread.sleep(sleep);
			} catch (InterruptedException e) {
					e.printStackTrace();
			}
	}
    public static void main(String[] args){
        Manager manager = new Manager();
    }
    
}
import java.util.*;

public class Dispatcher extends MsgQueue implements Runnable {
 private static final int MAX_SLEEP = 500;
 private int numEntities; 
 private MsgQueue[] entityQueue;
 private Random rand;

 public Dispatcher(int numEntities){
    this.numEntities = numEntities;
    entityQueue = new MsgQueue[numEntities];
    rand = new Random();

 }


@Override
public void run() {
    //Variables you may need
	while(true)
	{
        MSG message;
        message = dequeueMsg();
			
		//2)
        if(message == null)
        {
            System.out.print("message is null");
        }
        if((message.getDestID() >= 0 && message.getDestID() <= numEntities-1))
        {
            entityQueue[message.getDestID()].enqueueMsg(message);
            Manager.sleepFunc(MAX_SLEEP);

        }

	}
}

    


public void register(MsgQueue q, int entityID){
        if((entityID >= 0) && (entityID <= numEntities-1) && (entityQueue[entityID] == null))
        {
            entityQueue[entityID]= q ;
            System.out.println("register id:" + entityID);

        }
}

}

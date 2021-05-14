public class MsgQueue implements MSGQInterface{
    
    private static final int QSIZE = 500;	

	private MSG[] queue; //The simple Array implementing the queue
	
	private int head; //index pointing to the head of queue
	
	private int tail; //index pointing to the tail of queue




    public MsgQueue() {
        this.queue = new MSG[QSIZE];
        this.head = 0; //out
        this.tail = 0; //in 
    }



	public synchronized void enqueueMsg(MSG message)
    {
        if(message == null)
        {
            return;
        }
        while(queueIsFull()){
             try {
                System.out.println("queue is full");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        queue[tail] = message;
        tail =  (tail + 1) % QSIZE;
        notifyAll();
    }
	
    public synchronized MSG dequeueMsg(){
        
        while(queueIsEmpty()){
             try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        MSG dequeuedMsg;
        dequeuedMsg = queue[head];
        head =  (head + 1) % QSIZE;
        notifyAll();
        return dequeuedMsg;
    }
	
    public boolean queueIsEmpty(){
        if(head==tail)
        {
            return true;
        }
        return false;
    }
	
    public boolean queueIsFull(){
      if((tail + 1) % QSIZE == head) 
      {
          return true;
      }
      return false;
    }
}

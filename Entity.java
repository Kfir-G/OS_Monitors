public class Entity extends Thread{
	private static final int MAX_SLEEP = 500;
	private int ID;
	private int numEntities;
	private MsgQueue queue;
	private Dispatcher dispatcher;

    public Entity(int ID,  Dispatcher dispatcher, int numEntities) {
        // this.rand = new Random();
        this.ID = ID;
        this.dispatcher = dispatcher;
        this.numEntities = numEntities;
        queue = new MsgQueue();
        dispatcher.register(queue, ID);
    }

    public void run()
	{
        int sendTo = 0;
        String message;
        MSG entityMsg;

		while(true)
		{
            if(sendTo == ID){
                sendTo = (sendTo + 1) % numEntities;
            }
            message = "MSG from "  + ID;
            MSG msg = new MSG(message, sendTo);
            dispatcher.enqueueMsg(msg);
            sendTo = (sendTo + 1) % numEntities;


			//2)
            entityMsg = queue.dequeueMsg();
            if(entityMsg.getDestID() == ID){
                System.out.println("ID: "+ ID+" "+ entityMsg.getBody());
            }
            else if(entityMsg.getBody() == null)
            {
                System.out.println(ID+":entity Msg is null");

            }
            else if(entityMsg.getDestID() != ID)
            {
                System.out.println(ID+":Msg can`t send Msg to itself");
            }   
            else{
                System.out.println("ID: "+ ID+" "+ entityMsg.getBody());

            }         
             Manager.sleepFunc(MAX_SLEEP);

		  
		}
	}
 
}

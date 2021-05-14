public interface MSGQInterface
{

	void enqueueMsg(MSG message);

	MSG dequeueMsg();	

	boolean queueIsEmpty();

	boolean queueIsFull();
}

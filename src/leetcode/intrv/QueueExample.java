package leetcode.intrv;
class Queue {
    
    private int[] queueAr;
    private int size; //Size of Queue
    
    private int rear; //elements will be added at rear.
    private int front;   //elements will be removed from front
    private int number;  //holds number of elements in Queue, initialized with 0 by default
 
    /**
     * Constructor
     */
    public Queue(int size) {
           this.size = size;
           queueAr = new int[this.size];         
           rear = 0;
           front = 0;
    }
 
    /**
     * Insert element at rear in Queue
     * @throws Exception 
     */
    public void insert(int value) throws Exception{
           
           if(isFull()){
                  throw new Exception("Cannot insert "+value+", Queue is full");
           }          
           if (rear == size ) // means we are at last position (deal with wrapAround)
                  rear = 0;
           queueAr[rear++] = value; // Insert element and increment rear
           number++; //increase number of elements in Queue
    }
 
    
    /**
     * Removes elements from front of Queue 
     * @throws Exception 
     */
    public int remove() throws Exception{
           if(isEmpty()){
                  throw new Exception("Queue is empty");
           }
           
           int deletedValue = queueAr[front++]; // get value at front and than increment front
           if (front == size) // deal with wrapAround
                  front = 0;
           number--; //reduce number of elements in Queue
           return deletedValue;
    }
 
    /**
     * @return true if Queue is empty
     */
    public boolean isEmpty() {
           return (number == 0);
    }
    
    /**
     * @return true if Queue is full
     */
    public boolean isFull() {
           return (number == size);
    }
    
}
 
 
/**
 * QueueExample - Main class
 */
public class QueueExample {
    public static void main(String[] args) throws Exception {
           Queue queue = new Queue(3); // queue holds 10 elements
           
           queue.insert(31);
           queue.insert(49);
           queue.insert(56);
           queue.insert(23);
           /*queue.remove();
           queue.remove();
 
           queue.insert(90);
           queue.insert(81);
           queue.insert(72);
           queue.insert(22); // At this point we got to deal with wrapAround, because rear must be pointing to last position.
           
           System.out.print("Deleted elements from queue: ");
           System.out.print(queue.remove()+ " ");
           System.out.print(queue.remove()+ " ");
           System.out.print(queue.remove()+ " ");
           System.out.print(queue.remove()+ " ");*/
           
    }
}
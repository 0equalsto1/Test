package pack2;
public class ThreadsInJava
{
    public static void main(String[] args)
    {
        Thread t = new Thread()
        {
            @Override
						public void run()
            {
                try
                {
                    Thread.sleep(10000);        //Thread is sleeping for 10 seconds
                    
                }
                catch (InterruptedException e)
                {
                    System.out.println("Thread is interrupted");
                }
                System.out.println("after interruption.....");
            }
        };
 
        t.start();
 
        try
        {
            Thread.sleep(3000);      //Main thread is sleeping for 3 seconds
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
 
        t.interrupt();         //main thread is interrupting thread t
    }
}
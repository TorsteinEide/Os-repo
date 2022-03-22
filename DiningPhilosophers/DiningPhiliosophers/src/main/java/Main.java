
public class Main extends Thread
{

    public void run()
    {
        try {
            System.out.println("Thread: " + Thread.currentThread().getId() + " is now running");
        } catch (Exception e)
        {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        for(int i=0; i< 8; i++)
        {
            Main main = new Main();
            main.start();
        }
    }



}

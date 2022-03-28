
public class Main extends Thread
{
    public static void main(String[] args) {
        Philosophers philosophers = new Philosophers();

        int i=0;
        for(Philosopher philosopher:philosophers.getPhilosophers()){
            Thread thread = new DiningTable(philosopher);
            System.out.println("Thread: " + i + " running");
            thread.start();
            i++;
        }




    }


}

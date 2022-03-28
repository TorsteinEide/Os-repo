//imports


import java.util.Random;

/**
 * This class represents the dining philosophers problem
 */
public class DiningTable extends Thread
{
    //fields --------------------------------------------------
    private static final Philosophers philosophers = new Philosophers();
    private Philosopher philosopher;

    /**
     * constructor
     */
    public DiningTable(Philosopher philosopher)
    {
        this.philosopher = philosopher;
    }

    /**
     * runs the "sim"
     */
    public void run()
    {
        //TODO: Add monitoring (wait(), notify())
        //This code is running inside a thread
        boolean run=true;
        while(run) {
            synchronized (this){
            try {
                // think for a while
                int thinktimer = randomSleepTimer();
                System.out.println("philosopher: " + philosopher.getPhilosopherNumber() + " thinking for: " + thinktimer + "s");
                sleep(thinktimer);
                philosopher.setState(Philosopher.State.THINKING);
                //check chopstick availability
                if (checkChopsticks(philosopher)) {
                    System.out.println("philosopher: " + philosopher.getPhilosopherNumber() + " chopsticks available");
                    //pick up chopsticks (wait?)
                    chopStickAction(philosopher);
                    System.out.println("Philosopher: " + philosopher.getPhilosopherNumber() + " picking up chopsticks");
                    //eat for a while
                    philosopher.setState(Philosopher.State.EATING);
                    int i = randomSleepTimer();
                    System.out.println("philosopher: " + philosopher.getPhilosopherNumber() + " Eating for: " + i + "s");
                    sleep(i);
                    //signal putting chopsticks back (notify?)
                    chopStickAction(philosopher);
                    System.out.println("philosopher: " + philosopher.getPhilosopherNumber() + " putting back chopsticks");
                    this.notify();
                } else if (!checkChopsticks(philosopher)) {
                    philosopher.setState(Philosopher.State.HUNGRY);
                    System.out.println("Philosopher: " + philosopher.getPhilosopherNumber() + " is hungry and waiting for chopsticks");
                    //Wait until chopsticks are ready
                    this.wait();
                    System.out.println("philosopher: " + philosopher.getPhilosopherNumber() + " chopsticks not available");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        }
    }

    /**
     * checks if both chopsticks are available
     * returns a boolean value true if chopsticks are available, false if not
     * @return a boolean value true if chopsticks are available, false if not
     */
    private boolean checkChopsticks(Philosopher philosopher)
    {
        boolean available = false;
        Philosopher p1 = philosophers.getPhilosopher((philosopher.getPhilosopherNumber() + 4) % 5);
        Philosopher p2 = philosophers.getPhilosopher((philosopher.getPhilosopherNumber() + 1) % 5);

        if(p1.getLeftChopstickStatus() && p1.getRightChopstickStatus())
        {
            if(p2.getLeftChopstickStatus() && p2.getRightChopstickStatus())
            {
                available=true;
            }
        }
        return available;
    }

    private void chopStickAction(Philosopher philosopher)
    {
        if(checkChopsticks(philosopher))
        {
            philosopher.setLeftChopstick(false);
            philosopher.setRightChopstick(false);
        } else {
            philosopher.setLeftChopstick(true);
            philosopher.setRightChopstick(true);
        }
    }

    private boolean checkChopsticksByPhilosopher()
    {
        boolean available = false;
        Philosopher leftPhilosopher = philosophers.getPhilosopher((philosopher.getPhilosopherNumber() + 4) % 5);
        Philosopher rightPhilosopher =  philosophers.getPhilosopher((philosopher.getPhilosopherNumber() + 4) % 5);

        if(leftPhilosopher.getState().equals(Philosopher.State.THINKING) && rightPhilosopher.getState().equals(Philosopher.State.THINKING))
        {
            available=true;
        }

        return available;
    }

    /**
     * creates a random number which is to be used as a timer for eating, waiting etc.
     * returns a random number between 0-20 * 1000
     * @return a random number between 0-20 * 1000
     */
    public int randomSleepTimer()
    {
        Random random = new Random();
        return random.nextInt(10) * 1000;
    }

    public static void main(String[] args) {
        Philosopher p = philosophers.getPhilosopher(0);
        Philosopher p2 = philosophers.getPhilosopher(1);
        p2.setState(Philosopher.State.EATING);
        DiningTable dt = new DiningTable(p);
        boolean shit = dt.checkChopsticksByPhilosopher();
        System.out.println(shit);
    }


    public void run1()
    {
        try{
            while(true)
            {

            }
        }catch(Exception e){
            System.out.println("Error while running: " + e.getMessage());
        }
    }
}



































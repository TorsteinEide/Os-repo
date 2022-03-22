//imports


import java.util.Random;

/**
 * This class represents the dining philosophers problem
 */
public class DiningTable extends Thread
{
    //fields --------------------------------------------------
    Philosophers philosophers = new Philosophers();

    /**
     * constructor
     */
    public DiningTable()
    {
    }

    /**
     * runs the "sim"
     */
    public void run(Philosopher philosopher)
    {
        //This code is running inside a thread
        boolean run=true;
        while(run) {
            try {
                //check chopstick availability
                if (checkChopsticks(philosopher)){
                    System.out.println("chopsticks available");
                    //pick up chopsticks (wait?)
                    System.out.println("Picking up chopsticks");
                    chopstickAction(philosopher);
                    //eat for a while
                    philosopher.setState(Philosopher.State.EATING);
                    int i = randomSleepTimer();
                    System.out.println("Eating for: " + i + "s");
                    sleep(i);
                    //signal putting chopsticks back (notify?)
                    chopstickAction(philosopher);
                } else if (!checkChopsticks(philosopher)){
                    philosopher.setState(Philosopher.State.HUNGRY);
                    //Wait until chopsticks are ready
                    while(!checkChopsticks(philosopher))
                    {

                    }
                    System.out.println("chopsticks not available");
                }
                // think for a while
                int thinktimer=randomSleepTimer();
                System.out.println("thinking for: " + thinktimer + "s");
                sleep(thinktimer);
            } catch (Exception e)
            {
                System.out.println(e.getMessage());
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
        if(philosopher.getLeftChopstickStatus() && philosopher.getRightChopstickStatus())
        {
            available=true;
        }
        return available;
    }

    /**
     * sets the availability of each chopstick to false
     * @param philosopher philosopher who picks up chopsticks
     */
    public void chopstickAction(Philosopher philosopher)
    {
        if (checkChopsticks(philosopher))
        {
            philosopher.setLeftChopstick(false);
            philosopher.setRightChopstick(false);
        } else {
            philosopher.setLeftChopstick(true);
            philosopher.setRightChopstick(true);
        }
    }


    /**
     * creates a random number which is to be used as a timer for eating, waiting etc.
     * returns a random number between 0-20 * 1000
     * @return a random number between 0-20 * 1000
     */
    public int randomSleepTimer()
    {
        Random random = new Random();
        return random.nextInt(5) * 1000;
    }

    public static void main(String[] args) {
        DiningTable d = new DiningTable();
        Philosophers philosophers = new Philosophers();
        d.run(philosophers.getPhilosopher(1));

    }


}


































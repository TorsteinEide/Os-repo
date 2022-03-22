//imports


import static sun.nio.ch.NativeThread.signal;

/**
 * This class represents the dining philosophers problem
 */
public class DiningPhilosophers
{
    //fields --------------------------------------------------
    /**
     * constructor
     */
    public DiningPhilosophers()
    {
    }

    /**
     * runs the "sim"
     */
    private void run(Philosopher philosopher)
    {
        boolean run=true;
        while(run) {
            try {
                //pick up chopsticks
                this.checkChopsticks(philosopher);
                wait(chopstick[i]);
                wait(chopstick[(i+1) % 5]); //finds the next available chopstick
                philosopher.setState(Philosopher.State.EATING);
                //eat for a while

                //signal putting chopsticks back
                signal(chopstick[i]);
                signal(chopstick[(i+1) % 5]);
                philosopher.setState(Philosopher.State.THINKING);
                // think for a while
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
}



































//imports


/**
 * This class represents the dining philosophers problem
 */
public class DiningPhilosophers
{
    //fields --------------------------------------------------
    //philosopher states
    enum State {
        THINKING,
        HUNGRY,
        EATING
    }

    boolean available=true;
    int[] p = {1,2,3,4,5};
    int[] chopstick = {1,2,3,4,5};
    Chopsticks chopsticks = new Chopsticks();

    /**
     * constructor
     */
    public DiningPhilosophers()
    {
        Philosopher one = new Philosopher(p[0]);
        Philosopher two = new Philosopher(p[1]);
        Philosopher three = new Philosopher(p[2]);
        Philosopher four = new Philosopher(p[3]);
        Philosopher five = new Philosopher(p[4]);

        Chopstick firstChopstick = new Chopstick(chopstick[1]);
        Chopstick secondChopstick = new Chopstick(chopstick[2]);
        Chopstick thirdChopstick = new Chopstick(chopstick[3]);
        Chopstick fourthChopstick = new Chopstick(chopstick[4]);
        Chopstick fifthChopstick = new Chopstick(chopstick[5]);
    }

    /**
     * runs the "sim"
     */
    private void run(Philosopher philosopher)
    {
        boolean run=true;
        while(run)
        {
            //pick up chopsticks
            checkChopsticks();
            wait(chopstick[i]);
            wait(chopstick[(i+1) % 5]); //finds the next available chopstick
            philosopher.setState(Philosopher.State.EATING);
            //eat for a while

            //signal putting chopsticks back
            notify(chopstick[i]);
            notify(chopstick[(i+1) % 5]);
            philosopher.setState(Philosopher.State.THINKING);
            // think for a while
        }
    }

    /**
     * checks if both chopsticks are available
     * returns a boolean value true if chopsticks are available, false if not
     * @return a boolean value true if chopsticks are available, false if not
     */
    private boolean checkChopsticks(int chopstick)
    {
        boolean available = false;
        if(chopsticks.getChopstick(chopstick+1).getAvailable() == true && chopsticks.getChopstick((chopstick+1) % 5).getAvailable() == true)
        {
            available=true;
        }
        return available;
    }
}



































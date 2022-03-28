import java.util.Random;

public class Philosopher extends Thread {

    private int id;
    private boolean leftStick;
    private boolean rightStick;
    private State currentState;
    private Chopstick[] chopsticks;

    enum State {
        THINKING,
        HUNGRY,
        EATING
    }

    public Philosopher(int id, Chopstick[] chopsticks) {
        this.id = id;
        this.leftStick = false;
        this.rightStick = false;
        this.currentState = State.THINKING;
        this.chopsticks = chopsticks;
    }

    public State getCurrentState() {
        return this.currentState;
    }

    @Override
    public void run() {
        int UPPER_SLEEP_BOUND = 5;
        System.out.println("Philosopher " + this.id + ": Started thread");
        //Run forever
        while(true){
            try{
                Chopstick cs1 = this.chopsticks[(this.id) % 5];
                Chopstick cs2 = this.chopsticks[(this.id + 1) % 5];
                //think for random seconds
                sleep(getRandomSleepTime(UPPER_SLEEP_BOUND), "thought");
                //get hungy
                this.currentState = State.HUNGRY;
                //check if sticks are available
                if(!cs1.isAvailable() || !cs2.isAvailable())
                {
                    // if no wait and be hungy
                    System.out.println("Philosopher " + this.id + ": is waiting for chopsticks");
                    synchronized (this){this.wait();}
                    System.out.println("Philosopher " + this.id + ": is done waiting for chopsticks");
                }
                // eat for random seconds
                System.out.println("Philosopher " + this.id + ": is now eating");
                this.currentState = State.EATING;
                cs1.toggleAvailability();
                cs2.toggleAvailability();
                sleep(getRandomSleepTime(UPPER_SLEEP_BOUND), "ate");
                // put down when finished
                System.out.println("Philosopher " + this.id + ": Put down chopsticks ");
                this.currentState = State.THINKING;
                cs1.toggleAvailability();
                cs2.toggleAvailability();
                synchronized (this){this.notify();}
        } catch (Exception e ){
                System.out.printf("error "+e.getMessage());
            }
        }
    }

    public void cum(){int UPPER_SLEEP_BOUND = 5;

        System.out.println("Philosopher " + this.id + ": Started thread");
        while (true) {
            synchronized (this) {
                try {
                    // Simulate the philosopher to think for a random amount of seconds
                    int sleepTime = this.getRandomSleepTime(UPPER_SLEEP_BOUND);
                    this.sleep(sleepTime, "thought");
                    // The philosopher is now hungry
                    this.currentState = State.HUNGRY;
                    // He needs to wait for the chopsticks to be available
                    Chopstick cs1 = this.chopsticks[(this.id) % 5];
                    Chopstick cs2 = this.chopsticks[(this.id + 1) % 5];
                    if(!cs1.isAvailable() || !cs2.isAvailable())
                    {
                        System.out.println("Philosopher " + this.id + ": is waiting for chopsticks");
                        synchronized (this) {
                            this.wait();
                        }
                        System.out.println("Philosopher " + this.id + ": is done waiting for chopsticks");
                    }
                    // Philosopher is now eating
                    System.out.println("Philosopher " + this.id + ": is now eating");
                    this.currentState = State.EATING;
                    cs1.toggleAvailability();
                    cs2.toggleAvailability();
                    // The philosopher eats for a random amount of seconds
                    int eatTime = this.getRandomSleepTime(UPPER_SLEEP_BOUND);
                    this.sleep(eatTime, "ate");
                    // He puts down his chopsticks so others can use them
                    System.out.println("Philosopher " + this.id + ": Put down chopsticks ");
                    // The philosopher is now done eating and back to thinking
                    cs1.toggleAvailability();
                    cs2.toggleAvailability();
                    synchronized (this) {
                        this.notifyAll();
                    }
                    this.currentState = State.THINKING;
                } catch (Exception e) {
                    System.out.println("Philosopher " + this.id + ": " + e.getMessage());
                }
            }
        }}

    private void sleep(int time, String act) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            System.out.println("Philosopher " + this.id + ": Could not sleep");
        }
        System.out.println("Philosopher " + this.id + ": "+ act +" for " + time + " milliseconds");
    }

    /**
     * Returns a random sleep time in seconds as milliseconds.
     * The number is generated from 0 and the upperbound given as param
     *
     * @param upperbound the max seconds for the sleep timer
     * @return a value for seconds to sleep in milliseconds. (Eg: 1 seconds
     * will be returned as 1000)
     */
    private int getRandomSleepTime(int upperbound) {
        Random rand = new Random();
        int random = rand.nextInt(upperbound);
        return random * 1000;
    }
}

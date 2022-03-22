/**
 * This class represents a philosopher
 */
public class Philosopher
{
    enum State {
        THINKING,
        HUNGRY,
        EATING
    }

    private State state;
    private boolean leftChopstick;
    private boolean rightChopstick;
    private int p;

    /**
     * constructor initializes an object of class philosopher
     * @param philosopher the number of a philosopher
     */
    public Philosopher(int philosopher)
    {
        this.leftChopstick=true;
        this.rightChopstick=true;
        this.state = State.THINKING;
        this.p=philosopher;
    }

    /**
     * sets the state of a philosopher
     * @param state
     * @return
     */
    public void setState(State state)
    {
        this.state = state;
    }

    /**
     * returns the state of a philosopher
     * @return the state of a philosopher
     */
    public State getState()
    {
        return this.state;
    }

    /**
     * returns the number of a philosopher
     * @return the number of a philosopher
     */
    public int getPhilosopherNumber()
    {
        return this.p;
    }

    public boolean getLeftChopstickStatus()
    {
        return this.leftChopstick;
    }


    public boolean getRightChopstickStatus()
    {
        return this.rightChopstick;
    }

}































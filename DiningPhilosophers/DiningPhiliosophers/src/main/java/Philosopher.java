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

    State state;

    int p;

    /**
     * constructor initializes an object of class philosopher
     * @param philosopher the number of a philosopher
     */
    public Philosopher(int philosopher)
    {
        this.state = State.THINKING;
        this.p=philosopher;
    }

    /**
     * sets the state of a philosopher
     * @param state
     * @return
     */
    public State setState(State state)
    {
        this.state = state;
        return state;
    }
}































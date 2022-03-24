/**
 * This class represents all the philosophers dining around the table
 */
public class Philosophers
{

    /**
     * constructor initializes an object of class Philosophers
     */
    public Philosophers()
    {
        initializePhilosophers();
    }

    /**
     * initializes all philosophers around the table
     */
    public Philosopher[] initializePhilosophers()
    {
        Philosopher first = new Philosopher(0);
        Philosopher second = new Philosopher(1);
        Philosopher third = new Philosopher(2);
        Philosopher fourth = new Philosopher(3);
        Philosopher fifth = new Philosopher(4);

        Philosopher[] philosophers = {first, second, third, fourth, fifth};
        return philosophers;
    }

    /**
     * finds a philosopher with a given parameter i
     * @param i number of the philosopher to be found
     * @return returns a philosopher at a given number (i)
     */
    public Philosopher getPhilosopher(int i)
    {
        return initializePhilosophers()[i];
    }



}

public class Chopsticks {

    Chopstick[] chopsticks = {};

    public Chopsticks()
    {
        init();

    }

    /**
     * inits the chopsticks
     */
    public void init()
    {
        Chopstick firstChopstick = new Chopstick(0);
        Chopstick secondChopstick = new Chopstick(1);
        Chopstick thirdChopstick = new Chopstick(2);
        Chopstick fourthChopstick = new Chopstick(3);
        Chopstick fifthChopstick = new Chopstick(4);

        Chopstick[] chopsticks = {firstChopstick = new Chopstick(0), secondChopstick = new Chopstick(1),
                thirdChopstick = new Chopstick(2), fourthChopstick = new Chopstick(3), fifthChopstick = new Chopstick(4)};
    }

    public Chopstick getChopstick(int i)
    {
        return chopsticks[i];
    }
















}

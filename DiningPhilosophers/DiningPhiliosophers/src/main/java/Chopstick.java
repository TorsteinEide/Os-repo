public class Chopstick {


    boolean available;
    int chopstick;


    /**
     * constructor initializes an object of class chopstick
     * @param chopstick the number of the chopstick
     */
    public Chopstick(int chopstick)
    {
        this.available=true;
        this.chopstick=chopstick;
    }

    /**
     * Sets the available boolean value of the chopstick
     * @param available new boolean value
     */
    public void setAvailable(boolean available)
    {
        this.available=available;
    }

    /**
     * returns the availablitity of a chopstick
     * @return the availablitity of a chopstick
     */
    public boolean getAvailable()
    {
        return this.available;
    }
}

























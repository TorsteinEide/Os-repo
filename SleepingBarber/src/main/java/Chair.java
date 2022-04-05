/**
 * This class represents a chair in the barbershop
 */
public class Chair
{
    //fields
    private boolean available;

    /**
     * Constructor initializes an object of class Chair
     */
    public Chair()
    {
        this.available=true;
    }

    /**
     * toggles the availability of the chair
     */
    public void toggleAvailability()
    {
        this.available=!available;
    }

    /**
     * returns the availability status of the chair
     * @return the availability status of the chair
     */
    public boolean isAvailable()
    {
        return this.available;
    }
}

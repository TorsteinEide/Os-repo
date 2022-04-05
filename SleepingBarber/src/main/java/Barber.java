/**
 * This class represents the barber in the sleeping barber problem
 */
public class Barber
{
    //fields
    private boolean available;

    /**
     * Constructor initializes an object of class Barber
     */
    public Barber()
    {
        this.available=true;
    }

    /**
     * Toggles the working status of the barber
     */
    public synchronized void toggleWorking()
    {
        this.available=!this.available;
    }

    /**
     * returns the working status of the barber
     * @return the working status of the barber
     */
    public boolean getWorkingStatus()
    {
        return this.available;
    }

    public boolean isBarberAvailable(){
        boolean available=false;
        if(getWorkingStatus()){available=true;}
        return available;
    }

}

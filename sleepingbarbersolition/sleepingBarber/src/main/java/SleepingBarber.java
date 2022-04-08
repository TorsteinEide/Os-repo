/**
 * This class represents the main class in which the logic behind the sleeping barber solution runs
 */
public class SleepingBarber {
    public static void main(String[] args) {
        // create objects
        BarberShop barberShop = new BarberShop();
        CustomerGenerator cg = new CustomerGenerator(barberShop);
        Barber barber = new Barber(barberShop);
        // create threads
        Thread costumerGeneratorThread = new Thread(cg);
        Thread barberThread = new Thread(barber);
        // start threads
        costumerGeneratorThread.start();
        barberThread.start();
    }
}

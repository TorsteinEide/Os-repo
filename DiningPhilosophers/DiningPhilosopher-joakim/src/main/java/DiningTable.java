import java.util.ArrayList;

/**
 * Represents the table where all the philosophers are sitting.
 * They are either thinking, hungry or eating.
 */
public class DiningTable {
    private Chopstick[] chopsticks;
    private ArrayList<Thread> philosophers;

    public void initialize() {
        this.philosophers = new ArrayList<>();
        this.chopsticks = new Chopstick[]{new Chopstick(0), new Chopstick(1), new Chopstick(2), new Chopstick(3), new Chopstick(4)};
    }

    public void runSimulation() {
        for (int i = 0; i < 5; i++) {
            Thread philosopher = new Philosopher(i, this.chopsticks);
            this.philosophers.add(philosopher);
            philosopher.start();
        }
    }

    public static void main(String[] args) {
        DiningTable diningTable = new DiningTable();
        diningTable.initialize();
        diningTable.runSimulation();
    }
}

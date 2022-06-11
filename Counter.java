/**
 * The type Counter.
 * @author Daniel Levy ID:208150433
 */
public class Counter {
    private int count;

    /**
     * Instantiates a new Counter.
     *
     * @param number the number
     */
    public Counter(int number) {
        this.count = number;
    }

    /**
     * Increase.
     * add number to current count.
     * @param number the number to add
     */
    void increase(int number) {
        this.count = this.count + number;
    }

    /**
     * Decrease.
     *subtract number from current count
     * @param number the number to subtract
     */
    void decrease(int number) {
        this.count = this.count - number;
    }

    /**
     * Gets value.
     * get current count.
     * @return the value
     */
    int getValue() {
        return this.count;
    }
}

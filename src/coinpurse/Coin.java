package coinpurse;

/**
 * Coin represents coinage (money) with a fixed value and currency.
 * @author Pornpavee Seri-umnuoy
 */
public class Coin implements Comparable<Coin>, Valuable{

    private final double value;
    private final String CURRENCY;

    /**
     *  Initialize a new coin.
     * @param value is the value of this coin.
     * @param CURRENCY is the coin's currency.
     */
    public  Coin(double value,String CURRENCY){
        if(value < 0) value = 0;
        this.value = value;
        this.CURRENCY = CURRENCY;
    }

    /**
     * @return the value of this coin.
     */
    public double getValue() {
        return value;
    }

    /**
     * @return the currency of this coin.
     */
    public String getCurrency() {
        return CURRENCY;
    }

    /**
     * @return Describe the coin's value and currency.
     */
    @Override
    public String toString() {
        if(((int) value) - value == 0) return String.format("%.0f-%s",value,CURRENCY);
        else return String.format("%.2f-%s",value,CURRENCY);
    }

    /**
     * Compare that 2 coins are the same or not.
     * @param obj the coin or object that you want to compare.
     * @return if 2 coins are the same, will return true.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if(obj.getClass() != this.getClass()) return false;

        Coin other = (Coin) obj;
        return this.value == other.value && this.CURRENCY.equals(other.CURRENCY);
    }

    /**
     * A method to make Coin comparable.
     * @param o The coin that you want to compare its value with other
     * @return  0 if the first coin has order before the second coin.
     * > 0 if the first coin has order after the second coin.
     * = 0 if the first coin and the second coin have same order.
     */
    @Override
    public int compareTo(Coin o) {

        if(this.value - o.value < 0) return -1;
        else if(this.value - o.value > 0) return 1;
        else return 0;

    }
}

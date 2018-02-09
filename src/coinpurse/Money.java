package coinpurse;

public class Money implements Valuable {

    private double value;
    private String currency;

    public Money(double value, String currency){
        if(value < 0) throw new IllegalArgumentException("value must be positive");
        this.value = value;
        this.currency = currency;
    }

    /**
     * A method to make Coin comparable.
     * @param o The coin that you want to compare its value with other
     * @return  0 if the first coin has order before the second coin.
     * > 0 if the first coin has order after the second coin.
     * = 0 if the first coin and the second coin have same order.
     */
    @Override
    public int compareTo(Valuable o) {
        if(this.getValue() - o.getValue() < 0) return -1;
        else if(this.getValue() - o.getValue() > 0) return 1;
        else return 0;

    }
    /**
     * Get value of Money.
     * @return value of Money in double.
     */
    @Override
    public double getValue() {
        return value;
    }
    /**
     * Get currency of Money.
     * @return String value of Money.
     */


    @Override
    public String getCurrency() {
        return currency;
    }

    /**
     * Compare that 2 objects are the same or not.
     * @param obj the object that you want to compare.
     * @return if 2 objects are the same, will return true.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if(obj.getClass() != this.getClass()) return false;

        Money other = (Money) obj;
        return this.getValue() == other.getValue() && this.getCurrency().equals(other.getCurrency());
    }

}

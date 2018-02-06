package coinpurse;

/**
 * BankNotes represents bill (money) with a fixed value,
 *  currency, and serial number.
 *  @author Pornpavee Seri-umnuoy
 *
 */
public class BankNote implements Valuable {


    private double value;
    private String currency;
    private long serialNumber;
    private static long nextSerialNumber = 1000000;

    /**
     * Create BankNote object with value, currency,
     * and unique serial number.
     *
     * @param value is value of a banknote.
     * @param currency is currency of a banknote.
     */
    public BankNote(double value, String currency) {
        this.value = value;
        this.currency= currency;
        this.serialNumber = nextSerialNumber;
        nextSerialNumber++;
    }

    /**
     * Get value of a banknote.
     * @return value of a banknote in double.
     */
    @Override
    public double getValue() {
        return this.value;
    }

    /**
     * Get currency of a banknote.
     * @return String value of a banknote.
     */
    @Override
    public String getCurrency() {
        return this.currency;
    }

    /**
     * get serialNumber of banknote
     * @return long value of serial number.
     */
    public long getSerial() {
        return this.serialNumber;
    }

    /**
     * Compare that 2 banknotes are the same or not.
     * @param obj the banknote or object that you want to compare.
     * @return if 2 banknotes are the same, will return true.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if(obj.getClass() != this.getClass()) return false;

        BankNote other = (BankNote) obj;
        return this.getValue() == other.getValue() && this.getCurrency().equals(other.getCurrency());
    }

    /**
     * @return Describe the banknote's value, currency, and serial number.
     */
    public String toString() {
        if(((int) value) - value == 0) return String.format("%.0f-%s note [%d]", value,currency,serialNumber);
        else return String.format("%.2f-%s note [%d]", value,currency,serialNumber);
    }

}
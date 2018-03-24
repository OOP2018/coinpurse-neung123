package coinpurse;

/**
 * BankNotes represents bill (money) with a fixed value,
 *  currency, and serial number.
 *  @author Pornpavee Seri-umnuoy
 *
 */
public class BankNote extends Money {

    private long serialNumber;
    private static long nextSerialNumber = 100000L;

    /**
     * Create BankNote object with value, currency,
     * and unique serial number.
     *
     * @param value is value of a banknote.
     * @param currency is currency of a banknote.
     */
    public BankNote(double value, String currency) {
        super(value, currency);
        this.serialNumber = nextSerialNumber++;
    }

    public BankNote(double value, String currency,long nextSerialNumber) {
        super(value, currency);
        this.serialNumber = nextSerialNumber;
    }

    /**
     * get serialNumber of banknote
     *
     * @return long value of serial number.
     */
    public long getSerial() {
        return this.serialNumber;
    }

    /**
     * @return Describe the banknote's value, currency, and serial number.
     */
    public String toString() {
        return String.format("%f-%s note [%d]", this.getValue(),this.getCurrency(),serialNumber);
    }

}
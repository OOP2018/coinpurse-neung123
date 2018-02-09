package coinpurse;

/**
 * An interface for objects having a monetary value and currency.
 *  @author Pornpavee Seri-umnuoy
 */

public interface Valuable {

    /**
     * @return the value of this Valuable.
     */
    public double getValue();

    /**
     * @return the currency of this Valuable.
     */
    public String getCurrency();
}
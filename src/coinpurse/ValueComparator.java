package coinpurse;
/**
 * ValueComparator is for compare two objects that implement Valuable
 * and define which one is more than the other.
 *  @author Pornpavee Seri-umnuoy
 */

import java.util.Comparator;

public class ValueComparator implements Comparator<Valuable> {

    /**
     * Compare two objects that implement Valuable.
     * First compare them by currency, so that "Baht" < "Dollar".
     * If both objects have the same currency, order them by value.
     *
     * @param a is a value of the object.
     * @param b is a value of the object.
     * @return -1 if a has an order before b or the value of a is less than b.
     *         0 if a and b have the same order or the value of a is equals b.
     *         1 if a has an order after b or the value of a is more than b.
     */

    public int compare(Valuable a, Valuable b) {
        if (a.getCurrency().equals(b.getCurrency()) ) {
            if (a.getValue() < b.getValue()) return -1;
            else if (a.getValue() > b.getValue()) return 1;
            else return 0;
        }
        else return a.getCurrency().compareTo(b.getCurrency());
    }

}

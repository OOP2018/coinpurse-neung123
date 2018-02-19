package coinpurse;

/**
 *  MoneyFactory is the main object for other money factory.
 *  Can't constructs this object, you can only get its instance.
 *
 * @author Pornpavee Seri-umnuoy
 */

public abstract class MoneyFactory {
    /** singleton instance of MoneyFactory. */
    private static MoneyFactory factory = null;

    /**
     *  Method for get the currently MoneyFactory.
     *
     * @return the currently MoneyFactory.
     *      if doesn't set the MoneyFactory yet, the default is ThaiMoneyFactory.
     */

    public static MoneyFactory getInstance() {
        if(factory == null) factory = new ThaiMoneyFactory();
        return  factory;
    }

    /**
     * A method for making a double value to money.
     *
     * @param value the value of money that you want to create.
     * @return the money that can be a banknote, a coin or null.
     */
    public abstract Valuable createMoney(double value);

    /**
     * Parse the String as a double and call the other createMoney method.
     * if String value isn't a number, it will throw IllegalArgumentException.
     * @param value
     * @return
     */
    public Valuable createMoney(String value) {
         double numberValue;
      try {
            numberValue = Double.parseDouble(value);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException(value + " isn't a number");
      }
        return createMoney( numberValue );
    }

    /**
     *  A method for set the moneyFactory to other money factory that you want.
     *
     * @param moneyFactory other money factory that you want to change to.
     */

    public static void setFactory(MoneyFactory moneyFactory) {
        factory = moneyFactory;
    }

}

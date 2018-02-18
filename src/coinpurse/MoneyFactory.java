package coinpurse;

public abstract class MoneyFactory {
    /** singleton instance of MoneyFactory. */
    private static MoneyFactory factory = null;

    public static MoneyFactory getInstance() {
        if(factory == null) factory = new ThaiMoneyFactory();
        return  factory;
    }

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

    public static void setFactory(MoneyFactory moneyFactory) {
        factory = moneyFactory;
    }

}

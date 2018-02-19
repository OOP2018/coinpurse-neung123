package coinpurse;

/**
 * ThaiMoneyFactory for creating money in thai specifically value and currency.
 *
 * @author Pornpavee Seri-umnuoy
 */
public class ThaiMoneyFactory extends MoneyFactory {
    private static long serialNumber = 1000000;

    /**
     * creating money in thai specifically value and currency.
     *
     * @param value the value of money that you want to create.
     * @return Coin if equal to 0.25, 0.5, 1, 2, 5 or 10.
     *          Banknote if equal to 20, 50, 100, 500 or 1000.
     */
    @Override
    public Valuable createMoney(double value) {
        if(value < 20){
            if (value == 0.25 || value == 0.5
                    || value == 1 || value == 2
                    || value == 5 || value == 10) {
                return new Coin(value,"Baht");
            }

            throw new IllegalArgumentException(value + " Baht coin is invalid in Thailand");
        }
        if (value == 20 || value == 50
                || value == 100 || value == 500
                || value == 1000) {

            BankNote bank =  new BankNote(value,"Baht", getSerialNumber());
            serialNumber++;
            return bank;
        }

        throw new IllegalArgumentException(value + " Baht banknote is invalid in Thailand");
    }

    /**
     * @return the unique serial number.
     */

    private long getSerialNumber(){
        return serialNumber;
    }
}

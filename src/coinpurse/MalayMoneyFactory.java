package coinpurse;

/**
 * MoneyFactory in Malaysia's currency and value.
 * has its own unique serial number.
 *
 * @author Pornpavee Seri-umnuoy
 */

public class MalayMoneyFactory extends MoneyFactory{
    private static long serialNumber = 1000000;

    /**
     * Creating money in banknote or coin.
     * if the value is greater-than or equal to 1
     * this method will create it in banknote.
     *
     * @param value value of money
     * @return Coin if equal to 0.05, 0.1, 0.2 or 0.5.
     *          Banknote if equal to 1, 2, 5, 10, 20, 50 or 100.
     */
    @Override
    public Valuable createMoney(double value) {
        if(value < 1){
            if (value == 0.05 || value == 0.10
                    || value == 0.20 || value == 0.5) {
                return new Coin(value,"Ringgit");
            }

            throw new IllegalArgumentException(value + " Ringgit is invalid in Malaysia");
        }
        if (value == 1 || value == 2
                || value == 5 || value == 10
                || value == 20 || value == 50
                || value == 100) {
            BankNote bank =  new BankNote(value,"Ringgit", getSerialNumber());
            serialNumber++;
            return bank;
        }

        throw new IllegalArgumentException(value + " Ringgit banknote is invalid in Malaysia");
    }

    /**
     * @return serial number for Banknote.
     */
    private long getSerialNumber(){
        return serialNumber;
    }
}

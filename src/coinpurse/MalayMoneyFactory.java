package coinpurse;

public class MalayMoneyFactory extends MoneyFactory{
    private static long serialNumber = 1000000;

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
    private long getSerialNumber(){
        return serialNumber;
    }
}

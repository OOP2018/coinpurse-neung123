package coinpurse;

/**
 * Coin represents coinage (money) with a fixed value and currency.
 * @author Pornpavee Seri-umnuoy
 */
public class Coin extends Money {

    /**
     *  Initialize a new coin.
     * @param value is the value of this coin.
     * @param currency is the coin's currency.
     */
    public  Coin(double value,String currency){
        super(value, currency);
    }

    /**
     * @return Describe the coin's value and currency.
     */
    @Override
    public String toString() {
        return String.format("%f-%s",this.getValue(), this.getCurrency());
    }

}

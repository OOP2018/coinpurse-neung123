package coinpurse;

import java.util.ArrayList;
import java.util.List;

/**
 * A class for testing Coin.
 *
 * @author Pornpavee Seri-umnuoy
 */
public class MoneyUtil {

    public static void main(String[] arg){
        sortCoins();
    }

    public static void sortCoins(){
        List<Coin> coins = new ArrayList<Coin>();
        coins.add(new Coin(10.0, "Bath"));
        coins.add(new Coin(0.5, "Bath"));
        coins.add(new Coin(0.25, "Bath"));
        coins.add(new Coin(2.0, "Bath"));
        coins.add(new Coin(10.0, "Rupie"));
        coins.add(new Coin(50.0, "Rupie"));
        printCoin( coins );
        java.util.Collections.sort( coins );
        printCoin( coins );
    }

    public static void printCoin(List<Coin> coins){
        for (Coin c : coins){
            System.out.println(c);
        }

        System.out.println("---------------");
    }
}

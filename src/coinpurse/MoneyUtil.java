package coinpurse;

import java.util.ArrayList;
import java.util.List;

/**
 * A class for testing Coin.
 *
 * @author Pornpavee Seri-umnuoy
 */
public class MoneyUtil {

    public static List<Coin> filterByCurrency(List<Coin> coins, String currency) {
        List<Coin> other = new ArrayList<>();
        for (Coin c : coins) {
            if (currency.equals(c.getCurrency())) other.add(c);
        }
        return other;
    }

    public static void sortCoins(List<Coin> coins) {
        java.util.Collections.sort(coins);
    }

    public static void printCoins(List<Coin> coins){
        for (Coin c : coins){
            System.out.println(c);
        }

        System.out.println("---------------");
    }

    public static void main(String[] arg){
        List<Coin> coins = new ArrayList<Coin>();
        coins.add(new Coin(10.0, "Bath"));
        coins.add(new Coin(0.5, "Bath"));
        coins.add(new Coin(0.25, "Bath"));
        coins.add(new Coin(2.0, "Bath"));
        coins.add(new Coin(10.0, "Rupie"));
        coins.add(new Coin(50.0, "Rupie"));

        printCoins(coins);
        sortCoins(coins);
        printCoins(coins);
        printCoins(filterByCurrency(coins, "Bath"));
    }

}

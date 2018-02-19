package coinpurse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * A class for testing Coin.
 *
 * @author Pornpavee Seri-umnuoy
 */
public class MoneyUtil {

    public static List<Valuable> filterByCurrency(List<Valuable> valuables, String currency) {
        List<Valuable> other = new ArrayList<>();
        for (Valuable v : valuables) {
            if (currency.equals(v.getCurrency())) other.add(v);
        }
        return other;
    }

    public static void sort(List<Valuable> valuables) {

        Comparator<Valuable> comp = new ValueComparator();
        java.util.Collections.sort(valuables,comp);
    }

    public static void printCoins(List<Valuable> valuables){
        for (Valuable v : valuables){
            System.out.println(v);
        }
        System.out.println("---------------");
    }

    public static void main(String[] arg){
        List<Valuable> valuables = new ArrayList<Valuable>();
        valuables.add(new Coin(10.0, "Bath"));
        valuables.add(new Coin(0.25, "Bath"));
        valuables.add(new Coin(10.0, "Rupie"));
        valuables.add(new BankNote(50.0, "Rupie"));
        valuables.add(new BankNote(20.0, "Rupie"));
        valuables.add(new BankNote(100.0, "Bath"));

        printCoins(valuables);
        sort(valuables);
        printCoins(valuables);
        printCoins(filterByCurrency(valuables, "Bath"));
    }

}

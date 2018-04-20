package coinpurse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * A class for testing Coin.
 *
 * @author Pornpavee Seri-umnuoy
 */
public class MoneyUtil {

    public static <E extends Valuable> List<E> filterByCurrency(List<E> valuables, String currency) {
        List<E> other = new ArrayList<>();
        for (E v : valuables) {
            if (currency.toLowerCase().equals(v.getCurrency().toLowerCase())) other.add(v);
        }
        return other;
    }

    public static void sortMoney(List<? extends Valuable> money) {

        Comparator<Valuable> comp = new ValueComparator();
        java.util.Collections.sort(money,comp);
    }

    public static void printCoins(List<Valuable> valuables){
        for (Valuable v : valuables){
            System.out.println(v);
        }
        System.out.println("---------------");
    }

    public static <E extends Comparable<? super E>> E max(E ...args){

        E maxValue = args[0];
        for(int i = 0; i < args.length; i++) if(maxValue.compareTo(args[i]) < 0) maxValue = args[i];

        return  maxValue;
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
        sortMoney(valuables);
        printCoins(valuables);
        printCoins(filterByCurrency(valuables, "Bath"));

        System.out.println(max(new Coin(10.0, "Bath"),new Coin(0.25, "Bath")));
        String max = MoneyUtil.max("dog", "zebra", "cat");
        System.out.println(max);


        Money m1 = new BankNote(100, "Baht");
        Money m2 = new BankNote(500, "Baht");
        Money m3 = new Coin(20, "Baht");
        Money maxM = MoneyUtil.max( m1, m2, m3 );
        System.out.println(maxM);

        List<BankNote> list = new ArrayList<BankNote>();
        list.add( new BankNote(10.0, "USD") );
        list.add( new BankNote(500.0, "Baht") );
        MoneyUtil.sortMoney( list );
        System.out.println(list);

        List<Coin> coins = Arrays.asList( new Coin(5,"Baht"),
                new Coin(0.1,"Ringgit"), new Coin(5,"Cent") );
        List<Coin> result = MoneyUtil.filterByCurrency(coins, "Baht");
        System.out.println(result);

    }

}

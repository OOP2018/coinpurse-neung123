package coinpurse.strategy;

import coinpurse.Coin;
import coinpurse.Money;
import coinpurse.Valuable;
import coinpurse.ValueComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Find and return items from a collection whose total value equals
 * the requested amount by using recursion.
 *
 *@author Pornpavee Seri-umnuoy
 */
public class RecursiveWithdraw implements WithdrawStrategy {

    Comparator<Valuable> comp = new ValueComparator();

    /**
     *  Withdraw the requested amount of money by using recursion.
     *  Return an array of Valuable withdrawn from List,
     *  or return null if cannot withdraw the amount requested.
     * @param amount is the amount of money to withdraw, with currency
     * @param money the contents that are available for possible withdraw.
     * Must not be null, but may be an empty list.
     * This list is not modified.
     * @return List of Valuable objects for money withdrawn,
     *    or null if cannot withdraw requested amount
     */
    @Override
    public List<Valuable> withdraw(Valuable amount, List<Valuable> money) {
        java.util.Collections.sort(money,comp);
        java.util.Collections.reverse(money);

        if(money.size() == 0) return null;

        Valuable first = money.get(0);
        List<Valuable> result = null;

        if (amount.getCurrency().equals(first.getCurrency())) {
            try {
                result = withdraw(new Money(amount.getValue() - first.getValue(), amount.getCurrency()), money.subList(1, money.size()));
            }catch (IllegalArgumentException e){
                result = withdraw(new Money(amount.getValue(), amount.getCurrency()), money.subList(1, money.size()));
            }
                if (amount.getValue() - first.getValue() == 0) {
                    result = new ArrayList<>();
                    result.add(first);
                    return result;
                }

                if (amount.getValue() - first.getValue() > 0 && result!=  null) {
                    result.add(first);
                    return result;
                }
        }
        if(result != null) java.util.Collections.sort(result,comp);
        else java.util.Collections.reverse(money);
        return result;
    }

}
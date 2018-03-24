package coinpurse.strategy;

import coinpurse.Valuable;
import coinpurse.ValueComparator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Simple withdraw class for items from a collection
 *
 * @author Pornpavee Seri-umnuoy
 */
public class GreedyWithdraw implements WithdrawStrategy {
    /**
     * Comparator for sorting Valuable.
     */
    Comparator<Valuable> comp = new ValueComparator();

    /**
     *  Withdraw the requested amount of money.
     *  Return an array of Valuable withdrawn from List,
     *  or return null if cannot withdraw the amount requested.
     * @param amount the amount to withdraw
     * @param money List of Valuable objects for withdraw
     * @return List of Valuable objects for money withdrawn,
     *    or null if cannot withdraw requested amount
     */
    @Override
    public List<Valuable> withdraw(Valuable amount, List<Valuable> money) {
        List<Valuable> templist = new ArrayList<>();

        if (amount == null || amount.getValue() < 0) return null;
        java.util.Collections.sort(money,comp);
        java.util.Collections.reverse(money);

        double amountNeededToWithdraw = amount.getValue();

        for(Valuable valuable: money){

            if(amount.getCurrency().equalsIgnoreCase(valuable.getCurrency())){

                if (amountNeededToWithdraw - valuable.getValue() >= 0) {

                    amountNeededToWithdraw -= valuable.getValue();
                    templist.add(valuable);
                }

                if (amountNeededToWithdraw == 0) break;
            }
        }
        if (amountNeededToWithdraw != 0) return null;

        java.util.Collections.sort(templist,comp);
        return templist;
    }
}

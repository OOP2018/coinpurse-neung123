package coinpurse;

import java.util.*;

/**
 *  A purse contains money.
 *  You can insert money, withdraw money, check the balance,
 *  and check if the purse is full.
 *
 *  @author Pornpavee Seri-umnuoy
 */
public class Purse {
    /** Collection of objects in the purse. */
    List<Valuable> money = new ArrayList<Valuable>();

    /** Capacity is maximum number of items the purse can hold.
     *  Capacity is set when the purse is created and cannot be changed.
     */
    private final int capacity;

    /**
     * Comparator for sorting Valuable.
     */
    Comparator<Valuable> comp = new ValueComparator();

    /**
     *  Create a purse with a specified capacity.
     *  @param capacity is maximum number of money you can put in purse.
     */
    public Purse(int capacity) {
        this.capacity = capacity;
        money = new ArrayList<Valuable>(capacity);
    }

    /**
     * Count and return the number of money in the purse.
     * This is the number of cmoney, not their value.
     * @return the number of money in the purse
     */
    public int count() { return money.size(); }

    /**
     *  Get the total value of all items in the purse.
     *  @return the total value of items in the purse.
     */
    public double getBalance() {
        double balance = 0;
        for(Valuable valuable:money){
            balance+=valuable.getValue();
        }
		return balance;
	}


    /**
     * Return the capacity of the purse.
     * @return the capacity
     */

    public int getCapacity() {
		return capacity;
	}

    /**
     *  Test whether the purse is full.
     *  The purse is full if number of items in purse equals
     *  or greater than the purse capacity.
     *  @return true if purse is full.
     */
    public boolean isFull() {
        if(count() != capacity) return false;
        return true;
    }

    /**
     * Insert money into the purse.
     * Money is only inserted if the purse has space for it
     * and the money has positive value.  No worthless money!
     * @param valuable is a Coin object to insert into purse
     * @return true if money inserted, false if can't insert
     */
    public boolean insert(Valuable valuable) {
        // if the purse is already full then can't insert anything.
        if(isFull() || valuable.getValue() <= 0) return false;

        money.add(valuable);
        return true;
    }

    /**
     *  Withdraw the requested amount of money.
     *  Return an array of Coins withdrawn from purse,
     *  or return null if cannot withdraw the amount requested.
     *  @param amount is the amount to withdraw
     *  @return array of Coin objects for money withdrawn,
	 *    or null if cannot withdraw requested amount.
     */
    public Valuable[] withdraw(double amount) {

        List<Valuable> templist = new ArrayList<>();
        if (amount > 0) {
            java.util.Collections.sort(money,comp);

            double amountNeededToWithdraw = amount;

            for (int i = money.size()-1; i >= 0; i--) {
                if (amountNeededToWithdraw - money.get(i).getValue() >= 0) {
                    amountNeededToWithdraw -= money.get(i).getValue();
                    templist.add(money.get(i));
                }

                if (amountNeededToWithdraw == 0) break;
            }

            if (amountNeededToWithdraw != 0) return null;

        }else return null;

        Valuable [] array = new Valuable[ templist.size() ];
        templist.toArray(array);

		for (int i = 0;  i < templist.size(); i++){
		    money.remove( templist.get(i));
        }
        return array;
	}

    /**
     * toString returns a string description of the purse contents.
     * It can return whatever is a useful description.
     */
    public String toString() {
    	return String.format("%d money with value %.2f", money.size(), getBalance());
    }

}


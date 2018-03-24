package coinpurse.strategy;

import coinpurse.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Junit class for testing WithdrawStrategy.
 *
 * @author Pornpavee Seri-umnuoy
 */
public class WithdrawUnitTest {
    public static String currency = "THB";
    private static final double TOLERANCE = 1.0E-6;
    private WithdrawStrategy strategy;
    private List<Valuable> money;
    private Comparator<Valuable> comp = new ValueComparator();

    @Before
    public void setUp() throws Exception {
        strategy = new RecursiveWithdraw();
        money = new ArrayList<>();
    }

    /**
     * try to withdraw from an empty List.
     */
    @Test(timeout=1000)
    public void testWithdrawEmptyList(){
        Valuable m = new Money(500,currency);
        assertNull(strategy.withdraw(m,money));
    }

    /**
     * Withdraw with an invalid value that can't withdraw.
     */
    @Test(timeout=1000)
    public void testWithdrawWrongValue(){
        money = Arrays.asList(
                new BankNote(50,currency),
                new BankNote(20,currency),
                new BankNote(100,currency)
        );

        Valuable m = new Money(500,currency);
        assertNull(strategy.withdraw(m,money));
    }

    /**
     * Withdraw with a wrong currency in an valid value.
     */
    @Test(timeout=1000)
    public void testWithdrawWrongCurrency(){
        String otherCurr = "USD";

        money = Arrays.asList(
                new BankNote(50,currency),
                new BankNote(20,currency),
                new BankNote(100,currency)
        );

        for(Valuable v: money){
            Valuable m = new BankNote(v.getValue(),otherCurr);
            assertNull(strategy.withdraw(m,money));
        }
    }

    /**
     * Testing normal withdraw.
     */
    @Test(timeout=1000)
    public void testEasyWithdraw(){

        money = Arrays.asList(
                new BankNote(50,currency),
                new BankNote(20,currency),
                new BankNote(100,currency)
        );

        List<Valuable> other = new ArrayList<>();
        for(Valuable v: money){
            other.add(v);
            Valuable m = new BankNote(v.getValue(),currency);
            assertEquals(other,strategy.withdraw(m,money));
            other.remove(v);
        }
    }

    /**
     * Withdraw more than 2 values.
     */
    @Test(timeout=1000)
    public void testMultiWithdraw(){
        money = Arrays.asList(
                new BankNote(50,currency),
                new BankNote(20,currency),
                new BankNote(100,currency),
                new BankNote(500,currency)
        );
        double amount1 = money.get(0).getValue() + money.get(3).getValue();
        List<Valuable> compare1 = Arrays.asList( money.get(0),money.get(3));
        double amount2 = money.get(0).getValue() + money.get(2).getValue();
        List<Valuable> compare2 = Arrays.asList( money.get(0),money.get(2));
        double amount3 = money.get(0).getValue() + money.get(1).getValue() + money.get(3).getValue();
        List<Valuable> compare3 = Arrays.asList( money.get(0),money.get(1),money.get(3));

        java.util.Collections.sort(compare1,comp);
        java.util.Collections.sort(compare2,comp);
        java.util.Collections.sort(compare3,comp);


        //test amount1
        Valuable m1 = new Money(amount1,currency);
        assertEquals(compare1,strategy.withdraw(m1,money));

        //test amount2
        Valuable m2 = new Money(amount2,currency);
        assertEquals(compare2,strategy.withdraw(m2,money));

        //test amount3
        Valuable m3 = new Money(amount3,currency);
        assertEquals(compare3,strategy.withdraw(m3,money));
    }

    /**
     * Withdraw everything in List
     */
    @Test(timeout=1000)
    public void testWithdrawEverything(){

        money = Arrays.asList(
                new Coin(5.0,currency),
                new Coin(0.25,currency),
                new Coin(1.0,currency),
                new Coin(2.0,currency),
                new Coin(10.0,currency),
                new Coin(0.5,currency)
        );

        double amount = 0.0;
        for(Valuable c: money) {
            amount += c.getValue();
        }

        Valuable otherCurr = new Money(amount,"BTC");
        List<Valuable> stg = strategy.withdraw(otherCurr,money);
        assertNull("Withdraw right amount but another currency", stg);

        Valuable sameCurr = new Money(amount,currency);
        stg = strategy.withdraw(sameCurr,money);
        java.util.Collections.sort(money,comp);
        assertEquals("Withdraw everything", money,stg);
    }

}
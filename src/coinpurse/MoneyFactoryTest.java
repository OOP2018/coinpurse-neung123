package coinpurse;
/**
 * Test the MoneyFactory using JUnit.
 *
 *  @author Pornpavee Seri-umnuoy
 */

import junit.framework.TestCase;
import org.junit.Test;

public class MoneyFactoryTest extends TestCase {
    private MoneyFactory moneyFactory = MoneyFactory.getInstance();
    private String[] thaiMoneyString = {"1","2","5","10","20","50","100","1000"};
    private Double[] thaiMoneyDouble = {1d, 2d, 5d, 10d, 20d, 50d, 100d, 1000d};
    private String[] notMoneyString = {"0.3", "0.6", "4", "9", "15", "78", "666"};
    private String[] malayMoneyString = {"0.05","0.1","0.2","0.5","1","2","5","10","20","50","100"};

    /**
     * for testing the singleton in MoneyFactory.
     */
    @Test(timeout=1000)
    public void testSingleton()  {
        MoneyFactory f1 = MoneyFactory.getInstance();
        MoneyFactory f2 = MoneyFactory.getInstance();

        assertTrue("f1 == f2?",f1==f2);
    }

    /**
     * for testing that it will create the same object or not,
     * if its type is not the same.(String and Double)
     */
    @Test(timeout=1000)
    public void testCreateMoney() throws Exception {

        for (int i = 0; i < thaiMoneyString.length; i++) {
            assertEquals("String,Double", moneyFactory.createMoney(thaiMoneyString[i]),
                    moneyFactory.createMoney(thaiMoneyDouble[i]));
        }

    }

    /**
     * for testing that it will create the object or not,
     * if the value is invalid.
     */
    @Test(timeout=1000)
    public void testCreateMoney1() throws Exception {
        for (int i = 0; i < notMoneyString.length; i++) {
            assertFalse("notMoneyString", creatingMoney(notMoneyString[i],moneyFactory));
        }
    }

    /**
     * a method for create money.
     *
     * @param value string value that you want to parse to Money.
     * @param moneyFactory the MoneyFactory that you want to create money by using it.
     * @return true if you can create money.
     *          false if you can not create money.
     */
    private boolean creatingMoney(String value,MoneyFactory moneyFactory){

        try {
            moneyFactory.createMoney(value);
            return true;
        }catch (IllegalArgumentException ex){
            return false;
        }
    }

    /**
     * for testing setFactory method.
     */
    @Test(timeout=1000)
    public void testSetFactory() throws Exception {
        MoneyFactory.setFactory(new MalayMoneyFactory());
        MoneyFactory factory = MoneyFactory.getInstance();

        for (int i = 0; i <malayMoneyString.length; i++) {
            assertTrue("MoneyString", creatingMoney(malayMoneyString[i],factory));
        }

        for (int i = 0; i < notMoneyString.length; i++) {
            assertFalse("notMoneyString", creatingMoney(notMoneyString[i],factory));
        }
    }
}
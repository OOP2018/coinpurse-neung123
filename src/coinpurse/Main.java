package coinpurse;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * A main class to create objects and connect objects together.
 * The user interface needs a reference to coin purse.
 *  @author Pornpavee Seri-umnuoy
 */
public class Main {

    /**
     * Configure and start the application.
     * @param args not used
     */
    public static void main(String[] args) {

        // 1. create a Purse
    	Purse purse = new Purse(10,init());
        // 2. create a ConsoleDialog with a reference to the Purse object
    	ConsoleDialog ui = new ConsoleDialog(purse,init());
        // 3. run the ConsoleDialog
    	ui.run();

    }

    public static String init() {

        ResourceBundle bundle = ResourceBundle.getBundle( "purse" );
        String factoryClass = bundle.getString( "moneyfactory" );

        MoneyFactory factory = null;

        try {
            factory = (MoneyFactory)Class.forName(factoryClass).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
            if (factory == null) System.exit(1);
            MoneyFactory.setFactory(factory);


            return bundle.getString("currency");
        }


    }


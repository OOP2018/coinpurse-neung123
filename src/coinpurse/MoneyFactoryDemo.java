package coinpurse;

public class MoneyFactoryDemo {

    public static void main(String[] args){
        factoryTest();
        System.out.println("Thailand ------> Malaysia");
        MoneyFactory.setFactory(new MalayMoneyFactory());
        factoryTest();
    }


    public static void factoryTest(){
        MoneyFactory f1 = MoneyFactory.getInstance();
        System.out.println("f1 is a " + f1.getClass().getName());
        MoneyFactory f2 = MoneyFactory.getInstance();
        System.out.println("f2 is a " + f1.getClass().getName());
        System.out.println("f1 == f2? " + (f1 == f2));

        String[] values = {"0.25","0.5","1","2","8","5.0","20","100","1000"};
        for(String value: values){
            System.out.printf("createMoney(%s) is ",value);
            try{
                Valuable v = f1.createMoney(value);
                System.out.println(v.toString());
            }catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
}

package coinpurse;

public class Coin implements  Comparable<Coin>{

    private final double value;
    private final String CURRENCY;

    public  Coin(double value,String CURRENCY){
        if( value<0 ) value = 0;
        this.value = value;
        this.CURRENCY = CURRENCY;
    }

    public double getValue() {
        return value;
    }

    public String getCURRENCY() {
        return CURRENCY;
    }


    @Override
    public String toString() {
        if(((int) value)- value == 0 ) return String.format("%.0f-%s",value,CURRENCY);
        else return String.format("%.2f-%s",value,CURRENCY);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if(obj.getClass() != this.getClass()) return false;

        Coin other = (Coin) obj;
        return this.value == other.value && this.CURRENCY.equals(other.CURRENCY);
    }

    @Override
    public int compareTo(Coin o) {

        if(this.value - o.value < 0) return -1;
        else if(this.value - o.value > 0) return 1;
        else return 0;

    }
}

public class Money {
    private int value;
    private String currency;
    public Money(int value,String currency){
        this.value=value;
        this.currency=currency;
    }
    public Money add_value(Money a){
        if(a.currency==this.currency) {
            Money b = new Money(a.value + this.value, a.currency);
            return b;
        }
        else{
            System.out.println("Currencies do not match");
            return this;
        }
    }
    public static void main(String args[]){
        Money money=new Money(10,"inr");
        Money money1=money.add_value(new Money(5,"inr"));
        System.out.println(money1.value);
    }
}

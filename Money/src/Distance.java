import java.util.Objects;
public class Distance {
    private int value;
    enum Unit{
        KM,METRIC;
    }
    private Unit unit;
    public Distance(int a,Unit b){
        this.value=a;
        this.unit=b;
    }
    public boolean equals(Object o){
        if(o!=null && o instanceof Distance){
            if(((Distance) o).unit == this.unit){
                if(((Distance)o).value==this.value){
                    return true;
                }
                else{
                    return false;
                }
            }
            else if(((Distance)o).unit==Unit.KM){
                if(((Distance)o).value*1000==this.value){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        return false;
    }

    public static void main(String args[]){

    }

}

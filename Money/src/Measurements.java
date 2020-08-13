public class Measurements {
    private int value;
    private Type type;
    private Unit unit;
    enum Type {
        Distance, Weight, Volume;
    }
    enum Unit {
        KM, m, KG, g, L, ml;
    }
    private Measurements convert(){
        Measurements m=new Measurements();
        if(this.type==Type.Distance){
            if(this.unit==Unit.KM){
                m.value=this.value*1000;
                m.unit=Unit.m;
            }
            else{
                m.value=this.value/1000;
                m.unit=Unit.KM;
            }
            return m;
        }
        else if(this.type==Type.Weight){
            if(this.unit==Unit.KG){
                m.value=this.value*1000;
                m.unit=Unit.g;
            }
            else{
                m.value=this.value/1000;
                m.unit=Unit.KG;
            }
            return m;
        }
        else{
            if(this.unit==Unit.L){
                m.value=this.value*1000;
                m.unit=Unit.ml;
            }
            else{
                m.value=this.value/1000;
                m.unit=Unit.L;
            }
            return m;
        }
    }
    public boolean equals(Object o){
        if(o!=null && o instanceof Measurements){
            if(((Measurements) o).type == this.type){
                if(((Measurements)o).unit==this.unit && ((Measurements)o).value==this.value){
                    return true;
                }
                else if(((Measurements)o).unit!=this.unit){
                    if((((Measurements)o).convert()).value==this.value){
                        return true;
                    }
                    return false;
                }
            }
            return false;

        }
        return false;
    }

}

import org.junit.Assert;
import org.junit.Test;
public class gameOfLifeTest {
    @Test
    public void gridInitialisedToDead() {
        boolean[][] a={{false,false,false,false,false},{false,false,false,false,false},{false,false,false,false,false},{false,false,false,false,false},{false,false,false,false,false}};
        Assert.assertEquals((new universe(5, 5)).grid, a);
    }
    @Test
    public void gridTick() {
        boolean[][] c={{true,false,false,true,false},{true,false,false,false,false},{true,true,false,true,false},{false,true,false,false,false},{false,false,true,false,false}};
        universe b=new universe(5,5);
        b.makeAlive(0,1);
        b.makeAlive(0,2);
        b.makeAlive(0,3);
        b.makeAlive(1,0);
        b.makeAlive(1,1);
        b.makeAlive(1,2);
        b.makeAlive(1,4);
        b.makeAlive(2,1);
        b.makeAlive(3,3);
        b.makeAlive(4,1);
        b.makeAlive(4,2);
        Assert.assertEquals((b.tick()).grid, c);
    }
    @Test
    public void countAliveCorner() {
        universe d=new universe(5,5);
        d.makeAlive(0,0);
        d.makeAlive(0,1);
        d.makeAlive(1,0);
        Assert.assertEquals((d.count_alive(0,0)), 2);
    }
    @Test
    public void countAliveEdge() {
        universe e=new universe(5,5);
        e.makeAlive(0,2);
        e.makeAlive(0,1);
        e.makeAlive(1,2);
        e.makeAlive(1,3);
        Assert.assertEquals((e.count_alive(0,2)), 3);
    }
    @Test
    public void countAliveCenter() {
        universe f=new universe(5,5);
        f.makeAlive(2,2);
        f.makeAlive(1,1);
        f.makeAlive(1,3);
        f.makeAlive(2,3);
        f.makeAlive(3,3);
        Assert.assertEquals((f.count_alive(2,2)), 4);
    }
}

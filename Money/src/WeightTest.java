import org.junit.Assert;
import org.junit.Test;

public class WeightTest {
    @Test
    public void oneKmIsThousandMeters() {
        Assert.assertEquals(new Distance(1000,Distance.Unit.METRIC),new Distance(1,Distance.Unit.KM));
    }
}


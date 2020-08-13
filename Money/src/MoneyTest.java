import org.junit.Assert;
import org.junit.Test;
public class MoneyTest {
    @Test
    public void fiftyRupeesShouldEqualFiftyRupees() {
        Assert.assertEquals(new Money(50,"inr"), new Money(50,"inr"));
    }

}


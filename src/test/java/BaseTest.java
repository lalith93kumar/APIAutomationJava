import org.apache.commons.lang3.RandomUtils;
import org.junit.After;
import org.junit.Before;

public class BaseTest {
    @Before
    public void setUp() {
        System.out.println("This test is started");
    }

    @After
    public void tearDown() {
        System.out.println("This test is completed");
    }

    protected int get3DigitRandomInt() {
        return RandomUtils.nextInt(100, 999);
    }
}

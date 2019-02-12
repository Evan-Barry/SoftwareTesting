import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)

public class RobotCostParamTest {

    private double expected;
    private int age;

    public RobotCostParamTest(double expected, int age)
    {
        this.expected = expected;
        this.age = age;
    }

    @Parameterized.Parameters (name = "{index}: checkCost({1})={0}")
    public static Collection<Object[]> getTestParameters() {
        return Arrays.asList(new Object[][] {
                {10000.00, 2},
                {10000.00 , 5},
                {7500.00, 7},
                {7500.00, 10},
                {5000.00, 15},
        });
    }

    @Test
    public void testCheckCostAll() {
        Robot buddy = new Robot("buddy", age);
        assertEquals(expected, buddy.checkCost(), 0);
    }
}
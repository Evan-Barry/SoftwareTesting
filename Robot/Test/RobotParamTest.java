import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)

public class RobotParamTest {

    private String expected;
    private int age;

    public RobotParamTest(String expected, int age)
    {
        this.expected = expected;
        this.age = age;
    }

    @Parameterized.Parameters (name= "{index}: checkAge({1})={0}")
    public static Collection<Object[]> getTestParameters() {
        return Arrays.asList(new Object[][] {
                {"Age ok", 10},
                {"Age ok" , 20},
                {"Too old", 25},
        });
    }

    @Test
    public void testCheckAgeAll() {
        Robot buddy = new Robot("buddy", age);
        assertEquals(expected, buddy.checkAge() );

    }

}
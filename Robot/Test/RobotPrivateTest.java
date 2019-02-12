import static org.junit.Assert.*;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import static org.junit.Assert.*;

public class RobotPrivateTest {

    /**
     * Accessing a private member
     * Test of age member, of class Robot.
     */

    @Test
    public void testSetAge() throws Exception {
        System.out.println("testsetAge");
        Robot target = new Robot("robbie", 5);
        Class secretClass = target.getClass();

        /*Retrieve the field age */
        Field f = secretClass.getDeclaredField("age");

        /* make sure the field is accessible. */
        f.setAccessible(true);

        /* get the value of the field */
        System.out.println("The value in f (age) is " + f.get(target));

        int result =  f.getInt(target);
        assertEquals("The ages should be equal", 5,  result);
    }






    /**
     * Accessing a private member
     * Test of setAge method, of class robot.
     */

    @Test
    public void testSetAge1() throws Exception {
        System.out.println("setAge1");
        /* Set up a new Robot */
        Robot target = new Robot("robbie", 3);

        /* get the setAge method details */
        Method method = Robot.class.getDeclaredMethod("setAge", int.class);

        /* make the method assessible */
        method.setAccessible(true);

        /* invoke the method setAge with the value 7 */
        method.invoke(target, 7);

        /*access the field age and check its value is set to 7*/
        Class secretClass = target.getClass();

        Field f = secretClass.getDeclaredField("age");

        f.setAccessible(true);

        int result =  f.getInt(target);
        System.out.println("The value in f (age) is " + f.get(target));
        assertEquals("The ages should be equal", 7,  result);
    }
}

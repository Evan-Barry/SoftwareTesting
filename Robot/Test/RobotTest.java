import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.concurrent.TimeoutException;

import static org.junit.Assert.*;


public class RobotTest {

    @Rule
    public Timeout globalTimeout = Timeout.millis(5000);

    Robot buddy = new Robot("Buddy", 4);

    @Test
    public void testGetName()
    {
        assertEquals("Buddy", buddy.getName());
    }

    @Test
    public void testGetAge()
    {
        assertEquals(4, buddy.getAge());
    }

    @Test
    public void testIsNotWorking()
    {
        assertEquals(false, buddy.isWorking());
    }

    @Test
    public void testIsWorking()
    {
        buddy.talkToRobot();
        assertEquals(true, buddy.isWorking());
    }

    @Test
    public void testGetWorkingMessage()
    {
        buddy.talkToRobot();
        assertEquals("I am in working mode", buddy.getWorkingMessage());
    }

    @Test (expected = IllegalStateException.class)
    public void testGetWorkingMessageFail()
    {
        assertEquals("I am in working mode", buddy.getWorkingMessage());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetNameFail()
    {
        Robot chuck = new Robot("", 3);
        //assertEquals("", chuck.getName());
    }

    @Test (timeout = 300) //milliseconds
    public void testWaitTilWorking()
    {
        buddy.waitTilWorking();
    }

}
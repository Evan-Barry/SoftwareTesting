import org.junit.Test;

import static org.junit.Assert.*;

public class DriverTest {

    Driver d = new Driver("Dan", 12345);

    @Test
    public void testGetDriverNum()
    {
        assertEquals(12345, d.getDriverNum());
    }

    @Test
    public void testGetDriverName()
    {
        assertEquals("Dan", d.getDriverName());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testDriverNumFail()
    {
        Driver m = new Driver("Mary", 10);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testDriverNameFail()
    {
        Driver t = new Driver("", 300);
    }

    @Test
    public void testIsNotBanned()
    {
        assertEquals(false, d.check_status());
    }

    @Test (timeout = 100)
    public void testWaitTillBanned()
    {
        d.waitTillbanned();
    }

    @Test
    public void testGetToString()
    {
        assertEquals("\nDriver Name: "+d.getDriverName()+"\nDriver Number: "+d.getDriverNum(), d.toString());
    }

}
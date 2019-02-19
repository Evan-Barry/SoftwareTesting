import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class DriverScreenOutputTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStream()
    {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void testNumberValidMsg() throws IOException
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        Driver dan = new Driver("Dan", 4000);
        dan.checkNumberValid();
        baos.flush();
        String whatWasPrinted = new String(baos.toByteArray());
        String[] linesOfOutput = whatWasPrinted.split(
                System.getProperty("line.separator"));
        assertEquals("Driver number valid", linesOfOutput[0]);
    }

    @Test
    public void testNumberNotValidMsg() throws IOException
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        Driver dan = new Driver("Dan", 6000);
        dan.checkNumberValid();
        baos.flush();
        String whatWasPrinted = new String(baos.toByteArray());
        String[] linesOfOutput = whatWasPrinted.split(
                System.getProperty("line.separator"));
        assertEquals("Error Driver number not valid", linesOfOutput[0]);
    }

    @After
    public void cleanUpStream()
    {
        System.setOut(null);
        System.setErr(null);
    }
}
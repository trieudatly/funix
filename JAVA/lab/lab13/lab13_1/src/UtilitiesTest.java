import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class UtilitiesTest {

    @org.junit.Test
    public void everyNthChar() {
        fail("This test has not been implemented");
    }

    @org.junit.Test
    public void removePairs() {
        // fail("This test has not been implemented");
        Utilities util = new Utilities();
        assertEquals("ABCDEF", util.removePairs("AABBCDDEFF"));
        assertEquals("ABCABDEF", util.removePairs("ABCABDDEEF"));
    }

    @org.junit.Test
    public void converter() {
        fail("This test has not been implemented");
    }

    @org.junit.Test
    public void nullIfOddLength() {
        fail("This test has not been implemented");
    }
}
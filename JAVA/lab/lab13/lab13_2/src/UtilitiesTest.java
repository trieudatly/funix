import static org.junit.Assert.*;

public class UtilitiesTest {

    @org.junit.Test
    public void everyNthChar() {
        Utilities utils = new Utilities();
        char[] output = utils.everyNthChar(new char[]{'h', 'e', 'l', 'l', 'o'}, 2);
        //System.out.println(Arrays.toString(output));
        assertArrayEquals(new char[]{'e', 'l'}, output);
        char[] output2 = utils.everyNthChar(new char[]{'h', 'e', 'l', 'l', 'o'}, 8);
        assertArrayEquals(new char[]{'h', 'e', 'l', 'l', 'o'}, output2);

    }

    @org.junit.Test
    public void removePairs() {
        // fail("This test has not been implemented");
        Utilities util = new Utilities();
        assertEquals("ABCDEF", util.removePairs("AABBCDDEFF"));
        assertEquals("ABCABDEF", util.removePairs("ABCABDDEEF"));
        assertNull("Did not get null returned when argument passed was null", util.removePairs(null));
        assertEquals("A", util.removePairs("A"));
        assertEquals("", util.removePairs(""));
    }

    @org.junit.Test
    public void converter() {
        Utilities util = new Utilities();
        assertEquals(300, util.converter(10, 5));
    }

    @org.junit.Test
    public void nullIfOddLength() {
        Utilities util = new Utilities();
        assertNull(util.nullIfOddLength("odd"));
        assertNotNull(util.nullIfOddLength("even"));
    }
}
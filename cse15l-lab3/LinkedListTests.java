import static org.junit.Assert.*;
import org.junit.*;

public class LinkedListTests {
    @Test
    public void testPrepend() {
        LinkedList test = new LinkedList();
        test.prepend(2);
        test.prepend(1);
        test.prepend(0);
        assertEquals("0 1 2 ", test.toString());
    }

    @Test
    public void testAppend() {
        LinkedList test = new LinkedList();
        test.append(0);
        test.append(1);
        test.append(2);
        assertEquals("0 1 2 ", test.toString());
    }

    @Test 
    public void testFirstAndLast() {
        LinkedList test = new LinkedList();
        test.append(0);
        test.append(1);
        test.append(2);
        assertEquals(0, test.first());
        assertEquals(2, test.last());
    }

    @Test 
    public void testLength() {
        LinkedList test = new LinkedList();
        test.append(0);
        test.append(1);
        test.append(2);
        assertEquals(3, test.length());
    }
}
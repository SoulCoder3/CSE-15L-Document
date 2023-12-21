import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;
import java.util.List;

public class ListTests {
    @Test
    public void testFilter1() {
        List<String> test = new ArrayList<>();
        test.add("ssoss");
        test.add("qqqqq");
        test.add("abcdefg");
        List<String> result = ListExamples.filter(test, checker);
        List<String> exception = new ArrayList<>();
        exception.add("qqqqq");
        exception.add("abcdefg");
        assertEquals(exception, result);
    }

    @Test
    public void testFilter2() {
        List<String> test = new ArrayList<>();
        test.add("ssoss");
        test.add("qqqqq");
        List<String> result = ListExamples.filter(test, checker);
        List<String> exception = new ArrayList<>();
        exception.add("qqqqq");
        assertEquals(exception, result);
    }

    public StringChecker checker = (str) -> {
        if (str.contains("o"))
            return false;
        return true;
    };

    /*
     * @Test
     * public void testMerge() {
     * List<String> test1 = new ArrayList<>();
     * test1.add("12");
     * test1.add("56");
     * test1.add("78");
     * List<String> test2 = new ArrayList<>();
     * test2.add("34");
     * test2.add("78");
     * test2.add("aa");
     * List<String> test3 = ListExamples.merge(test1, test2);
     * List<String> expect = new ArrayList<>();
     * expect.add("12");
     * expect.add("34");
     * expect.add("56");
     * expect.add("78");
     * expect.add("78");
     * expect.add("aa");
     * assertEquals(expect, test3);
     * }
     */
}
import static org.junit.Assert.*;
import org.junit.*;
import java.util.Arrays;
import java.util.List;

class IsMoon implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("moon");
  }
}

public class TestListExamples {
  @Test(timeout = 500)
  public void testMergeRightEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testFliter() {
    List<String> test = Arrays.asList("a", "b", "moon");
    List<String> result = ListExamples.filter(test, new IsMoon());
    List<String> expected = Arrays.asList("moon");
    assertEquals(expected, result);
  }

  @Test(timeout = 500)
  public void testMerge() {
    List<String> left = Arrays.asList("1", "2", "5");
    List<String> right = Arrays.asList("3", "6");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("1", "2", "3", "5", "6");
    assertEquals(expected, merged);
  }
}
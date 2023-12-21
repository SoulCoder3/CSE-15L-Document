import static org.junit.Assert.*;
import org.junit.*;

public class ArrayTests {
	@Test 
	public void testReverseInPlace() {
    int[] input1 = { 3 };
    int[] input2 = {1, 2, 3, 4, 5};
    ArrayExamples.reverseInPlace(input1);
    ArrayExamples.reverseInPlace(input2);
    assertArrayEquals(new int[]{ 3 }, input1);
    assertArrayEquals(new int[]{5, 4, 3, 2, 1}, input2);
	}


  @Test
  public void testReversed() {
    int[] input1 = {1, 2, 3, 4, 5 };
    assertArrayEquals(new int[]{5, 4, 3, 2, 1 }, ArrayExamples.reversed(input1));
  }

  @Test
  public void testAverageWithoutLowest() {
	    double[] input1 = {2, 2, 3, 5, 6, 7, 12, 7};
      double[] input2 = {7, 7, 7, 7, 7, 7, 7};
	    double average = ArrayExamples.averageWithoutLowest(input1);
      double average2 = ArrayExamples.averageWithoutLowest(input2);
	    assertEquals(6.0, average, 0.00);
      assertEquals(7.0, average2, 0.0);
  }
}

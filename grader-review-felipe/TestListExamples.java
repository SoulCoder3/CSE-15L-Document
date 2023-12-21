import static org.junit.Assert.*;
import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class IsMoon implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("moon");
  }
}

class PalindromeChecker implements StringChecker {

    @Override
    public boolean checkString(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }

}

public class TestListExamples {
  
  @Test(timeout=500)
  public void testFilterMultiple(){
  
    List<String> input = new ArrayList<>();
    input.add("aba");
    input.add("acca");

    List<String> expected = new ArrayList<>();
    expected.add("aba");
    expected.add("acca");
    
    assertEquals(expected, ListExamples.filter(input, new PalindromeChecker()));
    
  }

  @Test(timeout=500)
  public void testFilterNomatch(){

    List<String> input = new ArrayList<>();
    input.add("aaron");
    input.add("brian");
    input.add("david");
    
    List<String> expected = new ArrayList<>();
    
    assertEquals(expected, ListExamples.filter(input, new IsMoon()));
    
  }
  
  @Test(timeout=500)
  public void testFilterEmpty(){
    
    List<String> input = new ArrayList<>();
    
    List<String> expected = new ArrayList<>();

    assertEquals(expected, ListExamples.filter(input, new IsMoon()));
    
  }

  @Test(timeout=500)
  public void testFilterLarge(){

    List<String> input = new ArrayList<>();
    for(int i = 0; i < 100000; i++){
      input.add("moon");
    }

      List<String> expected = new ArrayList<>();
      for(int i = 0; i < 100000; i++){
        expected.add("moon");
      }
      
      assertEquals(expected, ListExamples.filter(input, new IsMoon()));
    }
    
    @Test(timeout=500)
    public void testMergeLater(){
      
      
      List<String> input = new ArrayList<>();
      input.add("aaron");
      input.add("brian");
      input.add("david");
      
      List<String> input2 = new ArrayList<>();
      input2.add("denice");
      input2.add("fred");
      
      List<String> expected = new ArrayList<>();
    expected.add("aaron");
    expected.add("brian");
    expected.add("david");
    expected.add("denice");
    expected.add("fred");
    
    assertEquals(expected, ListExamples.merge(input, input2));
  }

  @Test(timeout = 500)
  public void testMergeRightEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }
  
  @Test(timeout = 500)
  public void testMergeEmpty(){

    List<String> input = new ArrayList<>();
    
    List<String> input2 = new ArrayList<>();
    
    List<String> expected = new ArrayList<>();
    
    assertEquals(expected, ListExamples.merge(input, input2));

  }

  @Test(timeout = 500)
  public void testMergeSorted() {
    
    List<String> left = Arrays.asList("a", "b", "c");

    List<String> right = Arrays.asList("d", "e", "e", "f");

    List<String> expected = Arrays.asList("a", "b", "c", "d", "e", "e", "f");

    assertEquals(expected, ListExamples.merge(left, right));
  }

  @Test(timeout = 500)
  public void testMergeInverted(){

    List<String> left = Arrays.asList("d", "e", "e", "f");

    List<String> right = Arrays.asList("a", "b", "c");

    List<String> expected = Arrays.asList("a", "b", "c", "d", "e", "e", "f");

    assertEquals(expected, ListExamples.merge(left, right));

  }
}





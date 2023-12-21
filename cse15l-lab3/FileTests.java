import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.File;

public class FileTests {
    @Test
    public void testFilter() throws IOException {
        File test = new File("some-files/");
        List<File> result = new ArrayList<>();
        result = FileExample.getFiles(test, result);
        List<File> expect = new ArrayList<>();
        expect.add(new File("some-files/even-more-files/d.java"));
        expect.add(new File("some-files/even-more-files/a.txt"));
        expect.add(new File("some-files/more-files/c.java"));
        expect.add(new File("some-files/more-files/b.txt"));
        expect.add(new File("some-files/a.txt"));
        assertEquals(expect, result);
    }
}
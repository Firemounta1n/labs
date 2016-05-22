import com.Lab_1.Paginator;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.*;

public class TestClass {
    @Test
    public void testLeftEdge() throws Exception {
        Paginator paginator = new Paginator();
        List<Integer> testList = Arrays.asList(1, 2, 0, 10);
        assertEquals(paginator.getList(1, 10), testList);
    }

    @Test
    public void testRightEdge() throws Exception {
        Paginator paginator = new Paginator();
        List<Integer> testList = Arrays.asList(1, 0, 9, 10);
        assertEquals(paginator.getList(10, 10), testList);
    }

    @Test
    public void testSecondPage() throws Exception {
        Paginator paginator = new Paginator();
        List<Integer> testList = Arrays.asList(1, 2, 3, 0, 10);
        assertEquals(paginator.getList(2, 10), testList);
    }

    @Test
    public void testPrelastPage() throws Exception {
        Paginator paginator = new Paginator();
        List<Integer> testList = Arrays.asList(1, 0, 8, 9, 10);
        assertEquals(paginator.getList(9, 10), testList);
    }

    @Test
    public void testEmptyPages() throws Exception {
        Paginator paginator = new Paginator();
        List<Integer> testList = Arrays.asList();
        assertEquals(paginator.getList(5, 0), testList);
    }

    @Test
    public void testOutOfEdgeRight() throws Exception {
        Paginator paginator = new Paginator();
        List<Integer> testList = Arrays.asList(1, 0, 9, 10);
        assertEquals(paginator.getList(11, 10), testList);
    }

    @Test
    public void testOutOfEdgeLeft() throws Exception {
        Paginator paginator = new Paginator();
        List<Integer> testList = Arrays.asList(1, 2, 0, 10);
        assertEquals(paginator.getList(0, 10), testList);
    }
}

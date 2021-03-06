import com.Lab_1.Paginator;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.*;

public class TestClass {
    @Test
    public void testLeftEdge() throws Exception {
        Paginator paginator = new Paginator();
        List<Integer> testList = Arrays.asList(1, 2, 3, 4, 5, 0, 20);
        assertEquals(paginator.getList(1, 20, 5), testList);
    }

    @Test
    public void testRightEdge() throws Exception {
        Paginator paginator = new Paginator();
        List<Integer> testList = Arrays.asList(1, 0, 13, 14, 15, 16, 17, 18, 19, 20);
        assertEquals(paginator.getList(20, 20, 7), testList);
    }

    @Test
    public void testSecondPage() throws Exception {
        Paginator paginator = new Paginator();
        List<Integer> testList = Arrays.asList(1, 2, 3, 0, 20);
        assertEquals(paginator.getList(2, 20, 3), testList);
    }

    @Test
    public void testThirdPage() throws Exception {
        Paginator paginator = new Paginator();
        List<Integer> testList = Arrays.asList(1, 2, 3, 4, 5, 0, 20);
        assertEquals(paginator.getList(3, 20, 5), testList);
    }

    @Test
    public void testFourthPage() throws Exception {
        Paginator paginator = new Paginator();
        List<Integer> testList = Arrays.asList(1, 2, 3, 4, 5, 6, 0, 20);
        assertEquals(paginator.getList(4, 20, 5), testList);
    }

    @Test
    public void testCenterPage() throws Exception {
        Paginator paginator = new Paginator();
        List<Integer> testList = Arrays.asList(1, 0, 8, 9, 10, 11, 12, 0, 20);
        assertEquals(paginator.getList(10, 20, 5), testList);
    }

    @Test
    public void testPrelastPage() throws Exception {
        Paginator paginator = new Paginator();
        List<Integer> testList = Arrays.asList(1, 0, 7, 8, 9, 10);
        assertEquals(paginator.getList(9, 10, 3), testList);
    }

    @Test
    public void testEmptyPages() throws Exception {
        Paginator paginator = new Paginator();
        List<Integer> testList = Arrays.asList();
        assertEquals(paginator.getList(5, 0, 3), testList);
    }

    @Test
    public void testOutOfEdgeRight() throws Exception {
        Paginator paginator = new Paginator();
        List<Integer> testList = Arrays.asList(1, 0, 8, 9, 10);
        assertEquals(paginator.getList(11, 10, 3), testList);
    }

    @Test
    public void testOutOfEdgeLeft() throws Exception {
        Paginator paginator = new Paginator();
        List<Integer> testList = Arrays.asList(1, 2, 3, 0, 10);
        assertEquals(paginator.getList(0, 10, 3), testList);
    }
}

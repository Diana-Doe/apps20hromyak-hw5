package ua.edu.ucu;

import ua.edu.ucu.stream.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author andrii
 */
public class StreamAppTest {
    
    private IntStream intStream;

    @Before
    public void init() {
        int[] intArr = {-1, 0, 1, 2, 3};
        intStream = AsIntStream.of(intArr);
    }
    
    @Test
    public void testStreamOperations() {
        System.out.println("streamOperations");
        int expResult = 42;
        int result = StreamApp.streamOperations(intStream);
        assertEquals(expResult, result);        
    }

    @Test
    public void testStreamToArray() {
        System.out.println("streamToArray");
        int[] expResult = {-1, 0, 1, 2, 3};
        int[] result = StreamApp.streamToArray(intStream);
        assertArrayEquals(expResult, result);        
    }

    @Test
    public void testStreamForEach() {
        System.out.println("streamForEach");
        String expResult = "-10123";
        String result = StreamApp.streamForEach(intStream);
        assertEquals(expResult, result);
    }

    @Test
    public void testMax() {
        System.out.println("max");
        Integer expResult = 3;
        Integer result = intStream.max();
        assertEquals(expResult, result);
    }

    @Test
    public void testMin() {
        System.out.println("min");
        Integer expResult = -1;
        Integer result = intStream.min();
        assertEquals(expResult, result);
    }

    @Test
    public void testSum() {
        System.out.println("sum");
        Integer expResult = 5;
        Integer result = intStream.sum();
        assertEquals(expResult, result);
    }

    @Test
    public void testAverage() {
        System.out.println("average");
        Double expResult = 1.0;
        Double result = intStream.average();
        assertEquals(expResult, result, 0.0001);
    }
    
}

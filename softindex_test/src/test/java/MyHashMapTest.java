import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Neo on 21.08.2017.
 */
public class MyHashMapTest {

    @Test
    public void testInsertKeysWithMod128is1() {
        MyHashMap map = new MyHashMap();
        map.put(129, 0);
        map.put(1, 1);
        assertEquals(0L, (long) map.get(129));
        assertEquals(1L, (long) map.get(1));
    }

    @Test
    public void testKeyPositiveAndNegativevalues() {
        MyHashMap map = new MyHashMap();
        map.put(-1, 33);
        map.put(1, 323);
        assertEquals(33L, (long) map.get(-1));
        assertEquals(323L, (long) map.get(1));
    }

    @Test
    public void testSize() throws Exception {
        MyHashMap map = new MyHashMap();
        map.put(1,5645);
        map.put(2,1989);
        assertEquals(2,map.getSize());
    }
    @Test
    public void testSizeWithSameKeys() throws Exception {
        MyHashMap map = new MyHashMap();
        map.put(1,1337);
        map.put(1,1564);
        map.put(2,1989);
        map.put(2,56464);
        assertEquals(2,map.getSize());
    }


    @Test
    public void maxIndexValue() {
        MyHashMap map = new MyHashMap(3000);
        for (int i = 0; i <= 2999; i++) {
            map.put(i, 333 + i);
        }
        assertEquals(3332,(long)map.get(2999));
    }
    @Test
    public void testMaxIntValueAsIndex() {
        MyHashMap map = new MyHashMap();

        map.put(Integer.MAX_VALUE+1, 123L);
        assertEquals(123L, (long)map.get(Integer.MAX_VALUE+1));
    }
    @Test
    public void testMaxLongValueAsValue() {
        MyHashMap map = new MyHashMap();
        map.put(1, Long.MAX_VALUE);
        assertEquals(Long.MAX_VALUE, (long)map.get(1));
    }

}
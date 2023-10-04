package Zimu_Su_Question_C;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

public class Zimu_Su_Question_C_Tests {
    @Test
    public void put_less_than_capacity() {
        LRUCache cache = new LRUCache(5);

        cache.put(new Node(0, 0));
        cache.put(new Node(1, 1));
        cache.put(new Node(2, 2));

        assertEquals(3, cache.getSize());
        assertEquals(0, cache.getHead());
        assertEquals(2, cache.getTail());
        assertEquals(0, cache.get(0));
        assertEquals(1, cache.get(1));
        assertEquals(2, cache.get(2));
    }

    @Test
    public void put_more_than_capacity() {
        LRUCache cache = new LRUCache(2);

        cache.put(new Node(0, 0));
        cache.put(new Node(1, 1));
        cache.put(new Node(2, 2));

        assertEquals(2, cache.getSize());
        assertEquals(1, cache.getHead());
        assertEquals(2, cache.getTail());
    }

    @Test
    public void get_updates_order() {
        LRUCache cache = new LRUCache(5);

        cache.put(new Node(0, 0));
        cache.put(new Node(1, 1));
        cache.put(new Node(2, 2));
        cache.get(1);

        assertEquals(3, cache.getSize());
        assertEquals(0, cache.getHead());
        assertEquals(1, cache.getTail());
    }

    @Test
    public void get_updates_order_of_head() {
        LRUCache cache = new LRUCache(5);

        cache.put(new Node(0, 0));
        cache.put(new Node(1, 1));
        cache.put(new Node(2, 2));
        cache.get(0);

        assertEquals(3, cache.getSize());
        assertEquals(1, cache.getHead());
        assertEquals(0, cache.getTail());
    }

    @Test
    public void get_not_update_order_of_tail() {
        LRUCache cache = new LRUCache(5);

        cache.put(new Node(0, 0));
        cache.put(new Node(1, 1));
        cache.put(new Node(2, 2));
        cache.get(2);

        assertEquals(3, cache.getSize());
        assertEquals(0, cache.getHead());
        assertEquals(2, cache.getTail());
    }

    @Test
    public void combination_of_get_and_put() {
        LRUCache cache = new LRUCache(5);

        cache.put(new Node(0, 0));
        cache.put(new Node(1, 1));
        cache.put(new Node(2, 2));
        cache.get(1);
        cache.put(new Node(3, 3));
        cache.put(new Node(4, 4));
        cache.get(0);
        cache.put(new Node(5, 5));
        cache.put(new Node(6, 6));

        assertEquals(5, cache.getSize());
        assertEquals(3, cache.getHead());
        assertEquals(6, cache.getTail());
    }

    @Test
    public void expire() {
        LRUCache cache = new LRUCache(5);

        cache.put(new Node(0, 0));
        cache.put(new Node(1, 1));
        cache.put(new Node(2, 2, 100));

        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertEquals(3, cache.getSize());
        assertEquals(-1, cache.get(2));
        assertEquals(1, cache.getTail());
    }
}

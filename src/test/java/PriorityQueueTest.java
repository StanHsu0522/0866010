import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.PriorityQueue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PriorityQueueTest {

    private static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of(new int[]{2, 3, 1}, new int[]{2, 1, 3}),
                Arguments.of(new int[]{4, 5, 6, 0, 2, 3}, new int[]{0, 2, 3, 4, 5, 6}),
                Arguments.of(new int[]{0}, new int[]{0}),
                Arguments.of(new int[]{11, 12234567, 1235134645, 621345634},
                        new int[]{11, 12234567, 621345634, 1235134645}),
                Arguments.of(new int[]{-5, -100, 55}, new int[]{-100, -5, 55})
        );
    }

    @ParameterizedTest(name = "#{index} - Test with Argument={arguments}")
    @MethodSource("provider")
//    @Order(1)
    public void PriorityQueue_RunTest(int[] inputted_arr, int[] expected_arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(inputted_arr.length);
        for (int i : inputted_arr) {
            pq.add(i);
        }
        for(int i : expected_arr) {
            assertEquals(i, pq.poll());
        }
    }

//    @Test
//    @Order(2)
//    public void whenExceptionThrown_thenAddNull() {
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        Exception ex = assertThrows(NullPointerException.class, ()-> pq.add(null));
//        assertNull(ex.getMessage());
//    }
//
//    @Test
//    @Order(3)
//    public void whenExceptionThrown_thenInitialCapacityLessThan1() {
//        Exception ex = assertThrows(IllegalArgumentException.class, ()->{
//            PriorityQueue<Integer> pq = new PriorityQueue<>(-1);
//        });
//        assertNull(ex.getMessage());
//    }
//
//    @Test
//    @Order(4)
//    public void whenExceptionThrown_thenOfferNull() {
//        Exception ex = assertThrows(NullPointerException.class, ()->{
//            PriorityQueue<String> pq = new PriorityQueue<>();
//            pq.offer(null);
//        });
//        assertNull(ex.getMessage());
//    }
}

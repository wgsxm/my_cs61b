import static org.junit.Assert.*;

import org.junit.Test;

public class TestArrayDequeGold {
    @Test
    public void someTest() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> sad2 = new ArrayDequeSolution<>();
        String message = "";
        int size = 0;
        for (int i = 0; ; i++) {
            double numberBetweenZeroAndOne = StdRandom.uniform();
            if (numberBetweenZeroAndOne < 0.5) {
                message += "addFirst(" + (char) ('0' + i) + ")\n";
                sad1.addFirst(i);
                sad2.addFirst(i);
                size++;
            } else if (numberBetweenZeroAndOne > 0.5) {
                if (size > 0) {
                    int a = sad1.removeFirst();
                    int b = sad2.removeFirst();
                    message += "removeFirst()\n";
                    assertEquals(message, a, b);
                    size--;
                }
            }
        }
    }


}

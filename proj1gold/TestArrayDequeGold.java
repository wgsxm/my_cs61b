import static org.junit.Assert.*;

import org.junit.Test;

public class TestArrayDequeGold {
    @Test
    public void someTest() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> sad2 = new ArrayDequeSolution<>();
        String message = "";
        for (int i = 0; ; i++) {
            double numberBetweenZeroAndOne = StdRandom.uniform();
            if (numberBetweenZeroAndOne < 0.25) {
                message += "addFirst(" +  i + ")\n";
                sad1.addFirst(i);
                sad2.addFirst(i);
                assertEquals(message,sad1.get(0),sad2.get(0));
            }else if(numberBetweenZeroAndOne>0.25&&numberBetweenZeroAndOne<0.5){
                message += "addLast(" +  i + ")\n";
                sad1.addLast(i);
                sad2.addLast(i);
                assertEquals(message,sad1.get(sad1.size()-1),sad2.get(sad2.size()-1));
            }else if(numberBetweenZeroAndOne>0.5&&numberBetweenZeroAndOne<0.75){
                if (sad1.size() > 0) {
                    message += "removeLast()\n";
                    assertEquals(message, (int) sad1.removeLast(), (int) sad2.removeLast());
                }
            }
            else if (numberBetweenZeroAndOne > 0.75) {
                if (sad1.size() > 0) {
                    message += "removeFirst()\n";
                    assertEquals(message, (int) sad1.removeFirst(), (int) sad2.removeFirst());
                }
            }
        }
    }

}

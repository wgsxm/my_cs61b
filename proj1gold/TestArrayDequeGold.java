import static org.junit.Assert.*;

import org.junit.Test;

public class TestArrayDequeGold {
    @Test
    public void someTest() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> sad2 = new ArrayDequeSolution<>();
        int size = 0;
        for (int i = 0; ; i++) {
            double numberBetweenZeroAndOne = StdRandom.uniform();
            if (numberBetweenZeroAndOne < 0.5) {
                sad1.addFirst(i);
                sad2.addFirst(i);
                size++;
            } else if (numberBetweenZeroAndOne > 0.75) {
                if (size > 0) {
                    assertEquals((int) sad1.removeFirst(), (int) sad2.removeLast());
                    size--;
                }
            }
        }
    }
    @Test
    public void testStudentArrayDeque(){
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        int size=0;
        String message="";
        String check="";
        while(true)
        {
            double numberBetweenZeroAndOne = StdRandom.uniform();
            int randomNumber = StdRandom.uniform(0,10);

            if(numberBetweenZeroAndOne<0.5)
            {
                message+="addFirst("+(char)('0'+randomNumber)+")\n";
                check+=(char)('0'+randomNumber);
                size++;
                sad.addFirst(randomNumber);
            }
            else {
                if(size>0){
                    size--;
                    int answer=check.charAt(0)-'0';
                    check=check.substring(1);
                    message+="removeFirst()\n";
                    int temp=sad.removeFirst();
                    assertEquals(message,answer,temp);
                }
            }
        }
    }
}

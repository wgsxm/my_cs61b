import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testequalChars0(){
        assertTrue(offByOne.equalChars('a','b'));
    }
    @Test
    public void testequalChars1(){
        assertFalse(offByOne.equalChars('a','a'));
    }
    @Test
    public void testequalChars2(){
        assertTrue(offByOne.equalChars('b','a'));
    }
    @Test
    public void testequalChars3(){
        assertFalse(offByOne.equalChars('a','B'));
    }
}

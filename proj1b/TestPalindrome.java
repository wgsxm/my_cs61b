import org.junit.Test;

import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testisPalindrome0() {
        assertTrue(palindrome.isPalindrome(""));
    }

    @Test
    public void testisPalindrome1() {
        assertFalse(palindrome.isPalindrome("cat"));
    }

    @Test
    public void testisPalindrome2() {
        assertTrue(palindrome.isPalindrome("A"));
    }

    @Test
    public void testisPalindrome3() {
        assertTrue(palindrome.isPalindrome("AA"));
    }

    @Test
    public void testisPalindrome4() {
        assertFalse(palindrome.isPalindrome("Aa"));
    }

    static OffByOne cc = new OffByOne();

    @Test
    public void testisPalindrome5() {
        assertTrue(palindrome.isPalindrome("a", cc));
    }

    @Test
    public void testisPalindrome6() {
        assertTrue(palindrome.isPalindrome("ab", cc));
    }

    @Test
    public void testisPalindrome7() {
        assertTrue(palindrome.isPalindrome("aab", cc));
    }

    @Test
    public void testisPalindrome8() {
        assertFalse(palindrome.isPalindrome("aa", cc));
    }

    @Test
    public void testisPalindrome9() {
        assertTrue(palindrome.isPalindrome("ba", cc));
    }

}

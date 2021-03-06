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
    public void testisPalindrome() {
        assertTrue(palindrome.isPalindrome("noon"));
        assertFalse(palindrome.isPalindrome("nooN"));
        assertTrue(palindrome.isPalindrome("cc"));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("refer"));
        assertTrue(palindrome.isPalindrome(""));

        CharacterComparator cc = new OffByOne();
        assertFalse(palindrome.isPalindrome("noon", cc));
        assertTrue(palindrome.isPalindrome("a", cc));
        assertTrue(palindrome.isPalindrome("%&", cc));
        assertTrue(palindrome.isPalindrome("flake", cc));
        assertFalse(palindrome.isPalindrome("fLake", cc));
        assertTrue(palindrome.isPalindrome(""));


        CharacterComparator dd = new OffByN(4);
        assertFalse(palindrome.isPalindrome("noon", dd));
        assertTrue(palindrome.isPalindrome("a", dd));
        assertTrue(palindrome.isPalindrome("ae", dd));
        assertTrue(palindrome.isPalindrome("flapj", dd));
        assertFalse(palindrome.isPalindrome("Flapi", dd));
        assertTrue(palindrome.isPalindrome(""));

    }
}

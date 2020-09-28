package com.gorban.interviewprep;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class StringsSolutionsTest {

    StringsSolutions stringsSolutions = new StringsSolutions();

    @Test
    void isUnique() {
        String strWithUniqueChars = "abcdefgh";
        String strWithDuplicatedChars = "abbcddeffghh";
        assertTrue(stringsSolutions.isUniqueChars(strWithUniqueChars));
        assertFalse(stringsSolutions.isUniqueChars(strWithDuplicatedChars));
    }

    @Test
    void sort() {
        String unsortedStr = "zaxbyc";
        String sortedStr = "abcxyz";
        assertEquals(sortedStr, stringsSolutions.sort(unsortedStr));
    }

    @Test
    void isPermutatated() {
        String initialStr = "dog";
        String permutatedStr = "god";
        assertTrue(stringsSolutions.isPermutatated(initialStr, permutatedStr));
    }

    @Test
    void isPermutated2() {
        String initialStr = "dog";
        String permutatedStr = "god";
        assertTrue(stringsSolutions.isPermutated2(initialStr, permutatedStr));
    }

    @Test
    void checkStringsPool(){
        String strLiteral = "string literal will be stored in the string pool";
        String strLiteral2 = "string literal will be stored in the string pool";
        assertTrue(strLiteral == strLiteral2);
        assertEquals(strLiteral, strLiteral2);
        String newStr = new String("new string instance will be stored in the heap");
        String newStr2 = new String("new string instance will be stored in the heap");
        assertFalse(newStr == newStr2);
        assertEquals(newStr,newStr2);
        assertTrue(newStr.intern() == newStr2.intern());
    }

    @Test
    void getPermutations() {
        String str = "ABC";
        Set<String> expectedPermutations = new HashSet<>(Arrays.asList("ACB, BCA, ABC, CBA, BAC, CAB"));
        Set<String> permutations = stringsSolutions.getPermutations(str);
        System.out.println(expectedPermutations);
        System.out.println(permutations);
    }

    @Test
    void reverseEachWord() {
        String str = "how to do in java dot com";
        String expectedStr = "woh ot od ni avaj tod moc";
        String reversed = stringsSolutions.reverseEachWord(str);
        assertEquals(expectedStr, reversed);
    }

    @Test
    void getCharsOccurrence() {
        String blogName = "howToDoInJava";
        HashMap<Character, Integer> expectedOccurrences = new HashMap<Character, Integer>();
        expectedOccurrences.put('a', 2);
        expectedOccurrences.put('T', 1);
        expectedOccurrences.put('D', 1);
        expectedOccurrences.put('v', 1);
        expectedOccurrences.put('w', 1);
        expectedOccurrences.put('h', 1);
        expectedOccurrences.put('I', 1);
        expectedOccurrences.put('J', 1);
        expectedOccurrences.put('n', 1);
        expectedOccurrences.put('o', 3);
        HashMap<Character, Integer> occurrencesMap = stringsSolutions.getCharsOccurrence(blogName);
        assertEquals(expectedOccurrences, occurrencesMap);
    }

    @Test
    void reverseStringWithRecursion() {
        String str = "howToDoInJava";
        String expectedReversedStr = "avaJnIoDoTwoh";
        String reversedStr = stringsSolutions.reverseStringWithRecursion(str);
        assertEquals(expectedReversedStr, reversedStr);
    }

    @Test
    void uRLifyString() {
        String usualStr = "Mr John Smith";
        String expectedUrlifiedStr = "Mr%20John%20Smith";
        String urlifiedStr = stringsSolutions.uRLifyString(usualStr);
        assertEquals(expectedUrlifiedStr, urlifiedStr);
    }

    @Test
    void isPermutationOfPalindrome() {
        String palindrome = "tacocat";
        assertTrue(stringsSolutions.isPermutationOfPalindrome(palindrome));
        String notPalindrome = "tacocati";
        assertFalse(stringsSolutions.isPermutationOfPalindrome(notPalindrome));
    }

    @Test
    void isOneWay() {
        assertTrue(stringsSolutions.isOneWay("pale", "ple"));
        assertTrue(stringsSolutions.isOneWay("pales", "pale"));
        assertTrue(stringsSolutions.isOneWay("pale", "bale"));
        assertFalse(stringsSolutions.isOneWay("pale", "bake"));
    }

    @Test
    void compressString() {
        String str = "aabcccccaaa";
        String expectedCompressedStr = "a2b1c5a3";
        assertEquals(expectedCompressedStr, stringsSolutions.compressString(str));
        assertEquals("abcdefgh", stringsSolutions.compressString("abcdefgh"));
    }

    @Test
    void isSubstring() {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        assertTrue(stringsSolutions.isSubstring(s1, s2));
    }

    @Test
    void reverseString() {
        char[] charArr = {'h','e','l','l','o'};
        char[] reversedCharArr = {'o','l','l','e','h'};
        stringsSolutions.reverseString(charArr);
        assertEquals(new String(reversedCharArr), new String(charArr));
    }

    @Test
    void reverseString2() {
        char[] charArr = {'H','a','n','n','a','h'};
        char[] reversedCharArr = {'h','a','n','n','a','H'};
        stringsSolutions.reverseString(charArr);
        assertEquals(new String(reversedCharArr), new String(charArr));
    }

    @Test
    void stringMatching() {
        String[] words = new String[]{"mass","as","hero","superhero"};
        List<String> expectedSubstrings = new ArrayList<>(Arrays.asList("as","hero"));
        List<String> substring = stringsSolutions.stringMatching(words);
        assertEquals(expectedSubstrings, substring);
    }

    @Test
    void stringMatching2() {
        String[] words = new String[]{"leetcode","et","code"};
        List<String> expectedSubstrings = new ArrayList<>(Arrays.asList("et","code"));
        List<String> substring = stringsSolutions.stringMatching(words);
        assertEquals(expectedSubstrings, substring);
    }

    @Test
    void stringMatching3() {
        String[] words = new String[]{"blue","green","bu"};
        List<String> expectedSubstrings = new ArrayList<>();
        List<String> substring = stringsSolutions.stringMatching(words);
        assertEquals(expectedSubstrings, substring);
    }

    @Test
    void stringMatching4() {
        String[] words = new String[]{"leetcoder","leetcode","od","hamlet","am"};
        List<String> expectedSubstrings = new ArrayList<>(Arrays.asList("leetcode","od","am"));
        List<String> substring = stringsSolutions.stringMatching(words);
        assertEquals(expectedSubstrings, substring);
    }

    @Test
    void compress2() {
        char[] charsArr = new char[]{'a'};
        char[] expectedCharsArr = new char[]{'a'};
        int expectedLength = 1;
        int length = stringsSolutions.compress(charsArr);
        assertEquals(expectedLength, length);
        assertTrue(Arrays.equals(expectedCharsArr, charsArr));
    }

    @Test
    void compress3() {
        char[] charsArr = new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        char[] expectedCharsArr = new char[]{'a','b','1','2','b','b','b','b','b','b','b','b','b'};
        int expectedLength = 4;
        int length = stringsSolutions.compress(charsArr);
        assertEquals(expectedLength, length);
        assertTrue(Arrays.equals(expectedCharsArr, charsArr));
    }

    @Test
    void firstUniqueChar() {
        assertEquals(0, stringsSolutions.firstUniqueChar("leetcode"));
        assertEquals(2, stringsSolutions.firstUniqueChar("loveleetcode"));
        assertEquals(-1, stringsSolutions.firstUniqueChar2("abab"));
    }

    @Test
    void isAnagram() {
        assertTrue(stringsSolutions.isAnagram("anagram", "nagaram"));
        assertFalse(stringsSolutions.isAnagram("rat", "car"));
    }

    @Test
    void isPalindrome() {
        assertTrue(stringsSolutions.isPalindrome("1b1"));
        assertTrue(stringsSolutions.isPalindrome(".,"));
        assertTrue(stringsSolutions.isPalindrome("a."));
        assertTrue(stringsSolutions.isPalindrome(""));
        assertTrue(stringsSolutions.isPalindrome(" "));
        assertTrue(stringsSolutions.isPalindrome("."));
        assertTrue(stringsSolutions.isPalindrome("A man, a plan, a canal: Panama"));
        assertFalse(stringsSolutions.isPalindrome("race a car"));
        assertFalse(stringsSolutions.isPalindrome("0P"));
    }
}
package com.gorban.interviewprep;

import java.util.*;

public class StringsSolutions {

    public boolean isUniqueChars(String str) {
        if (str.length() > 128) {
            return false;
        }

        boolean[] charSet = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (charSet[val]) {
                return false; // this char index is already exists, so the String contains duplicated characters
            } else {
                charSet[val] = true;
            }
        }
        return true;
    }

    public String sort(String str) {
        char[] charArr = str.toCharArray();
        Arrays.sort(charArr);
        return new String(charArr);
    }

    public boolean isPermutatated(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        return sort(str1).equals(sort(str2));
    }

    public boolean isPermutated2(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int[] letters = new int[128]; //assumption
        char[] charArray = str1.toCharArray();

        for (char c : charArray) {
            letters[c]++;
        }

        for (int i = 0; i < str2.length(); i++) {
            char c = str2.charAt(i);
            letters[c]--;

            if (letters.length < 0) {
                return false;
            }
        }

        return true;
    }

    public Set<String> getPermutations(String str) {
        Set<String> permutations = new HashSet<>();
        if (str == null || str.length() == 0) {
            permutations.add("");
        } else {
            char initialChar = str.charAt(0);
            String remainingStr = str.substring(1);

            Set<String> words = getPermutations(remainingStr);

            for (String word : words) {
                for (int i = 0; i <= word.length(); i++) {
                    permutations.add(placeCharAt(word, initialChar, i));
                }
            }
        }

        return permutations;
    }

    private String placeCharAt(String str, char character, int indexToPlace) {
        String begin = str.substring(0, indexToPlace);
        String end = str.substring(indexToPlace);
        return begin + character + end;
    }

    public String reverseEachWord(String str) {
        StringBuffer finalString = new StringBuffer();
        String[] strArr = str.split(" ");

        for (String word : strArr) {
            finalString.append(new StringBuffer(word).reverse());
            finalString.append(" ");
        }

        return finalString.toString().stripTrailing();
    }

    public HashMap<Character, Integer> getCharsOccurrence(String str) {
        HashMap<Character, Integer> occurrencesMap = new HashMap<>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (occurrencesMap.containsKey(c)) {
                occurrencesMap.put(c, occurrencesMap.get(c) + 1);
            } else {
                occurrencesMap.put(c, 1);
            }
        }
        return occurrencesMap;
    }

    public String reverseStringWithRecursion(String str) {
        String recursiveString = recursiveSwap(str);

        return recursiveString;
    }

    private String recursiveSwap(String str) {
        if (str == null || str.length() < 1) {
            return str;
        } else {
            return recursiveSwap(str.substring(1)) + str.charAt(0);
        }
    }

    public String uRLifyString(String str) {
        char[] spaceReplacementChars = new char[]{'%', '2', '0'};
        int spaceCounter = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                spaceCounter++;
            }
        }
        char[] resultCharsArray = new char[str.length() + (spaceCounter * 2)];

        int j = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                for (int k = 0; k < spaceReplacementChars.length; k++) {
                    resultCharsArray[j++] = spaceReplacementChars[k];
                }
            } else {
                resultCharsArray[j++] = str.charAt(i);
            }
        }

        return new String(resultCharsArray);
    }

    public boolean isPermutationOfPalindrome(String phrase) {
        int[] charFrequencyTable = buildCharFrequencyTable(phrase);
        return checkMaxOneOdd(charFrequencyTable);
    }

    private boolean checkMaxOneOdd(int[] table) {
        boolean oddIsFound = false;
        for (int num : table) {
            if (num % 2 == 1) {
                if (!oddIsFound) {
                    oddIsFound = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private int getCharNumericValue(Character c) {
        int begin = Character.getNumericValue('a');
        int end = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (val >= begin && val <= end) {
            return val - begin;
        } else return -1;
    }

    private int[] buildCharFrequencyTable(String phrase) {
        int[] charFrequencyTable = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (Character c : phrase.toCharArray()) {
            int charNumValue = getCharNumericValue(c);
            if (charNumValue != -1) {
                charFrequencyTable[charNumValue]++;
            }
        }
        return charFrequencyTable;
    }

    public boolean isOneWay(String initialStr, String editedStr) {
        if (editedStr.length() > initialStr.length() || editedStr.length() < initialStr.length() - 1) {
            return false;
        }
        int editsCounter = 0;
        for (Character c : initialStr.toCharArray()) {
            if (!editedStr.contains(c.toString())) {
                editsCounter++;
            }
        }

        return editsCounter == 1 ? true : false;
    }

    public String compressString(String str) {
        StringBuilder compressedStr = new StringBuilder();
        int charCounter = 0;
        for (int i = 0; i < str.length(); i++) {
            if (charCounter == 0) {
                compressedStr.append(str.charAt(i));
                charCounter++;
            } else if (str.charAt(i - 1) == str.charAt(i)) {
                charCounter++;
            } else if (str.charAt(i - 1) != str.charAt(i)) {
                compressedStr.append(charCounter);
                charCounter = 1;
                compressedStr.append(str.charAt(i));
            }
        }
        compressedStr.append(charCounter);

        return compressedStr.length() >= str.length() ? str : compressedStr.toString();
    }

    public boolean isSubstring(String s1, String s2) {
        int charEqualsIndex = 0;
        StringBuilder refurbishedStr = new StringBuilder();
        for (int i = 0; i < s2.length(); i++) {
            if (s2.charAt(i) == s1.charAt(0)) {
                charEqualsIndex = i;
                break;
            }
        }
        refurbishedStr.append(s2.substring(charEqualsIndex));
        refurbishedStr.append(s2.substring(0, charEqualsIndex));

        return refurbishedStr.toString().equals(s1) ? true : false;
    }

    public void reverseString(char[] s) {
        for (int i = s.length - 1; i > s.length / 2; i--) {
            int position = (s.length - 1) - i;
            char temp = s[position];
            s[position] = s[i];
            s[i] = temp;
        }
    }

    public List<String> stringMatching(String[] words) {
        List<String> matchingList = new ArrayList<>();
        for (int i = 0; i< words.length; i++){
            for (int j = 0; j < words.length; j++){
                if (i != j && words[i].length() < words[j].length()){
                    if (words[j].contains(words[i])){
                        if (!matchingList.contains(words[i])){
                            matchingList.add(words[i]);
                        }
                    }
                }
            }
        }
        return matchingList;
    }

    public int compress(char[] chars) {
        int compressedIndex = 0;
        int compressCounter = 1;

        if (chars.length > 1){
            for (int i = 1; i<chars.length; i++){
                if (chars[i] == chars[i-1]){
                    compressCounter++;
                } else {
                    if (compressCounter > 1){
                        chars[compressedIndex] = chars[i];
                        compressedIndex = writeCounter(compressCounter, compressedIndex, chars);
                        compressCounter = 1;
                    }
                    compressedIndex++;
                }
                if (i == chars.length -1){
                    compressedIndex = writeCounter(compressCounter, compressedIndex, chars);
                }
            }
        }

        return compressedIndex + 1;
    }

    private int writeCounter(int counter, int index, char[] arr){
        if (counter >= 10){
            int firstDigit = counter/10;
            int lastDigit = counter%10;
            arr[++index] = (char) (firstDigit + '0');
            arr[++index] = (char) (lastDigit + '0');
        } else {
            arr[++index] = (char) (counter + '0');
        }

        return index;
    }

    public int firstUniqueChar(String s) {
        for (int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            char ptr = 0;
            boolean isUnique = false;
            for (int j = i + 1; j < s.length() -1; j++){
                ptr = s.charAt(j);
                if (cur == ptr){
                    isUnique = false;
                    break;
                } else {
                    isUnique = true;
                }
            }
            if (isUnique){
                return i;
            }
        }

        return -1;
    }

    public int firstUniqueChar2(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (int i = 0; i < s.length(); i++){
            if(map.get(s.charAt(i)) == 1){
                return i;
            }
        }

        return -1;
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        Character sChar;
        Character tChar;
        for (int i = 0; i < s.length(); i++){
            sChar = s.charAt(i);
            if (sMap.containsKey(sChar)){
                sMap.put(sChar, sMap.get(sChar) + 1);
            } else {
                sMap.put(sChar, 1);
            }


            tChar = t.charAt(i);
            if (tMap.containsKey(tChar)){
                tMap.put(tChar, tMap.get(tChar) + 1);
            } else {
                tMap.put(tChar, 1);
            }
        }

        if (sMap.equals(tMap)){
            return true;
        }

        return false;
    }

    public boolean isPalindrome(String s) {
        if(s.isEmpty() || s.isBlank() || s.length() == 1){
            return true;
        }
        s = s.toLowerCase();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c <= Character.valueOf('z') && c >= Character.valueOf('a')){
                sb.append(c);
            } else if(c <= Character.valueOf('9') && c >= Character.valueOf('0')){
                sb.append(c);
            }
        }

        char[] charArr = sb.toString().toCharArray();

        int j = 0;
        for (int i = charArr.length -1; i > charArr.length/2 - 1; i--){
            if (charArr[i] != charArr[j++]){
                return false;
            }
        }

        return true;
    }



}

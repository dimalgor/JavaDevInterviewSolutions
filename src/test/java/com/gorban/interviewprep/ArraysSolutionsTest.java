package com.gorban.interviewprep;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArraysSolutionsTest {

    ArraysSolutions arraysSolutions = new ArraysSolutions();

    @Test
    void findNumbers() {
        int [] arr = {437,315,322,431,686,264,442};
        assertEquals(0, arraysSolutions.findNumbers(arr));
    }

    @Test
    void shiftIndexes() {
        int[] arr = {1,0,2,3,0,4,5,0};
        int[] duplicatedZeroesArr = {1,0,0,2,3,0,0,4};
        boolean isDuplicationZeroesCorrect = true;
        arraysSolutions.duplicateZeros(arr);
        for (int i = 0; i < arr.length; i++){
            if (arr[i] != duplicatedZeroesArr[i]){
                isDuplicationZeroesCorrect = false;
                break;
            }
        }
        assertTrue(isDuplicationZeroesCorrect);
    }

    @Test
    void mergeSet1(){
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        int[] expectedNums = {1,2,2,3,5,6};
        arraysSolutions.merge(nums1, m, nums2,n);
        assertTrue(isEqual(nums1, expectedNums));
    }

    @Test
    void mergeSet2(){
        int[] nums1 = {4,5,6,0,0,0};
        int m = 3;
        int[] nums2 = {1,2,3};
        int n = 3;
        int[] expectedNums = {1,2,3,4,5,6};
        arraysSolutions.merge(nums1, m, nums2,n);
        assertTrue(isEqual(nums1, expectedNums));
    }

    @Test
    void mergeSet3(){
        int[] nums1 = {-1,0,0,3,3,3,0,0,0};
        int m = 6;
        int[] nums2 = {1,2,2};
        int n = 3;
        int[] expectedNums = {-1,0,0,1,2,2,3,3,3};
        arraysSolutions.merge(nums1, m, nums2,n);
        assertTrue(isEqual(nums1, expectedNums));
    }
    public boolean isEqual(int[] nums1, int[] expectedNums){
        for (int i = 0; i < nums1.length; i++){
            if (nums1[i] != expectedNums[i]){
                return false;
            }
        }
        return true;
    }

    private boolean checkEqualityTillLength(int[] nums1, int[] expectedNums, int length){
        for (int i = 0; i < length; i++){
            if (nums1[i] != expectedNums[i]){
                return false;
            }
        }
        return true;
    }

    @Test
    void removeElement() {
        int[] nums = {3,2,2,3};
        int val = 3;
        int expectedLength = 2;
        int[] expectedArr = {2,2,0,0};
        int newLength = arraysSolutions.removeElement(nums, val);
        assertEquals(expectedLength,newLength);
        assertTrue(isEqual(nums, expectedArr));
    }

    @Test
    void removeElement2() {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        int expectedLength = 5;
        int[] expectedArr = {0,1,3,0,4,0,0,0};
        int newLength = arraysSolutions.removeElement(nums, val);
        assertEquals(expectedLength,newLength);
        assertTrue(isEqual(nums, expectedArr));
    }

    @Test
    void removeElement3() {
        int[] nums = {4,4,0,1,0,2};
        int val = 0;
        int expectedLength = 4;
        int[] expectedArr = {4,4,1,2,0,0};
        int newLength = arraysSolutions.removeElement(nums, val);
        assertEquals(expectedLength,newLength);
        assertTrue(isEqual(nums, expectedArr));
    }

    @Test
    void removeDuplicates() {
        int[] nums = {1,1,2};
        int[] expectedArr = {1,2,0};
        int expectedLength = 2;
        int newLength = arraysSolutions.removeDuplicates(nums);
        assertEquals(expectedLength,newLength);
        assertTrue(isEqual(nums, expectedArr));
    }

    @Test
    void removeDuplicates2() {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int[] expectedArr = {0,1,2,3,4,0,0,0,0,0};
        int expectedLength = 5;
        int newLength = arraysSolutions.removeDuplicates(nums);
        assertEquals(expectedLength,newLength);
        assertTrue(isEqual(nums, expectedArr));
    }

    @Test
    void checkIfExist() {
        int[] arr = {10,2,5,3};
        assertTrue(arraysSolutions.checkIfExist(arr));
    }

    @Test
    void checkIfExist2() {
        int[] arr = {7,1,14,11};
        assertTrue(arraysSolutions.checkIfExist(arr));
    }

    @Test
    void checkIfExist3() {
        int[] arr = {3,1,7,11};
        assertFalse(arraysSolutions.checkIfExist(arr));
    }

    @Test
    void checkIfExist4() {
        int[] arr = {-10,12,-20,-8,15};
        assertTrue(arraysSolutions.checkIfExist(arr));
    }

    @Test
    void checkIfExist5() {
        int[] arr = {-20,8,-6,-14,0,-19,14,4};
        assertTrue(arraysSolutions.checkIfExist(arr));
    }

    @Test
    void checkIfExist6() {
        int[] arr = {-2,0,10,-19,4,6,-8};
        assertFalse(arraysSolutions.checkIfExist(arr));
    }

    @Test
    void checkIfExist7() {
        int[] arr = {0,0,};
        assertTrue(arraysSolutions.checkIfExist(arr));
    }

    @Test
    void validMountainArray() {
        int[] A = {0,3,2,1};
        assertTrue(arraysSolutions.validMountainArray(A));
    }

    @Test
    void validMountainArray2() {
        int[] A = {2,1};
        assertFalse(arraysSolutions.validMountainArray(A));
    }

    @Test
    void validMountainArray3() {
        int[] A = {3,5,5};
        assertFalse(arraysSolutions.validMountainArray(A));
    }

    @Test
    void validMountainArray4() {
        int[] A = {2,0,2};
        assertFalse(arraysSolutions.validMountainArray(A));
    }

    @Test
    void validMountainArray5() {
        int[] A = {0,1,2,1,2};
        assertFalse(arraysSolutions.validMountainArray(A));
    }

    @Test
    void replaceElements() {
        int[] arr = {17,18,5,4,6,1};
        int[] expectedArr = {18,6,6,6,1,-1};
        int[] outputArr = arraysSolutions.replaceElements(arr);
        assertTrue(isEqual(outputArr, expectedArr));
    }

    @Test
    void testRemoveDuplicates2() {
        int[] arr = {1,1,2};
        int[] expectedArr = {1,2,2};
        int expectedArrLength = 2;
        int newArrLength = arraysSolutions.removeDuplicates2(arr);
        assertEquals(newArrLength, expectedArrLength);
        assertTrue(checkEqualityTillLength(arr,expectedArr,newArrLength));
    }

    @Test
    void testRemoveDuplicates3() {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        int[] expectedArr = {0,1,2,3,4,2,2,3,3,4};
        int expectedArrLength = 5;
        int newArrLength = arraysSolutions.removeDuplicates2(arr);
        assertEquals(newArrLength, expectedArrLength);
        assertTrue(checkEqualityTillLength(arr,expectedArr,newArrLength));
    }

    @Test
    void moveZeroes() {
        int [] arr = {0,1,0,3,12};
        int [] expectedArr = {1,3,12,0,0};
        arraysSolutions.moveZeroes(arr);
        assertTrue(isEqual(arr, expectedArr));
    }

    @Test
    void moveZeroes2() {
        int [] arr = {0,0,1};
        int [] expectedArr = {1,0,0};
        arraysSolutions.moveZeroes(arr);
        assertTrue(isEqual(arr, expectedArr));
    }

    @Test
    void sortArrayByParity() {
        int [] arr = {3,1,2,4};
        int [] expectedArr = {2,4,3,1};
        arraysSolutions.sortArrayByParity(arr);
        assertTrue(isEqual(arr, expectedArr));
    }

    @Test
    void sortedSquares() {
        int[] arr = {-4,-1,0,3,10};
        int[] expectedArr = {0,1,9,16,100};
        arraysSolutions.sortedSquares(arr);
        assertTrue(isEqual(arr, expectedArr));
    }

    @Test
    void sortedSquares2() {
        int[] arr = {-7,-3,2,3,11};
        int[] expectedArr = {4,9,9,49,121};
        arraysSolutions.sortedSquares(arr);
        assertTrue(isEqual(arr, expectedArr));
    }

    @Test
    void heightChecker() {
        int[] arr = {1,1,4,2,1,3};
        int expectedMovements = 3;
        int movements = arraysSolutions.heightChecker2(arr);
        assertEquals(expectedMovements, movements);
    }

    @Test
    void heightChecker2() {
        int[] arr = {5,1,2,3,4};
        int expectedMovements = 5;
        int movements = arraysSolutions.heightChecker2(arr);
        assertEquals(expectedMovements, movements);
    }

    @Test
    void heightChecker3() {
        int[] arr = {1,2,3,4,5};
        int expectedMovements = 0;
        int movements = arraysSolutions.heightChecker2(arr);
        assertEquals(expectedMovements, movements);
    }


    @Test
    void findDisappearedNumbers() {
        int[] arr = {4,3,2,7,8,2,3,1};
        List<Integer> expectedList = new ArrayList<>(Arrays.asList(5,6));
        List<Integer> retrievedList = arraysSolutions.findDisappearedNumbers2(arr);
        boolean isEqual = true;
        for (int i = 0; i < retrievedList.size(); i++){
            if (expectedList.get(i) != retrievedList.get(i)){
                isEqual = false;
                break;
            }
        }
        assertTrue(isEqual);
    }

    @Test
    void thirdMax() {
        int[] arr = {3, 2, 1};
        int thirdMax = arraysSolutions.thirdMax(arr);
        assertEquals(1, thirdMax);
    }

    @Test
    void thirdMax2() {
        int[] arr = {1, 2};
        int thirdMax = arraysSolutions.thirdMax(arr);
        assertEquals(2, thirdMax);
    }

    @Test
    void thirdMax3() {
        int[] arr = {2, 2, 3, 1};
        int thirdMax = arraysSolutions.thirdMax(arr);
        assertEquals(1, thirdMax);
    }


    @Test
    void maxProfit() {
        assertEquals(2, arraysSolutions.maxProfit(new int[]{2,1,2,0,1}));
        assertEquals(1, arraysSolutions.maxProfit(new int[]{1,2}));
        assertEquals(7, arraysSolutions.maxProfit(new int[]{7,1,5,3,6,4}));
        assertEquals(4, arraysSolutions.maxProfit(new int[]{1,2,3,4,5}));
        assertEquals(0, arraysSolutions.maxProfit(new int[]{7,6,4,3,1}));
    }

    @Test
    void rotate() {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        int[] rotatedNums = new int[]{5,6,7,1,2,3,4};
        int k = 3;
        arraysSolutions.rotate(nums, k);
        assertTrue(Arrays.equals(rotatedNums, nums));
    }

    @Test
    void rotate2() {
        int[] nums = new int[]{-1,-100,3,99};
        int[] rotatedNums = new int[]{3,99,-1,-100};
        int k = 2;
        arraysSolutions.rotate(nums, k);
        assertTrue(Arrays.equals(rotatedNums, nums));
    }

    @Test
    void rotate3() {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        int[] rotatedNums = new int[]{5,6,7,1,2,3,4};
        int k = 3;
        arraysSolutions.rotate2(nums, k);
        assertTrue(Arrays.equals(rotatedNums, nums));
    }

    @Test
    void rotate4() {
        int[] nums = new int[]{-1,-100,3,99};
        int[] rotatedNums = new int[]{3,99,-1,-100};
        int k = 2;
        arraysSolutions.rotate2(nums, k);
        assertTrue(Arrays.equals(rotatedNums, nums));
    }

    @Test
    void rotate5() {
        int[] nums = new int[]{1,2};
        int[] rotatedNums = new int[]{2,1};
        int k = 3;
        arraysSolutions.rotate2(nums, k);
        assertTrue(Arrays.equals(rotatedNums, nums));
    }

    @Test
    void containsDuplicate() {
        assertTrue(arraysSolutions.containsDuplicate(new int[]{1,2,3,1}));
        assertFalse(arraysSolutions.containsDuplicate(new int[]{1,2,3,4}));
        assertTrue(arraysSolutions.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));
    }

    @Test
    void singleNumber() {
        assertEquals(1, arraysSolutions.singleNumber(new int[]{2,2,1}));
        assertEquals(4, arraysSolutions.singleNumber(new int[]{4,1,2,1,2}));
    }

    @Test
    void intersect() {
        assertTrue(Arrays.equals(new int[]{-2147483648, 1}, arraysSolutions.intersect2(new int[]{-2147483648,1,2,3}, new int[]{1,-2147483648,-2147483648})));
        assertTrue(Arrays.equals(new int[]{2,2}, arraysSolutions.intersect2(new int[]{1,2,2,1}, new int[]{2,2})));
        assertTrue(Arrays.equals(new int[]{4,9}, arraysSolutions.intersect2(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
        assertTrue(Arrays.equals(new int[]{1}, arraysSolutions.intersect2(new int[]{2,1}, new int[]{1,1})));
        assertTrue(Arrays.equals(new int[]{1,2}, arraysSolutions.intersect2(new int[]{2,1}, new int[]{1,2})));
        assertTrue(Arrays.equals(new int[]{1}, arraysSolutions.intersect2(new int[]{3,1,2}, new int[]{1,1})));
    }

    @Test
    void plusOne() {
        assertTrue(Arrays.equals(new int[]{9,8,7,6,5,4,3,2,1,1}, arraysSolutions.plusOne(new int[]{9,8,7,6,5,4,3,2,1,0})));
        assertTrue(Arrays.equals(new int[]{1,2,4}, arraysSolutions.plusOne(new int[]{1,2,3})));
        assertTrue(Arrays.equals(new int[]{1}, arraysSolutions.plusOne(new int[]{0})));
        assertTrue(Arrays.equals(new int[]{1,3,0}, arraysSolutions.plusOne(new int[]{1,2,9})));
    }

    @Test
    void plusOne2() {
        assertTrue(Arrays.equals(new int[]{9,0,0,0}, arraysSolutions.plusOne2(new int[]{8,9,9,9})));
        assertTrue(Arrays.equals(new int[]{1,0,0,0}, arraysSolutions.plusOne2(new int[]{9,9,9})));
        assertTrue(Arrays.equals(new int[]{1,0}, arraysSolutions.plusOne2(new int[]{9})));
        assertTrue(Arrays.equals(new int[]{5,6,2,0,0,4,6,2,5,0}, arraysSolutions.plusOne2(new int[]{5,6,2,0,0,4,6,2,4,9})));
        assertTrue(Arrays.equals(new int[]{9,8,7,6,5,4,3,2,1,1}, arraysSolutions.plusOne2(new int[]{9,8,7,6,5,4,3,2,1,0})));
        assertTrue(Arrays.equals(new int[]{1,2,4}, arraysSolutions.plusOne2(new int[]{1,2,3})));
        assertTrue(Arrays.equals(new int[]{1}, arraysSolutions.plusOne2(new int[]{0})));
        assertTrue(Arrays.equals(new int[]{1,3,0}, arraysSolutions.plusOne2(new int[]{1,2,9})));
    }

    @Test
    void isPalindrome() {
        assertTrue(arraysSolutions.isPalindrome(121));
        assertFalse(arraysSolutions.isPalindrome(-121));
        assertFalse(arraysSolutions.isPalindrome(10));
    }
}

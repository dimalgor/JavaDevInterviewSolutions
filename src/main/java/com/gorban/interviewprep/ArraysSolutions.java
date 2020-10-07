package com.gorban.interviewprep;

import java.util.*;

public class ArraysSolutions {
    public int findNumbers(int[] nums) {
        int evenNumDigits = 0;
        int numDigitsCounter = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            while (num > 0) {
                num = num / 10;
                numDigitsCounter++;
            }
            if (numDigitsCounter % 2 == 0) {
                evenNumDigits++;
            }
            numDigitsCounter = 0;
        }

        return evenNumDigits;
    }

    public void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                for (int j = arr.length - 1; j > i; j--) {
                    arr[j] = arr[j - 1];
                }
                i++;
            }
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        for (int i = m; i < nums1.length; i++) {
            nums1[i] = nums2[j++];
        }
        Arrays.sort(nums1);
    }

    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == val) {
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[--length] = 0;
                i--;
            }
        }

        return length;
    }

    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[--length] = 0;
                i--;
            }
        }

        return length;
    }

    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet();
        for (Integer i : arr) {
            if (set.contains(i * 2) || (i % 2 == 0 && set.contains(i / 2))) {
                return true;
            } else {
                set.add(i);
            }
        }
        return false;
    }

    public boolean validMountainArray(int[] A) {
        if (A == null || A.length < 3) {
            return false;
        }
        boolean isStrictlyIncreasing = false;
        boolean isStrictlyDecreasing = false;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] < A[i + 1] && isStrictlyDecreasing == false) {
                isStrictlyIncreasing = true;
            } else if (A[i] == A[i + 1]) {
                return false;
            } else if (A[i] > A[i + 1] && isStrictlyIncreasing == true) {
                isStrictlyDecreasing = true;
            } else {
                return false;
            }
        }

        return isStrictlyIncreasing && isStrictlyDecreasing;
    }

    public int[] replaceElements(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                arr[i] = -1;
            } else {
                int max = 0;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] > max) {
                        max = arr[j];
                    }
                }
                arr[i] = max;
            }
        }
        return arr;
    }

    public int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length < 3) {
            // throw Exception;
        }
        int length = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[++length] = nums[i];
            }
        }

        return length + 1;
    }

    public void moveZeroes(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                for (int j = i; j < length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[length - 1] = 0;
                length--;
                if (nums[i] == 0) {
                    i--;
                }
            }
        }
    }

    public int[] sortArrayByParity(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 != 0) {
                for (int j = i + 1; j < A.length; j++) {
                    if (A[j] % 2 == 0) {
                        int temp = A[i];
                        A[i] = A[j];
                        A[j] = temp;
                        break;
                    }
                }
            }
        }
        return A;
    }

    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] *= A[i];
        }
        Arrays.sort(A);
        return A;
    }

    public int heightChecker(int[] heights) {
        int movement = 0;
        for (int i = 0; i < heights.length; i++) {
            int minValue = Integer.MAX_VALUE;
            int minValuePosition = 0;
            for (int j = i + 1; j < heights.length; j++) {
                if (minValue > heights[j]) {
                    minValue = heights[j];
                    minValuePosition = j;
                }
            }
            if (heights[i] > minValue) {
                int temp = heights[i];
                heights[i] = heights[minValuePosition];
                heights[minValuePosition] = temp;
                movement++;
            }
        }

        return movement;
    }

    public int heightChecker2(int[] heights) {
        int movements = 0;
        int[] sorted = heights.clone();
        Arrays.sort(sorted);
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != sorted[i]) {
                movements++;
            }
        }
        return movements;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> disappearedNums = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            disappearedNums.add(i + 1);
        }

        for (int i = 0; i < nums.length; i++) {
            if (disappearedNums.contains(nums[i])) {
                disappearedNums.remove(disappearedNums.indexOf(nums[i]));
            }
        }

        return disappearedNums;
    }

    public List<Integer> findDisappearedNumbers2(int[] nums) {
        boolean[] appeared = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            appeared[nums[i] - 1] = true;
        }
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < appeared.length; i++) {
            if (!appeared[i]) {
                result.add(i + 1);
            }
        }

        return result;
    }

    public int thirdMax(int[] nums) {
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;
        boolean minValueAppearsOnlyOnce = true;
        int counter = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = nums[i];
            } else if (nums[i] > secondMax && nums[i] != firstMax) {
                thirdMax = secondMax;
                secondMax = nums[i];
            } else if (nums[i] > thirdMax && nums[i] != secondMax && nums[i] != firstMax) {
                thirdMax = nums[i];
            } else if (nums[i] == Integer.MIN_VALUE && minValueAppearsOnlyOnce == true) {
                minValueAppearsOnlyOnce = false;
            } else {
                continue;
            }
            counter++;
        }

        return counter > 2 ? thirdMax : firstMax;
    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        int buyPrice = -1;
        int sellPrice = -1;

        for (int i = 0; i < prices.length - 1; i++) {
            if (buyPrice == -1 && prices[i] < prices[i + 1]) {
                buyPrice = prices[i];
                if (i + 1 == prices.length - 1) {
                    sellPrice = prices[i + 1];
                } else {
                    continue;
                }
            }
            if (buyPrice != -1 && sellPrice == -1 && prices[i] > prices[i + 1]) {
                sellPrice = prices[i];
            } else if (buyPrice != -1 && sellPrice == -1 && i + 1 == prices.length - 1) {
                sellPrice = prices[i + 1];
            }
            if (buyPrice != -1 && sellPrice != -1) {
                int transactionProfit = sellPrice - buyPrice;
                profit = profit + transactionProfit;
                buyPrice = -1;
                sellPrice = -1;
            }
        }

        return profit;
    }

    public void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int temp = nums[nums.length - 1];
            for (int j = nums.length - 2; j >= 0; j--) {
                nums[j + 1] = nums[j];
            }
            nums[0] = temp;
        }
    }

    public void rotate2(int[] nums, int k) {
        if (nums.length > 1) {
            if (nums.length < k) {
                k = k - nums.length;
            }

            int[] beginArr = new int[k];
            int[] endArr = new int[nums.length - k];

            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i < nums.length - k) {
                    endArr[i] = nums[i];
                } else {
                    beginArr[index++] = nums[i];
                }
            }
            index = 0;

            for (int i = 0; i < nums.length; i++) {
                if (i < beginArr.length) {
                    nums[i] = beginArr[i];
                } else {
                    nums[i] = endArr[index++];
                }
            }
        }
    }

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    public int singleNumber(int[] nums) {
        int singleNum = 0;
        if (nums.length == 1) {
            return nums[0];
        }

        Arrays.sort(nums);
        for (int i = 1; i < nums.length - 1; i++) {
            if (i == 1 && nums[i] != nums[i - 1]) {
                singleNum = nums[i - 1];
                break;
            } else if (i == nums.length - 2 && nums[i] != nums[i + 1]) {
                singleNum = nums[i + 1];
                break;
            } else if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                singleNum = nums[i];
                break;
            }
        }

        return singleNum;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        int[] intersectArr = new int[]{};
        if (nums1.length != 0 && nums2.length != 0) {
            int[] sm;
            int[] bg;
            if (nums1.length < nums2.length) {
                sm = nums1;
                bg = nums2;
            } else if (nums1.length == nums2.length) {
                int commonNumsCounter = 0;
                Arrays.sort(nums1);
                Arrays.sort(nums2);
                for (int i = 0; i < nums1.length; i++) {
                    if (nums1[i] == nums2[i]) {
                        commonNumsCounter++;
                    }
                }
                intersectArr = new int[commonNumsCounter];
                int index = 0;
                for (int i = 0; i < nums1.length; i++) {
                    if (nums1[i] == nums2[i]) {
                        intersectArr[index++] = nums1[i];
                    }
                }
                return intersectArr;
            } else {
                sm = nums2;
                bg = nums1;
            }

            int startInd = -1;
            int endInd = 0;
            int bgTravInd = 0;
            for (int i = 0; i < sm.length; i++) {
                for (int j = bgTravInd; j < bg.length; j++) {
                    if (sm[i] == bg[j]) {
                        if (startInd == -1) {
                            startInd = i;
                        } else {
                            endInd++;
                        }
                        break;
                    }
                }
            }

            intersectArr = new int[endInd - startInd + 1];
            int index = 0;
            for (int i = startInd; i < endInd + 1; i++) {
                intersectArr[index++] = sm[i];
            }
        }

        return intersectArr;
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        int[] intersectArr = new int[]{};
        if (nums1.length != 0 && nums2.length != 0) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            List<Integer> list = new ArrayList<>();
            int i = 0;
            int j = 0;
            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] > nums2[j]) {
                    j++;
                } else if (nums2[j] > nums1[i]) {
                    i++;
                } else {
                    list.add(nums1[i++]);
                    j++;
                }
            }
            intersectArr = list.stream().mapToInt(k -> k).toArray();
        }
        return intersectArr;
    }

    public int[] plusOne(int[] digits) {
        if (digits[digits.length - 1] + 1 <= 9) {
            digits[digits.length - 1] = digits[digits.length - 1] + 1;
            return digits;
        }

        long sum = 0;
        for (int i = 0; i < digits.length - 1; i++) {
            sum += digits[i] * Math.pow(10, (digits.length - 1 - i));
        }
        sum += digits[digits.length - 1] + 1;

        long digit = sum;
        int resultLength = 0;
        while (digit > 0) {
            digit = digit / 10;
            resultLength++;
        }

        digit = sum;
        int[] result = new int[resultLength];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = (int) digit % 10;
            digit = digit / 10;
        }

        return result;
    }

    public int[] plusOne2(int[] digits) {
        if (digits[digits.length - 1] + 1 <= 9) {
            digits[digits.length - 1] = digits[digits.length - 1] + 1;
            return digits;
        } else if (digits.length == 1){
            int[] result = new int[2];
            result[0] = 1;
            result[1] = 0;
            return result;
        }

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + 1 > 9) {
                if (digits[i] > 9) {
                    digits[i] = digits[i] % 10;
                } else {
                    digits[i] = (digits[i] + 1) % 10;
                }

                if (i - 1 > 0) {
                    digits[i - 1] = ++digits[i - 1];
                } else if (i - 1 == 0){
                    if ((digits[i-1] + 1) > 9){
                        int[] result = new int[digits.length + 1];
                        result[0] = 1;
                        for (int j = 0; j < digits.length; j++) {
                            result[i + 1] = digits[i];
                        }
                        return result;
                    } else {
                        digits[i-1] = ++digits[i-1];
                        break;
                    }
                }
            }
        }

        return digits;
    }

    public boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        } else if (x == 0){
            return true;
        } else {
            List<Integer> list = new ArrayList<>();
            while (x != 0){
                list.add(x%10);
                x = x/10;
            }

            if (list.size() == 2){
                if (list.get(0) == list.get(1)){
                    return true;
                } else {
                    return false;
                }
            } else {
                for (int i = 0; i < list.size()/2; i++){
                    if (list.get(i) != list.get((list.size() - 1) - i)){
                        return false;
                    }
                }
                return true;
            }
        }
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0] == target ? 0 : -1;
        }
        int low = 0;
        int high = nums.length - 1;

        while (low <= high){
            int mid = low + ((high - low)/2);
            if (target == nums[mid]){
                return mid;
            }
            if (target < nums[mid]){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public int mySqrt(int x) {
        if (x > 1){
            int low = 0;
            int high = x;

            while (low < high){
                int mid = low + (high - low)/2;
                int sqrt = mid * mid;
                if (sqrt == x){
                    return mid;
                } else if (sqrt > x){
                    high = mid;
                } else if (sqrt < x){
                    low = mid + 1;
                }
            }
            return low - 1;
        }
        return x;
    }

    public int mySqrt2(int x) {
        if(x < 2){
            return x;
        }
        int low = 0;
        int high = x / 2;

        while(low < high) {
            int mid = low + (high - low + 1) / 2;
            if(mid > x/mid) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }
        return low;
    }

    public static class MaxAndMin {
        int max;
        int min;
    }

    public MaxAndMin getMaxAndMin(int[] numbers){
        // array is unsorted, and we have time limitation, so implement bubble sorting;
        MaxAndMin result = new MaxAndMin();
        if (numbers.length < 2){
            return result;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < numbers.length; i++){
            if (numbers[i] < min){
                min = numbers[i];
            }
            if (numbers[i] > max){
                max = numbers[i];
            }
        }

        result.max = max;
        result.min = min;

        return result;
    }

}

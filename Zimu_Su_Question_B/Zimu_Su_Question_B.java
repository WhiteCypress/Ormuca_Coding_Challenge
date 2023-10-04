package Zimu_Su_Question_B;

import java.util.Arrays;

public class Zimu_Su_Question_B {
    /***
     * Takes two(2) string inputs as version numbers, returns -1 if the first input
     * is greater than the second, 1 if the second is greater than the first, and 0
     * if both are equal.
     * 
     * @return integer value indicating the result of comparison.
     */
    public static int compareVersion(String v1, String v2) {
        // Convert input version number strings into an array of integers.
        int[] n1 = convertToArrayNew(v1);
        int[] n2 = convertToArrayNew(v2);

        // For Java version lower than Java 8, uncomment the following.
        // int[] n1 = convertToArrayOld(v1);
        // int[] n2 = convertToArrayOld(v2);

        // Compare every digit from the beginning, until one version number has no more
        // digit.
        for (int i = 0; i < Math.min(n1.length, n2.length); i++) {
            if (n1[i] > n2[i]) {
                return -1;
            } else if (n1[i] < n2[i]) {
                return 1;
            }
        }

        // If all previous digits are the same, the one with more digits is greater.
        if (n1.length > n2.length && containsNoneZero(n1, n2.length)) {
            return -1;
        } else if (n1.length < n2.length && containsNoneZero(n2, n1.length)) {
            return 1;
        } else {
            // In case both inputs have the same length or the longer
            // one only have 0 after the common digits, they are equal.
            return 0;
        }
    }

    private static boolean containsNoneZero(int[] arr, int start) {
        for (int i = start; i < arr.length; i++) {
            if (arr[i] != 0) {
                return true;
            }
        }

        return false;
    }

    private static int[] convertToArrayNew(String l) {
        int[] n;

        try {
            n = Arrays.stream(l.split("\\.")).mapToInt(Integer::parseInt).toArray();

            return n;
        } catch (NumberFormatException e) {
            System.out.println(
                    "ERROR: cannot convert input values. Please make sure values are separated with dots and no other symboles are present.");
            System.exit(1);
        }
        return null;
    }

    // private static int[] convertToIntArrayOld(String l) {
    // String[] s = l.split(".");
    // int[] numbers = new int[s.length];
    // for (int i = 0; i < s.length; i++) {
    // numbers[i] = Integer.parseInt(s[i]);
    // }

    // return numbers;
    // }
}

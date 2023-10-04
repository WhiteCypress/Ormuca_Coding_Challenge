package Zimu_Su_Question_A;

import java.io.Console;
import java.util.Arrays;

public class Zimu_Su_Question_A {
    public static void main(String[] args) {
        Console cnsl = System.console();

        // Take the input from console and store as strings.
        String l1 = cnsl.readLine("Please Enter coordinates for line 1 separated by a comma (ex: 1,5): ");
        // Convert input into numbers arrays.
        // Only works in Java 8 or higher.
        int[] n1 = convertToArrayNew(l1);
        String l2 = cnsl.readLine("Please Enter coordinates for line 2 separated by a comma (ex: 2,6): ");
        int[] n2 = convertToArrayNew(l2);

        // Uncomment the following lines if Java version is lower than Java 8.
        // Make sure to uncomment the corresponding method as well.
        // int[] n1 = convertToIntArrayOld(l1);
        // int[] n2 = convertToIntArrayOld(l2);

        // Sort arrays in case input is not in order (start position, end position).
        Arrays.sort(n1);
        Arrays.sort(n2);

        if (isIntersect(n1, n2)) {
            System.out.println("Input lines intersect.");
        } else {
            System.out.println("Input lines does not intersect.");
        }
    }

    private static int[] convertToArrayNew(String l) {
        int[] n;

        try {
            n = Arrays.stream(l.split(",")).mapToInt(Integer::parseInt).toArray();

            if (n.length != 2) {
                System.out.println(
                        "Your input is not valid, make sure to separate your values by a comma and have only 2 values.");
                System.exit(1);
            }

            return n;
        } catch (NumberFormatException e) {
            System.out.println(
                    "ERROR: cannot convert input values. Please make sure values are separated with commas and no other symboles are present.");
            System.exit(1);
        }
        return null;
    }

    // private static int[] convertToIntArrayOld(String l) {
    // String[] s = l.split(",");
    // int[] numbers = new int[s.length];
    // for (int i = 0; i < s.length; i++) {
    // numbers[i] = Integer.parseInt(s[i]);
    // }

    // return numbers;
    // }

    private static boolean isIntersect(int[] n1, int[] n2) {
        // Assuming "touching" is considered as overlaping.
        // Ex: (1,5) overlaps with (5,6).

        if ((n1[0] <= n2[1] && n1[0] >= n2[0]) || (n1[1] >= n2[0] && n1[1] <= n2[1])
                || (n2[0] <= n1[1] && n2[0] >= n1[0]) || (n2[1] >= n1[0] && n2[1] <= n1[1])) {
            return true;
        }

        return false;
    }
}
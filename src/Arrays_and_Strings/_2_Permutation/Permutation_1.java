package Arrays_and_Strings._2_Permutation;// QUESTION
// Given two strings, write a method to decide
// if one is a permutation of the other.

// EXPLANATION
// If two strings are permutations,
// then we know they have the same characters,
// but in different orders.
// Therefore, sorting the strings will put
// the characters from two permutations in the same order.
// We just need to compare the sorted versions of the strings.

// BEFORE
// ask if case-sensitive (assume: yes)
// ask if whitespace is significant (assume: yes)
public class Permutation_1 {
    public String sort(String s){ // sort string
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content); // don't do: return content.toString();
    }
    public boolean permutation(String s1, String s2) {
        if(s1.length() != s2.length()) // check if same length
            return false;
        return sort(s1).equals(sort(s2)); // check if sorted strings are the same
    }

    // TEST
    public static void main(String[] args) {
        Permutation_1 ip = new Permutation_1();

        // Test case 1: s1 and s2 are permutations
        String s1 = "racecar";
        String s2 = "carrace";
        boolean result = ip.permutation(s1, s2);
        System.out.println("Test case 1: s1 and s2 are permutations");
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
        System.out.println("Result = " + result);
        System.out.println();

        // Test case 2: s1 and s2 have different lengths
        s1 = "hello";
        s2 = "world";
        result = ip.permutation(s1, s2);
        System.out.println("Test case 2: s1 and s2 have different lengths");
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
        System.out.println("Result = " + result);
        System.out.println();

        // Test case 3: s1 and s2 are not permutations
        s1 = "abcd";
        s2 = "efgh";
        result = ip.permutation(s1, s2);
        System.out.println("Test case 3: s1 and s2 are not permutations");
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
        System.out.println("Result = " + result);
        System.out.println();
    }

}

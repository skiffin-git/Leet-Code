package _1_Arrays_and_Strings._2_Permutation;// QUESTION
// Given two strings, write a method to decide
// if one is a permutation of the other.

// EXPLANATION
// two words with the same character counts-to implement
// this algorithm. We simply iterate through this code,
// counting how many times each character appears.
// Then, afterwards, we compare the two arrays.

// BEFORE
// ask if case-sensitive (assume: yes)
// ask if whitespace is significant (assume: yes)
// ask if we use ASC2
public class Permutation_2 {
    boolean permutation(String s1, String s2){
        if(s1.length() != s2.length()){ // check if same length
            return false;
        }
        int[] s1_letters = new int[128]; // assume we use ASC2
        for(int i = 0; i < s1.length(); i++){ // count chars in first string
            s1_letters[s1.charAt(i)]++;
        }
        for(int i = 0; i < s2.length(); i++){ // deduct chars from second string
            int s2_index_char = s2.charAt(i);
            s1_letters[s2_index_char]--;
            if(s1_letters[s2_index_char] < 0) // compare char count
                return false;
        }
        return true;
    }

    // TEST
    public static void main(String[] args) {
        Permutation_2 ip = new Permutation_2();

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

package Arrays_and_Strings._4_Palindrome_Permutation;

public class Palindrome_Permutation_Practice {
    boolean isPermutationOfPalindrome(String str){
        int countOdd = 0;
        int[] countSameChar = new int[128]; // ASC22
        for(char c : str.toCharArray()){
            if(c == ' '){
                continue;
            }
            countSameChar[c]++;
            if(countSameChar[c] % 2 == 1){
                countOdd++;
            }else{
                countOdd--;
            }
        }
        return countOdd <= 1;
    }

    // TEST
    public static void main(String[] args) {
        Palindrome_Permutation_Practice pp = new Palindrome_Permutation_Practice();
        String str1 = "racecar";
        String str2 = "tact coa";
        String str3 = "hello";
        String str4 = "abbcdde";

        System.out.println(pp.isPermutationOfPalindrome(str1)); // true
        System.out.println(pp.isPermutationOfPalindrome(str2)); // true
        System.out.println(pp.isPermutationOfPalindrome(str3)); // false
        System.out.println(pp.isPermutationOfPalindrome(str4)); // false
    }
}

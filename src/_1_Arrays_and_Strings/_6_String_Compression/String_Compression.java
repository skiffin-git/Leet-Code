package _1_Arrays_and_Strings._6_String_Compression;
// QUESTION
// Implement a method to perform basic string compression using the counts
// of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
// "compressed" string would not become smaller than the original string, your method should return
// the original string. You can assume the string has only uppercase and lowercase letters (a - z).
//
// EXPLANATION
// At first glance, implementing this method seems fairly straightforward, but perhaps a bit tedious. We iterate
// through the string, copying characters to a new string and counting the repeats. At each iteration, check
// if the current character is the same as the next character. If not, add its compressed version to the result.
// Using a StringBuilder.
public class String_Compression {
    String compress(String str){
        StringBuilder compressed = new StringBuilder();
        int countConsecutive = 0;
        for(int i = 0; i < str.length(); i++){
            countConsecutive++;
            // either next char is last char or next char isn't current char
            if(i + 1 >= str.length() || str.charAt(i) != str.charAt(i+1)){
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressed.length() < str.length() ? compressed.toString() : str;
    }

    // TEST
    public static void main(String[] args) {
        String_Compression stringCompression = new String_Compression();

        // Test cases with compressed string becoming smaller than the original string
        String testString1 = "aabcccccaaa";
        String compressedString1 = stringCompression.compress(testString1);
        System.out.println("Original string: " + testString1);
        System.out.println("Compressed string: " + compressedString1);

        String testString2 = "abcdeeeffggg";
        String compressedString2 = stringCompression.compress(testString2);
        System.out.println("Original string: " + testString2);
        System.out.println("Compressed string: " + compressedString2);

        // Test case with compressed string not becoming smaller than the original string
        String testString3 = "abcdefgh";
        String compressedString3 = stringCompression.compress(testString3);
        System.out.println("Original string: " + testString3);
        System.out.println("Compressed string: " + compressedString3);
    }
}

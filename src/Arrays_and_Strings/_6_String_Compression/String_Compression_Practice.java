package Arrays_and_Strings._6_String_Compression;

public class String_Compression_Practice {
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
        String_Compression_Practice stringCompression = new String_Compression_Practice();

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

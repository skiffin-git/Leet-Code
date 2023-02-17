package URLify;

// QUESTION
// Write a method to replace all spaces in a string with '%20'.
// You may assume that the string has sufficient space at the end
// to hold the additional characters,
// and that you are given the "true" length of the string.
// (Note: if implementing in Java, please use a character array
// so that you can perform this operation in place.)
//
// EXAMPLE
// Input: "Mr John Smith ", 13
// Output: "Mr%20John%20Smith"
//
// EXPLANATION
// Common approach in string manipulation problems is to edit the string
// starting from the end and working backwards.
// This is useful because we have an extra buffer at the end,
// which allows us to change characters
// without worrying about what we're overwriting.
// We will use this approach in this problem.
// The algorithm employs a two-scan approach.
// In the first scan, we count the number of spaces.
// By tripling this number, we can compute how many extra characters we will
// have in the final string. In the second pass, which is done in reverse order,
// we actually edit the string. When we see a space, we replace it with %20.
// If there is no space, then we copy the original character.
public class URLify_1 {
    void replaceSpaces(char[] str, int trueLength){
        int countSpaces = 0, index, i;

        // countSpaces
        for(i = 0; i < trueLength; i++){
            if(str[i] == ' '){
                countSpaces++;
            }
        }

        // calc new length
        index = trueLength + countSpaces * 2;

        // check for end array
        if(trueLength < str.length) str[trueLength] = '\0'; // end array

        // replace spaces with %20
        for(i = trueLength - 1; i >= 0; i--){
            if(str[i] == ' '){
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index -= 3;
            }else{
                str[index - 1] = str[i];
                index--;
            }
        }
    }

    // TEST
    public static void main(String[] args) {
        URLify_1 urlify = new URLify_1();

        // Test case 1
        char[] str1 = "Mr John Smith    ".toCharArray();
        int trueLength1 = 13;
        urlify.replaceSpaces(str1, trueLength1);
        System.out.println(new String(str1)); // expected output: "Mr%20John%20Smith"

        // Test case 2
        char[] str2 = "Hello world!  ".toCharArray();
        int trueLength2 = 12;
        urlify.replaceSpaces(str2, trueLength2);
        System.out.println(new String(str2)); // expected output: "Hello%20world!"
    }

}

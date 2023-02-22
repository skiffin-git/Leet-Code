package _1_Arrays_and_Strings._3_URLify;// QUESTION
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
// EXPLANATION (Steps)
// Convert the input string to a character array
// Then, count the number of spaces in the input string
// by looping through the character array and checking each character.
// Then, create a new character array with enough space
// to accommodate the additional characters required to replace the spaces.
// The additional characters are calculated as spaceCount * 2,
// since each space is replaced by three characters: %, 2, and 0,
// but we already have one space character in the original string,
// so we only need to add two more characters
// Then, loop through the original character array again and copy each character
// into the new character array. If a space is encountered,
// replace it with %20. Then, Convert the new character array to a string and return it

public class URLify_2 {
    String replaceSpaces(String str){
        char[] str_arr = str.toCharArray();
        int spaceCount = 0, i = 0;
        for(i = 0; i < str.length(); i++){ // count spaces
            if(str_arr[i] == ' '){
                spaceCount++;
            }
        }

        char[] newStr = new char[str.length() + spaceCount * 2]; // create new extended string
        int extender = 0; // use to extend new string when overwrite spaces
        for(i = 0; i < str_arr.length; i++){ // copy to new string and convert spaces
            if(str_arr[i] == ' ') {
                newStr[i + extender] = '%';
                newStr[i + 1 + extender] = '2';
                newStr[i + 2 + extender] = '0';
                extender += 2;
            } else
            newStr[i + extender] = str_arr[i]; // copy from old string with extension
        }
        return new String(newStr); // return new string
    }

    // TEST
    public static void main(String[] args) {
        URLify_2 ip = new URLify_2();
        String test1 = "Hello world";
        String result1 = ip.replaceSpaces(test1);
        System.out.println(result1); // expected output: "Hello%20world"

        String test2 = "This is a sentence with spaces.";
        String result2 = ip.replaceSpaces(test2);
        System.out.println(result2); // expected output: "This%20is%20a%20sentence%20with%20spaces."
    }
}


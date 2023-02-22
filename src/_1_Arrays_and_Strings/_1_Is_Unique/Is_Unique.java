package _1_Arrays_and_Strings._1_Is_Unique;

// QUESTION
// Is Unique: Implement an algorithm to determine
// if a string has all unique characters.
// What if you cannot use additional data structures?
//
// EXPLANATION
// One solution is to create an array of boolean values,
// where the flag at index i indicates whether character
// i in the alphabet is contained in the string.
// The second time you see this character you can immediately
// return false.
//
// BEFORE
// ask if it ASC2 table or unicode string?
// ask if ASC2 extended or standard?
public class Is_Unique {

    boolean isUniqueString(String str){
        boolean[] uniqueCharArray = new boolean[128]; // if using standard ASC2
        for(int i = 0; i < str.length(); i++){
            if(uniqueCharArray[str.charAt(i)]){ // true when finds same char twice
                return false;
            }
            uniqueCharArray[str.charAt(i)] = true; // remembers char
        }
        return true; // when didn't find any same chars
    }

    // TEST
    public static void main(String[] args) {
        Is_Unique test = new Is_Unique();
        String str1 = "abcdef";
        String str2 = "abcdea";
        System.out.println("Testing string: " + str1 + " Result: " + test.isUniqueString(str1));
        System.out.println("Testing string: " + str2 + " Result: " + test.isUniqueString(str2));
    }
}

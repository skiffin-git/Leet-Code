package _1_Arrays_and_Strings._5_One_Away;

// QUESTION
// There are three types of edits that can be performed on strings: insert a character,
// remove a character, or replace a character. Given two strings, write a function to check if they are
// one edit (or zero edits) away.
//
// EXAMPLE
// pale, ple -> true
// pales, pale -> true
// pale, bale -> true
// pale, bae -> false
//
// EXPLANATION
// replacement: Consider two strings, such as bale and pale, that are one replacement away.
// Yes, that does mean that you could replace a character in bale to make pale.
// But more precisely, it means that they are different only in one place.
// Insertion: The strings apple and aple are one insertion away. This means that if you compared the
// strings, they would be identical-except for a shift at some point in the strings.
// Removal: The strings apple and aple are also one removal away, since removal is just the inverse of
// insertion.
//
// We can go ahead and implement this algorithm now. We'll merge the insertion and removal check into one
// step, and check the replacement step separately.
// Observe that you don't need to check the strings for insertion, removal, and replacement edits. The lengths
// of the strings will indicate which of these you need to check.
//
// TIME:
// takes O ( n) time, where n is the length of the shorter string.
public class One_Away {
    boolean isOneEditAway(String s1, String s2){
        if(s1.length() == s2.length()){
            return isOneReplaceAway(s1, s2);
        } else if (s1.length() + 1 == s2.length()){
            return isOneInsertAway(s1, s2); // when s2 shorter
        } else if (s1.length() - 1 == s2.length()){
            return isOneInsertAway(s2, s1); // when s1 shorter
        }
        return false;
    }
    boolean isOneReplaceAway(String s1, String s2){
        boolean firstDifference = false;
        for(int i = 0; i < s1.length(); i++){

            // if different chars second time, return false
            if(s1.charAt(i) != s2.charAt(i)){
                if(firstDifference){
                    return false;
                }
                firstDifference = true; // remember first difference
            }
        }
        return true;
    }
    /* Check if you can insert a character into s1 to make s2.
    *  so s1 has to be shorter then s2 */
    boolean isOneInsertAway(String s1, String s2){
        boolean stop = false;
        int indexS2 = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(indexS2)){
                if(stop){
                    return false;
                }
                stop = true;
                indexS2++;
            }
            indexS2++;
        }
        return true;
    }

    // TEST
    public static void main(String[] args) {
        One_Away oneAway = new One_Away();
        System.out.println(oneAway.isOneEditAway("pale", "ple"));  // expected output: true
        System.out.println(oneAway.isOneEditAway("pales", "pale"));  // expected output: true
        System.out.println(oneAway.isOneEditAway("pale", "bale"));  // expected output: true
        System.out.println(oneAway.isOneEditAway("pale", "bae"));  // expected output: false
    }
}

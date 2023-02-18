package Arrays_and_Strings._5_One_Away;

public class One_Away_Practice {

    boolean isOneEditAway(String s1, String s2){
        if(s1.length() == s2.length()){
            return isOneReplaceAway(s1, s2);
        }else if(s1.length() + 1 == s2.length()){
            return isOneInsertAway(s1, s2);
        }else if(s2.length() + 1 == s1.length()){
            return isOneInsertAway(s2,s1);
        }
        return  false;
    }
    boolean isOneReplaceAway(String s1, String s2){
        boolean stop = false;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                if(stop){
                    return false;
                }
                stop = true;
            }
        }
        return true;
    }

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
        One_Away_Practice oneAway = new One_Away_Practice();
        System.out.println(oneAway.isOneEditAway("pale", "ple"));  // expected output: true
        System.out.println(oneAway.isOneEditAway("pales", "pale"));  // expected output: true
        System.out.println(oneAway.isOneEditAway("pale", "bale"));  // expected output: true
        System.out.println(oneAway.isOneEditAway("pale", "bae"));  // expected output: false
    }
}

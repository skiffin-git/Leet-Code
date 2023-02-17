package URLify;

public class URLify_1_Test {
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
        URLify_1_Test urlify = new URLify_1_Test();

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

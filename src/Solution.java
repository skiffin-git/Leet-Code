import java.util.*;
import java.lang.*;
import java.io.*;

/*
 * inputNum, represents the number of rows and columns of the chess board (N).
 */
public class Solution
{
    public static void  funcChessBoard(int inputNum)
    {
        // Write your code here
        char c = 'B';
        for(int i = 0; i < inputNum; i++){
            for(int j = 0; j < inputNum; j++){
                if(c == 'B')
                    c = 'W';
                else
                    c = 'B';
                System.out.print(c);
                if(!(j + 1 == inputNum)){
                    System.out.print(" ");
                }
            }
            if(inputNum % 2 == 0){ // is even
                if(c == 'B')
                    c = 'W';
                else
                    c = 'B';
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        // input for inputNum
        int inputNum = in.nextInt();



        funcChessBoard(inputNum);
    }
}
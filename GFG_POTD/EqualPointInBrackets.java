/*
PROBLEM STATEMENT
Given a string s of opening and closing brackets '(' and ')' only, find an equal point in the string. 
An equal point is a position k (0-based) such that the number of opening brackets before position k is equal to the number of closing brackets from position k to the end of the string.
If multiple such points exist, return the first valid position.

The string can be split at any position from 0 to n, where n is the length of the string.
If we split at 0, it means there is an empty string on left.
If we split at n, it means there is an empty string on right.

APPROCH:
1.our aim to check for index has equal opening bracket on left side and closing bracket at right side
2.first count closing brackets in the string 
3.Now iterate to track opening brackets
4.we will return index when we have equal open and close variable count

IF OUR STRING HAS ALL CLOSING BRACKETS
1. At the end of string we will have zero opening brackets at left and zero closing bracket at right
2.so we will check after whole array iteration whether our open , close variables

IF OUR STRING HAS ALL OPENING BRACKETS
1.At index '0' you will have zero opening brackets at left and zero closing bracket at right
2.so we will return index 0 fro this case
*/


class Solution {
    public int findIndex(String s) {
        int n=s.length();
        int close=0;
        int open=0;
        
        for(int i=0;i<n;i++){
         if(s.charAt(i)==')'){
             close++;
         }   
        }
        
        for(int i=0;i<n;i++){
            if(open==close){
                return i;
            }
            else{
                if(s.charAt(i)=='('){
                    open++;
                }
                else{
                    close--;
                }
            }
        }
        if(open==close){
            return n;
        }
        return 0;
    }
}

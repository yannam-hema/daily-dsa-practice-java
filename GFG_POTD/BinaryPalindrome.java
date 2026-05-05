/*
Given an integer n, determine whether its binary representation forms a palindrome.
Return true if the binary representation of n is a palindrome; otherwise, return false.
*/
class Solution {
    public boolean isBinaryPalindrome(int n) {
      //consider a stringBuilder
        StringBuilder sb = new StringBuilder();
      //Iterate number to find binary representation 
        while(n>0){
            sb.append(n%2);
            n=n/2;
        }
      //reverse the string to get the correct binary representation
        sb.reverse();
        int m=sb.length();
      // Checking our String is palindrome or not
        for(int i=0;i<=m/2;i++){
            if(sb.charAt(i)!=sb.charAt(m-i-1)){
                return false;
            }
        }
        return true;
    }
};

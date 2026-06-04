/*
PROBLEM STATEMENT:
Given a binary string s consisting of 0s and 1s. 
Find the maximum difference of the number of 0s and the number of 1s (number of 0s – number of 1s) in a substring of the string.

APPROCH:
This problem is Indirect way of asking implement Kadanes Algorithm , I mean find maximum sum subarray (asssume 0's 1 and 1's as -1)

SOLUTION:
Step1:As we have to find difference like this (number of 0s – number of 1s) we consider 0's as 1 and 1's as -1 
Step2 :Now perform Kadanes Algorithm
KADEN'S ALGORITHM
- initilaize sum=0,max_sum=minimum value
- Iterate the whole array , by adding current value to sum 
- At every index check our sum is greater than max_sum if yes we will update it
- And important if our sum<0 so it doesn't make moving on with current sum value as it decrease our subarray value we will make sum=0 and proceed
- At last we return max_sum at last
*/

class Solution {
    int maxSubstring(String s) {
        int n=s.length();
        int sum=0;
        int max_sum=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='0'){
               sum+=1; 
            }
            else{
                sum+=-1;
            }
            
            
            if(sum>max_sum){
                max_sum=sum;
            }
            
            if(sum<0){
                sum=0;
            }
        }
        return max_sum;
    }
}

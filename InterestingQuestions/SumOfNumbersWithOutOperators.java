/*
QUESTION:
Given two integers a and b, return the sum of the two integers without using the operators + and -.
*/
/*
SOLUTION APPROACH:
Using BitWise Operators
"Xor" will give us addition value
"and" will give us carry value --> here we left shift the carry as we do for the normal mathematical addition
we can add our xor and add value but we can't use + operator so we will continue this until our carry value becomes zero
*/

class Solution {
    public int getSum(int a, int b) {
       while(b!=0){
        int xor=a^b;
        int add=(a&b)<<1;
        a=xor;
        b=add;
       }
       return a;
    }
    
}

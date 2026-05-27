/*
QUESTION

There are n rooms in a straight line in Geekland State University's hostel. 
You are given a binary string s of length n, where s[i] = '1' means there is a WiFi router in the i-th room, and s[i] = '0' means there is no WiFi in that room.

Each WiFi router has a range of x, meaning it can cover up to x rooms to its left and x rooms to its right.

Given x and s, determine whether all rooms are covered by at least one WiFi router.
Return true if all rooms are covered; otherwise, return false.
----------------------------------------------------------------------------------------------------------------------------------------------------------------------
SOLUTION

Step 1: Create a boolean array to keep track of either wifi is covered or not
Step 2: Iterate through the string if the current is index '1' or not ,If it is '1' , we will make it true and we will check 
both sides to check wifi is accesibble or not andmake them true
Step3: After the whole iteration check boolean array if we find false we will return false otherwise true
*/

class Solution {
    public boolean wifiRange(String s, int x) {
        int n=s.length();
        boolean wifi [] = new boolean[n];
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1'){
                wifi[i]=true;
         for(int j=i;(j>=0 && j>=(i-x));j--) {
                wifi[j]=true;
         }
         for(int j=i; (j<n && j<=(i+x));j++){
                wifi[j]=true;
         }
        }
        }
        for(int i=0;i<n;i++){
            if(wifi[i]==false){
                return false;
            }
        }
        return true;
    }
}

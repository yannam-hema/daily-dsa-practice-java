/*
Given two integer arrays nums1 and nums2, sorted in non-decreasing order, return the minimum integer common to both arrays. 
If there is no common integer amongst nums1 and nums2, return -1.
Note that an integer is said to be common to nums1 and nums2 if both arrays have at least one occurrence of that integer.
*/

// Approach 1 : Store one array2 elements in a set and search for that element in Array1  .As the array elements are in increasing 
// order the first element common will be the smallest
//T.C = O(n+m)  s.c= O(m)
class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
     Set<Integer> st = new HashSet<>();
     int minCommon =Integer.MAX_VALUE;
     for(int i=0;i<nums2.length;i++){
        st.add(nums2[i]);
     }
     for(int i=0;i<nums1.length;i++){
        if( nums1[i]<minCommon && st.contains(nums1[i])){
            minCommon=nums1[i];
            break;
        }
     }
     if(minCommon == Integer.MAX_VALUE){
        return -1;
     }
     return minCommon;
    }
}
//Approach 2 : use two pointers and traverse both arrays simultaneously when we find common element we return it 
//T.C =O(n+m) S.C=O(1)
class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int i=0; int j=0;
        while(i<n && j<m){
            if(nums1[i]==nums2[j]){
                return nums1[i];
            }
            else{
                if(nums1[i]<nums2[j]){
                    i++;
                }
                else{
                 j++;
                }
            }
        }
    return -1;
    }
}

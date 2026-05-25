//Given an array arr[] containing distinct positive integers, and two integers start and end defining a range.
//Determine if the array contains all elements within inclusive range [start, end].

//Note: If the array contains all elements in the given range return true otherwise return false.

class Solution {
    public boolean checkElements(int start, int end, int[] arr) {
        // code here
        int n=arr.length;
        Set<Integer> st = new HashSet<>();
        for(int i=0;i<n;i++){
            st.add(arr[i]);
        }
        for(int i=start;i<=end;i++){
        if(!st.contains(i)){
            return false;
        }   
        }
        return true;
    }
}

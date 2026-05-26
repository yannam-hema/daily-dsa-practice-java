//Given an array arr[] containing only 0 and 1.
//Find the minimum toggles (switch from 0 to 1 or vice-versa) required such the array become partitioned, i.e., it has first 0s then 1s.

class Solution {
    int minToggle(int[] arr) {
        int n=arr.length;
        //variable to count at left Side
        int onesAtLeft=0;
        //Variable to zeros in the array
        int zeroCount=0;
        for(int i=0;i<n;i++){
            if(arr[i]==0){
                zeroCount++;
            }
        }
      //If our array doesn't have zeroes atall , we can say every left side element is '1'
        if(zeroCount==0){
            return 0;
        }
      //To find a minimum cost we use farmula at every index cost = (ones at left side of the Index + zeroes at right side of the Index)
      // At first we don't have ones at left side so we consider only zero count
        int minCost =zeroCount;
        for(int i=0;i<n;i++){
            if(arr[i]==1){
                onesAtLeft++;
            }
            else{
                zeroCount--;
            }
            int cost=onesAtLeft+zeroCount;
            minCost=Math.min(minCost,cost);
        }
        return minCost;
    }
}

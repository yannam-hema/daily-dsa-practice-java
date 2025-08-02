# length of the longest substring(Contigious elements / characters) Without Duplicates  
By meee :)
## Problem statement

Given a string might contain dupicate characters(of course), our task is to find the longest substring with out any duplicate characters

**example** s="abcdeabcefghac"

Substrings without duplicates characters are **a,b,c,d,e,f,g,h,ab,ac,abc,abcd,abcde,bc,bcd,bcde,abce,abcef,abcefg,abcefgh,bce,bcefgha,...**
-- here we can see two substrings with length **7**(bcefgha,abcefgh) those seems to longest among all so our output should be 7

**example2** s="hhhhhhhh";

our output should be **1** 

**example3** s=" ";
our output should be **1** 


## Brute Force approach 
### using Nested loops 

**Logic**
-- consider two loops , use set data structure to keep track of characters at each loop
-- iterate through string in **i** loop , in **j** loop start from i goes until our set has unique elements 
-- when we find duplicate elements then we can calculate length of the substring and if length is greater than the maximum length then we assign this length as maximum and breaks the j loop . This contnues until i<n

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        //brute force
        int n=s.length();
    
        int max=0;
        for(int i=0;i<n;i++){
            Set<Character> st = new HashSet<>();
            for(int j=i;j<n;j++){
            if(st.contains(s.charAt(j))){
                max=Math.max(max,(j-i));
                break;
            }
            else{
                st.add(s.charAt(j));
                max=Math.max(max,(j-i)+1);
            }
            }
        }
        return max;
    }
}

```

## Better Approach
--Instead of using two loops as it takes o(n)^2 time complexity --> so we can solve this using two pointers

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        //two pointer
        int n=s.length();
        Set<Character> st = new HashSet<>();
        int l=0;
        int r=0;
        int max=0;
        while(r<n){
         if(st.contains(s.charAt(r))){
            while(st.contains(s.charAt(r))){
                st.remove(s.charAt(l));
                l++;
            }
         }
            st.add(s.charAt(r));
            max=Math.max(max,(r-l+1));
         
         r++;
        }
    return max;
    }
}
```


## better Approach
--instead of using while loop to delete the character until set has unique we can directly make a jump to the index 

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = 0;
        int r = 0;
        int l = 0;
        int n = s.length();
        HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
        
        while (r < n) {
            if (hm.containsKey(s.charAt(r))) {
                l = Math.max(hm.get(s.charAt(r)) + 1, l);
            }
            hm.put(s.charAt(r), r);
            len = Math.max(len, r - l + 1);
            r++;
        }       
        return len;
    }
}

```


 

## 🔍 Problem: Majority Element

### 📅 Problem Statement

We are given an array `nums` of size `n`. We need to find the element that appears **more than ⌊n / 2⌋ times**. This element is called the **majority element**.

It is guaranteed that a majority element always exists in the array.

Example:

```java
Input: nums = [3,2,3]
Output: 3

Input: nums = [2,2,1,1,1,2,2]
Output: 2
```

---

### 🔫 Brute Force Approach

Use two loops:

* For each element, count its frequency using another loop.
* If its frequency is more than `n/2`, return that element.

This approach is simple but inefficient due to nested loops.

---

### 🔄 Better Approach

Use a **HashMap** to store the count of each element:

* Loop through array and maintain frequency in the map.
* Check if any frequency goes above `n/2`, return that number.

---

### 🃏 Optimal Approach (Moore’s Voting Algorithm)

* Initialize `count = 1` and `element = nums[0]`
* Traverse the array:

  * If `count == 0`, set `element = nums[i]`, `count = 1`
  * If current number equals `element`, increment count
  * Else decrement count

At the end, the `element` will be the majority element.

---

### ✅ Code (Java)

```java
class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int ele = nums[0];
        int count = 1;

        for (int i = 1; i < n; i++) {
            if (count == 0) {
                ele = nums[i];
                count = 1;
            } else if (nums[i] == ele) {
                count++;
            } else {
                count--;
            }
        }

        return ele;
    }
}
```

---

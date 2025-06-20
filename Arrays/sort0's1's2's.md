---

## 🔍 Problem: Sort Colors (Dutch National Flag Problem)

### 📅 Problem Statement

We are given an array `nums` containing only 0s, 1s, and 2s. We need to **sort the array in-place** so that all 0s come first, followed by all 1s, and then all 2s.

We must solve it **without using any library sort functions**.

Example:

```java
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
```

---

### 🔫 Brute Force Approach

Sort the array using any sorting algorithm like Bubble Sort or Selection Sort.

* Traverse the array and compare elements.
* Swap accordingly to bring the array in sorted order.

💡 This approach is simple but **not optimal** in terms of efficiency.

---

### 🔄 Better Approach

Use **counting**:

1. Count the number of 0s, 1s, and 2s.
2. Create a new array or overwrite the existing array with the correct number of 0s, 1s, and 2s in order.

#### Steps:

* Initialize three counters: `count0`, `count1`, `count2`
* Loop through array and update these counts
* Overwrite the original array: first fill with `count0` zeroes, then `count1` ones, and then `count2` twos

This is better than brute because we only traverse the array a few times.

---

### 🃏 Optimal Approach (Dutch National Flag Algorithm)

We solve this using three pointers:

* `low` – points to next place to put 0
* `mid` – current index being evaluated
* `high` – points to next place to put 2

We swap values as we go to keep 0s to the left, 2s to the right, and 1s in the middle.

---

### ✅ Code (Java)

```java
class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0;
        int mid = 0;
        int high = n - 1;

        // Loop until mid crosses high
        while (mid <= high) {
            if (nums[mid] == 0) {
                // Swap 0 with value at low and move both pointers forward
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // Just move mid if 1 is in place
                mid++;
            } else {
                // Swap 2 with value at high and move high pointer back
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}
```

---


### ✅ Problem: Find Maximum Consecutive 1s

Given a binary array `nums`, return the **maximum number of consecutive 1s** in the array.

---

### 🔍 Brute Force Approach

* **Idea:** For every index, if you see a 1, count consecutive 1s from there.
* **Time Complexity:** `O(n^2)`
* **Not efficient** for large arrays.

---

### 🚀 Optimal Approach (Single Pass)

* **Idea:** Traverse once. Use a counter for current streak of 1s and update max whenever a `0` is encountered.
* **Time Complexity:** `O(n)`
* **Space Complexity:** `O(1)`

---

### ✅ Java Code

```java
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;     // Current streak of 1s
        int maxCount = 0;  // Maximum streak found

        for (int num : nums) {
            if (num == 1) {
                count++; // Continue the streak
            } else {
                maxCount = Math.max(maxCount, count); // Update max
                count = 0; // Reset streak
            }
        }

        // Final check in case array ends with 1s
        maxCount = Math.max(maxCount, count);

        return maxCount;
    }
}
```

---

### 📌 Example

```java
Input:
nums = [1, 1, 0, 1, 1, 1]

Output:
3

Explanation:
There are two sequences of 1s: [1, 1] and [1, 1, 1]. Maximum = 3.
```


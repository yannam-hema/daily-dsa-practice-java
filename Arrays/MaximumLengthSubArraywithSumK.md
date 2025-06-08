
### 📘 Problem: Longest Subarray With Sum K (Positive Integers Only)

We are given an array `a[]` of positive integers and a target sum `k`.
Our task is to find the **length of the longest subarray** that sums exactly to `k`.

---

### 🧠 Example:

**Input**:
`a = [1, 2, 3, 1, 1, 1, 1, 4, 2, 3]`, `k = 6`
**Output**:
`3`

**Explanation**:
The subarrays that sum up to `6` are:

* `[1, 2, 3]` → length 3
* `[3, 1, 1, 1]` → sum exceeds 6
* `[1, 1, 1, 1, 2]` → sum = 6 → length 5 → **not valid** (this sum is not exactly 6)
* `[4, 2]` → length 2
  So, the longest subarray is `[1, 2, 3]` → length **3**

---

### 🧱 Brute Force Approach:

We consider every possible subarray, calculate the sum, and check if it equals `k`.

#### 💡 Steps:

1. Use two nested loops:

   * Outer loop for start index `i`
   * Inner loop for end index `j`
2. For every subarray from `i` to `j`, calculate the sum.
3. If the sum equals `k`, update the maximum length.

#### ⏱ Time Complexity:

* `O(N^2)` where `N` is the size of the array

---

### ⚡ Optimal Approach (Sliding Window Technique):

Since all elements are **positive**, we can use the sliding window technique efficiently.

#### 💡 Logic:

* Use two pointers: `l` (left) and `r` (right)
* Expand the window by moving `r` and add elements to the `sum`
* If the `sum` exceeds `k`, shrink the window from the left by moving `l`
* When `sum == k`, update the maximum length

---

### ✅ Java Code (Optimal Approach):

```java
public class Solution {
    public static int longestSubarrayWithSumK(int[] a, long k) {
        int n = a.length;
        long sum = 0;
        int max_len = 0;
        int l = 0;
        int r = 0;

        while (r < n) {
            sum += a[r];

            // Shrink the window if sum exceeds k
            while (sum > k && l <= r) {
                sum -= a[l];
                l++;
            }

            // If sum equals k, update max_len
            if (sum == k) {
                max_len = Math.max(max_len, (r - l) + 1);
            }

            r++;
        }

        return max_len;
    }
}
```


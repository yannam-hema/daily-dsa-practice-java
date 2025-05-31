
# 🔢 Leetcode 268: Missing Number

## 🧠 Problem Statement

Given an array `nums` containing `n` distinct numbers in the range `[0, n]`, return the only number in the range that is missing from the array.

---

## 🧪 Example

**Input:**
```
nums = [3, 0, 1]
```

**Output:**
```
2
```

---

## 🔍 Constraints

- `n == nums.length`
- `0 <= nums[i] <= n`
- All the numbers of `nums` are **unique**.
- One number from the range `[0, n]` is **missing**.

---

## ✅ Approaches

---

### 🐌 Brute Force Approach

1. Loop from `0` to `n`.
2. For each number, check if it is present in the array.
3. If not, that is the missing number.

**Drawbacks:**
- **Time Complexity:** `O(n²)`
- **Space Complexity:** `O(1)`
- Not efficient for large arrays.

---

### 🚀 Optimal Approach (Used in Code)

1. Find the **expected sum** of numbers from `0` to `n`:  
   \[
   \text{sum} = \frac{n(n+1)}{2}
   \]
2. Subtract the **actual sum** of the array elements from it.
3. The difference is the **missing number**.

- ✅ **Time Complexity:** `O(n)`  
- ✅ **Space Complexity:** `O(1)`  
- ✅ **In-place:** Yes  
- ✅ **Efficient and Simple**

---

## ✅ Java Code with Comments

```java
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;

        // Calculate expected sum of numbers from 0 to n
        int sum = (n * (n + 1)) / 2;

        // Calculate actual sum of elements in the array
        int sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum2 += nums[i];
        }

        // The difference is the missing number
        return sum - sum2;
    }
}
```



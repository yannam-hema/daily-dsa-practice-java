
### 🧠 Problem Statement

Given an integer array `nums`, move all `0`'s to the end of it **while maintaining the relative order of the non-zero elements**.

✅ This must be done **in-place**, meaning **no extra space** should be used.

---

### 🧪 Example

#### Input:

```
nums = [0, 1, 0, 3, 12]
```

#### Output:

```
[1, 3, 12, 0, 0]
```

---

### 🔍 Constraints

* `1 <= nums.length <= 10⁴`
* `-2³¹ <= nums[i] <= 2³¹ - 1`

---

## ✅ Approaches

---

### 🐢 Brute Force Approach

1. Create a **new array**.
2. Copy all non-zero elements into it.
3. Fill the remaining positions with zeroes.

🔻 Drawback: Uses **extra space** → violates the **in-place constraint**.

---

### 🔁 Better Approach (In-place using two passes)

1. Iterate over the array and **move all non-zero elements** to the front.
2. Maintain an index `k` to track where to place the next non-zero.
3. After the first pass, **fill the remaining positions** with zeroes.

✅ Time: `O(n)`
✅ Space: `O(1)`
✅ Maintains order of non-zero elements
✅ In-place


### ✅ Java Code 

```java
class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int k = 0; // Pointer to track position to insert next non-zero element

        // First pass: Move non-zero elements to the front
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }

        // Second pass: Fill remaining positions with zeroes
        for (int i = k; i < n; i++) {
            nums[i] = 0;
        }
    }
}
```

---


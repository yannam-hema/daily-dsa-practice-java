
And we return the indices `[i, j]`.

📌 Each input will have **exactly one solution**, and we **can’t use the same element twice**.

---

## 🧪 Example:

**Input:**  
`nums = [2, 7, 11, 15]`, `target = 9`

**Explanation:**  
`nums[0] + nums[1] = 2 + 7 = 9`  
So, we return `[0, 1]`

---

## 🧱 Brute Force Approach:

We try all possible pairs using two loops.

### 👣 Steps:
1. For every element `i`, loop through every other element `j > i`.
2. Check if `nums[i] + nums[j] == target`.

### ⏱ Time Complexity:
- `O(N^2)`

---

## 🚀 Better Approach (Using HashMap):

We store all elements with their indices in a map first.  
Then, we loop again to check if the complement (`target - nums[i]`) is present in the map.

### ⚠️ We must make sure:
- The element isn’t using the same index twice.

---

## ✅ Our Optimal Java Code (With Full Comments):

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>(); // Stores number → index
        int result[] = new int[2];

        // Step 1: Add all elements to the map
        for (int i = 0; i < n; i++) {
            mp.put(nums[i], i);
        }

        // Step 2: Loop again to check for target - current value
        for (int i = 0; i < n; i++) {
            int curr = nums[i];
            int rem = target - curr; // What number do we need?

            // Check if rem exists and is not the same index
            if (mp.containsKey(rem) && mp.get(rem) != i) {
                result[0] = i;
                result[1] = mp.get(rem);
                break;
            }
        }

        return result;
    }
}
Time & Space Complexity:
Time: O(N) — We loop twice but each step is constant due to HashMap

Space: O(N) — For storing the elements in the map
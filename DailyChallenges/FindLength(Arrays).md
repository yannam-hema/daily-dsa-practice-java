

## 🎨 Problem: Minimum Number of Items Left After Pair Cancellation

We are given two arrays, `color[]` and `radius[]`, representing a sequence of colored items, each with a specific radius.
Our task is to **cancel out adjacent matching pairs**, where a pair is defined as having the **same color and same radius**.

Each time we find such a pair next to each other in the list (after considering previous cancellations), we remove them.
At the end, we need to return the **number of remaining items**.

---

### 🧠 Example:

**Input**:
`color = [1, 2, 2, 1]`
`radius = [3, 4, 4, 3]`

**Explanation**:

* Start with the first element `(1,3)`
* Next: `(2,4)` → different → push
* Next: `(2,4)` again → same as previous → **cancel**
* Stack now: `(1,3)`
* Next: `(1,3)` → same as top → **cancel**

All are cancelled.
**Output**: `0`

---

### 🧱 Brute Force Approach:

We can repeatedly traverse the array and cancel adjacent pairs whenever they match.

#### 💡 Steps:

1. Loop through the arrays.
2. If `color[i] == color[i+1]` and `radius[i] == radius[i+1]`, remove both.
3. Repeat until no more cancellations can be made.

But this approach would be inefficient due to repeated scans.

#### ⏱ Time Complexity:

* Worst Case: `O(N^2)`

---

### ⚡ Optimal Approach: Stack Simulation

We can treat the list of items like a **stack**:

* Push items onto the stack.
* If the current item matches the **top of the stack**, pop it (cancel).
* Else, push it.

This ensures we process each item only once.

---

### ✅ Java Code (Optimal Stack-Based):

```java
class Solution {
    public int findLength(int[] color, int[] radius) {
        ArrayList<Integer> colorLs = new ArrayList<>();
        ArrayList<Integer> radiusLs = new ArrayList<>();

        for (int i = 0; i < color.length; i++) {
            int size = colorLs.size();

            // Check if top of stack matches current item
            if (size > 0 && colorLs.get(size - 1) == color[i] && radiusLs.get(size - 1) == radius[i]) {
                // Cancel the matching pair
                colorLs.remove(size - 1);
                radiusLs.remove(size - 1);
            } else {
                // Push current item to stack
                colorLs.add(color[i]);
                radiusLs.add(radius[i]);
            }
        }

        // The remaining stack size is the number of items left
        return colorLs.size();
    }
}
```

---

### ⏱ Time and Space Complexity:

* **Time**: `O(N)` — each element is pushed and popped at most once
* **Space**: `O(N)` — for the stack simulation


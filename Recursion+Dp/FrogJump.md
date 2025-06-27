# 🐸 Frog Jump - Recursive + Memoization Solution (Java)

## 🔸 Problem Statement
We are given an array `height[]` where a frog is standing at the first index (`0`) and wants to reach the last index (`n-1`).

The frog can:
- Jump to the next index (`i + 1`)
- Or jump two steps ahead (`i + 2`)

The cost of each jump is the absolute difference between heights:  
`|height[i] - height[j]|`

Our goal is to calculate the **minimum total cost** to reach the end.

---

## 🔁 Approach: Recursion + Memoization (Top-Down DP)

### 🧠 Idea:
- Start from index `0` and recursively try both jump options.
- For each step:
  - Calculate cost of jumping one step
  - Calculate cost of jumping two steps (if possible)
- Return the **minimum** of both.
- Use a `dp[]` array to store already solved results (memoization).

---

### ⚙️ Base Case:
- If we reach the last index (`i == n - 1`), cost is `0`.

---

## ✅ Java Code

```java
class Solution {
    int minCost(int[] height) {
        int n = height.length;
        int dp[] = new int[n];
        
        // Initialize all dp values to -1
        for (int j = 0; j < n; j++) {
            dp[j] = -1;
        }
        
        // Start from index 0
        int i = 0;
        int result = frogJump(i, height, n, dp);
        return result;
    }

    public static int frogJump(int i, int h[], int n, int dp[]) {
        // Base case: if we are at the last index
        if (i == n - 1) {
            return 0;
        }

        // If already solved, return stored result
        if (dp[i] != -1) {
            return dp[i];
        }

        // One-step jump
        int one_step = Math.abs(h[i] - h[i + 1]) + frogJump(i + 1, h, n, dp);

        // Two-step jump (only if valid)
        int second_step = Integer.MAX_VALUE;
        if (i < n - 2) {
            second_step = Math.abs(h[i] - h[i + 2]) + frogJump(i + 2, h, n, dp);
        }

        // Store and return the minimum cost
        return dp[i] = Math.min(one_step, second_step);
    }
}

# House Robber Problem

## Problem Statement

There is a robber planning to rob houses along a street. Each house has a certain amount of money stashed. The only constraint is: the robber **cannot rob two adjacent houses**, otherwise the police will be alerted.

The goal is to find the **maximum amount of money** the robber can steal without robbing two adjacent houses.

---

## Recursive Approach (Brute Force)

We can't use a greedy solution here because taking the best option at each step doesn't guarantee the optimal solution in the end. We need to explore all possibilities. So, we go with recursion first.

The idea is to treat this like a maximum sum of non-adjacent elements (like a subsequence problem).

### Intuition:

At each index `i`, we have two choices:

1. **Pick** the current house: Add `nums[i]` to the result and move to index `i+2` (since we skip the next house).
2. **Don't pick** the current house: Move to index `i+1`.

We return the maximum of these two choices.

### Base Cases:

* If `i == n - 1`, we return `nums[i]`, since we are at the last house.
* If `i > n - 1`, we return `0`, since we’ve moved past the last house.

---

## Dynamic Programming Solution 

```java
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int i = 0;
        int dp[] = new int[n];
        for (int j = 0; j < n; j++) {
            dp[j] = -1;
        }
        int result = maxRob(i, nums, n, dp);
        return result;
    }

    public static int maxRob(int i, int nums[], int n, int dp[]) {
        if (i == n - 1) {
            return dp[i] = nums[i];
        }
        if (i > n - 1) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int pick = nums[i] + maxRob(i + 2, nums, n, dp);
        int not_Pick = maxRob(i + 1, nums, n, dp);

        return dp[i] = Math.max(pick, not_Pick);
    }
}
```

### Explanation:

* We start from index `0`.
* We initialize a `dp` array to store intermediate results (memoization) and avoid recomputation.
* We handle two base cases:

  * If `i == n - 1`: we're at the last house, so return its value.
  * If `i > n - 1`: no house to rob, return 0.
* For each house:

  * **Pick** it: add its value and move to `i + 2`.
  * **Don't pick** it: move to `i + 1`.
* Store the maximum result in `dp[i]` to reuse it later.

This reduces the time complexity from **O(2^n)** (in recursion) to **O(n)** using memoization.

---



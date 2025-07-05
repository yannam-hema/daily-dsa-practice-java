

# House Robber II Problem (Circular Street)

## Problem Statement

In this variation, the houses are arranged in a **circle** instead of a straight line. This means the **first and last house are neighbors**, so the robber **cannot** rob both the first and last houses.

The goal is still to find the **maximum amount** of money the robber can steal, **without robbing two adjacent houses**, and also **not robbing both the first and last** houses together.

---

## Recursive Approach (Brute Force)

To handle the circular constraint, we split the problem into **two linear subproblems**:

1. Rob houses from **index 0 to n-2** (exclude last house)
2. Rob houses from **index 1 to n-1** (exclude first house)

Take the **maximum** of these two cases.

### Recursive Code:

```java
public static int func(int[] a, int i, int n) {
    // Base case: reached the last index in range
    if (i == n - 1) return a[i];
    if (i > n - 1) return 0;

    // Recursive choices
    int pick = a[i] + func(a, i + 2, n);
    int notPick = func(a, i + 1, n);

    return Math.max(pick, notPick);
}
```

To solve the circular problem:

```java
int m = nums.length;
if (m == 1) return nums[0];

int result = Math.max(func(nums, 0, m - 1), func(nums, 1, m));
```

---

## Dynamic Programming Solution (Top-Down with Memoization)

```java
class Solution {
    public int rob(int[] nums) {
        int m = nums.length;

        // Edge case: only one house
        if (m == 1) {
            return nums[0];
        }

        int dp1[] = new int[m];
        int dp2[] = new int[m];

        // Initialize dp arrays with -1
        for (int i = 0; i < m; i++) {
            dp1[i] = -1;
            dp2[i] = -1;
        }

        // Exclude last house: range 0 to m-2
        int case1 = func(nums, 0, m - 1, dp1);
        // Exclude first house: range 1 to m-1
        int case2 = func(nums, 1, m, dp2);

        return Math.max(case1, case2);
    }

    public static int func(int[] a, int i, int n, int[] dp) {
        if (i == n - 1) {
            return dp[i] = a[i];
        }
        if (i > n - 1) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        // Pick current house and skip next
        int pick = a[i] + func(a, i + 2, n, dp);
        // Skip current house
        int not_pick = func(a, i + 1, n, dp);

        return dp[i] = Math.max(pick, not_pick);
    }
}
```

### Explanation:

* We can't take both first and last houses, so we split it into two scenarios.
* Solve both using the same memoized recursive function.
* Each call maintains its own `dp` array.

Time Complexity: **O(n)**
Space Complexity: **O(n)** (for dp arrays)

---


🔍 Problem: Check if Kth Bit is Set
🧾 Problem Statement
We are given two integers:

n — the number whose bit we want to check.

k — the position (1-based) of the bit we want to verify.

We need to determine whether the kth bit in the binary representation of n is set (i.e., is 1).

🧠 Concept
To check whether a specific bit is set in a number, we can use bit manipulation.

In this problem, our goal is to check if the kth bit from the right (1-based indexing) in the number n is set.

🧾 Explanation
Let’s take an example:

java
Copy
Edit
n = 13    // Binary: 1101
k = 3
We are checking whether the 3rd bit (from the right) is set.

🔧 Step-by-step:
Right shift n by (k - 1) bits:
This will bring the kth bit to the least significant bit (rightmost position).
For n = 13, k = 3:
n >> (3 - 1) → 13 >> 2 → binary becomes 0011 (i.e., 3)

Perform bitwise AND with 1:
3 & 1 → 0011 & 0001 → 0001 → result is 1 which means kth bit is set

If the result is 1, it means the kth bit was set.
If the result is 0, it means the kth bit was not set.

✅ Final Code (Java)
java
Copy
Edit
public class Solution {
    static boolean isKthBitSet(int n, int k) {
        // Right shift the number 'n' by (k - 1) positions
        n = n >> (k - 1);

        // Check if the least significant bit is set (1)
        return (n & 1) > 0;
    }
}

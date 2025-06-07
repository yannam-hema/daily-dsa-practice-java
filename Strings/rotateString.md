

## 📝 Problem Statement

Given two strings `s` and `goal`, the task is to check whether we can rotate string `s` any number of times so that it becomes equal to `goal`.

A **rotation** means shifting the first character of the string to the end repeatedly.

---

## 📌 Examples

### Example 1:

```
Input: s = "abcde", goal = "cdeab"  
Output: true

Explanation:  
After 2 rotations —>  
"abcde" → "bcdea" → "cdeab" → matches `goal`
```

---

### Example 2:

```
Input: s = "abcde", goal = "abced"  
Output: false

Explanation:  
No rotation of "abcde" can produce "abced".
```

---

## 🔍 Approaches

---

### 1. 💭 Brute Force

#### 🔸 Idea:

Try all possible rotations of the string `s` and check if any rotation is equal to `goal`.

#### 🔢 Steps:

- Loop through all indices `i` from `0` to `n - 1`.
- For each `i`, rotate the string manually using loops:
  - First add characters from index `i` to end.
  - Then add characters from `0` to `i - 1`.
- Compare this rotated string to `goal`.

#### ⏱ Time Complexity:  
- O(n²) — since we build and compare strings of length `n` for each of `n` positions.

#### 💡 Note: I didn’t use any built-in methods like `.contains()` in this brute force approach.

---

### 2. ⚙️ Better Approach

#### 🔸 Idea:

Concatenate string `s` with itself to get `s + s`. If `goal` is a **substring** of this combined string, it's a valid rotation.

This is more efficient in theory, but to stay true to manual practice, I implemented the checking part using loops — not using `.contains()`.

#### ⏱ Time Complexity:  
- O(n²) worst case (for manual matching within `s + s`)

---

### 3. 🚀 Optimal Approach (Manual Matching in Duplicated String)

This is the approach I implemented. I manually checked if `goal` exists in `s + s` using two nested loops without using any pre-built functions.

---

## ✅ Java Code (Optimal)

```java
class Solution {
    public boolean rotateString(String s, String goal) {
        int n = s.length();
        int m = goal.length();

        // Step 1: Lengths must be equal
        if (n != m) {
            return false;
        }

        // Step 2: Duplicate the original string: s + s
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i));
        }

        String new_s = sb.toString();  // Combined string of length 2n

        // Step 3: Manually check if `goal` is a substring of `new_s`
        for (int i = 0; i < new_s.length() - m + 1; i++) {
            int k = 0;
            while (k < m && new_s.charAt(i + k) == goal.charAt(k)) {
                k++;
            }
            if (k == m) return true;
        }

        return false;
    }
}
```

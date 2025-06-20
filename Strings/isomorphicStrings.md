
---

## 🧩 Problem: Isomorphic Strings

---

### 🔍 Problem Statement

Given two strings `s` and `t`, determine if they are **isomorphic**.

Two strings are isomorphic if the characters in `s` can be replaced to get `t`, with each character mapping to another character **uniquely** and **consistently**.

---

### 📌 Example

```txt
Input:  s = "egg", t = "add"
Output: true

Input:  s = "foo", t = "bar"
Output: false

Input:  s = "paper", t = "title"
Output: true
```

---

## 💡 Approaches

### 1. 🐢 Brute Force (Not Recommended)

* **Idea**: Try all possible character mappings from `s` to `t` and check if they’re consistent.
* **Time Complexity**: `O(n^2)`
* **Space Complexity**: `O(n)`
* **Drawback**: Inefficient for larger strings due to checking and backtracking multiple mappings.

---

### 2. 🚀 Optimal Approach (Two HashMaps)

* **Idea**:
  Use two hash maps to keep track of character mappings from `s` to `t` and `t` to `s`. This ensures a **one-to-one** mapping in both directions.

* **Steps**:

  1. If lengths are not equal, return false.
  2. Traverse both strings simultaneously.
  3. Use:

     * `mpS` for `s -> t` mapping.
     * `mpT` for `t -> s` mapping.
  4. For every character:

     * If already mapped, check if mapping is consistent.
     * If not, store the mapping.

* **Time Complexity**: `O(n)`

* **Space Complexity**: `O(1)` (since max distinct characters = 256)

---

### ✅ Java Code with Comments

```java
import java.util.*;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        // Step 1: Length check
        if (s.length() != t.length()) {
            return false;
        }

        int n = s.length();

        // Maps to keep track of both directions
        Map<Character, Character> mpS = new HashMap<>(); // s -> t
        Map<Character, Character> mpT = new HashMap<>(); // t -> s

        // Step 2: Traverse both strings
        for (int i = 0; i < n; i++) {
            char s_curr = s.charAt(i);
            char t_curr = t.charAt(i);

            // If s -> t mapping exists, check consistency
            if (mpS.containsKey(s_curr)) {
                if (mpS.get(s_curr) != t_curr) {
                    return false;
                }
            } else {
                mpS.put(s_curr, t_curr);
            }

            // If t -> s mapping exists, check consistency
            if (mpT.containsKey(t_curr)) {
                if (mpT.get(t_curr) != s_curr) {
                    return false;
                }
            } else {
                mpT.put(t_curr, s_curr);
            }
        }

        // All checks passed
        return true;
    }
}
```

---


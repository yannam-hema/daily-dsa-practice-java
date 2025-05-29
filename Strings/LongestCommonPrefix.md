
## 🧠 Detailed Problem Explanation

### 🧩 Problem Summary:

We're given an array of strings. Our task is to:

1. Find the **longest common prefix** string that is shared by all strings.
2. If no common prefix exists, return an empty string `""`.

---


### 📊 Example:

Input: strs = ["flower", "flow", "flight"]
Output: "fl"

Input: strs = ["dog", "racecar", "car"]
Output: ""
Explanation: There is no common prefix among the input strings.
```

---

### 🔁 Step-by-Step Dry Run

Let’s take the first example: `["flower", "flow", "flight"]`

* Step 1: All strings have to be compared character by character.
* The shortest string has length 4 (`flow`).
* Compare first character of all → `"f"` → ✅
* Compare second character → `"l"` → ✅
* Compare third character → `"o"` vs `"i"` → ❌ → stop here.

✅ Output: `"fl"`

---

### 🧠 Key Points

* All characters must match in **order from the start**.
* The **shortest string length** is a natural upper bound on prefix length.
* As soon as a mismatch is found, we return what we’ve matched so far.
* Efficient character-by-character checking ensures good performance.

---

### 💼 Real-World Analogy

Imagine a set of URLs we're grouping together — like `"https://site.com/user1"`, `"https://site.com/user2"`, etc. We're trying to find the **common base URL** they all share.

---

## ❌ Brute Force Approach

We could:

1. Take the first string.
2. Start checking each prefix of it (from longest to shortest).
3. Verify whether each prefix is also a prefix of every other string.

This is highly inefficient and repeated string matching makes it costly.

⛔ Not optimal due to repeated work.

---

## ✅ Optimal Approach

We use a **character-by-character scan**, comparing all strings column-wise (i.e., vertical scanning).

---

### 🔍 Explanation of Our Code

```java
public String longestCommonPrefix(String[] strs) {
    int n = strs.length;
    int min_len = Integer.MAX_VALUE;
    StringBuilder sb = new StringBuilder();
```

* We store the number of strings in `n`.
* We track the **minimum string length** (`min_len`) to avoid index errors.
* `StringBuilder sb` will hold the result — the common prefix we build.

---

```java
    for (int i = 0; i < n; i++) {
        int m = strs[i].length();
        min_len = Math.min(min_len, m);
    }
```

* First loop: Calculate the minimum string length among all strings.
* We only compare characters up to the length of the shortest string.

---

```java
    for (int i = 0; i < min_len; i++) {
        char c = strs[0].charAt(i);         // Take the i-th character of the first string
        for (int j = 1; j < n; j++) {
            if (c != strs[j].charAt(i)) {
                return sb.toString();       // If any character doesn’t match, return current prefix
            }
        }
        sb.append(c);                       // If all characters matched at i-th position, add to prefix
    }
```

* Second loop: Character-by-character scan.
* For each index `i`, we take the char from the first string and compare it to all other strings at the same index.
* If they all match → we add it to the `StringBuilder`.
* The moment one mismatch occurs → we stop and return what we have so far.

---

```java
    return sb.toString();                   // Final common prefix
}
```

* After the loop, we return the built prefix.

---


* **Time Complexity:** `O(n * m)` — where `n` is number of strings, `m` is min string length.
* **Space Complexity:** `O(1)` extra (excluding result).



## 🧠 Detailed Problem Explanation

### 🧩 Problem Summary:

We are given two strings `s` and `t`. Our task is to **check whether `t` is an anagram of `s`**.

A string `t` is an anagram of `s` if it contains **exactly the same characters**, with the **same frequencies**, possibly in a different order.

---

### 📘 What’s an Anagram?

> An anagram is just a **rearrangement** of letters from another word.

For example:

* `"listen"` and `"silent"` are anagrams.
* `"rat"` and `"car"` are **not** anagrams.

---

### 📊 Example:

```java
Input: s = "anagram", t = "nagaram"
Output: true

Input: s = "rat", t = "car"
Output: false
```

---

### 🔁 Step-by-Step Dry Run

Example: s = `"anagram"`, t = `"nagaram"`

1. Both strings have length 7 ✅
2. Count frequency of each letter in `s`: `{a: 3, n:1, g:1, r:1, m:1}`
3. Subtract frequency of each letter in `t`: `{a: 0, n:0, g:0, r:0, m:0}`
4. If all counts are zero → ✅ Anagram

---

### 🧠 Key Points

* Only lowercase English letters are used (`'a'` to `'z'`).
* We use a **frequency array** of size 26.
* If frequencies match for all characters → the strings are anagrams.

---

### 💼 Real-World Analogy

Imagine two containers of letter tiles. To check if they’re anagrams, we match **count of each letter**. If any letter appears more in one than the other → Not an anagram.

---

## ❌ Brute Force Approach

1. Sort both strings.
2. If sorted strings are equal → anagrams.

```java
Arrays.sort(s.toCharArray());
Arrays.sort(t.toCharArray());
return s.equals(t);
```

**Drawbacks**:
- Sorting takes `O(n log n)` time.
- Not optimal when we can use counting instead.

---

## ✅ Optimal Approach

We use a **frequency count technique** with a fixed-size array of 26 (for each alphabet letter).

---

### 🔍 Explanation of Our Code

```java
public boolean isAnagram(String s, String t) {
    int n = s.length();
    int m = t.length();
    if (n != m) return false;
```

* If lengths differ → can’t be anagrams.

---

```java
    int freq[] = new int[26];
    for (int i = 0; i < 26; i++) {
        freq[i] = 0;
    }
```

* Initialize frequency array for 26 lowercase letters.

---

```java
    for (int i = 0; i < n; i++) {
        freq[s.charAt(i) - 'a']++;
    }
    for (int j = 0; j < m; j++) {
        freq[t.charAt(j) - 'a']--;
    }
```

* For each char in `s`, increment its frequency.
* For each char in `t`, decrement its frequency.
* In the end, all frequencies should be 0 if they are truly anagrams.

---

```java
    int cnt = 0;
    for (int i = 0; i < 26; i++) {
        if (freq[i] != 0) {
            cnt++;
        }
    }
    return cnt == 0;
}
```

* Count how many frequencies are non-zero.
* If zero → strings are perfect anagrams.

---

### ✅ Why This Code is Optimal

* **Time Complexity:** `O(n)` — Single pass through both strings.
* **Space Complexity:** `O(1)` — Frequency array of fixed size (26).
* **Efficient and clean**, especially when characters are only lowercase English letters.

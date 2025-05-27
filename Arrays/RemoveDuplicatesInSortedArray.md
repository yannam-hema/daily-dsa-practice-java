
## 🧠 Detailed Problem Explanation

### 🧩 Problem Summary:

You're given a **sorted array** of integers in **non-decreasing order**. You need to:

1. **Remove duplicates in-place** (without using extra space).
2. Ensure only **unique elements remain at the beginning** of the array.
3. Return `k` – the count of unique elements.

The remaining elements (after the first `k`) don't matter and can be ignored.

---

### 📘 Why “in-place” Matters?

> "In-place" means you have to modify the given array itself — without creating another array to store the result. You can only use **constant extra space** (like a few variables).

---

### 📊 Example:

```java
Input: nums = [1, 1, 2, 2, 3]

Goal: Move only unique elements to the start → [1, 2, 3, _, _]
Return: 3 (number of unique elements)
```

Let’s go step-by-step:

---

### 🔁 Step-by-Step Dry Run

Initial Array:
`[1, 1, 2, 2, 3]`

* Start from index `0`, first unique number is `1`.
* Next number is also `1` → **duplicate** → skip it.
* Move to `2` → it's new → **place it after `1`** → array becomes:
  `[1, 2, 2, 2, 3]`
* Move to next `2` → duplicate → skip it.
* Next is `3` → it's new → **place it after `2`** → array becomes:
  `[1, 2, 3, 2, 3]`

Final modified array:
`[1, 2, 3, _, _]` → only first 3 elements are unique.

✅ Output: `3`

---

### 🧠 Key Points

* The **array is sorted**, which means **all duplicates are together**.
* You only need to keep one copy of each number.
* Use a **two-pointer technique**:

  * One pointer for current unique value (slow pointer)
  * One pointer to scan the array (fast pointer)

---

### 💼 Real-World Analogy

Imagine a **queue of students** sorted by their roll number. Your task is to **remove duplicate IDs**, but you can’t create a new list. Just shift the unique ones to the front, and let the extras stay at the end of the queue (we won’t care about them).

---
## ❌Brute Force Approach
We can:

Use a Set to collect unique elements

Overwrite nums[] with values from the set

Return the set’s size

But this uses extra space, which violates the in-place condition.

Not allowed due to space constraint.
## ✅Optimal Approach

We use the two-pointer technique:

Pointer i tracks the last unique element

Pointer j scans through the array

When nums[j] != nums[i], we found a new unique element

Move i forward and set nums[i] = nums[j]


---

### 🔍 Explanation of Our Code

```java
public int removeDuplicates(int[] nums) {
    int n = nums.length;                   // Total length of the array
    int current = nums[0];                 // First unique element (starting point)
    int i = 0;                             
    int j = i + 1;                         // j starts from the next element
```

* We use **`i`** to track the position of the **last unique element**.
* **`j`** explores the rest of the array to find the next **different** element.

---

```java
    while (j < n) {
        if (nums[j] == current) {
            while (j < n && nums[j] == current) {
                j++;                      // Skip all duplicates of current
            }
        }
```

* If `nums[j]` is same as `current`, we skip all such elements using the **inner while loop**.
* This ensures we jump straight to the **next unique number**.

---

```java
        if (j < n) {
            nums[i + 1] = nums[j];       // Place the next unique element right after i
            current = nums[j];           // Update current to new unique
            i++;                         // Move i forward to mark new end of unique part
            j++;                         // Move j forward
        }
    }
```

* Once a new unique element is found, we:

  * Place it in the next index after `i`
  * Update `current` to this new unique value
  * Move both pointers ahead

---

```java
    return i + 1;                         // Number of unique elements
}
```

* Since `i` points to the last index of the unique portion, we return `i + 1` as the **count of unique elements**.

---

### ✅ Why This Code is Optimal

* **Time Complexity:** `O(n)` — Each element is visited at most twice.
* **Space Complexity:** `O(1)` — No extra space used; only pointers.
* **In-place:** The original array is modified to store the result.

---


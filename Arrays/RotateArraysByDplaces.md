
## 🧠 Detailed Problem Explanation

### 🧩 Problem Summary:

We're given an **array** of integers and a number `D`. We need to:

1. Rotate the array **to the left** by `D` positions.
2. The operation must be done **in-place** (no extra array allowed).
3. Return or print the rotated array.

---

### 📘 Why “in-place” Matters?

> "In-place" means we must modify the given array **without** using any additional arrays or significant extra space. We can only use a few variables.

---

### 📊 Example:

```java
Input: arr = [1, 2, 3, 4, 5, 6, 7], D = 2

Goal: Shift elements to the left by 2 positions

Output: [3, 4, 5, 6, 7, 1, 2]
```

Let’s walk through the steps:

---

### 🔁 Step-by-Step Dry Run

Initial Array:  
`[1, 2, 3, 4, 5, 6, 7]`  
Rotate by 2 positions.

* First step: Reverse the **first D elements** → reverse `[1, 2]` → becomes `[2, 1]`
* Second step: Reverse the **rest of the array** → reverse `[3, 4, 5, 6, 7]` → becomes `[7, 6, 5, 4, 3]`
* Third step: Reverse the **entire array** → reverse `[2, 1, 7, 6, 5, 4, 3]` → final array:

✅ Result: `[3, 4, 5, 6, 7, 1, 2]`

---

### 🧠 Key Points

* We can rotate an array in-place using the **reverse trick**.
* This approach doesn’t use extra space and finishes in linear time.
* Works for both **left** and **right** rotations (with a sign change in D).

---

### 💼 Real-World Analogy

Imagine a **queue** of people. We’re asked to **move the first D people to the back**, maintaining the order. Instead of pulling them out and adding to a new queue, we turn parts of the line around and then fix the entire line — smart and space-saving!

---

## ❌ Brute Force Approach

We can:

* Run a loop `D` times.
* On each iteration, shift the entire array to the left by 1 element.

Example:
```java
for d times:
    store first element
    shift all others left by 1
    put stored element at end
```

❌ This works but is **O(n × D)** in time, which is inefficient for large inputs.

---

## ✅ Optimal Approach

We use the **reverse algorithm**:

1. Reverse first `D` elements
2. Reverse the rest of the array
3. Reverse the entire array

---

### 🔍 Explanation of Our Code

```java
public void rotate(int[] arr, int d) {
    int n = arr.length;

    d = d % n;  // Handle cases where d > n
    reverse(arr, 0, d - 1);        // Step 1
    reverse(arr, d, n - 1);        // Step 2
    reverse(arr, 0, n - 1);        // Step 3
}

public void reverse(int[] arr, int start, int end) {
    while (start < end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        start++;
        end--;
    }
}
```

---

### ✅ Why This Code is Optimal

* **Time Complexity:** `O(n)` — Every element is visited at most twice.
* **Space Complexity:** `O(1)` — Only a few variables used.
* **In-place:** We directly manipulate the input array without using extra space.

# 🧠 Problem: Fibonacci Number Using Recursion

## 📌 Problem Summary:

You're given a number `n`, and you need to return the `n`th Fibonacci number.

The **Fibonacci series** looks like this:

```
0, 1, 1, 2, 3, 5, 8, 13, ...
```

Each number is the sum of the two numbers before it:

```
fib(n) = fib(n-1) + fib(n-2)
```

Also,

* fib(0) = 0
* fib(1) = 1

---

## 🧪 Example and Dry Run

### Example:

```
Input: n = 4
Output: 3
```

### Dry Run (step-by-step for n = 4):

```
fib(4)
= fib(3) + fib(2)
= (fib(2) + fib(1)) + (fib(1) + fib(0))
= ((fib(1) + fib(0)) + 1) + (1 + 0)
= ((1 + 0) + 1) + (1 + 0)
= (1 + 1) + 1 = 2 + 1 = 3
```

---

## 🔑 Key Concepts:

* **Recursion**: A function that calls itself to solve smaller subproblems.
* **Base Cases**:

  * `fib(0)` returns 0
  * `fib(1)` returns 1
* **Recursive Case**:

  * `fib(n) = fib(n-1) + fib(n-2)`

---

## 💡 Real-Life Analogy:

Think of climbing stairs:

* To get to step `n`, you could have come from step `n-1` or step `n-2`.
* The total ways to reach step `n` is the sum of the ways to reach `n-1` and `n-2`.

---

## 🦾 Java Code (Recursive Solution):

```java
class Solution {
    public int fib(int n) {
        if (n == 0) {
            return 0; // base case 1
        }
        if (n == 1) {
            return 1; // base case 2
        }
        return fib(n - 1) + fib(n - 2); // recursive case
    }
}
```

---

## 🧠 Explanation :

Hey! So, in this code we’re calculating the Fibonacci number using **recursion**.

1. First, we check for the **base cases**. If `n` is 0 or 1, we directly return 0 or 1.
2. For any `n > 1`, we say: "Okay, I don’t know the answer yet, but I know how to get it!"
   So we break it down into smaller subproblems: `fib(n-1)` and `fib(n-2)` and call the function again.
3. Eventually, every call keeps breaking down until it hits the base cases (like a chain of smaller questions).

It’s kinda like solving a big math puzzle by solving smaller and smaller pieces till you hit the simplest one!

--
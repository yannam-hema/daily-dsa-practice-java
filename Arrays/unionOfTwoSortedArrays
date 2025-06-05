
### ✅ Problem: Union of Two Sorted Arrays

Given two sorted arrays, return the **union** of the arrays (i.e., all unique elements present in either array), in **sorted order**.

---

### 🔍 Brute Force Approach

* **Idea:** Combine both arrays, insert into a set to remove duplicates, then sort the result.
* **Time Complexity:** `O((n + m) log(n + m))` due to sorting
* **Space Complexity:** `O(n + m)`

```java
import java.util.*;

public class Solution {
    public static List<Integer> sortedArray(int[] a, int[] b) {
        Set<Integer> set = new HashSet<>();
        for (int num : a) set.add(num);
        for (int num : b) set.add(num);

        List<Integer> result = new ArrayList<>(set);
        Collections.sort(result);
        return result;
    }
}
```

---

### 🚀 Optimal Approach (Two Pointer Technique)

* **Idea:** Since both arrays are sorted, use two pointers to traverse both arrays and add unique elements to the result list.
* **Time Complexity:** `O(n + m)`
* **Space Complexity:** `O(n + m)` (result list)

---

### ✅ Java Code with Comments

```java
import java.util.*;

public class Solution {
    public static List<Integer> sortedArray(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int i = 0, j = 0;

        List<Integer> result = new ArrayList<>();

        // Traverse both arrays simultaneously
        while (i < n && j < m) {
            // If elements are equal, add only once
            if (a[i] == b[j]) {
                if (result.isEmpty() || result.get(result.size() - 1) != a[i]) {
                    result.add(a[i]);
                }
                i++;
                j++;
            }
            // Add smaller element and move its pointer
            else if (a[i] < b[j]) {
                if (result.isEmpty() || result.get(result.size() - 1) != a[i]) {
                    result.add(a[i]);
                }
                i++;
            } else {
                if (result.isEmpty() || result.get(result.size() - 1) != b[j]) {
                    result.add(b[j]);
                }
                j++;
            }
        }

        // Add remaining elements from array a
        while (i < n) {
            if (result.isEmpty() || result.get(result.size() - 1) != a[i]) {
                result.add(a[i]);
            }
            i++;
        }

        // Add remaining elements from array b
        while (j < m) {
            if (result.isEmpty() || result.get(result.size() - 1) != b[j]) {
                result.add(b[j]);
            }
            j++;
        }

        return result;
    }
}
```

---

### 📌 Example

```java
Input:
a = [1, 2, 2, 3, 4]
b = [2, 3, 5]

Output:
[1, 2, 3, 4, 5]
```

---


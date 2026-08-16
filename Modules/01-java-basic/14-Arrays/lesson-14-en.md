# 📚 Lesson 14 - Arrays

---

## 🎯 Lesson Objectives

* Understand the concept of arrays as one-dimensional composite variables
* Learn how to declare and initialize arrays in Java
* Master the use of loops with arrays
* Get familiar with useful methods from the `Arrays` class
* Develop programs that manipulate arrays

---

## 🔍 What is an Array?

An **array** is a **one-dimensional composite variable** capable of storing **multiple values of the same type** in different memory positions.

📦 **Analogy:**
Think of an array as a **drawer cabinet**, where each drawer has a **position (index)** and stores a **value**.

---

```
n [3][5][8][2]
   0  1  2  3
```

* **Position 0** → value 3
* **Position 1** → value 5
* **Position 2** → value 8
* **Position 3** → value 2

---

## 💡 Representation in Pseudocode

```
var
    n: array [0..3] of integer

begin
    n[0] <- 3
    n[1] <- 5
    n[2] <- 8
    n[3] <- 2
end
```

Each number on the right represents the **index** (position) of the array.
That is: `n[0] = 3`, `n[1] = 5`, and so on.

---

## 💻 Implementation in Java

```java
int n[] = new int[4];
n[0] = 3;
n[1] = 5;
n[2] = 8;
n[3] = 2;
```

➡️ In Java, arrays are **objects**, so we use the `new` keyword.

### ✅ Simplified Form

If you already know the values:

```java
int n[] = {3, 5, 8, 2};
```

---

## 🧩 Practical Example

```java
public class Array01 {
    public static void main(String[] args) {
        int n[] = {3, 2, 8, 7, 5, 4};

        for (int i = 0; i <= 5; i++) {
            System.out.println("At position " + i + " we have the value " + n[i]);
        }
    }
}
```

### 🧠 Expected Output

```
At position 0 we have the value 3
At position 1 we have the value 2
At position 2 we have the value 8
At position 3 we have the value 7
At position 4 we have the value 5
At position 5 we have the value 4
```

---

## 📏 The `length` Property

### What is it?

Every array in Java has the property `length`, which returns the **total size** of the array.

### Example Using `length`

```java
public class ArrayLength {
    public static void main(String[] args) {
        int n[] = {3, 2, 8, 7, 5, 4};
        
        System.out.println("Total elements in N: " + n.length);
        
        for (int i = 0; i < n.length; i++) {
            System.out.println("At position " + i + " we have the value " + n[i]);
        }
    }
}
```

### 🧠 Output

```
Total elements in N: 6
At position 0 we have the value 3
At position 1 we have the value 2
At position 2 we have the value 8
At position 3 we have the value 7
At position 4 we have the value 5
At position 5 we have the value 4
```

### ✅ Advantages of `length`:

* **Safer code** – avoids index errors
* **Easy maintenance** – works even if the array size changes
* **More readable** – clearly expresses intent

---

## ⚙️ For-Each Loop

The **for-each** loop simplifies array traversal, automatically iterating through all elements.

### Simplified Syntax for Arrays

```java
for (type element : array) {
    // process element
}
```

### Comparison: Traditional For vs For-Each

#### Traditional For:

```java
int num[] = {3, 5, 8, 4};
for (int i = 0; i < num.length; i++) {
    System.out.print(num[i] + " ");
}
// Output: 3 5 8 4
```

#### For-Each:

```java
int num[] = {3, 5, 8, 4};
for (int value : num) {
    System.out.print(value + " ");
}
// Output: 3 5 8 4
```

### Practical Example with For-Each

```java
public class ArrayForEach {
    public static void main(String[] args) {
        double v[] = {3.5, 2.75, 9.0, -4.5};
        
        for (double value : v) {
            System.out.print(value + " ");
        }
    }
}
// Output: 3.5 2.75 9.0 -4.5
```

---

## 🧰 Arrays Class – Useful Methods

Java provides the `Arrays` class with several **utility methods**.

### 🧩 Example – Sorting with `Arrays.sort()`

```java
import java.util.Arrays;

public class ArraySort {
    public static void main(String[] args) {
        int num[] = {3, 5, 8, 4};
        Arrays.sort(num);

        for (int value : num) {
            System.out.print(value + "  ");
        }
    }
}
```

### 🧠 Output:

```
3  4  5  8
```

---

## 🔍 Searching with `Arrays.binarySearch()`

### Searching for a Value

```java
import java.util.Arrays;

public class ArraySearch {
    public static void main(String[] args) {
        int vet[] = {3, 7, 6, 1, 9, 4, 2};
        
        for (int v : vet) {
            System.out.print(v + "  ");
        }
        System.out.println(" ");
        
        int position = Arrays.binarySearch(vet, 1);
        System.out.println("Found the value at position " + position);
    }
}
```

### ⚠️ Important:

* The array **must be sorted** for `binarySearch()` to work properly
* Returns the **position** if found
* Returns a **negative value** if not found

---

## 🎯 Complete Example: Sorted Search

```java
import java.util.Arrays;

public class SortedSearch {
    public static void main(String[] args) {
        int vet[] = {3, 7, 6, 1, 9, 4, 2};
        
        System.out.print("Original array: ");
        for (int v : vet) {
            System.out.print(v + " ");
        }
        
        Arrays.sort(vet);
        
        System.out.print("\nSorted array: ");
        for (int v : vet) {
            System.out.print(v + " ");
        }
        
        int pos = Arrays.binarySearch(vet, 7);
        System.out.println("\nThe value 7 is at position: " + pos);
    }
}
```

---

## 🧱 Filling Arrays with `fill()`

You can automatically fill an array with a fixed value using `Arrays.fill()`.

### Filling an Array

```java
import java.util.Arrays;

public class ArrayFill {
    public static void main(String[] args) {
        int v[] = new int[20];
        
        Arrays.fill(v, 0);
        
        for (int value : v) {
            System.out.print(value + " ");
        }
    }
}
// Output: 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
```

### Partial Filling

```java
import java.util.Arrays;

public class PartialFill {
    public static void main(String[] args) {
        int v[] = new int[10];
        
        Arrays.fill(v, 2, 7, 5);
        
        for (int value : v) {
            System.out.print(value + " ");
        }
    }
}
// Output: 0 0 5 5 5 5 5 0 0 0
```

---

## 📋 Arrays Class Method Table

| Method                                  | Description            | Example                           |
| --------------------------------------- | ---------------------- | --------------------------------- |
| `Arrays.sort(array)`                    | Sorts the array        | `Arrays.sort(numbers)`            |
| `Arrays.binarySearch(array, value)`     | Searches for a value   | `Arrays.binarySearch(numbers, 5)` |
| `Arrays.fill(array, value)`             | Fills the entire array | `Arrays.fill(array, 0)`           |
| `Arrays.fill(array, start, end, value)` | Fills a range          | `Arrays.fill(array, 2, 5, 10)`    |

---

## 🎮 Practical Example: Grade System

```java
import java.util.Arrays;
import java.util.Scanner;

public class GradeSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("How many grades do you want to enter? ");
        int amount = input.nextInt();
        
        double grades[] = new double[amount];
        double sum = 0;
        
        for (int i = 0; i < grades.length; i++) {
            System.out.print("Enter grade " + (i + 1) + ": ");
            grades[i] = input.nextDouble();
            sum += grades[i];
        }
        
        Arrays.sort(grades);
        
        System.out.println("\n=== RESULTS ===");
        System.out.print("Sorted grades: ");
        for (double g : grades) {
            System.out.print(g + " ");
        }
        
        System.out.println("\nHighest grade: " + grades[grades.length - 1]);
        System.out.println("Lowest grade: " + grades[0]);
        System.out.println("Average: " + (sum / grades.length));
        
        input.close();
    }
}
```

---

## 🚀 Practice Exercises

### Exercise 1: Reversed Array

```java
// Create an array and display its elements in reverse order
```

### Exercise 2: Count Even and Odd Numbers

```java
// Count how many even and odd numbers exist in an array
```

### Exercise 3: Search for a Value

```java
// Ask the user for a number and check if it exists in the array
```

### Exercise 4: Array Statistics

```java
// Calculate average, maximum, and minimum of a numeric array
```

---

## ✅ Learning Checklist

* [ ] I understand the concept of arrays as composite variables
* [ ] I can declare and initialize arrays in Java
* [ ] I can use traditional for loops with arrays
* [ ] I can use for-each loops to traverse arrays
* [ ] I understand and use the `length` property
* [ ] I can apply `Arrays` methods: sort, binarySearch, fill
* [ ] I can create programs that manipulate arrays

---

> 💡 **Tip:** Practice by creating different types of arrays and experimenting with all methods. Use `System.out.println()` to inspect your array after each operation. Mastering array manipulation is essential for working with data collections in Java!

---


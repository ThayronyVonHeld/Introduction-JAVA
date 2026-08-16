# 📚 Lesson 7 - Arithmetic Operators and Math Class

---

## 🎯 Lesson Objectives

* Master arithmetic operators in Java
* Understand operator precedence
* Learn how to use unary and assignment operators
* Get to know the Math class and its main methods
* Work with rounding and random numbers

---

## ➕ Basic Arithmetic Operators

### Arithmetic Operators Table

| Operator | Name           | Example | Result |
| -------- | -------------- | ------- | ------ |
| `+`      | Addition       | `5 + 2` | `7`    |
| `-`      | Subtraction    | `5 - 2` | `3`    |
| `*`      | Multiplication | `5 * 2` | `10`   |
| `/`      | Division       | `5 / 2` | `2.5`  |
| `%`      | Remainder      | `5 % 2` | `1`    |

> 💡 **Note**: The `+` operator is also used for concatenation when applied to Strings.

---

## 🧮 Operator Precedence

### Operator Priority

```java
public class Precedence {
    public static void main(String[] args) {
        int n1 = 5, n2 = 3, n3 = 2;
        
        // Without parentheses
        int result1 = n1 + n2 * n3;  // 5 + (3 * 2) = 11
        System.out.println("Without parentheses: " + result1);
        
        // With parentheses
        int result2 = (n1 + n2) * n3;  // (5 + 3) * 2 = 16
        System.out.println("With parentheses: " + result2);
        
        // Average calculation
        double average = (n1 + n2 + n3) / 3.0;
        System.out.println("Average: " + average);
    }
}
```

**Precedence Order:**

1. `()` - Parentheses
2. `*`, `/`, `%` - Multiplication, Division, Remainder
3. `+`, `-` - Addition, Subtraction

---

## 🔄 Unary Operators

### Increment and Decrement

```java
public class UnaryOperators {
    public static void main(String[] args) {
        int a = 5;
        
        // Post-increment
        System.out.println("a: " + a);       // 5
        System.out.println("a++: " + a++);   // 5 (uses then increments)
        System.out.println("a: " + a);       // 6
        
        // Pre-increment
        int b = 5;
        System.out.println("b: " + b);       // 5
        System.out.println("++b: " + ++b);   // 6 (increments then uses)
        System.out.println("b: " + b);       // 6
        
        // Decrement
        int c = 5;
        System.out.println("c--: " + c--);   // 5
        System.out.println("--c: " + --c);   // 3
    }
}
```

### Difference Between Pre and Post

```java
int x = 5;
int y = x++;  // y = 5, x = 6

int a = 5;
int b = ++a;  // a = 6, b = 6
```

---

## ⚡ Assignment Operators

### Simplified Forms

```java
public class AssignmentOperators {
    public static void main(String[] args) {
        int a = 10;
        
        a += 5;   // a = a + 5 → 15
        a -= 3;   // a = a - 3 → 12
        a *= 2;   // a = a * 2 → 24
        a /= 4;   // a = a / 4 → 6
        a %= 4;   // a = a % 4 → 2
        
        System.out.println("Final value of a: " + a);
    }
}
```

### Assignment Operators Table

| Operator | Equivalent  | Example  |
| -------- | ----------- | -------- |
| `+=`     | `a = a + b` | `a += 5` |
| `-=`     | `a = a - b` | `a -= 3` |
| `*=`     | `a = a * b` | `a *= 2` |
| `/=`     | `a = a / b` | `a /= 4` |
| `%=`     | `a = a % b` | `a %= 4` |

---

## 🧊 Math Class

### Main Methods

```java
public class MathClass {
    public static void main(String[] args) {
        // Exponentiation
        double power = Math.pow(5, 2);    // 25.0
        System.out.println("5² = " + power);
        
        // Square root
        double squareRoot = Math.sqrt(25); // 5.0
        System.out.println("√25 = " + squareRoot);
        
        // Cube root
        double cubeRoot = Math.cbrt(27);   // 3.0
        System.out.println("∛27 = " + cubeRoot);
        
        // PI constant
        double circleArea = Math.PI * Math.pow(5, 2);
        System.out.println("Circle area: " + circleArea);
        
        // Absolute value
        int absolute = Math.abs(-10);        // 10
        System.out.println("Absolute value: " + absolute);
    }
}
```

---

## 📊 Rounding

### Rounding Methods

```java
public class Rounding {
    public static void main(String[] args) {
        double number = 3.7;
        
        // Round down (floor)
        double down = Math.floor(number);    // 3.0
        System.out.println("Floor: " + down);
        
        // Round up (ceil)
        double up = Math.ceil(number);      // 4.0
        System.out.println("Ceil: " + up);
        
        // Arithmetic rounding (round)
        long rounded = Math.round(number);    // 4
        System.out.println("Round: " + rounded);
        
        // Examples with negative numbers
        System.out.println("Floor -3.2: " + Math.floor(-3.2)); // -4.0
        System.out.println("Ceil -3.2: " + Math.ceil(-3.2));   // -3.0
    }
}
```

---

## 🎲 Random Numbers

### Generating Random Numbers

```java
import java.util.Random;

public class RandomNumbers {
    public static void main(String[] args) {
        // Using Math.random()
        double random1 = Math.random();  // 0.0 up to 0.999...
        System.out.println("Math.random(): " + random1);
        
        // Generating between 0 and 9
        int between0and9 = (int) (Math.random() * 10);
        System.out.println("Between 0 and 9: " + between0and9);
        
        // Generating between 5 and 10
        int between5and10 = 5 + (int) (Math.random() * 6);
        System.out.println("Between 5 and 10: " + between5and10);
        
        // Using Random class
        Random rand = new Random();
        int between1and100 = rand.nextInt(100) + 1;
        System.out.println("Between 1 and 100: " + between1and100);
    }
}
```

### Interval Formulas

```java
// Interval [min, max]
int number = min + (int) (Math.random() * (max - min + 1));

// Example: between 10 and 20
int example = 10 + (int) (Math.random() * 11); // 10, 11, ..., 20
```

---

## 📋 Math Class Methods Table

| Method           | Description    | Example                 |
| ---------------- | -------------- | ----------------------- |
| `Math.pow(a, b)` | Power (aᵇ)     | `Math.pow(2, 3) = 8.0`  |
| `Math.sqrt(x)`   | Square root    | `Math.sqrt(16) = 4.0`   |
| `Math.cbrt(x)`   | Cube root      | `Math.cbrt(27) = 3.0`   |
| `Math.abs(x)`    | Absolute value | `Math.abs(-5) = 5`      |
| `Math.floor(x)`  | Rounds down    | `Math.floor(3.9) = 3.0` |
| `Math.ceil(x)`   | Rounds up      | `Math.ceil(3.1) = 4.0`  |
| `Math.round(x)`  | Rounding       | `Math.round(3.5) = 4`   |
| `Math.max(a, b)` | Larger value   | `Math.max(5, 3) = 5`    |
| `Math.min(a, b)` | Smaller value  | `Math.min(5, 3) = 3`    |
| `Math.random()`  | Random number  | `0.0 ≤ x < 1.0`         |

---

## 🎯 Practical Exercises

### Exercise 1: BMI Calculator

### Exercise 2: Password Generator

### Exercise 3: Temperature Converter

---

> 💡 **Tip**: "Constant practice with operators is essential. Create small mathematical programs daily to solidify your knowledge. Remember: the Math class is your best friend for complex calculations!"

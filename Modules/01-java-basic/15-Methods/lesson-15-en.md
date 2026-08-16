# 📚 Lesson 15 - Methods

---

## 🎯 Lesson Objectives

* Understand the concept of methods in Java
* Differentiate between procedures and functions
* Master the syntax for creating and calling methods
* Understand the `static` modifier and how to use it
* Learn to work with methods across different classes
* Explore access modifiers: `public`, `private`, and `protected`

---

## 🧩 Concept of Methods in Java

### What Are Methods?

In Java, there is **no specific reserved word** for *functions* or *procedures* as in other languages.
In Java, **everything is called a method**.

The difference between a function and a procedure lies in the **return type**:

* If the method **returns a value**, it is a **function**.
* If it **does not return a value**, it is a **procedure**, and we use the keyword **`void`**.

### 💭 Why Use Methods?

* Avoid code repetition
* Make code easier to read and maintain
* Divide problems into smaller, manageable parts
* Keep programs organized and professional

---

## 🔹 Reviewing with Pseudocode

In pseudocode, a **procedure** would look like this:

```text
procedure Sum(A, B: Integer)
var
    S: Integer
begin
    S <- A + B
    Write(S)
endProcedure
```

Calling the procedure:

```text
Sum(5, 2)
```

In this case, the **procedure does not return a value**, it only performs an action.

---

## 💻 Translating to Java

In Java, the same procedure would look like this:

```java
void sum(int a, int b) {
    int s = a + b;
    System.out.print(s);
}

sum(5, 2); // calling the procedure
```

---

## 🎯 Practical Example

```java
public class TestProcedure {

    void sum(int a, int b) {
        int s = a + b;
        System.out.println("The sum is: " + s);
    }

    public static void main(String[] args) {
        sum(5, 2);
    }
}
```

⚠️ This code will **cause an error** because the `sum` method is **not static**, while `main` **is**.
A `static` method belongs to the **class**, not to an **instance (object)**.

### In Summary: What Is `static`?

* **Static method** → Belongs to the **class**, not to an instance
* **Non-static method** → Belongs to an **object** (instance) of the class

---

## ⚡ Fixing It with `static`

```java
public class TestProcedure {

    static void sum(int a, int b) { // added 'static'
        int s = a + b;
        System.out.println("The sum is: " + s);
    }

    public static void main(String[] args) {
        sum(5, 2);
    }
}
```

When we add `static`, the method becomes accessible **without needing to create an object of the class**.

> 💡 The `main` method is always the first to run — it’s the entry point of the program.

---

## 🔹 Now, Functions!

In pseudocode:

```text
function Sum(A, B: Integer): Integer
var
    S: Integer
begin
    S <- A + B
    return S
endFunction

sm <- Sum(5, 2) // Calling the function
```

Here, we have a **return statement** (`return S`) and the return type is `Integer`.

---

## 🔹 Translating to Java

```java
int sum(int a, int b) {
    int s = a + b;
    return s;
}

int sm = sum(5, 2);
```

The difference is simple:

* Use `void` → no return value.
* Use a type (`int`, `String`, `double`, etc.) → returns a value.

---

## 🔹 Practical Example

```java
public class TestFunction {

    static int sum(int a, int b) {
        int s = a + b;
        return s;
    }

    public static void main(String[] args) {
        int sm = sum(5, 2);
        System.out.println("The sum is: " + sm);
    }
}
```

The `static` keyword is still needed because we are calling the function inside the `main` method, which is also `static`.

> 🔸 In other contexts, `static` may not be necessary, depending on the program structure.

---

### Example of a Non-Static Method

```java
public class InstanceExample {
    void greeting(String name) {
        System.out.println("Hello, " + name + "!");
    }

    public static void main(String[] args) {
        InstanceExample example = new InstanceExample(); // creating object
        example.greeting("Thayrony");
    }
}
```

> 💡 Non-static methods require creating an object before calling them.

---

## 🔄 Understanding the `main` Method

### Analyzing the Main Method:

```java
public static void main(String[] args) {
    // code
}
```

* **`public`** → Accessible from anywhere
* **`static`** → Belongs to the class, doesn’t require an instance
* **`void`** → No return value
* **`String[] args`** → Parameter: array of strings for command-line arguments

Thus, the `main` method is the entry point of every Java program.

---

## 🏪 Working with Methods in Other Classes

You can create a method in one class and call it from another.

### Class `Operations.java`

```java
package JavaBasic.Lesson15.TestingClasses;

public class Operations {
    public static String counter(int i, int f) {
        String s = "";
        for (int c = i; c <= f; c++) {
            s += c + " ";
        }
        return s;
    }
}
```

### Class `TestFunction.java`

```java
package JavaBasic.Lesson15.TestingClasses;

public class TestFunction {
    public static void main(String[] args) {
        System.out.println("Counting will start...");
        System.out.println(Operations.counter(1, 5));
    }
}
```

We use:

```java
Operations.counter(1, 5);
```

That is: **class name + dot + method name**.

### 🔍 Expected Output:

```
Counting will start...
1 2 3 4 5 
```

---

## 🔒 Access Modifiers

### Access Modifiers Table:

| Modifier        | Access    | Description                                    |
| --------------- | --------- | ---------------------------------------------- |
| **`public`**    | Public    | Accessible from anywhere                       |
| **`private`**   | Private   | Accessible only within the same class          |
| **`protected`** | Protected | Accessible within the class and its subclasses |
| **(default)**   | Package   | Accessible only within the same package        |

---

### Example with Different Modifiers

```java
public class AccessExample {
    public static void publicMethod() {
        System.out.println("Public method - accessible from anywhere");
    }

    private static void privateMethod() {
        System.out.println("Private method - accessible only within this class");
    }

    protected static void protectedMethod() {
        System.out.println("Protected method - accessible by inheritance");
    }

    static void defaultMethod() {
        System.out.println("Default method - accessible within the same package");
    }
}
```

---

## 📋 Method Syntax Summary

### Full Structure:

```java
[public|private|protected] [static] [final] [synchronized] 
return_type methodName(type param1, type param2, ...) {
    // method body
    
    if (return_type != void) {
        return value;
    }
}
```

### Parts of a Method:

1. **Access modifier** → `public`, `private`, `protected`
2. **Static modifier** → `static` (optional)
3. **Return type** → `void`, `int`, `String`, etc.
4. **Method name** → identifier
5. **Parameters** → inside parentheses
6. **Body** → inside curly braces
7. **Return statement** → required if not `void`

---

## 🚀 Practical Exercises

### Exercise 1: Temperature Converter

```java
// Create methods to convert between Celsius ↔ Fahrenheit
```

### Exercise 2: Data Validator

```java
// Create methods to validate email, ID, age, etc.
```

### Exercise 3: Geometry Calculator

```java
// Create methods to calculate area, perimeter, and volume
```

### Exercise 4: Report Generator

```java
// Create methods to generate different types of reports
```

---

## ✅ Learning Checklist

* [ ] I understand the concept of methods in Java
* [ ] I can differentiate between procedures (void) and functions (with return)
* [ ] I master the syntax for creating and calling methods
* [ ] I understand how the `static` modifier works
* [ ] I can create methods in separate classes
* [ ] I know and apply access modifiers
* [ ] I can work with parameters and return values
* [ ] I can build organized programs using methods

**Congratulations on completing the Java Fundamentals course! 🎊**

---

> 💡 **Final Tip:** A good programmer doesn’t write more code — they write **better** code.
> Organize, name clearly, and reuse your methods.
> Each small method you create is one more step toward professional programming.

---

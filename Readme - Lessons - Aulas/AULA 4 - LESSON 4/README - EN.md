# 📚 Lesson 4

First program in Java

---

### Basic structure of a Java program

A Java program can be organized into **packages**, **classes**, and **methods**.

Example code:

```java
package firstprogram; // optional

public class FirstProgram { // Class (main block)
    public static void main(String[] args) { // Main method
        System.out.print("Hello World");
    }
}
```

---

### Code analysis

* **`package firstprogram;`** → optional, designates the package where the class is located
* **`public class FirstProgram { ... }`** → defines the **class** (a block)
* **`public static void main(String[] args) { ... }`** → main method, entry point of the program
* **`System.out.print("Hello World");`** → instruction that prints text to the console

> Hierarchical structure:
> Package → Class → Method → Instruction

---

### Case sensitivity ⚠️

* Java is **case sensitive** → it distinguishes between uppercase and lowercase letters.
* Example: `System` is different from `system`.

---

### IDE help (shortcuts)

Most IDEs provide **code shortcuts** (e.g., IntelliJ IDEA):

* Typing `psvm` → generates automatically:

  ```java
  public static void main(String[] args) { ... }
  ```
* Typing `sout` → generates automatically:

  ```java
  System.out.print();
  ```

---

### CamelCase 🐪

**CamelCase** is a writing style where compound words are joined, and each "hump" (new word) starts with a **capital letter**.

📌 Rules in Java:

* **Class or Interface** → first letter uppercase, following words in CamelCase
  Ex.: `WelcomeToBrazil`
* **Attribute, Variable, Method** → first letter lowercase, following words in CamelCase
  Ex.:

    * Variable: `nameStudent`
    * Variable: `firstTermAverage`
    * Method: `registerStudentNote()`
* **Package** → all lowercase
  Ex.: `studentcourseonline`
* **Constant** → all uppercase, words separated by `_`
  Ex.: `PI_VALUE`

---

### Quick summary

* Every Java program can have **packages, classes, methods, and instructions**.
* The **entry point** is the main method:

  ```java
  public static void main(String[] args) { ... }
  ```
* Java is **case sensitive**.
* IDEs help with **shortcuts** like `psvm` and `sout`.
* Naming conventions:

    * **Class/Interface** → `UpperCamelCase`
    * **Variable/Method** → `lowerCamelCase`
    * **Package** → lowercase
    * **Constant** → `UPPERCASE_WITH_UNDERSCORES`

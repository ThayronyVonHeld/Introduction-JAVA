# 📚 Lesson 3 – Access Modifiers

---

## 🎯 Lesson Objectives

* Understand the concept of UML and class diagrams
* Identify different types of access modifiers
* Relate visibility concepts to real-world examples
* Apply access modifiers in Java code

---

## 🧭 Introduction

**Visibility** is one of the core principles of Object-Oriented Programming.
It defines **who can access** a class’s attributes and methods, ensuring **security and organization** within the code.

Before we dive into access modifiers, let’s take a quick look at a tool widely used in system modeling **UML (Unified Modeling Language)**.

---

## 🧩 UML – Unified Modeling Language

**UML** is a standardized language used to **visualize, specify, construct, and document** software systems.

Among its many diagrams, the most relevant one for us is the **class diagram**.

---

## 🏗️ Class Diagram

A **class diagram** provides a visual representation of a class and its elements.

For example, the `Pen` class (from the previous lesson) could be represented like this:

```
+---------------------+
|        Pen          |   ← Class name
+---------------------+
| model               |   ← Attributes
| color               |
| inkLevel            |
| tipSize             |
| capped              |
+---------------------+
| write()             |   ← Methods
| scribble()          |
| draw()              |
| cap()               |
| uncap()             |
+---------------------+
```

Notice that:

* The **class name** is at the top and starts with a **capital letter**.
* **Attributes** and **methods** start with **lowercase letters**.
* **Methods** always include parentheses `()` to indicate actions.

This diagram helps you **quickly visualize** what a class contains and what it can do.

---

## 🔒 What Are Access Modifiers?

**Access modifiers** define **who can access** a class’s **attributes and methods**.
They are used to **protect data** and **control access** to specific parts of the code.

In **UML**, we use these symbols:

| Symbol | Modifier      | Description                                |
| ------ | ------------- | ------------------------------------------ |
| `+`    | **public**    | Free access (any class can access)         |
| `-`    | **private**   | Restricted to the class itself             |
| `#`    | **protected** | Accessible by the class and its subclasses |

---

## 🧱 UML Example

```
+---------------------+
|        Pen          |
+---------------------+
| + model             |
| + color             |
| - inkLevel          |
| # tipSize           |
| # capped            |
+---------------------+
| + write()           |
| + scribble()        |
| + draw()            |
| - cap()             |
| - uncap()           |
+---------------------+
```

---

## ☎️ Simple Analogies

Let’s understand each type using real-world examples:

### **Public (+)**

Think of a **payphone**, anyone can use it.
It’s **accessible to everyone**.

➡️ In OOP: **any class** can access this attribute or method.

---

### **Private (-)**

Now imagine your **personal cellphone**.
Only you can use it, and you even protect it with a password.

➡️ In OOP: **only the class itself** can access or modify it.

---

### **Protected (#)**

Think of a **company phone**.
Only **employees** can use it, it’s not public, but also not exclusive to one person.

➡️ In OOP: **the class and its subclasses** can access it.

---

## 🎮 Practical Example: Remote Control

Think about a **TV remote**:

* The **external buttons** (power, volume, channel) → **public**, since the user must access them.
* The **internal circuits** → **private**, protected by the casing.
* The **infrared LED** → **protected**, because it interacts with the TV but isn’t directly accessible.

This “**protective shell**” that separates what’s public from what’s private is called **encapsulation** (we’ll explore it in the next lesson).

---

## 🧩 Example in Pseudocode

```text
class Pen
  public model : string
  public color : string
  protected tipSize : float
  private inkLevel : int
  protected capped : boolean

  public method write()
  end method

  public method scribble()
  end method

  public method draw()
  end method

  private method cap()
  end method

  private method uncap()
  end method
end class
```

---

## ⚙️ Creating an Object

```text
p1 = new Pen
p1.model = "BIC Cristal"   // OK → public
p1.color = "Blue"          // OK → public
p1.tipSize = 0.5           // ❌ ERROR → protected
p1.inkLevel = 50           // ❌ ERROR → private
p1.capped = true           // ❌ ERROR → protected

p1.write()     // OK → public
p1.scribble()  // OK → public
p1.cap()       // ❌ ERROR → private method
```

---

## 💻 Java Code Example

### Pen Class with Modifiers:

```java
package oop.Lesson3.Pen;

public class Pen {
    // ATTRIBUTES WITH MODIFIERS
    public String model;      // + Public
    public String color;      // + Public
    private Float tipSize;    // - Private
    protected int inkLevel;   // # Protected
    private boolean capped;   // - Private
    
    // METHODS
    public void status() {
        System.out.println("Model: " + this.model);
        System.out.println("A " + this.color + " pen");
        System.out.println("Tip size: " + this.tipSize);
        System.out.println("Ink level: " + this.inkLevel);
        System.out.println("Is it capped? " + this.capped);
    }
    
    public void scribble() {
        if (this.capped) {
            System.out.println("Error! Can't scribble while capped.");
        } else {
            System.out.println("Scribbling...");
        }
    }
    
    private void cap() {
        this.capped = true;
    }
    
    private void uncap() {
        this.capped = false;
    }
}
```

### Main Class:

```java
package oop.Lesson3.Pen;

public class Main {
    public static void main(String[] args) {
        Pen p1 = new Pen();
        
        // ✅ PUBLIC ATTRIBUTES - Accessible
        p1.model = "BIC Cristal";
        p1.color = "Blue";
        
        // ❌ PRIVATE ATTRIBUTE - Not directly accessible
        // p1.tipSize = 0.5f;  // ERROR! Private attribute
        
        // ✅ PROTECTED ATTRIBUTE - Accessible (same package)
        p1.inkLevel = 50;
        
        // ❌ PRIVATE ATTRIBUTE - Not directly accessible
        // p1.capped = false;  // ERROR! Private attribute
        
        // ❌ PRIVATE METHOD - Not directly accessible
        // p1.cap();  // ERROR! Private method
        
        p1.status();
        p1.scribble();
    }
}
```

---

## 🎯 What is `this`?

### Explanation:

* **`this`** refers to the **current object** that’s calling the method.
* **`this.model`** means the `model` attribute of **this object**.
* When calling `p1.status()`, inside that method, **`this` = `p1`**.

### Example:

```java
Pen p1 = new Pen();
Pen p2 = new Pen();

p1.model = "BIC";
p2.model = "Faber-Castell";

p1.status(); // this = p1 → shows "BIC"
p2.status(); // this = p2 → shows "Faber-Castell"
```

---

## 🚫 Access Restrictions in Practice

### What you can and can’t do:

#### ✅ **ALLOWED** (Public attributes):

```java
p1.model = "BIC Cristal";  // ✅ Public
p1.color = "Blue";         // ✅ Public
```

#### ✅ **ALLOWED** (Protected attribute – same package):

```java
p1.inkLevel = 50;          // ✅ Protected (same package)
```

#### ❌ **DENIED** (Private attributes):

```java
// p1.tipSize = 0.5f;     // ❌ Private - ERROR!
// p1.capped = true;      // ❌ Private - ERROR!
```

#### ❌ **DENIED** (Private methods):

```java
// p1.cap();              // ❌ Private method - ERROR!
// p1.uncap();            // ❌ Private method - ERROR!
```

---

## 🛡️ Why Use Access Modifiers?

### Advantages:

1. **Encapsulation** → Protects sensitive data
2. **Access Control** → Defines who can modify what
3. **Maintainability** → Makes code organized and secure
4. **Error Prevention** → Avoids unintended modifications

---

## 📋 Summary Table – Access Modifiers

| Modifier      | Class | Package | Subclass | Everyone |
| ------------- | ----- | ------- | -------- | -------- |
| **public**    | ✅     | ✅       | ✅        | ✅        |
| **protected** | ✅     | ✅       | ✅        | ❌        |
| **default**   | ✅     | ✅       | ❌        | ❌        |
| **private**   | ✅     | ❌       | ❌        | ❌        |

> **Default**: Used when no modifier is explicitly defined.

---

## 🚀 Practice Exercises

### Exercise 1: UML Diagram

```java
// Create a UML class diagram for "Car"
// Attributes: brand, model, year, currentSpeed
// Methods: accelerate(), brake(), start(), stop()
// Define visibility for each element
```

### Exercise 2: Java Implementation

```java
// Implement the "Car" class in Java
// Apply the appropriate access modifiers
```

### Exercise 3: Access Analysis

```java
// Given a class with public, private, and protected attributes
// Identify which accesses are allowed and which are denied
// in different contexts
```

---

> 💡 **Tip:** Think of modifiers as *security levels*.
> Use `private` for sensitive data, `protected` for what’s shared within the family,
> and `public` for what everyone needs to use.
> That mindset helps you write safer and cleaner code!


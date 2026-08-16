Claro! Aqui está a **versão completa em inglês**, mantendo o mesmo formato didático e estilo visual da sua Aula 3 traduzida:

---

# 📚 Lesson 4 – Special Methods

---

## 🎯 Lesson Objectives

* Understand the concept of special methods in OOP
* Master accessor (getter) and mutator (setter) methods
* Learn how to implement constructors
* Understand the importance of encapsulation for data security
* Apply these concepts in a practical Java example

---

## 🧭 Introduction

In object-oriented programming, **special methods** are functions that have **specific and standardized purposes** within classes.

They are not mandatory, but are **widely used** because they make the code more **secure, readable, and organized**.

In this lesson, we’ll explore the three main types of special methods:

1. **Getters** → accessor methods
2. **Setters** → mutator methods
3. **Constructors** → methods that initialize the object

---

## 🗄️ Conceptual Example: The Bookshelf

Imagine you have an object called `Bookshelf`.

### 🔹 Possible attributes:

* Size
* Color
* Number of shelves
* Model
* Manufacturer

### 🔹 Possible methods:

* `addDocument()`
* `removeDocument()`
* `countDocuments()`

Now think about this:
If multiple people use the same bookshelf, would you let anyone handle other people's documents directly?

Probably not.
In real life, we create **protection mechanisms**, and in OOP, we do the same.

---

## 🔑 Accessor Methods (Getters)

**Getters** are methods used to **safely access an attribute**.
They allow you to **retrieve information** from an object **without altering its internal state**.

📘 *In English, “get” means “to obtain” or “to retrieve.”*

### 📦 Analogy:

Think of an **ATM**.
You don’t open the bank vault to see your balance — you **request the information** through a secure interface.

---

### 💡 Conceptual Example:

The bookshelf has an attribute `totalDocs` (total number of documents).
To check how many documents it has, instead of directly accessing `b.totalDocs`, you call:

```java
b.getTotalDocs();
```

This way, you **safely retrieve** the value without accidentally changing it.

---

## 🛠️ Mutator Methods (Setters)

**Setters** are used to **safely modify an attribute**.
They control *how* and *when* the value of an attribute can be changed.

📘 *In English, “set” means “to assign” or “to define.”*

### 📦 Analogy:

Using the same bookshelf example — if you want to **add a document**, you don’t do it yourself; you **hand it to the librarian**.

That “librarian” is the **setter**.

---

### 💡 Conceptual Example:

```java
b.setTotalDocs(6);
```

Here, `setTotalDocs` receives a **parameter** (6) and **updates** the attribute internally.

This ensures that **no attribute is modified incorrectly or directly.**

---

## 🛡️ Why Use Getters and Setters?

### Advantages:

1. **Encapsulation** → Protects sensitive data
2. **Validation** → Ensures values are verified before changing
3. **Control** → Allows logging or tracking changes
4. **Flexibility** → Internal logic can change without breaking external code

---

## 💡 Example with Class `Pen`

Let’s simplify our `Pen` class to two attributes:
`model` (public) and `tip` (private).

```
+---------------------+
|        Pen          |
+---------------------+
| + model             |
| - tip               |
+---------------------+
| + getModel()        |
| + setModel(m)       |
| + getTip()          |
| + setTip(t)          |
+---------------------+
```

---

## 🧩 Pseudocode

```algoritmo
class Pen
  public model : string
  private tip : float

  public method getModel()
    return model
  end method

  public method setModel(m : string)
    model = m
  end method

  public method getTip()
    return tip
  end method

  public method setTip(t : float)
    tip = t
  end method
end class
```

---

## 💻 Full Java Code Example

### Class Pen

```java
package oop.Lesson4.Pen;

public class Pen {
    public String model;   // Public
    private float tip;     // Private

    // GETTER for model
    public String getModel() {
        return this.model;
    }

    // SETTER for model
    public void setModel(String m) {
        this.model = m;
    }

    // GETTER for tip
    public float getTip() {
        return this.tip;
    }

    // SETTER for tip
    public void setTip(float t) {
        this.tip = t;
    }
}
```

---

### Main Class

```java
public class Main {
    public static void main(String[] args) {
        // Creating object
        Pen p1 = new Pen();

        // ✅ Using SETTERS (safe modification)
        p1.setModel("BIC Cristal");
        p1.setTip(0.5f);

        // ✅ Using GETTERS (safe access)
        System.out.println("Model: " + p1.getModel());
        System.out.println("Tip: " + p1.getTip());

        // ❌ Direct access to private attribute (ERROR!)
        // p1.tip = 0.7f; // Compilation error
    }
}
```

🧠 **Expected output:**

```
Model: BIC Cristal
Tip: 0.5
```

---

## 🏗️ Constructor Method

A **constructor** is a special method that is **automatically executed** whenever a new object is created.

📘 *In English, “constructor” comes from “construct” — it builds the object.*

### ⚙️ Constructor Function

1. **Initializes attributes automatically**
2. **Defines default values**
3. **Can receive parameters for customization**

### Characteristics:

* Has the **same name** as the class
* **No return type** (not even `void`)
* Can **accept parameters**
* Initializes attributes

---

### 💡 Example 1 – Simple Constructor

Every pen starts **blue** and **capped**:

```java
public Pen() {
    this.color = "Blue";
    this.cap();
}
```

### 💡 Example 2 – Constructor with Parameters

```java
public Pen(String m, String c, float t) {
    this.setModel(m);
    this.setColor(c);
    this.setTip(t);
    this.cap();
}
```

Now we can create customized pens in one line:

```java
Pen p1 = new Pen("BIC", "Blue", 0.5f);
Pen p2 = new Pen("Faber-Castell", "Red", 0.7f);
```

---

## 🎯 Full Example

### Class Pen – Constructor with Parameters

```java
public class Pen {
    // ATTRIBUTES
    private String model;
    private String color;
    private Float tip;
    private boolean capped;
    
    // ✅ CONSTRUCTOR
    public Pen(String m, String c, Float t) {
        this.setModel(m);
        this.setColor(c);
        this.setTip(t);
        this.cap();
    }
    
    // GETTERS AND SETTERS
    public String getModel() {
        return this.model;
    }
    
    public void setModel(String m) {
        this.model = m;
    }
    
    public String getColor() {
        return this.color;
    }
    
    public void setColor(String c) {
        this.color = c;
    }
    
    public Float getTip() {
        return this.tip;
    }
    
    public void setTip(Float t) {
        this.tip = t;
    }
    
    public boolean getCapped() {
        return this.capped;
    }
    
    // REGULAR METHODS
    public void cap() {
        this.capped = true;
    }
    
    public void uncap() {
        this.capped = false;
    }
    
    public void status() {
        System.out.println("=== ABOUT THE PEN ===");
        System.out.println("Model: " + this.getModel());
        System.out.println("Color: " + this.getColor());
        System.out.println("Tip: " + this.getTip());
        System.out.println("Capped: " + this.getCapped());
    }
}
```

---

### Using the Constructor

```java
public class Main {
    public static void main(String[] args) {
        // ✅ Creating pens with constructor
        Pen p1 = new Pen("BIC", "Blue", 0.5f);
        Pen p2 = new Pen("Faber-Castell", "Red", 1.0f);
        
        // Displaying status
        p1.status();
        p2.status();
    }
}
```

🧠 **Expected Output:**

```
=== ABOUT THE PEN ===
Model: BIC
Color: Blue
Tip: 0.5
Capped: true

=== ABOUT THE PEN ===
Model: Faber-Castell
Color: Red
Tip: 1.0
Capped: true
```

---

## 🧠 Final Summary

| Method Type | Name                | Purpose                 | Runs Automatically? |
| ----------- | ------------------- | ----------------------- | ------------------- |
| Getter      | `getAttribute()`    | Returns attribute value | ❌                   |
| Setter      | `setAttribute(val)` | Changes attribute value | ❌                   |
| Constructor | `ClassName()`       | Initializes the object  | ✅                   |

---

## 💡 Best Practices

1. **Always use getters/setters** for private attributes
2. **Keep attributes private** whenever possible
3. **Use constructors** to define initial values
4. **Validate data** inside setters

```java
public void setTip(Float t) {
    // ✅ Validation before changing
    if (t > 0 && t <= 2.0) {
        this.tip = t;
    } else {
        System.out.println("Invalid tip size!");
    }
}
```

---

## 🚀 Practical Exercises

### Exercise 1: Class `Car`

```java
// Create a class Car with:
// Attributes: brand, model, year, speed (private)
// Methods: getters/setters, constructor, accelerate(), brake()
```

### Exercise 2: Setter Validation

```java
// Modify the setters to validate:
// - Year cannot be in the future
// - Speed cannot be negative
// - Brand cannot be empty
```

### Exercise 3: Bank Account Class

```java
// Create a class Account with:
// Attributes: number, balance, holder (private)
// Methods: deposit(), withdraw(), getBalance()
// Rule: balance cannot be negative
```

---

> 💡 **Tip:** “Think of getters and setters as your code’s security guards.
> The getter lets you *see* what’s inside; the setter lets you *change* it — but only the right way.
> The constructor is like receiving a product already configured.
> This mindset helps you write safer and more professional code!”

---
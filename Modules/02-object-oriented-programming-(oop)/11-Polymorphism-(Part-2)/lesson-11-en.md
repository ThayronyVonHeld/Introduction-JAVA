# 📚 Lesson 11 – Method Overloading Polymorphism in Java

## 🎯 Lesson Objectives

* Differentiate **overriding** vs **overloading**
* Understand the concept of **method signature**
* Understand **polymorphism by overloading**
* Implement **method overloading** in Java in practice

---

## 🧠 Polymorphism by Overloading

### 📌 What is it?

**Overloading** occurs when there are **multiple methods with the same name**, but with **different signatures**, within the **same class**.

📌 Key characteristics:

* Same method name
* Different parameters (type and/or quantity)
* Same class
* Decision made **at compile time**

---

## 🔄 Comparison: Overloading vs Overriding

### 📊 Comparison Table:

| Feature             | **Overloading**               | **Overriding**                     |
| ------------------- | ----------------------------- | ---------------------------------- |
| **Location**        | Same class                    | Different classes (inheritance)    |
| **Signature**       | Different                     | Same                               |
| **Return type**     | Can be different              | Must be compatible                 |
| **Access modifier** | Can change                    | Cannot be more restrictive         |
| **Polymorphism**    | Compile time                  | Runtime                            |
| **Example**         | `react(String)`, `react(int)` | `makeSound()` in different animals |

---

## 🐶 Implementation: Dog Class with Overloading

A dog can **react in different ways**, depending on the stimulus received.
Each stimulus is represented by a **different set of parameters**.

👉 Full implementation available at:
🔗 [https://github.com/ThayronyVonHeld/Introduction-JAVA/tree/main/src-projects/Module02/Exercicies/Lesson11](https://github.com/ThayronyVonHeld/Introduction-JAVA/tree/main/src-projects/Module02/Exercicies/Lesson11)

---

## 🧩 Class Structure

### 🧬 Abstract Class `Animal`

```java
public abstract class Animal {
    protected float weight;
    protected int age;
    protected int limbs;

    public abstract void makeSound();
}
```

---

### 🐺 Class `Wolf`

```java
public class Wolf extends Mammal {
    @Override
    public void makeSound() {
        System.out.println("Auuuuuu!");
    }
}
```

---

### 🐕 Class `Dog`

In addition to overriding `makeSound()`, the dog implements **overloading** with the `react()` method.

---

## 🔁 Overloaded Versions of `react()`

### 🗣️ Reacting to a phrase

```java
public void react(String phrase) {
    if (phrase.equals("have some food") || phrase.equals("hello")) {
        System.out.println("Wag tail");
    } else {
        System.out.println("Growl");
    }
}
```

---

### ⏰ Reacting to time

```java
public void react(int hour, int min) {
    if (hour < 12) {
        System.out.println("Wag tail");
    } else if (hour >= 18) {
        System.out.println("Ignore");
    } else {
        System.out.println("Wag tail and bark");
    }
}
```

---

### 👤 Reacting if it’s the owner

```java
public void react(boolean owner) {
    if (owner) {
        System.out.println("Wag tail");
    } else {
        System.out.println("Aggressive barking");
    }
}
```

---

### 📏 Reacting by age and weight

```java
public void react(int age, float weight) {
    if (age < 5) {
        if (weight < 10) {
            System.out.println("Wag tail");
        } else {
            System.out.println("Bark");
        }
    } else {
        if (weight < 10) {
            System.out.println("Growl");
        } else {
            System.out.println("Ignore");
        }
    }
}
```

➡️ **Same method (`react`)**, multiple signatures, multiple behaviors.

---

## ▶️ Overloading in Action (Main Program)

```java
Dog d = new Dog();

d.react("hello");
d.react(11, 30);
d.react(true);
d.react(3, 9.5f);
```

### 📌 What does Java do?

* Analyzes the **passed parameters**
* Automatically identifies **which method version to call**
* Choice made **at compile time**

➡️ This is **polymorphism by overloading**.

---

## ⚡ Benefits of Overloading

* **Consistent Interface**
* **Flexibility for the User**
* **Code Reusability**

---

## 🚫 Very Important Rule

❌ It is **not allowed** to create two methods with the **same signature**, even if:

* Variable names are different
* Return types are different

```java
public void react(int a, int b) { }
public int react(int x, int y) { } // ❌ ERROR
```

➡️ Duplicate signature → compilation error.

---

## 🍔 Final Analogy: Fast-Food Attendant

Imagine a fast-food attendant:

* You order **“water”** → you get water
* You order **“sparkling water”** → you get something else
* You order **“water with ice”** → you get yet another

➡️ The base request is the same (**method**),
➡️ But the order details (**parameters**) change the result.

```java
class Attendant {
    // SAME "serve", DIFFERENT parameters!
    public void serve(String order) {
        if (order.equals("water")) {
            System.out.println("Delivers a bottle of water 💧");
        }
    }
    
    public void serve(String order, boolean sparkling) {
        if (sparkling) {
            System.out.println("Delivers sparkling water 💦");
        } else {
            serve(order); // Reuses the previous method!
        }
    }
    
    public void serve(String order, boolean ice, boolean lemon) {
        System.out.println("Delivers water with ice" + 
                          (lemon ? " and lemon" : "") + " 🍋");
    }
    
    public void serve(String order, int quantity) {
        System.out.println("Delivers " + quantity + 
                          " bottles of water 📦");
    }
}

// Usage:
Attendant a = new Attendant();
a.serve("water");              // Water bottle
a.serve("water", true);        // Sparkling water
a.serve("water", true, true);  // Water with ice and lemon
a.serve("water", 6);           // 6 bottles
```

**Same command** (“serve water”), **different results** based on parameters!

---

## 🚨 Important Rules and Restrictions

### ❌ **What is NOT valid overloading**:

```java
class Example {
    // 1. SAME signature, different return type → ERROR!
    public void method(int x) { }
    // public int method(int y) { return y; } // COMPILATION ERROR!
    
    // 2. SAME signature, different parameter name → ERROR!
    public void test(int value) { }
    // public void test(int number) { } // ERROR!
    
    // 3. SAME signature, different access modifier → ERROR!
    private void action(int x) { }
    public void action(int y) { } // ERROR! Same signature
}
```

### ✅ **What IS valid overloading**:

```java
class Valid {
    // Different number of parameters
    public void method() { }
    public void method(int x) { }
    public void method(int x, int y) { }
    
    // Different parameter types
    public void method(String s) { }
    public void method(double d) { }
    
    // Different order of types
    public void method(int x, String s) { }
    public void method(String s, int x) { } // DIFFERENT!
    
    // Varargs
    public void method(int... numbers) { }
    public void method(String s, int... numbers) { }
}
```

---

## 💡 Best Practices with Overloading

### ✅ **DO**:

1. **Use descriptive parameter names**
2. **Document** the different versions
3. **Provide default values** when possible
4. **Reuse code** between overloaded versions

### ❌ **DON’T**:

1. Don’t overload methods with radically different behaviors
2. Don’t create too many versions (keep it simple)
3. Don’t ignore compatibility between versions
4. Don’t use overloading where inheritance would be more appropriate

---

> 💡 Tip: Overloading is like being a versatile chef — with the same basic tools (methods), you can create completely different dishes depending on the ingredients (parameters) you use! 👨‍🍳

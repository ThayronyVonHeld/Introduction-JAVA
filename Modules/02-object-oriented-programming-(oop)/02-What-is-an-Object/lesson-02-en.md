# 📚 Lesson 2 - What is an Object?

---

## 🎯 Lesson Objectives

* Understand the concept of objects in Object-Oriented Programming (OOP)
* Differentiate between concrete and abstract objects
* Identify attributes, methods, and states of objects
* Understand the relationship between classes and objects
* Apply the concept of abstraction when modeling objects

---

## 🧐 What is an Object?

Ask yourself: **what is an object?**
Look around and try to identify how many objects you can see.

For example: a **cell phone**, a **car**, a **mouse**, or a **joystick**.
All of these are **objects**, things we can **see, touch, use, and describe**.

But what if I asked you:

* Is your **dentist appointment** an object?
* What about the **meeting you scheduled**?
* Or a **button on your phone screen**?

Most people would say that **only the first four** (cell phone, car, joystick, and mouse) are objects.
But can’t the others **also be considered objects**?

---

### 📘 Formal Definition of an Object

According to classical Object-Oriented Programming:

> **“An object is a material or abstract thing that can be perceived by the senses and described through its characteristics, behaviors, and current state.”**

So, an object can be something **concrete** (like a pen) or **abstract** (like an appointment).
What matters is that it has:

* **Characteristics**
* **Behaviors**
* **State**

---

## ✏️ Example 1 – Remote Control

A **remote control** is an excellent example of an object:

* **Characteristics** → has buttons, a brand “X”, model “RM”
* **Behaviors** → turn on, record, pause, power off
* **State** → off, new, low battery, or searching for a signal

Anything that has **characteristics, behaviors, and a state** is an **object**.

### Practical Example – Remote Control

```java
// CHARACTERISTICS (What does it have?)
String brand = "X";
String model = "RM";
int buttonCount = 2;

// BEHAVIORS (What does it do?)
void turnOn() { /* code */ }
void record() { /* code */ }
void pause() { /* code */ }

// STATE (What is its current condition?)
boolean isOn = false;
int batteryLevel = 75;
boolean connected = true;
```

---

## 📅 Example 2 – Appointment

Now think about your **dentist appointment**.

* **Characteristics** → date and time, location, type (consultation, check-up, etc.)
* **Behaviors** → schedule, reschedule, cancel
* **State** → scheduled, canceled, or completed

Even though it’s **abstract**, it still has these three dimensions, therefore, it’s also an **object**.

---

## ✨ The Three Pillars of Every Object

### 1. **What do I have?** → **Attributes**

* Physical or descriptive characteristics
* Properties that define the object

### 2. **What do I do?** → **Methods**

* Actions the object can perform
* Behaviors and functionalities

### 3. **How am I now?** → **State**

* The object’s current situation
* Specific values at a given time

---

## 🖊️ Detailed Example: Pen

### 🧠 The Pen Class

Before creating a pen, we need its **mold**.
In a factory, this mold is designed based on the **characteristics** of the final product.

In programming, we do the same: we create a **Pen class**.

---

### 🏭 Class vs Object

| Concept    | Analogy             | Definition                               |
| ---------- | ------------------- | ---------------------------------------- |
| **Class**  | **Mold** of the pen | Blueprint or design                      |
| **Object** | **Actual pen**      | Concrete instance created from the class |

---

### Basic Structure

```pseudocode
class Pen
    // Attributes
    model : string
    color : string
    tip : double
    inkLevel : int
    capped : boolean

    // Methods
    method write()
    end method

    method cap()
    end method
end class
```

---

## 🧩 Methods in Action

Inside the methods, we define the pen’s behavior.

### Example – Method `write()`

```pseudocode
if capped == true then
    print("Error: The pen is capped")
else
    print("Writing...")
end if
```

### Example – Method `cap()`

```pseudocode
capped = true
```

Methods can change the **attributes** of a class.
That’s what makes objects **dynamic**.

---

## 🧪 Creating an Object (Instantiating)

The computer **doesn’t know what a pen is**, you have to teach it.

We create a **class** (the mold) and then **instantiate** an object:

```pseudocode
P1 = new Pen
```

Now we have a pen called `P1`.

We can set its attributes:

```pseudocode
P1.color = "Blue"
P1.tip = 0.5
P1.capped = false
```

And use its methods:

```pseudocode
P1.write()
```

We can also create another object:

```pseudocode
P2 = new Pen
P2.color = "Red"
P2.tip = 1.0
P2.cap()
```

Now we have **two different pens** (two objects) created from the **same class**.

---

### Analysis in Java

#### **ATTRIBUTES** (What does the pen have?)

```java
String model;
String color; 
double tip;    
int inkLevel;
boolean capped;
```

#### **METHODS** (What does the pen do?)

```java
void write() { /* code */ }
void cap() { /* code */ }
void uncap() { /* code */ }
boolean canWrite() { /* code */ }
```

#### **STATE** (How is it right now?)

```java
model = "Bic Cristal";
color = "Blue";
tip = 0.5;
inkLevel = 90;
capped = false; // CURRENT STATE: Uncapped, 90% ink, writing
```

---

### 📝 Example in Code

#### **CLASS** (Blueprint)

```java
public class Pen {
    // ATTRIBUTES
    String model;
    String color;
    double tip;
    int inkLevel;
    boolean capped;
    
    // METHODS
    void write() {
        if (capped) {
            System.out.println("Error! Pen is capped");
        } else {
            System.out.println("Writing...");
        }
    }
    
    void cap() {
        capped = true;
    }
}
```

#### **OBJECTS** (Instances)

```java
Pen p1 = new Pen();  
Pen p2 = new Pen();

p1.color = "Blue";
p1.tip = 0.5;
p1.capped = false;

p2.color = "Red"; 
p2.tip = 1.0;
p2.capped = true;
```

---

## 🔄 Instantiation

### What is Instantiation?

> **Instantiation** is the process of creating a specific object from a class.

### Syntax

```java
// objectName = new Class();
Pen myPen = new Pen();
RemoteControl myRemote = new RemoteControl();
Student student1 = new Student();
```

### 📌 Key Points

* A **class** can generate **multiple objects**
* Each object has its **own attribute values**
* Objects from the same class are **independent**

---

## 🧱 Class × Object × Instance

| Term            | Definition                                    |
| --------------- | --------------------------------------------- |
| **Class**       | Blueprint that defines attributes and methods |
| **Object**      | Instance (example) created from the class     |
| **Instantiate** | Action of creating an object from a class     |

Example:

> “Pen class” is the blueprint,
> “P1” and “P2” are objects (instances) of that class.

---

## 🧠 Abstraction: The First Pillar of OOP

### What is Abstraction?

You are a person. So am I.
We’re both objects of the **Person class**.

We share the same **attributes** (name, age, weight...), but have **different states**.

**Abstraction** helps us **focus only on the relevant attributes** for a given context.

> **Abstraction** means focusing on the relevant aspects of an object for a specific context and ignoring unnecessary details.

* In a **student registration system**, eye color is irrelevant.
* In a **modeling agency system**, it’s essential.

👉 Abstraction means **ignoring what doesn’t matter** and **keeping what does**.

---

### Example of Abstraction

#### Context: Student Registration

```java
public class Student {
    // RELEVANT ATTRIBUTES
    String name;
    String registration;
    String course;
    
    // IGNORED (not relevant in this context)
    // - Eye color
    // - Weight
    // - Height
    // - Favorite soccer team
}
```

#### Context: Model Registration

```java
public class Model {
    // RELEVANT ATTRIBUTES
    double height;
    double weight;
    String eyeColor;
    String hairColor;
    
    // IGNORED (not relevant in this context)
    // - Registration
    // - Course
    // - Grades
}
```

---

## 🎯 Practical Application: Modeling Objects

### Example 1: Concrete Object – Chair

```java
public class Chair {
    String color;
    String material;
    boolean hasArms;
    double maxWeight;
    
    void sit() {
        System.out.println("Someone sat on the chair");
    }
    
    void stack() {
        System.out.println("Chair stacked");
    }
    
    boolean occupied = false;
    boolean stacked = false;
    String orientation = "front";
}
```

### Example 2: Abstract Object – Appointment

```java
public class Appointment {
    Date date;
    String time;
    String location;
    String description;
    
    void schedule() {
        System.out.println("Appointment scheduled");
    }
    
    void cancel() {
        System.out.println("Appointment canceled");
    }
    
    void postpone() {
        System.out.println("Appointment postponed");
    }
    
    String status = "scheduled"; // scheduled, canceled, completed
}
```

---

## 📋 Comparison Table: Class vs Object

| Aspect         | Class                 | Object            |
| -------------- | --------------------- | ----------------- |
| **Nature**     | Abstract              | Concrete          |
| **Definition** | Blueprint, design     | Instance, example |
| **Time**       | Exists at design time | Exists at runtime |
| **Quantity**   | One per concept       | Many per class    |
| **Analogy**    | House blueprint       | Built house       |

---

## 🎮 Practice Activity

### 🔍 Exercise 1: Concrete Objects

**Choose TWO concrete objects around you and analyze:**

#### Object: [Your Object Here]

* **Attributes**:
* **Methods**:
* **Current State**:

#### Object: [Your Object Here]

* **Attributes**:
* **Methods**:
* **Current State**:

---

### 💭 Exercise 2: Abstract Objects

**Choose TWO abstract objects from your daily life:**

#### Object: [Example: Class]

* **Attributes**: time, subject, teacher, students
* **Methods**: start(), end(), postpone()
* **Current State**: "waiting to start"

#### Object: [Your Abstract Object]

* **Attributes**:
* **Methods**:
* **Current State**:

---

> 💡 **Tip:** "Practice identifying objects in your daily life. Always ask yourself: *What does it have? What does it do? What is its current state?* This mindset is key to becoming a good object-oriented programmer.
> Abstraction is your ally — focus on what truly matters for the problem you’re solving!"

**Keep seeing the world through OOP lenses! 👓**

---


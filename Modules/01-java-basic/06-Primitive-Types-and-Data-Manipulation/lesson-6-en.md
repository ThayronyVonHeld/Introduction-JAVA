# 📚 Lesson 6 - Primitive Types and Data Manipulation

---

## 🎯 Lesson Objectives
- Understand different types of comments in Java
- Master primitive types and their declarations
- Learn to work with data input and output
- Understand type conversions (Typecast and Wrapper Classes)
- Create a Swing application with data manipulation

---

## 💬 Comments in Java

Comments are essential for documenting code and facilitating maintenance. Java offers three main types:

### 1. Single Line Comment
```java
// This is a single line comment
int age = 25; // Comment after code
```

### 2. Multi-line Comment
```java
/*
 * This is a comment
 * that spans multiple lines
 * very useful for long explanations
 */
```

### 3. Documentation Comment (Javadoc)
```java
/**
 * Main System Class
 * @author Thayrony
 * @version 14.2
 * @since 2025
 */
```

> 📖 **Official Documentation**: [Java Documentation Tool](https://docs.oracle.com/javase/8/docs/technotes/tools/windows/javadoc.html)

---

## 🔢 Primitive Types in Java

Java is a **strongly typed** language - types are essential and require attention.

### Three Ways to Declare Variables

#### 1. Simple Declaration
```java
int age = 3;
```

#### 2. Using Typecast
```java
int age = (int) 3;
```

#### 3. Using Wrapper Classes
```java
Integer age = new Integer(3);
```

---

## 📊 Primitive Types Table

| Primitive Type | Wrapper Class | Size | Example |
|----------------|---------------|---------|---------|
| `byte` | `Byte` | 1 byte | `byte b = 127;` |
| `short` | `Short` | 2 bytes | `short s = 32000;` |
| `int` | `Integer` | 4 bytes | `int i = 2147483647;` |
| `long` | `Long` | 8 bytes | `long l = 9223372036854775807L;` |
| `float` | `Float` | 4 bytes | `float f = 3.14f;` |
| `double` | `Double` | 8 bytes | `double d = 3.14159265359;` |
| `char` | `Character` | 2 bytes | `char c = 'A';` |
| `boolean` | `Boolean` | 1 bit | `boolean flag = true;` |

---

## 🎯 Practical Declaration Examples

### Integer Numbers
```java
// Three ways to declare integers
int age1 = 25;                    // Simple form
int age2 = (int) 25;              // With typecast
Integer age3 = new Integer(25);   // With wrapper class
```

### Real Numbers (Float)
```java
// Three ways to declare float
float salary1 = 1825.54f;          // With 'f' at the end
float salary2 = (float) 1825.54;   // With typecast
Float salary3 = new Float(1825.54); // With wrapper class
```

### Characters
```java
// Three ways to declare char
char letter1 = 'G';                   // Simple form
char letter2 = (char) 'G';            // With typecast
Character letter3 = new Character('G'); // With wrapper class
```

### Booleans
```java
// Three ways to declare boolean
boolean married1 = true;              // Simple form
boolean married2 = (boolean) true;    // With typecast
Boolean married3 = new Boolean(true); // With wrapper class
```

---

## 🖨️ Data Output

### Printing Methods

```java
public class OutputExample {
    public static void main(String[] args) {
        String name = "Thayrony";
        float grade = 8.5f;
        
        // System.out.print() - without line break
        System.out.print("Grade: " + grade);
        
        // System.out.println() - with line break
        System.out.println("Name: " + name);
        
        // System.out.printf() - formatting
        System.out.printf("%s your grade is: %.2f\n", name, grade);
        
        // System.out.format() - similar to printf
        System.out.format("Formatted grade: %.1f", grade);
    }
}
```

**Output:**
```
Grade: 8.5Name: Thayrony
Thayrony your grade is: 8.50
Formatted grade: 8.5
```

---

## ⌨️ Data Input with Scanner

### Import and Configuration
```java
import java.util.Scanner;

public class DataInput {
    public static void main(String[] args) {
        // Creating Scanner object
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("Enter your name: ");
        String name = keyboard.nextLine();
        
        System.out.print("Enter your age: ");
        int age = keyboard.nextInt();
        
        System.out.print("Enter your salary: ");
        float salary = keyboard.nextFloat();
        
        System.out.printf("Hello %s, you are %d years old and earn $ %.2f", 
                         name, age, salary);
        
        keyboard.close(); // Close the scanner
    }
}
```

### Scanner Methods
- `nextLine()` - Reads a complete line (String)
- `nextInt()` - Reads an integer number
- `nextFloat()` - Reads a float number
- `nextDouble()` - Reads a double number
- `nextBoolean()` - Reads a boolean

---

## 🔄 Type Conversion

### Type Incompatibility
```java
int age = 30;
// String value = age; // ERROR! Incompatible types
```

### Correct Conversions

#### From Primitive to String
```java
int age = 30;
String value1 = Integer.toString(age);      // Using wrapper class
String value2 = String.valueOf(age);        // Using String.valueOf()
```

#### From String to Primitive
```java
String text = "30";
int number1 = Integer.parseInt(text);        // To integer
float number2 = Float.parseFloat("30.5");     // To float
double number3 = Double.parseDouble("30.75"); // To double
```

#### Complete Example
```java
public class TypeConversion {
    public static void main(String[] args) {
        // Integer to String
        int age = 30;
        String ageText = Integer.toString(age);
        System.out.println("Age as text: " + ageText);
        
        // String to Integer
        String value = "25";
        int number = Integer.parseInt(value);
        System.out.println("Number: " + number);
        
        // Float to String and vice-versa
        String salaryText = "1825.54";
        float salary = Float.parseFloat(salaryText);
        System.out.printf("Salary: $ %.2f", salary);
    }
}
```

---

## 🧮 Practical Project: Swing Calculator

### Creating the Graphical Interface

#### Step by Step in NetBeans:
1. **Ctrl + Shift + N** → New Project
2. **Java with Ant** → **Java Application**
3. Name: `SwingCalculator`
4. **New** → **JFrame Form** → `Calculator`

#### Interface Elements:
- **TextField** → `txtN1` (empty text)
- **TextField** → `txtN2` (empty text)
- **Label** → `"+"` (addition sign)
- **Button** → `btnSum` (text: "=")
- **Label** → `lblResult` (text: "0")

### Sum Button Code

```java
private void btnSumActionPerformed(java.awt.event.ActionEvent evt) {
    // Convert TextField (String) to int
    int n1 = Integer.parseInt(txtN1.getText());
    int n2 = Integer.parseInt(txtN2.getText());
    
    // Perform the sum
    int sum = n1 + n2;
    
    // Convert result to String and display
    lblResult.setText(Integer.toString(sum));
}
```

### Complete Calculator Code

```java
public class Calculator extends javax.swing.JFrame {

    private void btnSumActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            // Get values from text fields
            int n1 = Integer.parseInt(txtN1.getText());
            int n2 = Integer.parseInt(txtN2.getText());
            
            // Calculate sum
            int result = n1 + n2;
            
            // Display result
            lblResult.setText(String.valueOf(result));
            
        } catch (NumberFormatException e) {
            lblResult.setText("Error: Enter valid numbers!");
        }
    }
    
    // Component variables
    private javax.swing.JButton btnSum;
    private javax.swing.JLabel lblResult;
    private javax.swing.JTextField txtN1;
    private javax.swing.JTextField txtN2;
}
```

---

## 🛡️ Error Handling

### Avoiding NumberFormatException
```java
private void btnSumActionPerformed(java.awt.event.ActionEvent evt) {
    try {
        int n1 = Integer.parseInt(txtN1.getText());
        int n2 = Integer.parseInt(txtN2.getText());
        int sum = n1 + n2;
        lblResult.setText(Integer.toString(sum));
        
    } catch (NumberFormatException e) {
        lblResult.setText("Error: Enter only numbers!");
    }
}
```

---

## 📋 Learning Checklist

- [ ] Understood the three types of comments in Java
- [ ] Learned to declare variables in three different ways
- [ ] Know all primitive types and their wrapper classes
- [ ] Can work with data input and output
- [ ] Understand how to convert between different types
- [ ] Created a functional calculator with Swing
- [ ] Learned to handle conversion errors

---

## 🎓 Concept Summary

| Concept | Example | Description |
|----------|---------|-----------|
| **Comment** | `// text` | Code documentation |
| **Typecast** | `(int) 3.14` | Explicit type conversion |
| **Wrapper Class** | `Integer.valueOf()` | Classes that wrap primitive types |
| **Scanner** | `nextInt()` | User data input |
| **printf** | `%.2f` | Output formatting |
| **parseInt** | `Integer.parseInt()` | String to integer |

---

## 🚀 Practical Exercises

1. **Advanced Calculator**: Add subtraction, multiplication and division operations
2. **Temperature Converter**: Convert Celsius to Fahrenheit
3. **Age Validator**: Check if user is over 18
4. **BMI Calculator**: Calculate Body Mass Index

---

## 🔍 Important Tips

- Always close `Scanner` with `.close()`
- Use `try-catch` to avoid `NumberFormatException`
- Prefer `Integer.valueOf()` instead of `new Integer()`
- Use `printf` for professional output formatting
- Document your code with Javadoc for real projects


---

> 💡 **Tip**: "Consistent practice is the key to mastering data types. Try creating small programs every day to solidify your knowledge!"
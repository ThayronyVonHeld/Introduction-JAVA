# 📚 Lesson 3

IDE and JDK

---

### IDE — Integrated Development Environment

An **IDE (Integrated Development Environment)** is software that helps you **write, compile, and debug programs efficiently**.

Popular Java IDEs:

* **IntelliJ IDEA**
* **Eclipse**
* **NetBeans**
* **VS Code** (with extensions)

> IDEs speed up development and offer features like syntax highlighting, autocomplete, debugger, and version control integration (Git).

---

### Which JDK to install?

There are different editions of Java depending on the type of application you want to develop:

* **SE — Standard Edition**

    * For developing **simple applications** with windows or graphical interfaces.
* **EE — Enterprise Edition**

    * For **more complex applications**, with **databases** and **remote access**.
* **ME — Micro Edition**

    * For **portable applications**, such as on **mobile devices** or IoT.

---

### Difference between JDK and SDK

* **JDK — Java Development Kit**

    * A set of tools to **develop Java applications**.
    * Includes **JRE**, compiler (`javac`), debugger (`jdb`), documentation (`javadoc`) and other tools.
* **SDK — Software Development Kit**

    * A more **general development kit**, used to create applications in any language or platform.
    * An SDK may contain **libraries, tools, documentation, and examples**.
* **Summary of the difference**

    * Every **JDK is an SDK** specifically for Java, but not every SDK is a JDK.
    * SDK = general concept; JDK = Java-specific SDK.

---

### How to install IntelliJ IDEA (step by step)

1. Go to the official website: [https://www.jetbrains.com/idea/download/](https://www.jetbrains.com/idea/download/)
2. Choose the version:

    * **Community** → free
    * **Ultimate** → paid (more features, aimed at enterprises)
3. Download the installer for your operating system (Windows, Mac, or Linux)
4. Run the installer and follow the instructions:

    * Accept the license terms
    * Choose the installation folder
    * Select additional options, like creating a desktop icon or associating `.java` files
5. Finish the installation and open IntelliJ IDEA
6. Configure **JDK 24** when creating a new project:

    * File → New → Project → SDK → Add JDK → select the JDK 24 installation path

---

### How to install JDK 24

1. Access the official documentation: [JDK 24 Oracle](https://docs.oracle.com/en/java/javase/24/index.html)
2. Download **JDK 24 SE** for your operating system
3. Run the installer:

    * Accept the license terms
    * Choose the installation folder
4. Set the `JAVA_HOME` environment variable (important for Windows):

    * Path to JDK installation (e.g.: `C:\Program Files\Java\jdk-24`)
5. Add `%JAVA_HOME%\bin` to the system **PATH**
6. Verify the installation:

   ```bash
   java -version
   javac -version
   ```

   > It should show something like: `java version "24"` and `javac 24`

---

### Quick summary

* **IDE** → environment that makes development easier. E.g., IntelliJ, Eclipse.
* **JDK** → kit to develop in Java (SE, EE, ME).
* **SDK** → general development kit (Java, Android, etc.).
* **SE** → simple programs with graphical interface.
* **EE** → complex applications with database and networking.
* **ME** → portable applications, mobile devices.
* **RAD** → method for rapid application development.

---


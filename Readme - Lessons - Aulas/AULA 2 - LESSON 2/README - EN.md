# 📚 Lesson 2

How does Java work?

---

### Code flow (from `.java` to execution)

1. **Source file (`.java`)**
2. **Compilation (`javac`)** → generates **bytecode** (`.class`)
3. **Execution on the JVM** → bytecode runs on any OS with a compatible **JRE/JDK**

> Write once, run anywhere.

---

### Java Acronyms (“Alphabet Soup”)

- **JDK — Java Development Kit**: everything needed to **develop**.
    - Includes the **JRE**, the **`javac`** compiler, **`jdb`** (debugger), **`jar`**, **`javadoc`**, **`jshell`**, etc.
- **JRE — Java Runtime Environment**: everything needed to **run** programs.
    - **JVM** + **standard libraries** (Java SE APIs).
- **JVM — Java Virtual Machine**: the virtual machine that executes bytecode.
    - **Class Loader**
    - **Bytecode Verifier**
    - **Interpreter** + **JIT (Just-In-Time) Compiler**
    - **Garbage Collector** (memory manager)

---

### Two roles (who uses what)

- **Developer** → uses the **JDK** to compile, test, and package applications.
- **End-user** → only needs the **runtime environment** (JRE/JDK).

> Note: since **Java 11**, many vendors stopped distributing a standalone JRE; applications often ship with their own **runtime** (via `jlink`) or require a **JDK** installation.

---

### IDE (Integrated Development Environment)

Tools that make Java development faster and more efficient:  
**IntelliJ IDEA**, **Eclipse**, **NetBeans**, **VS Code** (with extensions).

---

### Quick recap

- **`javac`** compiles `.java` ➜ `.class` (**bytecode**).
- **JVM** runs the bytecode on any operating system.
- **JDK** = develop; **JRE** = run; **JVM** = where the code executes.

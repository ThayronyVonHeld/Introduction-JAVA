# 📚 Aula 2

Como funciona o Java?

---

### Fluxo do código (de `.java` à execução)

1. **Arquivo fonte (`.java`)**
2. **Compilação (`javac`)** → gera **bytecode** (`.class`)
3. **Execução na JVM** → o bytecode roda em qualquer SO com uma **JRE/JDK** compatível

> Escreva uma vez, rode em qualquer lugar (*Write once, run anywhere*).

---

### “Sopa de letrinhas” do Java (visão geral)

- **JDK — Java Development Kit**: tudo para **desenvolver**.
    - Inclui a **JRE**, o compilador **`javac`**, **`jdb`** (debugger), **`jar`**, **`javadoc`**, **`jshell`**, etc.
- **JRE — Java Runtime Environment**: tudo para **executar**.
    - **JVM** + **bibliotecas** da plataforma (APIs do Java SE).
- **JVM — Java Virtual Machine**: máquina virtual que executa o bytecode.
    - **Class Loader** (carregador)
    - **Bytecode Verifier** (verificador)
    - **Interpreter** + **JIT (Just-In-Time) Compiler**
    - **Garbage Collector** (gerenciador de memória)

---

### Dois momentos (quem usa o quê)

- **Programador** → usa o **JDK** para compilar, testar e empacotar.
- **Usuário** → precisa apenas do **ambiente de execução** (JRE/JDK).

> Nota: a partir do **Java 11**, muitos vendors não distribuem uma JRE separada; aplicações costumam vir com um **runtime** próprio (ex.: `jlink`) ou pedem a instalação do **JDK**.

---

### IDE (Integrated Development Environment)

Ferramentas que aceleram o desenvolvimento em Java:
**IntelliJ IDEA**, **Eclipse**, **NetBeans**, **VS Code** (com extensões).

---

### Resumo rápido

- **`javac`** transforma `.java` ➜ `.class` (**bytecode**).
- **JVM** executa o bytecode, independente do sistema operacional.
- **JDK** = desenvolver; **JRE** = executar; **JVM** = onde o código roda.

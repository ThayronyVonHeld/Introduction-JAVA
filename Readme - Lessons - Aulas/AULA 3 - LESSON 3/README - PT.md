# 📚 Aula 3

IDE e JDK

---

### IDE — Ambiente de Desenvolvimento Integrado

Uma **IDE (Integrated Development Environment)** é um software que ajuda a escrever, compilar e depurar programas de forma mais eficiente.

Exemplos de IDEs populares para Java:

* **IntelliJ IDEA**
* **Eclipse**
* **NetBeans**
* **VS Code** (com extensões)

> IDEs aceleram o desenvolvimento e oferecem ferramentas como: destaque de sintaxe, autocomplete, depurador e integração com sistemas de versionamento (Git).

---

### Qual JDK instalar?

Existem diferentes edições do Java, dependendo do tipo de aplicação que você quer desenvolver:

* **SE — Standard Edition**

    * Para desenvolver **aplicações simples** com janelas ou interfaces gráficas.
* **EE — Enterprise Edition**

    * Para aplicações **mais complexas**, com **bancos de dados** e **acessos remotos**.
* **ME — Micro Edition**

    * Para aplicações **portáteis**, como em **dispositivos móveis** ou IoT.

---

### Diferença entre JDK e SDK

* **JDK — Java Development Kit**

    * Conjunto de ferramentas para **desenvolver aplicações em Java**.
    * Inclui **JRE**, compilador (`javac`), debugger (`jdb`), documentação (`javadoc`) e outras ferramentas.
* **SDK — Software Development Kit**

    * Kit de desenvolvimento mais **genérico**, usado para criar aplicações em qualquer linguagem ou plataforma.
    * Um SDK pode conter **bibliotecas, ferramentas, documentação e exemplos**.
* **Resumo da diferença**

    * Todo **JDK é um SDK** específico para Java, mas nem todo SDK é JDK.
    * SDK = conceito genérico; JDK = SDK para Java.

---

### Como instalar a IDE IntelliJ IDEA (passo a passo)

1. Acesse o site oficial: [https://www.jetbrains.com/idea/download/](https://www.jetbrains.com/idea/download/)
2. Escolha a versão:

    * **Community** → gratuita
    * **Ultimate** → paga (mais recursos, voltada para empresas)
3. Baixe o instalador correspondente ao seu sistema operacional (Windows, Mac ou Linux)
4. Execute o instalador e siga as instruções:

    * Aceite os termos de uso
    * Escolha a pasta de instalação
    * Marque opções adicionais, como criar ícone na área de trabalho ou associar arquivos `.java`
5. Conclua a instalação e abra o IntelliJ IDEA
6. Configure o **JDK 24** ao criar um novo projeto:

    * File → New → Project → SDK → Add JDK → selecione o caminho da instalação do JDK 24

---

### Como instalar o JDK 24

1. Acesse a documentação oficial: [JDK 24 Oracle](https://docs.oracle.com/en/java/javase/24/index.html)
2. Baixe o **JDK 24 SE** para o seu sistema operacional
3. Execute o instalador:

    * Aceite os termos de licença
    * Escolha a pasta de instalação
4. Configure a variável de ambiente `JAVA_HOME` (importante para sistemas Windows):

    * Caminho da instalação do JDK (ex.: `C:\Program Files\Java\jdk-24`)
5. Adicione `%JAVA_HOME%\bin` ao **PATH** do sistema
6. Verifique a instalação:

   ```bash
   java -version
   javac -version
   ```

   > Deve aparecer algo como: `java version "24"` e `javac 24`

---

### Resumo rápido

* **IDE** → ambiente que facilita o desenvolvimento. Ex.: IntelliJ, Eclipse.
* **JDK** → kit para desenvolver em Java (SE, EE, ME).
* **SDK** → kit de desenvolvimento genérico (Java, Android, etc.).
* **SE** → programas simples com interface gráfica.
* **EE** → aplicações complexas com banco de dados e rede.
* **ME** → aplicações portáteis, dispositivos móveis.
* **RAD** → método para desenvolvimento rápido de aplicações.

---

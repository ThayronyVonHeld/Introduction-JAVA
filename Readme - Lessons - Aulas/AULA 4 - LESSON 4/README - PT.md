# 📚 Aula 4

Primeiro programa em Java!

---

### Estrutura básica de um programa em Java

Um programa em Java pode ser organizado em **pacotes**, **classes** e **métodos**.

Exemplo de código:

```java
package primeiroprograma; // opcional

public class PrimeiroPrograma { // Classe (bloco principal)
    public static void main(String[] args) { // Método principal
        System.out.print("Olá Mundo");
    }
}
```

---

### Analisando o código

* **`package primeiroprograma;`** → opcional, indica o pacote onde a classe está.
* **`public class PrimeiroPrograma { ... }`** → define a **classe** (um bloco).
* **`public static void main(String[] args) { ... }`** → método principal, ponto de entrada do programa.
* **`System.out.print("Olá Mundo");`** → instrução que exibe texto no console.

> Estrutura hierárquica:
> **Pacote** → **Classe** → **Método** → **Instrução**

---

### Atenção às letras! ⚠️

* Java é **case sensitive** → diferencia letras maiúsculas e minúsculas.

    * Ex.: `System` é diferente de `system`.

---

### Ajuda da IDE (atalhos)

Muitas IDEs oferecem **atalhos de código** (ex.: IntelliJ IDEA):

* Digite `psvm` → gera automaticamente o
  
 ```java
 public static void main(String[] args) { ... }
```
* Digite `sout` → gera automaticamente 

```java
System.out.print()
```
---

### CamelCase 🐪

O **CamelCase** é um estilo de escrita em que palavras compostas são unidas e cada "corcova" começa com **letra maiúscula**.

📌 Regras em Java:

* **Classe ou Interface** → primeira letra **maiúscula**, demais palavras em **CamelCase**
  Ex.: `SejaBemVindo`
* **Atributo, variável ou método** → primeira letra **minúscula**, demais palavras em **CamelCase**
  Ex.:

    * Variável: `nomeAluno`
    * Variável: `mediaPrimeiroBimestre`
    * Método: `lancarNotaAluno()`
* **Pacote** → tudo em **minúsculo**
  Ex.: `alunoscursoemvideo`
* **Constantes** → todas as letras em **maiúsculas**, palavras separadas por `_`
  Ex.: `VALOR_DE_PI`

---

### Resumo rápido

* Todo programa Java pode ter **pacote**, **classe**, **método** e **instrução**.
* O ponto de entrada é o método:

  ```java
  public static void main(String[] args) { ... }
  ```
* Java é **case sensitive** (diferencia maiúsculas e minúsculas).
* IDEs ajudam com **atalhos** como `psvm` e `sout`.
* Convenções de escrita:

    * **Classe/Interface** → `PrimeiraMaiuscula`
    * **Variável/Método** → `primeiraMinuscula`
    * **Pacote** → `minusculo`
    * **Constante** → `MAIUSCULA_SEPARADA_POR_UNDERLINE`


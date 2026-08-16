# 📚 Aula 3 – Modificadores de Visibilidade

---

## 🎯 Objetivos da Aula
- Compreender o conceito de UML e diagramas de classes
- Identificar os tipos de modificadores de acesso
- Relacionar os conceitos de visibilidade com exemplos práticos
- Aplicar os modificadores em código Java

---

## 🧭 Introdução

A **visibilidade** é uma das grandes essências da Programação Orientada a Objetos.
Ela define **quem pode acessar** os atributos e métodos de uma classe, garantindo **segurança e organização** no código.

Antes de falarmos sobre os modificadores de visibilidade, vamos entender rapidamente um recurso muito usado na modelagem de sistemas: a **UML (Unified Modeling Language)**.

---

## 🧩 UML – Linguagem de Modelagem Unificada

A **UML** é uma linguagem padronizada usada para **visualizar, especificar, construir e documentar** sistemas de software.

Entre seus vários diagramas, o mais famoso (e o que nos interessa agora) é o **diagrama de classes**.

---

## 🏗️ Diagrama de Classes

O **diagrama de classes** é uma forma simples de **representar visualmente uma classe e seus elementos**.

Por exemplo, se pegarmos a classe `Caneta` (vista na aula anterior), podemos representá-la assim:

```
+---------------------+
|      Caneta         |   ← Nome da Classe
+---------------------+
| modelo              |   ← Atributos
| cor                 |
| carga               |
| ponta               |
| tampada             |
+---------------------+
| escrever()          |   ← Métodos
| rabiscar()          |
| pintar()            |
| tampar()            |
| destampar()         |
+---------------------+
```

Perceba que:

* A **classe** é o título no topo, iniciando com **letra maiúscula**.
* Os **atributos** e **métodos** começam com **letra minúscula**.
* Os **métodos** possuem **parênteses `()`**, indicando ações.

Esse diagrama ajuda a **visualizar rapidamente** o que uma classe possui e o que ela pode fazer.

---

## 🔒 O que são Modificadores de Visibilidade?

Os **modificadores de visibilidade** indicam **quem pode acessar** os **atributos e métodos** de uma classe.
Eles servem para **proteger os dados** e **controlar o acesso** a determinadas partes do código.

Na **UML**, usamos os seguintes símbolos:

| Símbolo | Modificador   | Descrição                                   |
| ------- | ------------- | ------------------------------------------- |
| `+`     | **public**    | Acesso livre (qualquer classe pode acessar) |
| `-`     | **private**   | Acesso restrito à própria classe            |
| `#`     | **protected** | Acesso permitido à classe e suas subclasses |

---

## 🧱 Exemplo em UML

```
+---------------------+
|      Caneta         |
+---------------------+
| + modelo            |
| + cor               |
| - carga             |
| # ponta             |
| # tampada           |
+---------------------+
| + escrever()        |
| + rabiscar()        |
| + pintar()          |
| - tampar()          |
| - destampar()       |
+---------------------+
```

---

## ☎️ Analogias Simples

Vamos entender cada tipo com exemplos do mundo real:

### **Public (+)**

Pense em um **telefone público** (“orelhão”).
Qualquer pessoa pode usá-lo, ele é **acessível a todos**.

➡️ Em POO: **qualquer classe** pode acessar esse atributo ou método.

---

### **Private (-)**

Agora pense em um **celular pessoal**.
Apenas o dono pode usá-lo e ainda coloca senha para garantir a privacidade.

➡️ Em POO: **somente a própria classe** pode acessar ou modificar.

---

### **Protected (#)**

Imagine um **telefone corporativo**.
Somente os **funcionários da empresa** podem usar, não é público, mas também não é exclusivo de uma pessoa.

➡️ Em POO: **a classe e suas subclasses** podem acessar.

---

## 🎮 Exemplo Prático: Controle Remoto

Pense em um **controle remoto**:

* Os **botões externos** (ligar, volume, canal) → **públicos**, pois o usuário precisa usá-los.
* Os **circuitos internos** → **privados**, protegidos pela carcaça.
* O **LED infravermelho** → **protegido**, pois se comunica com a TV, mas não está acessível a qualquer pessoa.

Essa “**cápsula de proteção**” que separa o que é público do que é privado é chamada de **encapsulamento** (veremos mais sobre isso na próxima aula).

---

## 🧩 Exemplo em Pseudocódigo

```algoritmo
classe Caneta
  publico modelo : caractere
  publico cor : caractere
  protegido ponta : real
  privado carga : inteiro
  protegido tampada : lógico

  publico método escrever()
  fim método

  publico método rabiscar()
  fim método

  publico método pintar()
  fim método

  privado método tampar()
  fim método

  privado método destampar()
  fim método
fim classe
```

---

## ⚙️ Criando um Objeto

```algoritmo
c1 = nova Caneta
c1.modelo = "BIC Cristal"   // OK → público
c1.cor = "Azul"             // OK → público
c1.ponta = 0.5              // ❌ ERRO → protegido
c1.carga = 50               // ❌ ERRO → privado
c1.tampada = verdadeiro     // ❌ ERRO → protegido

c1.escrever()   // OK → público
c1.rabiscar()   // OK → público
c1.tampar()     // ❌ ERRO → método privado
```

---
## 💻 Aplicação em Código Java

### Classe Caneta com Modificadores:

```java
package oop.Lesson3.Caneta;

public class Caneta {
    // ATRIBUTOS COM MODIFICADORES
    public String modelo;      // + Público
    public String cor;         // + Público  
    private Float ponta;       // - Privado
    protected int carga;       // # Protegido
    private boolean tampada;   // - Privado
    
    // MÉTODOS
    public void status() {
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Uma caneta " + this.cor);
        System.out.println("Ponta: " + this.ponta);
        System.out.println("Carga: " + this.carga);
        System.out.println("Está tampada? " + this.tampada);
    }
    
    public void rabiscar() {
        if(this.tampada == true) {
            System.out.println("Error! Não posso rabiscar");
        } else {
            System.out.println("Estou Rabiscando");
        }
    }
    
    private void tampar() {
        this.tampada = true;
    }
    
    private void destampar() {
        this.tampada = false;
    }
}
```

### Classe Principal (Main):

```java
package oop.Lesson3.Caneta;

import Module02.Caneta.Caneta;

public class Main {
    public static void main(String[] args) {
        Caneta c1 = new Caneta();

        // ✅ ATRIBUTOS PÚBLICOS - Podemos acessar
        c1.modelo = "BIC cristal";
        c1.cor = "Azul";

        // ❌ ATRIBUTO PRIVADO - Não podemos acessar diretamente
        // c1.ponta = 0.5f;  // ERRO! Atributo privado

        // ✅ ATRIBUTO PROTEGIDO - Podemos acessar (mesmo pacote)
        c1.carga = 50;

        // ❌ ATRIBUTO PRIVADO - Não podemos acessar diretamente
        // c1.tampada = false;  // ERRO! Atributo privado

        // ❌ MÉTODO PRIVADO - Não podemos chamar diretamente
        // c1.tampar();  // ERRO! Método privado

        c1.status();
        c1.rabiscar();
    }
}
```
---
## 🎯 O que é `this`?

### Explicando `this`:
- **`this`** refere-se ao **objeto atual** que está chamando o método
- **`this.modelo`** → o atributo `modelo` **deste objeto**
- Quando temos `c1.status()`, dentro do método `status()`, **`this`** é o objeto `c1`

### Exemplo:
```java
Caneta c1 = new Caneta();
Caneta c2 = new Caneta();

c1.modelo = "BIC";
c2.modelo = "Faber-Castell";

c1.status(); // this = c1 → mostra "BIC"
c2.status(); // this = c2 → mostra "Faber-Castell"
```

---

## 🚫 Restrições de Acesso na Prática

### O que podemos e não podemos fazer:

#### ✅ **PERMITIDO** (Atributos públicos):
```java
c1.modelo = "BIC Cristal";  // ✅ Público
c1.cor = "Azul";           // ✅ Público
```

#### ✅ **PERMITIDO** (Atributo protegido - mesmo pacote):
```java
c1.carga = 50;             // ✅ Protegido (mesmo pacote)
```

#### ❌ **NEGADO** (Atributos privados):
```java
// c1.ponta = 0.5f;       // ❌ Privado - ERRO!
// c1.tampada = true;     // ❌ Privado - ERRO!
```

#### ❌ **NEGADO** (Métodos privados):
```java
// c1.tampar();           // ❌ Método privado - ERRO!
// c1.destampar();        // ❌ Método privado - ERRO!
```

---

## 🛡️ Por que usar Modificadores?

### Vantagens dos Modificadores:

1. **Encapsulamento** → Protege dados sensíveis
2. **Controle de acesso** → Define quem pode modificar o quê
3. **Manutenibilidade** → Código mais organizado e seguro
4. **Prevenção de erros** → Evita modificações acidentais

---

## 📋 Tabela Resumo - Modificadores

| Modificador | Classe | Pacote | Subclasse | Todos |
|-------------|--------|--------|-----------|-------|
| **public** | ✅ | ✅ | ✅ | ✅ |
| **protected** | ✅ | ✅ | ✅ | ❌ |
| **default** | ✅ | ✅ | ❌ | ❌ |
| **private** | ✅ | ❌ | ❌ | ❌ |

> **Default**: Quando não especificamos nenhum modificador

---

## 🚀 Exercícios Práticos

### Exercício 1: Diagrama UML
```java
// Crie um diagrama UML para a classe "Carro" com:
// Atributos: marca, modelo, ano, velocidadeAtual
// Métodos: acelerar(), frear(), ligar(), desligar()
// Defina a visibilidade de cada componente
```

### Exercício 2: Implementação em Java
```java
// Implemente a classe "Carro" em Java aplicando
// os modificadores de visibilidade apropriados
```

### Exercício 3: Análise de Acesso
```java
// Dada uma classe com atributos public, private e protected
// Identifique quais acessos serão permitidos e negados
// em diferentes contextos
```

---

> 💡 **Dica**: "Pense nos modificadores como níveis de segurança. Use `private` para o que é sensível, `protected` para o que é compartilhado na família, e `public` para o que todos precisam usar. Essa mentalidade ajuda a criar código mais seguro e organizado!"
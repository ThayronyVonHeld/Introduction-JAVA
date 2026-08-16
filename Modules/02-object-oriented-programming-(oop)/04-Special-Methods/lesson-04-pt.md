# 📚 Aula 4 – Métodos Especiais

---

## 🎯 Objetivos da Aula
- Compreender o conceito de métodos especiais em POO
- Dominar métodos acessores (getters) e modificadores (setters)
- Aprender a implementar métodos construtores
- Entender a importância do encapsulamento na segurança de dados
- Aplicar esses métodos em um exemplo prático em Java

---

## 🧭 Introdução

Em programação orientada a objetos, **métodos especiais** são funções que possuem **propósitos específicos e padronizados** dentro das classes.

Eles não são obrigatórios, mas são **amplamente utilizados** por convenção, porque tornam o código mais **seguro, legível e organizado**.

Nesta aula, veremos os três principais tipos de métodos especiais:

1. **Getters** → métodos acessores
2. **Setters** → métodos modificadores
3. **Construtores** → métodos que inicializam o objeto

---

## 🗄️ Exemplo Conceitual: A Estante

Imagine que você tem um objeto chamado `Estante`.

### 🔹 Atributos possíveis:

* Tamanho
* Cor
* Quantidade de prateleiras
* Modelo
* Fabricante

### 🔹 Métodos possíveis:

* `colocarDocumento()`
* `retirarDocumento()`
* `contarDocumentos()`

Agora, pense no seguinte:
Se várias pessoas usam a mesma estante, **você deixaria qualquer uma mexer diretamente nos documentos de todas as outras?**

Provavelmente não.
Na vida real, criamos **mecanismos de proteção**, e em POO isso também acontece.

---

## 🔑 Métodos Acessores (Getters)

Os **getters** são métodos que **acessam um atributo de forma segura**.

Eles permitem **consultar informações** de um objeto **sem alterar seu estado interno**.

📘 *Em inglês, “get” significa “pegar” ou “obter”.*

### 📦 Analogia:

Pense em um **caixa eletrônico**.
Você não abre o cofre do banco para ver seu saldo, você **pede a informação** através de uma interface segura.

---

### 💡 Exemplo Conceitual:

A estante tem um atributo `totDoc` (total de documentos).
Quer saber quantos documentos há?

Em vez de acessar diretamente `e.totDoc`, você usa o método:

```java
e.getTotDoc();
```

Assim, **você consulta o valor de forma controlada**, sem modificar nada indevidamente.

---

## 🛠️ Métodos Modificadores (Setters)

Os **setters** servem para **modificar um atributo com segurança**.
Eles controlam *como* e *quando* o valor de um atributo é alterado.

📘 *Em inglês, “set” significa “definir” ou “atribuir”.*

### 📦 Analogia:

No mesmo exemplo da estante, você quer **adicionar um documento**.
Você **não vai lá e coloca direto** — entrega o documento ao funcionário responsável.

Esse “funcionário” é o **setter**.

---

### 💡 Exemplo Conceitual:

```java
e.setTotDoc(6);
```

Aqui, `setTotDoc` recebe um **parâmetro** (6) e **atualiza** o valor do atributo internamente.

Dessa forma, você garante que **nenhum atributo seja modificado de forma direta ou incorreta.**

---

## 🛡️ Por que usar Getters e Setters?

### Vantagens:
1. **Encapsulamento** → Protege dados sensíveis
2. **Validação** → Pode verificar dados antes de modificar
3. **Controle** → Logs e auditoria de alterações
4. **Flexibilidade** → Pode mudar implementação interna sem afetar quem usa

---

## 💡 Exemplo com a Classe Caneta

Vamos simplificar nossa classe `Caneta` para dois atributos:
`modelo` (público) e `ponta` (privado).

```
+---------------------+
|       Caneta        |
+---------------------+
| + modelo            |
| - ponta             |
+---------------------+
| + getModelo()       |
| + setModelo(m)      |
| + getPonta()        |
| + setPonta(p)       |
+---------------------+
```

---

## 🧩 Pseudocódigo

```algoritmo
classe Caneta
  publico modelo : caractere
  privado ponta : real

  publico método getModelo()
    retorne modelo
  fim método

  publico método setModelo(m : caractere)
    modelo = m
  fim método

  publico método getPonta()
    retorne ponta
  fim método

  publico método setPonta(p : real)
    ponta = p
  fim método
fim classe
```

---

## 💻 Código Java Completo

### Classe Caneta

```java
package oop.Lesson4.Caneta;

public class Caneta {
    public String modelo;   // Público
    private float ponta;    // Privado

    // GETTER do modelo
    public String getModelo() {
        return this.modelo;
    }

    // SETTER do modelo
    public void setModelo(String m) {
        this.modelo = m;
    }

    // GETTER da ponta
    public float getPonta() {
        return this.ponta;
    }

    // SETTER da ponta
    public void setPonta(float p) {
        this.ponta = p;
    }
}
```

---

### Classe Principal (Main)

```java
public class Main {
    public static void main(String[] args) {
        // Criando objeto
        Caneta c1 = new Caneta();

        // ✅ Usando SETTERS (modificação segura)
        c1.setModelo("BIC Cristal");
        c1.setPonta(0.5f);

        // ✅ Usando GETTERS (consulta segura)
        System.out.println("Modelo: " + c1.getModelo());
        System.out.println("Ponta: " + c1.getPonta());

        // ❌ Acesso direto a atributo privado (ERRO!)
        // c1.ponta = 0.7f; // ERRO de compilação
    }
}
```

🧠 **Saída esperada:**

```
Modelo: Bic Cristal
Ponta: 0.5
```

---

## 🏗️ Método Construtor (Constructor)

O **construtor** é um método especial que é **executado automaticamente** sempre que um novo objeto é criado.

📘 *Em inglês, “constructor” vem de “construir”, ele monta o objeto inicial.*

### ⚙️ Função do Construtor

1. **Inicializa os atributos automaticamente**
2. **Define valores padrão**
3. **Pode receber parâmetros para personalização**


### Características:
- Nome **igual ao da classe**
- **Não tem tipo de retorno** (nem void)
- Pode **receber parâmetros**
- Inicializa atributos

---

### 💡 Exemplo 1 – Construtor Simples

Toda caneta criada começa **tampada** e **azul**:

```java
public Caneta() {
    this.cor = "Azul";
    this.tampar();
}
```
### 💡 Exemplo 2 – Construtor com Parâmetros

```java
public Caneta(String m, String c, float p) {
    this.setModelo(m);
    this.setCor(c);
    this.setPonta(p);
    this.tampar();
}
```

Agora podemos criar canetas diferentes com uma única linha:

```java
Caneta c1 = new Caneta("Bic", "Azul", 0.5f);
Caneta c2 = new Caneta("Faber-Castell", "Vermelha", 0.7f);
```

## 🎯 Exemplo: Completo!

### Classe Caneta - Construtor com parâmetros:

```java
public class Caneta {
    // ATRIBUTOS
    private String modelo;
    private String cor;
    private Float ponta;
    private boolean tampada;
    
    // ✅ CONSTRUTOR
    public Caneta(String m, String c, Float p) {
        this.setModelo(m);  // Usando setter
        this.setCor(c);     // Usando setter  
        this.setPonta(p);   // Usando setter
        this.tampar();      // Já começa tampada
    }
    
    // GETTERS E SETTERS
    public String getModelo() {
        return this.modelo;
    }
    
    public void setModelo(String m) {
        this.modelo = m;
    }
    
    public String getCor() {
        return this.cor;
    }
    
    public void setCor(String c) {
        this.cor = c;
    }
    
    public Float getPonta() {
        return this.ponta;
    }
    
    public void setPonta(Float p) {
        this.ponta = p;
    }
    
    public boolean getTampada() {
        return this.tampada;
    }
    
    // MÉTODOS NORMAIS
    public void tampar() {
        this.tampada = true;
    }
    
    public void destampar() {
        this.tampada = false;
    }
    
    public void status() {
        System.out.println("=== SOBRE A CANETA ===");
        System.out.println("Modelo: " + this.getModelo());
        System.out.println("Cor: " + this.getCor());
        System.out.println("Ponta: " + this.getPonta());
        System.out.println("Tampada: " + this.getTampada());
    }
}
```

### Usando o Construtor:

```java
public class Main {
    public static void main(String[] args) {
        // ✅ Criando caneta com construtor
        Caneta c1 = new Caneta("BIC", "Azul", 0.5f);
        Caneta c2 = new Caneta("Faber-Castell", "Vermelha", 1.0f);
        
        // Status automático
        c1.status();
        c2.status();
    }
}
```

**Saída:**
```
=== SOBRE A CANETA ===
Modelo: BIC
Cor: Azul
Ponta: 0.5
Tampada: true

=== SOBRE A CANETA ===
Modelo: Faber-Castell
Cor: Vermelha
Ponta: 1.0
Tampada: true
```

---
## 🧠 Resumo Final

| Tipo de Método | Nome                 | Função                     | Executado Automaticamente? |
| -------------- | -------------------- | -------------------------- | -------------------------- |
| Getter         | `getAtributo()`      | Retorna valor do atributo  | ❌                          |
| Setter         | `setAtributo(valor)` | Modifica valor do atributo | ❌                          |
| Construtor     | `Classe()`           | Inicializa o objeto        | ✅                          |

---

## 💡 Boas Práticas

### 1. **Sempre use getters/setters** para atributos privados
### 2. **Mantenha atributos privados** quando possível
### 3. **Use o construtor** para valores iniciais
### 4. **Valide dados** nos setters

```java
public void setPonta(Float p) {
    // ✅ Validação antes de modificar
    if (p > 0 && p <= 2.0) {
        this.ponta = p;
    } else {
        System.out.println("Ponta inválida!");
    }
}
```
---

## 🚀 Exercícios Práticos

### Exercício 1: Classe Carro
```java
// Crie uma classe Carro com:
// Atributos: marca, modelo, ano, velocidade (privados)
// Métodos: getters/setters, construtor, acelerar(), frear()
```

### Exercício 2: Validação em Setters
```java
// Modifique os setters para validar:
// - Ano não pode ser futuro
// - Velocidade não pode ser negativa
// - Marca não pode ser vazia
```

### Exercício 3: Classe Conta Bancária
```java
// Crie uma classe Conta com:
// Atributos: numero, saldo, titular (privados)
// Métodos: depositar(), sacar(), getSaldo()
// Regra: saldo não pode ficar negativo
```

---

> 💡 **Dica:** “Pense nos getters e setters como os seguranças do seu código.
> O getter te deixa *ver* o que há dentro; o setter te deixa *mudar*, mas só da forma certa.
> O construtor é como receber um produto novo já configurado. Essa mentalidade ajuda a criar código mais seguro e profissional!"

---



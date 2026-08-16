# 📚 Aula 11 – Polimorfismo por Sobrecarga em Java - pt

## 🎯 Objetivos da Aula

* Diferenciar **sobreposição (overriding)** vs **sobrecarga (overloading)**
* Compreender o conceito de **assinatura de métodos**
* Compreender o **polimorfismo por sobrecarga (overloading)**
* Implementar **sobrecarga de métodos** em Java na prática

---

## 🧠 Polimorfismo por Sobrecarga (Overloading)

### 📌 O que é?

A **sobrecarga** ocorre quando existem **vários métodos com o mesmo nome**, porém com **assinaturas diferentes**, dentro da **mesma classe**.

📌 Características importantes:

* Mesmo nome
* Parâmetros diferentes (tipo e/ou quantidade)
* Mesma classe
* Decisão feita **em tempo de compilação**

---

## 🔄 Comparação: Sobrecarga vs Sobrep**osição**

### 📊 Tabela Comparativa:

| Característica | **Sobrecarga (Overloading)** | **Sobrep**osição (Overriding)** |
|----------------|-----------------------------|---------------------------------|
| **Local** | Mesma classe | Classes diferentes (herança) |
| **Assinatura** | Diferente | Igual |
| **Retorno** | Pode ser diferente | Deve ser compatível |
| **Modificador** | Pode mudar | Não pode ser mais restritivo |
| **Polimorfismo** | Em tempo de compilação | Em tempo de execução |
| **Exemplo** | `reagir(String)`, `reagir(int)` | `emitirSom()` em diferentes animais |


---
## 🐶 Implementação: Classe Cachorro com Sobrecarga

Um cachorro pode **reagir de várias formas**, dependendo do estímulo recebido.
Cada estímulo é representado por **um conjunto diferente de parâmetros**.

👉 Implementação completa disponível em:
🔗 [https://github.com/ThayronyVonHeld/Introduction-JAVA/tree/main/src-projects/Module02/Exercicies/Lesson11](https://github.com/ThayronyVonHeld/Introduction-JAVA/tree/main/src-projects/Module02/Exercicies/Lesson8)


---

## 🧩 Estrutura das Classes

### 🧬 Classe Abstrata `Animal`

```java
public abstract class Animal {
    protected float peso;
    protected int idade;
    protected int membros;

    public abstract void emitirSom();
}
```

---

### 🐺 Classe `Lobo`

```java
public class Lobo extends Mamifero {
    @Override
    public void emitirSom() {
        System.out.println("Auuuuuu!");
    }
}
```

---

### 🐕 Classe `Cachorro`

Além de sobrescrever `emitirSom()`, o cachorro implementa **sobrecarga** com o método `reagir()`.

---

## 🔁 Sobrecargas do Método `reagir()`

### 🗣️ Reagir a uma frase

```java
public void reagir(String frase) {
    if (frase.equals("toma comida") || frase.equals("olá")) {
        System.out.println("Abanar o rabo");
    } else {
        System.out.println("Rosnar");
    }
}
```

---

### ⏰ Reagir ao horário

```java
public void reagir(int hora, int min) {
    if (hora < 12) {
        System.out.println("Abanar o rabo");
    } else if (hora >= 18) {
        System.out.println("Ignorar");
    } else {
        System.out.println("Abanar e latir");
    }
}
```

---

### 👤 Reagir se é o dono

```java
public void reagir(boolean dono) {
    if (dono) {
        System.out.println("Abanar o rabo");
    } else {
        System.out.println("Latir agressivamente");
    }
}
```

---

### 📏 Reagir pela idade e peso

```java
public void reagir(int idade, float peso) {
    if (idade < 5) {
        if (peso < 10) {
            System.out.println("Abanar o rabo");
        } else {
            System.out.println("Latir");
        }
    } else {
        if (peso < 10) {
            System.out.println("Rosnar");
        } else {
            System.out.println("Ignorar");
        }
    }
}
```

➡️ **Mesmo método (`reagir`)**, múltiplas assinaturas, múltiplos comportamentos.

---
## ▶️ Sobrecarga em Ação (Programa Principal)

```java
Cachorro c = new Cachorro();

c.reagir("olá");
c.reagir(11, 30);
c.reagir(true);
c.reagir(3, 9.5f);
```

### 📌 O que o Java faz?

* Analisa os **parâmetros passados**
* Identifica automaticamente **qual versão do método chamar**
* Escolha feita **em tempo de compilação**

➡️ Isso é **polimorfismo por sobrecarga**.

---

## ⚡ Benefícios da Sobrecarga

* **Interface Consistente**
* **Flexibilidade para o Usuário**
* **Reutilização de Código**

---

## 🚫 Regra Muito Importante

❌ **Não é permitido** criar dois métodos com a **mesma assinatura**, mesmo que:

* O nome das variáveis seja diferente
* O tipo de retorno seja diferente

```java
public void reagir(int a, int b) { }
public int reagir(int x, int y) { } // ❌ ERRO
```

➡️ Assinatura duplicada → erro de compilação.

---

## 🍔 Analogia Final: Atendente de Lanchonete

Imagine um atendente:

* Você pede **“água”** → recebe água
* Você pede **“água com gás”** → recebe outra
* Você pede **“água com gelo”** → recebe outra ainda

➡️ O pedido base é o mesmo (**método**),
➡️ Mas os detalhes do pedido (**parâmetros**) mudam o resultado.

```java
class Atendente {
    // MESMO "servir", PARÂMETROS diferentes!
    public void servir(String pedido) {
        if (pedido.equals("água")) {
            System.out.println("Entrega garrafa de água 💧");
        }
    }
    
    public void servir(String pedido, boolean comGas) {
        if (comGas) {
            System.out.println("Entrega água com gás 💦");
        } else {
            servir(pedido);  // Reutiliza o método anterior!
        }
    }
    
    public void servir(String pedido, boolean gelo, boolean limao) {
        System.out.println("Entrega água com gelo" + 
                          (limao ? " e limão" : "") + " 🍋");
    }
    
    public void servir(String pedido, int quantidade) {
        System.out.println("Entrega " + quantidade + 
                          " garrafas de água 📦");
    }
}

// Uso:
Atendente a = new Atendente();
a.servir("água");           // Garrafa de água
a.servir("água", true);     // Água com gás
a.servir("água", true, true); // Água com gelo e limão
a.servir("água", 6);        // 6 garrafas
```

**Mesmo comando** ("servir água"), **resultados diferentes** baseados nos parâmetros!

---

## 🚨 Regras e Restrições Importantes

### ❌ **O que NÃO é sobrecarga válida**:

```java
class Exemplo {
    // 1. MESMA assinatura, tipo de retorno diferente → ERRO!
    public void metodo(int x) { }
    // public int metodo(int y) { return y; }  // ERRO DE COMPILAÇÃO!
    
    // 2. MESMA assinatura, nome do parâmetro diferente → ERRO!
    public void teste(int valor) { }
    // public void teste(int numero) { }  // ERRO!
    
    // 3. MESMA assinatura, modificador diferente → PODE ser sobrecarga?
    private void acao(int x) { }
    public void acao(int y) { }  // ERRO! Mesma assinatura
}
```

### ✅ **O que É sobrecarga válida**:

```java
class Valido {
    // Diferentes quantidades de parâmetros
    public void metodo() { }
    public void metodo(int x) { }
    public void metodo(int x, int y) { }
    
    // Diferentes tipos de parâmetros
    public void metodo(String s) { }
    public void metodo(double d) { }
    
    // Ordem diferente dos tipos
    public void metodo(int x, String s) { }
    public void metodo(String s, int x) { }  // DIFERENTE!
    
    // Varargs
    public void metodo(int... numeros) { }
    public void metodo(String s, int... numeros) { }
}
```

---

## 💡 Boas Práticas com Sobrecarga

### ✅ **FAÇA**:
1. **Use nomes descritivos** para os parâmetros
2. **Documente** as diferentes versões
3. **Forneça valores padrão** quando possível
4. **Reutilize código** entre versões sobrecarregadas

### ❌ **NÃO FAÇA**:
1. Não sobrecarregue métodos com comportamentos radicalmente diferentes
2. Não crie muitas versões (mantenha simples)
3. Não ignore a compatibilidade entre versões
4. Não use sobrecarga onde herança seria mais apropriada

---

>💡 Dica: Sobrecarga é como ser um chef versátil - com as mesmas ferramentas básicas (métodos), você pode criar pratos completamente diferentes dependendo dos ingredientes (parâmetros) que usa! 👨‍🍳

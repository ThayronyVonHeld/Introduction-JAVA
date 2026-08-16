# 📚 Aula 15 - Métodos

---

## 🎯 Objetivos da Aula
- Compreender o conceito de métodos em Java
- Diferenciar entre procedimentos e funções
- Dominar a sintaxe de criação e chamada de métodos
- Entender o modificador `static` e seu uso
- Aprender a trabalhar com métodos em diferentes classes
- Conhecer os modificadores de acesso: public, private, protected

---

## 🧩 Conceito de Métodos em Java

### O que são Métodos?
Em Java, **não existe uma palavra reservada específica** para *funções* ou *procedimentos*, como em outras linguagens.
Em Java, **tudo é chamado de método**.

A diferença entre uma função e um procedimento está no **tipo de retorno**:

* Se o método **retorna um valor**, ele é uma **função**.
* Se **não retorna valor**, ele é um **procedimento**, e usamos a palavra **`void`**.

### 💭 Por que usar métodos?

- Evitam repetição de código
- Facilitam a leitura e manutenção
- Permitem dividir o problema em partes menores
- Tornam o programa mais organizado e profissional

---

## 🔹 Revisando com Algoritmo

Em pseudocódigo, um **procedimento** seria algo assim:

```text
procedimento Soma(A, B: Inteiro)
var
    S: Inteiro
inicio
    S <- A + B
    Escreva(S)
fimProcedimento
```

Chamando o procedimento:
```text
Soma(5, 2)
```

Nesse caso, **o procedimento não retorna valor**, apenas executa uma ação.

---
## 💻 Traduzindo para Java

Em Java, o mesmo procedimento ficaria assim:

```java
void soma(int a, int b) {
    int s = a + b;
    System.out.print(s);
}

soma(5, 2); // chama o procedimento
```

---
## 🎯 Exemplo prático

```java
public class TesteProcedimento {

    void soma(int a, int b) {
        int s = a + b;
        System.out.println("A soma é: " + s);
    }

    public static void main(String[] args) {
        soma(5, 2);
    }
}
```

⚠️ Esse código gera **erro**, pois o método `soma` **não é estático**, enquanto o `main` **é**.
Um método `static` pertence à **classe**, e não a uma **instância (objeto)**.

### Em resumo: O que é `static`?
- **Método estático** → Pertence à **classe**, não às instâncias
- **Método não-estático** → Pertence às **instâncias** (objetos) da classe

---

## ⚡ Corrigindo com `static`

```java
public class TesteProcedimento {

    static void soma(int a, int b) { // adicionamos 'static'
        int s = a + b;
        System.out.println("A soma é: " + s);
    }

    public static void main(String[] args) {
        soma(5, 2);
    }
}
```

Quando colocamos `static`, o método passa a ser acessível **sem precisar criar um objeto da classe**.

> 💡 O método `main` sempre é executado primeiro — ele é o ponto de entrada do programa.

---

## 🔹 Agora, as Funções!

Em pseudocódigo:

```text
funcao Soma(A, B: Inteiro): Inteiro
var
    S: Inteiro
inicio
    S <- A + B
    retorne S
fimFuncao

sm <- Soma(5, 2) // Chama a função
```

Aqui temos um **retorno** (`retorne S`) e o tipo de retorno é `Inteiro`.

---

## 🔹 Traduzindo para Java

```java
int soma(int a, int b) {
    int s = a + b;
    return s;
}

int sm = soma(5, 2);
```

A diferença é simples:

* Se usa `void` → não há retorno.
* Se usa um tipo (`int`, `String`, `double`, etc.) → há retorno.

---

## 🔹 Exemplo prático

```java
public class TesteFuncao {

    static int soma(int a, int b) {
        int s = a + b;
        return s;
    }

    public static void main(String[] args) {
        int sm = soma(5, 2);
        System.out.println("A soma vale: " + sm);
    }
}
```

O `static` ainda é necessário porque estamos chamando a função dentro do `main`, que também é `static`.

> 🔸 Em outros contextos, o `static` pode não ser necessário, dependendo da estrutura do programa.

### Exemplo de método não-estático
```java
public class ExemploInstancia {
void saudacao(String nome) {
System.out.println("Olá, " + nome + "!");
}

    public static void main(String[] args) {
        ExemploInstancia exemplo = new ExemploInstancia(); // criando objeto
        exemplo.saudacao("Thayrony");
    }
}
```
>💡 Métodos não estáticos exigem a criação de um objeto para serem usados.

---

## 🔄 Entendendo o Método `main`

### Análise do Método Principal:
```java
public static void main(String[] args) {
    // código
}
```

- **`public`** → Método acessível de qualquer lugar
- **`static`** → Pertence à classe, não precisa de instância
- **`void`** → Não retorna valor
- **`String[] args`** → Parâmetro: vetor de Strings para argumentos

Ou seja, o método `main` é o ponto de partida do programa.

---

## 🏪 Trabalhando com Métodos em Outras Classes

Podemos criar um método em uma classe separada e chamá-lo em outra.

### Classe `Operacoes.java`

```java
package JavaBasic.Lesson15.TestandoClasses;

public class Operacoes {
    public static String contador(int i, int f) {
        String s = "";
        for (int c = i; c <= f; c++) {
            s += c + " ";
        }
        return s;
    }
}
```

### Classe `TesteFuncao.java`

```java
package JavaBasic.Lesson15.TestandoClasses;

import ex31_classTesting.Operacoes;

public class TesteFuncao {
    public static void main(String[] args) {
        System.out.println("Vai começar a contagem...");
        System.out.println(Operacoes.contador(1, 5));
    }
}
```

Repare que usamos:

```java
Operacoes.contador(1, 5);
```

Ou seja, **nome da classe + ponto + nome do método**.

### 🔍 Saída Esperada:
```
Vai começar a contagem:
1 2 3 4 5 
```

---

## 🔒 Modificadores de Acesso

### Tabela de Modificadores:

| Modificador | Acesso | Descrição |
|-------------|---------|-----------|
| **`public`** | Público | Acessível de qualquer lugar |
| **`private`** | Privado | Acessível apenas na própria classe |
| **`protected`** | Protegido | Acessível na classe e subclasses |
| **(default)** | Pacote | Acessível apenas no mesmo pacote |

---

### Exemplo com Diferentes Modificadores:
```java
public class ExemploModificadores {
    public static void metodoPublico() {
        System.out.println("Método público - qualquer um pode acessar");
    }
    
    private static void metodoPrivado() {
        System.out.println("Método privado - só acessível nesta classe");
    }
    
    protected static void metodoProtegido() {
        System.out.println("Método protegido - acessível por herança");
    }
    
    static void metodoPadrao() {
        System.out.println("Método padrão - acessível no mesmo pacote");
    }
}
```

---

## 📋 Resumo da Sintaxe

### Estrutura Completa:
```java
[public|private|protected] [static] [final] [synchronized] 
tipo_retorno nomeMetodo(tipo param1, tipo param2, ...) {
    // corpo do método
    
    if (tipo_retorno != void) {
        return valor;
    }
}
```

### Partes do Método:
1. **Modificadores de acesso** → `public`, `private`, `protected`
2. **Modificador static** → `static` (opcional)
3. **Tipo de retorno** → `void`, `int`, `String`, etc.
4. **Nome do método** → identificador
5. **Parâmetros** → entre parênteses
6. **Corpo** → entre chaves
7. **Return** → se não for `void`

---

## 🚀 Exercícios Práticos

### Exercício 1: Conversor de Temperatura
```java
// Crie métodos para converter Celsius ↔ Fahrenheit
```

### Exercício 2: Validador de Dados
```java
// Crie métodos para validar email, CPF, idade, etc.
```

### Exercício 3: Calculadora Geométrica
```java
// Crie métodos para calcular área, perímetro, volume
```

### Exercício 4: Gerador de Relatórios
```java
// Crie métodos para gerar diferentes tipos de relatórios
```

---

## ✅ Checklist de Aprendizagem

- [ ] Compreendo o conceito de métodos em Java
- [ ] Sei diferenciar procedimentos (void) de funções (com retorno)
- [ ] Domino a sintaxe de criação e chamada de métodos
- [ ] Entendo o uso do modificador `static`
- [ ] Consigo criar métodos em classes separadas
- [ ] Conheço e aplico modificadores de acesso
- [ ] Sei trabalhar com parâmetros e valores de retorno
- [ ] Criei programas organizados com métodos

**Parabéns por completar o curso de fundamentos de Java! 🎊**

---

> 💡 **Dica Final**: Um bom programador não escreve mais código, escreve o melhor código. Organize, nomeie bem e reutilize seus métodos.
Cada pequeno método que você cria é um passo a mais rumo à programação profissional.

---
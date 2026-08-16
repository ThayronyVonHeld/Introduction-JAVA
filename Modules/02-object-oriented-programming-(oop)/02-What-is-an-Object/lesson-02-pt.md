# 📚 Aula 2 - O que é um Objeto?

---

## 🎯 Objetivos da Aula
- Compreender o conceito de objetos na Programação Orientada a Objetos
- Diferenciar entre objetos concretos e abstratos
- Identificar atributos, métodos e estados de objetos
- Entender a relação entre classes e objetos
- Aplicar o conceito de abstração na modelagem de objetos

---

## 🧐 O que é um Objeto?

Faça essa pergunta para si mesmo: **o que é um objeto?**    
Olhe ao seu redor e tente identificar quantos objetos você consegue ver.

Por exemplo: um **celular**, um **carro**, um **mouse** ou um **joystick**.
Todos esses são **objetos** coisas que conseguimos **ver, tocar, usar e descrever**.

Mas e se eu te perguntar:

* O **horário no dentista** é um objeto?
* O **compromisso que você agendou**?
* E um **botão na tela do seu celular**?

A maioria das pessoas responderia que **só os quatro primeiros** (celular, carro, joystick e mouse) são objetos.    
Mas será que os outros **não podem ser considerados objetos também**?


### 📘 Definição Formal de Objeto:
De acordo com a definição clássica de Programação Orientada a Objetos:

> **"Um objeto é uma coisa material ou abstrata que pode ser percebida pelos sentidos e descrita por meio de suas características, comportamentos e estado atual."**

Ou seja, um objeto pode ser algo **concreto** (como uma caneta) ou **abstrato** (como um compromisso).
O importante é que ele tenha:

* **Características**
* **Comportamentos**
* **Estado**
---
## ✏️ Exemplo 1 – Controle remoto

**Controle remoto** é um excelente exemplo de objeto:

* **Características** → tem botões, é da marca "x", modelo "RM".
* **Comportamentos** → ligar, gravar, pausar, desligar.
* **Estado** → desligado, novo, sem bateria ou procurando uma rede.

Tudo o que tiver **características, comportamentos e estado**, é um **objeto**.


### Exemplo Prático - Controle Remoto:
```java
// CARACTERÍSTICAS (O que tem?)
String marca = "X";
String modelo = "RM";
int quantidadeBotoes = 2;

// COMPORTAMENTOS (O que faz?)
void ligar() { /* código */ }
void gravar() { /* código */ }
void pausar() { /* código */ }

// ESTADO (Como está agora?)
boolean ligado = false;
int nivelBateria = 75;
boolean conectado = true;
```

---
## 📅 Exemplo 2 – Compromisso

Agora pense no seu **compromisso marcado no dentista**.

* **Características** → data e hora, local, tipo (consulta, revisão, etc).
* **Comportamentos** → marcar, remarcar, cancelar.
* **Estado** → agendado, cancelado ou concluído.

Mesmo sendo **abstrato**, ele também possui essas três dimensões — logo, também é um **objeto**.

---
## ✨ Os Três Pilares de Todo Objeto

### 1. **O que eu tenho?** → **Atributos**
- Características físicas ou descritivas
- Propriedades que definem o objeto

### 2. **O que eu faço?** → **Métodos**
- Ações que o objeto pode realizar
- Comportamentos e funcionalidades

### 3. **Como estou agora?** → **Estado**
- Situação atual do objeto
- Valores específicos em um momento

---

## 🖊️ Exemplo Detalhado: Caneta

### 🧠 A Classe Caneta

Antes de criar uma caneta, precisamos do **molde**.
Na fábrica, esse molde é projetado com base nas **características** do produto final.

Na programação, fazemos o mesmo, criamos uma **classe Caneta**.

### 🏭 Classe vs Objeto

#### Analogia da Fábrica:
| Conceito | Analogia | Definição |
|----------|----------|-----------|
| **Classe** | **Molde** da caneta | Projeto, planejamento, definição |
| **Objeto** | **Caneta** específica | Instância concreta criada a partir da classe |

### Estrutura básica:

```algoritmo
classe Caneta
    // Atributos
    modelo : caractere
    cor : caractere
    ponta : real
    carga : inteiro
    tampada : lógico

    // Métodos
    método rabiscar()
    fim do método

    método tampar()
    fim do método
fim da classe
```

---

## 🧩 Métodos em ação

Dentro dos métodos, colocamos o comportamento da caneta.

### Exemplo – Método `rabiscar()`

```algoritmo
se tampada = verdadeiro então
    escreva("Erro: Caneta tampada")
senão
    escreva("Rabiscando...")
fim se
```

### Exemplo – Método `tampar()`

```algoritmo
tampada = verdadeiro
```

Os **métodos** podem modificar os **atributos** da classe.
Isso é o que torna os objetos **dinâmicos**.

---

## 🧪 Criando um objeto (instanciando)

O computador **não sabe o que é uma caneta**, você precisa ensiná-lo.

Para isso, criamos uma **classe** (molde) e depois **instanciamos** um objeto:

```algoritmo
C1 = nova Caneta
```

Agora temos uma caneta chamada `C1`.

Podemos configurar seus atributos:

```algoritmo
C1.cor = "Azul"
C1.ponta = 0.5
C1.tampada = falso
```

E usar seus métodos:

```algoritmo
C1.rabiscar()
```

Podemos também criar outro objeto:

```algoritmo
C2 = nova Caneta
C2.cor = "Vermelha"
C2.ponta = 1.0
C2.tampar()
```

Agora temos **duas canetas diferentes** (dois objetos), criadas a partir da **mesma classe**.

---
### Análise em Java:

#### **ATRIBUTOS** (O que a caneta tem?)
```java
String modelo;
String cor; 
double ponta;    // 0.5, 0.7, 1.0
int carga;       // porcentagem
boolean tampada;
```

#### **MÉTODOS** (O que a caneta faz?)
```java
void rabiscar() { /* código */ }
void tampar() { /* código */ }
void destampar() { /* código */ }
boolean podeEscrever() { /* código */ }
```

#### **ESTADO** (Como está agora?)
```java
modelo = "Bic Cristal";
cor = "Azul";
ponta = 0.5;
carga = 90;
tampada = false;  // ↴ ESTADO ATUAL: Destampada, com 90% de carga, escrevendo
```

---

### 📝 Exemplo em Código:

#### **CLASSE** (Molde)
```java
public class Caneta {
    // ATRIBUTOS
    String modelo;
    String cor;
    double ponta;
    int carga;
    boolean tampada;
    
    // MÉTODOS
    void rabiscar() {
        if (tampada) {
            System.out.println("Erro! Caneta tampada");
        } else {
            System.out.println("Rabiscando...");
        }
    }
    
    void tampar() {
        tampada = true;
    }
}
```

#### **OBJETOS** (Instâncias)
```java
// Criando objetos a partir da classe
Caneta c1 = new Caneta();  // ↴ INSTANCIAÇÃO
Caneta c2 = new Caneta();

// Configurando objetos diferentes
c1.cor = "Azul";
c1.ponta = 0.5;
c1.tampada = false;

c2.cor = "Vermelha"; 
c2.ponta = 1.0;
c2.tampada = true;
```

---

## 🔄 Instanciamento

### O que é Instanciar?
> **Instanciar** é o processo de criar um objeto específico a partir de uma classe.

### Sintaxe:
```java
// nomeObjeto = new Classe();
Caneta minhaCaneta = new Caneta();
ControleRemoto meuControle = new ControleRemoto();
Aluno aluno1 = new Aluno();
```

### 📌 Pontos Importantes:
- Uma **classe** pode gerar **múltiplos objetos**
- Cada objeto tem **seus próprios valores** nos atributos
- Objetos da mesma classe são **independentes**

---

## 🧱 Classe × Objeto × Instância

| Termo          | Definição                                       |
| -------------- | ----------------------------------------------- |
| **Classe**     | Molde que define atributos e métodos.           |
| **Objeto**     | Instância (exemplar) criada a partir da classe. |
| **Instanciar** | Ação de gerar um objeto a partir de uma classe. |

Exemplo:

> “Classe Caneta” é o molde,
> “C1” e “C2” são objetos (instâncias) dessa classe.


---

## 🧠 Abstração: O Primeiro Pilar da POO

### O que é Abstração?
Você é uma pessoa. Eu também sou.
Somos objetos da **classe Pessoa**.

Temos os mesmos **atributos** (nome, idade, peso...), mas **estados diferentes**.

A **abstração** serve para **focar apenas nos atributos relevantes** para o contexto.

### Conceito de abstração:
> **Focar apenas nos aspectos relevantes** de um objeto para um determinado contexto, **ignorando detalhes desnecessários**.

* Em um **cadastro de aluno**, a cor dos olhos é irrelevante.
* Em um **cadastro de modelo**, é essencial.

👉 Abstração é **ignorar o que não importa** para o problema e **manter o que importa**.

### Exemplos de Abstração:

#### Contexto: Cadastro de Aluno
```java
public class Aluno {
    // ATRIBUTOS RELEVANTES
    String nome;
    String matricula;
    String curso;
    
    // IGNORADOS (não relevantes neste contexto)
    // - Cor dos olhos
    // - Peso
    // - Altura
    // - Time de futebol preferido
}
```

#### Contexto: Cadastro de Modelo
```java
public class Modelo {
    // ATRIBUTOS RELEVANTES  
    double altura;
    double peso;
    String corOlhos;
    String corCabelo;
    
    // IGNORADOS (não relevantes neste contexto)
    // - Matrícula
    // - Curso
    // - Notas
}
```

---

## 🎯 Aplicação Prática: Modelando Objetos

### Exemplo 1: Objeto Concreto - Cadeira
```java
public class Cadeira {
    // ATRIBUTOS
    String cor;
    String material;
    boolean temBraco;
    double pesoMaximo;
    
    // MÉTODOS
    void sentar() {
        System.out.println("Alguém sentou na cadeira");
    }
    
    void empilhar() {
        System.out.println("Cadeira empilhada");
    }
    
    // ESTADO ATUAL
    boolean ocupada = false;
    boolean empilhada = false;
    String orientacao = "frente";
}
```

### Exemplo 2: Objeto Abstrato - Compromisso
```java
public class Compromisso {
    // ATRIBUTOS
    Date data;
    String horario;
    String local;
    String descricao;
    
    // MÉTODOS  
    void marcar() {
        System.out.println("Compromisso marcado");
    }
    
    void cancelar() {
        System.out.println("Compromisso cancelado");
    }
    
    void adiar() {
        System.out.println("Compromisso adiado");
    }
    
    // ESTADO ATUAL
    String status = "agendado"; // agendado, cancelado, realizado
}
```

---

## 📋 Tabela de Comparação: Classe vs Objeto

| Aspecto | Classe | Objeto |
|---------|--------|--------|
| **Natureza** | Abstrata | Concreta |
| **Definição** | Molde, projeto | Instância, exemplar |
| **Tempo** | Existe durante o design | Existe durante a execução |
| **Quantidade** | Uma por conceito | Múltiplos por classe |
| **Analogia** | Projeto da casa | Casa construída |

---

## 🎮 Atividade Prática

### 🔍 Exercício 1: Objetos Concretos
**Escolha DOIS objetos concretos ao seu redor e analise:**

#### Objeto: [Seu Objeto Aqui]
- **Atributos**:
- **Métodos**:
- **Estado Atual**:

#### Objeto: [Seu Objeto Aqui]
- **Atributos**:
- **Métodos**:
- **Estado Atual**:

### 💭 Exercício 2: Objetos Abstratos
**Escolha DOIS objetos abstratos do seu dia a dia:**

#### Objeto: [Exemplo: Aula]
- **Atributos**: horário, disciplina, professor, alunos
- **Métodos**: iniciar(), terminar(), adiar()
- **Estado Atual**: "aguardando início"

#### Objeto: [Seu Objeto Abstrato]
- **Atributos**:
- **Métodos**:
- **Estado Atual**:

---

> 💡 **Dica**: "Pratique identificando objetos no seu dia a dia. Pergunte sempre: 'O que ele tem? O que ele faz? Como está agora?' Essa mentalidade é fundamental para se tornar um bom programador orientado a objetos. A abstração é sua aliada - foque no que é importante para o problema que você está resolvendo!"

**Continue observando o mundo através das lentes da POO! 👓**

---
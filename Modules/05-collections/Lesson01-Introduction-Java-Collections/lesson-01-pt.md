# 📚 Aula 01 - Introdução ao Java Collections Framework (JCF)

---

# 🎯 Objetivos da Aula

* Compreender o que é o **Java Collections Framework (JCF)**
* Conhecer as principais interfaces do framework
* Entender quando utilizar cada estrutura de dados
* Conhecer a classe utilitária `Collections`

---

# 🧠 O que é o Java Collections Framework?

O **Java Collections Framework (JCF)** é um conjunto de **interfaces**, **implementações** e **algoritmos** que fornece estruturas de dados prontas para armazenar e manipular grupos de objetos.

Em vez de implementar listas, filas ou conjuntos manualmente, o Java disponibiliza estruturas eficientes, reutilizáveis e padronizadas.

Essas estruturas permitem realizar operações comuns, como:

* ➕ Adicionar elementos
* ❌ Remover elementos
* 🔍 Pesquisar informações
* 📊 Ordenar dados
* 🔄 Percorrer coleções
* 🚫 Evitar duplicações

---

## 💡 Sem Collections

```java
String aluno1 = "João";
String aluno2 = "Maria";
String aluno3 = "Carlos";
String aluno4 = "Pedro";
```

Imagine armazenar centenas ou milhares de objetos dessa forma.

---

## ✅ Com Collections

```java
List<String> alunos = new ArrayList<>();

alunos.add("João");
alunos.add("Maria");
alunos.add("Carlos");
alunos.add("Pedro");
```

As coleções tornam o código mais organizado, flexível e escalável.

---

# 🏗 Estrutura do Collections Framework

```text
                 Collection
                     │
     ┌───────────────┼───────────────┐
     │               │               │
    List            Set            Queue
     │               │               │
 ┌───┴────┐     ┌────┴────┐      ┌────┴─────┐
 │        │     │         │      │          │
ArrayList LinkedList HashSet TreeSet PriorityQueue
```

> ℹ️ A interface **`Map`** também faz parte do Java Collections Framework, porém **não herda da interface `Collection`**.

```text
Map
 │
 ├── HashMap
 ├── LinkedHashMap
 └── TreeMap
```

---

# 📚 Principais Interfaces

| Interface | Finalidade                     | Permite duplicados? | Mantém ordem?                      |
| --------- | ------------------------------ | ------------------- | ---------------------------------- |
| `List`    | Lista ordenada                 | ✅ Sim               | ✅ Sim                              |
| `Set`     | Conjunto de elementos únicos   | ❌ Não               | Depende da implementação           |
| `Queue`   | Estrutura de fila              | ✅ Sim               | FIFO na maioria das implementações |
| `Map`     | Associação entre chave e valor | Chaves únicas       | Depende da implementação           |

---

# 📋 List

A interface **List** representa uma sequência ordenada de elementos.

### Características

* Mantém a ordem de inserção
* Permite elementos duplicados
* Permite acesso por índice

```java
List<String> nomes = new ArrayList<>();

nomes.add("Lucas");
nomes.add("Maria");
nomes.add("Lucas");

System.out.println(nomes);
```

**Saída**

```
[Lucas, Maria, Lucas]
```

---

# 🎯 Set

A interface **Set** representa um conjunto de elementos únicos.

### Características

* Não permite duplicados
* Não possui índice
* A ordem depende da implementação utilizada

```java
Set<String> nomes = new HashSet<>();

nomes.add("Lucas");
nomes.add("Maria");
nomes.add("Lucas");

System.out.println(nomes);
```

**Saída**

```
[Lucas, Maria]
```

> 💡 A verificação de elementos duplicados utiliza os métodos `equals()` e `hashCode()`, que serão estudados nas próximas aulas.

---

# 🚶 Queue

A interface **Queue** representa uma fila.

Na maioria das implementações, segue a política **FIFO (First In, First Out)**.

Ou seja, o primeiro elemento inserido será o primeiro a ser removido.

```java
Queue<String> fila = new LinkedList<>();

fila.add("Cliente 1");
fila.add("Cliente 2");
fila.add("Cliente 3");

System.out.println(fila.poll());
```

**Saída**

```
Cliente 1
```

---

# 🗂 Map

A interface **Map** armazena pares de **chave → valor**.

Cada chave é única e está associada a apenas um valor.

```java
Map<Integer, String> alunos = new HashMap<>();

alunos.put(1, "João");
alunos.put(2, "Maria");
alunos.put(3, "Carlos");
```

Representação:

```
1 → João
2 → Maria
3 → Carlos
```

---

# 🛠 Classe `Collections`

Além das estruturas de dados, o framework fornece a classe utilitária `Collections`, que disponibiliza diversos algoritmos prontos para manipulação de coleções.

| Método           | Descrição                     |
| ---------------- | ----------------------------- |
| `sort()`         | Ordena uma lista              |
| `reverse()`      | Inverte a ordem dos elementos |
| `shuffle()`      | Embaralha os elementos        |
| `binarySearch()` | Realiza busca binária         |
| `max()`          | Retorna o maior elemento      |
| `min()`          | Retorna o menor elemento      |

### Exemplo

```java
List<Integer> numeros = new ArrayList<>();

numeros.add(8);
numeros.add(2);
numeros.add(5);

Collections.sort(numeros);

System.out.println(numeros);
```

**Saída**

```
[2, 5, 8]
```

---

# 📌 Resumo

| Estrutura | Melhor utilização                                   |
| --------- | --------------------------------------------------- |
| `List`    | Quando a ordem importa e elementos podem se repetir |
| `Set`     | Quando não podem existir elementos duplicados       |
| `Queue`   | Processamento em ordem de chegada (FIFO)            |
| `Map`     | Associação entre chaves e valores                   |

---

# 🎓 Dicas Importantes

* ✅ O **Java Collections Framework** é uma das APIs mais utilizadas no desenvolvimento Java.
* ✅ Cada interface foi criada para resolver um tipo específico de problema.
* ✅ Escolher a estrutura correta melhora a organização, o desempenho e a legibilidade do código.
* ✅ A interface `Map` pertence ao framework, mas **não herda de `Collection`**.
* ✅ Nas próximas aulas veremos como os métodos **`equals()`** e **`hashCode()`** influenciam diretamente o funcionamento de coleções como `HashSet` e `HashMap`.

---

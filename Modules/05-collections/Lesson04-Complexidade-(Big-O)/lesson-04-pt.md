# 📚 Aula 04 - Organização das Collections e Introdução à Complexidade (Big-O)

---

# 🎯 Objetivos da Aula

* Compreender como as coleções podem organizar seus elementos
* Entender a importância da escolha da estrutura de dados
* Conhecer o conceito de Complexidade Big-O
* Comparar o desempenho de algumas coleções
* Diferenciar `Collection` de `Collections`

---

# 🧠 Como as Collections organizam os dados?

As coleções do Java podem organizar seus elementos de maneiras diferentes, dependendo da implementação utilizada.

De forma geral, podemos classificá-las em dois grupos.

## 📋 Coleções Ordenadas

Mantêm uma ordem conhecida para os elementos.

Na maioria dos casos, essa ordem corresponde à ordem de inserção.

Exemplo:

```text
João
Maria
Carlos
Pedro
```

Os elementos permanecem na sequência em que foram adicionados.

Estruturas como `ArrayList` e `LinkedList` seguem esse comportamento.

---

## 🔤 Coleções Classificadas (Ordenadas Automaticamente)

Algumas coleções reorganizam automaticamente seus elementos seguindo uma regra de ordenação.

Exemplo:

```text
Carlos
João
Maria
Pedro
```

Mesmo que os nomes tenham sido inseridos em outra ordem, a coleção os reorganiza automaticamente.

Um exemplo é o `TreeSet`, que mantém seus elementos ordenados naturalmente (ou através de um comparador).

---

# 🏗 Estrutura do Java Collections Framework

O Java Collections Framework foi construído utilizando fortemente o conceito de **interfaces**, permitindo que diferentes implementações compartilhem o mesmo comportamento.

```text
Collection
    │
 ┌──┴──────┐
 │         │
List      Set
```

Cada implementação possui um objetivo específico.

Por exemplo:

* `ArrayList`
* `LinkedList`
* `HashSet`
* `TreeSet`

Todas seguem os contratos definidos pelas interfaces.

---

# 📌 E o `Map`?

Apesar de fazer parte do Java Collections Framework, o `Map` possui sua própria hierarquia.

Ele **não implementa** a interface `Collection`.

```text
Collection

List
Set

Map
```

Isso acontece porque o `Map` trabalha com pares **chave → valor**, enquanto as coleções tradicionais armazenam apenas elementos.

---

# ⚡ O que é Complexidade Big-O?

A **Complexidade Big-O** é uma forma de estimar o custo de uma operação conforme a quantidade de dados aumenta.

Ela permite responder perguntas como:

* Essa busca continuará rápida quando houver um milhão de elementos?
* Inserir novos objetos continuará eficiente?
* Remover elementos ficará mais lento conforme a coleção cresce?

---

# 🚀 Complexidade O(1)

Representa uma operação de tempo constante.

O tempo gasto praticamente não muda, independentemente da quantidade de elementos.

```text
10 elementos  → rápido

1.000 elementos → rápido

1.000.000 elementos → rápido
```

É considerada a melhor complexidade para operações de acesso ou busca.

---

# 🐢 Complexidade O(n)

Representa uma operação linear.

Quanto maior a quantidade de elementos, maior será o tempo necessário.

```text
10 elementos

↓

100 elementos

↓

10.000 elementos

↓

1.000.000 elementos
```

Normalmente acontece quando é necessário percorrer toda a coleção procurando um elemento.

---

# 📊 Comparando `ArrayList` e `HashSet`

Cada estrutura foi projetada para resolver problemas diferentes.

| Operação                 | `ArrayList`   | `HashSet`           |
| ------------------------ | ------------- | ------------------- |
| Acesso por índice        | ⭐ Excelente   | ❌ Não possui índice |
| Busca (`contains`)       | 🐢 Mais lenta | ⚡ Muito rápida      |
| Permite duplicados       | ✅ Sim         | ❌ Não               |
| Mantém ordem de inserção | ✅ Sim         | ❌ Não (HashSet)     |

> 💡 Não existe uma coleção "melhor". Existe apenas a coleção mais adequada para cada necessidade.

---

# 🔍 Por que o `HashSet` é mais rápido?

Quando executamos:

```java
nomes.contains("Lucas");
```

O `ArrayList` normalmente percorre seus elementos comparando um por um utilizando `equals()`.

```text
Lucas?

↓

Maria?

↓

Carlos?

↓

Pedro?
```

Já o `HashSet` utiliza o `hashCode()` para localizar rapidamente o bucket onde o objeto pode estar.

```text
hashCode()

↓

Bucket

↓

equals()
```

Por isso, operações de busca costumam ser significativamente mais rápidas.

---

# ⚠️ `Collection` x `Collections`

É comum confundir esses dois nomes.

Apesar de parecidos, representam conceitos diferentes.

| `Collection`                       | `Collections`                                                     |
| ---------------------------------- | ----------------------------------------------------------------- |
| Interface                          | Classe utilitária                                                 |
| Define comportamentos das coleções | Fornece algoritmos prontos                                        |
| É implementada por `List` e `Set`  | Possui métodos estáticos como `sort()`, `reverse()` e `shuffle()` |

---

# 📌 Resumo

| Conceito               | Descrição                                                        |
| ---------------------- | ---------------------------------------------------------------- |
| Coleções ordenadas     | Mantêm uma ordem conhecida para os elementos.                    |
| Coleções classificadas | Organizam automaticamente os elementos.                          |
| Big-O                  | Mede o custo de uma operação conforme o volume de dados aumenta. |
| `O(1)`                 | Tempo constante.                                                 |
| `O(n)`                 | Tempo cresce proporcionalmente à quantidade de elementos.        |
| `Collection`           | Interface base das coleções.                                     |
| `Collections`          | Classe utilitária com algoritmos para manipulação de coleções.   |

---

# 🎓 Dicas Importantes

* ✅ Escolha a coleção considerando as operações mais frequentes do sistema.
* ✅ Nem sempre a coleção mais rápida para busca será a melhor para inserção ou acesso por índice.
* ✅ `HashSet` utiliza os métodos `hashCode()` e `equals()` para localizar elementos com eficiência.
* ✅ `ArrayList` é excelente para acesso por índice, enquanto `HashSet` se destaca em operações de busca.
* ✅ Entender a complexidade das operações ajuda a desenvolver aplicações mais eficientes.

---

https://data-flair.training/blogs/collection-framework-in-java/
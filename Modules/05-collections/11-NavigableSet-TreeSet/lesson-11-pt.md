# 📚 Aula 11 - `NavigableSet` e `TreeSet`

---

# 🎯 Objetivos da Aula

* Compreender o funcionamento do **`TreeSet`**
* Conhecer a interface **`NavigableSet`**
* Entender como o `TreeSet` mantém os elementos ordenados
* Diferenciar `TreeSet` de `HashSet`
* Conhecer os métodos de navegação como `lower()`, `floor()`, `higher()` e `ceiling()`

---

# 🌳 `TreeSet` e `NavigableSet`

O `TreeSet` é uma implementação da interface `NavigableSet`.

Sua hierarquia é:

```text
Set
 │
 └── SortedSet
       │
       └── NavigableSet
             │
             └── TreeSet
```

Assim como qualquer `Set`, o `TreeSet` **não permite elementos duplicados**.

A grande diferença é que ele mantém os elementos **automaticamente ordenados**.

---

# 🔄 `HashSet` × `TreeSet`

| Característica             | `HashSet`  | `TreeSet` |
| -------------------------- | ---------- | --------- |
| Duplicados                 | ❌ Não      | ❌ Não     |
| Mantém ordem de inserção   | ❌ Não      | ❌ Não     |
| Mantém elementos ordenados | ❌ Não      | ✅ Sim     |
| Utiliza `hashCode()`       | ✅ Sim      | ❌ Não     |
| Utiliza comparação         | ❌          | ✅         |
| Busca/inserção             | O(1) médio | O(log n)  |

> 💡 Use `TreeSet` quando a **ordenação constante** dos elementos for importante.

---

# 📊 Ordenação Automática

```java
Set<Integer> numeros = new TreeSet<>();

numeros.add(30);
numeros.add(10);
numeros.add(20);

System.out.println(numeros);
```

Saída:

```text
[10, 20, 30]
```

Não importa a ordem em que os elementos foram adicionados: o `TreeSet` mantém a coleção ordenada.

---

# ⚖️ `Comparable` ou `Comparator`

O `TreeSet` precisa saber **como comparar os elementos**.

Existem duas possibilidades:

### 1. `Comparable`

A própria classe define sua **ordem natural**.

```java
public class Manga implements Comparable<Manga> {

    @Override
    public int compareTo(Manga outro) {
        return this.nome.compareTo(outro.nome);
    }
}
```

Depois:

```java
Set<Manga> mangas = new TreeSet<>();
```

---

### 2. `Comparator`

Quando queremos definir a ordenação externamente:

```java
Comparator<Manga> comparator =
        (m1, m2) -> m1.getPreco().compareTo(m2.getPreco());

Set<Manga> mangas = new TreeSet<>(comparator);
```

Isso permite ordenar por critérios diferentes sem modificar a classe original.

---

# ⚠️ Atenção: `TreeSet` não utiliza `equals()` para duplicatas

Essa é uma das características **mais importantes** do `TreeSet`.

Enquanto o `HashSet` utiliza:

```text
hashCode()
     ↓
equals()
```

o `TreeSet` utiliza:

```text
compareTo()
     ou
compare()
```

Se a comparação retornar:

```text
0
```

o `TreeSet` entende que os objetos são equivalentes para aquela coleção e **não adiciona o segundo**.

---

## Exemplo

Imagine dois mangás:

```text
Manga 1 → ID: 1 | Nome: Naruto
Manga 2 → ID: 2 | Nome: Naruto
```

Se o `compareTo()` considerar apenas o nome:

```java
return this.nome.compareTo(outro.nome);
```

o resultado será:

```text
0
```

Consequentemente:

```text
TreeSet → considera os dois equivalentes
```

Mesmo que o `equals()` diga que são objetos diferentes.

> ⚠️ Por isso, é importante que a lógica de comparação seja coerente com a ideia de igualdade desejada para a coleção.

---

# 🔽 `descendingSet()`

Podemos obter uma visão da coleção em **ordem inversa** utilizando:

```java
NavigableSet<Integer> numeros = new TreeSet<>();

numeros.add(10);
numeros.add(20);
numeros.add(30);

System.out.println(numeros.descendingSet());
```

Saída:

```text
[30, 20, 10]
```

---

# 🔎 Métodos de Navegação

A interface `NavigableSet` adiciona métodos que permitem encontrar elementos **próximos de determinado valor**.

| Método      | Retorna              |
| ----------- | -------------------- |
| `lower()`   | Menor que o elemento |
| `floor()`   | Menor ou igual       |
| `higher()`  | Maior que o elemento |
| `ceiling()` | Maior ou igual       |

---

## `lower()`

Retorna o maior elemento que seja **estritamente menor**.

```java
Set<Integer> numeros = new TreeSet<>(
        List.of(10, 20, 30, 40)
);

System.out.println(
        ((NavigableSet<Integer>) numeros).lower(30)
);
```

Resultado:

```text
20
```

---

## `floor()`

Retorna o maior elemento **menor ou igual**.

```java
numeros.floor(30);
```

Resultado:

```text
30
```

---

## `higher()`

Retorna o menor elemento **estritamente maior**.

```java
numeros.higher(30);
```

Resultado:

```text
40
```

---

## `ceiling()`

Retorna o menor elemento **maior ou igual**.

```java
numeros.ceiling(30);
```

Resultado:

```text
30
```

### 🧠 Forma fácil de memorizar

```text
             30
              │
       ┌──────┴──────┐
       │             │
   LOWER/FLOOR   HIGHER/CEILING
       │             │
       ▼             ▼
      menor        maior

LOWER   → < 30
FLOOR   → ≤ 30

HIGHER  → > 30
CEILING → ≥ 30
```

---

# 🗑️ Removendo elementos das extremidades

O `NavigableSet` também permite remover elementos das extremidades.

### `pollFirst()`

Retorna **e remove** o primeiro elemento:

```java
numeros.pollFirst();
```

### `pollLast()`

Retorna **e remove** o último elemento:

```java
numeros.pollLast();
```

Exemplo:

```text
[10, 20, 30, 40]

pollFirst() → 10

[20, 30, 40]
```

---

# ⚡ Performance

O `TreeSet` utiliza uma estrutura de árvore balanceada para manter os elementos organizados.

Por isso, operações como busca e inserção possuem complexidade:

```text
O(log n)
```

Isso é mais lento que a complexidade média de `HashSet`:

```text
HashSet  → O(1) médio
TreeSet  → O(log n)
```

Por outro lado, o `TreeSet` oferece algo que o `HashSet` não oferece:

> **Elementos permanentemente ordenados e operações de navegação por proximidade.**

---

# 📌 Resumo Geral

| Conceito          | Descrição                                              |
| ----------------- | ------------------------------------------------------ |
| `NavigableSet`    | Interface que adiciona recursos avançados de navegação |
| `TreeSet`         | Implementação de `NavigableSet` baseada em árvore      |
| `Comparable`      | Define a ordem natural dos objetos                     |
| `Comparator`      | Permite definir uma ordenação externa                  |
| `lower()`         | Retorna o elemento imediatamente menor                 |
| `floor()`         | Retorna o menor elemento maior ou igual                |
| `higher()`        | Retorna o elemento imediatamente maior                 |
| `ceiling()`       | Retorna o maior elemento menor ou igual                |
| `descendingSet()` | Retorna a coleção em ordem inversa                     |
| `pollFirst()`     | Remove e retorna o primeiro elemento                   |
| `pollLast()`      | Remove e retorna o último elemento                     |
| `O(log n)`        | Complexidade típica das operações do `TreeSet`         |

---

# 🎓 Dicas Importantes

* ✅ `TreeSet` **não permite duplicatas**.
* ✅ Diferentemente do `HashSet`, o `TreeSet` mantém os elementos **ordenados automaticamente**.
* ✅ O `TreeSet` utiliza `Comparable` ou `Comparator` para determinar a ordem.
* ⚠️ A decisão de considerar dois elementos "iguais" no `TreeSet` depende do resultado da comparação (`compareTo()` ou `compare()`), e não do `equals()`.
* ✅ Use `HashSet` quando a prioridade for **performance de busca** e `TreeSet` quando precisar de **ordenação e navegação**.
* 💡 `NavigableSet` é especialmente útil quando precisamos encontrar elementos próximos de determinado valor.

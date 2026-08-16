# 📚 Aula 13 — NavigableMap e TreeMap

---

# 🎯 Objetivos da Aula

* Compreender o funcionamento do **`NavigableMap`**
* Conhecer a implementação **`TreeMap`**
* Entender como o `TreeMap` mantém as **chaves ordenadas**
* Conhecer os métodos de busca por aproximação
* Entender o funcionamento de **submapas**
* Diferenciar métodos que retornam `Key` dos que retornam `Entry`

---

# 🗺️ O que é `NavigableMap`?

A interface **`NavigableMap`** é uma extensão de `SortedMap` que fornece recursos para trabalhar com mapas ordenados e realizar **buscas por proximidade**.

Sua implementação mais conhecida é:

```java
TreeMap
```

A hierarquia pode ser visualizada assim:

```text
Map
 │
 └── SortedMap
       │
       └── NavigableMap
              │
              └── TreeMap
```

Assim como o `NavigableSet`, o `NavigableMap` trabalha com elementos ordenados.

---

# 🌳 `TreeMap`

O `TreeMap` mantém suas **chaves automaticamente ordenadas**.

```java
TreeMap<String, Integer> mapa = new TreeMap<>();

mapa.put("Carlos", 20);
mapa.put("Ana", 30);
mapa.put("Bruno", 25);
```

Mesmo inserindo nessa ordem:

```text
Carlos
Ana
Bruno
```

O `TreeMap` organizará as chaves:

```text
Ana
Bruno
Carlos
```

⚠️ **A ordenação acontece pelas chaves, não pelos valores.**

---

# ⚖️ Como o `TreeMap` sabe ordenar?

Assim como acontece com o `TreeSet`, a chave precisa possuir uma forma de comparação.

Existem duas possibilidades:

### `Comparable`

A própria classe da chave implementa:

```java
Comparable<T>
```

### `Comparator`

Ou podemos fornecer um comparador ao criar o mapa:

```java
TreeMap<Consumidor, String> mapa =
        new TreeMap<>(new ConsumidorComparator());
```

Caso uma chave personalizada não possua nenhuma dessas formas de comparação, a inserção poderá gerar:

```text
ClassCastException
```

---

# 🔎 Busca por Aproximação

Uma das principais vantagens do `NavigableMap` são os métodos que permitem encontrar chaves próximas de determinado valor.

| Método         | Retorno                   |
| -------------- | ------------------------- |
| `lowerKey()`   | Chave imediatamente menor |
| `floorKey()`   | Chave menor ou igual      |
| `higherKey()`  | Chave imediatamente maior |
| `ceilingKey()` | Chave maior ou igual      |

Exemplo:

```java
TreeMap<Integer, String> mapa = new TreeMap<>();

mapa.put(10, "A");
mapa.put(20, "B");
mapa.put(30, "C");
```

Se buscarmos:

```java
mapa.lowerKey(20);
```

Resultado:

```text
10
```

Enquanto:

```java
mapa.ceilingKey(20);
```

retorna:

```text
20
```

---

# 🔑 `Key` vs. `Entry`

O `NavigableMap` oferece métodos semelhantes que retornam informações diferentes.

### Retornando apenas a chave

```java
mapa.ceilingKey(20);
```

Resultado:

```text
20
```

### Retornando chave e valor

```java
mapa.ceilingEntry(20);
```

Resultado:

```text
20 = B
```

A diferença é:

```text
Key
 ↓
somente a chave

Entry
 ↓
chave + valor
```

Os mesmos conceitos se aplicam a:

```java
lowerKey()
lowerEntry()

floorKey()
floorEntry()

higherKey()
higherEntry()

ceilingKey()
ceilingEntry()
```

---

# ✂️ `headMap()`

O método `headMap()` permite obter uma parte do mapa utilizando uma chave como limite.

```java
TreeMap<Integer, String> mapa = new TreeMap<>();

mapa.put(10, "A");
mapa.put(20, "B");
mapa.put(30, "C");
mapa.put(40, "D");
```

```java
mapa.headMap(30);
```

Resultado:

```text
10 = A
20 = B
```

Por padrão, a chave limite **não é incluída**.

Podemos alterar esse comportamento:

```java
mapa.headMap(30, true);
```

Resultado:

```text
10 = A
20 = B
30 = C
```

---

# ⚠️ Atenção: o `headMap()` é uma visão do mapa

O resultado de `headMap()` não é simplesmente uma cópia independente.

Ele permanece **vinculado ao `TreeMap` original**.

```text
TreeMap
 ├── 10
 ├── 20
 ├── 30
 └── 40
      │
      └── headMap(30)
           ├── 10
           └── 20
```

Se removermos um elemento através do `headMap`:

```java
mapa.headMap(30).remove(20);
```

O elemento também será removido do mapa original.

---

# 🧠 `TreeMap` vs. `HashMap`

Uma diferença importante:

| Característica          | `HashMap`       | `TreeMap`                           |
| ----------------------- | --------------- | ----------------------------------- |
| Ordenação               | ❌ Não garante   | ✅ Mantém ordenado                   |
| Base da organização     | Hash            | Comparação                          |
| Busca média             | `O(1)`          | `O(log n)`                          |
| `equals/hashCode`       | Fundamentais    | Não são usados para ordenar         |
| `Comparable/Comparator` | Não obrigatório | Necessário para chaves customizadas |

---

# 📌 Resumo Geral

| Conceito       | Descrição                                                    |
| -------------- | ------------------------------------------------------------ |
| `NavigableMap` | Interface para mapas ordenados com navegação por proximidade |
| `TreeMap`      | Implementação de `NavigableMap`                              |
| Chaves         | São mantidas ordenadas                                       |
| `Comparable`   | Define a ordem natural das chaves                            |
| `Comparator`   | Permite definir uma ordenação personalizada                  |
| `lower`        | Busca elemento menor                                         |
| `floor`        | Busca elemento menor ou igual                                |
| `higher`       | Busca elemento maior                                         |
| `ceiling`      | Busca elemento maior ou igual                                |
| `Key`          | Retorna somente a chave                                      |
| `Entry`        | Retorna chave e valor                                        |
| `headMap`      | Cria uma visão parcial do mapa                               |

---

# 🎓 Dicas Importantes

* ✅ O **`TreeMap` ordena pelas chaves**, nunca pelos valores.
* ✅ Chaves de classes personalizadas precisam implementar `Comparable` ou possuir um `Comparator`.
* ✅ `NavigableMap` permite buscas muito úteis por valores **menores, maiores, menores/iguais e maiores/iguais**.
* ✅ Métodos `Key` retornam somente a chave; métodos `Entry` retornam **chave + valor**.
* ⚠️ `headMap()` cria uma **visão vinculada ao mapa original**, não uma cópia independente.
* 📌 Assim como o `TreeSet`, o `TreeMap` é indicado quando a **ordenação dos dados é importante**, mesmo tendo custo maior que estruturas baseadas em hash.

---
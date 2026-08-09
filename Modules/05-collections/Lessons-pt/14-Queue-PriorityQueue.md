# 📚 Aula 14 — Queue e PriorityQueue

---

# 🎯 Objetivos da Aula

* Compreender o funcionamento da interface **`Queue`**
* Entender o conceito **FIFO**
* Conhecer a implementação **`PriorityQueue`**
* Diferenciar fila comum de fila baseada em prioridade
* Conhecer `peek()`, `poll()`, `offer()` e `add()`
* Entender o uso de `Comparable` e `Comparator` em filas de prioridade

---

# 🚶 O que é uma `Queue`?

A interface **`Queue`** representa uma estrutura de dados do tipo **fila**.

O comportamento tradicional segue a regra:

> **FIFO — First In, First Out**

Ou seja:

> **O primeiro elemento que entra é o primeiro a sair.**

Podemos imaginar uma fila de banco:

```text
Entrada
  ↓
João → Maria → Carlos
  ↓
Primeiro a ser atendido
```

Ao remover um elemento:

```text
João sai

Maria → Carlos
```

---

# 🛠 Principais métodos

Os principais métodos utilizados para trabalhar com uma `Queue` são:

| Método    | Função                                     |
| --------- | ------------------------------------------ |
| `peek()`  | Consulta o primeiro elemento sem removê-lo |
| `poll()`  | Consulta e remove o primeiro elemento      |
| `add()`   | Adiciona um elemento                       |
| `offer()` | Tenta adicionar um elemento                |

Exemplo:

```java
Queue<String> fila = new LinkedList<>();

fila.add("João");
fila.add("Maria");
fila.add("Carlos");
```

Consultando:

```java
System.out.println(fila.peek());
```

Resultado:

```text
João
```

O elemento continua na fila.

Já:

```java
System.out.println(fila.poll());
```

retorna:

```text
João
```

e remove João da fila.

---

# ⚖️ `add()` vs. `offer()`

Ambos podem ser utilizados para adicionar elementos.

A principal diferença aparece em filas com **capacidade limitada**.

### `add()`

Se não for possível adicionar o elemento, lança uma exceção.

### `offer()`

Se não for possível adicionar, simplesmente retorna:

```text
false
```

Isso permite tratar a falha sem necessariamente gerar uma exceção.

---

# ⭐ `PriorityQueue`

A **`PriorityQueue`** é uma implementação especial de `Queue`.

Enquanto uma fila tradicional segue a ordem de chegada:

```text
1 → 2 → 3 → 4
```

uma `PriorityQueue` utiliza uma **regra de prioridade**.

Por exemplo:

```text
Elemento A → prioridade 3
Elemento B → prioridade 1
Elemento C → prioridade 2
```

Ao retirar os elementos, a prioridade determina quem sai primeiro.

---

# ⚙️ Como a prioridade é definida?

A `PriorityQueue` precisa saber **como comparar os elementos**.

Existem duas possibilidades:

### `Comparable`

A própria classe define sua ordem natural:

```java
class Manga implements Comparable<Manga>
```

através do:

```java
compareTo()
```

### `Comparator`

Podemos fornecer uma regra externa:

```java
PriorityQueue<Manga> fila =
        new PriorityQueue<>(new MangaByPriceComparator());
```

Nesse caso, a fila pode priorizar os mangás pelo preço, por exemplo.

---

# ⚠️ Um detalhe importante da `PriorityQueue`

Os elementos **não precisam aparecer ordenados quando a fila inteira é impressa**.

Por exemplo:

```java
System.out.println(fila);
```

não significa necessariamente que veremos os elementos em ordem de prioridade.

A prioridade é garantida principalmente durante a **extração dos elementos**:

```java
while (!fila.isEmpty()) {
    System.out.println(fila.poll());
}
```

Nesse caso, os elementos serão retirados seguindo a prioridade definida.

---

# 🔄 `PriorityQueue` + `Comparator`

Uma das maiores vantagens da `PriorityQueue` é poder definir diferentes regras de prioridade.

Por exemplo, uma fila de mangás pode ser organizada pelo preço:

```text
R$ 10
R$ 25
R$ 50
R$ 80
```

Ou podemos inverter a prioridade para processar primeiro os maiores valores:

```java
new PriorityQueue<>(
    Collections.reverseOrder()
);
```

Isso permite adaptar a fila às **regras de negócio** da aplicação.

---

# 🗑️ `remove(Object)`

Também é possível remover um elemento específico:

```java
fila.remove(objeto);
```

Porém, isso não representa o uso principal de uma `Queue`.

A ideia de uma fila é normalmente processar os elementos pela **cabeça da fila**, utilizando:

```java
poll()
```

Remover elementos arbitrariamente pode fugir justamente do propósito estrutural da fila.

---

# 🧠 Queue vs. PriorityQueue

| Característica                 | `Queue` tradicional | `PriorityQueue`                         |
| ------------------------------ | ------------------- | --------------------------------------- |
| Regra padrão                   | FIFO                | Prioridade                              |
| Primeiro inserido sai primeiro | ✅                   | ❌ necessariamente                       |
| Ordenação por prioridade       | ❌                   | ✅                                       |
| `Comparable` necessário        | Não necessariamente | Para objetos customizados, sim          |
| `Comparator`                   | Opcional            | Pode definir a prioridade               |
| `peek()`                       | Consulta a cabeça   | Consulta o elemento de maior prioridade |
| `poll()`                       | Remove a cabeça     | Remove o elemento de maior prioridade   |

---

# 📌 Resumo Geral

| Conceito                     | Descrição                                |
| ---------------------------- | ---------------------------------------- |
| `Queue`                      | Estrutura de dados baseada em fila       |
| FIFO                         | Primeiro que entra, primeiro que sai     |
| `peek()`                     | Consulta sem remover                     |
| `poll()`                     | Consulta e remove                        |
| `add()`                      | Adiciona, podendo lançar exceção         |
| `offer()`                    | Tenta adicionar e retorna `boolean`      |
| `PriorityQueue`              | Fila baseada em prioridade               |
| `Comparable`                 | Define a ordem natural                   |
| `Comparator`                 | Define uma prioridade personalizada      |
| `Collections.reverseOrder()` | Permite inverter uma ordem de comparação |

---

# 🎓 Dicas Importantes

* ✅ `Queue` normalmente representa uma fila **FIFO**.
* ✅ `peek()` **não remove** o elemento.
* ✅ `poll()` **remove** o elemento da cabeça da fila.
* ✅ `PriorityQueue` não significa que a coleção inteira ficará visualmente ordenada.
* ✅ A prioridade é percebida principalmente quando os elementos são retirados com `poll()`.
* ✅ Objetos customizados precisam de `Comparable` ou `Comparator` para que a `PriorityQueue` saiba como priorizá-los.
* 📌 `PriorityQueue` é especialmente útil quando o sistema precisa **processar elementos de acordo com uma prioridade**, e não simplesmente pela ordem em que chegaram.

---

## 🏁 Encerramento do bloco de Collections

Com essa aula, fechamos os principais tipos do **Java Collections Framework** estudados neste ciclo:

```text
Collection
│
├── List
│   └── ArrayList
│
├── Set
│   ├── HashSet
│   ├── LinkedHashSet
│   └── TreeSet
│
└── Queue
    └── PriorityQueue

Map
├── HashMap
├── LinkedHashMap
└── TreeMap
```

E, principalmente, você passou pelos conceitos que conectam praticamente todas essas estruturas:

```text
equals()
   ↓
hashCode()
   ↓
Comparable
   ↓
Comparator
   ↓
Collections
   ↓
Escolha da estrutura adequada
```

Isso é uma base muito importante para avançar para **Generics, Streams, Lambdas e posteriormente Spring Data/JPA**, porque essas APIs trabalham constantemente com coleções e objetos.

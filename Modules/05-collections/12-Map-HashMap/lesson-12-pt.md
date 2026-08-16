# 📚 Aula 12 - `Map`, `HashMap` e `LinkedHashMap`

---

# 🎯 Objetivos da Aula

* Compreender o funcionamento da interface **`Map`**
* Entender a relação entre **chaves e valores**
* Conhecer `HashMap` e `LinkedHashMap`
* Aprender as principais formas de percorrer um `Map`
* Trabalhar com objetos personalizados como chaves e valores
* Entender estruturas **um para muitos**, como `Map<K, List<V>>`

---

# 🗺️ O que é um `Map`?

O `Map` é uma estrutura de dados baseada na associação:

```text
CHAVE → VALOR
```

Diferentemente de `List` e `Set`, o `Map` **não faz parte da hierarquia `Collection`**.

```text
Collection
 ├── List
 ├── Set
 └── Queue

Map
 ├── HashMap
 └── LinkedHashMap
```

Ao declarar um `Map`, definimos o tipo da **chave (`K`)** e do **valor (`V`)**:

```java
Map<Integer, String> alunos = new HashMap<>();
```

Nesse exemplo:

```text
Integer → chave
String  → valor
```

---

# 🔑 Chaves e Valores

A principal regra de um `Map` é:

> **Cada chave é única.**

Porém, **valores podem se repetir**.

```java
Map<Integer, String> alunos = new HashMap<>();

alunos.put(1, "João");
alunos.put(2, "Maria");
alunos.put(3, "João");
```

Temos:

```text
1 → João
2 → Maria
3 → João
```

O valor `"João"` aparece duas vezes, mas as chaves continuam sendo únicas.

---

# ➕ `put()`

O método utilizado para adicionar associações é:

```java
put(chave, valor)
```

```java
Map<Integer, String> alunos = new HashMap<>();

alunos.put(1, "João");
alunos.put(2, "Maria");
alunos.put(3, "Carlos");
```

---

# ⚠️ Chaves Duplicadas

Se utilizarmos uma chave que já existe, o valor anterior será **substituído**.

```java
alunos.put(1, "João");
alunos.put(1, "Pedro");
```

Resultado:

```text
1 → Pedro
```

O `"João"` foi substituído.

---

## 🛡️ `putIfAbsent()`

Quando queremos adicionar somente se a chave ainda não existir:

```java
alunos.putIfAbsent(1, "Pedro");
```

Se a chave `1` já existir, o valor atual será preservado.

---

# ⚡ `HashMap`

O `HashMap` é a implementação mais comum de `Map`.

```java
Map<String, Integer> estoque = new HashMap<>();
```

Suas principais características:

* 🔑 Chaves únicas
* ♻️ Valores podem se repetir
* ⚡ Utiliza hashing
* ❌ Não garante ordem de inserção
* 🔍 Depende de `equals()` e `hashCode()` para suas chaves

A ordem dos elementos pode mudar conforme novas informações são adicionadas.

---

# 🔗 `LinkedHashMap`

Quando precisamos manter a **ordem de inserção**, podemos utilizar:

```java
Map<String, Integer> estoque = new LinkedHashMap<>();
```

Exemplo:

```java
estoque.put("Teclado", 10);
estoque.put("Mouse", 20);
estoque.put("Monitor", 5);
```

A iteração preservará:

```text
Teclado
Mouse
Monitor
```

### Comparação

| Característica     | `HashMap` | `LinkedHashMap` |
| ------------------ | --------- | --------------- |
| Chaves duplicadas  | ❌         | ❌               |
| Valores duplicados | ✅         | ✅               |
| Ordem de inserção  | ❌         | ✅               |
| Utiliza hash       | ✅         | ✅               |

---

# 🔄 Percorrendo um `Map`

Existem três formas principais de navegar pelos dados.

---

## 🔑 `keySet()`

Retorna um `Set` contendo todas as **chaves**.

```java
for (Integer chave : alunos.keySet()) {
    System.out.println(chave);
}
```

Se também quisermos o valor:

```java
for (Integer chave : alunos.keySet()) {
    System.out.println(
        chave + " → " + alunos.get(chave)
    );
}
```

Como as chaves são únicas, o retorno é um `Set`.

---

# 📦 `values()`

Retorna uma `Collection` contendo apenas os **valores**.

```java
for (String aluno : alunos.values()) {
    System.out.println(aluno);
}
```

É retornado `Collection` porque valores **podem ser duplicados**.

---

# ⭐ `entrySet()`

Quando precisamos da **chave e do valor simultaneamente**, a melhor opção geralmente é `entrySet()`.

```java
for (Map.Entry<Integer, String> entry : alunos.entrySet()) {

    System.out.println(
        entry.getKey() + " → " + entry.getValue()
    );
}
```

Cada `Entry` representa:

```text
┌───────────────┐
│ Key → Value   │
└───────────────┘
```

### Métodos principais

```java
entry.getKey()
```

Obtém a chave.

```java
entry.getValue()
```

Obtém o valor.

> 💡 `entrySet()` evita procurar novamente o valor através de `map.get(key)`, sendo normalmente a abordagem mais adequada quando precisamos dos dois dados.

---

# 🧑‍💻 `Map` com Objetos Personalizados

As chaves e os valores não precisam ser tipos simples.

Podemos utilizar nossas próprias classes:

```java
Map<Consumidor, Manga> compras = new HashMap<>();
```

Nesse exemplo:

```text
Consumidor → chave
Manga      → valor
```

Podemos fazer:

```java
compras.put(consumidor1, manga1);
compras.put(consumidor2, manga2);
```

Representação:

```text
Consumidor 1 → Manga 1
Consumidor 2 → Manga 2
```

---

# 🔐 `equals()` e `hashCode()` nas Chaves

Quando utilizamos objetos personalizados como **chaves**, é fundamental implementar corretamente:

```java
equals()
hashCode()
```

Por exemplo, se `Consumidor` utiliza `id` como identidade:

```java
@Override
public boolean equals(Object obj) {
    // comparação pelo ID
}

@Override
public int hashCode() {
    // hash baseado no ID
}
```

Assim, o `HashMap` consegue identificar corretamente quando duas chaves representam o mesmo consumidor.

---

# 👥 Um para Muitos

Um cenário mais realista seria:

> Um consumidor pode comprar vários mangás.

Nesse caso, não queremos:

```java
Map<Consumidor, Manga>
```

pois cada consumidor teria apenas um mangá associado.

Podemos utilizar:

```java
Map<Consumidor, List<Manga>> compras = new HashMap<>();
```

Agora temos:

```text
Consumidor
    │
    └── List<Manga>
          ├── Manga 1
          ├── Manga 2
          └── Manga 3
```

Isso representa uma relação:

> **Um Consumidor → Muitos Mangás**

---

# 🔄 Percorrendo `Map<K, List<V>>`

Como o valor agora é uma lista, precisamos utilizar **dois `for-each`**.

```java
for (Map.Entry<Consumidor, List<Manga>> entry
        : compras.entrySet()) {

    Consumidor consumidor = entry.getKey();

    System.out.println(
        "Consumidor: " + consumidor.getNome()
    );

    for (Manga manga : entry.getValue()) {
        System.out.println(
            "  Manga: " + manga.getNome()
        );
    }
}
```

O primeiro `for` percorre:

```text
Map
 ↓
Consumidor
 ↓
List<Manga>
```

O segundo percorre:

```text
List<Manga>
 ↓
Manga 1
Manga 2
Manga 3
```

---

# 🧠 Estrutura Visual

```text
Map<Consumidor, List<Manga>>

             Map
              │
       ┌──────┴──────┐
       │             │
 Consumidor A    Consumidor B
       │             │
       ▼             ▼
    List<Manga>   List<Manga>
       │             │
   ┌───┼───┐      ┌──┼───┐
   ▼   ▼   ▼      ▼  ▼   ▼
  M1  M2  M3     M4 M5  M6
```

Essa estrutura é extremamente comum em sistemas reais para representar relacionamentos entre entidades.

---

# 📌 Resumo Geral

| Conceito         | Descrição                                          |
| ---------------- | -------------------------------------------------- |
| `Map<K,V>`       | Associação entre chave e valor                     |
| `K`              | Tipo da chave                                      |
| `V`              | Tipo do valor                                      |
| `put()`          | Adiciona ou substitui uma associação               |
| `putIfAbsent()`  | Adiciona somente se a chave não existir            |
| `keySet()`       | Retorna as chaves como `Set`                       |
| `values()`       | Retorna os valores como `Collection`               |
| `entrySet()`     | Retorna chave e valor juntos                       |
| `HashMap`        | `Map` baseado em hash, sem ordem garantida         |
| `LinkedHashMap`  | `Map` baseado em hash que mantém ordem de inserção |
| `Map.Entry`      | Representa uma associação chave → valor            |
| `Map<K,List<V>>` | Representa uma relação de um para muitos           |

---

# 🎓 Dicas Importantes

* ✅ `Map` trabalha com **chave → valor**, não com posições.
* ✅ **Chaves são únicas**, mas valores podem se repetir.
* ✅ Usar uma chave existente com `put()` **substitui o valor anterior**.
* ✅ Prefira `entrySet()` quando precisar acessar chave e valor durante a iteração.
* ✅ `HashMap` não garante ordem; use `LinkedHashMap` quando a ordem de inserção for importante.
* ⚠️ Objetos utilizados como chaves devem possuir `equals()` e `hashCode()` consistentes.
* 💡 `Map<K, List<V>>` é uma estrutura muito importante para representar relacionamentos **um para muitos** em aplicações reais.

---
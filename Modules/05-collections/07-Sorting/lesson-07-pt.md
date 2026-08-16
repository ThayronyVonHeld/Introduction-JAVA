# 📚 Aula 07 - Ordenando Listas com `Comparable` e `Comparator`

---

# 🎯 Objetivos da Aula

* Compreender como funciona a ordenação de listas em Java
* Utilizar a classe utilitária `Collections`
* Entender a interface `Comparable`
* Conhecer a interface `Comparator`
* Saber quando utilizar cada abordagem de ordenação

---

# 🧠 Ordenando Coleções

Uma das operações mais comuns em aplicações é ordenar dados.

Exemplos:

* Lista de produtos por preço
* Usuários por nome
* Funcionários por matrícula
* Mangás por título

O Java facilita esse processo através da classe utilitária **`Collections`**.

---

# 🛠 Classe `Collections`

A classe **`Collections`** (plural) oferece diversos métodos estáticos para manipular coleções.

O principal deles é:

```java
Collections.sort(lista);
```

Exemplo:

```java
List<String> nomes = new ArrayList<>();

nomes.add("Carlos");
nomes.add("Ana");
nomes.add("Bruno");

Collections.sort(nomes);

System.out.println(nomes);
```

Saída:

```text
[Ana, Bruno, Carlos]
```

> 💡 Não confunda **`Collection`** (interface) com **`Collections`** (classe utilitária).

---

# 🔢 Ordenação de Tipos Básicos

O Java já conhece a ordem natural de alguns tipos.

| Tipo        | Ordem padrão  |
| ----------- | ------------- |
| `String`    | Alfabética    |
| `Integer`   | Crescente     |
| `Double`    | Crescente     |
| `Long`      | Crescente     |
| `Character` | Ordem Unicode |

Exemplo:

```java
List<Integer> numeros = Arrays.asList(8, 2, 15, 5);

Collections.sort(numeros);

System.out.println(numeros);
```

Saída:

```text
[2, 5, 8, 15]
```

---

# ❓ O problema com Objetos Personalizados

Imagine a classe:

```java
public class Manga {

    private Long id;
    private String nome;
    private Double preco;

}
```

Agora tente ordenar:

```java
Collections.sort(listaMangas);
```

O código não compila.

Mas por quê?

O Java não sabe qual atributo utilizar.

Deve ordenar por:

* Nome?
* ID?
* Preço?

É o desenvolvedor quem deve definir essa regra.

---

# 📚 Interface `Comparable`

Quando uma classe possui uma **ordem natural**, ela deve implementar a interface:

```java
Comparable<T>
```

Exemplo:

```java
public class Manga
        implements Comparable<Manga> {
}
```

Ao implementar essa interface, torna-se obrigatório sobrescrever o método:

```java
compareTo()
```

---

# ⚙️ Método `compareTo()`

O método compara o objeto atual (`this`) com outro objeto.

```java
@Override
public int compareTo(Manga outro) {

}
```

O retorno segue sempre a mesma regra:

| Retorno | Significado                 |
| ------- | --------------------------- |
| `< 0`   | Este objeto é menor         |
| `0`     | Os objetos são equivalentes |
| `> 0`   | Este objeto é maior         |

---

# ✨ Comparando por Nome

Como `String` já implementa `Comparable`, basta delegar a comparação.

```java
@Override
public int compareTo(Manga outro) {
    return this.nome.compareTo(outro.nome);
}
```

Agora:

```java
Collections.sort(listaMangas);
```

A lista será ordenada alfabeticamente pelo nome.

---

# 🔢 Comparando valores numéricos

Para tipos numéricos, utilize os métodos das classes Wrapper.

```java
@Override
public int compareTo(Manga outro) {
    return Double.compare(this.preco, outro.preco);
}
```

Também seria possível comparar pelo ID:

```java
return Long.compare(this.id, outro.id);
```

Essa abordagem evita implementações manuais com diversos `if` e torna o código mais simples e seguro.

---

# ⚠️ Limitação do `Comparable`

O `Comparable` define apenas **uma ordem natural**.

Por exemplo:

```text
Manga
   ↓
Ordenação por Nome
```

Mas e se outro ponto do sistema precisar ordenar por preço?

Ou por ID?

Alterar o `compareTo()` sempre que necessário não é uma boa prática, pois pode afetar outras partes da aplicação.

---

# 🔀 Interface `Comparator`

Para criar diferentes formas de ordenação, utilizamos a interface:

```java
Comparator<T>
```

Normalmente, a lógica fica em uma classe separada.

```java
public class MangaByIdComparator
        implements Comparator<Manga> {
}
```

---

# ⚙️ Método `compare()`

O método recebe dois objetos para comparação.

```java
@Override
public int compare(Manga m1, Manga m2) {

}
```

A regra de retorno continua sendo a mesma:

| Retorno | Significado                |
| ------- | -------------------------- |
| `< 0`   | Primeiro objeto vem antes  |
| `0`     | São equivalentes           |
| `> 0`   | Primeiro objeto vem depois |

---

# 💻 Exemplo

Ordenando por ID:

```java
@Override
public int compare(Manga m1, Manga m2) {

    return Long.compare(
            m1.getId(),
            m2.getId()
    );
}
```

Agora basta informar qual comparador será utilizado.

```java
Collections.sort(
        listaMangas,
        new MangaByIdComparator()
);
```

---

# 📌 Método `sort()` da própria `List`

Além da classe `Collections`, a própria interface `List` possui um método de ordenação.

```java
listaMangas.sort(new MangaByIdComparator());
```

Essa é uma alternativa mais moderna e legível para ordenar listas utilizando um `Comparator`.

---

# ⚖️ Comparable × Comparator

| `Comparable`                   | `Comparator`                        |
| ------------------------------ | ----------------------------------- |
| Ordem natural do objeto        | Ordem personalizada                 |
| Implementado na própria classe | Implementado externamente           |
| Método `compareTo()`           | Método `compare()`                  |
| Apenas um critério principal   | Permite vários critérios diferentes |

---

# 📌 Resumo

| Conceito             | Descrição                                                 |
| -------------------- | --------------------------------------------------------- |
| `Collections.sort()` | Ordena listas utilizando a ordem natural ou um comparador |
| `Comparable`         | Define a ordem natural do objeto                          |
| `compareTo()`        | Método utilizado pelo `Comparable`                        |
| `Comparator`         | Permite criar ordenações alternativas                     |
| `compare()`          | Método utilizado pelo `Comparator`                        |
| `List.sort()`        | Forma moderna de ordenar listas com um `Comparator`       |

---

# 🎓 Dicas Importantes

* ✅ Utilize `Collections.sort()` para ordenar listas de forma simples.
* ✅ Implemente `Comparable` quando a classe possuir uma ordem natural (como nome ou código).
* ✅ Utilize `Comparator` quando precisar de múltiplos critérios de ordenação.
* ✅ Prefira delegar comparações para métodos prontos, como `String.compareTo()`, `Long.compare()` e `Double.compare()`.
* ✅ Evite alterar constantemente o `compareTo()` da classe; isso pode impactar outras partes da aplicação.
* ✅ A própria interface `List` possui o método `sort()`, que oferece uma forma mais moderna de ordenar coleções.

---

## 💡 Conclusão

O Java oferece um mecanismo poderoso e flexível para ordenação de coleções. Enquanto o **`Comparable`** define a **ordem natural** de um objeto, o **`Comparator`** permite criar diferentes estratégias de ordenação sem modificar a classe original.

Na prática, ambos trabalham em conjunto e são amplamente utilizados em aplicações que precisam organizar dados por diferentes critérios, como nome, preço, data ou identificador.

---
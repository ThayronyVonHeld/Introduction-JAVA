# 📚 Aula 08 - Busca Binária (`Binary Search`)

---

# 🎯 Objetivos da Aula

* Compreender o funcionamento da Busca Binária
* Aprender quando utilizar `binarySearch()`
* Interpretar os valores retornados pelo método
* Realizar buscas em listas de objetos
* Conhecer a relação entre ordenação e busca binária

---

# 🧠 O que é a Busca Binária?

A **Busca Binária** (*Binary Search*) é um algoritmo utilizado para localizar elementos de forma muito mais eficiente do que uma busca sequencial.

Em vez de percorrer toda a coleção elemento por elemento, ela divide o espaço de busca pela metade a cada comparação.

Essa estratégia reduz significativamente o número de comparações necessárias.

---

# ⚠️ Requisito Fundamental

Para que a busca binária funcione corretamente, a coleção **deve estar ordenada**.

Exemplo:

```java
List<String> nomes = new ArrayList<>();

nomes.add("Carlos");
nomes.add("Ana");
nomes.add("Bruno");
```

Antes da busca:

```java
Collections.sort(nomes);
```

Somente depois:

```java
Collections.binarySearch(nomes, "Bruno");
```

> ⚠️ Se a lista não estiver ordenada, o resultado da busca será imprevisível.

---

# 🔍 Utilizando `binarySearch()`

Após ordenar a lista, basta utilizar:

```java
int indice =
        Collections.binarySearch(
                nomes,
                "Bruno"
        );
```

Resultado:

```text
1
```

O método retorna o índice onde o elemento foi encontrado.

---

# 📊 Valores de Retorno

O retorno do método pode ter dois significados.

| Retorno | Significado                             |
| ------- | --------------------------------------- |
| `>= 0`  | Elemento encontrado (índice da posição) |
| `< 0`   | Elemento não encontrado                 |

Exemplo:

```java
int indice =
        Collections.binarySearch(
                nomes,
                "Pedro"
        );
```

Resultado:

```text
-4
```

---

# ❓ Por que um número negativo?

Quando o elemento não existe, o Java retorna:

```text
-(ponto de inserção) - 1
```

O **ponto de inserção** representa a posição onde o elemento deveria ser inserido para manter a lista ordenada.

Exemplo:

Lista:

```text
Ana
Bruno
Carlos
```

Buscando:

```text
Beatriz
```

Ela deveria ficar entre:

```text
Ana
Beatriz
Bruno
Carlos
```

Logo, o ponto de inserção é:

```text
1
```

O retorno será:

```text
-(1) - 1 = -2
```

---

# 📦 Busca em Objetos

A busca binária também funciona com objetos personalizados.

```java
Collections.binarySearch(
        listaMangas,
        manga
);
```

Nesse caso, a lista precisa estar ordenada utilizando a **ordem natural**, definida pela interface `Comparable`.

---

# 🔀 Utilizando um `Comparator`

Se a lista foi ordenada utilizando um `Comparator`, a busca deve utilizar exatamente o mesmo comparador.

Ordenação:

```java
Collections.sort(
        listaMangas,
        new MangaByIdComparator()
);
```

Busca:

```java
Collections.binarySearch(
        listaMangas,
        manga,
        new MangaByIdComparator()
);
```

Caso seja utilizado um comparador diferente (ou nenhum comparador), o resultado poderá ser incorreto.

---

# 📚 Busca Binária em Arrays

O mesmo conceito também existe para arrays através da classe `Arrays`.

```java
int[] numeros = {8, 2, 5, 1};

Arrays.sort(numeros);

int indice =
        Arrays.binarySearch(
                numeros,
                5
        );
```

As regras de funcionamento e os valores de retorno são exatamente os mesmos das listas.

---

# ⚖️ `indexOf()` × `binarySearch()`

| `indexOf()`                | `binarySearch()`                     |
| -------------------------- | ------------------------------------ |
| Não exige ordenação        | Exige lista ordenada                 |
| Busca sequencial           | Busca dividindo a coleção ao meio    |
| Mais simples               | Mais eficiente para listas ordenadas |
| Ideal para listas pequenas | Ideal para grandes volumes de dados  |

---

# 📌 Resumo

| Conceito                     | Descrição                                            |
| ---------------------------- | ---------------------------------------------------- |
| `Collections.binarySearch()` | Realiza busca binária em listas                      |
| `Arrays.binarySearch()`      | Realiza busca binária em arrays                      |
| Lista ordenada               | Requisito obrigatório para a busca                   |
| Retorno positivo             | Índice do elemento encontrado                        |
| Retorno negativo             | Elemento não encontrado (`-(ponto de inserção) - 1`) |
| `Comparator`                 | Deve ser o mesmo utilizado na ordenação da lista     |

---

# 🎓 Dicas Importantes

* ✅ Sempre ordene a coleção antes de utilizar `binarySearch()`.
* ✅ Utilize `Collections.sort()` para listas e `Arrays.sort()` para arrays.
* ✅ Em objetos personalizados, implemente `Comparable` ou utilize um `Comparator`.
* ✅ Se ordenar com um `Comparator`, utilize o mesmo comparador durante a busca.
* ✅ O retorno negativo não representa um erro; ele informa onde o elemento poderia ser inserido mantendo a ordenação.

---

## 💡 Conclusão

A **Busca Binária** é uma alternativa muito eficiente para localizar elementos em coleções ordenadas. Embora exija uma etapa prévia de ordenação, ela reduz significativamente o número de comparações realizadas, tornando-se uma excelente opção para listas e arrays com grande quantidade de elementos. Dominar esse algoritmo ajuda a compreender melhor como o Java realiza buscas de forma otimizada em suas estruturas de dados.

---
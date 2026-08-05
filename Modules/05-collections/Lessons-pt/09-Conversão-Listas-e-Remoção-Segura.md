# 📚 Aula 09 - Conversão de Listas e Remoção Segura de Elementos

---

# 🎯 Objetivos da Aula

* Converter listas em arrays e vice-versa
* Entender as diferenças entre listas mutáveis e imutáveis
* Conhecer os métodos `toArray()` e `Arrays.asList()`
* Aprender a remover elementos de uma lista com segurança
* Conhecer o funcionamento do `Iterator` e do `removeIf()`

---

# 🔄 Convertendo uma `List` para Array

A interface `List` possui o método `toArray()`, utilizado para transformar uma coleção em um array.

Existem duas formas principais de utilizá-lo.

### Retornando um `Object[]`

```java
List<String> nomes = new ArrayList<>();

nomes.add("Ana");
nomes.add("Carlos");

Object[] array = nomes.toArray();
```

Como o retorno é um `Object[]`, normalmente essa abordagem não é a mais indicada.

---

### Retornando um array tipado

A forma recomendada é informar o tipo do array.

```java
String[] array =
        nomes.toArray(new String[0]);
```

Agora o retorno será:

```java
String[]
```

> 💡 Curiosamente, utilizar `new String[0]` costuma ser mais eficiente do que criar um array com o tamanho exato da lista, pois a própria JVM realiza essa otimização internamente.

---

# 🔁 Convertendo um Array para `List`

A conversão é feita através da classe utilitária `Arrays`.

```java
String[] nomes = {
        "Ana",
        "Carlos",
        "Maria"
};

List<String> lista =
        Arrays.asList(nomes);
```

Também é possível criar a lista diretamente:

```java
List<String> lista =
        Arrays.asList(
                "Ana",
                "Carlos",
                "Maria"
        );
```

---

# ⚠️ Atenção ao `Arrays.asList()`

A lista criada por `Arrays.asList()` possui algumas limitações importantes.

## 1️⃣ Ela continua ligada ao array original

```java
String[] nomes = {
        "Ana",
        "Carlos"
};

List<String> lista =
        Arrays.asList(nomes);

lista.set(0, "Lucas");

System.out.println(nomes[0]);
```

Saída:

```text
Lucas
```

Alterar a lista também altera o array.

---

## 2️⃣ O tamanho é fixo

Adicionar ou remover elementos não é permitido.

```java
lista.add("Maria");
```

Resultado:

```text
UnsupportedOperationException
```

---

# ✅ Criando uma Lista Mutável

Se precisar modificar a lista livremente, basta criar uma nova instância de `ArrayList`.

```java
List<String> lista =
        new ArrayList<>(
                Arrays.asList(
                        "Ana",
                        "Carlos"
                )
        );
```

Agora é possível utilizar normalmente:

```java
lista.add("Maria");
lista.remove("Ana");
```

Sem qualquer vínculo com o array original.

---

# ✨ Criando listas rapidamente

Desde o Java 9, existe outra alternativa:

```java
List<String> nomes =
        List.of(
                "Ana",
                "Carlos",
                "Maria"
        );
```

Essa sintaxe é mais limpa, porém cria uma **lista imutável**.

---

# ❌ O problema ao remover elementos

Um erro muito comum é remover elementos durante um `for-each`.

```java
for (String nome : nomes) {

    nomes.remove(nome);

}
```

Isso gera:

```text
ConcurrentModificationException
```

O motivo é que o tamanho da coleção muda enquanto ela está sendo percorrida.

---

# 🔄 Interface `Iterator`

O `Iterator` é a forma tradicional de percorrer e modificar uma coleção com segurança.

Obtendo um iterator:

```java
Iterator<String> iterator =
        nomes.iterator();
```

---

## Principais métodos

| Método      | Descrição                               |
| ----------- | --------------------------------------- |
| `hasNext()` | Verifica se existe próximo elemento     |
| `next()`    | Obtém o próximo elemento                |
| `remove()`  | Remove o elemento atual de forma segura |

---

# 💻 Exemplo

```java
Iterator<String> iterator =
        nomes.iterator();

while (iterator.hasNext()) {

    String nome = iterator.next();

    if (nome.startsWith("A")) {

        iterator.remove();

    }

}
```

O `Iterator` controla a navegação e a remoção sem causar erros de modificação concorrente.

---

# 🚀 `removeIf()` (Java 8+)

A partir do Java 8, a remoção tornou-se muito mais simples.

```java
nomes.removeIf(
        nome -> nome.startsWith("A")
);
```

Outro exemplo:

```java
mangas.removeIf(
        manga ->
                manga.getQuantidade() == 0
);
```

Embora pareça uma operação diferente, internamente o Java continua utilizando um `Iterator` para realizar a remoção com segurança.

---

# ⚖️ `Iterator` × `removeIf()`

| `Iterator`                             | `removeIf()`                              |
| -------------------------------------- | ----------------------------------------- |
| Mais detalhado                         | Mais simples                              |
| Controle total da navegação            | Ideal para remoções baseadas em condições |
| Necessário em situações mais complexas | Muito utilizado em Java moderno           |

---

# 📌 Resumo

| Conceito               | Descrição                                           |
| ---------------------- | --------------------------------------------------- |
| `toArray()`            | Converte uma lista em array                         |
| `Arrays.asList()`      | Converte um array em lista de tamanho fixo          |
| `new ArrayList<>(...)` | Cria uma lista independente e mutável               |
| `List.of()`            | Cria uma lista imutável                             |
| `Iterator`             | Permite percorrer e remover elementos com segurança |
| `removeIf()`           | Remove elementos utilizando uma condição            |

---

# 🎓 Dicas Importantes

* ✅ Prefira `toArray(new Tipo[0])` para obter arrays tipados.
* ✅ Lembre-se de que `Arrays.asList()` cria uma lista de tamanho fixo e vinculada ao array original.
* ✅ Utilize `new ArrayList<>(Arrays.asList(...))` quando precisar de uma lista mutável.
* ✅ Nunca remova elementos diretamente dentro de um `for-each`.
* ✅ Para remoções simples, prefira `removeIf()`, que torna o código mais limpo e legível.
* ✅ Utilize `Iterator` quando precisar de maior controle sobre a navegação da coleção.

---

## 💡 Conclusão

Além de armazenar e organizar dados, a interface `List` oferece diversos recursos para conversão e manipulação de coleções. Saber converter entre listas e arrays, entender as diferenças entre coleções mutáveis e imutáveis e utilizar corretamente ferramentas como `Iterator` e `removeIf()` torna o código mais seguro, legível e alinhado às boas práticas do Java moderno.

---
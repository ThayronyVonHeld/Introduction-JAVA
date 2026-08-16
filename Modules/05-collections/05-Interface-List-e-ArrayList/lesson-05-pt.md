# 📚 Aula 05 - Interface `List` e `ArrayList`

---

# 🎯 Objetivos da Aula

* Compreender o funcionamento da interface `List`
* Conhecer a implementação `ArrayList`
* Entender o uso de Generics
* Aprender as principais operações da interface
* Conhecer boas práticas de utilização

---

# 🧠 O que é uma `List`?

A interface `List`, pertencente ao pacote `java.util`, representa uma coleção **ordenada** de elementos.

Isso significa que os elementos permanecem na ordem em que foram inseridos e podem ser acessados através de um índice.

Entre suas implementações, a mais utilizada é o **`ArrayList`**.

---

# 📦 `ArrayList`

O `ArrayList` funciona como um **array dinâmico**.

Diferentemente dos arrays tradicionais, ele aumenta sua capacidade automaticamente conforme novos elementos são adicionados.

```java
List<String> nomes = new ArrayList<>();
```

Essa é a implementação mais utilizada quando precisamos armazenar uma sequência de elementos.

---

# 💎 Generics

Antes do Java 5, uma lista armazenava qualquer objeto.

```java
List lista = new ArrayList();

lista.add("Lucas");
lista.add(10);
lista.add(true);
```

Esse comportamento permitia erros em tempo de execução.

Com a chegada dos **Generics**, passou a ser possível definir o tipo da coleção.

```java
List<String> nomes = new ArrayList<>();

nomes.add("Lucas");
nomes.add("Maria");
```

Agora o compilador garante que apenas objetos do tipo correto sejam adicionados.

---

# 💡 Programação Orientada a Interfaces

Uma boa prática é declarar sempre utilizando a interface.

```java
List<String> nomes = new ArrayList<>();
```

Em vez de:

```java
ArrayList<String> nomes = new ArrayList<>();
```

Isso torna o código mais flexível, permitindo trocar a implementação futuramente sem alterar o restante da aplicação.

---

# 📊 Capacidade do `ArrayList`

Internamente, o `ArrayList` trabalha com um array.

Quando sua capacidade é atingida, um novo array maior é criado automaticamente e os elementos são copiados para ele.

Se já soubermos aproximadamente a quantidade de elementos que serão armazenados, podemos informar uma capacidade inicial.

```java
List<String> nomes = new ArrayList<>(300);
```

Isso reduz a quantidade de redimensionamentos e melhora a performance.

---

# 🔤 Apenas Objetos

Coleções armazenam apenas objetos.

Por isso, não é possível utilizar tipos primitivos diretamente.

❌ Incorreto

```java
List<int> numeros;
```

✅ Correto

```java
List<Integer> numeros = new ArrayList<>();
```

O Java utiliza o recurso chamado **Autoboxing**, convertendo automaticamente tipos primitivos para suas classes Wrapper.

```java
numeros.add(10);
```

Internamente:

```java
Integer.valueOf(10);
```

---

# 🛠 Principais Métodos

| Método       | Descrição                         |
| ------------ | --------------------------------- |
| `add()`      | Adiciona um elemento              |
| `get()`      | Obtém um elemento pelo índice     |
| `size()`     | Retorna a quantidade de elementos |
| `remove()`   | Remove um elemento ou posição     |
| `clear()`    | Remove todos os elementos         |
| `contains()` | Verifica se um elemento existe    |
| `indexOf()`  | Retorna a posição de um elemento  |
| `addAll()`   | Adiciona outra coleção            |

---

# ➕ Adicionando elementos

```java
List<String> nomes = new ArrayList<>();

nomes.add("Lucas");
nomes.add("Maria");
nomes.add("Carlos");
```

---

# 🔍 Obtendo elementos

```java
System.out.println(nomes.get(1));
```

**Saída**

```text
Maria
```

---

# 📏 Tamanho da lista

```java
System.out.println(nomes.size());
```

**Saída**

```text
3
```

Diferentemente dos arrays, utiliza-se `size()` em vez de `length`.

---

# 🔄 Percorrendo uma `List`

### For tradicional

```java
for (int i = 0; i < nomes.size(); i++) {
    System.out.println(nomes.get(i));
}
```

### For-each

```java
for (String nome : nomes) {
    System.out.println(nome);
}
```

O `for-each` costuma ser a opção mais simples quando apenas precisamos percorrer os elementos.

---

# 📌 Resumo

| Conceito    | Descrição                                       |
| ----------- | ----------------------------------------------- |
| `List`      | Coleção ordenada e indexada                     |
| `ArrayList` | Implementação baseada em array dinâmico         |
| Generics    | Definem o tipo aceito pela coleção              |
| Wrapper     | Permite armazenar tipos primitivos como objetos |
| Autoboxing  | Conversão automática entre primitivo e Wrapper  |

---

# 🎓 Dicas Importantes

* ✅ Utilize `List` na declaração da variável e `ArrayList` na instanciação.
* ✅ Sempre utilize Generics (`<>`) para garantir segurança de tipos.
* ✅ Coleções armazenam apenas objetos; para tipos primitivos utilize as classes Wrapper.
* ✅ Quando souber previamente o tamanho da lista, informe a capacidade inicial para reduzir realocações.
* ✅ O `ArrayList` é uma excelente escolha para acesso rápido por índice.

---
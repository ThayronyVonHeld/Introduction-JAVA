# 📚 Aula 10 - Interface `Set`, `HashSet` e `LinkedHashSet`

---

# 🎯 Objetivos da Aula

- Compreender o funcionamento da interface **`Set`**
- Entender a diferença entre **List** e **Set**
- Conhecer as implementações **`HashSet`** e **`LinkedHashSet`**
- Entender a importância do `equals()` e `hashCode()` em um `Set`
- Saber quando utilizar cada implementação

---

# 🧩 O que é um `Set`?

A interface **`Set`** representa uma coleção de elementos **únicos**, ou seja, **não permite elementos duplicados**.

Diferente de uma `List`, o foco do `Set` não é a posição dos elementos, mas sim garantir que cada objeto exista apenas uma vez na coleção.

---

# 📊 List × Set

| Característica | `List` | `Set` |
|---------------|--------|-------|
| Permite elementos duplicados | ✅ Sim | ❌ Não |
| Mantém ordem de inserção | ✅ Sim | Depende da implementação |
| Possui índice (`get()`) | ✅ Sim | ❌ Não |
| Acesso por posição | ✅ Sim | ❌ Não |

---

# 💻 Exemplo

```java
List<String> nomes = new ArrayList<>();

nomes.add("Lucas");
nomes.add("Maria");
nomes.add("Lucas");

System.out.println(nomes);
```

Saída

```
[Lucas, Maria, Lucas]
```

---

```java
Set<String> nomes = new HashSet<>();

nomes.add("Lucas");
nomes.add("Maria");
nomes.add("Lucas");

System.out.println(nomes);
```

Saída

```
[Lucas, Maria]
```

O segundo `"Lucas"` é ignorado automaticamente.

---

# 🏗️ Programação Orientada a Interfaces

Assim como vimos com `List`, a recomendação é declarar utilizando a interface:

```java
Set<String> nomes = new HashSet<>();
```

Dessa forma, a implementação pode ser alterada facilmente no futuro.

Por exemplo:

```java
Set<String> nomes = new LinkedHashSet<>();
```

ou

```java
Set<String> nomes = new TreeSet<>();
```

Sem alterar o restante do código.

---

# ⚡ `HashSet`

O **`HashSet`** é a implementação mais utilizada da interface `Set`.

Suas principais características são:

- Não permite elementos duplicados
- Não possui índice
- Não mantém a ordem de inserção
- Possui buscas muito rápidas utilizando **hash**

---

## Exemplo

```java
Set<Integer> numeros = new HashSet<>();

numeros.add(30);
numeros.add(10);
numeros.add(20);

System.out.println(numeros);
```

Possível saída

```
[20, 10, 30]
```

> ⚠️ A ordem pode variar, pois o `HashSet` organiza os elementos internamente através do **hash**, e não pela ordem de inserção.

---

# 🚫 Não existe índice

Diferente de uma `List`, um `Set` não possui posições.

Por isso, métodos como:

```java
get(0)
```

não existem.

Para percorrer os elementos, utilize:

```java
for (String nome : nomes) {
    System.out.println(nome);
}
```

ou um `Iterator`.

---

# 🔑 Como o `HashSet` evita duplicatas?

Sempre que um elemento é inserido, o Java realiza duas verificações:

1. Calcula o **`hashCode()`**
2. Caso necessário, compara utilizando **`equals()`**

Se outro objeto igual já existir na coleção, o novo elemento **não será adicionado**.

---

# ⚠️ Importância do `equals()` e `hashCode()`

Quando trabalhamos com objetos personalizados, é fundamental implementar corretamente esses métodos.

```java
Set<Smartphone> smartphones = new HashSet<>();

smartphones.add(new Smartphone("ABC123"));
smartphones.add(new Smartphone("ABC123"));
```

Se `equals()` e `hashCode()` estiverem implementados corretamente, apenas um objeto permanecerá na coleção.

---

# 🔗 `LinkedHashSet`

O **`LinkedHashSet`** possui praticamente o mesmo comportamento do `HashSet`, porém com uma diferença importante:

> Ele mantém a ordem de inserção dos elementos.

---

## Exemplo

```java
Set<String> nomes = new LinkedHashSet<>();

nomes.add("Lucas");
nomes.add("Maria");
nomes.add("Carlos");

System.out.println(nomes);
```

Saída

```
[Lucas, Maria, Carlos]
```

A sequência é preservada exatamente como foi inserida.

---

# 🔄 `HashSet` × `LinkedHashSet`

| Característica | `HashSet` | `LinkedHashSet` |
|---------------|-----------|-----------------|
| Permite duplicados | ❌ Não | ❌ Não |
| Mantém ordem de inserção | ❌ Não | ✅ Sim |
| Utiliza hash | ✅ Sim | ✅ Sim |
| Possui índice | ❌ Não | ❌ Não |

---

# 📌 Quando utilizar um `Set`?

Utilize um `Set` quando o objetivo principal for garantir **unicidade** dos dados.

Exemplos:

- CPF de clientes
- E-mails cadastrados
- Usuários online
- Tags de um artigo
- Categorias de produtos
- Palavras únicas em um texto

---

# 💡 `LinkedList`

Embora não faça parte da interface `Set`, vale lembrar outra implementação importante estudada nesta aula:

```java
List<String> nomes = new LinkedList<>();
```

O **`LinkedList`** é uma implementação de `List` baseada em nós encadeados.

Cada elemento conhece o anterior e o próximo, tornando operações de inserção e remoção mais eficientes do que em um `ArrayList`, especialmente no meio da coleção.

---

# 📌 Resumo Geral

| Conceito | Descrição |
|----------|-----------|
| `Set` | Coleção que não permite elementos duplicados |
| `HashSet` | Implementação baseada em hash, sem ordem de inserção |
| `LinkedHashSet` | Mantém a ordem de inserção e evita duplicatas |
| `equals()` | Define quando dois objetos são considerados iguais |
| `hashCode()` | Auxilia na localização e identificação dos objetos |
| `LinkedList` | Implementação de `List` otimizada para inserções e remoções |

---

# 🎓 Dicas Importantes

- ✅ Utilize **`Set`** quando não fizer sentido armazenar elementos repetidos.
- ✅ O **`HashSet`** oferece excelente desempenho para inserção e busca, mas **não preserva a ordem** dos elementos.
- ✅ Escolha o **`LinkedHashSet`** quando precisar manter a ordem de inserção sem permitir duplicatas.
- ✅ Objetos personalizados utilizados em um `Set` devem sobrescrever corretamente os métodos **`equals()`** e **`hashCode()`**.
- ✅ Sempre programe utilizando a interface (`Set`) e não a implementação (`HashSet`), tornando o código mais flexível e fácil de manter.


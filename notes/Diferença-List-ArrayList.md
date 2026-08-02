Em Java, **`List`** e **`ArrayList`** não são a mesma coisa:

* **`List`** é uma **interface** (um contrato). Ela define o que uma lista deve ser capaz de fazer, como:

    * adicionar elementos (`add`)
    * remover elementos (`remove`)
    * acessar por índice (`get`)
    * verificar tamanho (`size`)

* **`ArrayList`** é uma **classe** que implementa a interface `List`. Ela é uma implementação concreta baseada em um **array redimensionável**.

### Exemplo

```java
List<String> nomes = new ArrayList<>();
```

Nesse código:

* `List<String>` → tipo da variável (a interface).
* `new ArrayList<>()` → objeto criado (a implementação).

### Por que usar `List` em vez de `ArrayList`?

É uma boa prática programar para a interface, não para a implementação.

Exemplo:

```java
List<String> nomes = new ArrayList<>();
```

Se no futuro você quiser trocar a implementação:

```java
List<String> nomes = new LinkedList<>();
```

Você muda apenas a criação do objeto, sem precisar alterar o restante do código.

### Principais implementações de `List`

| Implementação | Características                                                                                                  |
| ------------- | ---------------------------------------------------------------------------------------------------------------- |
| `ArrayList`   | Baseada em array, acesso rápido por índice, inserções no meio podem ser mais lentas.                             |
| `LinkedList`  | Baseada em lista encadeada, inserções e remoções frequentes são mais eficientes, acesso por índice é mais lento. |
| `Vector`      | Similar ao `ArrayList`, porém sincronizada (legada e pouco usada atualmente).                                    |

### Analogia

Imagine um **veículo**:

* `List` = "Veículo" (define que um veículo deve acelerar, frear etc.).
* `ArrayList` = "Carro".
* `LinkedList` = "Moto".

Você pode escrever:

```java
Veiculo v = new Carro();
```

Da mesma forma:

```java
List<String> lista = new ArrayList<>();
```

### Resumindo

* **`List`** → interface (define operações).
* **`ArrayList`** → implementação da interface `List`.
* Geralmente declara-se a variável como `List` e instancia-se com `ArrayList`:

```java
List<Integer> numeros = new ArrayList<>();
```

Essa abordagem deixa o código mais flexível e facilita a troca da implementação caso seja necessário no futuro.

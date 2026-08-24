# 📚 Aula 12 - Wildcards (`?`) e Generics

---

# 🎯 Objetivos da Aula

* Compreender o problema do **polimorfismo com Generics**
* Entender por que `List<Cachorro>` não é uma `List<Animal>`
* Conhecer os **Wildcards (`?`)**
* Entender `? extends` e `? super`
* Saber quando utilizar cada tipo de Wildcard

---

# 🧩 O problema do Polimorfismo com Generics

Considere a seguinte hierarquia:

```java
Animal
 ├── Cachorro
 └── Gato
```

Como `Cachorro` e `Gato` são `Animal`, podemos fazer:

```java
Animal animal = new Cachorro();
```

Isso é **polimorfismo**.

Porém, o mesmo princípio **não se aplica diretamente aos Generics**:

```java
List<Cachorro> cachorros = new ArrayList<>();

List<Animal> animais = cachorros; // ❌ Erro
```

Embora `Cachorro` seja um `Animal`, **`List<Cachorro>` não é uma `List<Animal>`**.

---

# ⚠️ Por que isso é necessário?

Imagine que fosse permitido:

```java
List<Cachorro> cachorros = new ArrayList<>();

List<Animal> animais = cachorros;
```

Agora seria possível:

```java
animais.add(new Gato());
```

A lista original deveria conter apenas `Cachorro`, mas acabaria recebendo um `Gato`.

Por isso, o Java bloqueia essa conversão para preservar a **segurança de tipos**.

---

# 🐶 Polimorfismo com Arrays × Generics

Com arrays, o Java permite:

```java
Cachorro[] cachorros = new Cachorro[10];

Animal[] animais = cachorros;
```

Porém, isso pode gerar um erro em **tempo de execução**:

```java
animais[0] = new Gato();
```

Resultado:

```text
ArrayStoreException
```

Já os Generics adotam uma abordagem mais segura:

```java
List<Cachorro> cachorros = new ArrayList<>();

List<Animal> animais = cachorros; // ❌ Erro de compilação
```

> **Arrays permitem esse tipo de polimorfismo e podem falhar em runtime. Generics bloqueiam a operação durante a compilação.**

---

# 🃏 Wildcard `?`

Para permitir que um método trabalhe com diferentes tipos relacionados, utilizamos o **Wildcard (`?`)**.

Por exemplo:

```java
List<? extends Animal>
```

Isso significa:

> Uma `List` de algum tipo que seja `Animal` ou uma subclasse de `Animal`.

Assim podemos receber:

```java
List<Cachorro>
List<Gato>
List<Animal>
```

---

# ⬆️ `? extends` — Upper Bound

```java
List<? extends Animal>
```

Significa:

> Aceita `Animal` ou qualquer classe que herde de `Animal`.

Exemplo:

```java
public static void consulta(List<? extends Animal> animais) {
    for (Animal animal : animais) {
        animal.consulta();
    }
}
```

Agora podemos passar:

```java
List<Cachorro> cachorros = new ArrayList<>();
List<Gato> gatos = new ArrayList<>();

consulta(cachorros);
consulta(gatos);
```

---

# 🔒 Regra de Ouro do `extends`

Quando utilizamos:

```java
? extends Animal
```

**podemos ler, mas não podemos adicionar elementos.**

```java
Animal animal = animais.get(0); // ✅

animais.add(new Cachorro()); // ❌
animais.add(new Gato());     // ❌
```

O motivo é simples:

> O Java não sabe qual é o tipo específico da lista.

Ela pode ser:

```java
List<Cachorro>
```

ou:

```java
List<Gato>
```

Portanto, adicionar um `Animal` poderia inserir um tipo incompatível.

### 🧠 Memorize:

> `extends` → **LEITURA**

---

# ⬇️ `? super` — Lower Bound

O `super` funciona na direção contrária:

```java
List<? super Animal>
```

Significa:

> Aceita `Animal` ou qualquer uma de suas superclasses.

Por exemplo:

```java
List<Animal>
List<Object>
```

podem ser utilizadas.

---

# ✍️ Regra de Ouro do `super`

Com:

```java
List<? super Animal>
```

podemos adicionar `Animal` e suas subclasses:

```java
animais.add(new Cachorro()); // ✅
animais.add(new Gato());     // ✅
animais.add(new Animal());   // ✅
```

Isso é seguro porque a lista obrigatoriamente aceita `Animal` ou algo mais genérico, como `Object`.

Porém, a leitura é limitada:

```java
Object animal = animais.get(0);
```

O Java só consegue garantir que o elemento é um `Object`.

### 🧠 Memorize:

> `super` → **ESCRITA**

---

# ⚖️ `extends` × `super`

| Característica       | `? extends Animal` | `? super Animal` |
| -------------------- | ------------------ | ---------------- |
| Aceita subclasses    | ✅                  | ❌                |
| Aceita `Animal`      | ✅                  | ✅                |
| Aceita superclasses  | ❌                  | ✅                |
| Ler como `Animal`    | ✅                  | ❌                |
| Adicionar `Animal`   | ❌                  | ✅                |
| Principal utilização | **Leitura**        | **Escrita**      |

---

# 🧠 Regra para Memorizar

Uma forma clássica de lembrar:

> **PECS — Producer Extends, Consumer Super**

### `extends` → Producer

A coleção **produz/fornece dados** para você.

```java
List<? extends Animal>
```

➡️ **Leia os dados.**

### `super` → Consumer

A coleção **recebe/consome dados** de você.

```java
List<? super Animal>
```

➡️ **Adicione os dados.**

---

# 📌 Resumo Geral

| Conceito                          | Descrição                                 |
| --------------------------------- | ----------------------------------------- |
| `List<Cachorro>`                  | Lista exclusivamente de `Cachorro`        |
| `List<Animal>`                    | Lista exclusivamente de `Animal`          |
| `List<Cachorro>` → `List<Animal>` | ❌ Não permitido                           |
| `?`                               | Wildcard, representa um tipo desconhecido |
| `? extends Animal`                | `Animal` ou subclasses                    |
| `? super Animal`                  | `Animal` ou superclasses                  |
| `extends`                         | Preferencialmente leitura                 |
| `super`                           | Preferencialmente escrita                 |
| **PECS**                          | Producer Extends, Consumer Super          |

---

# 🎓 Dicas Importantes

* ✅ `List<Cachorro>` **não é** `List<Animal>`.
* ✅ Use `? extends` quando precisar **ler** diferentes subclasses.
* ✅ Use `? super` quando precisar **adicionar** subclasses de um determinado tipo.
* ✅ `extends` aponta **para baixo** na hierarquia.
* ✅ `super` aponta **para cima** na hierarquia.
* ✅ Lembre-se de **PECS: Producer Extends, Consumer Super**.
* ⚠️ `extends` e `super` não são apenas questões de herança: eles definem **como uma coleção genérica pode ser utilizada com segurança**.

---
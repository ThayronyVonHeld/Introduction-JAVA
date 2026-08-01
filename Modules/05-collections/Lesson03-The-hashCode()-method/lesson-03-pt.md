# 📚 Aula 03 - O método `hashCode()`

---

# 🎯 Objetivos da Aula

* Compreender a finalidade do método `hashCode()`
* Entender como o `hashCode()` melhora a performance das coleções
* Conhecer o conceito de colisão (*collision*)
* Aprender o contrato entre `equals()` e `hashCode()`
* Implementar corretamente o método `hashCode()`

---

# 🧠 O que é o `hashCode()`?

O método `hashCode()` retorna um valor inteiro (`int`) que representa um objeto.

Esse valor é utilizado pelas coleções baseadas em **hash**, como:

* `HashSet`
* `HashMap`
* `Hashtable`

Seu principal objetivo é **tornar as buscas muito mais rápidas**, evitando que seja necessário percorrer todos os elementos de uma coleção.

> 💡 Pense no `hashCode()` como um **índice** que ajuda o Java a encontrar rapidamente onde um objeto pode estar armazenado.

---

# 🚀 Por que o `hashCode()` existe?

Imagine um supermercado com milhares de produtos.

Sem um índice, para encontrar um produto seria necessário verificar cada item até encontrá-lo.

```text
Produto 1
Produto 2
Produto 3
...
Produto 9824
Produto 9825
Produto 9826
```

Esse processo é lento.

Com o `hashCode()`, o Java consegue ir diretamente para a região onde aquele objeto provavelmente está armazenado.

```text
hashCode()
     │
     ▼
 Bucket 42
     │
     ├── Produto A
     ├── Produto B
     └── Produto C
```

Em vez de procurar entre milhares de objetos, a busca ocorre apenas dentro daquele pequeno grupo.

---

# 📦 Buckets

Internamente, coleções como `HashMap` e `HashSet` organizam seus elementos em **buckets** (baldes).

O `hashCode()` determina em qual bucket um objeto será armazenado.

```text
HashMap

Bucket 0
Bucket 1
Bucket 2
Bucket 3
Bucket 4
...
Bucket 42
```

Quanto melhor distribuídos estiverem os objetos entre os buckets, maior será a performance da coleção.

---

# ⚠️ Colisão (*Collision*)

Uma colisão acontece quando dois objetos diferentes geram o mesmo `hashCode()`.

Exemplo:

```text
Alex → 42

Dirk → 42
```

Os dois objetos serão armazenados no mesmo bucket.

Isso **não representa um erro**.

Colisões fazem parte do funcionamento das estruturas baseadas em hash.

O objetivo é apenas reduzir sua quantidade.

---

# 🤝 Relação entre `hashCode()` e `equals()`

O Java utiliza esses métodos em conjunto.

O processo acontece em duas etapas.

### 1️⃣ Primeiro: `hashCode()`

O Java calcula o hash do objeto e identifica o bucket correspondente.

```text
Objeto
   │
   ▼
hashCode()
   │
   ▼
Bucket 42
```

---

### 2️⃣ Depois: `equals()`

Caso existam vários objetos dentro do mesmo bucket, o Java utiliza o método `equals()` para descobrir qual deles é realmente o procurado.

```text
Bucket 42

Alex
Dirk
Lucas

       │
       ▼
   equals()
```

> 💡 O `hashCode()` localiza a região da busca. O `equals()` confirma qual é o objeto correto.

---

# 📜 Contrato entre `equals()` e `hashCode()`

Sempre que um desses métodos for sobrescrito, o outro também deve ser.

Esse contrato garante o funcionamento correto das coleções baseadas em hash.

As principais regras são:

| Situação                  | Resultado                                                   |
| ------------------------- | ----------------------------------------------------------- |
| `equals()` retorna `true` | Os `hashCode()` devem ser iguais.                           |
| `hashCode()` iguais       | Os objetos podem ou não ser iguais.                         |
| `hashCode()` diferentes   | Os objetos obrigatoriamente não são iguais pelo `equals()`. |

---

## Exemplo

```java
Smartphone s1 =
        new Smartphone("Samsung", "ABC123");

Smartphone s2 =
        new Smartphone("Samsung", "ABC123");
```

Se:

```java
s1.equals(s2);
```

retornar

```text
true
```

então obrigatoriamente:

```java
s1.hashCode() == s2.hashCode();
```

também deverá retornar

```text
true
```

---

# 🛠 Implementando `hashCode()`

Os mesmos atributos utilizados no `equals()` devem ser utilizados para calcular o `hashCode()`.

No exemplo do `Smartphone`, a igualdade é definida pelo atributo `serialNumber`.

Logo, o `hashCode()` também deve utilizar esse atributo.

```java
@Override
public int hashCode() {
    return serialNumber.hashCode();
}
```

Caso o atributo possa ser `null`, é necessário evitar exceções.

```java
@Override
public int hashCode() {
    return serialNumber != null
            ? serialNumber.hashCode()
            : 0;
}
```

---

# 💻 Exemplo Completo

```java
public class Smartphone {

    private String marca;
    private String serialNumber;

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Smartphone other = (Smartphone) obj;

        return serialNumber.equals(other.serialNumber);
    }

    @Override
    public int hashCode() {
        return serialNumber != null
                ? serialNumber.hashCode()
                : 0;
    }
}
```

---

# 📈 Fluxo da Busca em um `HashMap`

```text
Objeto procurado
        │
        ▼
 Calcular hashCode()
        │
        ▼
 Localizar Bucket
        │
        ▼
Existe mais de um objeto?
        │
     Sim ▼ Não
        │
        ▼
 Executar equals()
        │
        ▼
Objeto encontrado
```

---

# 📌 Resumo

| Conceito     | Descrição                                                      |
| ------------ | -------------------------------------------------------------- |
| `hashCode()` | Retorna um valor inteiro utilizado para indexação dos objetos. |
| Bucket       | Estrutura onde objetos com o mesmo hash são armazenados.       |
| Colisão      | Objetos diferentes geram o mesmo `hashCode()`.                 |
| `equals()`   | Confirma se dois objetos são logicamente iguais.               |
| Contrato     | Objetos iguais devem possuir o mesmo `hashCode()`.             |

---

# 🎓 Dicas Importantes

* ✅ Sempre que sobrescrever `equals()`, sobrescreva também `hashCode()`.
* ✅ Utilize os mesmos atributos nos dois métodos para manter o contrato.
* ✅ Colisões são normais; o objetivo é apenas minimizá-las.
* ✅ O `hashCode()` melhora a performance das buscas, mas **não substitui** o `equals()`.
* ✅ Coleções como `HashSet`, `HashMap` e `Hashtable` dependem diretamente desses dois métodos para funcionar corretamente.

---

## 💡 Uma observação

Há um detalhe que eu acrescentaria, porque é uma dúvida muito comum e ajuda bastante na intuição:

> **O `hashCode()` não identifica unicamente um objeto.** Ele apenas calcula um número que ajuda a localizar rapidamente onde o objeto pode estar. Assim como duas pessoas podem morar no mesmo CEP, dois objetos diferentes podem possuir o mesmo `hashCode()`. Nesses casos, o Java utiliza o `equals()` para distinguir qual objeto é o correto.


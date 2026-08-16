# 📚 Aula 06 - Manipulando `List` com Objetos

---

# 🎯 Objetivos da Aula

* Trabalhar com listas contendo objetos personalizados
* Compreender a importância dos métodos `equals()` e `toString()`
* Conhecer métodos avançados da interface `List`
* Entender como buscar e remover objetos
* Aprender cuidados ao modificar listas durante a iteração

---

# 🧠 Trabalhando com Objetos em uma `List`

Em aplicações reais, listas raramente armazenam apenas `String` ou `Integer`.

O mais comum é trabalhar com objetos personalizados, como:

* Usuários
* Produtos
* Smartphones
* Funcionários
* Pedidos

E normalmente trabalhamos com objetos vindos de:

* Banco de dados
* APIs
* Arquivos
* Regras de negócio

Exemplo:

```java
List<Smartphone> smartphones = new ArrayList<>();
```

---

# 📱 Classe `Smartphone`

```java
public class Smartphone {

    private String marca;
    private String serialNumber;

    public Smartphone(String marca, String serialNumber) {
        this.marca = marca;
        this.serialNumber = serialNumber;
    }
}
```

Criando objetos:

```java
Smartphone s1 =
        new Smartphone("Samsung", "ABC123");

Smartphone s2 =
        new Smartphone("Apple", "XYZ789");
```

Adicionando na lista:

```java
List<Smartphone> smartphones = new ArrayList<>();

smartphones.add(s1);
smartphones.add(s2);
```

---

# 🖨️ A importância do `toString()`

Sem sobrescrever o método `toString()`, a impressão da lista pode gerar algo parecido com:

```text
[Smartphone@7a81197d, Smartphone@5ca881b5]
```

Para exibir informações úteis, sobrescrevemos `toString()`:

```java
@Override
public String toString() {
    return "Smartphone{" +
            "marca='" + marca + '\'' +
            ", serialNumber='" + serialNumber + '\'' +
            '}';
}
```

Agora:

```java
System.out.println(smartphones);
```

Saída:

```text
[
Smartphone{marca='Samsung', serialNumber='ABC123'},
Smartphone{marca='Apple', serialNumber='XYZ789'}
]
```

---

# 🔄 Percorrendo Objetos

O `for-each` é a forma mais simples:

```java
for (Smartphone smartphone : smartphones) {
    System.out.println(smartphone);
}
```

---

# ➕ Inserindo em uma posição específica

Além de adicionar ao final, podemos inserir em qualquer posição.

```java
smartphones.add(0,
        new Smartphone("Xiaomi", "AAA111"));
```

Resultado:

```text
[Xiaomi, Samsung, Apple]
```

Os elementos existentes são deslocados para a direita.

---

# 🔍 Obtendo um elemento

```java
Smartphone smartphone = smartphones.get(0);

System.out.println(smartphone);
```

---

# 📍 Encontrando a posição de um objeto

Podemos utilizar `indexOf()`.

```java
int indice = smartphones.indexOf(s1);

System.out.println(indice);
```

Saída:

```text
0
```

Se o objeto não existir:

```text
-1
```

---

# ⚠️ Dependência do `equals()`

Métodos como:

* `contains()`
* `indexOf()`
* `remove(Object)`

dependem diretamente do método `equals()`.

Exemplo:

```java
Smartphone busca =
        new Smartphone("Samsung", "ABC123");

System.out.println(
        smartphones.contains(busca)
);
```

Se `equals()` não estiver implementado corretamente:

```text
false
```

Mesmo sendo o mesmo smartphone.

---

# 🔄 Removendo elementos

Existem duas formas principais.

### Por índice

```java
smartphones.remove(0);
```

---

### Por objeto

```java
smartphones.remove(s1);
```

Nesse caso, o Java utiliza o método `equals()` para localizar o elemento.

---

# ➕ Adicionando outra coleção

O método `addAll()` permite unir listas.

```java
List<String> turma1 = new ArrayList<>();
turma1.add("Lucas");

List<String> turma2 = new ArrayList<>();
turma2.add("Maria");

turma1.addAll(turma2);
```

Resultado:

```text
[Lucas, Maria]
```

---

# 🧹 Limpando a lista

```java
smartphones.clear();
```

Todos os elementos são removidos.

A lista continua existindo:

```java
System.out.println(smartphones.size());
```

Saída:

```text
0
```

---

# ⚠️ Cuidado ao modificar listas durante a iteração

Modificar uma lista enquanto ela está sendo percorrida pode causar problemas.

Exemplo:

```java
for (String nome : nomes) {
    nomes.remove(nome);
}
```

Pode gerar:

```text
ConcurrentModificationException
```

---

# ❌ Exemplo de loop infinito

```java
for (int i = 0; i < nomes.size(); i++) {

    nomes.add("Novo Nome");
}
```

A lista cresce continuamente e a condição nunca é satisfeita.

---

# ✅ Solução

Guardar o tamanho inicial:

```java
int tamanho = nomes.size();

for (int i = 0; i < tamanho; i++) {

    System.out.println(nomes.get(i));
}
```

---

# 📌 Resumo

| Método            | Descrição                    |
| ----------------- | ---------------------------- |
| `add()`           | Adiciona elemento            |
| `add(index, obj)` | Insere em posição específica |
| `get()`           | Recupera elemento            |
| `contains()`      | Verifica existência          |
| `indexOf()`       | Busca posição                |
| `remove()`        | Remove elemento              |
| `addAll()`        | Junta coleções               |
| `clear()`         | Remove todos os elementos    |

---

# 🔗 Relação entre métodos

```text
contains()
indexOf()
remove(Object)
        │
        ▼
     equals()
```

Sem um `equals()` correto, essas operações podem falhar.

---

# 🎓 Dicas Importantes

* ✅ Sobrescreva `toString()` para facilitar a visualização dos objetos.
* ✅ Sobrescreva `equals()` quando precisar comparar objetos logicamente.
* ✅ Métodos como `contains()` e `indexOf()` dependem do `equals()`.
* ✅ Evite modificar listas durante o `for-each`.
* ✅ Utilize `clear()` para limpar listas sem destruir a referência.
* ✅ O `ArrayList` mantém a ordem de inserção dos elementos.

---

## 💡 Conclusão

A interface `List` é uma das estruturas mais utilizadas no Java. Em aplicações reais, ela raramente armazena apenas tipos simples; normalmente gerencia objetos vindos de bancos de dados, APIs ou regras de negócio.

Por isso, compreender a relação entre `List`, `equals()`, `hashCode()` e `toString()` é essencial para utilizar coleções de forma correta e eficiente.

---
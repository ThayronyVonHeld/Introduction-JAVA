# 📚 Aula 11 - Generics (Genéricos)

---

# 🎯 Objetivos da Aula

* Compreender o que são **Generics**
* Entender por que os Generics foram criados
* Compreender os problemas das coleções sem tipagem
* Entender a **segurança de tipos em tempo de compilação**
* Conhecer o conceito de **Type Erasure**
* Entender o problema das **Raw Types**
* Compreender como os Generics evitam `ClassCastException`

---

# 🧩 O que são Generics?

**Generics** são um recurso da linguagem Java que permite definir **quais tipos de dados uma classe, coleção ou método pode trabalhar**.

Por exemplo:

```java
List<String> nomes = new ArrayList<>();
```

Nesse caso, estamos dizendo:

> Essa lista deve trabalhar exclusivamente com objetos do tipo `String`.

Assim, o próprio compilador consegue impedir operações inválidas antes mesmo do programa ser executado.

---

# 🕰️ Antes dos Generics

Antes do Java 5, as coleções não possuíam a sintaxe de Generics que utilizamos atualmente.

Era comum encontrar código como:

```java
List nomes = new ArrayList();
```

Essa lista poderia receber praticamente qualquer tipo de objeto:

```java
nomes.add("Lucas");
nomes.add(10);
nomes.add(20.5);
nomes.add(new Cliente());
```

O problema é que o Java não tinha uma forma de garantir que todos os elementos possuíam o tipo esperado.

---

# ⚠️ O problema da falta de tipagem

Imagine uma lista que deveria armazenar apenas nomes:

```java
List nomes = new ArrayList();

nomes.add("Lucas");
nomes.add("Maria");
nomes.add(10);
```

Ao recuperar os valores, todos são tratados inicialmente como `Object`.

```java
for (Object nome : nomes) {
    System.out.println(nome);
}
```

Para trabalhar especificamente com `String`, seria necessário realizar conversões:

```java
String nome = (String) objeto;
```

Isso poderia gerar problemas caso o objeto não fosse realmente uma `String`.

---

# 🚨 `ClassCastException`

Considere:

```java
Object objeto = 10;

String nome = (String) objeto;
```

O código compila, mas durante a execução ocorrerá:

```text
ClassCastException
```

Isso acontece porque o objeto armazenado é um `Integer`, e não uma `String`.

Em sistemas maiores, depender constantemente de casts e verificações poderia tornar o código:

* Mais complexo
* Mais verboso
* Mais difícil de manter
* Mais propenso a erros

---

# 💡 A solução: Generics

Os Generics foram introduzidos no **Java 5** justamente para solucionar esse problema.

Agora podemos declarar:

```java
List<String> nomes = new ArrayList<>();
```

E o compilador sabe que essa lista aceita apenas `String`.

```java
nomes.add("Lucas");
nomes.add("Maria");
```

Se tentarmos:

```java
nomes.add(10);
```

O código não será compilado.

O erro é identificado **antes da execução do programa**.

---

# 🛡️ Segurança em Tempo de Compilação

Essa é uma das principais vantagens dos Generics.

Sem Generics:

```java
List lista = new ArrayList();

lista.add("Lucas");
lista.add(10);
```

Com Generics:

```java
List<String> lista = new ArrayList<>();

lista.add("Lucas");
lista.add(10); // Erro de compilação
```

O compilador consegue detectar o problema antecipadamente.

> **Generics transferem muitos erros que antes só seriam descobertos em tempo de execução para o momento da compilação.**

---

# ✨ Diamond Operator `<>`

Nas versões mais antigas, era necessário informar o tipo dos dois lados:

```java
List<String> nomes = new ArrayList<String>();
```

Nas versões modernas do Java, podemos utilizar o **Diamond Operator**:

```java
List<String> nomes = new ArrayList<>();
```

O compilador consegue inferir o tipo a partir do lado esquerdo.

Isso deixa o código mais limpo e legível.

---

# 🔍 O que acontece internamente?

Aqui existe um conceito muito importante:

## `Type Erasure`

Os Generics foram projetados para adicionar segurança de tipos ao Java **sem quebrar a compatibilidade com códigos antigos**.

Por isso, o Java utiliza o mecanismo chamado **Type Erasure** (*apagamento de tipo*).

Durante a compilação:

1. O compilador verifica os tipos utilizados pelos Generics.
2. Garante que as operações são válidas.
3. Gera o bytecode.
4. As informações específicas dos Generics são removidas em determinadas estruturas durante a execução.

Ou seja:

```java
List<String>
```

e

```java
List<Integer>
```

possuem a informação genérica durante a compilação, mas essa informação não funciona da mesma maneira em tempo de execução.

---

# ⚠️ Raw Types

Uma **Raw Type** ocorre quando utilizamos uma classe genérica sem informar seu tipo.

Por exemplo:

```java
List lista = new ArrayList();
```

Em vez de:

```java
List<String> lista = new ArrayList<>();
```

As Raw Types existem principalmente por questões de **compatibilidade com código legado**.

Porém, seu uso deve ser evitado em código moderno.

---

# 💣 O perigo das Raw Types

Podemos criar uma situação problemática:

```java
List<String> nomes = new ArrayList<>();

nomes.add("Lucas");
nomes.add("Maria");
```

Agora imagine que essa lista seja manipulada através de uma Raw Type:

```java
List lista = nomes;

lista.add(10);
```

O compilador permite essa operação porque a variável `lista` não possui informação genérica.

Agora temos:

```text
["Lucas", "Maria", 10]
```

Quando tentarmos tratar todos os elementos como `String`:

```java
for (String nome : nomes) {
    System.out.println(nome);
}
```

poderemos receber:

```text
ClassCastException
```

O problema foi introduzido justamente porque ignoramos a segurança fornecida pelos Generics.

---

# 📌 Por que utilizar Generics?

Generics proporcionam principalmente:

| Benefício          | Descrição                                              |
| ------------------ | ------------------------------------------------------ |
| Segurança de tipos | Impede tipos incompatíveis                             |
| Menos casting      | Reduz conversões manuais                               |
| Código mais limpo  | Torna as APIs mais claras                              |
| Erros antecipados  | Problemas são encontrados na compilação                |
| Reutilização       | Classes e métodos podem trabalhar com diferentes tipos |

---

# 🧠 Um conceito importante

Quando escrevemos:

```java
List<String> nomes;
```

não estamos dizendo que `List` é uma lista de Strings apenas em tempo de execução.

Estamos dizendo ao **compilador**:

> "Quero utilizar esta coleção considerando `String` como seu tipo."

Isso permite que o compilador faça diversas verificações automaticamente.

---

# 📌 Resumo Geral

| Conceito             | Descrição                                                         |
| -------------------- | ----------------------------------------------------------------- |
| `Generics`           | Permitem trabalhar com tipos parametrizados                       |
| `List<String>`       | Lista que trabalha com `String`                                   |
| Segurança de tipos   | Erros de tipos são detectados durante a compilação                |
| `<>`                 | Diamond Operator para inferência do tipo                          |
| `Type Erasure`       | Mecanismo utilizado para manter compatibilidade com código legado |
| `Raw Type`           | Uso de uma classe genérica sem especificar seu tipo               |
| `ClassCastException` | Exceção causada por uma conversão de tipo inválida                |

---

# 🎓 Dicas Importantes

* ✅ Prefira sempre utilizar **Generics** em coleções.
* ✅ Evite **Raw Types** em código moderno.
* ✅ Generics proporcionam **segurança de tipos em tempo de compilação**.
* ✅ Eles reduzem significativamente a necessidade de **casting**.
* ✅ O `<>` permite escrever código mais limpo através da inferência de tipos.
* ✅ O **Type Erasure** existe principalmente para preservar a compatibilidade do Java com versões anteriores.
* ✅ O objetivo principal dos Generics é tornar o código **mais seguro, reutilizável e fácil de manter**.

---

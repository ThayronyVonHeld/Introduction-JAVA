# 📚 Aula 02 - Comparação de Objetos e o método `equals()`

---

# 🎯 Objetivos da Aula

* Entender como o Java compara objetos
* Diferenciar o operador `==` do método `equals()`
* Conhecer o funcionamento do `String Pool`
* Compreender a implementação padrão do `equals()`
* Aprender o contrato do método `equals()`
* Implementar corretamente o `equals()` em classes personalizadas

---

# ⚖️ Comparação de Objetos

No Java, existem **duas formas principais** de comparar objetos:

* **`==`** → compara referências de memória.
* **`equals()`** → compara a igualdade lógica entre os objetos.

Entender essa diferença é fundamental para o funcionamento correto das Collections, especialmente estruturas como `HashSet` e `HashMap`.

---

# 🔵 Operador `==`

O operador `==` verifica se duas variáveis apontam para **o mesmo objeto na memória**.

```java
String nome1 = new String("João");
String nome2 = new String("João");

System.out.println(nome1 == nome2);
```

**Saída**

```
false
```

Embora o conteúdo seja igual, cada `new String()` cria um objeto diferente.

---

# 🟢 Método `equals()`

O método `equals()` compara o **conteúdo lógico** dos objetos.

```java
String nome1 = new String("João");
String nome2 = new String("João");

System.out.println(nome1.equals(nome2));
```

**Saída**

```
true
```

Nesse caso, a classe `String` sobrescreve o método `equals()` para comparar os caracteres da sequência de texto.

---

# 📌 Comparação Visual

### Operador `==`

```text
nome1 ─────► [Objeto A]
nome2 ─────► [Objeto B]

Resultado: false
```

### Método `equals()`

```text
"João"
"João"

Resultado: true
```

---

# 🧩 String Pool

O Java mantém uma área especial de memória chamada **String Pool**, utilizada para reutilizar Strings literais.

```java
String a = "Java";
String b = "Java";

System.out.println(a == b);
```

**Saída**

```
true
```

As duas variáveis apontam para o mesmo objeto.

Já utilizando o operador `new`, novos objetos são criados:

```java
String a = new String("Java");
String b = new String("Java");

System.out.println(a == b);
```

**Saída**

```
false
```

> 💡 O `String Pool` melhora o consumo de memória ao reutilizar Strings literais idênticas.

---

# 🌍 A classe `Object`

Toda classe em Java herda, direta ou indiretamente, da classe `Object`.

Ela fornece diversos métodos importantes, entre eles:

```java
equals()
hashCode()
toString()
clone()
getClass()
```

---

# ⚙️ Implementação padrão do `equals()`

A implementação da classe `Object` compara apenas as referências dos objetos.

```java
public boolean equals(Object obj) {
    return this == obj;
}
```

Ou seja, sem sobrescrita (`@Override`), `equals()` possui praticamente o mesmo comportamento do operador `==`.

---

# 🚨 Quando sobrescrever `equals()`?

Imagine a seguinte classe:

```java
public class Smartphone {

    private String marca;
    private String serialNumber;

}
```

Criando dois objetos:

```java
Smartphone s1 =
        new Smartphone("Samsung", "ABC123");

Smartphone s2 =
        new Smartphone("Samsung", "ABC123");
```

Mesmo representando o mesmo aparelho, o resultado será:

```java
System.out.println(s1.equals(s2));
```

**Saída**

```
false
```

Isso acontece porque o método `equals()` herdado de `Object` compara apenas o endereço de memória.

Para comparar o **número de série**, precisamos sobrescrever esse método.

---

# 🔄 Sobrescrevendo o método `equals()`

No exemplo do `Smartphone`, dois objetos serão considerados iguais quando possuírem o mesmo `serialNumber`.

---

# 📜 Contrato do método `equals()`

Toda implementação deve respeitar cinco regras fundamentais.

| Regra                     | Descrição                                                                                           |
| ------------------------- | --------------------------------------------------------------------------------------------------- |
| **Reflexivo**             | `x.equals(x)` deve retornar `true`.                                                                 |
| **Simétrico**             | Se `x.equals(y)` é `true`, então `y.equals(x)` também deve ser.                                     |
| **Transitivo**            | Se `x.equals(y)` e `y.equals(z)` forem verdadeiros, `x.equals(z)` também deve ser.                  |
| **Consistente**           | O resultado deve permanecer o mesmo enquanto os dados utilizados na comparação não forem alterados. |
| **Comparação com `null`** | `x.equals(null)` deve retornar sempre `false`.                                                      |

---

# 🛠 Estrutura básica do `equals()`

Uma implementação costuma seguir esta sequência:

1. Verificar se é o mesmo objeto.
2. Verificar se o objeto é `null`.
3. Comparar as classes.
4. Fazer o *cast*.
5. Comparar os atributos que definem a igualdade.

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

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        Smartphone other = (Smartphone) obj;

        return serialNumber.equals(other.serialNumber);
    }
}
```

---

# 🔄 Fluxo da implementação

```text
equals(obj)
      │
      ▼
Mesmo objeto?
      │
 Sim ▼ Não
true
      │
      ▼
É null?
      │
 Sim ▼ Não
false
      │
      ▼
Mesma classe?
      │
 Sim ▼ Não
      │  false
      ▼
Cast
      │
      ▼
Comparar atributos
      │
      ▼
Retornar resultado
```

---

# ⚠️ Comparando atributos

Ao comparar atributos que também são objetos, utilize `equals()`.

❌ Incorreto

```java
return serialNumber == other.serialNumber;
```

✅ Correto

```java
return serialNumber.equals(other.serialNumber);
```

---

# 💡 A igualdade depende da regra de negócio

Não existe uma definição universal para igualdade.

Alguns exemplos:

| Classe     | Critério de igualdade |
| ---------- | --------------------- |
| Pessoa     | CPF                   |
| Produto    | Código de barras      |
| Usuário    | ID                    |
| Smartphone | Número de série       |

O desenvolvedor define quais atributos representam a identidade lógica do objeto.

---

# 📌 Resumo

| Conceito               | Descrição                                                             |
| ---------------------- | --------------------------------------------------------------------- |
| `==`                   | Compara referências de memória                                        |
| `equals()`             | Compara igualdade lógica                                              |
| `Object.equals()`      | Implementação padrão baseada em `==`                                  |
| `@Override`            | Permite definir a lógica de igualdade da classe                       |
| `String Pool`          | Reutiliza Strings literais na memória                                 |
| Contrato do `equals()` | Reflexivo, Simétrico, Transitivo, Consistente e comparação com `null` |

---

# 🎓 Dicas Importantes

* ✅ Utilize `==` apenas para tipos primitivos ou quando desejar verificar se duas referências apontam para o mesmo objeto.
* ✅ Para comparar objetos, prefira `equals()`.
* ✅ Sempre sobrescreva `equals()` quando sua classe possuir um critério próprio de igualdade.
* ✅ O método `equals()` trabalha em conjunto com `hashCode()`, assunto que será abordado na próxima aula.
* ✅ Uma implementação incorreta de `equals()` pode causar comportamentos inesperados em coleções como `HashSet` e `HashMap`.

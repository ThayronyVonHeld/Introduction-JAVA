# 📚 Aula 8 - Operadores Ternários, Relacionais e Lógicos

---

## 🎯 Objetivos da Aula
- Dominar o operador ternário para simplificar condições
- Compreender operadores relacionais e suas aplicações
- Aprender a combinar condições com operadores lógicos
- Implementar exemplos práticos com Swing
- Desenvolver soluções inteligentes para problemas reais

---

## ❓ Operador Ternário

### Conceito e Estrutura
O operador ternário permite simplificar comparações que normalmente exigiriam estruturas `if/else` completas.

```java
variável = (expressão) ? valor_se_verdadeiro : valor_se_falso;
```

**As três partes do ternário:**
1. **Expressão** - Condição a ser avaliada (antes do `?`)
2. **Valor verdadeiro** - Retornado se expressão for true (entre `?` e `:`)
3. **Valor falso** - Retornado se expressão for false (após `:`)

### Exemplos Práticos
```java
public class OperadorTernario {
    public static void main(String[] args) {
        int n1 = 10, n2 = 5;
        
        // Exemplo 1: Encontrar maior número
        int maior = (n1 > n2) ? n1 : n2;
        System.out.println("Maior número: " + maior);
        
        // Exemplo 2: Operações matemáticas condicionais
        int resultado = (n1 > n2) ? n1 + n2 : n1 - n2;
        System.out.println("Resultado: " + resultado);
        
        // Exemplo 3: Strings condicionais
        String status = (n1 >= 10) ? "Aprovado" : "Reprovado";
        System.out.println("Status: " + status);
        
        // Exemplo 4: Múltiplas condições
        int idade = 17;
        String categoria = (idade < 12) ? "Criança" : 
                          (idade < 18) ? "Adolescente" : "Adulto";
        System.out.println("Categoria: " + categoria);
    }
}
```

> ⚠️ **Limitação**: O operador ternário é ideal para atribuições simples. Para lógica complexa, use estruturas `if/else`.

---

## 🔄 Operadores Relacionais

### Tabela de Operadores Relacionais

| Operador | Nome | Exemplo | Resultado |
|----------|------|---------|-----------|
| `>` | Maior que | `5 > 3` | `true` |
| `<` | Menor que | `5 < 3` | `false` |
| `>=` | Maior ou igual | `5 >= 5` | `true` |
| `<=` | Menor ou igual | `5 <= 3` | `false` |
| `==` | Igualdade | `5 == 5` | `true` |
| `!=` | Diferença | `5 != 3` | `true` |

### Exemplos com Diferentes Tipos
```java
public class OperadoresRelacionais {
    public static void main(String[] args) {
        // Comparações numéricas
        int a = 10, b = 5;
        System.out.println("a > b: " + (a > b));     // true
        System.out.println("a == b: " + (a == b));   // false
        System.out.println("a != b: " + (a != b));   // true
        
        // Comparações com diferentes tipos
        double x = 10.0;
        System.out.println("a == x: " + (a == x));   // true (10 == 10.0)
        
        // Cuidado com comparação de objetos!
        String nome1 = "Java";
        String nome2 = "Java";
        String nome3 = new String("Java");
        
        System.out.println("nome1 == nome2: " + (nome1 == nome2));     // true
        System.out.println("nome1 == nome3: " + (nome1 == nome3));     // false!
        System.out.println("nome1.equals(nome3): " + nome1.equals(nome3)); // true
    }
}
```

### ⚠️ Comparação de Strings
```java
// ERRADO - compara referências de memória
if (string1 == string2) { ... }

// CORRETO - compara conteúdos
if (string1.equals(string2)) { ... }
```

---

## 🧠 Operadores Lógicos

### Tabela de Operadores Lógicos

| Operador | Nome | Descrição | Exemplo |
|----------|------|-----------|---------|
| `&&` | E lógico | True se AMBAS condições forem true | `(a > b && b > c)` |
| `||` | OU lógico | True se PELO MENOS UMA condição for true | `(a > b || b > c)` |
| `^` | OU exclusivo | True se APENAS UMA condição for true | `(a > b ^ b > c)` |
| `!` | NÃO lógico | Inverte o valor booleano | `!(a > b)` |

### Tabela Verdade
| A | B | A && B | A \|\| B | A ^ B | !A |
|---|----|--------|----------|--------|-----|
| true | true | true | true | false | false |
| true | false | false | true | true | false |
| false | true | false | true | true | true |
| false | false | false | false | false | true |

### Exemplos Práticos
```java
public class OperadoresLogicos {
    public static void main(String[] args) {
        int x = 5, y = 10, z = 15;
        
        // Operador E (&&)
        boolean condicao1 = (x < y) && (y < z);  // true && true = true
        System.out.println("x < y E y < z: " + condicao1);
        
        // Operador OU (||)
        boolean condicao2 = (x > y) || (y < z);  // false || true = true
        System.out.println("x > y OU y < z: " + condicao2);
        
        // Operador OU exclusivo (^)
        boolean condicao3 = (x < y) ^ (y > z);   // true ^ false = true
        System.out.println("x < y OU EXCLUSIVO y > z: " + condicao3);
        
        // Operador NÃO (!)
        boolean condicao4 = !(x == y);           // !false = true
        System.out.println("NÃO (x == y): " + condicao4);
        
        // Combinações complexas
        boolean complexa = (x < y) && (y < z) || (x == 5);
        System.out.println("Combinação complexa: " + complexa);
    }
}
```


---

## 📋 Tabela de Resumo

### Operadores Ternários
| Cenário | Sintaxe | Resultado |
|---------|---------|-----------|
| Maior número | `(a > b) ? a : b` | Retorna o maior |
| Status | `(nota >= 7) ? "Aprovado" : "Reprovado"` | Status baseado em nota |
| Categoria | `(idade < 12) ? "Criança" : "Adulto"` | Categoria por idade |

### Operadores Relacionais
| Operador | Uso Comum | Cuidado Especial |
|----------|-----------|------------------|
| `==` | Números | Não usar com Strings |
| `equals()` | Strings | Sempre usar com objetos |

### Operadores Lógicos
| Combinação | Uso Típico | Resultado |
|------------|------------|-----------|
| `cond1 && cond2` | Validações múltiplas | True se ambas true |
| `cond1 || cond2` | Alternativas | True se alguma true |
| `!cond1` | Inversão | True se cond1 for false |

---

## 🚀 Exercícios Práticos

1. **Calculadora de IMC com Classificação**
    - Use ternário para classificar: Abaixo do peso, Normal, Sobrepeso

2. **Sistema de Notas Escolares**
    - Use operadores lógicos para: Aprovado, Recuperação, Reprovado

3. **Validador de Formulário**
    - Combine múltiplas validações com `&&` e `||`

4. **🗳️ Projeto: Sistema de Votação**

5. **🔧 Projeto: Validador de Senha com Swing**

6. **🎮 Exemplo Prático: Calculadora de Idade com Swing**

---

> 💡 **Dica**: "Os operadores lógicos são como interruptores que controlam o fluxo do seu programa. Pratique criando diferentes combinações até que se tornem naturais. Lembre-se: a clareza do código é tão importante quanto sua funcionalidade!"
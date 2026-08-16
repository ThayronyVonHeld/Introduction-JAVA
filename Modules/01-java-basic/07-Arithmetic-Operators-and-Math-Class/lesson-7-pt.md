# 📚 Aula 7 - Operadores Aritméticos e Classe Math

---

## 🎯 Objetivos da Aula
- Dominar os operadores aritméticos em Java
- Compreender a ordem de precedência dos operadores
- Aprender a usar operadores unários e de atribuição
- Conhecer a classe Math e seus principais métodos
- Trabalhar com arredondamentos e números aleatórios

---

## ➕ Operadores Aritméticos Básicos

### Tabela de Operadores Aritméticos

| Operador | Nome | Exemplo | Resultado |
|----------|------|---------|-----------|
| `+` | Adição | `5 + 2` | `7` |
| `-` | Subtração | `5 - 2` | `3` |
| `*` | Multiplicação | `5 * 2` | `10` |
| `/` | Divisão | `5 / 2` | `2.5` |
| `%` | Resto da Divisão | `5 % 2` | `1` |

> 💡 **Observação**: O operador `+` também serve para concatenação quando usado com Strings.

---

## 🧮 Ordem de Precedência

### Prioridade dos Operadores
```java
public class Precedencia {
    public static void main(String[] args) {
        int n1 = 5, n2 = 3, n3 = 2;
        
        // Sem parênteses
        int resultado1 = n1 + n2 * n3;  // 5 + (3 * 2) = 11
        System.out.println("Sem parênteses: " + resultado1);
        
        // Com parênteses
        int resultado2 = (n1 + n2) * n3;  // (5 + 3) * 2 = 16
        System.out.println("Com parênteses: " + resultado2);
        
        // Cálculo de média
        double media = (n1 + n2 + n3) / 3.0;
        System.out.println("Média: " + media);
    }
}
```

**Ordem de Precedência:**
1. `()` - Parênteses
2. `*`, `/`, `%` - Multiplicação, Divisão, Resto
3. `+`, `-` - Adição, Subtração

---

## 🔄 Operadores Unários

### Incremento e Decremento
```java
public class OperadoresUnarios {
    public static void main(String[] args) {
        int a = 5;
        
        // Pós-incremento
        System.out.println("a: " + a);       // 5
        System.out.println("a++: " + a++);   // 5 (usa depois incrementa)
        System.out.println("a: " + a);       // 6
        
        // Pré-incremento
        int b = 5;
        System.out.println("b: " + b);       // 5
        System.out.println("++b: " + ++b);   // 6 (incrementa depois usa)
        System.out.println("b: " + b);       // 6
        
        // Decremento
        int c = 5;
        System.out.println("c--: " + c--);   // 5
        System.out.println("--c: " + --c);   // 3
    }
}
```

### Diferença Entre Pré e Pós
```java
int x = 5;
int y = x++;  // y = 5, x = 6

int a = 5;
int b = ++a;  // a = 6, b = 6
```

---

## ⚡ Operadores de Atribuição

### Formas Simplificadas
```java
public class OperadoresAtribuicao {
    public static void main(String[] args) {
        int a = 10;
        
        a += 5;   // a = a + 5 → 15
        a -= 3;   // a = a - 3 → 12
        a *= 2;   // a = a * 2 → 24
        a /= 4;   // a = a / 4 → 6
        a %= 4;   // a = a % 4 → 2
        
        System.out.println("Valor final de a: " + a);
    }
}
```

### Tabela de Operadores de Atribuição

| Operador | Equivalente | Exemplo |
|----------|-------------|---------|
| `+=` | `a = a + b` | `a += 5` |
| `-=` | `a = a - b` | `a -= 3` |
| `*=` | `a = a * b` | `a *= 2` |
| `/=` | `a = a / b` | `a /= 4` |
| `%=` | `a = a % b` | `a %= 4` |

---

## 🧊 Classe Math

### Métodos Principais
```java
public class ClasseMath {
    public static void main(String[] args) {
        // Exponenciação
        double potencia = Math.pow(5, 2);    // 25.0
        System.out.println("5² = " + potencia);
        
        // Raiz quadrada
        double raizQuadrada = Math.sqrt(25); // 5.0
        System.out.println("√25 = " + raizQuadrada);
        
        // Raiz cúbica
        double raizCubica = Math.cbrt(27);   // 3.0
        System.out.println("∛27 = " + raizCubica);
        
        // Constante PI
        double areaCirculo = Math.PI * Math.pow(5, 2);
        System.out.println("Área do círculo: " + areaCirculo);
        
        // Valor absoluto
        int absoluto = Math.abs(-10);        // 10
        System.out.println("Valor absoluto: " + absoluto);
    }
}
```

---

## 📊 Arredondamentos

### Métodos de Arredondamento
```java
public class Arredondamentos {
    public static void main(String[] args) {
        double numero = 3.7;
        
        // Arredonda para baixo (floor)
        double paraBaixo = Math.floor(numero);    // 3.0
        System.out.println("Floor: " + paraBaixo);
        
        // Arredonda para cima (ceil)
        double paraCima = Math.ceil(numero);      // 4.0
        System.out.println("Ceil: " + paraCima);
        
        // Arredondamento aritmético (round)
        long arredondado = Math.round(numero);    // 4
        System.out.println("Round: " + arredondado);
        
        // Exemplos com números negativos
        System.out.println("Floor -3.2: " + Math.floor(-3.2)); // -4.0
        System.out.println("Ceil -3.2: " + Math.ceil(-3.2));   // -3.0
    }
}
```

---

## 🎲 Números Aleatórios

### Gerando Números Aleatórios
```java
import java.util.Random;

public class NumerosAleatorios {
    public static void main(String[] args) {
        // Usando Math.random()
        double aleatorio1 = Math.random();  // 0.0 até 0.999...
        System.out.println("Math.random(): " + aleatorio1);
        
        // Gerando entre 0 e 9
        int entre0e9 = (int) (Math.random() * 10);
        System.out.println("Entre 0 e 9: " + entre0e9);
        
        // Gerando entre 5 e 10
        int entre5e10 = 5 + (int) (Math.random() * 6);
        System.out.println("Entre 5 e 10: " + entre5e10);
        
        // Usando classe Random
        Random rand = new Random();
        int entre1e100 = rand.nextInt(100) + 1;
        System.out.println("Entre 1 e 100: " + entre1e100);
    }
}
```

### Fórmulas para Intervalos
```java
// Intervalo [min, max]
int numero = min + (int) (Math.random() * (max - min + 1));

// Exemplo: entre 10 e 20
int exemplo = 10 + (int) (Math.random() * 11); // 10, 11, ..., 20
```

---

## 📋 Tabela de Métodos da Classe Math

| Método | Descrição | Exemplo |
|--------|-----------|---------|
| `Math.pow(a, b)` | Potência (aᵇ) | `Math.pow(2, 3) = 8.0` |
| `Math.sqrt(x)` | Raiz quadrada | `Math.sqrt(16) = 4.0` |
| `Math.cbrt(x)` | Raiz cúbica | `Math.cbrt(27) = 3.0` |
| `Math.abs(x)` | Valor absoluto | `Math.abs(-5) = 5` |
| `Math.floor(x)` | Arredonda para baixo | `Math.floor(3.9) = 3.0` |
| `Math.ceil(x)` | Arredonda para cima | `Math.ceil(3.1) = 4.0` |
| `Math.round(x)` | Arredondamento | `Math.round(3.5) = 4` |
| `Math.max(a, b)` | Maior valor | `Math.max(5, 3) = 5` |
| `Math.min(a, b)` | Menor valor | `Math.min(5, 3) = 3` |
| `Math.random()` | Número aleatório | `0.0 ≤ x < 1.0` |

---

## 🎯 Exercícios Práticos

### Exercício 1: Calculadora de IMC
### Exercício 2: Gerador de Senha
### Exercício 3: Conversor de Temperatura

---

> 💡 **Dica**: "A prática constante com operadores é fundamental. Crie pequenos programas matemáticos diariamente para solidificar seu conhecimento. Lembre-se: a classe Math é sua melhor amiga para cálculos complexos!"
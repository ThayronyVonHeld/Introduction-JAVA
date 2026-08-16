# 📚 Aula 14 - Vetores

---

## 🎯 Objetivos da Aula
- Compreender o conceito de vetores como variáveis compostas unidimensionais
- Aprender a declarar e inicializar vetores em Java
- Dominar o uso de loops com vetores
- Conhecer os métodos úteis da classe Arrays
- Desenvolver programas com manipulação de vetores

---
## 🔍 O que é um Vetor?

Um **vetor** é uma **variável composta unidimensional**, capaz de armazenar **vários valores do mesmo tipo** em posições diferentes da memória.

📦 **Analogia:**
Pense em um vetor como uma **gaveteira**, onde cada gaveta tem uma **posição (índice)** e guarda um **valor**.

---
```
n [3][5][8][2]
   0  1  2  3
```

- **Posição 0** → valor 3
- **Posição 1** → valor 5
- **Posição 2** → valor 8
- **Posição 3** → valor 2

---

## 💡 Representação em Pseudocódigo

```
var
    n: vetor [0..3] de inteiro

inicio
    n[0] <- 3
    n[1] <- 5
    n[2] <- 8
    n[3] <- 2
fimalgoritmo
```
Cada número à direita representa o **índice** (posição) do vetor.
Ou seja: `n[0] = 3`, `n[1] = 5` e assim por diante.

---

## 💻 Implementação em Java

```java
int n[] = new int[4];
n[0] = 3;
n[1] = 5;
n[2] = 8;
n[3] = 2;
```

➡️ Em Java, o vetor é um **objeto**, por isso usamos `new`.

### ✅ Forma Simplificada

Se já souber os valores:

```java
int n[] = {3, 5, 8, 2};
```

---

## 🧩 Exemplo Prático

```java
public class Vetor01 {
    public static void main(String[] args) {
        int n[] = {3, 2, 8, 7, 5, 4};

        for (int i = 0; i <= 5; i++) {
            System.out.println("Na posição " + i + " temos o valor " + n[i]);
        }
    }
}
```

### 🧠 Saída Esperada

```
Na posição 0 temos o valor 3
Na posição 1 temos o valor 2
Na posição 2 temos o valor 8
Na posição 3 temos o valor 7
Na posição 4 temos o valor 5
Na posição 5 temos o valor 4
```
---
## 📏 Propriedade Length

### O que é?
Todo vetor em Java possui a propriedade `length` que retorna o **tamanho total** do vetor.

### Exemplo com Length
```java
public class VetorComLength {
    public static void main(String[] args) {
        int n[] = {3, 2, 8, 7, 5, 4};
        
        System.out.println("Total de casas de N: " + n.length);
        
        for(int i = 0; i < n.length; i++) {
            System.out.println("Na posição " + i + " temos o valor " + n[i]);
        }
    }
}
```

### 🧠 Saída

```
Total de casas de N: 6
Na posição 0 temos o valor 3
Na posição 1 temos o valor 2
Na posição 2 temos o valor 8
Na posição 3 temos o valor 7
Na posição 4 temos o valor 5
Na posição 5 temos o valor 4
```



### ✅ Vantagens do Length:
- **Código mais seguro** - evita erros de índice
- **Manutenção fácil** - funciona mesmo se o vetor mudar de tamanho
- **Mais legível** - intenção clara do código

---

## ⚙️ Laço For-Each (ou “Para Cada”)

O **for-each** simplifica a leitura dos vetores, percorrendo automaticamente todos os elementos.


### Sintaxe Simplificada para Vetores
```java
for(tipo elemento : vetor) {
    // processa elemento
}
```

### Comparação: For Tradicional vs For-Each

#### For Tradicional:
```java
int num[] = {3, 5, 8, 4};
for(int i = 0; i < num.length; i++) {
    System.out.print(num[i] + " ");
}
// Saída: 3 5 8 4
```

#### For-Each:
```java
int num[] = {3, 5, 8, 4};
for(int valor : num) {
    System.out.print(valor + " ");
}
// Saída: 3 5 8 4
```

### Exemplo Prático com For-Each
```java
public class VetorForEach {
    public static void main(String[] args) {
        double v[] = {3.5, 2.75, 9.0, -4.5};
        
        for(double valor : v) {
            System.out.print(valor + " ");
        }
    }
}
// Saída: 3.5 2.75 9.0 -4.5
```

---

## 🧰 Classe Arrays - Métodos Úteis


Java possui a classe `Arrays`, que contém diversos **métodos utilitários**.

### 🧩 Exemplo – Ordenação com Arrays.sort()

```java
import java.util.Arrays;

public class Vetor01 {
    public static void main(String[] args) {
        int num[] = {3, 5, 8, 4};
        Arrays.sort(num);

        for (int valor : num) {
            System.out.print(valor + "  ");
        }
    }
}
```

### 🧠 Saída:

```
3  4  5  8
```



## 🔍Busca com Arrays.binarySearch()

### Buscando um Valor no Vetor
```java
import java.util.Arrays;

public class BuscaVetor {
    public static void main(String[] args) {
        int vet[] = {3, 7, 6, 1, 9, 4, 2};
        
        // Mostra o vetor original
        for(int v : vet) {
            System.out.print(v + "  ");
        }
        System.out.println(" ");
        
        // Busca o valor 1
        int posicao = Arrays.binarySearch(vet, 1);
        System.out.println("Encontrei o valor na posição " + posicao);
    }
}
```

### ⚠️ Importante:
- O vetor **deve estar ordenado** para `binarySearch()` funcionar corretamente
- Retorna a **posição** do elemento se encontrado
- Retorna um **valor negativo** se não encontrado


## 🎯 Exemplo Completo: Busca com Ordenação

```java
import java.util.Arrays;

public class BuscaOrdenada {
    public static void main(String[] args) {
        int vet[] = {3, 7, 6, 1, 9, 4, 2};
        
        System.out.print("Vetor original: ");
        for(int v : vet) {
            System.out.print(v + " ");
        }
        
        // Ordena o vetor
        Arrays.sort(vet);
        
        System.out.print("\nVetor ordenado: ");
        for(int v : vet) {
            System.out.print(v + " ");
        }
        
        // Busca o valor 7
        int pos = Arrays.binarySearch(vet, 7);
        System.out.println("\nO valor 7 está na posição: " + pos);
    }
}
```
---
## 🧱 Preenchendo Vetores com `fill()`

Podemos preencher **automaticamente** um vetor com um valor fixo usando `Arrays.fill()`.

### Preenchendo um Vetor com Valor Padrão
```java
import java.util.Arrays;

public class PreenchimentoVetor {
    public static void main(String[] args) {
        int v[] = new int[20];  // Vetor com 20 posições
        
        Arrays.fill(v, 0);  // Preenche todo o vetor com 0
        
        for(int valor : v) {
            System.out.print(valor + " ");
        }
    }
}
// Saída: 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
```

### Preenchimento Parcial
```java
import java.util.Arrays;

public class PreenchimentoParcial {
    public static void main(String[] args) {
        int v[] = new int[10];
        
        // Preenche apenas as posições 2 a 6 com o valor 5
        Arrays.fill(v, 2, 7, 5);
        
        for(int valor : v) {
            System.out.print(valor + " ");
        }
    }
}
// Saída: 0 0 5 5 5 5 5 0 0 0
```

---

## 📋 Tabela de Métodos da Classe Arrays

| Método | Descrição | Exemplo |
|--------|-----------|---------|
| `Arrays.sort(vetor)` | Ordena o vetor | `Arrays.sort(numeros)` |
| `Arrays.binarySearch(vetor, valor)` | Busca valor no vetor | `Arrays.binarySearch(numeros, 5)` |
| `Arrays.fill(vetor, valor)` | Preenche todo vetor | `Arrays.fill(vetor, 0)` |
| `Arrays.fill(vetor, inicio, fim, valor)` | Preenche intervalo | `Arrays.fill(vetor, 2, 5, 10)` |

---
## 🎮 Exemplo Prático: Sistema de Notas

```java
import java.util.Arrays;
import java.util.Scanner;

public class SistemaNotas {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Quantas notas deseja cadastrar? ");
        int quantidade = teclado.nextInt();
        
        double notas[] = new double[quantidade];
        double soma = 0;
        
        // Entrada das notas
        for(int i = 0; i < notas.length; i++) {
            System.out.print("Digite a nota " + (i + 1) + ": ");
            notas[i] = teclado.nextDouble();
            soma += notas[i];
        }
        
        // Ordena as notas
        Arrays.sort(notas);
        
        // Exibe resultados
        System.out.println("\n=== RESULTADOS ===");
        System.out.print("Notas ordenadas: ");
        for(double nota : notas) {
            System.out.print(nota + " ");
        }
        
        System.out.println("\nMaior nota: " + notas[notas.length - 1]);
        System.out.println("Menor nota: " + notas[0]);
        System.out.println("Média: " + (soma / notas.length));
        
        teclado.close();
    }
}
```

---


## 🚀 Exercícios Práticos

### Exercício 1: Vetor Invertido
```java
// Crie um vetor e exiba seus elementos na ordem inversa
```

### Exercício 2: Contador de Pares e Ímpares
```java
// Conte quantos números pares e ímpares existem em um vetor
```

### Exercício 3: Busca por Valor
```java
// Peça um número ao usuário e verifique se existe no vetor
```

### Exercício 4: Estatísticas de Vetor
```java
// Calcule média, maior e menor valor de um vetor de números
```

---

## ✅ Checklist de Aprendizagem

- [ ] Compreendo o conceito de vetores como variáveis compostas
- [ ] Sei declarar e inicializar vetores em Java
- [ ] Domino o uso de for tradicional com vetores
- [ ] Sei usar for-each para percorrer vetores
- [ ] Conheço e uso a propriedade length
- [ ] Aplico métodos da classe Arrays: sort, binarySearch, fill
- [ ] Consigo criar programas que manipulam vetores


---

> 💡 **Dica**: Pratique criando diferentes tipos de vetores e experimentando todos os métodos. Use System.out.println() para verificar o estado do seu vetor a cada operação. A manipulação de vetores é fundamental para trabalhar com coleções de dados em Java!
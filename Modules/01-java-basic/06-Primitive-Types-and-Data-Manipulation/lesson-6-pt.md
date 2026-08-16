# 📚 Aula 6 - Tipos Primitivos e Manipulação de Dados

---

## 🎯 Objetivos da Aula
- Compreender os diferentes tipos de comentários em Java
- Dominar os tipos primitivos e suas declarações
- Aprender a trabalhar com entrada e saída de dados
- Entender conversões entre tipos (Typecast e Wrapper Classes)
- Criar uma aplicação Swing com manipulação de dados

---

## 💬 Comentários em Java

Comentários são essenciais para documentar código e facilitar a manutenção. Java oferece três tipos principais:

### 1. Comentário de Linha Única
```java
// Este é um comentário de linha única
int idade = 25; // Comentário após o código
```

### 2. Comentário de Múltiplas Linhas
```java
/*
 * Este é um comentário
 * que ocupa várias linhas
 * muito útil para explicações longas
 */
```

### 3. Comentário de Documentação (Javadoc)
```java
/**
 * Classe Main do Sistema
 * @author Thayrony
 * @version 14.2
 * @since 2025
 */
```

> 📖 **Documentação Oficial**: [Java Documentation Tool](https://docs.oracle.com/javase/8/docs/technotes/tools/windows/javadoc.html)

---

## 🔢 Tipos Primitivos em Java

Java é uma linguagem **fortemente tipada** - ou seja, cada variável precisa ter um tipo bem definido.

### Três Formas de Declarar Variáveis

#### 1. Declaração Simples
```java
int idade = 3;
```

#### 2. Usando Typecast
```java
int idade = (int) 3;
```

#### 3. Usando Wrapper Classes
```java
Integer idade = new Integer(3);
```

---

## 📊 Tabela de Tipos Primitivos

| Tipo Primitivo | Wrapper Class | Tamanho | Exemplo |
|----------------|---------------|---------|---------|
| `byte` | `Byte` | 1 byte | `byte b = 127;` |
| `short` | `Short` | 2 bytes | `short s = 32000;` |
| `int` | `Integer` | 4 bytes | `int i = 2147483647;` |
| `long` | `Long` | 8 bytes | `long l = 9223372036854775807L;` |
| `float` | `Float` | 4 bytes | `float f = 3.14f;` |
| `double` | `Double` | 8 bytes | `double d = 3.14159265359;` |
| `char` | `Character` | 2 bytes | `char c = 'A';` |
| `boolean` | `Boolean` | 1 bit | `boolean flag = true;` |

---

## 🎯 Exemplos Práticos de Declaração

### Números Inteiros
```java
// Três formas de declarar inteiros
int idade1 = 25;                    // Forma simples
int idade2 = (int) 25;              // Com typecast
Integer idade3 = new Integer(25);   // Com wrapper class
```

### Números Reais (Float)
```java
// Três formas de declarar float
float salario1 = 1825.54f;          // Com 'f' no final
float salario2 = (float) 1825.54;   // Com typecast
Float salario3 = new Float(1825.54); // Com wrapper class
```

### Caracteres
```java
// Três formas de declarar char
char letra1 = 'G';                   // Forma simples
char letra2 = (char) 'G';            // Com typecast
Character letra3 = new Character('G'); // Com wrapper class
```

### Booleanos
```java
// Três formas de declarar boolean
boolean casado1 = true;              // Forma simples
boolean casado2 = (boolean) true;    // Com typecast
Boolean casado3 = new Boolean(true); // Com wrapper class
```

---

## 🖨️ Saída de Dados

### Métodos de Impressão

```java
public class ExemploSaida {
    public static void main(String[] args) {
        String nome = "Thayrony";
        float nota = 8.5f;
        
        // System.out.print() - sem quebra de linha
        System.out.print("Nota: " + nota);
        
        // System.out.println() - com quebra de linha
        System.out.println("Nome: " + nome);
        
        // System.out.printf() - formatação
        System.out.printf("%s sua nota é: %.2f\n", nome, nota);
        
        // System.out.format() - similar ao printf
        System.out.format("Nota formatada: %.1f", nota);
    }
}
```

**Saída:**
```
Nota: 8.5Nome: Thayrony
Thayrony sua nota é: 8.50
Nota formatada: 8.5
```

---

## ⌨️ Entrada de Dados com Scanner

### Importação e Configuração
```java
import java.util.Scanner;

public class EntradaDados {
    public static void main(String[] args) {
        // Criando objeto Scanner
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Digite seu nome: ");
        String nome = teclado.nextLine();
        
        System.out.print("Digite sua idade: ");
        int idade = teclado.nextInt();
        
        System.out.print("Digite seu salário: ");
        float salario = teclado.nextFloat();
        
        System.out.printf("Olá %s, você tem %d anos e ganha R$ %.2f", 
                         nome, idade, salario);
        
        teclado.close(); // Fechar o scanner
    }
}
```

### Métodos do Scanner
- `nextLine()` - Lê uma linha completa (String)
- `nextInt()` - Lê um número inteiro
- `nextFloat()` - Lê um número float
- `nextDouble()` - Lê um número double
- `nextBoolean()` - Lê um boolean

---

## 🔄 Conversão entre Tipos

### Incompatibilidade de Tipos
```java
int idade = 30;
// String valor = idade; // ERRO! Tipos incompatíveis
```

### Conversões Corretas

#### De Primitivo para String
```java
int idade = 30;
String valor1 = Integer.toString(idade);      // Usando wrapper class
String valor2 = String.valueOf(idade);        // Usando String.valueOf()
```

#### De String para Primitivo
```java
String texto = "30";
int numero1 = Integer.parseInt(texto);        // Para inteiro
float numero2 = Float.parseFloat("30.5");     // Para float
double numero3 = Double.parseDouble("30.75"); // Para double
```

#### Exemplo Completo
```java
public class ConversaoTipos {
    public static void main(String[] args) {
        // Inteiro para String
        int idade = 30;
        String textoIdade = Integer.toString(idade);
        System.out.println("Idade como texto: " + textoIdade);
        
        // String para Inteiro
        String valor = "25";
        int numero = Integer.parseInt(valor);
        System.out.println("Número: " + numero);
        
        // Float para String e vice-versa
        String salarioTexto = "1825.54";
        float salario = Float.parseFloat(salarioTexto);
        System.out.printf("Salário: R$ %.2f", salario);
    }
}
```

---

## 🧮 Projeto Prático: Calculadora Swing

### Criando a Interface Gráfica

#### Passo a Passo no NetBeans:
1. **Ctrl + Shift + N** → New Project
2. **Java with Ant** → **Java Application**
3. Nome: `CalculadoraSwing`
4. **New** → **JFrame Form** → `Calculadora`

#### Elementos da Interface:
- **TextField** → `txtN1` (texto vazio)
- **TextField** → `txtN2` (texto vazio)
- **Label** → `"+"` (sinal de adição)
- **Button** → `btnSoma` (text: "=")
- **Label** → `lblResultado` (text: "0")

### Código do Botão Soma

```java
private void btnSomaActionPerformed(java.awt.event.ActionEvent evt) {
    // Converter TextField (String) para int
    int n1 = Integer.parseInt(txtN1.getText());
    int n2 = Integer.parseInt(txtN2.getText());
    
    // Realizar a soma
    int soma = n1 + n2;
    
    // Converter resultado para String e exibir
    lblResultado.setText(Integer.toString(soma));
}
```

### Código Completo da Calculadora

```java
public class Calculadora extends javax.swing.JFrame {

    private void btnSomaActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            // Obter valores dos campos de texto
            int n1 = Integer.parseInt(txtN1.getText());
            int n2 = Integer.parseInt(txtN2.getText());
            
            // Calcular soma
            int resultado = n1 + n2;
            
            // Exibir resultado
            lblResultado.setText(String.valueOf(resultado));
            
        } catch (NumberFormatException e) {
            lblResultado.setText("Erro: Digite números válidos!");
        }
    }
    
    // Variáveis de componentes
    private javax.swing.JButton btnSoma;
    private javax.swing.JLabel lblResultado;
    private javax.swing.JTextField txtN1;
    private javax.swing.JTextField txtN2;
}
```

---

## 🛡️ Tratamento de Erros

### Evitando NumberFormatException
```java
private void btnSomaActionPerformed(java.awt.event.ActionEvent evt) {
    try {
        int n1 = Integer.parseInt(txtN1.getText());
        int n2 = Integer.parseInt(txtN2.getText());
        int soma = n1 + n2;
        lblResultado.setText(Integer.toString(soma));
        
    } catch (NumberFormatException e) {
        lblResultado.setText("Erro: Digite apenas números!");
    }
}
```

---

## 📋 Checklist de Aprendizagem

- [ ] Compreendi os três tipos de comentários em Java
- [ ] Aprendi a declarar variáveis das três formas diferentes
- [ ] Conheço todos os tipos primitivos e suas wrapper classes
- [ ] Sei trabalhar com entrada e saída de dados
- [ ] Entendo como converter entre tipos diferentes
- [ ] Criei uma calculadora funcional com Swing
- [ ] Aprendi a tratar erros de conversão

---

## 🎓 Resumo dos Conceitos

| Conceito | Exemplo | Descrição |
|----------|---------|-----------|
| **Comentário** | `// texto` | Documentação do código |
| **Typecast** | `(int) 3.14` | Conversão explícita de tipos |
| **Wrapper Class** | `Integer.valueOf()` | Classes que envolvem tipos primitivos |
| **Scanner** | `nextInt()` | Entrada de dados do usuário |
| **printf** | `%.2f` | Formatação de saída |
| **parseInt** | `Integer.parseInt()` | String para inteiro |

---

## 🚀 Exercícios Práticos

1. **Calculadora Avançada**: Adicione operações de subtração, multiplicação e divisão
2. **Conversor de Temperatura**: Converta Celsius para Fahrenheit
3. **Validador de Idade**: Verifique se usuário é maior de idade
4. **Calculadora IMC**: Calcule Índice de Massa Corporal

---

## 🔍 Dicas Importantes

- Sempre feche o `Scanner` com `.close()`
- Use `try-catch` para evitar `NumberFormatException`
- Prefira `Integer.valueOf()` em vez de `new Integer()`
- Use `printf` para formatação profissional de saída
- Documente seu código com Javadoc para projetos reais


---

> 💡 **Dica**: "A prática consistente é a chave para dominar os tipos de dados. Experimente criar pequenos programas todos os dias para fixar o conhecimento!"
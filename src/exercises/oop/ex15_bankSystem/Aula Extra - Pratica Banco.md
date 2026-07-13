
# 🏦 Sistema de Conta Bancária – Exercício do Curso em Vídeo

Este projeto executa um exercício proposto pelo **Curso em Vídeo**, cujo objetivo é simular a abertura e o gerenciamento de contas bancárias utilizando conceitos fundamentais de **Programação Orientada a Objetos (POO)** em Java.

---

## 📘 Objetivo do Exercício

Criar duas contas bancárias:

* **Conta Corrente (CC)** — Pessoa 1
* **Conta Poupança (CP)** — Pessoa 2

Após a abertura das contas, cada pessoa deve ser capaz de:

* Depositar dinheiro
* Sacar dinheiro
* Pagar mensalidade
* Fechar a conta (seguindo regras específicas)

---

## 🧠 Conceitos Envolvidos

Antes de criar uma classe, precisamos entender que **todo objeto** é formado por:

* **Atributos** → dados internos do objeto
* **Métodos** → ações, comportamentos e operações que o objeto pode executar
* **Estado** → condição atual do objeto (ex.: conta aberta ou fechada)

O exercício reforça exatamente essas bases da POO.

---

# 🧩 Estrutura da Classe `ContaBanco`

## 🔑 **Atributos**

| Atributo   | Acesso        | Função                                                |
| ---------- | ------------- | ----------------------------------------------------- |
| `numConta` | público (+)   | Número da conta                                       |
| `tipo`     | protegido (#) | Tipo da conta: **CC** (corrente) ou **CP** (poupança) |
| `dono`     | privado (-)   | Nome do titular                                       |
| `saldo`    | privado (-)   | Saldo disponível                                      |
| `status`   | privado (-)   | Informa se a conta está aberta ou não                 |

---

## ⚙️ **Métodos**

| Método          | Função                                            |
| --------------- | ------------------------------------------------- |
| `abrirConta()`  | Abre uma nova conta e aplica bônus inicial        |
| `fecharConta()` | Fecha a conta, desde que o saldo seja **zero**    |
| `depositar()`   | Deposita valores, desde que a conta esteja aberta |
| `sacar()`       | Realiza saques, verificando saldo e status        |
| `pagarMensal()` | Deduz mensalidade (R$ 12 para CC, R$ 20 para CP)  |

---

## 🎁 Bônus ao Abrir Conta

* **Conta Corrente (CC)**: recebe **R$ 50**
* **Conta Poupança (CP)**: recebe **R$ 150**

---

## 🛠️ Getters e Setters

O exercício exige o uso de **getters e setters para todos os atributos**, garantindo encapsulamento e controle total sobre leitura e escrita dos dados.

Exemplos:

* `getNumConta()`
* `setNumConta()`
* `getTipo()`
* `setTipo()`
* *(e assim por diante para todos os atributos)*

---

## 🏗️ Construtor da Classe

Sempre que uma nova conta for criada, ela deve começar com:

* `status = false` (conta fechada)
* `saldo = 0`

Isso reflete o estado inicial realista de uma conta ainda não ativada.

---

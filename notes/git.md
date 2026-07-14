# 📚 Guia Rápido do Git

Este guia reúne os comandos mais utilizados do Git para o dia a dia de desenvolvimento, servindo como uma consulta rápida sem entrar em conceitos avançados.

## Índice

- [Conceitos Básicos](#-conceitos-básicos)
- [Configuração Inicial](#️-configuração-inicial)
- [Criando ou Clonando um Repositório](#-criando-ou-clonando-um-repositório)
- [Verificando o Estado do Projeto](#-verificando-o-estado-do-projeto)
- [Adicionando Arquivos](#-adicionando-arquivos)
- [Criando Commits](#-criando-commits)
- [Trabalhando com Branches](#-trabalhando-com-branches)
- [Mesclando Branches](#-mesclando-branches)
- [Trabalhando com o GitHub](#️-trabalhando-com-o-github)
- [Desfazendo Alterações](#️-desfazendo-alterações)
- [Salvando Alterações Temporariamente](#-salvando-alterações-temporariamente)
- [Tags](#-tags)
- [Fluxo Básico de Trabalho](#-fluxo-básico-de-trabalho)
- [Fluxo com Branches](#-fluxo-com-branches)
- [Erros Comuns e Soluções](#-erros-comuns-e-soluções)
- [Comandos que Sempre Esquecemos](#-comandos-que-sempre-esquecemos)
- [Tabela Resumo](#-tabela-resumo)
- [Boas Práticas](#-boas-práticas)
- [Links Úteis](#-links-úteis)

---

## 📖 Conceitos Básicos

| Termo | Significado |
|-------|-------------|
| **Working Directory** | Sua pasta de trabalho com os arquivos do projeto |
| **Stage (Index)** | Área de preparação onde os arquivos ficam antes do commit |
| **Commit** | Um snapshot (fotografia) do projeto em um determinado momento |
| **Branch** | Uma linha de desenvolvimento independente |
| **Remote** | Repositório hospedado em servidores como GitHub, GitLab etc. |

```
    Working Directory
           │
        git add
           ▼
       Stage (Index)
           │
       git commit
           ▼
       Repositório Local
           │
        git push
           ▼
      GitHub / Remote
```

---

## ⚙️ Configuração Inicial

| Comando | Descrição |
|---------|-----------|
| `git config --global user.name "Seu Nome"` | Define seu nome para os commits |
| `git config --global user.email "seu@email.com"` | Define seu e-mail para os commits |
| `git config --list` | Exibe todas as configurações atuais do Git |

---

## 📂 Criando ou Clonando um Repositório

| Comando | Descrição |
|---------|-----------|
| `git init` | Inicializa um novo repositório Git na pasta atual |
| `git clone <url>` | Clona um repositório remoto para sua máquina |

**Exemplo:**
```bash
git clone https://github.com/usuario/repositorio.git
```

---

## 🔍 Verificando o Estado do Projeto

| Comando | Descrição |
|---------|-----------|
| `git status` | Mostra o estado atual dos arquivos (modificados, novos etc.) |
| `git log` | Exibe o histórico completo de commits |
| `git log --oneline` | Exibe o histórico de forma resumida (uma linha por commit) |
| `git log --graph --oneline --all` | Mostra o histórico em formato de árvore visual |
| `git diff` | Mostra as alterações que ainda não estão no stage |
| `git diff --staged` | Mostra as alterações que já estão no stage |

---

## ➕ Adicionando Arquivos

| Comando | Descrição |
|---------|-----------|
| `git add <arquivo>` | Adiciona um arquivo específico ao stage |
| `git add .` | Adiciona todas as alterações ao stage |
| `git restore --staged <arquivo>` | Remove um arquivo do stage sem desfazer as alterações |

---

## 💾 Criando Commits

| Comando | Descrição |
|---------|-----------|
| `git commit -m "mensagem"` | Cria um commit com a mensagem especificada |
| `git commit --amend` | Edita o último commit (mensagem ou conteúdo) |

---

## 🌿 Trabalhando com Branches

| Comando | Descrição |
|---------|-----------|
| `git branch` | Lista as branches locais |
| `git branch -a` | Lista todas as branches (locais e remotas) |
| `git branch <nome>` | Cria uma nova branch |
| `git switch <nome>` | Troca para outra branch (comando moderno) |
| `git switch -c <nome>` | Cria e já muda para a nova branch |
| `git checkout <nome>` | Forma antiga de trocar de branch (ainda funciona) |
| `git branch -d <nome>` | Remove uma branch local |

---

## 🔀 Mesclando Branches

| Comando | Descrição |
|---------|-----------|
| `git merge <branch>` | Mescla a branch especificada na branch atual |
| `git rebase <branch>` | Reaplica os commits da branch atual sobre outra branch |

> 💡 **Dica:** Prefira `git pull --rebase` ao invés de `git pull` simples para manter um histórico mais limpo.

---

## ☁️ Trabalhando com o GitHub

| Comando | Descrição |
|---------|-----------|
| `git remote -v` | Lista os repositórios remotos configurados |
| `git remote add origin <url>` | Adiciona um repositório remoto |
| `git push origin <branch>` | Envia os commits para o GitHub |
| `git push -u origin <branch>` | Envia a branch e define o upstream (remoto padrão) |
| `git pull origin <branch>` | Baixa e mescla as alterações do remoto |
| `git pull --rebase origin <branch>` | Baixa e reaplica seus commits sobre as alterações remotas |
| `git fetch` | Baixa as atualizações do remoto sem fazer merge |
| `git fetch --all` | Atualiza todas as referências remotas de uma vez |

---

## ↩️ Desfazendo Alterações

| Comando | Descrição |
|---------|-----------|
| `git restore <arquivo>` | Descarta as alterações de um arquivo específico |
| `git restore .` | Descarta todas as alterações não commitadas |
| `git reset --soft HEAD~1` | Desfaz o último commit, mantendo as alterações no stage |
| `git reset --mixed HEAD~1` | Desfaz o último commit e remove os arquivos do stage (padrão) |
| `git reset --hard HEAD~1` | Remove o último commit e todas as alterações definitivamente |
| `git reflog` | Mostra o histórico de todas as ações do Git (útil para recuperar commits) |

> ⚠️ **Atenção:** `git reset --hard` remove alterações permanentemente. Utilize apenas quando tiver certeza absoluta do que está fazendo.

---

## 📦 Salvando Alterações Temporariamente

| Comando | Descrição |
|---------|-----------|
| `git stash` | Guarda temporariamente as alterações não commitadas |
| `git stash list` | Lista todos os stashes salvos |
| `git stash pop` | Recupera o último stash e o remove da lista |
| `git stash apply` | Recupera o último stash mantendo-o na lista |

---

## 🏷️ Tags

| Comando | Descrição |
|---------|-----------|
| `git tag` | Lista as tags existentes |
| `git tag <nome>` | Cria uma nova tag |
| `git push origin <tag>` | Envia uma tag específica para o remoto |
| `git push --tags` | Envia todas as tags de uma vez |

---

## 🚀 Fluxo Básico de Trabalho

O ciclo mais comum de uso do Git no dia a dia:

```
  Editar arquivos
        │
        ▼
  git status
        │
        ▼
  git add .
        │
        ▼
  git commit -m "Descrição"
        │
        ▼
  git pull --rebase
        │
        ▼
  Resolver conflitos (se houver)
        │
        ▼
  git push
```

**Em código:**
```bash
# Verificar o que foi alterado
git status

# Adicionar todas as alterações
git add .

# Criar um commit com mensagem descritiva
git commit -m "Descrição clara das alterações"

# Atualizar com as alterações remotas (usando rebase)
git pull --rebase origin main

# Enviar suas alterações
git push origin main
```

---

## 🌳 Fluxo com Branches (Recomendado)

Trabalhar com branches é a forma mais segura e profissional de desenvolver:

```bash
# 1. Atualizar a branch principal
git switch main
git pull origin main

# 2. Criar uma nova branch para sua funcionalidade
git switch -c feature/login

# 3. Fazer as alterações necessárias...

# 4. Adicionar e commitar
git add .
git commit -m "Implementa tela de login"

# 5. Enviar a branch para o GitHub
git push -u origin feature/login
```

Depois, basta abrir um **Pull Request** no GitHub para revisar e integrar as alterações à branch principal.

---

## ⚠️ Erros Comuns e Soluções

| Problema | Solução |
|----------|---------|
| Fiz um commit com a mensagem errada | `git commit --amend` |
| Adicionei um arquivo ao stage sem querer | `git restore --staged <arquivo>` |
| Fiz alterações que não queria | `git restore <arquivo>` |
| Preciso trocar de branch mas não terminei o trabalho | `git stash` |
| Apaguei um commit por engano | `git reflog` (encontre o hash e use `git checkout <hash>`) |
| Deu conflito no merge/pull | Resolva manualmente os arquivos, depois `git add` e `git commit` |
| Esqueci de criar uma branch e commitei na main | `git branch nova-branch` e depois `git reset HEAD~1` na main |

---

## 🧠 Comandos que Sempre Esquecemos

| Comando | Para que serve |
|---------|----------------|
| `git branch -a` | Ver todas as branches (locais e remotas) |
| `git fetch --all` | Atualizar todas as referências remotas |
| `git log --graph --oneline --all` | Visualizar o histórico em formato de árvore |
| `git reflog` | Ver o histórico completo de ações (recupera commits "perdidos") |
| `git remote -v` | Confirmar qual repositório remoto está configurado |

---

## 📋 Tabela Resumo

| Quero... | Comando |
|----------|---------|
| Ver alterações | `git status` |
| Adicionar arquivos | `git add .` |
| Criar commit | `git commit -m "mensagem"` |
| Atualizar projeto | `git pull --rebase` |
| Enviar alterações | `git push` |
| Criar branch | `git switch -c nome` |
| Trocar de branch | `git switch nome` |
| Mesclar branch | `git merge nome` |
| Guardar alterações | `git stash` |
| Recuperar stash | `git stash pop` |
| Ver histórico | `git log --oneline` |
| Desfazer alteração | `git restore arquivo` |

---

## 💡 Boas Práticas

- ✅ Faça commits pequenos e frequentes
- ✅ Escreva mensagens de commit claras e descritivas
- ✅ Sempre execute `git pull` antes de enviar novas alterações
- ✅ Evite trabalhar diretamente na branch `main`
- ✅ Utilize branches separadas para cada funcionalidade ou correção
- ✅ Revise seu próprio código antes de abrir um Pull Request
- ⚠️ Nunca utilize `git push --force` em branches compartilhadas
- ✅ Configure um arquivo `.gitignore` adequado para seu projeto
- ✅ Mantenha commits atômicos (cada commit resolve um único problema)

---

## 🔗 Links Úteis

- [Documentação Oficial do Git](https://git-scm.com/doc)
- [Guia Interativo: Learn Git Branching](https://learngitbranching.js.org/)
- [GitHub Skills](https://skills.github.com/)
- [Conventional Commits](https://www.conventionalcommits.org/) - Padrão para mensagens de commit

---

> 💡 **Dica Final:** O Git é uma ferramenta poderosa. Não tenha medo de explorar, mas sempre trabalhe em branches separadas e mantenha backups do seu código. Na dúvida, `git reflog` é seu melhor amigo!
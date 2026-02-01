# 🛠️ Micro Sistema Utilitário em Java

Este projeto é um **micro sistema utilitário desktop** desenvolvido em **Java**, com foco em **operações básicas no sistema de arquivos**, utilizando interface gráfica simples via **Swing**.

O sistema permite ao usuário **criar arquivos, criar pastas e deletar itens** de forma interativa, escolhendo os locais diretamente pelo explorador do sistema operacional.

---

## 🎯 Objetivo do Projeto

O objetivo deste projeto é **praticar e consolidar conceitos fundamentais de Java**, como:

- Manipulação de arquivos e diretórios
- Interação com o sistema operacional
- Uso de interfaces gráficas simples
- Organização de lógica em métodos
- Tratamento de exceções

---

## ⚙️ Funcionalidades

- 📁 Criar pastas em locais escolhidos pelo usuário
- 📄 Criar arquivos com nome definido pelo usuário
- 🗑️ Excluir arquivos ou pastas (vazias)
- 📂 Seleção de arquivos e diretórios via explorador do sistema
- 💬 Diálogos interativos com o usuário

---

## 🧰 Tecnologias Utilizadas

- **Java**
- **Swing**
  - `JFrame`
  - `JFileChooser`
- **java.io.File**
- **Tratamento de exceções (`IOException`)**

---

## 🖥️ Interface do Sistema

O sistema utiliza janelas simples para interação, como:

- `JPane` para criação de UI
- `JFileChooser` para seleção de arquivos e diretórios diretamente no sistema
- `JFile` para criação de arquivos
- 
Essa abordagem torna o sistema **intuitivo e multiplataforma** (Windows, Linux, macOS).

---

## 🧠 Lógica de Funcionamento

1. O sistema inicia exibindo um menu de opções
2. O usuário escolhe a operação desejada
3. Dependendo da escolha:
   - informa o nome do arquivo ou pasta
   - seleciona o local desejado
4. O sistema executa a ação e retorna uma mensagem de sucesso ou erro

---

## 📁 Estrutura do Projeto
📦 fakeos<br>
├── src<br>
│   ├── Main.java<br>
│   └── telas<br>
│       └── TelaTerminal.java<br>
└── README.md


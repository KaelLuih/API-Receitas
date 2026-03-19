<p align="center">
  <img src="assets/README/logo-receitas.png" alt="Logo API Receitas" width="400">
</p>

<h1 align="center">
API Livro de Receitas 🍲📚
</h1>

<p align="center">
👩‍💻 Desenvolvido para gerenciamento de receitas e usuários
</p>

<p align="center">
<img loading="lazy" src="http://img.shields.io/static/v1?label=STATUS&message=EM-DESENVOLVIMENTO&color=GREEN&style=for-the-badge"/>
</p>

---

# Objetivos 📝

A **API Livro de Receitas** foi desenvolvida com o objetivo de fornecer uma estrutura back-end robusta para gerenciamento de receitas culinárias.

O sistema permite que usuários cadastrem, visualizem, atualizem e removam receitas, funcionando como um “livrinho digital de receitas”.  
Além disso, a API será utilizada futuramente como base para uma aplicação mobile em **Kotlin**, garantindo escalabilidade e reutilização.

---

# Funcionalidades 🔨

<table border="1" cellpadding="10" cellspacing="0">
    <tbody>
        <tr>
            <td>Cadastro de receitas</td>
            <td>➕</td>
        </tr>
        <tr>
            <td>Busca de receita por ID</td>
            <td>🔎</td>
        </tr>
        <tr>
            <td>Listagem de todas as receitas (feed)</td>
            <td>📋</td>
        </tr>
        <tr>
            <td>Atualização de receitas</td>
            <td>✏️</td>
        </tr>
        <tr>
            <td>Remoção de receitas</td>
            <td>🗑️</td>
        </tr>
        <tr>
            <td>Cadastro de usuários</td>
            <td>👤</td>
        </tr>
        <tr>
            <td>Busca de usuário por email</td>
            <td>📧</td>
        </tr>
    </tbody>
</table>

---

# Tecnologias Utilizadas 👾

<div style="display: flex; flex-wrap: wrap; align-items: center; gap: 15px;">
    <img alt="Spring Boot" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" width="40" height="40" />
    <img alt="Java" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" width="40" height="40" />
    <img alt="JPA" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/hibernate/hibernate-original.svg" width="40" height="40" />
    <img alt="MySQL" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-original.svg" width="40" height="40" />
    <img alt="Maven" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/apache/apache-original.svg" width="40" height="40" />
    <img alt="Git" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/git/git-original.svg" width="40" height="40" />
</div>

---

# Como foi Desenvolvido 🤔

O desenvolvimento da API foi estruturado em camadas, seguindo boas práticas de arquitetura back-end:

**Controller 📡**  
Responsável por expor os endpoints da API, permitindo a comunicação com o cliente.

**Service ⚙️**  
Contém as regras de negócio, validações e processamento dos dados.

**Repository 💾**  
Responsável pela comunicação com o banco de dados utilizando JPA.

**Model 📦**  
Define as entidades principais do sistema, como **Usuário** e **Receita**.

---

# Estrutura da API 🔗

## 📌 Receita

- **POST /receitas** → Cadastrar receita  
- **GET /receitas** → Listar todas as receitas  
- **GET /receitas/{id}** → Buscar receita por ID  
- **PUT /receitas/{id}** → Atualizar receita  
- **DELETE /receitas/{id}** → Remover receita  

---

## 👤 Usuário

- **POST /usuarios** → Cadastrar usuário  
- **GET /usuarios/email/{email}** → Buscar usuário por email  

---

# Futuro do Projeto 🚀

- Integração com aplicativo mobile em **Kotlin** 📱    
- Upload de imagens para receitas  
- Sistema de favoritos e curtidas  
- Melhorias na segurança e autenticação (JWT)

---

# Como Acessar ❓

Para rodar o projeto na sua máquina, siga os passos abaixo:

## 1️⃣ Clone o repositório:
```bash
git clone https://github.com/seu-repositorio/api-receitas.git
```
## 2️⃣ Acesse a pasta do projeto:
```bash
cd api-receitas
```
## 3️⃣ Execute o projeto com Maven:

```bash
./mvnw spring-boot:run
```
👉 Ou, se já tiver Maven instalado:

```bash
mvn spring-boot:run
```
## 4️⃣ A API estará disponível em:

```bash
http://localhost:8080

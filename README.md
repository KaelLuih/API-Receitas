<p align="center">
  <img src="/receitas/assets/README/logotitulo.png" alt="Logo API Receitas" width="400">
</p>

<h1 align="center">
API Livro de Receitas 
</h1>

<p align="center">
👩‍💻 Desenvolvido para gerenciamento de receitas, usuários e ingredientes
</p>

<p align="center">
<img loading="lazy" src="http://img.shields.io/static/v1?label=STATUS&message=CONCLUIDO&color=GREEN&style=for-the-badge"/>
</p>

---

# Objetivos 📝

A **API Livro de Receitas** foi desenvolvida com o objetivo de fornecer uma estrutura back-end robusta para gerenciamento de receitas culinárias.

O sistema permite que usuários cadastrem, visualizem, atualizem e removam receitas, funcionando como um “livrinho digital de receitas”.  
Além disso, a API também gerencia usuários e oferece filtros avançados de busca por receitas.

O projeto será utilizado futuramente como base para uma aplicação mobile em **Kotlin**, garantindo escalabilidade e reutilização.

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
            <td>Busca de receitas por nome</td>
            <td>🔤</td>
        </tr>
        <tr>
            <td>Filtro por tempo de preparo</td>
            <td>⏱️</td>
        </tr>
        <tr>
            <td>Filtro por quantidade de porções</td>
            <td>🍽️</td>
        </tr>
        <tr>
            <td>Filtro por ingrediente</td>
            <td>🥕</td>
        </tr>
        <tr>
            <td>Listagem de receitas</td>
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
            <td>Listagem de ingredientes únicos</td>
            <td>📦</td>
        </tr>
        <tr>
            <td>Cadastro de usuários</td>
            <td>👤</td>
        </tr>
        <tr>
            <td>Busca de usuário por email</td>
            <td>📧</td>
        </tr>
        <tr>
            <td>Login de usuário</td>
            <td>🔐</td>
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
Responsável por expor os endpoints da API.

**Service ⚙️**  
Contém as regras de negócio e validações.

**Repository 💾**  
Responsável pela comunicação com o banco via JPA.

**Model 📦**  
Define as entidades do sistema: **Usuário**, **Receita**.

---

# Estrutura da API 🔗

## 📌 Receita

- **POST /receita** → Cadastrar receita  
- **GET /receita** → Listar todas as receitas  
- **GET /receita/{id}** → Buscar receita por ID  
- **GET /receita/nome/{nome}** → Buscar receitas por nome  
- **GET /receita/ingrediente/{ingrediente}** → Buscar receitas por ingrediente  
- **GET /receita/porcao/filtro?min={min}&max={max}** → Filtrar por porções  
- **GET /receita/filtro/tempo?tempoMin={min}&tempoMax={max}** → Filtrar por tempo de preparo  
- **PUT /receita/{id}** → Atualizar receita  
- **DELETE /receita/{id}** → Remover receita  

---

## 👤 Usuário

- **POST /usuario** → Cadastrar usuário  
- **POST /usuario/login** → Login de usuário  
- **GET /usuario/{email}** → Buscar usuário por email  

---

## 🥕 Ingredientes

- **GET /ingrediente** → Listar ingredientes únicos cadastrados  

---

# Futuro do Projeto 🚀

- Integração com aplicativo mobile em **Kotlin** 📱  
- Upload de imagens para receitas  
- Sistema de favoritos e curtidas  
- Implementação de autenticação com JWT  
- Melhorias em segurança e controle de acesso  

---

# Como Acessar ❓

Para rodar o projeto na sua máquina, siga os passos abaixo:

## 1️⃣ Clone o repositório:
```bash
git clone https://github.com/KaelLuih/API-Receitas.git
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
https://api-receitas-pb3e.onrender.com/
```

---

# Autores 👤

<table align="center">
  <tr>
    <td align="center" width="160" height="200" style="border:2px solid #ccc;">
      <img src="https://github.com/Liiiiisssz.png" width="115" height="115"><br>
      <sub><a href="https://github.com/Liiiiisssz">Elis Jasper</a><br><span style="color:#32CD32"><b>⚙️ Backend</b></span></sub>
    </td>
    <td align="center" width="160" height="200" style="border:2px solid #ccc;">
      <img src="https://github.com/KaelLuih.png" width="115" height="115"><br>
      <sub><a href="https://github.com/KaelLuih">Kael Luih de Araujo</a><br><span style="color:#FF69B4"><b>⚙️ Backend</b></span></sub>
    </td>
    <td align="center" width="160" height="200" style="border:2px solid #ccc;">
      <img src="https://github.com/Dudazabel.png" width="115" height="115"><br>
      <sub><a href="https://github.com/Dudazabel">Maria E. Zabel</a><br><span style="color:#32CD32"><b>⚙️ Backend</b></span></sub>
    </td>
  </tr>
</table>

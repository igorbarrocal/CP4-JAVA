# E-Project Manager

Sistema Spring Boot + Thymeleaf para cadastro, edição e listagem de **Projetos** e **Recursos**.

## Funcionalidades

- **Projetos**:
  - Cadastro de novos projetos
  - Listagem de projetos
  - Edição de projetos existentes
  - Exclusão de projetos

- **Recursos**:
  - Cadastro de novos recursos
  - Listagem de recursos
  - Edição de recursos existentes
  - Exclusão de recursos

- **Menu de Navegação**:
  - Links para Home, Projetos, Recursos e About

- **Tratamento global de erros**
- **Internacionalização (i18n)**

## Estrutura de Pastas

```
src/
 └─ main/
     ├─ java/
     │   └─ br/com/fiap/projetos/
     │        ├─ controller/
     │        │    ├─ HomeController.java
     │        │    ├─ RecursoController.java
     │        │    └─ ProjetoController.java
     │        ├─ dto/
     │        │    ├─ ProjetoDTO.java
     │        │    └─ RecursoDTO.java
     │        ├─ entity/
     │        │    ├─ Projeto.java
     │        │    └─ Recurso.java
     │        ├─ repository/
     │        │    ├─ ProjetoRepository.java
     │        │    └─ RecursoRepository.java
     │        └─ service/
     │             ├─ ProjetoService.java
     │             └─ RecursoService.java
     └─ resources/
         ├─ templates/
         │    ├─ home.html
         │    ├─ error.html
         │    ├─ projetos/
         │    │    ├─ lista.html
         │    │    └─ formulario.html
         │    ├─ recursos/
         │    │    ├─ lista.html
         │    │    └─ formulario.html
         │    └─ fragments/
         │         ├─ header.html
         │         └─ footer.html
         ├─ messages.properties
         ├─ messages_en.properties
         └─ application.yml
```

## Como rodar

1. **Pré-requisitos**: Java 17+ e Maven
2. Clone o repositório:
   ```bash
   git clone https://github.com/igorbarrocal/CP4-JAVA.git
   cd CP4-JAVA/AULA\ 10\ -\ PROJETO\ BASE
   ```
3. Execute o projeto:
   ```bash
   ./mvnw spring-boot:run
   ```
4. Acesse [http://localhost:8080](http://localhost:8080) no navegador.

## Telas principais

- **Home**: Página inicial com navegação para Projetos e Recursos
- **Projetos**: Listagem, cadastro, edição e exclusão
- **Recursos**: Listagem, cadastro, edição e exclusão
- **Erro**: Página personalizada para mensagens de erro

## Tecnologias

- Spring Boot
- Thymeleaf
- H2 Database (memória)
- Lombok
- Tailwind CSS

## Observações

- O projeto é para aprendizado e demonstração de arquitetura MVC com Spring Boot.
- Para alterar o idioma, modifique as mensagens em `messages.properties` e `messages_en.properties`.





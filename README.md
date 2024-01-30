# Projeto de Gerenciamento de Tarefas

Este projeto é uma aplicação simples de gerenciamento de tarefas desenvolvida em Java. A estrutura do projeto está organizada em diferentes pacotes para facilitar a manutenção e expansão.

## Estrutura do Projeto

### `controller`

- **PersonalController:** Controlador para operações relacionadas a tarefas pessoais.
- **StudyController:** Controlador para operações relacionadas a tarefas de estudo.
- **TasksController:** Controlador principal que interage com o usuário e coordena as operações de tarefas.
- **WorkController:** Controlador para operações relacionadas a tarefas de trabalho.

### `domain`

- **BaseTask:** Classe base que define atributos comuns a todas as tarefas.
- **PersonalTask:** Extensão de `BaseTask` para representar tarefas pessoais, incluindo atributos específicos.
- **StudyTask:** Extensão de `BaseTask` para representar tarefas de estudo, incluindo atributos específicos.
- **WorkTask:** Extensão de `BaseTask` para representar tarefas de trabalho, incluindo atributos específicos.

### `repository`

- **TasksRepository:** Repositório para armazenar e gerenciar tarefas.

### `service`

- **TasksService:** Serviço que lida com a lógica de negócios relacionada às tarefas.

### `Main`

- **Main:** Ponto de entrada da aplicação. Permite ao usuário escolher o tipo de tarefa e interagir com as operações correspondentes.

## Como Executar

1. Certifique-se de ter o Java instalado na sua máquina.
2. Clone o repositório para a sua máquina local.
3. Compile e execute o arquivo `Main.java`.

## Funcionalidades

- **Criar Tarefa:** Permite criar uma nova tarefa com título, descrição, data de vencimento e atributos específicos de cada tipo de tarefa.
- **Editar Tarefa:** Possibilita a edição de uma tarefa existente, incluindo título, descrição e data de vencimento.
- **Excluir Tarefa:** Permite excluir uma tarefa informando seu ID.
- **Listar Tarefas:** Exibe a lista de todas as tarefas cadastradas.

## Autor

Graziella Guedes

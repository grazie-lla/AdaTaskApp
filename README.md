# Projeto de Gerenciamento de Tarefas

Este projeto é uma aplicação simples de gerenciamento de tarefas desenvolvida em Java, onde o usuário interage através do console. A estrutura do projeto está organizada em diferentes pacotes para facilitar a manutenção e expansão, respeitando os princípios do SOLID.

## Estrutura do Projeto

### `controller`

- **PersonalController:** Controlador para operações relacionadas a tarefas pessoais.
- **StudyController:** Controlador para operações relacionadas a tarefas de estudo.
- **TasksController:** Controlador para tarefas gerais.
- **WorkController:** Controlador para operações relacionadas a tarefas de trabalho.

### `domain`

- `BaseTask`:Classe base que define atributos comuns a todas as tarefas.
- `PersonalTask`: Extensão de `BaseTask` para representar tarefas pessoais, incluindo atributos específicos de tarefas pessoais.
- `StudyTask`: Extensão de `BaseTask` para representar tarefas de estudo, incluindo atributos específicos de tarefas de estudo.
- `WorkTask`: Extensão de `BaseTask` para representar tarefas de trabalho, incluindo atributos específicos de tarefas de trabalho.

### `repository`

- `TasksRepository`: Repositório principal para armazenar e gerenciar todas as operações de tarefas.

### `service`

- `TasksService`: Serviço que lida com a lógica de negócios relacionada às tarefas.

### `Main`

- `Main`: Ponto de entrada da aplicação. Permite ao usuário escolher o tipo de tarefa e interagir com as operações correspondentes através do console.

## Como Executar

1. Certifique-se de ter o Java instalado na sua máquina.
2. Clone o repositório para a sua máquina local.
3. Compile e execute o arquivo `Main.java`.

## Funcionalidades

- **Criar Tarefa:** Permite criar uma nova tarefa com título, descrição, data final e atributos específicos de cada tipo de tarefa.
- **Editar Tarefa:** Possibilita a edição de uma tarefa existente, incluindo título, descrição e data final, através da busca por ID.
- **Excluir Tarefa:** Permite excluir uma tarefa informando seu ID.
- **Listar Tarefas:** Exibe a lista de todas as tarefas cadastradas de acordo com a classificação da tarefa.

## Fluxo
## Início
- O programa é iniciado.
- Exibe o menu principal.

### Escolher Tipo de Tarefa:
- Usuário escolhe entre Tarefas Gerais, Pessoais, de Estudo ou de Trabalho.
- O programa redireciona para o controlador correspondente com base na escolha.

## Operações do Controlador

### TasksController:
- Exibe opções para Criar, Editar, Excluir ou Listar Tarefas Gerais.
- Realiza operações conforme escolha do usuário.
- Retorna ao menu principal após conclusão.

### PersonalController, StudyController, WorkController:
- Realiza operações específicas do tipo de tarefa escolhido.
- Retorna ao menu principal após conclusão.

## Operações Específicas de Tarefa

### Criar Tarefa:
- Solicita informações necessárias de acordo com o tipo de tarefa.
- Cria uma instância da tarefa correspondente.
- Adiciona a tarefa ao repositório.
- Exibe a tarefa adicionada e mensagem de sucesso.

### Editar Tarefa:
- Solicita o ID da tarefa a ser editada.
- Exibe solicita novos dados.
- Atualiza a tarefa no repositório.
- Exibe mensagem de sucesso.

### Excluir Tarefa:
- Solicita o ID da tarefa a ser excluída.
- Remove a tarefa do repositório.
- Exibe mensagem de sucesso.

### Listar Tarefas:
- Verifica se a lista está vazia.
- Obtém a lista de tarefas do repositório.
- Exibe as informações de cada tarefa.

### Retornar ao Menu principal:
- Usuário escolhe retornar ao menu principal e pode escolher outros tipos de tarefas.

### Sair
- Usuário escolhe Sair.
- Encerra o programa.

## Fim
- O programa é encerrado.

## Autor

Graziella Guedes

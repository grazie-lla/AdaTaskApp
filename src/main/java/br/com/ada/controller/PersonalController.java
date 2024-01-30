package br.com.ada.controller;

import br.com.ada.domain.PersonalTask;
import br.com.ada.service.TasksService;

import java.util.List;
import java.util.Scanner;

public class PersonalController {
    private TasksService<PersonalTask<String>> service;

    public PersonalController(TasksService<PersonalTask<String>> service) {
        this.service = service;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.printf("Escolha uma opção: %n1. Criar tarefa; " +
                    "%n2. Editar tarefa; " +
                    "%n3. Excluir tarefa; " +
                    "%n4. Listar tarefas; " +
                    "%n5. Voltar para o menu principal;" +
                    "%n6. Encerrar programa.%n");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    createTask(scanner);
                    break;
                case 2:
                    editTask(scanner);
                    break;
                case 3:
                    deleteTask(scanner);
                    break;
                case 4:
                    listTasks();
                    break;
                case 5:
                    return;
                case 6:
                    System.out.println("Encerrando o programa!");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void createTask(Scanner scanner) {
        scanner = new Scanner(System.in);
        System.out.println("Digite o título da tarefa:");
        String title = scanner.nextLine();

        System.out.println("Digite a descrição da tarefa:");
        String description = scanner.nextLine();

        System.out.println("Digite a data final da tarefa:");
        String deadline = scanner.nextLine();

        System.out.println("Digite a prioridade da tarefa:");
        String priority = scanner.next();

        PersonalTask<String> task = new PersonalTask<>(title, description, deadline, priority);

        service.createTask(task);

        System.out.printf("***************************" +
                "%nTarefa criada com sucesso!" +
                "%n***************************%n");
        System.out.println(task);
        System.out.println("____________________________________");
    }
    private void editTask(Scanner scanner) {
        scanner = new Scanner(System.in);
        System.out.println("Digite o ID da tarefa que deseja editar:");
        Long id = null;
        while (id == null) {
            try {
                id = scanner.nextLong();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número válido para o ID:");
                scanner.nextLine();
            }
        }
        PersonalTask task = service.findById(id);

        if (task == null) {
            System.out.println("Tarefa não encontrada!");
            return;
        }

        System.out.println("Digite o novo título da tarefa:");
        task.setTitle(scanner.next());
        scanner.nextLine();

        System.out.println("Digite a nova descrição da tarefa:");
        task.setDescription(scanner.next());
        scanner.nextLine();

        System.out.println("Digite a nova data final da tarefa:");
        task.setDeadline(scanner.next());
        scanner.nextLine();

        System.out.println("Digite a prioridade tarefa:");
        task.setPriority(scanner.next());
        scanner.nextLine();

        service.editTask(task);

        System.out.println("Tarefa editada com sucesso!");
    }

    private void deleteTask(Scanner scanner) {
        scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Digite o ID da tarefa que deseja excluir:");
            String input = scanner.nextLine();

            try {
                Long id = Long.parseLong(input.trim());

                PersonalTask task = service.findById(id);

                if (task == null) {
                    System.out.println("Tarefa não encontrada!");
                } else {
                    service.deleteTask(task);
                    System.out.println("Tarefa excluída com sucesso!");
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um ID numérico válido.");
            }
        }
    }

    private void listTasks() {
        List<PersonalTask<String>> tasks = service.listTasks();

        if(tasks.isEmpty()){
            System.out.println("Lista vazia, não há tarefas para serem listadas.");
            System.out.println("____________________________________");
        }

        for (PersonalTask task : tasks) {
            System.out.println(task);
            System.out.println("____________________________________");
        }
    }

}

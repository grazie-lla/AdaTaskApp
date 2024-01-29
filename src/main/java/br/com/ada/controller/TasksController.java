package br.com.ada.controller;

import br.com.ada.domain.BaseTask;
import br.com.ada.service.TasksService;

import java.util.List;
import java.util.Scanner;

public class TasksController {

    private TasksService<BaseTask> service;

    public TasksController(TasksService<BaseTask> service) {
        this.service = service;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.printf("Escolha uma opção: %n1. Criar tarefa; " +
                    "%n2. Editar tarefa; " +
                    "%n3. Excluir tarefa; " +
                    "%n4. Listar tarefas; " +
                    "%n5. Sair.%n");

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
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void createTask(Scanner scanner) {
        System.out.println("Digite o título da tarefa:");
        String title = scanner.next();

        System.out.println("Digite a descrição da tarefa:");
        String description = scanner.next();

        System.out.println("Digite a data final da tarefa:");
        String deadline = scanner.next();

        System.out.println("Digite o Id da tarefa:");
        Long id = scanner.nextLong();
        scanner.nextLine();

        BaseTask task = new BaseTask(title, description, deadline, id);

        service.createTask(task);

        System.out.println("Tarefa criada com sucesso!");
    }

    private void editTask(Scanner scanner) {
        System.out.println("Digite o ID da tarefa que deseja editar:");
        Long id = scanner.nextLong();

        BaseTask task = service.findById(id);

        if (task == null) {
            System.out.println("Tarefa não encontrada!");
            return;
        }

        System.out.println("Digite o novo título da tarefa:");
        task.setTitle(scanner.next());

        System.out.println("Digite a nova descrição da tarefa:");
        task.setDescription(scanner.next());

        System.out.println("Digite a nova data de vencimento da tarefa:");
        task.setDeadline(scanner.next());

        service.editTask(task);

        System.out.println("Tarefa editada com sucesso!");
    }

    private void deleteTask(Scanner scanner) {
        while (true) {
            System.out.println("Digite o ID da tarefa que deseja excluir:");
            String input = scanner.nextLine();

            try {
                Long id = Long.parseLong(input.trim());

                BaseTask task = service.findById(id);

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
        List<BaseTask> tasks = service.listTasks();

        for (BaseTask task : tasks) {
            System.out.println(task);
        }
    }
}
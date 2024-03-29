package br.com.ada.controller;

import br.com.ada.domain.WorkTask;
import br.com.ada.service.TasksService;

import java.util.List;
import java.util.Scanner;

public class WorkController {
    private TasksService<WorkTask> service;

    public WorkController(TasksService<WorkTask> service) {
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
        String title = scanner.next();

        System.out.println("Digite a descrição da tarefa:");
        String description = scanner.next();

        System.out.println("Digite a qual projeto pertence a tarefa:");
        String project = scanner.next();

        System.out.println("Digite o responsável pela tarefa:");
        String assignedTo = scanner.next();
        scanner.nextLine();

        System.out.println("Digite a data final da tarefa:");
        String deadline = scanner.next();
        scanner.nextLine();


        WorkTask task = new WorkTask(title, description, deadline, project, assignedTo);

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
        WorkTask task = service.findById(id);

        if (task == null) {
            System.out.println("Tarefa não encontrada!");
            return;
        }

        System.out.println("Digite o novo título da tarefa:");
        task.setTitle(scanner.next());

        System.out.println("Digite a nova descrição da tarefa:");
        task.setDescription(scanner.next());
        scanner.nextLine();

        System.out.println("Digite a qual projeto pertence a nova tarefa:");
        task.setProject(scanner.next());
        scanner.nextLine();

        System.out.println("Digite o novo responsável pela tarefa:");
        task.setAssignedTo(scanner.next());
        scanner.nextLine();

        System.out.println("Digite a nova data final da tarefa:");
        task.setDeadline(scanner.next());

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

                WorkTask task = service.findById(id);

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
        List<WorkTask> tasks = service.listTasks();

        if(tasks.isEmpty()){
            System.out.println("Lista vazia, não há tarefas para serem listadas.");
            System.out.println("____________________________________");
        }

        for (WorkTask task : tasks) {
            System.out.println(task);
            System.out.println("____________________________________");
        }
    }
}

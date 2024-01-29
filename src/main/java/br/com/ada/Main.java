package br.com.ada;


import br.com.ada.controller.PersonalController;
import br.com.ada.controller.TasksController;
import br.com.ada.domain.BaseTask;
import br.com.ada.domain.PersonalTask;
import br.com.ada.repository.TasksRepository;
import br.com.ada.service.TasksService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println ("Escolha o tipo de tarefa: ");
        System.out.println("1. Tarefas Pessoais");
        System.out.println("2. Tarefas Gerais");

        int choice = scanner.nextInt();

        if (choice == 1) {
            TasksRepository<PersonalTask<String>> personalRepository = new TasksRepository<>();
            TasksService<PersonalTask<String>> personalService = new TasksService<>(personalRepository);
            PersonalController personalController = new PersonalController(personalService);
            personalController.run();
        } else if (choice == 2) {
            TasksRepository<BaseTask> generalRepository = new TasksRepository<>();
            TasksService<BaseTask> generalService = new TasksService<>(generalRepository);
            TasksController generalController = new TasksController(generalService);
            generalController.run();
        } else {
            System.out.println("Escolha inválida!");
        }
    }
}
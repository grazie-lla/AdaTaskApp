package br.com.ada;


import br.com.ada.controller.PersonalController;
import br.com.ada.controller.StudyController;
import br.com.ada.controller.TasksController;
import br.com.ada.domain.BaseTask;
import br.com.ada.domain.PersonalTask;
import br.com.ada.domain.StudyTask;
import br.com.ada.repository.TasksRepository;
import br.com.ada.service.TasksService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println ("Escolha o tipo de tarefa: ");
        System.out.println("1. Tarefas Pessoais");
        System.out.println("2. Tarefas Gerais");
        System.out.println("3. Tarefas de Estudo");

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
        } else if (choice == 3) {
            TasksRepository<StudyTask> studyRepository = new TasksRepository<>();
            TasksService<StudyTask> studyService = new TasksService<>(studyRepository);
            StudyController studyController = new StudyController(studyService);
            studyController.run();
        } else {
            System.out.println("Escolha inválida!");
        }
    }
}
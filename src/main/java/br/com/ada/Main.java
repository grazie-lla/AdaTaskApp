package br.com.ada;


import br.com.ada.controller.PersonalController;
import br.com.ada.controller.StudyController;
import br.com.ada.controller.TasksController;
import br.com.ada.controller.WorkController;
import br.com.ada.domain.BaseTask;
import br.com.ada.domain.PersonalTask;
import br.com.ada.domain.StudyTask;
import br.com.ada.domain.WorkTask;
import br.com.ada.repository.TasksRepository;
import br.com.ada.service.TasksService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.printf("Escolha o tipo de tarefa: " +
                    "%n1. Tarefas Gerais; " +
                    "%n2. Tarefas Pessoais; " +
                    "%n3. Tarefas de Estudo; " +
                    "%n4. Tarefas de Trabalho;" +
                    "%nInsira o número correspondente à opção escolhida:%n");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    runBaseTasks();
                    break;
                case 2:
                    runPersonalTasks();
                    break;
                case 3:
                    runStudyTasks();
                    break;
                case 4:
                    runWorkTasks();
                    break;
                default:
                    System.out.println("Escolha inválida!");
            }
        }
    }
    private static void runBaseTasks(){
        TasksRepository<BaseTask> generalRepository = new TasksRepository<>();
        TasksService<BaseTask> generalService = new TasksService<>(generalRepository);
        TasksController generalController = new TasksController(generalService);
        generalController.run();
    }
    private static void runPersonalTasks(){
        TasksRepository<PersonalTask<String>> personalRepository = new TasksRepository<>();
        TasksService<PersonalTask<String>> personalService = new TasksService<>(personalRepository);
        PersonalController personalController = new PersonalController(personalService);
        personalController.run();
    }
    public static void runStudyTasks(){
        TasksRepository<StudyTask> studyRepository = new TasksRepository<>();
        TasksService<StudyTask> studyService = new TasksService<>(studyRepository);
        StudyController studyController = new StudyController(studyService);
        studyController.run();
    }

    public static void runWorkTasks(){
        TasksRepository<WorkTask> workRepository = new TasksRepository<>();
        TasksService<WorkTask> workService = new TasksService<>(workRepository);
        WorkController workController = new WorkController(workService);
        workController.run();
    }

}
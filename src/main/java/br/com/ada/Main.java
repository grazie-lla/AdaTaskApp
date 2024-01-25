package br.com.ada;


import br.com.ada.controller.TasksController;
import br.com.ada.domain.BaseTask;
import br.com.ada.repository.TasksRepository;
import br.com.ada.service.TasksService;

public class Main {
    public static void main(String[] args) {
        TasksRepository<BaseTask> repository = new TasksRepository<>();
        TasksService<BaseTask> service = new TasksService<>(repository);
        TasksController controller = new TasksController(service);
        controller.run();
        }


}
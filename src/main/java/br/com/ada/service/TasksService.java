package br.com.ada.service;

import br.com.ada.domain.BaseTask;
import br.com.ada.repository.TasksRepository;

import java.util.List;

public class TasksService<T extends BaseTask> {

    private final TasksRepository<T> repository;

    public TasksService(TasksRepository<T> repository) {
        this.repository = repository;
    }

    public T createTask(T task) {
        task.setId(System.currentTimeMillis());
        repository.add(task);
        return task;
    }

    public void editTask(T task) {
        repository.update(task);
    }

    public void deleteTask(T task) {
        repository.remove(task);
    }

    public List<T> listTasks() {
        return repository.findAll();
    }
    public T findById(Long id) {
        List<T> tasks = repository.findAll();

        for (T task : tasks) {
            if (task.getId().equals(id)) {
                return task;
            }
        }

        return null;
    }
}
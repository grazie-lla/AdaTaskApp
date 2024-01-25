package br.com.ada.repository;

import br.com.ada.domain.BaseTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TasksRepository<T extends BaseTask> {
    private List<T> tasks;

    public TasksRepository() {
        tasks = new ArrayList<>();
    }

    public void add(T task) {
        tasks.add(task);
    }

    public void remove(T task) {
        tasks.remove(task);
    }

    public void update(T task) {
        for (int i = 0; i < tasks.size(); i++) {
            if (Objects.equals(tasks.get(i).getId(), task.getId())) {
                tasks.set(i, task);
                return;
            }
        }
    }

    public List<T> findAll() {
        return tasks;
    }
}

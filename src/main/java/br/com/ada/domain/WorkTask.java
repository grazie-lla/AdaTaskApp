package br.com.ada.domain;

public class WorkTask<T> extends BaseTask<T> {
    public WorkTask(String title, String description, String deadline, Long id) {
        super(title, description, deadline, id);
    }

    @Override
    public String toString() {
        return "WorkTask{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", deadline='" + deadline + '\'' +
                ", id=" + id +
                '}';
    }
}

package br.com.ada.domain;

public class WorkTask<T> extends BaseTask<T> {
    public WorkTask(String title, String description, String deadline) {
        super(title, description, deadline);
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

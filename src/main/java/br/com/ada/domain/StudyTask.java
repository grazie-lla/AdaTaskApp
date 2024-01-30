package br.com.ada.domain;

public class StudyTask <T> extends BaseTask<T>{
    public StudyTask(String title, String description, String deadline) {
        super(title, description, deadline);
    }

    @Override
    public String toString() {
        return "StudyTask{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", deadline='" + deadline + '\'' +
                ", id=" + id +
                '}';
    }
}

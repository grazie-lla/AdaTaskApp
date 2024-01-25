package br.com.ada.domain;

public class StudyTask <T> extends BaseTask<T>{
    public StudyTask(String title, String description, String deadline, Long id) {
        super(title, description, deadline, id);
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

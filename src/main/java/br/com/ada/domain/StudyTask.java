package br.com.ada.domain;

public class StudyTask <T> extends BaseTask<T>{
    private String subject;
    public StudyTask(String title, String description, String deadline, String subject) {
        super(title, description, deadline);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Título: " + title +
                "\nDescrição: " + description +
                "\nMatéria: "+ subject +
                "\nPrazo máximo: " + deadline +
                "\nID: " + id;

    }
}

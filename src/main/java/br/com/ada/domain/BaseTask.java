package br.com.ada.domain;

public class BaseTask<T> {
    protected String title;
    protected String description;
    protected String deadline;
    protected Long id;

    public BaseTask(String title, String description, String deadline) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "Título: " + title +
                "\nDescrição: " + description +
                "\nPrazo máximo: " + deadline +
                "\nID: " + id;
    }
}

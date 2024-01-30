package br.com.ada.domain;

public class WorkTask<T> extends BaseTask<T> {
    private String project;
    private String assignedTo;
    public WorkTask(String title, String description, String deadline, String project, String assignedTo) {
        super(title, description, deadline);
        this.project = project;
        this.assignedTo = assignedTo;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    @Override
    public String toString() {
        return "Título: " + title +
                "\nDescrição: " + description +
                "\nProjeto: "+ project +
                "\nResponsável pela tarefa: "+ assignedTo +
                "\nPrazo máximo: " + deadline +
                "\nID: " + id;
    }
}

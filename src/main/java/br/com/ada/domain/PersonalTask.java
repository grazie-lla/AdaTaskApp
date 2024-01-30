package br.com.ada.domain;

import javax.swing.*;

public class PersonalTask<T> extends BaseTask<T> {
    private String priority;

    public PersonalTask(String title, String description, String deadline, String priority) {
        super(title, description, deadline);
        this.priority = priority;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Título: " + title +
                "\nDescrição: " + description +
                "\nPrazo máximo: " + deadline +
                "\nID: " + id +
                "\nPrioridade:"+ priority;
    }
}

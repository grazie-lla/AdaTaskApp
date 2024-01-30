package br.com.ada.domain;

import javax.swing.*;

public class PersonalTask<T> extends BaseTask<T> {
    private String priority;

    public PersonalTask(String title, String description, String deadline, Long id, String priority) {
        super(title, description, deadline, id);
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
                "\nData de vencimento: " + deadline +
                "\nID: " + id +
                "\nPrioridade:"+ priority;
    }
}

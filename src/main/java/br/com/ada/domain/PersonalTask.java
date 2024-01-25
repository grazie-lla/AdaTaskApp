package br.com.ada.domain;

import javax.swing.*;

public class PersonalTask<T> extends BaseTask<T> {

    public PersonalTask(String title, String description, String deadline, Long id) {
        super(title, description, deadline, id);
    }

    @Override
    public String toString() {
        return "PersonalTask{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", deadline='" + deadline + '\'' +
                ", id=" + id +
                '}';
    }
}

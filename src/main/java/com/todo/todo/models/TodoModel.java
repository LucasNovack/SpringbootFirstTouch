package com.todo.todo.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;


@Entity
@Table(name = "todo")
public class TodoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idTodo;
    private String dsTodo;
    private boolean ieResolvido;

    public UUID getIdTodo() {
        return idTodo;
    }

    public void setIdTodo(UUID idTodo) {
        this.idTodo = idTodo;
    }

    public String getDsTodo() {
        return dsTodo;
    }

    public void setDsTodo(String dsTodo) {
        this.dsTodo = dsTodo;
    }

    public boolean isIeResolvido() {
        return ieResolvido;
    }

    public void setIeResolvido(boolean ieResolvido) {
        this.ieResolvido = ieResolvido;
    }
}

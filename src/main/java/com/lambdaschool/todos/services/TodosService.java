package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todos;

public interface TodosService
{
    void markComplete(long todoid);

    Todos update(Todos todo, Long id);

    Todos findUserById(Long id);
}

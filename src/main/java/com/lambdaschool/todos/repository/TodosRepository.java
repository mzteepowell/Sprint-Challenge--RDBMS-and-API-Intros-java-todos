package com.lambdaschool.todos.repository;

import com.lambdaschool.todos.models.Todos;
import com.lambdaschool.todos.views.UserNameCountTodos;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TodosRepository extends CrudRepository<Todos, Long> {
}

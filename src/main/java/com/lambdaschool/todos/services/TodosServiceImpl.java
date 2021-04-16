package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todos;
import com.lambdaschool.todos.repository.TodosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service(value = "TodoService")
public class TodosServiceImpl implements TodosService{

  @Autowired
  private TodosRepository todosRepos;

  @Autowired
  private UserService userService;

  @Autowired
  private UserAuditing userAuditing;

  @Override
  public Todos findUserById(Long id) throws EntityNotFoundException {
    return todosRepos.findById(id)
                     .orElseThrow(() -> new EntityNotFoundException("User id " + id + " not found!"));
  }

  @Override
  public void markComplete(long todoid) {

  }

  @Override
  public Todos update(
      Todos todos,
      Long id) {

    Todos currentTodo = findUserById(id);

    //ManyToOne
    if (todos.getUser() != null) {
      todos.setUser(userService.findUserById(todos.getUser().getUserid()));
    }


    if (todos.getDescription() != null){
      currentTodo.setDescription(todos.getDescription());
    }

    return todosRepos.save(currentTodo);
  }
}

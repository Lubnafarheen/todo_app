package se.lexicon.dao.impl;

import se.lexicon.dao.TodoItemDao;
import se.lexicon.model.TodoItem;
import se.lexicon.sequencer.TodoItemIdSequencer;

import java.util.ArrayList;
import java.util.List;

public class TodoItemDaoImpl implements TodoItemDao {

    private List<TodoItem> todoStorage;

    private static TodoItemDaoImpl instance;

    private TodoItemDaoImpl() {
        todoStorage = new ArrayList<>();
    }

    public static TodoItemDaoImpl getInstance() {
        if (instance == null) instance = new TodoItemDaoImpl();
        return instance;
    }

    @Override
    public TodoItem create(TodoItem model) {
        if (model == null) throw new IllegalArgumentException("appUser was null");
        model.setId(TodoItemIdSequencer.nextId());
        todoStorage.add(model);
        return model;
    }

    @Override
    public TodoItem findById(Integer id) {
        if (id == null) throw new IllegalArgumentException("TodoItem was null");
        for (TodoItem todoItem : todoStorage) {
            if (todoItem.getId().equals(id))
                return todoItem;
        }
        return null;
    }

    @Override
    public boolean deleteById(Integer id) {
        return todoStorage.remove(findById(id));
    }

    @Override
    public void update(TodoItem model) {
        if (model == null) throw new IllegalArgumentException("TodoItem update was null");
        for (TodoItem todoItem : todoStorage) {
            if (todoItem.getId().equals(model.getId())) {
                todoItem.setTitle(model.getTitle());
                todoItem.setDescription(model.getDescription());
                todoItem.setDeadline(model.getDeadline());
                todoItem.setDone(model.isDone());
                todoItem.setAssignee(model.getAssignee());
                break;
            }
        }
    }

    @Override
    public List<TodoItem> findAll() {
        return todoStorage;
    }


    @Override
    public List<TodoItem> findByDone(boolean done) {
        List<TodoItem> newList = new ArrayList<>();
        for (TodoItem todoItem : todoStorage) {
            if (todoItem.isDone() == done)
                newList.add(todoItem);
        }
        return newList;
    }

}

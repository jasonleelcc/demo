package com.jason.controller;

import com.jason.model.Item;
import com.jason.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * Created by innofin-04 on 2016/10/27.
 */
@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemRepository repo;
    @Value("${my.name}")
    private String myName;

    @RequestMapping(method = RequestMethod.GET)
    public List<Item> findItems() {
        List<Item> items = repo.findAll();
        for (Item a: items) {
              System.out.println(a.getDescription());
        }
        return items;
    }

    @RequestMapping(value = "/checked", method = RequestMethod.GET)
    public List<Item> findChecked() {
        return repo.findChecked();//this
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello World three" + myName;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Item addItem(@RequestBody Item item) {
        item.setId(null);
        return repo.saveAndFlush(item);//this is a
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Item updateItem(@RequestBody Item updatedItem, @PathVariable Integer id) {
        Item item = repo.getOne(id);

        item.setChecked(updatedItem.isChecked());
        item.setDescription(updatedItem.getDescription());
        return repo.saveAndFlush(item);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteItem(@PathVariable Integer id) {
        repo.delete(id);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = { EmptyResultDataAccessException.class, EntityNotFoundException.class })
    public void handleNotFound() { }
}

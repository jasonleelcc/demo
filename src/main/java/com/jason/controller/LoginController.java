package com.jason.controller;

import com.jason.model.Item;
import com.jason.model.LoginInfo;
import com.jason.repository.ItemRepository;
import com.jason.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * Created by innofin-04 on 2016/10/27.
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginRepository repo;
    @Value("${my.name}")
    private String myName;

    @RequestMapping(method = RequestMethod.GET)
    public String findChecked() {
        return "Hello " + myName;
    }


    @RequestMapping(method = RequestMethod.POST)
    public LoginInfo addLogin(@RequestBody LoginInfo loginInfo) {
        return repo.save(loginInfo);//this is a
    }

//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//    public Item updateItem(@RequestBody Item updatedItem, @PathVariable Integer id) {
//        Item item = repo.getOne(id);
//
//        item.setChecked(updatedItem.isChecked());
//        item.setDescription(updatedItem.getDescription());
//        return repo.saveAndFlush(item);
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    @ResponseStatus(value = HttpStatus.NO_CONTENT)
//    public void deleteItem(@PathVariable Integer id) {
//        repo.delete(id);
//    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = { EmptyResultDataAccessException.class, EntityNotFoundException.class })
    public void handleNotFound() { }
}

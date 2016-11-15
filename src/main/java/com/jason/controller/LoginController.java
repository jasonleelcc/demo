package com.jason.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jason.model.Item;
import com.jason.model.LoginInfo;
import com.jason.repository.ItemRepository;
import com.jason.repository.LoginRepository;
import com.jason.retdata.LoginRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.servlet.ServletContext;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.util.List;

/**
 * Created by innofin-04 on 2016/10/27.
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired private LoginRepository repo;
    @Autowired private ObjectMapper ot;
    @Autowired private ServletContext ctx;
    @Autowired private LoginRet loginRet;
    @Value("${my.name}") private String myName;

    @RequestMapping(method = RequestMethod.GET)
    public String findChecked() {
        return "Hello " + myName;
    }


    @RequestMapping(method = RequestMethod.POST)
    public LoginRet addLogin(@RequestBody LoginInfo loginInfo) {
        repo.save(loginInfo);
        loginRet.setId(loginInfo.getId());
        loginRet.setUserId(loginInfo.getUserId());
        loginRet.setPasswd(loginInfo.getPasswd());
        loginRet.setDesc("12345678");
        return loginRet;
//        return repo.save(loginInfo);//this is a
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

package com.jason.repository;

import com.jason.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by innofin-04 on 2016/10/27.
 */
public interface ItemRepository extends JpaRepository<Item, Integer> {
    @Query("select i from Item i where i.checked=true")
    List<Item> findChecked();//they a
}

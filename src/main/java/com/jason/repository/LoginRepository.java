package com.jason.repository;

import com.jason.model.Item;
import com.jason.model.LoginInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by innofin-04 on 2016/10/27.
 */
public interface LoginRepository extends JpaRepository<LoginInfo, String> {
}

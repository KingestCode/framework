package com.miaoqi.service;

import com.miaoqi.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Qualifier("bookDao2")
    @Autowired
    private BookDao bookDao1;

    @Override
    public String toString() {
        return "BookService{" +
                "bookDao=" + bookDao1 +
                '}';
    }
}

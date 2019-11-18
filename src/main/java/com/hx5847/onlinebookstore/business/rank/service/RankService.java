package com.hx5847.onlinebookstore.business.rank.service;

import com.hx5847.onlinebookstore.business.common.dao.BooksMapper;
import com.hx5847.onlinebookstore.business.common.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class RankService {

    @Autowired
    private BooksMapper booksMapper;

    public List<Book> getRankBooks(String[] types, String condition){
        List<Book> books = booksMapper.getRank(types,condition);

        return books;
    }
}

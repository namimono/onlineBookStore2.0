package com.hx5847.onlinebookstore.business.common.dao;

import com.hx5847.onlinebookstore.business.common.model.Book;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface BooksMapper extends Mapper<Book> {

//    SELECT * FROM books WHERE book_id IN
//    (SELECT book_id FROM tb_type where type='军事' or type='魔幻' or type='都市' GROUP BY book_id)
//    ORDER BY click DESC;

    /**
     *
     * @param types String[]
     * @param condition String
     * @return 返回Book 的List集合
     * 子查询使用or，子查询索引失效。建立book_id,type复合索引，查询结果是book_id 可以用到book_id索引。
     * 但是type索引失效。
     * ( SELECT book_id FROM tb_type where type='魔幻' or type='都市')
     *
     *
     *
     */
    @SelectProvider(type=BooksProvider.class,method ="getBookRank")
    public List<Book> getRank(@Param("types") String[] types, @Param("condition") String condition);

    @SelectProvider(type=BooksProvider.class,method ="getBooksByTypes")
    public List<Integer> getBooksIdByTypes(@Param("types") List<String> types);
}

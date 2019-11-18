package com.hx5847.onlinebookstore.business.common.dao;

import org.apache.ibatis.jdbc.SQL;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BooksProvider {

    /**
     * @param para
     * @return
     *
     * 根据类型和点击量获取排名前100的书
     * SELECT * FROM books WHERE book_id IN(SELECT book_id
     * FROM tb_type
     * WHERE (type='都市')
     * OR (type='魔幻')
     * GROUP BY book_id) ORDER BY click DESC limit 0,100
     */
    public String getBookRank(Map<String, Object> para){
        final String[] types= (String[]) para.get("types");
        for (int i = 0; i < types.length; i++) {
            System.out.println(types[i]);

        }
        final String condition= (String) para.get("condition");
        StringBuffer sql=new StringBuffer();
        String childSql=new SQL(){
            {
                SELECT("book_id");
                FROM("tb_type");
                for (int i = 0; i < types.length; i++) {
//                当条件索引是最后一个索引时不加or
                    if (i == types.length - 1) {
                        WHERE("type='" + types[i]+"'");
                    } else {
                        WHERE("type='" + types[i]+"'");
                        OR();
                    }
                }
                GROUP_BY("book_id");
            }}.toString();
        sql.append("SELECT * FROM books WHERE book_id IN(");
        sql.append(childSql+")");
        sql.append(" ORDER BY "+condition+" DESC");
        sql.append(" limit 0,100");

        System.out.println(sql);
        return sql.toString();
    }

    /**
     * @param map
     * @return
     * 根据类型随机获取10本书。
     * SELECT DISTINCT books.book_id
     * FROM books
     * LEFT OUTER JOIN tb_type on books.book_id=tb_type.book_id
     * WHERE (type='魔幻')
     * OR (type='军事') ORDER BY RAND() LIMIT 0,10
     */
    public String getBooksByTypes( Map<String, List> map){
        System.out.println(map);
        System.out.println(map.get("types"));
        final List<String> listType = (List)map.get("types");

        StringBuffer sql =new StringBuffer();
        String s=new SQL(){{
            SELECT_DISTINCT("books.book_id");
            FROM("books");
            LEFT_OUTER_JOIN("tb_type on books.book_id=tb_type.book_id");

            Iterator<String> iterator = listType.iterator();
            while(iterator.hasNext()){
                WHERE("type='"+iterator.next()+"'");
                if (iterator.hasNext()){
                    OR();
                }else {
                    break;
                }

            }


        }}.toString();
        sql.append(s);
        sql.append(" ORDER BY RAND() LIMIT 0,10");

        System.out.println(sql);
        return sql.toString();
    }
}

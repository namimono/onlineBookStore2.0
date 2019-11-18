package com.hx5847.onlinebookstore.business.common.dao;

public class UserProvider {
//    @Select("select book_id from books
//    LEFT JOIN tb_type on books.book_id=tb_type.book_id where
//    type='科幻' or type='军事' ORDER BY RAND() LIMIT 0,10")
//    随机取同类型的10本书
//    public String getUserIntrestBooks( Map<String, List> map){
//        System.out.println(map);
//        System.out.println(map.get("types"));
//        final List<String> listType = (List)map.get("types");
//
//        StringBuffer sql =new StringBuffer();
//        String s=new SQL(){{
//            SELECT_DISTINCT("books.book_id");
//            FROM("books");
//            LEFT_OUTER_JOIN("tb_type on books.book_id=tb_type.book_id");
//
//            Iterator<String> iterator = listType.iterator();
//            while(iterator.hasNext()){
//                WHERE("type='"+iterator.next()+"'");
//                if (iterator.hasNext()){
//                    OR();
//                }else {
//                    break;
//                }
//
//            }
//
//
//        }}.toString();
//        sql.append(s);
//        sql.append(" ORDER BY RAND() LIMIT 0,10");
//
//        System.out.println(sql);
//        return sql.toString();
//    }
}

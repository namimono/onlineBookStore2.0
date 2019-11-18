package com.hx5847.onlinebookstore.business.announce.dao;

import com.hx5847.onlinebookstore.business.announce.model.Announcement;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface AnnouncementMapper extends Mapper<Announcement> {
    @Select("select anno_id as annoId ,title,upload_time as uploadTime,type,content from announcement where anno_id=#{id}")
    public Announcement getAnnounceById(Integer id);


    @Select("select anno_id as annoId,title,upload_time as uploadTime,type from announcement")
    public List<Announcement> getAll();

    @Insert("insert into announcement (title,type,content) values (#{title},#{type},#{content})")
    public void insertAnnouncement(Announcement announcement);

    @Update("update announcement set title=#{title},type=#{type},content=#{content} WHERE (anno_id=#{annoId})")
    public void updateAnnouncement(Announcement announcement);


    @Delete("delete from announcement where anno_id=#{id}")
    public void delAnnouncement(Integer id);
}

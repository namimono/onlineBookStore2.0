package com.hx5847.onlinebookstore.business.announce.service;


import com.hx5847.onlinebookstore.business.announce.dao.AnnouncementMapper;
import com.hx5847.onlinebookstore.business.announce.model.Announcement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class AnnounceService {
    @Autowired
    private AnnouncementMapper announcementMapper;

    public List<Announcement> getAllAnnouncements(){

        List<Announcement> list = announcementMapper.getAll();
        return list;
    }

    public Announcement getAnnouncement(Integer id){
        Announcement announce = announcementMapper.getAnnounceById(id);
        return announce;
    }

    public void insertAnnouncement(Announcement announcement) {
        announcementMapper.insertAnnouncement(announcement);
    }

    public void updateAnnouncement(Announcement announcement) {
        announcementMapper.updateAnnouncement(announcement);
    }
    public String delAnnouncement(Integer id) {
        announcementMapper.delAnnouncement(id);
        return "success";
    }
}

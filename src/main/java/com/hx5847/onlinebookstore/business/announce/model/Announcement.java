package com.hx5847.onlinebookstore.business.announce.model;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public class Announcement {

  private Integer annoId;
  private String title;
  private Timestamp uploadTime;
  private String type;
  private String content;


  public Announcement(Integer annoId, String title, String type, String content) {
    this.annoId = annoId;
    this.title = title;
    this.type = type;
    this.content = content;
  }

  public Announcement() {
  }

  @Override
  public String toString() {
    return "Announcement{" +
            "annoId=" + annoId +
            ", title='" + title + '\'' +
            ", uploadTime=" + uploadTime +
            ", type='" + type + '\'' +
            ", content='" + content + '\'' +
            '}';
  }

  public Announcement(String title, String type, String content) {
    this.title = title;
    this.type = type;
    this.content = content;
  }

    public Announcement(String content) {
        this.content = content;
    }

    public Announcement(Integer annoId, String title, Timestamp uploadTime, String type, String content) {
    this.annoId = annoId;
    this.title = title;
    this.uploadTime = uploadTime;
    this.type = type;
    this.content = content;
  }

  public Integer getAnnoId() {
    return annoId;
  }

  public void setAnnoId(Integer annoId) {
    this.annoId = annoId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
  public Timestamp getUploadTime() {
    return uploadTime;
  }

  public void setUploadTime(Timestamp uploadTime) {
    this.uploadTime = uploadTime;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}

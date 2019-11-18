package com.hx5847.onlinebookstore.business.advertise.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Advertisement {

  private Integer advId;
  private String url;
  private String picUrl;
  private Timestamp lastMdfTime;
  private String location;


}

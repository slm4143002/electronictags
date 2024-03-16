package com.card.management.restapi.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class RestResponseResult {
 public String status;
 public String error;
 public Data data;
 
}

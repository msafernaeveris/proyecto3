package com.everis.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

/**
 * Omitir campos que son nulos.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder
public class Response {
  
  private String error;
  
  private Object data;

}

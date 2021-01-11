package com.example.cloud.pojo.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final Integer OK = Integer.valueOf(200);
    public static final Integer ERROR = Integer.valueOf(500);
    private int code;
    private String message;
    private T data;

    public static Result<Object> create(int code, String message, Object data){
        return new Result<>(code, message, data);
    }
}

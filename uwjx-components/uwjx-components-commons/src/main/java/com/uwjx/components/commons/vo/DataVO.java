package com.uwjx.components.commons.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author SalleyGardens
 */
@Data
public class DataVO<T> implements Serializable {

    private Integer code;

    private String message;

    private T data;

    public DataVO(int code, String message){
        this.code = code;
        this.message = message;
        this.data = null;
    }

    public DataVO(int code , String message , T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }
}

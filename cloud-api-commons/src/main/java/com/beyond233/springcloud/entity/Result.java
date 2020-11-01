package com.beyond233.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * <p>项目文档: 前后端公共消息类 </p>
 *
 * @author beyond233
 * @version 1.0
 * @since 2020-06-06 18:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Result<T> {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 结果消息
     */
    private String message;

    /**
     * 数据
     */
    private T data;

    public Result(Integer code, String message) {
        this(code, message,null);
    }

    public static <T>Result<T> success(T data){
        return new Result<>(200, "success",data);
    }

    public static <T>Result<T> success(){
        return new Result<>(200, "success",null);
    }

    public static <T>Result<T> fail(T data){
        return new Result<>(200, "fail",data);
    }

    public static <T>Result<T> fail(){
        return new Result<>(200, "fail",null);
    }

    public static <T>Result<T> error(T data){
        return new Result<>(500, "internal error",data);
    }

    public static <T>Result<T> error(){
        return new Result<>(500, "internal error",null);
    }
}

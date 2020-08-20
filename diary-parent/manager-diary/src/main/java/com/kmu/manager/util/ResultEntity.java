package com.kmu.manager.util;





/**
 * @作者：Deng 时间：2020/7/21 17:46
 * 网络传输的实体类，将来传输数据，使用这个类进行传输
 * 包含传输时的所用的信息
 */
public class ResultEntity<T> {

    public static final String CODE_SUCCESS = "SUCCESS";
    public static final String CODE_FAILED = "FAILED";

    //设定状态码，前端更具状态码判断成功、失败的响应
    private String code;

    //回显消息
    private String msg;

    //回显数据
    T data;
    public static  ResultEntity successWithData(Object data){
        ResultEntity<Object> objectResultEntity = new ResultEntity<>();
        objectResultEntity.code = CODE_SUCCESS;
        objectResultEntity.setData(data);
        return objectResultEntity;
    }
    public static ResultEntity failedWithData(Object data){
        ResultEntity<Object> objectResultEntity = new ResultEntity<>();
        objectResultEntity.code = CODE_FAILED;
        objectResultEntity.setData(data);
        return objectResultEntity;
    }


    public ResultEntity(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;


    }

    public static  ResultEntity successWithData(String msg,Object data){
        ResultEntity<Object> objectResultEntity = new ResultEntity<>();
        objectResultEntity.code = CODE_SUCCESS;
        objectResultEntity.setMsg(msg);
        objectResultEntity.setData(data);
        return objectResultEntity;
    }
    public static ResultEntity failedWithData(String msg,Object data){
        ResultEntity<Object> objectResultEntity = new ResultEntity<>();
        objectResultEntity.code = CODE_FAILED;
        objectResultEntity.setMsg(msg);
        objectResultEntity.setData(data);
        return objectResultEntity;
    }

    //成功or失败
    public static ResultEntity success() {
        ResultEntity<Object> objectResultEntity = new ResultEntity<>();
        objectResultEntity.code = CODE_SUCCESS;
        return objectResultEntity;
    }

    public static ResultEntity failed() {
        ResultEntity<Object> objectResultEntity = new ResultEntity<>();
        objectResultEntity.code = CODE_FAILED;
        return objectResultEntity;
    }
    public ResultEntity(){

    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

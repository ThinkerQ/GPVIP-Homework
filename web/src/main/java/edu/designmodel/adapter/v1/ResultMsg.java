package edu.designmodel.adapter.v1;

/**
 * 返回结果
 * Created by King on 2019/3/24.
 */
public class ResultMsg {
    private Integer code;
    private String message;
    private Object data;

    public ResultMsg(Integer code,String message,Object data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

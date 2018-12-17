package com.zgg.web.common.json;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonView;

/**
 * web前端json数据处理类
 */
public class JsonResult<T> implements Serializable {
    public static interface ErrorView {}
    public static interface NormalView extends ErrorView {}
    private static final long serialVersionUID = 3863559687276427577L;

    @JsonView(ErrorView.class)
    private Boolean success = true;
    
    @JsonView(NormalView.class)
    private T data;//数据

    @JsonView(ErrorView.class)
    private String code;//返回给调用者的错误码（如：100001）

    @JsonView(ErrorView.class)
    public String message;

    public JsonResult() {
    }
    
	public JsonResult(T data, String code) {
        this.data = data;
        this.code = code;
    }
	
    public JsonResult(T data, Boolean success, String message) {
        this.data = data;
        this.success = success;
        this.message = message;
    }
    
    public JsonResult(T data, String code, String message) {
        this.data = data;
        this.code = code;
        this.message = message;
    }
    
    public JsonResult(T data, Boolean success, String code,String message) {
        this.data = data;
        this.success = success;
        this.message = message;
        this.code = code;
    }

    public JsonResult(Boolean success, String code, String message) {
        this.success =success;
        this.code = code;
        this.message = message;
    }
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static <T> JsonResult<T> newResult() {

        return new JsonResult<T>();
    }

	public void setCode(String code) {
		this.code = code;
	}

    public String getCode() {
		return code;
	}
}

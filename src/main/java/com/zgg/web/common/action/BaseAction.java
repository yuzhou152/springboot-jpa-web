/**   
 * @Title: BaseAction.java 
 * @version V1.0   
 */
package com.zgg.web.common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zgg.web.common.code.CodeEC;
import com.zgg.web.common.json.JsonResult;

/**
 * 控制层基
 * 
 * @ClassName: BaseAction
 * @Description: BaseAction工具
 * @author
 *
 */

public class BaseAction {
	protected Logger logger = LoggerFactory.getLogger(BaseAction.class);
	private static ThreadLocal<HttpServletRequest> requestHolder = new ThreadLocal<>();
	private static ThreadLocal<HttpServletResponse> responseHolder = new ThreadLocal<>();

	/**
	 * 初始化
	 */
	public void init(HttpServletRequest request, HttpServletResponse response) {
		requestHolder.set(request);
		responseHolder.set(response);
	}

	/**
	 * 得到request对象
	 */
	public HttpServletRequest getRequest() {
		return requestHolder.get();
	}

	/**
	 * 得到response对象
	 */
	public HttpServletResponse getResponse() {
		return responseHolder.get();
	}

	public <T> JsonResult<T> buildSuccessJsonResult(T obj, CodeEC codeEC) {
		return new JsonResult<T>(obj, true, codeEC.getCode(), codeEC.getName());
	}

	public <T> JsonResult<T> buildFailJsonResult(CodeEC codeEC) {
		return new JsonResult<T>(false, codeEC.getCode(), codeEC.getName());
	}

	public <T> JsonResult<T> buildFailJsonResult( String code, String message) {
		return new JsonResult<T>(false ,code, message);
	}

	public static <T> JsonResult<T> buildJsonResult(T obj, Boolean success, String code, String message) {
		return new JsonResult<T>(obj, success, code, message);
	}
}

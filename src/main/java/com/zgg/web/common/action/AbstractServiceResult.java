package com.zgg.web.common.action;

import com.zgg.web.common.code.CodeEC;
import com.zgg.web.common.json.ServiceResult;

public class AbstractServiceResult{
	/**
     * 返回成功信息
     * @param obj
     * @return
     */
	public  <T> ServiceResult<T> buildSuccessResult(T obj){
    	return new ServiceResult<T>(CodeEC.SUCCESS.getCode(),CodeEC.SUCCESS.getName(),obj);
    }
    
	/**
     * 返回信息
     * @param obj
     * @return
     */
	public  <T> ServiceResult<T> buildResult(CodeEC codeEC){
    	return new ServiceResult<T>(codeEC.getCode(),codeEC.getName(),null);
    }
    
	/**
     * 返回信息
     * @param obj
     * @return
     */
	public  <T> ServiceResult<T> buildResult(CodeEC codeEC, T obj){
    	return new ServiceResult<T>(codeEC.getCode(),codeEC.getName(),obj);
    }
}

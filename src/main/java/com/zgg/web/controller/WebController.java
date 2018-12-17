package com.zgg.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zgg.web.common.action.BaseAction;
import com.zgg.web.common.code.CodeEC;
import com.zgg.web.common.json.JsonResult;
import com.zgg.web.pojo.ZgUser;
import com.zgg.web.pojo.vo.ZgUserVo;
import com.zgg.web.service.ZgUserService;

@RestController
@RequestMapping("webController")
public class WebController extends BaseAction {
	private final static Logger logger = LoggerFactory.getLogger(WebController.class);

	@Autowired
	private ZgUserService zgUserService;


	@RequestMapping(value = "method1/{id}", method = RequestMethod.GET)
	public JsonResult<ZgUser> method1(@PathVariable Integer id) {
		try {
			ZgUser sr = zgUserService.getZgUserById(id);
			return buildSuccessJsonResult(sr, CodeEC.SUCCESS);
		} catch (Exception e) {
			logger.error("error msg.", e);
			return buildFailJsonResult(CodeEC.NONE);
		}
	}
	
	@RequestMapping(value = "method2", method = RequestMethod.POST)
	public JsonResult<Page<ZgUser>> method2(@RequestBody ZgUserVo vo) {
		try {
			Page<ZgUser> sr = zgUserService.getZgUserListByParam(vo);
			return buildSuccessJsonResult(sr, CodeEC.SUCCESS);
		} catch (Exception e) {
			logger.error("error msg.", e);
			return buildFailJsonResult(CodeEC.NONE);
		}
	}
	
	@RequestMapping(value = "method3", method = RequestMethod.PUT)
	public JsonResult<ZgUser> method3(@RequestBody ZgUser zgUser) {
		try {
			zgUserService.updateOrSaveZgUser(zgUser);
			return buildSuccessJsonResult(null, CodeEC.SUCCESS);
		} catch (Exception e) {
			logger.error("error msg.", e);
			return buildFailJsonResult(CodeEC.NONE);
		}
	}
	
	@RequestMapping(value = "method4/{id}", method = RequestMethod.DELETE)
	public JsonResult<List<ZgUser>> method4(@PathVariable Integer id) {
		try {
			zgUserService.delete(id);
			return buildSuccessJsonResult(null, CodeEC.SUCCESS);
		} catch (Exception e) {
			logger.error("error msg.", e);
			return buildFailJsonResult(CodeEC.NONE);
		}
	}
}

package com.zgg.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.zgg.web.dao.ZgUserRepository;
import com.zgg.web.pojo.ZgUser;
import com.zgg.web.pojo.vo.ZgUserVo;
import com.zgg.web.scheduler.redis.handler.RedisHandler;

@Service
//@Transactional(rollbackFor = Exception.class, propagation=Propagation.SUPPORTS, readOnly=true) 查询
//@Transactional(rollbackFor = Exception.class, propagation=Propagation.REQUIRED) 更新
public class ZgUserService {
	@Autowired
	private RedisHandler redisHandler;
	
    @Autowired
    private ZgUserRepository zgUserRepository;

	public Page<ZgUser> getZgUserListByParam(ZgUserVo vo) {
    	ExampleMatcher matcher = ExampleMatcher.matching()
//                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.startsWith());//模糊查询匹配开头，即{username}%
                .withMatcher("name" ,ExampleMatcher.GenericPropertyMatchers.contains());//全部模糊查询，即%{address}%
//                .withIgnorePaths("password");//忽略字段，即不管password是什么值都不加入查询条件
        Example<ZgUser> example = Example.of(vo.getZgUser() ,matcher);
    	Page<ZgUser> resultDealing = (Page<ZgUser>) zgUserRepository.findAll(example, new PageRequest(vo.getPage(), vo.getSize()));
		return resultDealing;
	}

	public ZgUser getZgUserById(Integer id) {
    	ZgUser result = this.zgUserRepository.findOne(id);
		return result;
	}

	public void updateOrSaveZgUser(ZgUser zgUser) {
    	zgUserRepository.save(zgUser);
	}

	public void delete(Integer id) {
    	zgUserRepository.delete(id);
	}


}

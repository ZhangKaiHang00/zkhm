package com.bobo.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bobo.cms.dao.UserMapper;
import com.bobo.cms.domain.User;
import com.bobo.cms.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;

	@Override
	public PageInfo<User> selects(String name,Integer page,Integer pageSize) {
		PageHelper.startPage(page, pageSize);
		List<User> list = userMapper.selects(name);
		return new PageInfo<User>(list);
	}

	@Override
	public int updateByPrimaryKeySelective(User record) {
		return userMapper.updateByPrimaryKeySelective(record);
	}

}
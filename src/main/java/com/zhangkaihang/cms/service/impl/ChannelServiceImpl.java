package com.zhangkaihang.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhangkaihang.cms.dao.CategoryMapper;
import com.zhangkaihang.cms.dao.ChannelMapper;
import com.zhangkaihang.cms.domain.Category;
import com.zhangkaihang.cms.domain.Channel;
import com.zhangkaihang.cms.service.ChannelService;
@Service
public class ChannelServiceImpl implements ChannelService {
	@Resource
	private ChannelMapper channerMapper;
	
	@Resource
	private CategoryMapper categoryMapper;

	@Override
	public List<Channel> selects() {
		return channerMapper.selects();
	}

	@Override
	public List<Category> selectsByChannelId(Integer channelId) {
		// TODO Auto-generated method stub
		return categoryMapper.selectsByChannelId(channelId);
	}

}

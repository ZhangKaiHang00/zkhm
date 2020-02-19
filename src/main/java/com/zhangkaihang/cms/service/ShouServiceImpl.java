package com.zhangkaihang.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhangkaihang.cms.dao.ArticlesShouMapper;
import com.zhangkaihang.cms.domain.ArticlesShou;
import com.zhangkaihang.cms.util.CMSException;
import com.zhangkaihang.common.utils.StringUtil;

@Service
public class ShouServiceImpl implements ShouService{

	@Autowired
	ArticlesShouMapper articlesShouMapper;

	@Override
	public List<ArticlesShou> selects() {
		// TODO Auto-generated method stub
		return articlesShouMapper.selects();
	}

	@Override
	public boolean insert(ArticlesShou articlesShou) {
		try {
			//收藏的地址是否合法
			boolean b = StringUtil.isHttpUrl(articlesShou.getUrl());
			if(!b) {
				throw new CMSException("url 不合法");
			}
			
			//收藏 
			articlesShouMapper.insert(articlesShou);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("收藏失败");
			
		}
	}

	@Override
	public ArticlesShou select(Integer id) {
		// TODO Auto-generated method stub
		return articlesShouMapper.select(id);
	}
	
	
	
}

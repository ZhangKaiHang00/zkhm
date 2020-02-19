package com.zhangkaihang.cms.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zhangkaihang.cms.domain.Complain;
import com.zhangkaihang.cms.vo.ComplainVO;

public interface ComplainService {
	//投诉
	boolean insert(Complain complain);
	
	//查询投诉
	PageInfo<Complain> selects(ComplainVO complainVO,Integer page,Integer pageSize);
	
	Complain select(Integer id);
	
}

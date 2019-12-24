package com.zhangkaihang.cms.dao;

import java.util.List;

import com.zhangkaihang.cms.domain.Complain;
import com.zhangkaihang.cms.vo.ComplainVO;

public interface ComplainMapper {
	
	int insert(Complain complain);
	
	//查询举报
	List<Complain> selects(ComplainVO complainVO);

}

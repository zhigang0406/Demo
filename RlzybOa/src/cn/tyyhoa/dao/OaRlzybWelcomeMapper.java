package cn.tyyhoa.dao;

import java.util.List;


import cn.tyyhoa.pojo.OaRlzybEmployee;
import cn.tyyhoa.pojo.OaRlzybItem;

public interface OaRlzybWelcomeMapper {
	// 事项提醒查询
	List<OaRlzybItem> itemList();
	// 查询记录数
	int totaCount();
	// 新增事项
	int insertItem(OaRlzybItem oa);
	// 删除
	int del(int id);
	// 查询全部员工
	List<OaRlzybEmployee> selectAll();
}

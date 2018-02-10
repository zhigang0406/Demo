package cn.tyyhoa.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tyyhoa.pojo.OaRlzybEmployee;
import cn.tyyhoa.pojo.OaRlzybItem;
import cn.tyyhoa.service.OaRlzybWelcomeService;
import cn.tyyhoa.dao.OaRlzybWelcomeMapper;
@Service("oaRlzybWelcomeService")
public class OaRlzybWelcomeServiceImpl implements OaRlzybWelcomeService {
	@Autowired
	private OaRlzybWelcomeMapper OaRlzybWelcomeMapper;

	@Override
	public List<OaRlzybItem> itemList() {
		
		return OaRlzybWelcomeMapper.itemList();
	}

	@Override
	public int totaCount() {
		
		return OaRlzybWelcomeMapper.totaCount();
	}

	@Override
	public int insertItem(OaRlzybItem oa) {
		
		return OaRlzybWelcomeMapper.insertItem(oa);
	}

	@Override
	public int del(int id) {
		
		return OaRlzybWelcomeMapper.del(id);
	}

	@Override
	public List<OaRlzybEmployee> selectAll() {
		return OaRlzybWelcomeMapper.selectAll();
	}

	

}

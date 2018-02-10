package cn.tyyhoa.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import cn.tyyhoa.dao.OaRlzybEmployeeMapper;
import cn.tyyhoa.pojo.OaRlzybDimission;
import cn.tyyhoa.pojo.OaRlzybEmployee;
import cn.tyyhoa.pojo.OaRlzybItem;
import cn.tyyhoa.service.OaRlzybDimissionService;
import cn.tyyhoa.service.OaRlzybWelcomeService;
import cn.tyyhoa.util.Page;

@Controller
public class OaRlzybWelcomeController {
	@Resource(name="oaRlzybWelcomeService")
	private OaRlzybWelcomeService orws;
	public OaRlzybWelcomeService getOrws() {
		return orws;
	}
	public void setOrws(OaRlzybWelcomeService orws) {
		this.orws = orws;
	}
	
	@RequestMapping(value="/OaRlzybWelcome",method=RequestMethod.POST)
 	@ResponseBody
	public List<OaRlzybItem> OaRlzybWelcome(){
		List<OaRlzybItem> list = orws.itemList();
		return list;
	}
	
	//总记录数
	@RequestMapping(value="/totaCount",method=RequestMethod.POST)
 	@ResponseBody
	public int totaCount(){
		int count = orws.totaCount();
		return count;
	}
	//增加事项
	@RequestMapping(value="/insertItem",method=RequestMethod.POST)
 	@ResponseBody
	public int insertItem(String name,String text){
		OaRlzybItem oa=new OaRlzybItem();
		oa.setName(name);
		oa.setText(text);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		Date times=new Date(System.currentTimeMillis());
		String time=sdf.format(times);
		oa.setTime(time);
		System.out.println(time);
		int item = orws.insertItem(oa);
		return item;
	}
	//删除
	@RequestMapping(value="/del",method=RequestMethod.POST)
 	@ResponseBody
	public int del(String id){
		int ids=0;
		if(id!=null||id!=""){
			ids=Integer.parseInt(id);
		}
		int del = orws.del(ids);
		return del;
	}
	
	//查询全部员工
	
	@RequestMapping(value="/selectAll",method=RequestMethod.POST)
 	@ResponseBody
	public List<OaRlzybEmployee> all(){
		List<OaRlzybEmployee> al = orws.selectAll();
		return al;
	}
}

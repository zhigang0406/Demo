package cn.tyyhoa.controller;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import cn.tyyhoa.pojo.OaRlzybDepartment;
import cn.tyyhoa.pojo.OaRlzybDimission;
import cn.tyyhoa.pojo.OaRlzybEmployee;
import cn.tyyhoa.pojo.OaRlzybInterview;
import cn.tyyhoa.service.OaRlzybDepartmentService;
import cn.tyyhoa.service.OaRlzybDimissionService;
import cn.tyyhoa.service.OaRlzybEmployeeService;
import cn.tyyhoa.service.OaRlzybInterviewService;

@Controller
public class OaRlzybDimissionController {

	@Autowired
	OaRlzybDimissionService oaRlzybDimissionService;
	@Autowired
	OaRlzybDepartmentService oaRlzybDepartmentService;
	@Autowired
	OaRlzybEmployeeService oaRlzybEmployeeService;
	
	int dimission_statuss = -1;
	
	public List<OaRlzybDepartment> oaRlzybDepartments;
	List<OaRlzybDimission> OaRlzybDimissions;
	
	List<OaRlzybEmployee> oaRlzybEmployees;
	
	OaRlzybDimission oaRlzybDimission;
	
	@RequestMapping("/dimission_search.html")
	public String interview_search1(){
		return "human_resource_department/dimission_search";
	}
	
	@RequestMapping("/dimission_show.html")
	public String show(){
		return "human_resource_department/dimission_show";
	}
	
	@ResponseBody
	@RequestMapping(value="/dimission_search",method=RequestMethod.POST)
	public Object dimission_search(
			@RequestParam(required=false)String dimission_status,
			@RequestParam(required=false)String emp_name,
			@RequestParam(required=false)String dimission_date1,
			@RequestParam(required=false)String dimission_date2,
			@RequestParam(required=false)String pageIndex,
			@RequestParam(required = false) String pageSize,
			HttpServletRequest request) throws ParseException{

		
		int score = -1;
		System.out.println(pageSize);
		if(pageSize!=""||pageSize!=null){
			score=Integer.parseInt(pageSize);
		}
		
		
		if(dimission_status != null && dimission_status != ""){
			dimission_statuss = Integer.parseInt(dimission_status);
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date interviewDate1 = null;
		
		if(dimission_date1 != null && dimission_date1 != ""){
			interviewDate1 = sdf.parse(dimission_date1);
			
		}
		Date interviewDate2 = null;
		
		if(dimission_date2 != null && dimission_date2 != ""){
			interviewDate2 = sdf.parse(dimission_date2);
			
		}
		
		int count = oaRlzybDimissionService.selectCount(dimission_statuss,emp_name, interviewDate1,interviewDate2);
		
		
		int pageCount = count % score == 0 ? count / score : count / score + 1;	//总页数
		if(pageCount < 1){
			pageCount = 1;
		}
		
		Integer PageIndex = 1;
		if(pageIndex != null && pageIndex != ""){
			PageIndex = Integer.parseInt(pageIndex);	//当前页数
		}
		
		if(PageIndex < 1){
			PageIndex = 1;
    	}else if(PageIndex > pageCount){
    		PageIndex = pageCount;
    	}
		
		int startPos = score * (PageIndex - 1);
		//查询所有人员离职状态
		List<OaRlzybDimission> chaxun = oaRlzybDimissionService.selectAll(-1,emp_name, interviewDate1,interviewDate2, startPos, score);
		//循环每个离职时间并自动修改离职状态
		for (OaRlzybDimission oa : chaxun) {
			SimpleDateFormat geshi=new SimpleDateFormat("yyyy-MM-dd");
			Date date = oa.getDimission_date();
			Integer status = oa.getDimission_status();
			String date1 = geshi.format(date);
			System.out.println(date1);
			long dates = date.getTime();
			System.out.println(dates);
			Date now = new Date();
			String nows = geshi.format(now);
			System.out.println(nows);
			Date date2 = geshi.parse(nows);
			long date2s = date2.getTime();
			System.out.println(date2s);
			long time= dates - date2s;
			System.out.println(time/1000*60*60*24);
			if (0<time/1000*60*60*24 && time/1000*60*60*24<=30 && status != 3) {
				System.out.println("待离职");
				Integer dimissionid = oa.getDimission_id();
				oaRlzybDimissionService.updatedimissionStatu(dimissionid, 2);
			}else if (time/1000*60*60*24<0 && status != 3 ){
				System.out.println("已离职");
				Integer dimissionid1 = oa.getDimission_id();
				oaRlzybDimissionService.updatedimissionStatu(dimissionid1, 1);
			}
		}
		
		//按离职状态查询所有信息
		OaRlzybDimissions = oaRlzybDimissionService.selectAll(dimission_statuss,emp_name, interviewDate1,interviewDate2, startPos, score);
		
		

		String oa1 = JSON.toJSONStringWithDateFormat(OaRlzybDimissions, "YYYY-MM-dd HH:mm:ss");
		StringBuffer sb = new StringBuffer();
		
		sb.append("{");
		sb.append("\"OaRlzybDimissions\":");
		sb.append(oa1);
		sb.append(",\"totalPageCount\":");
		sb.append(pageCount);
		sb.append(",\"totalCount\":");
		sb.append(count);
		sb.append(",\"currentPageNo\":");
		sb.append(PageIndex);
		sb.append("}");
		System.out.println(sb.toString());
		return JSONArray.toJSONString(sb);
	}
	

	
	@RequestMapping("dimission_add.html")
	public String dimission_add(HttpServletRequest request){
		oaRlzybDepartments = oaRlzybDepartmentService.selectAll();
		request.setAttribute("oaRlzybDepartments", oaRlzybDepartments);
		return "human_resource_department/dimission_add";
	}
	
	@ResponseBody
	@RequestMapping(value="/dimission_add")
	public Object interview_add1(@RequestParam(required=false)String emp_name){
		
		try {
			emp_name=new String(emp_name.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(emp_name);
		oaRlzybEmployees = oaRlzybEmployeeService.selectAll(emp_name);
		return JSONArray.toJSONString(oaRlzybEmployees);
	}
	/**
	 * 增加离职信息
	 * @param emp_id
	 * @param dimission_date
	 * @param dimission_reason
	 * @param dimission_approver
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value="/dimission_add",method=RequestMethod.POST)
	@ResponseBody
	public int interview_add2(
			@RequestParam(required=false)String emp_id,
			@RequestParam(required=false)String dimission_date,
			@RequestParam(required=false)String dimission_reason,
			@RequestParam(required=false)String dimission_approver,
			@RequestParam(required=false)String dimission_status,
			HttpServletRequest request) throws ParseException{
		
		OaRlzybDimission oa = new OaRlzybDimission();
		Integer emp_id2 = 0;
		if(emp_id != null){
			emp_id2 = Integer.parseInt(emp_id);
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Integer dimission_status2=0;
		if(dimission_status!=null){
			dimission_status2 = Integer.parseInt(dimission_status);
		}
		if(dimission_status2==1){
			//获取系统当前时间
			Date d1=new Date();
			String format = sdf.format(d1);
			if(format.equals(dimission_date)){
				oaRlzybDimissionService.updatedimissionStatus(emp_id2);
			}
		}
		oa.setDimission_status(dimission_status2);
		
		Date d = sdf.parse(dimission_date);
		
		oa.setEmp_id(emp_id2);
		oa.setDimission_date(d);
		oa.setDimission_reason(dimission_reason);
		oa.setDimission_approver(dimission_approver);
		oa.setDimission_delectStatus(1);
		
		Date date = new Date();
		
		oa.setCreate_time(date);
		
		boolean flag = oaRlzybDimissionService.insertSelective(oa);
		if(flag == true){
			
			OaRlzybEmployee emp = new OaRlzybEmployee();
			
			emp.setEmp_id(emp_id2);
			emp.setEmp_now_status("离职");
			
			oaRlzybEmployeeService.updateStatus(emp);
			
			return 1;
		}
		return 0;
	}
	
	@RequestMapping(value="/dimission_show",produces = "text/html;charset=UTF-8")
	public String dimission_show(@RequestParam(required=false)String dimission_id,
			HttpServletRequest request){
		
		Integer dimissionId = 0;
		if(dimission_id != null){
			dimissionId = Integer.parseInt(dimission_id);
		}
		
		oaRlzybDimission = oaRlzybDimissionService.selectShow(dimissionId);
		
		Date d = oaRlzybDimission.getDimission_date();
		int year = d.getYear() + 1900;
		int month = d.getMonth() + 1;
		int day = d.getDate();
		
		String mon = "" + month;
		String date = "" + day;
		
		if(month < 10){
			mon = "0" + month;
		}
		if(day < 10){
			date = "0" + day;
		}
		
		String time = year + "-" + mon + "-" + date;
		
		request.setAttribute("oaRlzybDimission", oaRlzybDimission);
		request.setAttribute("dimission_date", time);
		
		return "human_resource_department/dimission_show";
	}
	
	
	@ResponseBody
	@RequestMapping(value="/dimission_delete",produces = "text/html;charset=UTF-8")
	public Object dimission_delete(
			@RequestParam(required=false)String dimission_id){
		Integer dimission_id2 = 0;
		
		if(dimission_id != null && dimission_id != ""){
			dimission_id2 = Integer.parseInt(dimission_id);
		}
		
		Boolean flag = oaRlzybDimissionService.updateDelete(dimission_id2);
		
		return JSONArray.toJSONString(flag);
		
	}
	
	
	
	
}


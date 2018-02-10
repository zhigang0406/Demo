package cn.tyyhoa.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import cn.tyyhoa.pojo.OaRlzybContract;
import cn.tyyhoa.pojo.OaRlzybEmployee;
import cn.tyyhoa.service.OaRlzybContractService;
import cn.tyyhoa.service.OaRlzybEmployeeService;
import cn.tyyhoa.util.Page;

@Controller
public class OaRlzybContractController {

	@Autowired
	OaRlzybContractService oaRlzybContractService;
	
	List<OaRlzybContract> oaRlzybContracts;
	
	OaRlzybContract oaRlzybContract;
	
	@Autowired
	OaRlzybEmployeeService oaRlzybEmployeeService;
	
	List<OaRlzybEmployee> oaRlzybEmployees;
	
	OaRlzybEmployee oaRlzybEmployee;
	
	@RequestMapping("/employee_contract_search.html")
	public String employee_contract_search(){
		
		return "human_resource_department/employee_contract_search";
	}
	
	
	@ResponseBody
	@RequestMapping(value="/employee_contract_search",method=RequestMethod.POST)
	public Object showAllContract(
			@RequestParam(required = false) String emp_name,
			@RequestParam(required = false) String contract_id,
			@RequestParam(required = false) String contract_startDate,
			@RequestParam(required = false) String contract_endDate,
			@RequestParam(required = false) String contract_status,
			@RequestParam(required = false) String pageIndex,
			@RequestParam(required = false) String pageSize,
			HttpServletRequest request,HttpSession session,Model model) throws ParseException{
		
		int score = -1;
		System.out.println(pageSize);
		if(pageSize!=""||pageSize!=null){
			score=Integer.parseInt(pageSize);
		}
		
		
		List<OaRlzybContract> allContract = oaRlzybContractService.selectAll();
    	
		Date now = new Date();
		
		for (OaRlzybContract oaRlzybContract : allContract) {
			System.out.println("进来了");
    		OaRlzybEmployee oaRlzybEmployee1=new OaRlzybEmployee();
    		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    		Date endDate = oaRlzybContract.getContract_endDate();
    		long endDate1 = endDate.getTime();
    		String nows = sdf.format(now);
    		Date nowDate = sdf.parse(nows);
    		long nowDate1 = nowDate.getTime();
    		long times= endDate1-nowDate1;
    		if(times/(1000*60*60*24)>=30){
				oaRlzybEmployee1.setContract_status("已签订");
			}else if(0<times/(1000*60*60*24)&&times/(1000*60*60*24)<30){
				oaRlzybEmployee1.setContract_status("即将到期");
			}else{
				oaRlzybEmployee1.setContract_status("已到期");
			}
    		oaRlzybEmployee1.setEmp_id(oaRlzybContract.getEmp_id());
    		oaRlzybEmployee1.setContract_endDate(new SimpleDateFormat("yyyy-MM-dd").format(oaRlzybContract.getContract_endDate()));
    	    Boolean ss = oaRlzybEmployeeService.updateByContractEndDate(oaRlzybEmployee1);
		}
		
		Integer contractId = 0;
		if(contract_id != null && contract_id != ""){
			contractId = Integer.parseInt(contract_id);
		}
		
		int count = oaRlzybEmployeeService.selectCount(emp_name, contractId, contract_startDate, contract_endDate, contract_status);
		
	
		int	pageCount = count % score == 0 ? count / score : count / score + 1;	//总页数
	if(pageCount==0){
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
		

		
    	oaRlzybEmployees = oaRlzybEmployeeService.selectAllContract(emp_name, contractId, contract_startDate, contract_endDate, contract_status, startPos, score);
		
		for (OaRlzybEmployee oaRlzybEmployee : oaRlzybEmployees) {
				System.out.println(oaRlzybEmployee.getEmp_name()+oaRlzybEmployee.getContract_status());
			if(oaRlzybEmployee.getContract_num() == null){
				oaRlzybEmployee.setContract_status("未签订");
			}else if(oaRlzybEmployee.getContract_endDate()==null){
				oaRlzybEmployee.setContract_status("未签订");
				oaRlzybEmployee.setContract_endDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			}else{
				
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				
				
				//确保时间一致获取毫秒数并用作之后计算
				String asd = oaRlzybEmployee.getContract_endDate();
				System.out.println(asd);
				Date end = sdf.parse(asd);
				System.out.println(end);
				System.out.println(end.getYear()+"/"+end.getMonth()+"/"+end.getDay()+"/"+end.getDate());
				System.out.println(sdf.format(end));
				String aaa = sdf.format(now);
				System.out.println(aaa);
				Date bbb = sdf.parse(aaa);
				System.out.println(bbb);
				long qq = end.getTime();
				long ww = bbb.getTime();
				long xx = qq - ww;
				
				if(xx/(1000*60*60*24)>=30){
					oaRlzybEmployee.setContract_status("已签订");
				}else if(0<xx/(1000*60*60*24)&&xx/(1000*60*60*24)<30){
					oaRlzybEmployee.setContract_status("即将到期");
				}else{
					oaRlzybEmployee.setContract_status("已到期");
				}
			}
			oaRlzybEmployee.setEmp_id(oaRlzybEmployee.getEmp_id());
			oaRlzybEmployee.setContract_endDate(oaRlzybEmployee.getContract_endDate());
		    oaRlzybEmployeeService.updateByContractEndDate(oaRlzybEmployee);
		}
		
		int count2 = oaRlzybEmployeeService.selectCount(emp_name, contractId, contract_startDate, contract_endDate, contract_status);
		Object obj = JSONArray.toJSONString(oaRlzybEmployees);
		Object totalPageCount = JSONArray.toJSONString(pageCount);
		Object totalCount = JSONArray.toJSONString(count);
		Object totalCount2 = JSONArray.toJSONString(count2);
		Object currentPageNo = JSONArray.toJSONString(PageIndex);
		
		session.setAttribute("obj", obj);
		session.setAttribute("totalPageCount", totalPageCount);
		session.setAttribute("totalCount", totalCount);
		session.setAttribute("totalCount2", totalCount2);
		session.setAttribute("currentPageNo", currentPageNo);
		
		String oa = JSON.toJSONStringWithDateFormat(oaRlzybEmployees, "YYYY-MM-dd HH:mm:ss");
		StringBuffer sb = new StringBuffer();
		
		sb.append("{");
		sb.append("\"oaRlzybEmployees\":");
		sb.append(oa);
		sb.append(",\"totalPageCount\":");
		sb.append(pageCount);
		sb.append(",\"totalCount\":");
		sb.append(count);
		sb.append(",\"totalCount2\":");
		sb.append(count2);
		sb.append(",\"currentPageNo\":");
		sb.append(PageIndex);
		sb.append("}");
		
		 /*Map<String, Object> map = new HashMap<String, Object>();
		 map.put("obj", oaRlzybEmployees);
		 map.put("totalPageCount", pageCount);
		 map.put("totalCount", count);
		 map.put("currentPageNo", PageIndex);*/
		 
		 System.out.println(sb.toString());
		
		return JSONArray.toJSONString(sb);
		
	}
	
	@ResponseBody
	@RequestMapping(value="/employee_contract_insert",method=RequestMethod.POST)
	public int insertContract(
			@RequestParam(required = false) String contract_id,
			@RequestParam(required = false) String emp_id,
			@RequestParam(required = false) String contract_startDate,
			@RequestParam(required = false) String contract_endDate,
			@RequestParam(required = false) String contract_company,
			HttpServletRequest request){
		
		
		int contractid =-1;
		int empid=-1; 

		if(contract_id != null && contract_id != ""){
			contractid = Integer.parseInt(contract_id);
		}
	
		if(emp_id != null && emp_id != ""){
			empid = Integer.parseInt(emp_id);
		}

		
		
		System.out.println(contract_id);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date contractStartDate = null;
		Date contractEndDate = null;
		if(contract_startDate != null || contract_startDate != ""){
			try {
				contractStartDate = sdf.parse(contract_startDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if(contract_endDate != null || contract_endDate != ""){
			try {
				contractEndDate = sdf.parse(contract_endDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		System.out.println(contractStartDate);
		
		Date date = new Date();
		
		int count = oaRlzybContractService.addContract(contractid, empid, contractStartDate, contractEndDate, "已签订", contract_company, 1, date);
		
		return count;
	}
	
	
	@RequestMapping("/employee_contract_add")
	public String employee_contract_add2(@RequestParam(required = false) String emp_id,
			HttpServletRequest request){		
		Integer empId = 0;
		
		if(emp_id != null){
			empId = Integer.parseInt(emp_id);
		}
		
		/*oaRlzybContract = oaRlzybContractService.showInfo(empId);*/
		oaRlzybEmployee = oaRlzybEmployeeService.showInfo(empId);
		oaRlzybContracts = oaRlzybContractService.selectContractId();
		
		request.setAttribute("oaRlzybContract", oaRlzybEmployee);
		request.setAttribute("oaRlzybContracts", oaRlzybContracts);
		
		return "human_resource_department/employee_contract_add";
	}

	@RequestMapping(value="/employee_contract_add",method=RequestMethod.POST)
	public int addContract(
			@RequestParam(required = false) String contract_id,
			@RequestParam(required = false) String depart_id,
			@RequestParam(required = false) String emp_id,
			@RequestParam(required = false) String position_id,
			@RequestParam(required = false) String contract_startDate,
			@RequestParam(required = false) String contract_endDate,
			@RequestParam(required = false) String contract_company,
			HttpServletRequest request){
		
		OaRlzybContract oa = new OaRlzybContract();
		
		if(contract_id != null && contract_id != ""){
			oa.setContract_id(Integer.parseInt(contract_id));
		}
		if(depart_id != null && depart_id != ""){
			oa.setEmp_department(Integer.parseInt(depart_id));
		}
		if(emp_id != null && emp_id != ""){
			oa.setEmp_id(Integer.parseInt(emp_id));
		}
		if(position_id != null && position_id != ""){
			oa.setEmp_position(Integer.parseInt(position_id));
		}
		System.out.println(contract_id);
		System.out.println(depart_id);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date contractStartDate = null;
		Date contractEndDate = null;
		if(contract_startDate != null || contract_startDate != ""){
			try {
				contractStartDate = sdf.parse(contract_startDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if(contract_endDate != null || contract_endDate != ""){
			try {
				contractEndDate = sdf.parse(contract_endDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		System.out.println(contractStartDate);
		oa.setContract_belong_company(contract_company);
		oa.setContract_status("已签订");
		oa.setContract_startDate(contractStartDate);
		oa.setContract_endDate(contractEndDate);
		oa.setContract_delectStatus(1);
		
		Date date = new Date();
		
		oa.setCreate_time(date);
		
		Boolean flag = oaRlzybContractService.insertSelective(oa);
		
		if(flag == true){
			return 1;
		}
		
		return 2;
		
	}
	
}

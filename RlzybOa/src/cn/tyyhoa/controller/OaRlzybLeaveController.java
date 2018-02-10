package cn.tyyhoa.controller;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Condition;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;

import org.apache.commons.lang.Validate;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;

import cn.tyyhoa.pojo.OaRlzybDepartment;
import cn.tyyhoa.pojo.OaRlzybEmployee;
import cn.tyyhoa.pojo.OaRlzybLeave;
import cn.tyyhoa.pojo.OaRlzybLeaveType;
import cn.tyyhoa.pojo.OaRlzybPosition;
import cn.tyyhoa.service.OaRlzybLeaveService;
import cn.tyyhoa.util.OaJzbRevoke;
import cn.tyyhoa.util.Page;
import cn.tyyhoa.util.totalDays;

@Controller
@RequestMapping("/Leave")
public class OaRlzybLeaveController {
	@Autowired
	private OaRlzybLeaveService leaveService;

	// 填充部门
	@RequestMapping(value = "/addDepartment", produces = "text/html;charset=UTF-8;")
	@ResponseBody
	public String getDepartment() {
		List<OaRlzybDepartment> oarlzybDepartmentName = leaveService
				.getAllDepartments();

		String optionStr = "";
		optionStr += "<option value='0'>请选择</option>";

		for (Iterator iterator = oarlzybDepartmentName.iterator(); iterator
				.hasNext();) {
			OaRlzybDepartment oaRlzybDepartment = (OaRlzybDepartment) iterator
					.next();
			optionStr += "<option value='" + oaRlzybDepartment.getDepart_id()
					+ "' >" + oaRlzybDepartment.getDepart_name() + "</option>";
		}
		return optionStr;
	}

	// 填充对应部门的员工姓名
	@RequestMapping(value = "/addEmployee", produces = "text/html;charset=UTF-8;")
	@ResponseBody
	public String getEmployee(@RequestParam("DepartmentId") String departmentId) {

		List<OaRlzybEmployee> oarlzybEmployeeName = leaveService
				.getAllEmployees(Integer.parseInt(departmentId));

		String optionStr = "";
		optionStr += "<option value='0'>请选择</option>";

		for (Iterator iterator = oarlzybEmployeeName.iterator(); iterator
				.hasNext();) {
			OaRlzybEmployee oaRlzybEmployee = (OaRlzybEmployee) iterator.next();
			optionStr += "<option value='" + oaRlzybEmployee.getEmp_id()
					+ "' >" + oaRlzybEmployee.getEmp_name() + "</option>";

		}
		return optionStr;
	}

	// 填充批准人列表
	@RequestMapping(value = "/addEmployeeContainPosition", produces = "text/html;charset=UTF-8;")
	@ResponseBody
	public String addEmployeeContainPosition(
			@RequestParam("DepartmentId") String departmentId) {
		List<OaRlzybEmployee> oarlzybEmployeeName = leaveService
				.getAllEmployees(Integer.parseInt(departmentId));
		String optionStr = "";
		optionStr += "<option value='无'>请选择</option>";
		for (Iterator iterator = oarlzybEmployeeName.iterator(); iterator
				.hasNext();) {
			OaRlzybEmployee oaRlzybEmployee = (OaRlzybEmployee) iterator.next();
			optionStr += "<option value='" + oaRlzybEmployee.getEmp_name()
					+ "' >" + oaRlzybEmployee.getEmp_name() + "-"
					+ oaRlzybEmployee.getEmp_position_name() + "</option>";
		}
		return optionStr;
	}

	// 填充对应员工的岗位名称
	@RequestMapping(value = "/addPosition", produces = "text/html;charset=UTF-8;")
	@ResponseBody
	public String getPosition(@RequestParam("PositionId") String positionId) {
		OaRlzybPosition oarlzybEmployeeName = leaveService
				.getAllPositions(Integer.parseInt(positionId));

		return oarlzybEmployeeName.getPosition_name();
	}

	// 填充离岗类型
	@RequestMapping(value = "/addLeaveType", produces = "text/html;charset=UTF-8;")
	@ResponseBody
	public String getType() {

		List<OaRlzybLeaveType> oarlzybLeaveType = leaveService
				.getAllLeaveType();

		String optionStr = "";
		optionStr += "<option value='0'>请选择</option>";

		for (Iterator iterator = oarlzybLeaveType.iterator(); iterator
				.hasNext();) {
			OaRlzybLeaveType oaRlzybLeaveType = (OaRlzybLeaveType) iterator
					.next();
			optionStr += "<option value='" + oaRlzybLeaveType.getLeave_type()
					+ "' >" + oaRlzybLeaveType.getLeave_type() + "</option>";
		}
		return optionStr;
	}
	/**
	 * 添加离岗信息
	 * @param method
	 * @param record
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	// 添加离岗原因所有数据
	@RequestMapping(value = "/addLeaveAllInfo/{method}", produces = "text/html;charset=UTF-8;")
	@ResponseBody
	public String addLeaveAllInfo(@PathVariable("method") String method,
			OaRlzybLeave record, HttpServletRequest request)
			throws ParseException {
		record.setLeave_delectStatus(1);
		record.setCreate_time(new Date(System.currentTimeMillis()));
		/**
		 * 起始日期和截止日期的处理
		 */
		// 起始日期和截止日期
		String leave_type = request.getParameter("leave_type");
		Date now = new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 起始日期
		String leave_startDate = request.getParameter("a_leave_startDate");
		if(leave_type.equals("外出")){
			leave_startDate = leave_startDate.replace('T', ' ')+":00";
		}else{
			leave_startDate = leave_startDate+" 00:00:00";
		}
		
		if (!leave_startDate.equals("")) {
			try {
				Date date1 = sdf.parse(leave_startDate.toString());
				record.setLeave_startDate(date1);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else {
			record.setLeave_startDate(now);
		}

		// 截止日期
		String leave_endDate = request.getParameter("a_leave_endDate");
		
		if(leave_type.equals("外出")){
			leave_endDate = leave_endDate.replace('T', ' ')+":00";
		}else{
			leave_endDate = leave_endDate+" 00:00:00";
		}
		if (!leave_endDate.equals("")) {
			try {
				Date date2 = sdf.parse(leave_endDate.toString());
				record.setLeave_endDate(date2);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else {
			record.setLeave_endDate(now);
		}

		// 判断一下,同一个方法执行不同的操作
		if (method.equals("CountDays")) {
			/**
			 * 计算请假合计多少天
			 */
			// 日期转换器: 将String类型的日期转换为Date类型的
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date dateS = format.parse(leave_startDate);
			Date dateE = format.parse(leave_endDate);
			int days = totalDays.differentDays(dateS, dateE);
			// 判断，如果截止日期在起始日期前面，那么，提醒用户，所填日期错误
			if (days < 0) {
				return "0";
			}else{
				if(leave_type.equals("外出")){
					if(days==0){
						return ((dateE.getTime()-dateS.getTime())/3600000)+"小时";
					}else{
						return ((dateE.getTime()-dateS.getTime())/86400000)+"天"+(Math.floor((dateE.getTime()-dateS.getTime())%86400000/3600000))+"小时";
					}
				}else{
					return days+"天";
				}
			}

		} else if (method.equals("SaveAllInfo")) {
			/**
			 * 判断添加到数据库是否成功！
			 */
			int row = leaveService.insertSelective(record);
			if (row == 1) {
				if (record.getLeave_type().equals("年假")
						|| record.getLeave_type().equals("婚假")
						|| record.getLeave_type().equals("产假")) {
					if (leaveService.updateOaRlzybEmployeeEmpNowStatusByEmpId(
							record.getEmp_id(), "停薪留职") == 1) {
						return "1";
					} else {
						return "0";
					}
				}
				// System.out.println(record.getLeave_approver()+"\t"+record.getLeave_reason()+"\t"+record.getLeave_type());
				return "1";
			} else {
				return "0";
			}
		} else {
			return "2";
		}

	}

	/**
	 * 查询离岗信息
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value = "/SelectAllInf", produces = "text/html;charset=UTF-8;")
	@ResponseBody
	// 查询所有离岗信息
	public Object SelectLeaveAllInf(
			@RequestParam(value = "leave_approver1", required = false) String leave_approver,
			@RequestParam(value = "leave_type1", required = false) String leave_type,
			@RequestParam(value = "pageIndex1", required = false) String pageIndex,
			@RequestParam(value = "pageSize1", required = false) String pageSiz,
			@RequestParam(value = "leave_startDate1", required = false) String leave_startDate,
			@RequestParam(value = "leave_endDate1", required = false) String leave_endDate,
			HttpServletRequest request) throws ParseException {
		
		
		String depart_id="0";
		
		// 处理按条件查询页面的问题
		Map<String, Object> result = new HashMap<>();
		String[] result_str = new String[2];

		Map<String, Object> condition = new HashMap<>();
		Page page = new Page();

		if (depart_id.equals("0")) {
			condition.put("depart_id", null);
		} else {
			condition.put("depart_id", depart_id);
		}
		if (leave_approver.equals("")) {
			condition.put("leave_approver", null);
		} else {
			condition.put("leave_approver", leave_approver);
		}
		if (leave_type.equals("0")) {
			condition.put("leave_type", null);
		} else {
			condition.put("leave_type", leave_type);
		}
		// 日期转换器
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if (leave_startDate.equals("")) {
			condition.put("leave_startDate", null);
		} else {
			condition.put("leave_startDate",
					format.parse(leave_startDate.toString()));
		}
		if (leave_endDate.equals("")) {
			condition.put("leave_endDate", null);
		} else {
			condition.put("leave_endDate",
					format.parse(leave_endDate.toString()));
		}
		int pageg=0;
		if(pageSiz != null && pageSiz != ""){
			pageg= Integer.parseInt(pageSiz);
		}
		// 分页
		page.setPageSize(pageg);// 页面大小
		// 总共有多少条
		page.setTotalCount(leaveService
				.selectOaRlzybLeaveCountByCondition(condition));
		int pa=0;
		if(pageIndex!=null || pageIndex!=""){
			pa=Integer.parseInt(pageIndex);
			
		}
		if(pageIndex.equals("0")){
			pageIndex="1";
		}
		page.setCurrentPageNo(Integer.parseInt(pageIndex));// 当前页的下标
		condition.put("fromIndex",(pa- 1) * pageg);
		condition.put("pageSize", pageg);
		page.setOaRlzybLeaveList(leaveService.getOaRlzybLeaveByPage(condition));
		List<OaRlzybLeave> oaRlzybLeave = page.getOaRlzybLeaveList();
		condition.put("resultCount", page.getTotalCount());
		int Count = page.getTotalCount();
		int pageSize = page.getPageSize();
		if (Count==0) {
			Count=1;
		}
		if (pageSize==0) {
			pageSize=1;
		}
		
		int inde=Count%pageSize==0?
				page.getTotalCount()/pageSize
				:(page.getTotalCount()/page.getPageSize())+1;
		int number = 0;
		// 设定一个拼接的string字符串

		String htmlStr = "";

		// 在前台填充查询条件
		
		for (Iterator iterator = oaRlzybLeave.iterator(); iterator.hasNext();) {
			OaRlzybLeave oaRlzybLeave2 = (OaRlzybLeave) iterator.next();
			number++;

			String numberStr = "";
			if (Integer.toString(number).length() <= 4) {
				for (int i = (4 - Integer.toString(number).length()); i > 0; i--) {
					numberStr += "0";
				}
			}
			numberStr = numberStr + Integer.toString(number);

			// 日期转换器
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
			String lsd = sdf.format(oaRlzybLeave2.getLeave_startDate());
			String led = sdf.format(oaRlzybLeave2.getLeave_endDate());
			OaJzbRevoke oaJzbRevoke = new OaJzbRevoke();
			if (oaJzbRevoke.Revoke(oaRlzybLeave2.getCreate_time())) {
				htmlStr += "<tr id='t' index="+pa +" pageSize="+inde+" count="+Count+" sc=0 emp_id="+oaRlzybLeave2.getEmp_id()+" leave_id="+oaRlzybLeave2.getLeave_id()+" leave_type="+oaRlzybLeave2.getLeave_type()+">";
			} else {
				htmlStr += "<tr id='t' index="+pa+" pageSize="+inde+" count="+Count+"  sc=1 emp_id="+oaRlzybLeave2.getEmp_id()+" leave_id="+oaRlzybLeave2.getLeave_id()+" leave_type="+oaRlzybLeave2.getLeave_type()+">";
			}
			htmlStr += "<td>" + numberStr + "</td>";
			htmlStr += "<td>" + oaRlzybLeave2.getEmp_name() + "</td>";
			htmlStr += "<td>" + oaRlzybLeave2.getPosition_name() + "</td>";
			htmlStr += "<td>" + oaRlzybLeave2.getDepart_name() + "</td>";
			htmlStr += "<td>" + oaRlzybLeave2.getLeave_type() + "</td>";
			htmlStr += "<td>" + oaRlzybLeave2.getLeave_reason() + "</td>";
			htmlStr += "<td>" + oaRlzybLeave2.getLeave_approver() + "</td>";
		if (!oaRlzybLeave2.getLeave_type().equals("产假")) {
				htmlStr += "<td class='0'>----------</td>";
		} else {
			if (oaRlzybLeave2.getLeave_backTime() == null) {
				htmlStr += "<td class='1'>未复职</td>";
			} else {
				String leave_backTime_str = sdf.format(oaRlzybLeave2
						.getLeave_backTime());
				htmlStr += "<td class='2'>已复职,时间为：" + leave_backTime_str + "</td>";
			}

		}
			htmlStr += "<td>" + lsd + "</td>";
			htmlStr += "<td>" + led + "</td>";
			

	}

		result_str[0] = htmlStr.toString();
		result_str[1] = page.getTotalCount()+"";
		result.put("result", result_str);
		return JSONArray.toJSONString(result);
		
	}
	
	/**
	 * 查询离岗信息
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value = "/SelectAllInfo", produces = "text/html;charset=UTF-8;")
	@ResponseBody
	// 查询所有离岗信息
	public Object SelectLeaveAllInfo(
			@RequestParam(value = "depart_id", required = false) String depart_id,
			@RequestParam(value = "leave_approver", required = false) String leave_approver,
			@RequestParam(value = "pageSize", required = false) String pageSiz,
			@RequestParam(value = "leave_type", required = false) String leave_type,
			@RequestParam(value = "pageIndex", required = false) String pageIndex,
			HttpServletRequest request) throws ParseException {
		boolean leave_startDate=false;
		boolean leave_endDate=false;
		// 处理按条件查询页面的问题
		Map<String, Object> result = new HashMap<>();
		String[] result_str = new String[2];

		Map<String, Object> condition = new HashMap<>();
		Page page = new Page();

		if (depart_id.equals("0")) {
			condition.put("depart_id", null);
		} else {
			condition.put("depart_id", depart_id);
		}
		if (leave_approver.equals("")) {
			condition.put("leave_approver", null);
		} else {
			condition.put("leave_approver", leave_approver);
		}
		if (leave_type.equals("0")) {
			condition.put("leave_type", null);
		} else {
			condition.put("leave_type", leave_type);
		}
		condition.put("leave_delectStatus", true);

		Integer PageIndex = 1;
		int pageg=0;
		if(pageSiz != null && pageSiz != ""){
			pageg= Integer.parseInt(pageSiz);
		}
		// 分页
		page.setPageSize(pageg);// 页面大小
		// 总共有多少条
		page.setTotalCount(leaveService
				.selectOaRlzybLeaveCountByCondition(condition));
		int pa=1;
		if(pageIndex!=null || pageIndex!=""){
			pa=Integer.parseInt(pageIndex);
			
		}
		if(pageIndex.equals("0")){
			pageIndex="1";
		}
		
		page.setCurrentPageNo(Integer.parseInt(pageIndex));// 当前页的下标
		condition.put("fromIndex",(pa- 1) * pageg);
		condition.put("pageSize", pageg);
		page.setOaRlzybLeaveList(leaveService.getOaRlzybLeaveByPage(condition));
		List<OaRlzybLeave> oaRlzybLeave = page.getOaRlzybLeaveList();
		condition.put("resultCount", page.getTotalCount());
		int number = 0;
		// 设定一个拼接的string字符串

		String htmlStr = "";

		// 在前台填充查询条件

		// 在前台填充离岗基本信息
		int Count = page.getTotalCount();
		int pageSize = page.getPageSize();
		if (Count==0) {
			Count=1;
		}
		if (pageSize==0) {
			pageSize=1;
		}
		
		int inde=Count%pageSize==0?
				page.getTotalCount()/pageSize
				:(page.getTotalCount()/page.getPageSize())+1;
		for (Iterator iterator = oaRlzybLeave.iterator(); iterator.hasNext();) {
			OaRlzybLeave oaRlzybLeave2 = (OaRlzybLeave) iterator.next();
			number++;
			
			String numberStr = "";
			if (Integer.toString(number).length() <= 4) {
				for (int i = (4 - Integer.toString(number).length()); i > 0; i--) {
					numberStr += "0";
				}
			}
			
			numberStr = numberStr + Integer.toString(number);
			
			// 日期转换器
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
			String lsd = sdf.format(oaRlzybLeave2.getLeave_startDate());
			String led = sdf.format(oaRlzybLeave2.getLeave_endDate());
			OaJzbRevoke oaJzbRevoke = new OaJzbRevoke();
			
			if (oaJzbRevoke.Revoke(oaRlzybLeave2.getCreate_time())) {
				
				htmlStr += "<tr id='t' index="+pa+" pageSize="+inde+" count="+Count+" sc=0 emp_id="+oaRlzybLeave2.getEmp_id()+" leave_id="+oaRlzybLeave2.getLeave_id()+" leave_type="+oaRlzybLeave2.getLeave_type()+">";
			} else {
				
				htmlStr += "<tr id='t' index="+pa +" pageSize="+inde+" count="+Count+" sc=1 emp_id="+oaRlzybLeave2.getEmp_id()+" leave_id="+oaRlzybLeave2.getLeave_id()+" leave_type="+oaRlzybLeave2.getLeave_type()+">";
			}
			htmlStr += "<td>" + numberStr + "</td>";
			htmlStr += "<td>" + oaRlzybLeave2.getEmp_name() + "</td>";
			htmlStr += "<td>" + oaRlzybLeave2.getPosition_name() + "</td>";
			htmlStr += "<td>" + oaRlzybLeave2.getDepart_name() + "</td>";
			htmlStr += "<td>" + oaRlzybLeave2.getLeave_type() + "</td>";
			htmlStr += "<td>" + oaRlzybLeave2.getLeave_reason() + "</td>";
			htmlStr += "<td>" + oaRlzybLeave2.getLeave_approver() + "</td>";
			
		if (!oaRlzybLeave2.getLeave_type().equals("产假")) {
				htmlStr += "<td class='0'>----------</td>";
		} else {
			if (oaRlzybLeave2.getLeave_backTime() == null) {
				htmlStr += "<td class='1'>未复职</td>";
			} else {
				String leave_backTime_str = sdf.format(oaRlzybLeave2
						.getLeave_backTime());
				htmlStr += "<td class='2'>已复职,时间为：" + leave_backTime_str + "</td>";
			}

		}
		
			htmlStr += "<td>" + lsd + "</td>";
			htmlStr += "<td>" + led + "</td>";
			
	}

		
		result_str[0] = htmlStr.toString();
		result_str[1] = page.getTotalCount()+"";
		result.put("result", result_str);
		
		return JSONArray.toJSONString(result);
		
	}

	/**
	 * 查看页面
	 * 
	 */
	@RequestMapping("/selectAllByleave_id/{leave_id}")
	public String selectAllByleave_id(
			@PathVariable("leave_id") String leave_id,
			HttpServletRequest request) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分");
		OaRlzybLeave oaRlzybLeave = leaveService.selectAllByleave_id(Integer
				.parseInt(leave_id));
		oaRlzybLeave.setLeave_startDate_str(sdf.format(oaRlzybLeave
				.getLeave_startDate()));
		oaRlzybLeave.setLeave_endDate_str(sdf.format(oaRlzybLeave
				.getLeave_endDate()));
		request.setAttribute("oaRlzybLeave", oaRlzybLeave);
		return "human_resource_department/requestleave_show";

	}
	
	@ResponseBody
	@RequestMapping(value = "/leave_delete", produces = "text/html;charset=UTF-8;")
	public Object talentReserve_delete(String leave_id){
		
		
		Integer rewards_id2 = 0;
		
		if(leave_id != null && leave_id != ""){
			rewards_id2 = Integer.parseInt(leave_id);
		}
		boolean flag =leaveService.delectStatus(rewards_id2);
		
		return JSONArray.toJSONString(flag);
		
	}
	
	/**
	 * 删除离岗记录
	 * 
	 * @param leave_id
	 * @return
	 */
	@RequestMapping("/deleteOaRlzybLeave")
	@ResponseBody
	public String deleteOaRlzybLeave(String leave_id,String emp_id,String leave_type) {
		try {
			leave_type = new String(leave_type.getBytes("ISO-8859-1"), "UTF-8");

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (leaveService
				.deleteOaRlzybLeaveByLeaveId(Integer.parseInt(leave_id)) == 1) {
			if (leave_type.equals("年假") || leave_type.equals("婚假")
					|| leave_type.equals("产假")) {
				if (leaveService.updateOaRlzybEmployeeEmpNowStatusByEmpId(
						Integer.parseInt(emp_id), "在职") == 1) {
					return "1";
				} else {
					return "0";
				}
			} else {
				return "1";
			}
		} else {
			return "0";
		}
	}

	/**
	 * 休假员工复职
	 * 
	 * @param leave_id
	 * @return
	 */
	@RequestMapping("/checkEmployeeGoBack")
	@ResponseBody
	public String checkEmployeeGoBack(
			@RequestParam("leave_backTime") String leave_backTime,
			@RequestParam("leave_id") String leave_id,
			@RequestParam("emp_id") String emp_id,
			@RequestParam("leave_type") String leave_type

	) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		OaRlzybLeave oaRlzybLeave = new OaRlzybLeave();
		try {
			oaRlzybLeave.setLeave_backTime(format.parse(leave_backTime));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		oaRlzybLeave.setLeave_id(Integer.parseInt(leave_id));
		if (leaveService.updateOaRlzybLeaveLeaveBackTimeByLeaveId(oaRlzybLeave) == 1) {
			if (leave_type.equals("年假") || leave_type.equals("婚假")
					|| leave_type.equals("产假")) {
				if (leaveService.updateOaRlzybEmployeeEmpNowStatusByEmpId(
						Integer.parseInt(emp_id), "在职") == 1) {
					return "1";
				} else {
					return "0";
				}
			} else {
				return "1";
			}
		} else {
			return "0";
		}
	}
	
	@RequestMapping("insertligang")
	@ResponseBody
	public int insertligang(int emp_id, String leave_startDate, String leave_endDate, String leave_type,
			String leave_reason, String leave_approver) throws ParseException{
		OaRlzybLeave oa=new OaRlzybLeave();
		oa.setLeave_approver(leave_approver);
		oa.setEmp_id(emp_id);
		oa.setLeave_delectStatus(1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		leave_startDate = leave_startDate+" 00:00:00";
		leave_endDate = leave_endDate+" 00:00:00";
		Date date1 = sdf.parse(leave_startDate.toString());
		oa.setLeave_startDate(date1);
		Date date2 = sdf.parse(leave_endDate.toString());
		oa.setLeave_endDate(date2);
		
		oa.setLeave_reason(leave_reason);
		oa.setLeave_id(0);
	
		oa.setLeave_type(leave_type);
		Date date = new Date();
		oa.setCreate_time(date);
		return leaveService.insertSelective(oa);
	
	}
	@RequestMapping("riqicha")
	@ResponseBody
	public String riqicha(String qishiriqi,String jiezhiriqi) throws ParseException{
		long quot=0;
		SimpleDateFormat ft=new SimpleDateFormat("yyyy-MM-dd");
		
		Date data1= ft.parse(qishiriqi);
		Date data2= ft.parse(jiezhiriqi);
		quot=data2.getTime()-data1.getTime();
		quot=quot/1000/60/60/24;
		if(quot<0){
			return "起始日期应比截止日期小";
			
		}else{
			return quot+"天";
		}
		
	}
}

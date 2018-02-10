package cn.tyyhoa.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.crypto.spec.OAEPParameterSpec;
import javax.enterprise.inject.New;
import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.ibatis.annotations.Param;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;

import Decoder.BASE64Decoder;

import cn.tyyhoa.pojo.OaRlzybDepartment;
import cn.tyyhoa.pojo.OaRlzybEmployee;
import cn.tyyhoa.pojo.OaRlzybGrade;
import cn.tyyhoa.pojo.OaRlzybHatArea;
import cn.tyyhoa.pojo.OaRlzybHatCity;
import cn.tyyhoa.pojo.OaRlzybHatProvince;
import cn.tyyhoa.pojo.OaRlzybNative;
import cn.tyyhoa.pojo.OaRlzybPosition;
import cn.tyyhoa.pojo.OaRlzybTechnicalTitle;
import cn.tyyhoa.pojo.OaRlzybUser;
import cn.tyyhoa.service.OaRlzybEmployeeService;
import cn.tyyhoa.service.OaRlzybPositionService;
import cn.tyyhoa.util.OaJzbRevoke;
import cn.tyyhoa.util.Page;

@Controller
@RequestMapping("/Employee")
public class OaRlzybEmployeeController {
	@Autowired
	private OaRlzybEmployeeService oaRlzybEmployeeService;
	@Autowired
	private OaRlzybPositionService oaRlzybPositionService;
	
	
	@RequestMapping(value = "/GetNationList", produces = "text/html;charset=UTF-8;")
	@ResponseBody
	public String GetNationList(@RequestParam(value="nationName",required=false) String nationName) {
	
		if(nationName==null){
			nationName = "汉族";
		}
		List<OaRlzybNative> oaRlzybNativeList = oaRlzybEmployeeService.getAllNations();
		String optionStr = "<option value=''>---</option>";
		for (Iterator iterator = oaRlzybNativeList.iterator(); iterator
				.hasNext();) {
			OaRlzybNative oaRlzybNative = (OaRlzybNative) iterator.next();
			if (oaRlzybNative.getNaName().equals(nationName)) {
				optionStr += "<option value='" + oaRlzybNative.getNaName()
						+ "'  selected='selected'>" + oaRlzybNative.getNaName()
						+ "</option>";
			} else {
				optionStr += "<option value='" + oaRlzybNative.getNaName()
						+ "'>" + oaRlzybNative.getNaName() + "</option>";
			}

		}
		/* System.out.println(optionStr); */
		return optionStr;
	}

	@RequestMapping(value = "/GetProvinceList", produces = "text/html;charset=UTF-8;")
	@ResponseBody
	public String GetProvinceList(@RequestParam(value="ProvinceId",required=false) String ProvinceId) {
		if(ProvinceId==null||ProvinceId.equals("")){
			ProvinceId = "140000";
		}
		List<OaRlzybHatProvince> oaRlzybHatProvinceList = oaRlzybEmployeeService
				.getAllProvinces();
		String optionStr = "<option value=''>---</option>";
		for (Iterator iterator = oaRlzybHatProvinceList.iterator(); iterator
				.hasNext();) {
			OaRlzybHatProvince oaRlzybHatProvince = (OaRlzybHatProvince) iterator
					.next();
			if (oaRlzybHatProvince.getProvinceID().equals(ProvinceId)) {
				optionStr += "<option value='"
						+ oaRlzybHatProvince.getProvinceID()
						+ "'  selected='selected'   >"
						+ oaRlzybHatProvince.getProvince() + "</option>";
			} else {
				optionStr += "<option value='"
						+ oaRlzybHatProvince.getProvinceID() + "' >"
						+ oaRlzybHatProvince.getProvince() + "</option>";
			}

		}
		return optionStr;
	}

	
	@RequestMapping(value = "/GetCityList", produces = "text/html;charset=UTF-8;")
	@ResponseBody
	public String GetCityList(@RequestParam(value="ProvinceId",required=false) String ProvinceId,@RequestParam(value="cityName",required=false) String  cityName) {	
		if(ProvinceId==null||ProvinceId.equals("")){
			ProvinceId = "140000";
		}  
		if(cityName==null||cityName.equals("")){
			cityName = "140100";
		}
		System.out.println(cityName);
		System.out.println(ProvinceId);
		System.out.println(ProvinceId==null);
		System.out.println(ProvinceId.equals("null"));
		List<OaRlzybHatCity> oaRlzybHatCityList = oaRlzybEmployeeService
					.getAllCitys(ProvinceId);
			String optionStr = "<option value=''>---</option>";
			for (Iterator iterator = oaRlzybHatCityList.iterator(); iterator
					.hasNext();) {
				OaRlzybHatCity oaRlzybHatCity = (OaRlzybHatCity) iterator
						.next();
				if (oaRlzybHatCity.getCityID().equals(cityName)) {
					optionStr += "<option value='" + oaRlzybHatCity.getCityID()
							+ "' selected='selected' >"
							+ oaRlzybHatCity.getCity() + "</option>";
				} else {
					optionStr += "<option value='" + oaRlzybHatCity.getCityID()
							+ "' >" + oaRlzybHatCity.getCity() + "</option>";
				}

			}
			return optionStr;
		}


	@RequestMapping(value = "/GetAreaList", produces = "text/html;charset=UTF-8;")
	@ResponseBody
	public String GetAreaList(@RequestParam(value="CityId",required=false) String CityId,@RequestParam(value="CountyName",required=false) String CountyName) {
			if(CityId==null||CityId.equals("")){
				CityId = "140100";
			}
		    if(CountyName==null||CountyName.equals("")){
				CountyName = "";
			}
			List<OaRlzybHatArea> oaRlzybHatAreaList = oaRlzybEmployeeService
					.getAllAreas(CityId);
			String optionStr = "";
			optionStr += "<option value=''>---</option>";
			for (Iterator iterator = oaRlzybHatAreaList.iterator(); iterator
					.hasNext();) {
				OaRlzybHatArea oaRlzybHatArea = (OaRlzybHatArea) iterator
						.next();
				if(oaRlzybHatArea.getAreaID().equals(CountyName)){
					optionStr += "<option   selected='selected'      value='" + oaRlzybHatArea.getAreaID()
							+ "' >" + oaRlzybHatArea.getArea() + "</option>";
				}else{
					optionStr += "<option value='" + oaRlzybHatArea.getAreaID()
							+ "' >" + oaRlzybHatArea.getArea() + "</option>";
				}
				
			}
			return optionStr;
		}
	

	@RequestMapping(value = "/GetDepartmentList", produces = "text/html;charset=UTF-8;")
	@ResponseBody
	public String GetDepartmentList(@RequestParam(value="DepartmentName",required=false) String DepartmentName) {
		if(DepartmentName==null){
			DepartmentName = "0";
		}
		List<OaRlzybDepartment> OaRlzybDepartmentList = oaRlzybEmployeeService
				.getAllDepartments();
		String optionStr = "";
		optionStr += "<option value='0'>---</option>";
		for (Iterator iterator = OaRlzybDepartmentList.iterator(); iterator
				.hasNext();) {
			OaRlzybDepartment oaRlzybDepartment = (OaRlzybDepartment) iterator
					.next();
			if(oaRlzybDepartment.getDepart_id()==Integer.parseInt(DepartmentName)){
				optionStr += "<option  selected='selected'  value='" + oaRlzybDepartment.getDepart_id()
						+ "' >" + oaRlzybDepartment.getDepart_name() + "</option>";
			}else{
				optionStr += "<option value='" + oaRlzybDepartment.getDepart_id()
						+ "' >" + oaRlzybDepartment.getDepart_name() + "</option>";	
			}
	
		}
		return optionStr;
	}

	@RequestMapping(value = "/GetPositionList", produces = "text/html;charset=UTF-8;")
	@ResponseBody
	public String GetPositionList(
			@RequestParam(value="DepartmentId",required=false) String DepartmentId,@RequestParam(value="PositionName",required=false) String PositionName) {
		String optionStr = "";
		if(PositionName==null||PositionName.equals("")){
			List<OaRlzybPosition> OaRlzybPositionList = oaRlzybEmployeeService
					.getAllPositions(Integer.parseInt(DepartmentId));
			optionStr += "<option value='0'>---</option>";
			for (Iterator iterator = OaRlzybPositionList.iterator(); iterator
					.hasNext();) {
				OaRlzybPosition oaRlzybPosition = (OaRlzybPosition) iterator.next();
				optionStr += "<option value='" + oaRlzybPosition.getPosition_id()
						+ "' >" + oaRlzybPosition.getPosition_name() + "</option>";
			}
		}else{
			List<OaRlzybPosition> OaRlzybPositionList = oaRlzybEmployeeService
					.getAllPositions(Integer.parseInt(DepartmentId));
			optionStr += "<option value='0'>---</option>";
			for (Iterator iterator = OaRlzybPositionList.iterator(); iterator
					.hasNext();) {
				OaRlzybPosition oaRlzybPosition = (OaRlzybPosition) iterator.next();
				if(oaRlzybPosition.getPosition_id()==Integer.parseInt(PositionName)){
					optionStr += "<option value='" + oaRlzybPosition.getPosition_id()
							+ "'  selected='selected'  >" + oaRlzybPosition.getPosition_name() + "</option>";
				}else{
					optionStr += "<option value='" + oaRlzybPosition.getPosition_id()
							+ "' >" + oaRlzybPosition.getPosition_name() + "</option>";
				}
		
			}
		}
		return optionStr;
	}
	@RequestMapping(value = "/GetGradeList", produces = "text/html;charset=UTF-8;")
	@ResponseBody
	public String GetGradeList(@RequestParam(value="GradeName",required=false) String GradeName) {
		if(GradeName==null){
			GradeName = "0";
		}
		String optionStr = "";
		optionStr += "<option value='0'>---</option>";
			List<OaRlzybGrade> OaRlzybGradeList = oaRlzybEmployeeService.getAllGrades();
			for (Iterator iterator = OaRlzybGradeList.iterator(); iterator
					.hasNext();) {
				OaRlzybGrade oaRlzybGrade = (OaRlzybGrade) iterator.next();
				if(oaRlzybGrade.getGrade_id()==Integer.parseInt(GradeName)){
					optionStr += "<option  selected='selected'   value='" + oaRlzybGrade.getGrade_id() + "' >"
							+ oaRlzybGrade.getGrade_name() + "</option>";	
				}else{
					optionStr += "<option value='" + oaRlzybGrade.getGrade_id() + "' >"
							+ oaRlzybGrade.getGrade_name() + "</option>";
				}
				
			}
			return optionStr;
		}
	@RequestMapping(value = "/GetRegistrantList", produces = "text/html;charset=UTF-8;")
	@ResponseBody
	public String GetRegistrantList(@RequestParam(value="RegistrantName",required=false) String RegistrantName) {
		if(RegistrantName==null||RegistrantName.equals("")){
			RegistrantName = "0";
		}
		String optionStr = "";
		optionStr += "<option value='0'>---</option>";
			List<OaRlzybEmployee> OaRlzybEmployeeList = oaRlzybEmployeeService
					.getHumanAffairsOaRlzybEmployees();
			for (Iterator iterator = OaRlzybEmployeeList.iterator(); iterator
					.hasNext();) {
				OaRlzybEmployee oaRlzybEmployee = (OaRlzybEmployee) iterator.next();
				if(oaRlzybEmployee.getEmp_id()==Integer.parseInt(RegistrantName)){
					optionStr += "<option  selected='selected' value='" + oaRlzybEmployee.getEmp_id()
							+ "' >" + oaRlzybEmployee.getEmp_name() + "</option>";
				}else{
					optionStr += "<option value='" + oaRlzybEmployee.getEmp_id()
							+ "' >" + oaRlzybEmployee.getEmp_name() + "</option>";
				}
			
			}
			return optionStr;
		}
	
	/**
	 * 查询指定并跳转到离职页面
	 * @param emp_id
	 * @param request
	 * @return
	 */
		@RequestMapping("/dimission_add/{emp_id}")
		public String dimission_add(@PathVariable String emp_id,
				HttpServletRequest request) {
			OaRlzybEmployee oaRlzybEmployee = oaRlzybEmployeeService
					.getOaRlzybEmployeeById(Integer.parseInt(emp_id));
			String emp_photo_path = oaRlzybEmployee.getEmp_photo_path();
			if(emp_photo_path!=null){
				oaRlzybEmployee.setEmp_photo_path(transformPhotoPath(emp_photo_path));	
			}else{
				oaRlzybEmployee.setEmp_photo_path("空");
			}

			
			String emp_idcard_front = oaRlzybEmployee.getEmp_idcard_front();
			if(emp_idcard_front!=null){
				
				oaRlzybEmployee.setEmp_idcard_front(transformPhotoPath(emp_idcard_front));
			}else{
				
				oaRlzybEmployee.setEmp_idcard_front("空");
			}
		
			
			String emp_idcard_reverse = oaRlzybEmployee.getEmp_idcard_reverse();
			System.out.println("测试测试"+emp_idcard_reverse);
			if(emp_idcard_reverse!=null){
				oaRlzybEmployee.setEmp_idcard_reverse(transformPhotoPath(emp_idcard_reverse));
			}else{
				oaRlzybEmployee.setEmp_idcard_reverse("空");
			}
			

			
			String emp_Degree_certificate = oaRlzybEmployee.getEmp_Degree_certificate();
			if(emp_Degree_certificate!=null){
				
				oaRlzybEmployee.setEmp_Degree_certificate(transformPhotoPath(emp_Degree_certificate));
			}else{
				oaRlzybEmployee.setEmp_Degree_certificate("空");
			}

			
			String emp_Education_certificate = oaRlzybEmployee.getEmp_Education_certificate();
			if(emp_Education_certificate!=null){
				
				oaRlzybEmployee.setEmp_Education_certificate(transformPhotoPath(emp_Education_certificate));
			}else{
				oaRlzybEmployee.setEmp_Education_certificate("空");
			}
			String emp_technical_title_path  = oaRlzybEmployee.getEmp_technical_title_path();
			if(emp_technical_title_path!=null){
				
				oaRlzybEmployee.setEmp_technical_title_path(transformPhotoPath(emp_technical_title_path));
			}else{
				oaRlzybEmployee.setEmp_technical_title_path("空");
			}
	/*		List<OaRlzybTechnicalTitle> oaRlzybTechnicalTitleList = oaRlzybEmployeeService.getOaRlzybTechnicalTitleByEmpId(Integer.parseInt(emp_id));

			for (Iterator iterator = oaRlzybTechnicalTitleList.iterator(); iterator
			.hasNext();) {
		OaRlzybTechnicalTitle oaRlzybTechnicalTitle = (OaRlzybTechnicalTitle) iterator
				.next();
		String emp_technical_title_path  = oaRlzybTechnicalTitle.getTechnical_title_path();
		oaRlzybTechnicalTitle.setTechnical_title_path(transformPhotoPath(emp_technical_title_path));
		
	}*/		
			Date emp_Entry_date = oaRlzybEmployee.getEmp_Entry_date();
			Date emp_tryout_end_date = oaRlzybEmployee.getEmp_tryout_end_date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			oaRlzybEmployee.setEmp_Entry_date_str(sdf.format(emp_Entry_date));
			oaRlzybEmployee.setEmp_tryout_end_date_str(sdf.format(emp_tryout_end_date));
	       /* request.setAttribute("oaRlzybTechnicalTitleList", oaRlzybTechnicalTitleList);*/
			request.setAttribute("oaRlzybEmployee", oaRlzybEmployee);
			return "human_resource_department/dimission_add";
		}
		/**
		 * 查询指定并跳转到奖惩页面
		 * @param emp_id
		 * @param request
		 * @return
		 */
			@RequestMapping("/Randp_add/{emp_id}")
			public String Randp_add(@PathVariable String emp_id,
					HttpServletRequest request) {
				OaRlzybEmployee oaRlzybEmployee = oaRlzybEmployeeService
						.getOaRlzybEmployeeById(Integer.parseInt(emp_id));
				String emp_photo_path = oaRlzybEmployee.getEmp_photo_path();
				if(emp_photo_path!=null){
					oaRlzybEmployee.setEmp_photo_path(transformPhotoPath(emp_photo_path));	
				}else{
					oaRlzybEmployee.setEmp_photo_path("空");
				}

				
				String emp_idcard_front = oaRlzybEmployee.getEmp_idcard_front();
				if(emp_idcard_front!=null){
					
					oaRlzybEmployee.setEmp_idcard_front(transformPhotoPath(emp_idcard_front));
				}else{
					
					oaRlzybEmployee.setEmp_idcard_front("空");
				}
			
				
				String emp_idcard_reverse = oaRlzybEmployee.getEmp_idcard_reverse();
				System.out.println("测试测试"+emp_idcard_reverse);
				if(emp_idcard_reverse!=null){
					oaRlzybEmployee.setEmp_idcard_reverse(transformPhotoPath(emp_idcard_reverse));
				}else{
					oaRlzybEmployee.setEmp_idcard_reverse("空");
				}
				

				
				String emp_Degree_certificate = oaRlzybEmployee.getEmp_Degree_certificate();
				if(emp_Degree_certificate!=null){
					
					oaRlzybEmployee.setEmp_Degree_certificate(transformPhotoPath(emp_Degree_certificate));
				}else{
					oaRlzybEmployee.setEmp_Degree_certificate("空");
				}

				
				String emp_Education_certificate = oaRlzybEmployee.getEmp_Education_certificate();
				if(emp_Education_certificate!=null){
					
					oaRlzybEmployee.setEmp_Education_certificate(transformPhotoPath(emp_Education_certificate));
				}else{
					oaRlzybEmployee.setEmp_Education_certificate("空");
				}
			
				
				List<OaRlzybTechnicalTitle> oaRlzybTechnicalTitleList = oaRlzybEmployeeService.getOaRlzybTechnicalTitleByEmpId(Integer.parseInt(emp_id));

				for (Iterator iterator = oaRlzybTechnicalTitleList.iterator(); iterator
				.hasNext();) {
			OaRlzybTechnicalTitle oaRlzybTechnicalTitle = (OaRlzybTechnicalTitle) iterator
					.next();
			String emp_technical_title_path  = oaRlzybTechnicalTitle.getTechnical_title_path();
			oaRlzybTechnicalTitle.setTechnical_title_path(transformPhotoPath(emp_technical_title_path));
			
		}		
				Date emp_Entry_date = oaRlzybEmployee.getEmp_Entry_date();
				Date emp_tryout_end_date = oaRlzybEmployee.getEmp_tryout_end_date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				oaRlzybEmployee.setEmp_Entry_date_str(sdf.format(emp_Entry_date));
				oaRlzybEmployee.setEmp_tryout_end_date_str(sdf.format(emp_tryout_end_date));
		        request.setAttribute("oaRlzybTechnicalTitleList", oaRlzybTechnicalTitleList);
				request.setAttribute("oaRlzybEmployee", oaRlzybEmployee);
				return "human_resource_department/Randp_add";
			}
		/**
		 * 查询指定并跳转到访谈页面
		 * @param emp_id
		 * @param request
		 * @return
		 */
			@RequestMapping("/interview_add")
			public String interview_add(@PathVariable String emp_id,
					HttpServletRequest request) {
				OaRlzybEmployee oaRlzybEmployee = oaRlzybEmployeeService
						.getOaRlzybEmployeeById(Integer.parseInt(emp_id));
				String emp_photo_path = oaRlzybEmployee.getEmp_photo_path();
				if(emp_photo_path!=null){
					oaRlzybEmployee.setEmp_photo_path(transformPhotoPath(emp_photo_path));	
				}else{
					oaRlzybEmployee.setEmp_photo_path("空");
				}

				String emp_idcard_front = oaRlzybEmployee.getEmp_idcard_front();
				if(emp_idcard_front!=null){
					
					oaRlzybEmployee.setEmp_idcard_front(transformPhotoPath(emp_idcard_front));
				}else{
					
					oaRlzybEmployee.setEmp_idcard_front("空");
				}
			
				
				String emp_idcard_reverse = oaRlzybEmployee.getEmp_idcard_reverse();
				System.out.println("测试测试"+emp_idcard_reverse);
				if(emp_idcard_reverse!=null){
					oaRlzybEmployee.setEmp_idcard_reverse(transformPhotoPath(emp_idcard_reverse));
				}else{
					oaRlzybEmployee.setEmp_idcard_reverse("空");
				}
				

				
				String emp_Degree_certificate = oaRlzybEmployee.getEmp_Degree_certificate();
				if(emp_Degree_certificate!=null){
					
					oaRlzybEmployee.setEmp_Degree_certificate(transformPhotoPath(emp_Degree_certificate));
				}else{
					oaRlzybEmployee.setEmp_Degree_certificate("空");
				}

				
				String emp_Education_certificate = oaRlzybEmployee.getEmp_Education_certificate();
				if(emp_Education_certificate!=null){
					
					oaRlzybEmployee.setEmp_Education_certificate(transformPhotoPath(emp_Education_certificate));
				}else{
					oaRlzybEmployee.setEmp_Education_certificate("空");
				}
			
				
				List<OaRlzybTechnicalTitle> oaRlzybTechnicalTitleList = oaRlzybEmployeeService.getOaRlzybTechnicalTitleByEmpId(Integer.parseInt(emp_id));

				for (Iterator iterator = oaRlzybTechnicalTitleList.iterator(); iterator
				.hasNext();) {
			OaRlzybTechnicalTitle oaRlzybTechnicalTitle = (OaRlzybTechnicalTitle) iterator
					.next();
			String emp_technical_title_path  = oaRlzybTechnicalTitle.getTechnical_title_path();
			oaRlzybTechnicalTitle.setTechnical_title_path(transformPhotoPath(emp_technical_title_path));
			
		}		
				Date emp_Entry_date = oaRlzybEmployee.getEmp_Entry_date();
				Date emp_tryout_end_date = oaRlzybEmployee.getEmp_tryout_end_date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				oaRlzybEmployee.setEmp_Entry_date_str(sdf.format(emp_Entry_date));
				oaRlzybEmployee.setEmp_tryout_end_date_str(sdf.format(emp_tryout_end_date));
		        request.setAttribute("oaRlzybTechnicalTitleList", oaRlzybTechnicalTitleList);
				request.setAttribute("oaRlzybEmployee", oaRlzybEmployee);
				return "1";
			}
		
/**
 * 
 * @param method 保存方式
 * @param oaRlzybEmployee
 * @param attach
 * @param fileNameIn
 * @param request
 * @return
 */
	@RequestMapping(value = "/AddEmployee/{method}/{a_emp_idcard}/{emp_id}", produces = "text/html;charset=UTF-8;",method = RequestMethod.POST)
	@ResponseBody
	public String AddEmployee(
			@PathVariable("method") String method,
			@PathVariable("a_emp_idcard") String a_emp_idcard,
			@PathVariable("emp_id") String emp_id,
			OaRlzybEmployee oaRlzybEmployee,
			HttpServletRequest request) {
		//设置保存方式
		//格式化日期并保存到对象中
		Date now = new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (method.equals("AddBasicInfo")) {
			oaRlzybEmployee.setA_emp_idcard(a_emp_idcard);
			oaRlzybEmployee.setEmp_id(Integer.parseInt(emp_id));
			oaRlzybEmployee.setSave_model("AddBasicInfo");
			oaRlzybEmployee.setCreate_time(new Date(System.currentTimeMillis()));
			String birthday = null;
			String birthday_day = null;
			String birthday_year = null;
			if(oaRlzybEmployee.getEmp_idcard()!=null){
				 birthday_year = (String) oaRlzybEmployee.getEmp_idcard().trim()
						.subSequence(6, 10);
				String birthday_month = (String) oaRlzybEmployee.getEmp_idcard().trim()
						.subSequence(10, 12);
				birthday_day = (String) oaRlzybEmployee.getEmp_idcard().trim()
						.subSequence(12, 14);
				 birthday = birthday_year + "-" + birthday_month + "-" + "-"
						+ birthday_day;	
			}else{
			 birthday_year = (String) oaRlzybEmployee.getA_emp_idcard().trim()
						.subSequence(6, 10);
				String birthday_month = (String) oaRlzybEmployee.getA_emp_idcard().trim()
						.subSequence(10, 12);
			 birthday_day = (String) oaRlzybEmployee.getA_emp_idcard().trim()
						.subSequence(12, 14);
				 birthday = birthday_year + "-" + birthday_month + "-" + "-"
						+ birthday_day;	
			}
			
			try {
				Date date3 = sdf.parse(birthday.toString());
				oaRlzybEmployee.setEmp_birthday(date3);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}

			String nowStr = sdf.format(now);
			String nowStrYear = nowStr.substring(0, 4);
			oaRlzybEmployee.setEmp_age(Integer.parseInt(nowStrYear)
					- Integer.parseInt(birthday_year));
		} else if (method.equals("AddExperienceInfo")) {
		/*	oaRlzybEmployee.setEmp_idcard(emp_idcard);*/
			oaRlzybEmployee.setEmp_id(Integer.parseInt(emp_id));
			oaRlzybEmployee.setA_emp_idcard(a_emp_idcard);
			oaRlzybEmployee.setSave_model("AddExperienceInfo");
		} else if (method.equals("AddPositionInfo")) {
		/*	oaRlzybEmployee.setEmp_idcard(emp_idcard);*/
			oaRlzybEmployee.setEmp_id(Integer.parseInt(emp_id));
			oaRlzybEmployee.setA_emp_idcard(a_emp_idcard);
			oaRlzybEmployee.setSave_model("AddPositionInfo");
			String emp_Entry_date = request.getParameter("a_emp_Entry_date");
			if (emp_Entry_date!=null) {
				if(!emp_Entry_date.equals("")){
					try {
						Date date1 = sdf.parse(emp_Entry_date.toString());
						oaRlzybEmployee.setEmp_Entry_date(date1);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					
				}else{
					oaRlzybEmployee.setEmp_Entry_date(now);
				}
			
			} else {
				oaRlzybEmployee.setEmp_Entry_date(now);
			}
				String emp_tryout_end_date = request.getParameter("a_emp_tryout_end_date");
				if(emp_tryout_end_date!=null){
					if (!emp_tryout_end_date.equals("")) {
						try {
							Date date2 = sdf.parse(emp_tryout_end_date.toString());
							oaRlzybEmployee.setEmp_tryout_end_date(date2);
						} catch (ParseException e) {
							e.printStackTrace();
						}
					} else {
						oaRlzybEmployee.setEmp_tryout_end_date(now);
					}
					
				}else{
					
					oaRlzybEmployee.setEmp_tryout_end_date(now);
				}
				
				
			
		} else if (method.equals("AddUrgentPersonInfo")) {
	/*		oaRlzybEmployee.setEmp_idcard(emp_idcard);*/
			oaRlzybEmployee.setEmp_id(Integer.parseInt(emp_id));
			oaRlzybEmployee.setA_emp_idcard(a_emp_idcard);
			oaRlzybEmployee.setSave_model("AddUrgentPersonInfo");
		} 
		//默认添加的数据是未删除的状态
		oaRlzybEmployee.setEmp_delectStatus("未删除");
		if (method.equals("AddBasicInfo")) {
			if (oaRlzybEmployeeService.modifyEmployeeByEmpIdCard(oaRlzybEmployee) == 1) {
				oaRlzybEmployee.setEmp_idcard(a_emp_idcard);
				if(emp_id.equals("0")){
					int Emp_id = oaRlzybEmployeeService
							.getEmpIdByEmpIdCard(oaRlzybEmployee);
					OaRlzybUser oaRlzybUser = new OaRlzybUser();
					oaRlzybUser.setEmp_id(Emp_id);
					oaRlzybUser.setUser_name(oaRlzybEmployee.getEmp_phone());
					oaRlzybUser.setLogin_type(1);
					oaRlzybUser.setUser_pwd("888888");
					if (oaRlzybEmployeeService
							.getOaRlzybUserCountByOaRlzybUser(oaRlzybUser) == 0) {
						if (oaRlzybEmployeeService.addUser(oaRlzybUser) == 1) {
							return  	"1";
						} else {
							return "0";
						}
					} else {
						return "2";
					}
				}
				return "1";
			} else {
				return "0";
			}
		}else if(method.equals("AddExperienceInfo")
				|| method.equals("AddUrgentPersonInfo")){
			if (oaRlzybEmployeeService.modifyEmployeeByEmpIdCard(oaRlzybEmployee) == 1) {
				return  "1";
			}else{
				return "0";
			}
		}else if(method.equals("AddPositionInfo")){
			OaRlzybUser oaRlzybUser = new OaRlzybUser();
			oaRlzybUser.setUser_name(oaRlzybEmployee.getEmp_phone());
			oaRlzybUser.setPosition_id(oaRlzybEmployee.getEmp_position());
			if (oaRlzybEmployeeService.modifyEmployeeByEmpIdCard(oaRlzybEmployee) == 1) {
				if (oaRlzybEmployeeService.modifyUserPositionIdByUserName(oaRlzybUser) == 1) {
					return  	"1";
				} else {
					return "0";
				}
			}else{
				return "0";
			}
		}
		return "3"; 
	}
	
	
	@RequestMapping(value = "/AddEmployeeFile/{method}/{a_emp_idcard}/{emp_id}", produces = "text/html;charset=UTF-8;",method = RequestMethod.POST)
	@ResponseBody
	public Object AddEmployeeFile(
			@PathVariable("method") String method,
			OaRlzybEmployee oaRlzybEmployee,
			@RequestParam(value="file", required = false) MultipartFile attach,
			@RequestParam(value="fileName", required = false) String fileNameIn, 
			@PathVariable("a_emp_idcard") String a_emp_idcard,
			@PathVariable("emp_id") String emp_id,
			@RequestParam("emp_idcard") String emp_idcard,
			HttpServletRequest request) {
		Map<String, Object> resultBack = new HashMap<String, Object>();
		oaRlzybEmployee.setSave_model(method);
		oaRlzybEmployee.setA_emp_idcard(a_emp_idcard);
		oaRlzybEmployee.setEmp_id(Integer.parseInt(emp_id));
		/*oaRlzybEmployee.setEmp_idcard(emp_idcard);*/
		String[] result =  uploadFile(oaRlzybEmployee, attach,request, fileNameIn,emp_idcard);
		resultBack.put("result", result);
		/*System.out.println(JSONArray.toJSONString(resultBack));*/
		return JSONArray.toJSONString(resultBack);
	}
	public String[] uploadFile(
			OaRlzybEmployee oaRlzybEmployee, MultipartFile attach,
			HttpServletRequest request, String fileNameIn,String emp_idcard) {
		System.out.println(attach);
		String logoLocPath = null;
		if (attach!=null) {// 判断上传文件是否为空
			String path = request.getSession().getServletContext()
					.getRealPath("statics" + File.separator + "uploadfiles");// 创建存放上传文件的文件夹
			String oldFileName = attach.getOriginalFilename();// 获得文件名
			String prefix = FilenameUtils.getExtension(oldFileName);// 获得扩展名
			int fileZize = 524288000;// 设定上传文件大小
			if (attach.getSize() > fileZize) {// 判断长传文件大小
				return new String[]{"上传文件大小不得超过2Mb！",null};
			} else if (prefix.equalsIgnoreCase("jpg")// 判断文件格式
					|| prefix.equalsIgnoreCase("png")
					|| prefix.equalsIgnoreCase("jpeg")
					|| prefix.equalsIgnoreCase("pdf")) {
				String fileName = System.currentTimeMillis()// 系统时间及随机数拼接文件名
						+ RandomUtils.nextInt(10000000) + "." + prefix;
				File targetFile = new File(path, fileName);// 创建文件对象
				if (!targetFile.exists()) {// 文件不存在在虚拟机中创建文件
					targetFile.mkdirs();
				}
				try {
					attach.transferTo(targetFile);// 输出内存中文件到本地磁盘
				} catch (Exception e) {
					e.printStackTrace();
				}
				logoLocPath = path + File.separator + fileName;// 获得文件路径
                if(fileNameIn.equals("a_emp_idcard_front")){
                	oaRlzybEmployee.setEmp_idcard_front(logoLocPath);
                	System.out.println(oaRlzybEmployee.getEmp_idcard());
                	if(oaRlzybEmployeeService.modifyEmployeeByEmpIdCard(oaRlzybEmployee) == 1){
                		return new String[]{"1",logoLocPath};
                	}else{
                		return new String[]{"0",null};
                	}
                }else if(fileNameIn.equals("a_emp_idcard_reverse")){
                	oaRlzybEmployee.setEmp_idcard_reverse(logoLocPath);
                	if(oaRlzybEmployeeService.modifyEmployeeByEmpIdCard(oaRlzybEmployee) == 1){
                		return new String[]{"1",logoLocPath};
                	}else{
                		return new String[]{"0",null};
                	}
                }else if(fileNameIn.equals("a_emp_Degree_certificate")){
                	oaRlzybEmployee.setEmp_Degree_certificate(logoLocPath);	
                	if(oaRlzybEmployeeService.modifyEmployeeByEmpIdCard(oaRlzybEmployee) == 1){
                		return new String[]{"1",logoLocPath};
                	}else{
                		return new String[]{"0",null};
                	}
                }else if(fileNameIn.equals("a_emp_Education_certificate")){
                	oaRlzybEmployee.setEmp_Education_certificate(logoLocPath);
                	if(oaRlzybEmployeeService.modifyEmployeeByEmpIdCard(oaRlzybEmployee) == 1){
                		return new String[]{"1",logoLocPath};
                	}else{
                		return new String[]{"0",null};
                	}
                }else if(fileNameIn.equals("a_emp_technical_title_path")){
                	OaRlzybTechnicalTitle oaRlzybTechnicalTitle = new OaRlzybTechnicalTitle(); 
                	OaRlzybEmployee oaRlzybEmployee1 = new OaRlzybEmployee();
                	oaRlzybEmployee1.setEmp_idcard(emp_idcard);
    				int Emp_id = oaRlzybEmployeeService.getEmpIdByEmpIdCard(oaRlzybEmployee1);
    				 oaRlzybTechnicalTitle.setEmp_id(Emp_id);
    				 oaRlzybTechnicalTitle.setTechnical_title_path(logoLocPath);
    				if( oaRlzybEmployeeService.addEmpTechnicalTitlePath(oaRlzybTechnicalTitle)==1){
    					return new String[]{"1",logoLocPath};
    				}else{
    		      		return new String[]{"0",null};
    				}
                }
			} else {
				return new String[]{"2",null};
			}
		} else {
			return new String[]{"3",null};
		}
		return null;
	}

	@RequestMapping(value = "/UploadPersonPhoto", produces = "text/html;charset=UTF-8;")
	@ResponseBody
	public String UploadPersonPhoto(
			@RequestParam("imgRecord") String imgRecord,
			@RequestParam("emp_idcard") String emp_idcard,
			HttpServletRequest request) {
		
		String path = request.getSession().getServletContext()
				.getRealPath("statics" + File.separator + "uploadfiles");
		String fileName = System.currentTimeMillis()// 系统时间及随机数拼接文件名
				+ RandomUtils.nextInt(10000000) + ".jpg";
		String logoLocPath = path + File.separator + fileName;
		/* System.out.println(logoLocPath); */
		if (GenerateImage(imgRecord, logoLocPath)) {
			Integer maxEmpId = oaRlzybEmployeeService.getMaxEmpId();
			OaRlzybEmployee oaRlzybEmployee = new OaRlzybEmployee();
			if (maxEmpId == null) {
				oaRlzybEmployee.setEmp_id(1);
				oaRlzybEmployee.setEmp_photo_path(logoLocPath);
				oaRlzybEmployee.setEmp_idcard(emp_idcard);
				oaRlzybEmployee.setCreate_time(new Date(System.currentTimeMillis()));
				if (oaRlzybEmployeeService.addEmployee(oaRlzybEmployee) == 1) {
					return "1";
				} else {
					return "0";
				}
			} else {
				oaRlzybEmployee.setEmp_id(maxEmpId + 1);
				oaRlzybEmployee.setEmp_photo_path(logoLocPath);
				oaRlzybEmployee.setEmp_idcard(emp_idcard);
				oaRlzybEmployee.setCreate_time(new Date(System.currentTimeMillis()));
				if (oaRlzybEmployeeService.addEmployee(oaRlzybEmployee) == 1) {
					return "1";
				} else {
					return "0";
				}
			}
			/* System.out.println(maxEmpId); */
		} else {
			return "0";
		}
	}

	
	@RequestMapping(value = "/UploadPersonPhoto/{emp_id}", produces = "text/html;charset=UTF-8;")
	@ResponseBody
	public String UploadPersonPhotoByEmpId(
			@RequestParam("imgRecord") String imgRecord,
			@PathVariable("emp_id") String emp_id,
			HttpServletRequest request) {
		String path = request.getSession().getServletContext()
				.getRealPath("statics" + File.separator + "uploadfiles");
		String fileName = System.currentTimeMillis()// 系统时间及随机数拼接文件名
				+ RandomUtils.nextInt(10000000) + ".jpg";
		String logoLocPath = path + File.separator + fileName;
		/* System.out.println(logoLocPath); */
		if (GenerateImage(imgRecord, logoLocPath)) {
			OaRlzybEmployee oaRlzybEmployee = new OaRlzybEmployee();
			oaRlzybEmployee.setEmp_photo_path(logoLocPath);
			oaRlzybEmployee.setEmp_id(Integer.parseInt(emp_id));
				if (oaRlzybEmployeeService.modifyOaRlzybEmployeePhotoPathByEmpId(oaRlzybEmployee) == 1) {
					return "1";
				} else {
					return "0";
				}
			}
			/* System.out.println(maxEmpId); */
		return "0";
		} 
	
	
	// base64字符串转化成图片
	public static boolean GenerateImage(String imgRecord, String filePath) { // 对字节数组字符串进行Base64解码并生成图片
		if (imgRecord == null) // 图像数据为空
			return false;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64解码
			byte[] b = decoder.decodeBuffer(imgRecord);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// 调整异常数据
					b[i] += 256;
				}
			}
			// 生成jpeg图片
			String imgFilePath = filePath;// 新生成的图片
			OutputStream out = new FileOutputStream(imgFilePath);
			out.write(b);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}/**
	 * 跳转到员工信息编辑页面
	 * @param emp_id
	 * @param request
	 * @return
	 */
		@RequestMapping("/ShowEmployee/{emp_id}")
		public String ShowEmployee(@PathVariable String emp_id,
				HttpServletRequest request) {
			OaRlzybEmployee oaRlzybEmployee = oaRlzybEmployeeService
					.getOaRlzybEmployeeById(Integer.parseInt(emp_id));
			String emp_photo_path = oaRlzybEmployee.getEmp_photo_path();
			if(emp_photo_path!=null){
				oaRlzybEmployee.setEmp_photo_path(transformPhotoPath(emp_photo_path));	
			}else{
				oaRlzybEmployee.setEmp_photo_path("空");
			}

			
			String emp_idcard_front = oaRlzybEmployee.getEmp_idcard_front();
			if(emp_idcard_front!=null){
				
				oaRlzybEmployee.setEmp_idcard_front(transformPhotoPath(emp_idcard_front));
			}else{
				
				oaRlzybEmployee.setEmp_idcard_front("空");
			}
		
			
			String emp_idcard_reverse = oaRlzybEmployee.getEmp_idcard_reverse();
			System.out.println("测试测试"+emp_idcard_reverse);
			if(emp_idcard_reverse!=null){
				oaRlzybEmployee.setEmp_idcard_reverse(transformPhotoPath(emp_idcard_reverse));
			}else{
				oaRlzybEmployee.setEmp_idcard_reverse("空");
			}
			

			
			String emp_Degree_certificate = oaRlzybEmployee.getEmp_Degree_certificate();
			if(emp_Degree_certificate!=null){
				
				oaRlzybEmployee.setEmp_Degree_certificate(transformPhotoPath(emp_Degree_certificate));
			}else{
				oaRlzybEmployee.setEmp_Degree_certificate("空");
			}

			
			String emp_Education_certificate = oaRlzybEmployee.getEmp_Education_certificate();
			if(emp_Education_certificate!=null){
				
				oaRlzybEmployee.setEmp_Education_certificate(transformPhotoPath(emp_Education_certificate));
			}else{
				oaRlzybEmployee.setEmp_Education_certificate("空");
			}
		
			
			List<OaRlzybTechnicalTitle> oaRlzybTechnicalTitleList = oaRlzybEmployeeService.getOaRlzybTechnicalTitleByEmpId(Integer.parseInt(emp_id));

			for (Iterator iterator = oaRlzybTechnicalTitleList.iterator(); iterator
			.hasNext();) {
		OaRlzybTechnicalTitle oaRlzybTechnicalTitle = (OaRlzybTechnicalTitle) iterator
				.next();
		String emp_technical_title_path  = oaRlzybTechnicalTitle.getTechnical_title_path();
		oaRlzybTechnicalTitle.setTechnical_title_path(transformPhotoPath(emp_technical_title_path));
		
	}		
			Date emp_Entry_date = oaRlzybEmployee.getEmp_Entry_date();
			Date emp_tryout_end_date = oaRlzybEmployee.getEmp_tryout_end_date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			oaRlzybEmployee.setEmp_Entry_date_str(sdf.format(emp_Entry_date));
			oaRlzybEmployee.setEmp_tryout_end_date_str(sdf.format(emp_tryout_end_date));
	        request.setAttribute("oaRlzybTechnicalTitleList", oaRlzybTechnicalTitleList);
			request.setAttribute("oaRlzybEmployee", oaRlzybEmployee);
			return "human_resource_department/employee_info_show";
		}
/**
 * 跳转到员工信息编辑页面
 * @param emp_id
 * @param request
 * @return
 */
	@RequestMapping("/EditEmployee/{emp_id}")
	public String EditEmployee(@PathVariable String emp_id,
			HttpServletRequest request) {
		OaRlzybEmployee oaRlzybEmployee = oaRlzybEmployeeService
				.getOaRlzybEmployeeById(Integer.parseInt(emp_id));
		String emp_photo_path = oaRlzybEmployee.getEmp_photo_path();
		if(emp_photo_path!=null){
			oaRlzybEmployee.setEmp_photo_path(transformPhotoPath(emp_photo_path));	
		}else{
			oaRlzybEmployee.setEmp_photo_path("空");
		}

		
		String emp_idcard_front = oaRlzybEmployee.getEmp_idcard_front();
		if(emp_idcard_front!=null){
			
			oaRlzybEmployee.setEmp_idcard_front(transformPhotoPath(emp_idcard_front));
		}else{
			
			oaRlzybEmployee.setEmp_idcard_front("空");
		}
	
		
		String emp_idcard_reverse = oaRlzybEmployee.getEmp_idcard_reverse();
		System.out.println("测试测试"+emp_idcard_reverse);
		if(emp_idcard_reverse!=null){
			oaRlzybEmployee.setEmp_idcard_reverse(transformPhotoPath(emp_idcard_reverse));
		}else{
			oaRlzybEmployee.setEmp_idcard_reverse("空");
		}
		

		
		String emp_Degree_certificate = oaRlzybEmployee.getEmp_Degree_certificate();
		if(emp_Degree_certificate!=null){
			
			oaRlzybEmployee.setEmp_Degree_certificate(transformPhotoPath(emp_Degree_certificate));
		}else{
			oaRlzybEmployee.setEmp_Degree_certificate("空");
		}

		
		String emp_Education_certificate = oaRlzybEmployee.getEmp_Education_certificate();
		if(emp_Education_certificate!=null){
			
			oaRlzybEmployee.setEmp_Education_certificate(transformPhotoPath(emp_Education_certificate));
		}else{
			oaRlzybEmployee.setEmp_Education_certificate("空");
		}
	
		
		
		
		
		
		
		
		List<OaRlzybTechnicalTitle> oaRlzybTechnicalTitleList = oaRlzybEmployeeService.getOaRlzybTechnicalTitleByEmpId(Integer.parseInt(emp_id));

		for (Iterator iterator = oaRlzybTechnicalTitleList.iterator(); iterator
		.hasNext();) {
	OaRlzybTechnicalTitle oaRlzybTechnicalTitle = (OaRlzybTechnicalTitle) iterator
			.next();
	String emp_technical_title_path  = oaRlzybTechnicalTitle.getTechnical_title_path();
	oaRlzybTechnicalTitle.setTechnical_title_path(transformPhotoPath(emp_technical_title_path));
	
}		

		Date emp_Entry_date = oaRlzybEmployee.getEmp_Entry_date();
		
		Date emp_tryout_end_date = oaRlzybEmployee.getEmp_tryout_end_date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		oaRlzybEmployee.setEmp_Entry_date_str(sdf.format(emp_Entry_date));
		oaRlzybEmployee.setEmp_tryout_end_date_str(sdf.format(emp_tryout_end_date));
	
		
        request.setAttribute("oaRlzybTechnicalTitleList", oaRlzybTechnicalTitleList);
		request.setAttribute("oaRlzybEmployee", oaRlzybEmployee);
		
		
		
		
		
		
		
		return "human_resource_department/employee_info_edit";
	}
	/**
	 * 跳转到调薪编辑页面
	 * @param emp_id
	 * @param request
	 * @return
	 */
		@RequestMapping("/addEmployee/{emp_id}")
		public String addEmployee(@PathVariable String emp_id,
				HttpServletRequest request) {
			OaRlzybEmployee oaRlzybEmployee = oaRlzybEmployeeService
					.getOaRlzybEmployeeById(Integer.parseInt(emp_id));
			String emp_photo_path = oaRlzybEmployee.getEmp_photo_path();
			if(emp_photo_path!=null){
				oaRlzybEmployee.setEmp_photo_path(transformPhotoPath(emp_photo_path));	
			}else{
				oaRlzybEmployee.setEmp_photo_path("空");
			}

			
			String emp_idcard_front = oaRlzybEmployee.getEmp_idcard_front();
			if(emp_idcard_front!=null){
				
				oaRlzybEmployee.setEmp_idcard_front(transformPhotoPath(emp_idcard_front));
			}else{
				
				oaRlzybEmployee.setEmp_idcard_front("空");
			}
		
			
			String emp_idcard_reverse = oaRlzybEmployee.getEmp_idcard_reverse();
			System.out.println("测试测试"+emp_idcard_reverse);
			if(emp_idcard_reverse!=null){
				oaRlzybEmployee.setEmp_idcard_reverse(transformPhotoPath(emp_idcard_reverse));
			}else{
				oaRlzybEmployee.setEmp_idcard_reverse("空");
			}
			

			
			String emp_Degree_certificate = oaRlzybEmployee.getEmp_Degree_certificate();
			if(emp_Degree_certificate!=null){
				
				oaRlzybEmployee.setEmp_Degree_certificate(transformPhotoPath(emp_Degree_certificate));
			}else{
				oaRlzybEmployee.setEmp_Degree_certificate("空");
			}

			
			String emp_Education_certificate = oaRlzybEmployee.getEmp_Education_certificate();
			if(emp_Education_certificate!=null){
				
				oaRlzybEmployee.setEmp_Education_certificate(transformPhotoPath(emp_Education_certificate));
			}else{
				oaRlzybEmployee.setEmp_Education_certificate("空");
			}
		
			
			
			
			
			
			
			
			List<OaRlzybTechnicalTitle> oaRlzybTechnicalTitleList = oaRlzybEmployeeService.getOaRlzybTechnicalTitleByEmpId(Integer.parseInt(emp_id));

			for (Iterator iterator = oaRlzybTechnicalTitleList.iterator(); iterator
			.hasNext();) {
		OaRlzybTechnicalTitle oaRlzybTechnicalTitle = (OaRlzybTechnicalTitle) iterator
				.next();
		String emp_technical_title_path  = oaRlzybTechnicalTitle.getTechnical_title_path();
		oaRlzybTechnicalTitle.setTechnical_title_path(transformPhotoPath(emp_technical_title_path));
		
	}		

			Date emp_Entry_date = oaRlzybEmployee.getEmp_Entry_date();
			
			Date emp_tryout_end_date = oaRlzybEmployee.getEmp_tryout_end_date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			oaRlzybEmployee.setEmp_Entry_date_str(sdf.format(emp_Entry_date));
			oaRlzybEmployee.setEmp_tryout_end_date_str(sdf.format(emp_tryout_end_date));
		
			
	        request.setAttribute("oaRlzybTechnicalTitleList", oaRlzybTechnicalTitleList);
			request.setAttribute("oaRlzybEmployee", oaRlzybEmployee);
			
			
			
			
			
			
			
			return "human_resource_department/managesalary_add";
		}
		
		
		/**
		 * 跳转到离岗编辑页面
		 * @param emp_id
		 * @param request
		 * @return
		 */
			@RequestMapping("/requestleaveEmployee/{emp_id}")
			public String requestleaveEmployee(@PathVariable String emp_id,
					HttpServletRequest request) {
				OaRlzybEmployee oaRlzybEmployee = oaRlzybEmployeeService
						.getOaRlzybEmployeeById(Integer.parseInt(emp_id));
				String emp_photo_path = oaRlzybEmployee.getEmp_photo_path();
				if(emp_photo_path!=null){
					oaRlzybEmployee.setEmp_photo_path(transformPhotoPath(emp_photo_path));	
				}else{
					oaRlzybEmployee.setEmp_photo_path("空");
				}

				
				String emp_idcard_front = oaRlzybEmployee.getEmp_idcard_front();
				if(emp_idcard_front!=null){
					
					oaRlzybEmployee.setEmp_idcard_front(transformPhotoPath(emp_idcard_front));
				}else{
					
					oaRlzybEmployee.setEmp_idcard_front("空");
				}
			
				
				String emp_idcard_reverse = oaRlzybEmployee.getEmp_idcard_reverse();
				System.out.println("测试测试"+emp_idcard_reverse);
				if(emp_idcard_reverse!=null){
					oaRlzybEmployee.setEmp_idcard_reverse(transformPhotoPath(emp_idcard_reverse));
				}else{
					oaRlzybEmployee.setEmp_idcard_reverse("空");
				}
				

				
				String emp_Degree_certificate = oaRlzybEmployee.getEmp_Degree_certificate();
				if(emp_Degree_certificate!=null){
					
					oaRlzybEmployee.setEmp_Degree_certificate(transformPhotoPath(emp_Degree_certificate));
				}else{
					oaRlzybEmployee.setEmp_Degree_certificate("空");
				}

				
				String emp_Education_certificate = oaRlzybEmployee.getEmp_Education_certificate();
				if(emp_Education_certificate!=null){
					
					oaRlzybEmployee.setEmp_Education_certificate(transformPhotoPath(emp_Education_certificate));
				}else{
					oaRlzybEmployee.setEmp_Education_certificate("空");
				}
			
				
				
				
				
				
				
				
				List<OaRlzybTechnicalTitle> oaRlzybTechnicalTitleList = oaRlzybEmployeeService.getOaRlzybTechnicalTitleByEmpId(Integer.parseInt(emp_id));

				for (Iterator iterator = oaRlzybTechnicalTitleList.iterator(); iterator
				.hasNext();) {
			OaRlzybTechnicalTitle oaRlzybTechnicalTitle = (OaRlzybTechnicalTitle) iterator
					.next();
			String emp_technical_title_path  = oaRlzybTechnicalTitle.getTechnical_title_path();
			oaRlzybTechnicalTitle.setTechnical_title_path(transformPhotoPath(emp_technical_title_path));
			
		}		

				Date emp_Entry_date = oaRlzybEmployee.getEmp_Entry_date();
				
				Date emp_tryout_end_date = oaRlzybEmployee.getEmp_tryout_end_date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				oaRlzybEmployee.setEmp_Entry_date_str(sdf.format(emp_Entry_date));
				oaRlzybEmployee.setEmp_tryout_end_date_str(sdf.format(emp_tryout_end_date));
			
				
		        request.setAttribute("oaRlzybTechnicalTitleList", oaRlzybTechnicalTitleList);
				request.setAttribute("oaRlzybEmployee", oaRlzybEmployee);
				
				
				
				
				
				
				
				return "human_resource_department/requestleave_add";
			}
			
			
	public String transformPhotoPath(String photoPath){
		int photoPath_index = photoPath.lastIndexOf("\\");
		photoPath = photoPath.substring(photoPath_index+1);
		photoPath = "/uploadfiles/"+photoPath;
		return photoPath;
	}
	
	/**
	 * 查询数据库中是否 有重复的员工身份证号
	 * @param empIdCard
	 * @param request
	 * @return
	 */
	@RequestMapping("/GetEmployeeCount")
	@ResponseBody
	public String GetEmployeeCount(@RequestParam("emp_idcard") String emp_idcard) {
	if(oaRlzybEmployeeService.getOaRlzybEmployeeCountByEmpIdCard(emp_idcard)==1){
		return "1";
	}else{
		return "0";
	}
	}
	
	
	
	@RequestMapping(value="/DeleteEmployee/{del_emp_id}",produces = "text/html;charset=UTF-8;")
	@ResponseBody
	public String DeleteEmployee(@PathVariable("del_emp_id") String del_emp_id) {
     if(oaRlzybEmployeeService.deleteOaRlzybEmployeeByEmpId(Integer.parseInt(del_emp_id))==1){
    	 return "1";
     }else{
    	 return "0"; 
     }
	}
	//删除对象
	@RequestMapping(value="/DeleteEmployees")
	@ResponseBody
	public String DeleteEmployees(String emp_id) {
    
     int i = oaRlzybEmployeeService.deleteByPrimaryKey(Integer.parseInt(emp_id));
     if(i>0){
    	 return "1";
     }else{
    	 return "0"; 
     }
	}
	
	@RequestMapping(value="/CheckPhoneNumber",produces = "text/html;charset=UTF-8;")
	@ResponseBody
	public String CheckPhoneNumber(@RequestParam("phone_val") String phone_val) {
     if(oaRlzybEmployeeService.getOaRlzybEmployeeCountByPhoneNumber(phone_val)==0){
    	 return "0";
     }else{
    	 return "1"; 
     }
	}
	
	
	
	@RequestMapping(value="/CheckEmailAddress",produces = "text/html;charset=UTF-8;")
	@ResponseBody
	public String CheckEmailAddress(@RequestParam("emp_Email") String emp_Email) {
     if(oaRlzybEmployeeService.getOaRlzybEmployeeCountByEmailAddress(emp_Email)==0){
    	 return "0";
     }else{
    	 return "1"; 
     }
	}
	
	/**
	 * 删除信息不完整的员工
	 * @param emp_Email
	 * @return
	 */
	@RequestMapping(value="/DeleteInformationBugOaRlzybEmployee",produces = "text/html;charset=UTF-8;")
	@ResponseBody
	public String DeleteInformationBugOaRlzybEmployee() {
		oaRlzybEmployeeService.realDeleteInformationBugOaRlzybEmployee();
		return null;
	}
	
	
	
	
	/**
	 * 查询员工
	 * 
	 * @return
	 */
	@RequestMapping(value = "/SearchEmployee", produces = "text/html;charset=UTF-8;")
	@ResponseBody
	public Object searchEmployee(@RequestParam("emp_name") String emp_name,
			@RequestParam String emp_age_begin,
			@RequestParam String emp_age_end,
			@RequestParam String birthday_year,
			@RequestParam String birthday_month,
			@RequestParam String birthday_day, @RequestParam String emp_sex,
			@RequestParam String emp_grade_id,
			@RequestParam(required = false) String emp_status2,
			@RequestParam(required = false) String emp_status3,
			@RequestParam String pageIndex, HttpServletRequest request) {
		Map<String,Object> result = new HashMap<>();
		String[] result_str = new String[2];
		Map<String, Object> condition = new HashMap<>();
		Page page = new Page();
		if (emp_name == null) {
			condition.put("emp_name", null);
			condition.put("emp_name_simple", null);
		} else {
			char[] emp_name_chars = emp_name.toCharArray();
			for (int i = 0; i < emp_name_chars.length; i++) {
				if ((int) emp_name_chars[i] >= 97
						&& (int) emp_name_chars[i] <= 122) {
					emp_name = emp_name.toUpperCase();
					condition.put("emp_name_simple", emp_name);
					condition.put("emp_name", null);
					break;
				} else if ((int) emp_name_chars[i] >= 65
						&& (int) emp_name_chars[i] <= 90) {
					condition.put("emp_name_simple", emp_name);
					condition.put("emp_name", null);
					break;
				} else {
					condition.put("emp_name", emp_name);
					condition.put("emp_name_simple", null);
				}
			}
		}
		/* System.out.println(condition.get("emp_name")); */

		/* condition.put("emp_name", null); */
		if (!emp_age_begin.equals("")) {
			condition.put("emp_age_begin", emp_age_begin);
		} else {
			condition.put("emp_age_begin", null);
		}
		if (!emp_age_end.equals("")) {
			condition.put("emp_age_end", emp_age_end);
		} else {
			condition.put("emp_age_end", null);
		}
		condition.put("birthday_year", birthday_year);
		condition.put("birthday_month", birthday_month);
		condition.put("birthday_day", birthday_day);
		condition.put("emp_sex", emp_sex);
		condition.put("emp_grade_id", Integer.parseInt(emp_grade_id));
		condition.put("emp_status2", emp_status2);
		condition.put("emp_status3", emp_status3);
		page.setPageSize(10);
		page.setTotalCount(oaRlzybEmployeeService
				.getEmployeeCountByCondition(condition));
		if(pageIndex==null||pageIndex.equals("")){
			pageIndex="1";
		}
		page.setCurrentPageNo(Integer.parseInt(pageIndex));
		condition.put("fromIndex",
				(page.getCurrentPageNo() - 1) * page.getPageSize());
		condition.put("pageSize", page.getPageSize());
		page.setOaRlzybEmployeeList(oaRlzybEmployeeService
				.getOaRlzybEmployeeByPage(condition));
		List<OaRlzybEmployee> OaRlzybEmployeeList = page
				.getOaRlzybEmployeeList();

		condition.put("resultCount", page.getTotalCount());
		int number = 0;
		/* System.out.println(page.getOaRlzybEmployeeList().size()); */
		String htmlStr = "";
//		htmlStr += " <table cellpadding='0' cellspacing='0' border='1'";
//		htmlStr += " class='selectTable'>";
//		htmlStr += " <tr>";
//		htmlStr += " <th>编号</th>";
//		htmlStr += " <th>姓名</th>";
//		htmlStr += " <th>岗位</th>";
//		htmlStr += " <th>部门</th>";
//		htmlStr += " <th>年龄</th>";
//		htmlStr += " <th>性别</th>";
//		htmlStr += " <th>学历</th>";
//		htmlStr += " <th>技术职称</th>";
//		htmlStr += " <th>联系方式</th>";
//		htmlStr += " <th>紧急联系人(电话)</th>";
//		htmlStr += " <th>出生日期</th>";
//		htmlStr += " <th>入职时间</th>";
//		htmlStr += " <th>业务功能</th>";
//		htmlStr += " <th>数据管理</th>";
//		htmlStr += " </tr>";
	 	Date now = new Date(System.currentTimeMillis());
	    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	    String nowStr = sdf1.format(now);
	    String nowStrYear = nowStr.substring(0, 4);
		for (Iterator iterator = OaRlzybEmployeeList.iterator(); iterator.hasNext();) {
			number++;
			String numberStr = "";
			if (Integer.toString(number).length() <= 4) {
				for (int i = (4 - Integer.toString(number).length()); i > 0; i--) {
					numberStr += "0";
				}
			}
			numberStr = numberStr + Integer.toString(number);
			OaRlzybEmployee oaRlzybEmployee = (OaRlzybEmployee) iterator.next();
			String birthday_year1 = oaRlzybEmployee.getEmp_idcard().trim().substring(6, 10);
			oaRlzybEmployee.setEmp_age((Integer.parseInt(nowStrYear)- Integer.parseInt(birthday_year1)));
			if(oaRlzybEmployee.getEmp_contact_relationship()==null){
				oaRlzybEmployee.setEmp_contact_relationship("无");
			}
			if(oaRlzybEmployee.getEmp_contact_phone()==null){
				oaRlzybEmployee.setEmp_contact_phone("无");
			}
			if(oaRlzybEmployee.getEmp_department_name()==null){
				oaRlzybEmployee.setEmp_department_name("无");
			}
			if(oaRlzybEmployee.getEmp_position_name()==null){
				oaRlzybEmployee.setEmp_position_name("无");
			}
			htmlStr += "<tr>";
			htmlStr += "<td>" + numberStr + "</td>";
			if(oaRlzybEmployee.getEmp_now_status().equals("离职")){
				htmlStr += "<td style='background-color: red;color:white;'>" + oaRlzybEmployee.getEmp_name() + "(离职)</td>";
			}else if(oaRlzybEmployee.getEmp_now_status().equals("停薪留职")){
				htmlStr += "<td style='background-color: orange;'>" + oaRlzybEmployee.getEmp_name() + "(停薪留职)</td>";
			}else{
				htmlStr += "<td>" + oaRlzybEmployee.getEmp_name() + "</td>";
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
			/*
			 * 出生日期修改格式
			 */
			//String getEmp_birthday = sdf.format(oaRlzybEmployee.getEmp_birthday());
			String idcard=oaRlzybEmployee.getEmp_idcard();
			String birthday_years=idcard.substring(6, 10);
			String birthday_ms=idcard.substring(10, 12);
			String birthday_days=idcard.substring(12, 14);
			String getEmp_birthday=birthday_years+"年"+birthday_ms+"月"+birthday_days+"日";
			htmlStr += "<td>" + oaRlzybEmployee.getEmp_position_name()
					+ "</td>";
			htmlStr += "<td>" + oaRlzybEmployee.getEmp_department_name()
					+ "</td>";
			htmlStr += "<td>" + oaRlzybEmployee.getEmp_age() + "</td>";
			htmlStr += "<td>" + oaRlzybEmployee.getEmp_sex() + "</td>";
			htmlStr += "<td>" + oaRlzybEmployee.getEmp_educational_background()
					+ "</td>";
			htmlStr += "<td>" + oaRlzybEmployee.getEmp_technical_title_name()
					+ "</td>";
			htmlStr += "<td>" + oaRlzybEmployee.getEmp_phone() + "</td>";
			htmlStr += "<td>" + oaRlzybEmployee.getEmp_contact_relationship()
					+ "：" + oaRlzybEmployee.getEmp_contact_phone() + "</td>";
			htmlStr += "<td>" + getEmp_birthday + "</td>";
			/*
			 * 入职时间修改格式
			 */
			String getEmp_Entry_date_str = sdf.format(oaRlzybEmployee
					.getEmp_Entry_date());
			htmlStr += "<td>" + getEmp_Entry_date_str + "</td>";
			OaJzbRevoke oaJzbRevoke = new OaJzbRevoke();
			htmlStr += "<td>" ;
			htmlStr +=	"<a href='javascript:void(0);'  emp_id = '"+ oaRlzybEmployee.getEmp_id()+ "' class='interview'>访谈</a>" ;
			htmlStr +=	"<a href='javascript:void(0);'  emp_id = '"+ oaRlzybEmployee.getEmp_id()+ "' class='job'>调岗</a>" ;
			htmlStr +=	"<a href='javascript:void(0);'  emp_id = '"+ oaRlzybEmployee.getEmp_id()+ "' class='salary'>调薪</a>" ;
			htmlStr +=	"<a href='javascript:void(0);'  emp_id = '"+ oaRlzybEmployee.getEmp_id()+ "' class='randp'>奖惩</a>" ;
			htmlStr +=	"<a href='javascript:void(0);'  emp_id = '"+ oaRlzybEmployee.getEmp_id()+ "' class='transfer'>离岗</a>";
			htmlStr +=	"<a href='javascript:void(0);'  emp_id = '"+ oaRlzybEmployee.getEmp_id()+ "' class='position'>离职</a>";
			htmlStr += "</td>";
//			htmlStr += "<td>" ;
//			htmlStr +=	"<a href='javascript:void(0);'  emp_id = '"+ oaRlzybEmployee.getEmp_id()+ "' class='link'>查看</a>" ;
//			htmlStr += "<a href='javascript:void(0);'   emp_id = '"+ oaRlzybEmployee.getEmp_id()+ "'   class='edit'>编辑</a>" ;
//			if(oaJzbRevoke.Revoke(oaRlzybEmployee.getCreate_time())){
//			}else{
//				htmlStr +=	" <a href='javascript:void(0);' emp_id = '"+ oaRlzybEmployee.getEmp_id() + "' class='delete'>删除</a>" ;
//			}
			htmlStr += "</tr>" ;
		}
//		htmlStr += " </table>";
//		htmlStr += " <div id='page'>";
//		int currentFromIndex = (page.getCurrentPageNo() - 1)
//				* page.getPageSize() + 1;
//		int currentEndIndex = currentFromIndex+number-1;
//		
//		htmlStr += " 当前" + currentFromIndex + "-" + currentEndIndex + "";
//		htmlStr += " 条";
//		for (int i = 1; i <= page.getTotalPageCount(); i++) {
//			htmlStr += " <span onclick='javascript:page_nav(document.forms[0],"
//					+ i + ");'>" + i + "</span>";
//		}
//		htmlStr += " 共" + page.getTotalPageCount() + "页";
//		htmlStr += " </div>";
//		htmlStr += " <div class='btposition2'>";
//		htmlStr += " <div>";
//		htmlStr += " </div>";
//		htmlStr += "<div class='mbStyle'>&nbsp;</div>";
//		htmlStr += "<div class='deleteStyle'>";
//		htmlStr += "<h3>操作提示</h3>";
//		htmlStr += "<h2>确定要删除吗？</h2>";
//		htmlStr += "<div class='btn'>";
//		htmlStr += "<div class='bottomStyle1'>确定</div>";
//		htmlStr += "<div class='bottomStyle2'>取消</div>";
//		htmlStr += "</div>";
//		htmlStr += "</div>";
//		htmlStr += " </div>";
	/*	htmlStr += " </div>";*/
		/*System.out.println(htmlStr);*/
		System.out.println(htmlStr.toString());
		result_str[0] = htmlStr.toString();
		result_str[1] = page.getTotalCount()+"";
		result.put("result", result_str);
		return JSONArray.toJSONString(result);
	}	
	/**
	 * 查询所有的在全职     兼职员工信息
	 * @return
	 */
	@RequestMapping(value="selectAllqzj")
	@ResponseBody
	public Page selectAllquanzhi(String emp_Employment_nature,String emp_now_status,String index,String pageSize,String emp_name,String emp_department,String emp_educational_background,String emp_birthday,String emp_phone){
		Page page=new Page();
		int Index=1;
		if(index!=null||index!=""){
			Index=Integer.parseInt(index);
		}
		int PageSize = 10;
		if(pageSize!=null||pageSize!=""){
			PageSize=Integer.parseInt(pageSize);
		}
		int department = Integer.parseInt(emp_department);
		page.setPageSize(PageSize);
		int totalCount = oaRlzybEmployeeService.selectCounts(emp_Employment_nature, emp_now_status, emp_name, null, department, emp_educational_background, emp_birthday, emp_phone);//在职记录数
		page.setTotalCount(totalCount);
		
		if(Index < 1){
			Index = 1;
    	}else if(Index >page.getTotalPageCount()){
    		Index = page.getTotalPageCount();
    	}
		Index =page.getPageSize()*(Index-1); 
		page.setCurrentPageNo(Index);//当前页数 
		List<OaRlzybEmployee> list = null;
		if(totalCount!=0){
			list = oaRlzybEmployeeService.selectAllqzj(emp_Employment_nature, emp_now_status, Index, PageSize, emp_name, null, department, emp_educational_background, emp_birthday, emp_phone);
		}
		page.setOaRlzybEmployeeList(list);
		return page;
	}
	/**
	 * 通过id得到对象
	 * @param emp_id
	 * @return
	 */
	@RequestMapping(value="selectByPrimaryKey")
	@ResponseBody
	public OaRlzybEmployee selectByPrimaryKey(int emp_id){
		OaRlzybEmployee key = oaRlzybEmployeeService.selectByPrimaryKey(emp_id);
		return key;
	}
	/**
	 * 得到全职的人数
	 * @return
	 */
	@RequestMapping(value="selectCountquanzhi")
	@ResponseBody
	public int selectCountquanzhi(){
		return  oaRlzybEmployeeService.selectCountquanzhi();
	}
	/**
	 * 得到在职的人数
	 * @return
	 */
	@RequestMapping(value="selectCountzaizhi")
	@ResponseBody
	public int selectCountzaizhi(){
		return  oaRlzybEmployeeService.selectCountzzhi();
	}
	/**
	 * 得到兼职的人数
	 * @return
	 */
	@RequestMapping(value="selectCountjianzhi")
	@ResponseBody
	public int selectCountjianzhi(){
		return  oaRlzybEmployeeService.selectCountjianzhi();
	}
	
	/**
	 * 得到试用期的人数
	 * @return
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value="selectCountshiyongqi",method=RequestMethod.POST)
	@ResponseBody
	public List<OaRlzybEmployee> selectCountshiyongqi(String emp_name,Integer emp_department){
		int i=0;
		List<OaRlzybEmployee> list = oaRlzybEmployeeService.getHumanAffairsOaRlzybEmployees();
		List<OaRlzybEmployee> listsyq = new ArrayList<OaRlzybEmployee>();
		OaRlzybEmployee ore ;
		for (OaRlzybEmployee oa : list) {
			Date end=oa.getEmp_tryout_end_date();
			Date str=new Date();
			if(end.getTime()>str.getTime()){

				ore = new OaRlzybEmployee();
				ore.setEmp_id(oa.getEmp_id());
				ore.setEmp_name(oa.getEmp_name());
				ore.setEmp_age(oa.getEmp_age());
				ore.setEmp_sex(oa.getEmp_sex());
				ore.setEmp_department(oa.getEmp_department());
				ore.setEmp_department_name(oa.getEmp_department_name());
				ore.setEmp_position_name(oa.getEmp_position_name());
				ore.setEmp_tryout_end_date(oa.getEmp_tryout_end_date());
				ore.setEmp_tryout_end_date_str(oa.getEmp_tryout_end_date_str());
				if(emp_name==null||emp_name==""||emp_department==0){
					listsyq.add(ore);
				}else{
					if(emp_name==ore.getEmp_name()){
						listsyq.add(ore);
					}else if(emp_department==ore.getEmp_department()){
						listsyq.add(ore);
					}else if(emp_name==ore.getEmp_name()&&emp_department==ore.getEmp_department()){
						listsyq.add(ore);
					}
				}
				
			}
		}
		
		return  listsyq;
	} 
	
	/**
	 * 得到离岗的人数
	 * @return
	 */
	@RequestMapping(value="	selectCountligang")
	@ResponseBody
	public int 	selectCountligang(){
		return  oaRlzybEmployeeService.	selectCountligang();
	}
	/**
	 * 得到停薪留职的人数
	 * @return
	 */
	@RequestMapping(value="	selectCounttingxin")
	@ResponseBody
	public int 	selectCounttingxin(){
		return  oaRlzybEmployeeService.	selectCountlizhi(3);
	}
	/**
	 * 得到离职的人数
	 * @return
	 */
	@RequestMapping(value="	selectCountlizhi")
	@ResponseBody
	public int 	selectCountlizhi(){
		return  oaRlzybEmployeeService.	selectCountlizhi(1);
	}
	/**
	 * 得到待离职的人数
	 * @return
	 */
	@RequestMapping(value="	selectCountdailizhi")
	@ResponseBody
	public int 	selectCountdailizhi(){
		return  oaRlzybEmployeeService.	selectCountlizhi(2);
	}
	/**
	 * 增加岗位
	 * @param position
	 * @return
	 */
	@RequestMapping(value="	insertgangwei",method=RequestMethod.POST)
	@ResponseBody
	public int insertgangwei(String position_name, int depart_id, int jurisdiction_id){
		return oaRlzybPositionService.insertgangwei(position_name, depart_id, jurisdiction_id);
	}
	/**
	 * 通过与员工id得到对象
	 * @param emp_id
	 * @return
	 */
	@RequestMapping(value="getInfo",method=RequestMethod.POST)
	@ResponseBody
	public OaRlzybEmployee getInfo(int emp_id){
		OaRlzybEmployee info = oaRlzybEmployeeService.showInfo(emp_id);
		System.out.println(info.getDepart_name());
		System.out.println(info.getEmp_name());
		System.out.println(info.getPosition_name());
		return info;
	}
	
	//三级联动、、、、、、、、、、、、、、、、、、、、、、
	//省
	@RequestMapping(value="ListProvince",method=RequestMethod.POST)
	@ResponseBody
	public List<OaRlzybHatProvince> ListProvince(){
		return oaRlzybEmployeeService.ListProvince();
	}
	
	//市
	@RequestMapping(value="ListCity",method=RequestMethod.POST)
	@ResponseBody
	public List<OaRlzybHatCity> ListCity(String provinceID){
		return oaRlzybEmployeeService.ListCity(provinceID);
	}
	
	//县
	@RequestMapping(value="ListArea",method=RequestMethod.POST)
	@ResponseBody
	public List<OaRlzybHatArea> ListArea(String cityID){
		return oaRlzybEmployeeService.ListArea(cityID);
	}
	//增加员工的信息
	@RequestMapping(value="insertSelective",method=RequestMethod.POST)
	@ResponseBody
	public int insertSelective(String emp_name,String emp_idcard,String emp_phone,String emp_age,String emp_sex,String emp_marital_status,String emp_political_status,String emp_educational_background,String nation_name,String emp_Email,String emp_province,String emp_city,String emp_county,String emp_address,String emp_department,String emp_position,String emp_Employment_nature,String emp_Entry_date,String emp_tryout_end_date,String emp_now_status,String emp_grade_id,String emp_registrant,String emp_photo_path,String emp_remarks,String emp_origin_detail,String emp_now_province,String emp_now_city,String emp_now_county,String emp_now_detail) throws ParseException{
		OaRlzybEmployee record=new OaRlzybEmployee();
		OaRlzybUser oaRlzybUser=new OaRlzybUser();
		record.setEmp_delectStatus("未删除");
		record.setCreate_time(new Date(System.currentTimeMillis()));
		record.setEmp_name(emp_name);
		record.setEmp_idcard(emp_idcard);
		int age = 0;
		if(emp_age!=null||emp_age!=""){
			age = Integer.parseInt(emp_age);
		}
		record.setEmp_phone(emp_phone);
		record.setEmp_age(age);
		record.setEmp_sex(emp_sex);
		record.setEmp_marital_status(emp_marital_status);
		record.setEmp_political_status(emp_political_status);
		record.setEmp_educational_background(emp_educational_background);
		record.setNation_name(nation_name);
		record.setEmp_Email(emp_Email);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		Date end = null;String emp_birthday;
		if(emp_idcard!=null||emp_idcard!=""){
			emp_birthday=emp_idcard.substring(6,10)+"-"+emp_idcard.substring(10,12)+"-"+emp_idcard.substring(12,14);
			end=(Date) sdf.parseObject(emp_birthday);
		}
		record.setEmp_birthday(end);
		int province = 0,city = 0,areas = 0;
		if(emp_province!=null||emp_province!=""){
			province=Integer.parseInt(emp_province);
		}
		if(emp_city!=null||emp_city!=""){
			city=Integer.parseInt(emp_city);
		}
		if(emp_county!=null||emp_county!=""){
			areas=Integer.parseInt(emp_county);
		}
		record.setEmp_province(province);
		record.setEmp_city(city);
		record.setEmp_county(areas);
		record.setEmp_address(emp_address);
		int depart = 0,position = 0;
		if(emp_department!=null||emp_department!=""){
			depart=Integer.parseInt(emp_department);
		}
		if(emp_position!=null||emp_position!=""){
			position=Integer.parseInt(emp_position);
		}
		record.setEmp_department(depart);
		record.setEmp_position(position);
		record.setEmp_Employment_nature(emp_Employment_nature);
		Date str = null ;Date str1=null;
		if(emp_Entry_date!=null||emp_Entry_date!=""){
			str = (Date) sdf.parseObject(emp_Entry_date);
		}
		record.setEmp_Entry_date(str);
		if(emp_tryout_end_date!=null||emp_tryout_end_date!=""){
			str1 = (Date) sdf.parseObject(emp_tryout_end_date);
		}
		record.setEmp_tryout_end_date(str1);
		record.setEmp_now_status(emp_now_status);
		int grade = 0,res = 0;
		if(emp_grade_id!=null||emp_grade_id!=""){
			grade=Integer.parseInt(emp_grade_id);
		}
		if(emp_grade_id!=null||emp_registrant!=""){
			res=Integer.parseInt(emp_registrant);
		}
		record.setEmp_grade_id(grade);
		record.setEmp_registrant(res);
		record.setEmp_remarks(emp_remarks);
		record.setEmp_photo_path(emp_photo_path);
		record.setEmp_origin_detail(emp_origin_detail);
		record.setEmp_now_province(emp_now_province);
		record.setEmp_now_city(emp_now_city);
		record.setEmp_now_county(emp_now_county);
		record.setEmp_now_detail(emp_now_detail);
		
		oaRlzybUser.setUser_name(emp_phone);
		oaRlzybUser.setUser_pwd("888888");
		oaRlzybUser.setPosition_id(position);
		oaRlzybUser.setLogin_type(1);
		int selective = oaRlzybEmployeeService.insertSelective(record);
		oaRlzybUser.setLogincont(0);
		int Emp_id=oaRlzybEmployeeService.getEmpIdByEmpIdCard(record);
		oaRlzybUser.setEmp_id(Emp_id);
		oaRlzybEmployeeService.addUser(oaRlzybUser);
		return 	selective;
	}
	//上传照片
	@RequestMapping(value="upload",method=RequestMethod.POST)
	@ResponseBody
	public String upload(@RequestParam(value="file",required=false)MultipartFile file,HttpServletRequest request) throws Exception, IOException{
		File f=null;
		String name = null;
		if(!file.isEmpty()){
			//获取源文件的名称
			//System.currentTimeMillis()
			name=String.valueOf(new Date().getTime()+file.getOriginalFilename());
			System.out.println(name);
			//获取文件存储路径
			String path=request.getServletContext().getRealPath(File.separator+"statics"+File.separator+"uploadfiles");
			System.out.println("地址："+path);
			//进行路径拼接
			f=new File(path,name);
			//判断文件是否存在
			if(!f.exists()){
				f.mkdirs();
			}
			System.out.println(f);
			//存储到磁盘中
			file.transferTo(f);
		}
		return name;
	}
	
	//保存证件信息
	
	@RequestMapping(value="upziduan", method=RequestMethod.POST)
	@ResponseBody
	public int updateziduan(String emp_idcard_front,String emp_idcard_reverse,String emp_Degree_certificate,String emp_Education_certificate,String emp_technical_title_path,String emp_id){
		int empid = 0;
		
		if(emp_id!=null||emp_id!=""){
			empid=Integer.parseInt(emp_id);
		
		}
		int updateziduan = oaRlzybEmployeeService.updateziduan(emp_idcard_front, emp_idcard_reverse, emp_Degree_certificate, emp_Education_certificate, emp_technical_title_path, empid);
		System.out.println(updateziduan);
		return updateziduan;
		
	}
	//编辑紧急联系人
	@RequestMapping("updatejinji")
	@ResponseBody
	public int updatejinji(String emp_id,String emp_contact_address_province,String emp_contact_address_city,String emp_contact_address_county,String emp_contact_address_detail,String emp_contact_name,String emp_contact_phone,String emp_contact_relationship,String emp_contact_address){
		OaRlzybEmployee record=new OaRlzybEmployee();
		int empid = 0;
		System.out.println(emp_id);
		if(emp_id!=null||emp_id!=""){
			empid=Integer.parseInt(emp_id);
		}
		record.setEmp_id(empid);
		record.setEmp_contact_address_province(emp_contact_address_province);
		record.setEmp_contact_address_city(emp_contact_address_city);
		record.setEmp_contact_address_county(emp_contact_address_county);
		record.setEmp_contact_address_detail(emp_contact_address_detail);
		record.setEmp_contact_name(emp_contact_name);
		record.setEmp_contact_phone(emp_contact_phone);
		record.setEmp_contact_relationship(emp_contact_relationship);
		record.setEmp_contact_address(emp_contact_address);
		return oaRlzybEmployeeService.updatejinji(record);
	}
	@RequestMapping("updatejingli")
	@ResponseBody
	public int updatejingli(String emp_id,String emp_Education_experience,String emp_work_experience,String emp_train_experience,String emp_society_relation,String emp_remarks){
		OaRlzybEmployee record=new OaRlzybEmployee();
		int empid = 0;
		System.out.println(emp_id);
		if(emp_id!=null||emp_id!=""){
			empid=Integer.parseInt(emp_id);
		}
		record.setEmp_id(empid);
		record.setEmp_society_relation(emp_society_relation);
		record.setEmp_Education_experience(emp_Education_experience);
		record.setEmp_work_experience(emp_work_experience);
		record.setEmp_train_experience(emp_train_experience);
		record.setEmp_remarks(emp_remarks);
		return oaRlzybEmployeeService.updatejingli(record);
		
	}
	//修改个人信息
	@RequestMapping("updateperson")
	@ResponseBody
	public int updateperson(String emp_id,String emp_educational_background,String emp_name,String emp_idcard,String emp_name_simple,String emp_phone,String emp_sex,String emp_marital_status,String nation_name,String emp_Email,String emp_hobby,String emp_educational_background1,String emp_age,String emp_now_detail){
		OaRlzybEmployee record=new OaRlzybEmployee();
		int empid = 0;
		System.out.println(emp_id);
		if(emp_id!=null||emp_id!=""){
			empid=Integer.parseInt(emp_id);
		}
		record.setEmp_id(empid);
		record.setEmp_name(emp_name);
		int age=0;
		if(emp_age!=null||emp_age!=""){
			age=Integer.parseInt(emp_age);
		}
		record.setEmp_age(age);
		record.setEmp_educational_background(emp_educational_background1);
		record.setEmp_idcard(emp_idcard);
		record.setEmp_name_simple(emp_name_simple);
		record.setEmp_phone(emp_phone);
		record.setEmp_sex(emp_sex);
		record.setEmp_marital_status(emp_marital_status);
		record.setNation_name(nation_name);
		record.setEmp_Email(emp_Email);
		record.setEmp_hobby(emp_hobby);
		record.setEmp_educational_background(emp_educational_background1);
		record.setEmp_now_detail(emp_now_detail);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		Date end = null;String emp_birthday;
		if(emp_idcard!=null||emp_idcard!=""){
			emp_birthday=emp_idcard.substring(6,10)+"-"+emp_idcard.substring(10,12)+"-"+emp_idcard.substring(12,14);
			try {
				end=(Date) sdf.parseObject(emp_birthday);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		record.setEmp_birthday(end);
		return oaRlzybEmployeeService.updateperson(record);
		
	}
	
	/*转正修改*/
	@RequestMapping(value="OaRlzybEmployeesUpdataRq",method=RequestMethod.POST)
	@ResponseBody
	public int OaRlzybEmployeesUpdataRq(String emp_tryout_end_date,Integer emp_id){
		int updatasyq = oaRlzybEmployeeService.updatasyq(emp_id, emp_tryout_end_date);
		return updatasyq;
	}
	
	@RequestMapping("getHumanAffairsOaRlzybEmployeess")
	@ResponseBody
	public List<OaRlzybEmployee> getHumanAffairsOaRlzybEmployeess(){
		List<OaRlzybEmployee> list = oaRlzybEmployeeService.getHumanAffairsOaRlzybEmployees();
		OaRlzybEmployee list1= null;
		List<OaRlzybEmployee> list2 = new ArrayList<OaRlzybEmployee>();
		Date d=new Date(System.currentTimeMillis());
		int ds=d.getMonth();
		int i=0;
		
		for (OaRlzybEmployee oaRlzybEmployee : list) {
			int m=oaRlzybEmployee.getEmp_birthday().getMonth();
			if(m==ds){
				list1 = new OaRlzybEmployee();
				i++;
				list1.setEmp_birthday(oaRlzybEmployee.getEmp_birthday());
				System.out.println(oaRlzybEmployee.getEmp_birthday());
				list1.setEmp_name(oaRlzybEmployee.getEmp_name());
				list2.add(list1);
			}
		}
		System.out.println(list1.getEmp_name());
		return list2;
	}
	
}

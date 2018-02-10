package cn.tyyhoa.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.jboss.weld.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tyyhoa.pojo.OaRlzybContract;
import cn.tyyhoa.pojo.OaRlzybEmployee;
import cn.tyyhoa.pojo.OaRlzybHatArea;
import cn.tyyhoa.pojo.OaRlzybHatCity;
import cn.tyyhoa.pojo.OaRlzybHatProvince;
import cn.tyyhoa.pojo.OaRlzybItem;
import cn.tyyhoa.pojo.OaRlzybPosition;
import cn.tyyhoa.service.OaRlzybContractService;
import cn.tyyhoa.service.OaRlzybDimissionService;
import cn.tyyhoa.service.OaRlzybEmployeeService;
import cn.tyyhoa.service.OaRlzybPositionService;
import cn.tyyhoa.service.OaRlzybWelcomeService;
import cn.tyyhoa.service.impl.OaRlzybEmployeeServiceImpl;

public class test {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext a=new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
		OaRlzybWelcomeService oa=(OaRlzybWelcomeService)a.getBean("oaRlzybWelcomeService");
		OaRlzybContractService qq= (OaRlzybContractService)a.getBean("oaRlzybContractService");
		OaRlzybEmployeeService bean = (OaRlzybEmployeeService) a.getBean("oaRlzybEmployeeService");
		int i = bean.updatasyq(58,"2016-05-31 00:00:00");
		if(i>0){
			System.out.println(12311);
		}
	/*	List<OaRlzybEmployee> list = oa.selectAllByEmployeeNature("李林", null, "人力资源行政部", "全职", "本科", "1990-05-16 00:00:00", "15834143980");
		for (OaRlzybEmployee o : list) {
			System.out.println(o.getEmp_name_simple());
		}
		List<OaRlzybEmployee> list2 = oa.selectAllByNowStatus("李林", null, "人力资源行政部", "在职", "本科", "1990-05-16 00:00:00", "15834143980");
		for (OaRlzybEmployee o : list2) {
			System.out.println(o.getEmp_name_simple());
		}*/
		/*List<OaRlzybEmployee> list = oa.selectAllquanzhi("全职", 1, 3);
		for (OaRlzybEmployee oas : list) {
			System.out.println(oas.getEmp_Email());
		}
		List<OaRlzybEmployee> list2 = oa.selectAllzaizhi("在职", 1, 3);
		for (OaRlzybEmployee oas : list2) {
			System.out.println(oas.getEmp_Email());
		}*/
		/*List<OaRlzybHatProvince> list = oa.ListProvince();
		for (OaRlzybHatProvince oaw : list) {
			System.out.println(oaw.getProvince());
		}*/
		/*List<OaRlzybHatCity> list2 = oa.ListCity("110000");
			for (OaRlzybHatCity oas : list2) {
				System.out.println(oas.getCity());
			}*/
	/*	List<OaRlzybHatArea> list = oa.ListArea("110100");
		for (OaRlzybHatArea oaa: list) {
			System.out.println(oaa.getArea());
		}*/
/*		OaRlzybEmployee record=new OaRlzybEmployee();
		record.setEmp_name("sss");
		int i = oa.insertSelective(record);
		System.out.println(i);*/
		/*List<OaRlzybPosition> list = oa.selectAllByDepartId(1);
		
		for (OaRlzybPosition oaRlzybPosition : list) {
			System.out.println(oaRlzybPosition.getPosition_name()+"======"+oaRlzybPosition.getPosition_id());
		}*/
		/*String dimission_date="2018-01-06";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d1=new Date();
		String format = sdf.format(d1);
		if(format.equals(dimission_date)){
			int i = oa.updatedimissionStatus(11);
			System.out.println(i);
		}*/
		
	/*List<OaRlzybEmployee> list = oa.getHumanAffairsOaRlzybEmployees();
	
	for (OaRlzybEmployee oaRlzybEmployee : list) {
		System.out.println(oaRlzybEmployee.getEmp_Email());
	}*/
	/*	OaRlzybEmployee key = oa.selectByPrimaryKey(1);
		System.out.println(key.getEmp_Email());
	List<OaRlzybEmployee> list = oa.selectAllquanzhi("停薪留职");
	System.out.println(list);
	System.out.println("--------------------------------------------------------------");
	for (OaRlzybEmployee oaRlzybEmployee : list) {
		System.out.println("--------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------");
		System.out.println(oaRlzybEmployee.getEmp_Email());
	}*/
		/*OaRlzybItem oas=new OaRlzybItem();
		oas.setName("22");
		oas.setText("33");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:ss:mm");  
		Date times=new Date(System.currentTimeMillis());
		String time=sdf.format(times);
		oas.setTime(time);
		int item = oa.insertItem(oas);
		System.out.println(item);*/
		
		/*List<OaRlzybEmployee> list = oa.selectAll();
		for (OaRlzybEmployee oaRlzybEmployee : list) {
			System.out.println(oaRlzybEmployee.getEmp_sex());
		}*/
		
		/*List<OaRlzybEmployee> contract = oa.selectAllContract(null, null, null, null,"已到期" , 1, 10);
		for (OaRlzybEmployee oaRlzybEmployee : contract) {
			System.out.println(oaRlzybEmployee.getEmp_name());
			
		}*/
		/*OaRlzybContract aa = new OaRlzybContract();
		aa.setContract_num(0);
		aa.setContract_id(741852);
		aa.setEmp_id(20);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date end;
		try {
			end = sdf.parse("2018-01-12");
			aa.setContract_startDate(end);
			Date ends = sdf.parse("2018-03-18");
			aa.setContract_endDate(ends);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		aa.setContract_status("已签订");
		aa.setContract_belong_company("山西多元合创有限公司");
		aa.setEmp_department(1);
		aa.setCreate_time(new Date());
		Boolean ss = qq.insertSelective(aa);
		if(ss==true){
			System.out.println("成功");
		}else{
			System.out.println("失败");
		}*/
		
		List<OaRlzybContract> selectAll = qq.selectAll();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		for (OaRlzybContract oaRlzybContract : selectAll) {
			Date endDate = oaRlzybContract.getContract_endDate();
			System.out.println(sdf.format(endDate));
			System.out.println(oaRlzybContract.getContract_status());
		}
}
}

// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   OaRlzybEmployeeServiceImpl.java

package cn.tyyhoa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tyyhoa.dao.OaRlzybEmployeeMapper;
import cn.tyyhoa.pojo.OaRlzybEmployee;
import cn.tyyhoa.service.OaRlzybEmployeeService;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tyyhoa.dao.OaRlzybDepartmentMapper;
import cn.tyyhoa.dao.OaRlzybEmployeeMapper;
import cn.tyyhoa.dao.OaRlzybGradeMapper;
import cn.tyyhoa.dao.OaRlzybHatAreaMapper;
import cn.tyyhoa.dao.OaRlzybHatCityMapper;
import cn.tyyhoa.dao.OaRlzybHatProvinceMapper;
import cn.tyyhoa.dao.OaRlzybNativeMapper;
import cn.tyyhoa.dao.OaRlzybNoticeMapper;
import cn.tyyhoa.dao.OaRlzybNotifiedPartyMapper;
import cn.tyyhoa.dao.OaRlzybPositionMapper;
import cn.tyyhoa.dao.OaRlzybTechnicalTitleMapper;
import cn.tyyhoa.dao.OaRlzybUserMapper;
import cn.tyyhoa.pojo.OaRlzybContract;
import cn.tyyhoa.pojo.OaRlzybDepartment;
import cn.tyyhoa.pojo.OaRlzybEmployee;
import cn.tyyhoa.pojo.OaRlzybGrade;
import cn.tyyhoa.pojo.OaRlzybHatArea;
import cn.tyyhoa.pojo.OaRlzybHatCity;
import cn.tyyhoa.pojo.OaRlzybHatProvince;
import cn.tyyhoa.pojo.OaRlzybNative;
import cn.tyyhoa.pojo.OaRlzybNotice;
import cn.tyyhoa.pojo.OaRlzybNotifiedParty;
import cn.tyyhoa.pojo.OaRlzybPosition;
import cn.tyyhoa.pojo.OaRlzybTechnicalTitle;
import cn.tyyhoa.pojo.OaRlzybUser;
import cn.tyyhoa.service.OaRlzybEmployeeService;

@Service("oaRlzybEmployeeService")
public class OaRlzybEmployeeServiceImpl
	implements OaRlzybEmployeeService
{
	@Autowired
	private OaRlzybEmployeeMapper oaRlzybEmployeeMapper;
	@Autowired
	private OaRlzybNativeMapper oaRlzybNativeMapper;
	@Autowired
	private OaRlzybHatProvinceMapper oaRlzybHatProvinceMapper;
	@Autowired
	private OaRlzybHatCityMapper oaRlzybHatCityMapper;
	@Autowired
	private OaRlzybHatAreaMapper oaRlzybHatAreaMapper;
	@Autowired
	private OaRlzybDepartmentMapper oaRlzybDepartmentMapper;
	@Autowired
	private OaRlzybPositionMapper oaRlzybPositionMapper;
	@Autowired
	private OaRlzybGradeMapper oaRlzybGradeMapper;
	@Autowired
	private OaRlzybTechnicalTitleMapper oaRlzybTechnicalTitleMapper;
	@Autowired
	private OaRlzybUserMapper oaRlzybUserMapper;
	@Autowired
	private OaRlzybNoticeMapper oaRlzybNoticeMapper;
	@Autowired
	private OaRlzybNotifiedPartyMapper oaRlzybNotifiedPartyMapper;

	public OaRlzybEmployeeServiceImpl()
	{
	}

	public OaRlzybEmployee selectByPrimaryKey(Integer emp_id)
	{
		return oaRlzybEmployeeMapper.selectByPrimaryKey(emp_id);
	}
	
	
	
	

	@Override
	public List<OaRlzybEmployee> selectByDepart(Integer depart_id) {
		
		return oaRlzybEmployeeMapper.selectByDepart(depart_id);
	}

	@Override
	public List<OaRlzybEmployee> selectByEmpId(Integer emp_id) {
		
		return oaRlzybEmployeeMapper.selectByEmpId(emp_id);
	}


	@Override
	public OaRlzybEmployee showInfo(Integer emp_id) {
		
		return oaRlzybEmployeeMapper.showInfo(emp_id);
	}

	@Override
	public List<OaRlzybEmployee> selectAllContract(String emp_name,
			Integer contract_id, String contract_startDate,
			String contract_endDate, String contract_status,Integer startPos,Integer PageSize) {
		
		return oaRlzybEmployeeMapper.selectAllContract(emp_name, contract_id, contract_startDate, contract_endDate, contract_status, startPos,PageSize);
	}

	@Override
	public Boolean updateByContractEndDate(OaRlzybEmployee record) {
		int result = oaRlzybEmployeeMapper.updateByContractEndDate(record);
		if(result >= 1){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public int selectCount(String emp_name,Integer contract_id,String contract_startDate,String contract_endDate,String contract_status) {
		
		return oaRlzybEmployeeMapper.selectCount(emp_name, contract_id, contract_startDate, contract_endDate, contract_status);
	}

	@Override
	public boolean updateByEmpId(OaRlzybEmployee record){
		int result = oaRlzybEmployeeMapper.updateByEmpId(record);
		if(result >= 1){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<OaRlzybEmployee> selectAll(String emp_name) {
		// TODO Auto-generated method stub
		return oaRlzybEmployeeMapper.selectAll(emp_name);
	}

	@Override
	public List<OaRlzybEmployee> selectEmpNameByDepartId(
			 Integer emp_department) {
		// TODO Auto-generated method stub
		return oaRlzybEmployeeMapper.selectEmpNameByDepartId(emp_department);
	}

	@Override
	public OaRlzybEmployee selectPositionByEmpName(
			Integer emp_id) {
		// TODO Auto-generated method stub
		return oaRlzybEmployeeMapper.selectPositionByEmpName(emp_id);
	}

	/*@Override
	public List<OaRlzybEmployee> selectByDepart2(Integer depart_id) {
		// TODO Auto-generated method stub
		return oaRlzybEmployeeMapper.selectByDepart2(depart_id);
	}*/

	@Override
	public boolean updateStatus(OaRlzybEmployee record) {
		int result = oaRlzybEmployeeMapper.updateStatus(record);
		if(result >= 1){
			return true;
		}else{
			return false;
		}
	}
	
	
	
	
	
	

	@Override
	public List<OaRlzybNative> getAllNations(){
		return oaRlzybNativeMapper.selectAllOaRlzybNative();
	}

	@Override
	public List<OaRlzybHatProvince> getAllProvinces(){
	return oaRlzybHatProvinceMapper.selectAllOaRlzybHatProvince();
	}

	@Override
	public List<OaRlzybHatCity> getAllCitys(String ProvinceId){
		return oaRlzybHatCityMapper.selectSomeOaRlzybHatCityByfather(ProvinceId);
	}

	@Override
	public List<OaRlzybHatArea> getAllAreas(String CityId){
		return oaRlzybHatAreaMapper.getSomeOaRlzybHatAreaByFather(CityId);
	}

	@Override
	public List<OaRlzybDepartment> getAllDepartments() {
		return oaRlzybDepartmentMapper.selectAllOaRlzybDepartment();
	}

	@Override
	public List<OaRlzybPosition> getAllPositions(Integer DepartmentId) {
		return oaRlzybPositionMapper.selectSomeOaRlzybPositionByDepartment(DepartmentId);
	}

	@Override
	public List<OaRlzybGrade> getAllGrades() {
		return oaRlzybGradeMapper.selectAllOaRlzybGrade();
	}

	@Override
	public List<OaRlzybEmployee> getHumanAffairsOaRlzybEmployees() {
		return oaRlzybEmployeeMapper.selectHumanAffairsOaRlzybEmployee();
	}

	@Override
	public int addEmpTechnicalTitlePath(
			OaRlzybTechnicalTitle oaRlzybTechnicalTitle) {
		return oaRlzybTechnicalTitleMapper.insertSelective(oaRlzybTechnicalTitle);
	}

	@Override
	public int addEmployee(OaRlzybEmployee oaRlzybEmployee) {
		return oaRlzybEmployeeMapper.insertSelective(oaRlzybEmployee);
	}

	@Override
	public int modifyEmployee(OaRlzybEmployee oaRlzybEmployee) {
		return oaRlzybEmployeeMapper.updateByPrimaryKeySelective(oaRlzybEmployee);
	}

	@Override
	public Integer getMaxEmpId() {
		return oaRlzybEmployeeMapper.selectMaxEmpId();
	}

	@Override
	public int modifyEmployeeByEmpIdCard(OaRlzybEmployee oaRlzybEmployee) {
		return oaRlzybEmployeeMapper.updateByEmpIdCardSelective(oaRlzybEmployee);
	}

	@Override
	public int getEmpIdByEmpIdCard(OaRlzybEmployee oaRlzybEmployee) {
		return oaRlzybEmployeeMapper.selectEmpIdByByEmpIdCard(oaRlzybEmployee);
	}

	@Override
	public int addUser(OaRlzybUser OaRlzybUser) {
		return oaRlzybUserMapper.insertSelective(OaRlzybUser);
	}

	@Override
	public int getEmployeeCountByCondition(Map<String, Object> condition) {
		return oaRlzybEmployeeMapper.selectOaRlzybEmployeeCountByCondition(condition);
	}

	@Override
	public List<OaRlzybEmployee> getOaRlzybEmployeeByPage(
			Map<String, Object> condition) {
		return oaRlzybEmployeeMapper.selectOaRlzybEmployeeByPage(condition);
	}

	@Override
	public OaRlzybEmployee getOaRlzybEmployeeById(int emp_id) {
		return oaRlzybEmployeeMapper.selectByPrimaryKey(emp_id);
	}

	@Override
	public int getOaRlzybUserCountByOaRlzybUser(OaRlzybUser oaRlzybUser) {
		return oaRlzybUserMapper.selectOaRlzybUserCountByOaRlzybUser(oaRlzybUser);
	}

	@Override
	public int getOaRlzybEmployeeCountByEmpIdCard(String empIdCard) {
		return oaRlzybEmployeeMapper.selectOaRlzybEmployeeCountByEmpIdCard(empIdCard);
	}

	@Override
	public List<OaRlzybTechnicalTitle> getOaRlzybTechnicalTitleByEmpId(
			int emp_id) {
		return oaRlzybTechnicalTitleMapper.selectOaRlzybTechnicalTitleByEmpId(emp_id);
	}

	@Override
	public int modifyOaRlzybEmployeePhotoPathByEmpId(
			OaRlzybEmployee oaRlzybEmployee) {
		return oaRlzybEmployeeMapper.updateOaRlzybEmployeePhotoPathByEmpId(oaRlzybEmployee);
	}

	@Override
	public int deleteOaRlzybEmployeeByEmpId(Integer emp_id) {
		return oaRlzybEmployeeMapper.deleteOaRlzybEmployeeByEmpId(emp_id);
	}

	@Override
	public int getOaRlzybEmployeeCountByPhoneNumber(String emp_phone) {
		return oaRlzybEmployeeMapper.selectOaRlzybEmployeeCountByPhoneNumber(emp_phone);
	}

	@Override
	public int getOaRlzybEmployeeCountByEmailAddress(String emp_Email) {
		return oaRlzybEmployeeMapper.selectOaRlzybEmployeeCountByEmailAddress(emp_Email);
	}

	@Override
	public int realDeleteInformationBugOaRlzybEmployee() {
		return oaRlzybEmployeeMapper.realDeleteInformationBugOaRlzybEmployee();
	}

	@Override
	public int modifyUserPositionIdByUserName(OaRlzybUser oaRlzybUser) {
		return oaRlzybUserMapper.updateUserPositionIdByUserName(oaRlzybUser);
	}
	
	
	
	
	
	
	
	
	
	
	
		
    @Override
	public List<OaRlzybUser> selectUserByUid(Integer user_id) {
		return oaRlzybUserMapper.selectUserByUid(user_id);
	}

	@Override
	public OaRlzybUser selectUserNameByUid(@Param("user_id") Integer user_id) {
		return oaRlzybUserMapper.selectUserNameByUid(user_id);
	}

	@Override
	public boolean addNotice(OaRlzybNotice record) {
		if(oaRlzybNoticeMapper.insertNotice(record)==1){
			return true;
		} ;
		 
		 return false;
	}

	@Override
	public boolean addNotified_party(OaRlzybNotifiedParty record) {
		 if(oaRlzybNotifiedPartyMapper.addNotified_party(record)==1){
			 return true;
		};
		return false;
	}

	@Override
	public List<OaRlzybNotice> selectYdNoticeByUid(Integer user_id) {
		return oaRlzybNoticeMapper.selectYdNoticeByUid(user_id);
	}

	@Override
	public List<OaRlzybNotice> selectWdNoticeByUid(Integer user_id) {
		return oaRlzybNoticeMapper.selectWdNoticeByUid(user_id);
	}

	@Override
	public List<OaRlzybNotice> selectnotice(Integer status, Integer user_id) {
		
		return oaRlzybNoticeMapper.selectnotice(status,user_id);
	}

	@Override
	public OaRlzybNotice selectXqNotice( Integer id,Integer user_id) {
		return oaRlzybNoticeMapper.selectXqNotice(id,user_id);
	}

	@Override
	public int updateNoticeById(Integer npid) {
		return oaRlzybNotifiedPartyMapper.updateNoticeById(npid);
	}

	@Override
	public int selectWdCountByUid(Integer user_id) {
		return oaRlzybNotifiedPartyMapper.selectWdCountByUid(user_id);
	}
	
	
	
	
	public List<OaRlzybEmployee> getEmpByDept(Integer deptid) {
		// TODO Auto-generated method stub
		return oaRlzybEmployeeMapper.getEmpByDept(deptid);
	}

/*	public List<OaRlzybEmployee> selectAllquanzhi(String emp_Employment_nature,int index,int pageSize) {
		// TODO Auto-generated method stub
		return oaRlzybEmployeeMapper.selectAllquanzhi(emp_Employment_nature,index,pageSize);
	}*/

	/*@Override
	public List<OaRlzybEmployee> selectAllzaizhi(String can,int index,int pageSize) {
		// TODO Auto-generated method stub
		return oaRlzybEmployeeMapper.selectAllzaizhi(can,index,pageSize);
	}*/

	@Override
	public int selectCountquanzhi() {
		// TODO Auto-generated method stub
		return oaRlzybEmployeeMapper.selectCountquanzhi();
	}

	@Override
	public int selectCountzaizhi(String emp_now_status) {
		// TODO Auto-generated method stub
		return oaRlzybEmployeeMapper.selectCountzaizhi(emp_now_status);
	}


	@Override
	public int selectCountligang() {
		// TODO Auto-generated method stub
		return oaRlzybEmployeeMapper.selectCountligang();
	}

	@Override
	public int selectCountlizhi(int dimission_status) {
		// TODO Auto-generated method stub
		return oaRlzybEmployeeMapper.selectCountlizhi(dimission_status);
	}

	@Override
	public int selectCountjianzhi() {
		return oaRlzybEmployeeMapper.selectCountjianzhi();
	}

	@Override
	public int selectCounttingxin() {
		
		return oaRlzybEmployeeMapper.selectCounttingxin();
	}

	@Override
	public int deleteByPrimaryKey(Integer emp_id) {
		
		return oaRlzybEmployeeMapper.deleteByPrimaryKey(emp_id);
	}



	@Override
	public int selectCountzzhi() {
	
		return oaRlzybEmployeeMapper.selectCountzzhi();
	}

	@Override
	public List<OaRlzybHatProvince> ListProvince() {
		return oaRlzybEmployeeMapper.ListProvince();
	}

	@Override
	public List<OaRlzybHatCity> ListCity(String provinceID) {
		return oaRlzybEmployeeMapper.ListCity(provinceID);
	}

	@Override
	public List<OaRlzybHatArea> ListArea(String cityID) {
		return oaRlzybEmployeeMapper.ListArea(cityID);
	}

	@Override
	public int insertSelective(OaRlzybEmployee record) {
		return oaRlzybEmployeeMapper.insertSelective(record);
	}

	@Override
	public int updatejinji(OaRlzybEmployee record) {
		return oaRlzybEmployeeMapper.updatejinji(record);
	}

	@Override
	public int updatejingli(OaRlzybEmployee record) {
		return oaRlzybEmployeeMapper.updatejingli(record);
	}

	@Override
	public int updateperson(OaRlzybEmployee record) {
		
		return oaRlzybEmployeeMapper.updateperson(record);
	}




	@Override
	public List<OaRlzybEmployee> selectAllqzj(String emp_Employment_nature,String emp_now_status, int index, int pageSize, String emp_name,
			String emp_name_simple, int emp_department, String emp_educational_background, String emp_birthday,
			String emp_phone) {
		// TODO Auto-generated method stub
		return oaRlzybEmployeeMapper.selectAllqzj(emp_Employment_nature,emp_now_status,index, pageSize, emp_name, emp_name_simple, emp_department, emp_educational_background, emp_birthday, emp_phone);
	}

	@Override
	public int selectCounts(String emp_Employment_nature, String emp_now_status, String emp_name, String emp_name_simple,
			int emp_department, String emp_educational_background, String emp_birthday, String emp_phone) {
		// TODO Auto-generated method stub
		return oaRlzybEmployeeMapper.selectCounts(emp_Employment_nature, emp_now_status, emp_name, emp_name_simple, emp_department, emp_educational_background, emp_birthday, emp_phone);
	}

	public int updateziduan(String emp_idcard_front, String emp_idcard_reverse, String emp_Degree_certificate,
			String emp_Education_certificate, String emp_technical_title_path, int emp_id) {
		// TODO Auto-generated method stub
		return oaRlzybEmployeeMapper.updateziduan(emp_idcard_front, emp_idcard_reverse, emp_Degree_certificate, emp_Education_certificate, emp_technical_title_path, emp_id);
	}

	@Override
	public List<OaRlzybEmployee> selectShiyongqi(Integer index, Integer PageSize, String emp_name,
			int emp_department) {
		// TODO Auto-generated method stub
		return oaRlzybEmployeeMapper.selectShiyongqi(index, PageSize, emp_name, emp_department);
	}

	@Override
	public int updatasyq(Integer emp_id, String emp_tryout_end_date) {
		// TODO Auto-generated method stub
		return oaRlzybEmployeeMapper.updatasyq(emp_id, emp_tryout_end_date);
	}




	
	
}

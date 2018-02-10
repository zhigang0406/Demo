// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   OaRlzybEmployeeService.java

package cn.tyyhoa.service;

import cn.tyyhoa.pojo.OaRlzybEmployee;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

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

public interface OaRlzybEmployeeService
{

	public abstract OaRlzybEmployee selectByPrimaryKey(Integer integer);
	//根据部门id得到所属部门的员工
	List<OaRlzybEmployee> selectByDepart(Integer depart_id);
	/*List<OaRlzybEmployee> selectByDepart2(Integer depart_id);*/
	//
	List<OaRlzybEmployee> selectByEmpId(Integer emp_id);
	
	List<OaRlzybEmployee> selectAllContract(String emp_name,Integer contract_id,String contract_startDate,String contract_endDate,String contract_status,Integer startPos,Integer PageSize);
	//根据员工的id得到员工的对象
	OaRlzybEmployee showInfo(Integer emp_id);
	
	Boolean updateByContractEndDate(OaRlzybEmployee record);
	
	int selectCount(String emp_name,Integer contract_id,String contract_startDate,String contract_endDate,String contract_status);
	
	boolean updateByEmpId(OaRlzybEmployee record);
    /**
     * 根据员工 的姓名得到集合
     * @param emp_name
     * @return
     */
    List<OaRlzybEmployee> selectAll(String emp_name);
    
    boolean updateStatus(OaRlzybEmployee record);
    
    
    List<OaRlzybEmployee> selectEmpNameByDepartId(Integer emp_department);
    /**
     * 根据部门的id得到对象
     * @param emp_id
     * @return
     */
    OaRlzybEmployee selectPositionByEmpName(Integer emp_id);
    
    
    
    
    
    
    
    
    public List<OaRlzybNative> getAllNations();
    public List<OaRlzybHatProvince> getAllProvinces();
    public List<OaRlzybHatCity> getAllCitys(String ProvinceId);
    public List<OaRlzybHatArea> getAllAreas(String CityId);
    /**
     * 得到所有的部门
     * @return
     */
    public List<OaRlzybDepartment> getAllDepartments();
    public List<OaRlzybPosition> getAllPositions(Integer DepartmentId);
    public List<OaRlzybGrade> getAllGrades();
    
    
    
    public List<OaRlzybEmployee> getHumanAffairsOaRlzybEmployees();//获得人力资源部人事的雇员名单
    
    
    
    public int addEmpTechnicalTitlePath(OaRlzybTechnicalTitle oaRlzybTechnicalTitle);
    public int addEmployee(OaRlzybEmployee oaRlzybEmployee);
    public int modifyEmployee(OaRlzybEmployee oaRlzybEmployee);
    public Integer getMaxEmpId();
    public int modifyEmployeeByEmpIdCard(OaRlzybEmployee oaRlzybEmployee);
    public int getEmpIdByEmpIdCard(OaRlzybEmployee oaRlzybEmployee);
    public int addUser(OaRlzybUser OaRlzybUser);
    public int getEmployeeCountByCondition(Map<String,Object> condition);
    public List<OaRlzybEmployee> getOaRlzybEmployeeByPage(Map<String,Object> condition);
    public OaRlzybEmployee getOaRlzybEmployeeById(int emp_id);
    public int getOaRlzybUserCountByOaRlzybUser(OaRlzybUser oaRlzybUser);
    public int getOaRlzybEmployeeCountByEmpIdCard(String empIdCard );
    public List<OaRlzybTechnicalTitle>  getOaRlzybTechnicalTitleByEmpId(int emp_id);
    public int modifyOaRlzybEmployeePhotoPathByEmpId(OaRlzybEmployee oaRlzybEmployee);
    public int deleteOaRlzybEmployeeByEmpId(Integer emp_id);
    public     int getOaRlzybEmployeeCountByPhoneNumber(String emp_phone);
    public     int getOaRlzybEmployeeCountByEmailAddress(String emp_Email);
    public int realDeleteInformationBugOaRlzybEmployee();
    public int modifyUserPositionIdByUserName(OaRlzybUser oaRlzybUser);
    
    
    
    
    
    int deleteByPrimaryKey(Integer emp_id);
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   

    /*查询除自己外其他用户名*/
    public List<OaRlzybUser> selectUserByUid(Integer user_id);
    /*查询自己用户名*/
    public OaRlzybUser selectUserNameByUid(@Param("user_id") Integer user_id);


    /*插入通知信息*/
    public boolean addNotice(OaRlzybNotice record);
    /*收件人添加通知信息*/
    public boolean  addNotified_party(OaRlzybNotifiedParty record);

    /* 根据用户id查询已读通知信息 */
    public List<OaRlzybNotice> selectYdNoticeByUid( Integer user_id);

    /* 根据用户id查询未读通知信息 */
    public List<OaRlzybNotice> selectWdNoticeByUid( Integer user_id);
    /* 根据用户id查询通知信息 */
    public List<OaRlzybNotice> selectnotice(Integer status, Integer user_id);

    /*根据通知id查询通知详情*/
    public OaRlzybNotice selectXqNotice( Integer id,Integer user_id);

    /*根据通知id修改通知状态*/
    public int updateNoticeById(Integer npid);

    /*根据用户id查询未读通知记录数*/
    public int selectWdCountByUid(Integer user_id);
    
    
    
    
    
    
    
    public abstract List<OaRlzybEmployee> getEmpByDept(Integer deptid);
    
    
    
    /**
     * 查询异步分页所需的全职  ,兼职信息,搜索
     */
    List<OaRlzybEmployee> selectAllqzj(String emp_Employment_nature,String emp_now_statusint,int index,int pageSize,String emp_name,String emp_name_simple,int emp_department,String emp_educational_background,String emp_birthday,String emp_phone);
    /**
     * 总记录数
     * @param emp_Employment_nature
     * @param emp_now_status
     * @param emp_name
     * @param emp_name_simple
     * @param emp_department
     * @param emp_educational_background
     * @param emp_birthday
     * @param emp_phone
     * @return
     */
    int selectCounts(@Param("emp_Employment_nature")String emp_Employment_nature,@Param("emp_now_status")String emp_now_status,@Param("emp_name")String emp_name,@Param("emp_name_simple")String emp_name_simple,@Param("emp_department")int emp_department,@Param("emp_educational_background")String emp_educational_background,@Param("emp_birthday")String emp_birthday,@Param("emp_phone")String emp_phone);

    /**
     * 查询全职的人数
     * @param emp_Employment_nature
     * @return
     */
    
    int selectCountquanzhi();
    /**
     * 查询在职的人数
     * @param emp_Employment_nature
     * @return
     */
    int selectCountzzhi();
    /**
     * 查询兼职的人数
     * @return
     */
    int selectCountjianzhi();
    /**
     * 查询在职的人数
     */
    int selectCountzaizhi(String emp_now_status);
  
    /**
     * 离岗的人数
     * @return
     */
    int selectCountligang();
    /**
     * 待离职         离职的人数
     * @return
     */
    int selectCountlizhi(int dimission_status);
    /**
     * 停薪留职的人数
     * @return
     */
    int  selectCounttingxin();
    /**
     * 通过员工id得到对象
     */
    /**
     * 普通搜索  参数姓名 ， 部门 ， 状态
     * 
     */
    
    /**
     * 试用期
     * @param index
     * @param PageSize
     * @return
     */
    List<OaRlzybEmployee> selectShiyongqi(@Param("index") Integer index,@Param("PageSize") Integer PageSize,@Param("emp_name")String emp_name,@Param("emp_department")int emp_department);
    
    /**
     * 转正修改
     * @param emp_id
     * @param emp_tryout_end_date
     * @return
     */
    int updatasyq(@Param("emp_id")Integer emp_id,@Param("emp_tryout_end_date") String emp_tryout_end_date);
    //三级联动、、、、、、、、
    //查询省级的集合
    List<OaRlzybHatProvince> ListProvince();
    //查询市级的集合
    List<OaRlzybHatCity> ListCity(@Param("provinceID")String provinceID);
    //查询县级的集合
    List<OaRlzybHatArea> ListArea(@Param("cityID")String cityID);
    //增加员工
    int insertSelective(OaRlzybEmployee record);
    //编制紧急联系人
    int updatejinji(OaRlzybEmployee record);
  //编辑社会经历
    int updatejingli(OaRlzybEmployee record);
  //修改个人信息
    int updateperson(OaRlzybEmployee record);
    
    //添加证件信息
    int updateziduan(@Param("emp_idcard_front")String emp_idcard_front,@Param("emp_idcard_reverse")String emp_idcard_reverse,@Param("emp_Degree_certificate")String emp_Degree_certificate,@Param("emp_Education_certificate")String emp_Education_certificate,@Param("emp_technical_title_path")String emp_technical_title_path,@Param("emp_id")int emp_id);
}

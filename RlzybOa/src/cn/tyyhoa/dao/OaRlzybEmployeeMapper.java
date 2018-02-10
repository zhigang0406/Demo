package cn.tyyhoa.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.junit.runners.Parameterized.Parameters;

import cn.tyyhoa.pojo.OaRlzybEmployee;
import cn.tyyhoa.pojo.OaRlzybHatArea;
import cn.tyyhoa.pojo.OaRlzybHatCity;
import cn.tyyhoa.pojo.OaRlzybHatProvince;
import cn.tyyhoa.pojo.OaRlzybPosition;

public interface OaRlzybEmployeeMapper {
	/**
	 * 根据员工的id来删除员工
	 * @param emp_id
	 * @return
	 */
    int deleteByPrimaryKey(Integer emp_id);
    
    int insert(OaRlzybEmployee record);

    int insertSelective(OaRlzybEmployee record);

    OaRlzybEmployee selectByPrimaryKey(Integer emp_id);

    
    int updateByPrimaryKeySelective(OaRlzybEmployee record);
    /**
     * 根据对象修改相应的信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(OaRlzybEmployee record);
    
    String selectByID(Integer emp_id);

    public Integer selectById(@Param("emp_name")String name);

/*人力资源部*/
 List<OaRlzybEmployee> selectHumanAffairsOaRlzybEmployee();//查询人力资源部的人事专员
    
    Integer selectMaxEmpId();   
    
 Integer updateByEmpIdCardSelective(OaRlzybEmployee record);
    
    int selectEmpIdByByEmpIdCard(OaRlzybEmployee record);
    
    int selectOaRlzybEmployeeCountByCondition(Map<String,Object> condition);
    
    List<OaRlzybEmployee> selectOaRlzybEmployeeByPage(Map<String,Object> condition);
    
    int selectOaRlzybEmployeeCountByEmpIdCard(@Param("emp_idcard") String empIdCard);
    
    List<OaRlzybEmployee> selectSomeOaRlzybEmployeeByfather(@Param("DepartId") Integer DepartId);
    
    int updateOaRlzybEmployeePhotoPathByEmpId(OaRlzybEmployee record);
    
    int deleteOaRlzybEmployeeByEmpId(@Param("emp_id") Integer emp_id);
    
    int selectOaRlzybEmployeeCountByPhoneNumber(@Param("emp_phone") String emp_phone);
    
    int selectOaRlzybEmployeeCountByEmailAddress(@Param("emp_Email") String emp_Email); 
    
    int realDeleteInformationBugOaRlzybEmployee();
    
    int updateOaRlzybEmployeeEmpNowStatusByEmpId(@Param("emp_id") Integer emp_id,@Param("emp_now_status") String emp_now_status);
    
    
   /* zl*/
    List<OaRlzybEmployee> selectByDepart(@Param("emp_department")Integer depart_id);
   /* List<OaRlzybEmployee> selectByDepart2(@Param("emp_department")Integer depart_id);*/
    
    List<OaRlzybEmployee> selectByEmpId(@Param("emp_id")Integer emp_id);
    
    
    //查询合同
    List<OaRlzybEmployee> selectAllContract(@Param("emp_name")String emp_name,@Param("contract_id")Integer contract_id,@Param("contract_startDate")String contract_startDate,@Param("contract_endDate")String contract_endDate,@Param("contract_status")String contract_status,@Param("startPos")Integer startPos,@Param("PageSize")Integer PageSize);
    
    OaRlzybEmployee showInfo(@Param("emp_id")Integer emp_id);
    
    int updateByContractEndDate(OaRlzybEmployee record);
    
   int selectCount(@Param("emp_name")String emp_name,@Param("contract_id")Integer contract_id,@Param("contract_startDate")String contract_startDate,@Param("contract_endDate")String contract_endDate,@Param("contract_status")String contract_status);
  
   int updateByEmpId(OaRlzybEmployee record);
   
   List<OaRlzybEmployee> selectAll(@Param("emp_name")String emp_name);
   int updateStatus(OaRlzybEmployee record);
   
   
   
   
   
   List<OaRlzybEmployee> selectEmpNameByDepartId(@Param("emp_department")Integer emp_department);
   
   OaRlzybEmployee selectPositionByEmpName(@Param("emp_id")Integer emp_id);
   /* zl*/
   List<OaRlzybEmployee>  getEmpByDept(@Param("deptid") Integer deptid);
    /*人力资源部*/
   
   /**
    * 查询异步分页所需的全职  ,兼职信息
    */
   List<OaRlzybEmployee> selectAllqzj(@Param("emp_Employment_nature")String emp_Employment_nature,@Param("emp_now_status")String emp_now_status,@Param("index")int index,@Param("pageSize")int pageSize,@Param("emp_name")String emp_name,@Param("emp_name_simple")String emp_name_simple,@Param("emp_department")int emp_department,@Param("emp_educational_background")String emp_educational_background,@Param("emp_birthday")String emp_birthday,@Param("emp_phone")String emp_phone);
   /**
    * 动态总记录数
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
    * 试用期
    * @param index
    * @param PageSize
    * @return
    */
   List<OaRlzybEmployee> selectShiyongqi(@Param("index") Integer index,@Param("PageSize") Integer PageSize,@Param("emp_name")String emp_name,@Param("emp_department")int emp_department);
   
   /**
    * 转正
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
   //编制紧急联系人
   int updatejinji(OaRlzybEmployee record);
   //编辑社会经历
   int updatejingli(OaRlzybEmployee record);
	//修改个人信息
   int updateperson(OaRlzybEmployee record);

   //添加证件信息
   int updateziduan(@Param("emp_idcard_front")String emp_idcard_front,@Param("emp_idcard_reverse")String emp_idcard_reverse,@Param("emp_Degree_certificate")String emp_Degree_certificate,@Param("emp_Education_certificate")String emp_Education_certificate,@Param("emp_technical_title_path")String emp_technical_title_path,@Param("emp_id")int emp_id);

}
package cn.tyyhoa.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tyyhoa.pojo.OaRlzybContract;

public interface OaRlzybContractMapper {
    int deleteByPrimaryKey(Integer contract_num);

    int insert(OaRlzybContract record);

    int insertSelective(OaRlzybContract record);

    OaRlzybContract selectByPrimaryKey(Integer contract_num);

    int updateByContractEndDate(OaRlzybContract record);

    int updateByPrimaryKey(OaRlzybContract record);
    /**
     *  查询全部合同信息
     * @return
     */
    List<OaRlzybContract> selectAllContract();
    
    List<OaRlzybContract> selectAll();
    
    OaRlzybContract showInfo(@Param("emp_id")Integer emp_id);
    
    List<OaRlzybContract> selectContractId();
    
    int addContract(
    		@Param("contract_id")Integer contract_id,
    		@Param("emp_id")Integer emp_id,
    		@Param("contract_startDate")Date contract_startDate,
    		@Param("contract_endDate")Date contract_endDate,
    		@Param("contract_status")String contract_status,
    		@Param("contract_belong_company")String contract_belong_company,
    		@Param("contract_delectStatus")Integer contract_delectStatus,
    		@Param("create_time")Date create_time);
    }
package cn.tyyhoa.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tyyhoa.pojo.OaRlzybContract;

public interface OaRlzybContractService {
	
	List<OaRlzybContract> selectAllContract();
	
	List<OaRlzybContract> selectAll();
	
	OaRlzybContract showInfo(Integer emp_id);
	
	Boolean insertSelective(OaRlzybContract record);
	
	Boolean updateByContractEndDate(OaRlzybContract record);
	
	List<OaRlzybContract> selectContractId();
	
	 int addContract(
	    		Integer contract_id,
	    		Integer emp_id,
	    		Date contract_startDate,
	    		Date contract_endDate,
	    		String contract_status,
	    		String contract_belong_company,
	    		Integer contract_delectStatus,
	    		Date create_time);

}

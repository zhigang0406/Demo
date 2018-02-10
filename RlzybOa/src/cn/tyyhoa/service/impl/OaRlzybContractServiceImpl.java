package cn.tyyhoa.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tyyhoa.dao.OaRlzybContractMapper;
import cn.tyyhoa.pojo.OaRlzybContract;
import cn.tyyhoa.service.OaRlzybContractService;

@Service("oaRlzybContractService")
public class OaRlzybContractServiceImpl implements OaRlzybContractService {
	
	@Autowired
	OaRlzybContractMapper oaRlzybContractMapper;

	@Override
	public List<OaRlzybContract> selectAllContract() {
		
		return oaRlzybContractMapper.selectAllContract();
	}

	@Override
	public OaRlzybContract showInfo(Integer emp_id) {
		
		return oaRlzybContractMapper.showInfo(emp_id);
	}

	@Override
	public Boolean insertSelective(OaRlzybContract record) {
		int result = oaRlzybContractMapper.insertSelective(record);
		if(result == 0){
			return false; 
		}else{
			return true;
		}
	}

	@Override
	public Boolean updateByContractEndDate(OaRlzybContract record) {
		int result = oaRlzybContractMapper.updateByContractEndDate(record);
		if(result == 0){
			return false; 
		}else{
			return true;
		}
	}

	@Override
	public List<OaRlzybContract> selectContractId() {
		
		return oaRlzybContractMapper.selectContractId();
	}

	@Override
	public int addContract(Integer contract_id, Integer emp_id, Date contract_startDate, Date contract_endDate,
			String contract_status, String contract_belong_company, Integer contract_delectStatus, Date create_time) {
		
		return oaRlzybContractMapper.addContract(contract_id, emp_id, contract_startDate, contract_endDate, contract_status, contract_belong_company, contract_delectStatus, create_time);
	}

	@Override
	public List<OaRlzybContract> selectAll() {
		return oaRlzybContractMapper.selectAll();
	}

}

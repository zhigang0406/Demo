package cn.tyyhoa.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tyyhoa.pojo.OaRlzybDimission;
/**
 * 离职信息
 * @author lenove ch
 *
 */
public interface OaRlzybDimissionMapper {
    int deleteByPrimaryKey(Integer dimission_id);
    /**
     * 根据对象添加一条离职信息
     * @param record
     * @return
     */
    int insert(OaRlzybDimission record);
    
    int insertSelective(OaRlzybDimission record);

    OaRlzybDimission selectByPrimaryKey(Integer dimission_id);

    int updateByPrimaryKeySelective(OaRlzybDimission record);

    int updateByPrimaryKey(OaRlzybDimission record);
    
    
    List<OaRlzybDimission> selectAll(
    		@Param("dimission_status") Integer dimission_status,
    		@Param("emp_name") String emp_name,
    		@Param("dimission_date1") Date dimission_date1,
    		@Param("dimission_date2") Date dimission_date2,
    		@Param("startPos") Integer startPos,
    		@Param("PageSize") Integer PageSize);
    
    int selectCount(
    		@Param("dimission_status") Integer dimission_status,
    		@Param("emp_name") String emp_name,
    		@Param("dimission_date1") Date dimission_date1,
    		@Param("dimission_date2") Date dimission_date2);
    

    
    OaRlzybDimission selectShow(Integer dimission_id); 
    
    int updateDelete(@Param("dimission_id") Integer dimission_id);
    
    
    //把待离职修改为离职
    int updatedimissionStatus(int emp_id);
    
    //状态自动转化
    int updatedimissionStatu(@Param("dimission_id")Integer dimission_id,@Param("dimission_status")Integer dimission_status);
}

package cn.tyyhoa.controller;

import cn.tyyhoa.pojo.*;
import cn.tyyhoa.service.OaRlzybAccountLoginService;
import cn.tyyhoa.service.OaRlzybPositionService;
import cn.tyyhoa.service.OaRlzybUserService;
import cn.tyyhoa.service.impl.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

@Controller
@RequestMapping("/getData")
public class OarlzybGetData
{

	@Autowired
	private  OaRlzybPositionServiceImpl oaRlzybPositionServiceImpl;
	@Autowired
	private  OaRlzybSubfieldServiceImpl oaRlzybSubfieldServiceImpl;
	@Autowired
	private  OaRlzybFunctionServiceImpl oaRlzybFunctionServiceImpl;
	@Autowired
	private  OaRlzybPositionService oaRlzybPositionService;
	@Autowired
	private OaRlzybUserService oaRlzybUserService;
	
	/**
	 * 根据用户id获取功能组信息
	 * @param userid
	 * @param request
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/Subfields")
	public Object getSubfields(@RequestParam("userid") String userid, HttpServletRequest request, HttpSession session)
	{	
		int id = Integer.parseInt(userid);
		OaRlzybPosition position = oaRlzybPositionServiceImpl.selectByUserId(id);
		List<OaRlzybSubfield> subfields = oaRlzybSubfieldServiceImpl.selectByPositionId(position.getPosition_id());
		position.setSubfields(subfields);
		int i = 0;
		for (Iterator<OaRlzybSubfield> iterator = subfields.iterator(); iterator.hasNext();) {
			OaRlzybSubfield oaRlzybSubfield = iterator.next();
			List<OaRlzybFunction> oaRlzybFunctions = oaRlzybFunctionServiceImpl.selectBySubfieldId(oaRlzybSubfield.getSubfield_id());
			for (Iterator<OaRlzybFunction> iterator2 = oaRlzybFunctions.iterator(); iterator2
					.hasNext();) {
				OaRlzybFunction oaRlzybFunction = iterator2
						.next();
			}
			oaRlzybSubfield.setFunctions(oaRlzybFunctions);
			subfields.set(i, oaRlzybSubfield);
			i++;
		}
		List<OaRlzybFunction> userFunctions = oaRlzybFunctionServiceImpl.selectByUserId(Integer.valueOf(id));
		Object objsubs1 = JSONArray.toJSONString(subfields);
		Object objsubs2 = JSONArray.toJSONString(userFunctions);
		String str = "";
		str += "{\"subfields\":"+objsubs1+",\"userFunctions\":"+objsubs2+"}";
		Object objsubs = str;
		return objsubs;
	}
	/**
	 * 根据部门获取职位信息
	 * @param depart_id
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping("/position")
	@ResponseBody
	public Object getPosition(@RequestParam("depart_id") String depart_id, HttpServletRequest request, HttpSession session)
	{
		int departid = Integer.parseInt(depart_id);
		OaRlzybPosition position = new OaRlzybPosition();
		position.setDepart_id(departid);
		position.setJurisdiction_id(1);
		List<OaRlzybPosition> positions = oaRlzybPositionService.selectByDepartmentid(position);
		for (Iterator<OaRlzybPosition> iterator = positions.iterator(); iterator.hasNext();) {
			OaRlzybPosition oaRlzybPosition = iterator.next();
		}
		Object obj = JSONArray.toJSONString(positions);
		return obj;
	}
	/**
	 * 根据职位获取功能组信息
	 * @param position_id
	 * @param request
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/subfieldsByPosition")
	public Object getsubfields(@RequestParam("position_id") String position_id, HttpServletRequest request, HttpSession session)
	{
		int positionid = Integer.parseInt(position_id);
		List<OaRlzybSubfield> subfields = oaRlzybSubfieldServiceImpl.selectByPositionId(Integer.valueOf(positionid));
		Object obj = JSONArray.toJSONString(subfields);
		return obj;
	}
	/**
	 * 获取不属于职位的功能组信息
	 * @param position_id
	 * @param request
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/subfieldsByNotPosition")
	public Object subfieldsByNotPosition(@RequestParam("position_id") String position_id, HttpServletRequest request, HttpSession session)
	{
		int positionid = Integer.parseInt(position_id);
		List<OaRlzybSubfield> subfields = oaRlzybSubfieldServiceImpl.selectByNotPositionId(positionid);
		Object obj = JSONArray.toJSONString(subfields);
		return obj;
	}
	/**
	 * 获取职位功能组信息
	 * @param subfield_id
	 * @param request
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/functionBySubfield")
	public Object functionBySubfield(@RequestParam("subfield_id") String subfield_id, HttpServletRequest request, HttpSession session)
	{
		int subfieldid = Integer.parseInt(subfield_id);
		List<OaRlzybFunction> functions = oaRlzybFunctionServiceImpl.selectBySubfieldId(subfieldid);
		Object obj = JSONArray.toJSONString(functions);
		return obj;
	}
	/**
	 * 获取不属于功能组的功能信息
	 * @param subfield_id
	 * @param request
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/functionByNotSubfield")
	public Object functionByNotSubfield(@RequestParam("subfield_id") String subfield_id, HttpServletRequest request, HttpSession session)
	{
		int subfieldid = Integer.parseInt(subfield_id);
		List<OaRlzybFunction> functions = oaRlzybFunctionServiceImpl.selectByNotSubfieldId(subfieldid);
		Object obj = JSONArray.toJSONString(functions);
		return obj;
	}
	/**
	 * 验证用户名是否存在
	 * @param user_name
	 * @param request
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/checkUsername")
	public String checkUsername(@RequestParam("user_name") String user_name, HttpServletRequest request, HttpSession session){
		OaRlzybUser user = new OaRlzybUser();
		user.setUser_name(user_name);
		OaRlzybUser loginUser = oaRlzybUserService.login(user);
		if (loginUser == null) {
			return "red";
		}else{
			return "black";
		}
	}
	@ResponseBody
	@RequestMapping("/getlogincont")
	public String getlogincont(HttpServletRequest request, HttpSession session){
		OaRlzybUser loginUser = (OaRlzybUser) session.getAttribute("loginUser");
		OaRlzybUser user = oaRlzybUserService.login(loginUser);
		if (loginUser.getLogincont().intValue()==user.getLogincont().intValue()) {
			return "yes";
		}else{
			return "out";
		}
	}
}

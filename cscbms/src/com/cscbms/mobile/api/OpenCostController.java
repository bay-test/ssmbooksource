package com.cscbms.mobile.api;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cscbms.dao.CostDao;
import com.cscbms.entity.Cost;

import com.cscbms.entity.page.CostPage;
import com.cscbms.mobile.common.BaseController;
import com.cscbms.mobile.common.JsonResult;
import com.cscbms.vo.CostVo;



@Controller
@RequestMapping(value="/open")
public class OpenCostController extends BaseController{
	

	
	@Autowired 
	private CostDao costDao;
	
	
	@RequestMapping(value="/findByCost.do")
	@ResponseBody
	public JsonResult findByCost(){
		CostPage  Page=new CostPage();
		Page.setPageSize(1000);
		List<Cost>  Costs=costDao.findByPage(Page);
		return Costs.size()>0?renderSuccess(Costs):renderError("error");	
	}
	
	@RequestMapping(value="/addCost.do")
	@ResponseBody
	public JsonResult addCost(CostVo costVo,HttpSession session){
		Cost cost=new Cost();
		BeanUtils.copyProperties(costVo, cost);//對象拷貝
		costDao.save(cost);
		return renderSuccess("success");
	}
	
	
	/*更新数据*/
	@RequestMapping(value = "/updateCost.do")
	@ResponseBody
	public JsonResult updateCost( CostVo costVo,HttpSession session) {
		Cost cost=new Cost();
		BeanUtils.copyProperties(costVo, cost);//對象拷貝
		costDao.update(cost);
		return renderSuccess("success");
		
	}
	
	/*删除数据*/
	@RequestMapping(value = "/deleteCost.do")
	@ResponseBody
	public JsonResult deleteCost(int id) {
		costDao.delete(id);
		return renderSuccess("成功");
	
}
}

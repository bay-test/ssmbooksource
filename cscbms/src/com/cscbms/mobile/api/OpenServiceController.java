package com.cscbms.mobile.api;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cscbms.dao.ServiceDao;
import com.cscbms.entity.Service;
import com.cscbms.entity.page.ServicePage;
import com.cscbms.mobile.common.BaseController;
import com.cscbms.mobile.common.JsonResult;
import com.cscbms.vo.ServiceVo;

@Controller
@RequestMapping(value="/open")
public class OpenServiceController extends BaseController{

	@Autowired
	private ServiceDao serviceDao;
	
	
      /*	查询*/
	@RequestMapping(value="/findByService.do")
	@ResponseBody
	public JsonResult findByService(){
		ServicePage  page=new ServicePage();
		page.setPageSize(1000);
		List<Map<String, Object>> services=serviceDao.findByPage(page);
		return services.size()>0?renderSuccess(services):renderError("error");
		
		
	}
	
	/*保存数据*/
	@RequestMapping(value="/addService.do")
	@ResponseBody
	public JsonResult addService( ServiceVo serviceVo,HttpSession session){
		Service service=new Service();
		BeanUtils.copyProperties(serviceVo, service);
		serviceDao.save(service);
		return renderSuccess("success");
		
		
	}
	
	
	/*更新数据*/
	@RequestMapping(value="/updateService.do")
	@ResponseBody
	public JsonResult updateService( ServiceVo serviceVo,HttpSession session){
		Service service=new Service();
		BeanUtils.copyProperties(serviceVo, service);
		serviceDao.update(service);
		return renderSuccess("success");
		
		
	}
	
	
	/*删除数据*/
	@RequestMapping(value="/deleteService.do")
	@ResponseBody
	public JsonResult deleteService(int serviceId ,HttpSession session){
		Service service=new Service();
		service.setServiceId(serviceId);
		service.setStatus('2');
		serviceDao.updateStatus(service);
		return renderSuccess("success");
		
		
	}
	

}

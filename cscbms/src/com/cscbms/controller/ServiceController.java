package com.cscbms.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cscbms.dao.AccountDao;
import com.cscbms.dao.CostDao;
import com.cscbms.dao.ServiceDao;
import com.cscbms.entity.Account;
import com.cscbms.entity.Cost;
import com.cscbms.entity.Service;
import com.cscbms.entity.page.ServicePage;

@Controller
@RequestMapping("/service")
@SessionAttributes("servicePage")
public class ServiceController extends BaseController {
	
	@Resource
	private ServiceDao serviceDao;
	
	@Resource
	private AccountDao accountDao;
	
	@Resource
	private CostDao costDao;

	@RequestMapping("/findService.do")
	public String find(ServicePage page, Model model) {
		page.setRows(serviceDao.findRows(page));
		model.addAttribute("servicePagea", page);
		
		List<Map<String, Object>> list = 
				serviceDao.findByPage(page);
		model.addAttribute("services", list);
		
		return "service/serviceList";
	}
	
	@RequestMapping("/startService.do")
	@ResponseBody
	public Map<String, Object> updateStart(@RequestParam("serviceId") int id) {
		 Map<String, Object> info = 
				new HashMap<String,Object>();
		
		//判断对应的账务账号是否处于开通态
		Service service = serviceDao.findById(id);
		Account account = accountDao.findById(service.getAccountId());
		if(!(account.getStatus()=='0')) {
			info.put("success", false);
			info.put("message", "帐务账号没有开通，不允许开通当前业务账号!");
			return info;
		}
		
		Service s = new Service();
		s.setServiceId(id);
		s.setStatus('0');
		try {
			serviceDao.updateStatus(s);
			info.put("success", true);
			info.put("message", "开通成功!");
		} catch (Exception e) {
			e.printStackTrace();
			info.put("success", false);
			info.put("message", "开通失败，系统发生异常!");
		}
		
		return info;
	}
	
	@RequestMapping("/pauseService.do")
	@ResponseBody
	public Map<String, Object> updatePause(@RequestParam("serviceId") int id) {
		Map<String, Object> info = 
				new HashMap<String, Object>();
		
		Service s = new Service();
		s.setServiceId(id);
		s.setStatus('1');
		try {
			serviceDao.updateStatus(s);
			info.put("success", true);
			info.put("message", "暂停成功!");
		} catch (Exception e) {
			e.printStackTrace();
			info.put("success", false);
			info.put("message", "暂停失败，系统发生异常!");
		}
		
		return info;
	}
	
	@RequestMapping("/deleteService.do")
	@ResponseBody
	public Map<String, Object> updateDelete(@RequestParam("serviceId") int id) {
		Map<String, Object> info = 
				new HashMap<String, Object>();
		
		Service s = new Service();
		s.setServiceId(id);
		s.setStatus('2');
		try {
			serviceDao.updateStatus(s);
			info.put("success", true);
			info.put("message", "删除成功!");
		} catch (Exception e) {
			e.printStackTrace();
			info.put("success", false);
			info.put("message", "删除失败，系统发生异常!");
		}
		
		return info;
	}
	
	@RequestMapping("/toAddService.do")
	public String toAdd(Model model) {
		List<Cost> list = costDao.findAll();
		List<Account> accounts = accountDao.findAll();
		model.addAttribute("costs", list);
		model.addAttribute("accounts", accounts);
		return "service/addService";
	}
	
	@RequestMapping("/findAccount.do")
	@ResponseBody
	public Account findAccount(@RequestParam("idcardNo") String idcardNo) {
		return accountDao.findByIdcardNo(idcardNo);
	}
	
	@RequestMapping("/addService.do")
	public String add(Service service) {
		service.setStatus('0');
		service.setCreateDate(
		new Timestamp(System.currentTimeMillis()));
		serviceDao.save(service);
		return "redirect:findService.do";
	}
	
	@RequestMapping("/toUpdateService.do")
	public String toUpdate(@RequestParam("id") int id, Model model) {
		Service service = serviceDao.findById(id);
		model.addAttribute("service", service);
		List<Cost> list = costDao.findAll();
		model.addAttribute("costs", list);
		return "service/updateService";
	}
	
	@RequestMapping("/updateService.do")
	public String update(Service service) {
		serviceDao.update(service);
		serviceDao.insertUpdateBak(service);
		return "redirect:findService.do";
	}
	
}

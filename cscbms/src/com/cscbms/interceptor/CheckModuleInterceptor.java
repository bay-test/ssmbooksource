package com.cscbms.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.cscbms.entity.Module;

public class CheckModuleInterceptor implements HandlerInterceptor {
	
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {

	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object obj) throws Exception {
		List<Module> modules = (List<Module>) 
				request.getSession().getAttribute("allModules");
		int currentModule = (Integer) 
				request.getSession().getAttribute("currentModule");
		for (Module module : modules) {
			if (module.getModuleId() == currentModule) {
				return true;
			}
		}
		response.sendRedirect(
				request.getContextPath() + "/login/nopower.do");
		return false;
	}

}

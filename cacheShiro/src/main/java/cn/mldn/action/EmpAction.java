package cn.mldn.action;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresGuest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.mldn.service.IEmpService;
@Controller 
@RequestMapping("/pages/emp/*")
public class EmpAction {
	@Resource
	private IEmpService empService ;
	@RequestMapping("add")
	public ModelAndView add() {
		this.empService.add();
		return null ;
	}
	@RequestMapping("edit")
	public ModelAndView edit() {
		this.empService.edit();
		return null ;
	}
	@RequestMapping("remove")
	public ModelAndView remove() {
		this.empService.remove();
		return null ;
	} 
	@RequestMapping("list")
	public ModelAndView list() {
		this.empService.list(); 
		return null ;
	}
}

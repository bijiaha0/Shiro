package cn.mldn.action;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller 
@RequestMapping("/pages/emp/*")
public class EmpAction {
	private Logger log = Logger.getLogger(EmpAction.class) ;
	@RequiresAuthentication 
	@RequestMapping("add")
	public ModelAndView add() {
		log.info("************ 【EmpAction/add.action】 ************");
		return null ;
	}
	@RequestMapping("edit")
	@RequiresGuest 
	public ModelAndView edit() {
		log.info("************ 【EmpAction/edit.action】 ************");
		return null ;
	}
	@RequiresRoles("member")
	@RequestMapping("remove")
	public ModelAndView remove() {
		log.info("************ 【EmpAction/remove.action】 ************");
		return null ;
	} 
	@RequiresPermissions("emp:list") 
	@RequestMapping("list")
	public ModelAndView list() {
		log.info("************ 【EmpAction/list.action】 ************");
		return null ;
	}
}

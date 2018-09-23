package cn.mldn.action;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class MemberLoginAction {
	@RequestMapping("/shiroLogin")
	public ModelAndView login(String mid, String password) {
		ModelAndView mav = new ModelAndView();
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(mid, password);
		try {
			subject.login(token);
			mav.setViewName("welcome");
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("login");
		} 
		return mav;
	}
	@RequestMapping("/loginUrl")
	public ModelAndView loginUrl() {
		return new ModelAndView("login");
	}
	@RequestMapping("/unauthUrl")
	public ModelAndView unauthUrl() {
		return new ModelAndView("role");
	}
	@RequestMapping("/successUrl")
	public ModelAndView successUrl() {
		return new ModelAndView("welcome");
	}
}

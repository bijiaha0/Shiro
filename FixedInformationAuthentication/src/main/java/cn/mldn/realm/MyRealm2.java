package cn.mldn.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

public class MyRealm2 implements Realm {
	@Override
	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal() ;	// 取得用户名
		// 在Shiro里面是利用字符数组实现了密码的传递，所以不能将其直接变为String
		String password = new String((char[]) token.getCredentials()) ;	// 取得密码
		// 此时直接使用一个固定的用户名和密码进行验证处理操作
		if (!"mldn".equals(username)) {	// 判断用户名是否存在
			throw new UnknownAccountException("用户名不存在！") ;
		}
		if (!"java".equals(password)) {
			throw new IncorrectCredentialsException("密码输入错误！") ;
		}
		return new SimpleAuthenticationInfo(username,password,this.getName()) ;
	}
	
	@Override
	public String getName() {
		return "MyRealm";	// 名字随便给一个，只要能唯一标记即可
	}

	@Override
	public boolean supports(AuthenticationToken token) {
		// 本次将在之前程序的基础之上继续使用UsernamePasswordToken完成信息的传递
		return token instanceof UsernamePasswordToken ;
	}

}

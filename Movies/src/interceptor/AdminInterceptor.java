package interceptor;

import java.util.Map;

import model.Admin;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

//从session中获取用户登录的信息
//如果有该信息的话，访问main.jsp
//没有的话，转到登录页面，并提示用户登录后，在进行操作
public class AdminInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings( { "unchecked", "static-access" })
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		Map<String, Object> session = arg0.getInvocationContext().getSession();
		Admin ru = (Admin) session.get("admin");
		Map<String, Object> request = (Map<String, Object>) arg0.getInvocationContext().getContext().get("request");
		if (ru != null) {
			// 调用action,根据action中方法放回的结果找到对应的result标签
			return arg0.invoke();
		} else {
			Object o = arg0.getAction();
			ActionSupport s = (ActionSupport) o;
			request.put("msg", s.getText("msg.checkUserLogin"));
			return "fail";
		}
	}

}

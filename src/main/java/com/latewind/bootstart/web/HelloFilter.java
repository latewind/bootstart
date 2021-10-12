package com.latewind.bootstart.web;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter("/helloServlet")
public class HelloFilter extends HttpFilter {

	private Logger logger = LoggerFactory.getLogger(HelloFilter.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = -3161072512027786968L;

	/**
	 * 初始化，只在项目启动的时候执行一次
	 */
	@Override
	public void init(FilterConfig filterConfig) {
		logger.debug("===> TestFilter init");
	}

	/**
	 * 用于存放过滤器的业务逻辑实现代码
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		chain.doFilter(request, response);// 处理请求和响应的分界线
		logger.debug("===> chain.doFilter 后执行处理 response 的相关方法");
		// 在response header里设置一个token
		setToken(response);

	}

	private void setToken(ServletResponse response) {
		HttpServletResponse res = (HttpServletResponse) response;
		String token = UUID.randomUUID().toString();
		res.setHeader("Token", token);
		logger.debug("===> 设置了token：" + token);
	}

	/**
	 * 销毁，在项目关闭，Servlet 容器销毁前调用
	 */
	@Override
	public void destroy() {
		logger.debug("===> TestFilter destroy");
	}

}

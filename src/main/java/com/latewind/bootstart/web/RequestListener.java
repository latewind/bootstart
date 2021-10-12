package com.latewind.bootstart.web;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebListener
public class RequestListener implements ServletRequestListener, ServletRequestAttributeListener {
	private Logger logger = LoggerFactory.getLogger(RequestListener.class);
	/**
	 * 请求即将进入Web应用程序的范围/请求初始化时
	 */
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		logger.debug("===> request initialized");
	}

	/**
	 * 请求即将进入Web应用程序的范围/请求销毁时
	 */
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		logger.debug("===> request destroyed");
	}

	/**
	 * request属性新增
	 */
	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		logger.debug("===> request attribute added");
	}

	/**
	 * request属性移除
	 */
	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		logger.debug("===> request attribute removed");
	}

	/**
	 * request属性替换
	 */
	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		logger.debug("===> request attribute replaced");
	}
}
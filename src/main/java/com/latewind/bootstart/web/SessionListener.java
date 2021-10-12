package com.latewind.bootstart.web;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebListener
public class SessionListener implements HttpSessionListener, HttpSessionIdListener, HttpSessionAttributeListener,
		HttpSessionActivationListener {
	private Logger logger = LoggerFactory.getLogger(RequestListener.class);

	/**
	 * session被创建时
	 */
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		logger.debug("===> session created");
	}

	/**
	 * session被销毁时
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		logger.debug("===> session destroyed");
	}

	/**
	 * sessionId改变
	 */
	@Override
	public void sessionIdChanged(HttpSessionEvent se, String oldSessionId) {
		logger.debug("===> session id changed");
	}

	/**
	 * session属性新增
	 */
	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		logger.debug("===> session attribute added");
	}

	/**
	 * session属性移除
	 */
	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		logger.debug("===> session attribute removed");
	}

	/**
	 * session属性替换
	 */
	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		logger.debug("===> session attribute replaced");
	}

	/**
	 * session的钝化，内存的数据写入到硬盘上的过程。
	 */
	@Override
	public void sessionWillPassivate(HttpSessionEvent se) {
		logger.debug("===> session will passivate");
	}

	/**
	 * session的活化，将硬盘的数据恢复到内存中。
	 */
	@Override
	public void sessionDidActivate(HttpSessionEvent se) {
		logger.debug("===> session did activate");
	}

}
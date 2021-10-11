package com.latewind.bootstart.info.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.latewind.bootstart.info.bean.UserEntity;
import com.latewind.bootstart.info.dao.UserDao;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDao userDao;

	// 使用注解方式
	/**
	 * 获取所有用户
	 * 
	 * @return
	 */
	@RequestMapping("/getAll")
	public List<UserEntity> getAll() {
		return userDao.getAll();
	}

	/**
	 * 根据id获取用户
	 * 
	 * @return
	 */
	@RequestMapping("/getOne")
	public List<UserEntity> getOne(Long id) {
		return userDao.getOne(id);
	}

	/**
	 * 新增用户
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/insertUser2")
	public String insertUser2(UserEntity user) {
		userDao.insertUser(user);
		return "insert success";
	}

	/**
	 * 修改用户
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/updateUser2")
	public String updateUser2(UserEntity user) {
		userDao.updateUser(user);
		return "update success";
	}

	/**
	 * 删除用户
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/deleteUser2")
	public String deleteUser2(Long id) {
		userDao.deleteUser(id);
		return "delete success";
	}

	/**
	 * 查询所有用户
	 * 
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView getUserList() {
		LoggerFactory.getLogger(UserController.class).debug("Hello Log");
		List<UserEntity> userList = userDao.getAll();
		ModelAndView view = new ModelAndView();
		view.addObject("userList", userList);
		view.setViewName("index");
		return view;
	}

	/**
	 * 使用缓存查询查询全部
	 * @return
	 */
	@RequestMapping("/getAllUseCache")
	@Cacheable("userList")
	public List<UserEntity> getAllUseCache() {
		return userDao.getAll();
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/getOneUseCache")
	@Cacheable(cacheNames = { "user" }, key = "#id") // 如果缓存存在，直接读取缓存值；如果缓存不存在，则调用目标方法，并将结果放入缓存
	public List<UserEntity> getOneCache(Long id) {
		System.out.println("缓存不存在，执行方法");
		return userDao.getOne(id);
	}
	
}

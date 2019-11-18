package online.shixun.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import online.shixun.project.pojo.HeroPojo;
import online.shixun.project.pojo.UserPojo;
import online.shixun.project.service.HeroService;
import online.shixun.project.service.UserService;

@Controller
public class indexController {

	@Autowired
	UserService userService;
	
	@Autowired
	HeroService heroService;
	
	/**
	 * 进入登陆页面
	 * @return
	 */
	@RequestMapping("/")
	public String login() {
		return "login";
	}
	
	/**
	 * 验证登录，成功则进入主页面
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/index")
	public String index(UserPojo user, Model model) {
		List<UserPojo> list = (List<UserPojo>) userService.getUser(user);
		if(list.size()>0) {
		model.addAttribute("user", list);
		return "index";
		}else {
			return "redirect:/";
		}
	}
	
	/**
	 * 所有英雄
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "queryAllHero")
	public String index(Model model) {
		List<HeroPojo> list = heroService.getHero();
		model.addAttribute("user", list);
		return "hero";
	}
	
	/**
	 * 介绍
	 * @return
	 */
	@RequestMapping(value = "introduce")
	public String introduce() {
		return "introduce";
	}
	
	/**
	 * 根据类型遍历
	 * @param hero
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "queryHerosByType")
	public String queryHerosByType(HeroPojo hero,Model model) {
		List<HeroPojo> list = heroService.queryHerosByType(hero);
		model.addAttribute("heros", list);
		return "heroList";
	}
	
	/**
	 * 根据ID显示单个英雄信息
	 * @param hero
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "details")
	public String queryHerosById(HeroPojo hero,Model model) {
		HeroPojo hero1 = heroService.getHeroById(hero);
		model.addAttribute("heroId",hero1);
		System.out.println("id:"+hero1.getId());
		return "details";
	}

}

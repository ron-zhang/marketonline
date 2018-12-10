package com.cdcp.core.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 后台管理中心
 * 
 * @author zicha
 *
 */
@Controller
public class CenterController {

	//入口页面
	@RequestMapping(value = "/control/index.do")
	public String index() {
		return "index";
	}
	
	//入口页面头
	@RequestMapping(value = "/control/top.do")
	public String top() {
		return "top";
	}
	
	//入口页面体
	@RequestMapping(value = "/control/main.do")
	public String main() {
		return "main";
	}
	
	//入口页面左
	@RequestMapping(value = "/control/left.do")
	public String left() {
		return "left";
	}
	
	//入口页面右
	@RequestMapping(value = "/control/right.do")
	public String right() {
		return "right";
	}
	
	//商品体
	@RequestMapping(value = "/control/frame/product_main.do")
	public String product_main() {
		return "frame/product_main";
	}
	
	//商品左
	@RequestMapping(value = "/control/frame/product_left.do")
	public String product_left() {
		return "frame/product_left";
	}
		
	//广告体
	@RequestMapping(value = "/control/frame/ad_main.do")
	public String ad_main() {
		return "frame/ad_main";
	}
	
	//广告左
	@RequestMapping(value = "/control/frame/ad_left.do")
	public String ad_left() {
		return "frame/ad_left";
	}
	
	//订单体
	@RequestMapping(value = "/control/frame/order_main.do")
	public String order_main() {
		return "frame/order_main";
	}
	
	//订单左
	@RequestMapping(value = "/control/frame/order_left.do")
	public String order_left() {
		return "frame/order_left";
	}
	

}





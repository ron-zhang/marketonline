package com.cdcp.core.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cdcp.core.pojo.product.Brand;
import com.cdcp.core.service.product.BrandService;

import cn.itcast.common.page.Pagination;


/**
 * 品牌管理
 * 
 * @author zicha
 *
 */
@Controller
public class BrandController {
	
	@Autowired
	private BrandService brandService;

	//品牌管理-列表查询
	@RequestMapping(value = "/brand/list.do")
	public String list(Integer pageNo, String name, Integer isDisplay, Model model) {
		//查询分页对象
		Pagination pagination = brandService.selectPaginationByQuery(pageNo, name, isDisplay);
		//查询结果集
//		List<Brand> brands = brandService.selectBrandListByQuery(name, isDisplay);
		model.addAttribute("pagination", pagination);
		model.addAttribute("name", name);
		model.addAttribute("isDisplay", isDisplay);
		return "brand/list";
	}
	
	//去修改页面
	@RequestMapping(value = "/brand/toEdit.do")
	public String toEdit(Long id, Model model) {
		Brand brand = brandService.selectBrandById(id);
		model.addAttribute("brand", brand);
		return "brand/edit";
	}
}





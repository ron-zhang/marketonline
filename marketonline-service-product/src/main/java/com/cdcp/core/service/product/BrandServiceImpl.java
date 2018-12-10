package com.cdcp.core.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdcp.core.dao.product.BrandDao;
import com.cdcp.core.pojo.product.Brand;
import com.cdcp.core.pojo.product.BrandQuery;

import cn.itcast.common.page.Pagination;

/**
 * 品牌管理
 * @author zicha
 *
 */
@Service("brandService")
@Transactional
public class BrandServiceImpl implements BrandService {
	
	@Autowired
	private BrandDao brandDao;

	//查询品牌结果集
	public List<Brand> selectBrandListByQuery(String name, Integer isDisplay){
		
		BrandQuery brandQuery = new BrandQuery();
		//判断
		if(null != name) {
			brandQuery.setName(name);
		}	
		if(null != isDisplay) {
			brandQuery.setIsDisplay(isDisplay);
		}else {
			//默认值
			brandQuery.setIsDisplay(1);
		}
		
		return brandDao.selectBrandListByQuery(brandQuery);
	}
	
	public Pagination selectPaginationByQuery(Integer pageNo, String name, Integer isDisplay) {
		Pagination pagination = new Pagination();
		//当前页
		pagination.setPageNo(Pagination.cpn(pageNo));
		
		//每页数
		pagination.setPageSize(5);
		
		//总条数
		BrandQuery brandQuery = new BrandQuery();
		StringBuilder params = new StringBuilder();
		
		//判断
		if(null != name) {
			brandQuery.setName(name);
			params.append("name=").append(name);
		}
		if(null != isDisplay) {
			brandQuery.setIsDisplay(isDisplay);
			params.append("isDisplay=").append(isDisplay);
		}else {
			//默认值
			brandQuery.setIsDisplay(1);
			params.append("isDisplay=").append(1);
		}
		
		//设置当前页
		brandQuery.setPageNo(pagination.getPageNo());
		//设置每页数
		brandQuery.setPageSize(pagination.getPageSize());
		//总条数
		pagination.setTotalCount(brandDao.countBrandByQuery(brandQuery));
		//结果集
		pagination.setList(brandDao.selectBrandListByQuery(brandQuery));
		//分页在页面上的展示
		String url = "/brand/list.do";
		pagination.pageView(url, params.toString());
		
		return pagination;
	}

	@Override
	public Brand selectBrandById(Long id) {
		return brandDao.selectBrandById(id);
	}
}

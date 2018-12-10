package com.cdcp.core.dao.product;

import java.util.List;

import com.cdcp.core.pojo.product.Brand;
import com.cdcp.core.pojo.product.BrandQuery;

public interface BrandDao {

	//查询结果集 想查所有就查所有 想查分页就查分页
	public List<Brand> selectBrandListByQuery(BrandQuery brandQuery);
	
	//查询总条数
	public Integer countBrandByQuery(BrandQuery brandQuery);
	
	//通过ID查询一个品牌对象
	public Brand selectBrandById(Long id);
}

package com.example.jpetstore.dao.mybatis;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.jpetstore.dao.ProductDao;
import com.example.jpetstore.dao.mybatis.mapper.ProductMapper;
import com.example.jpetstore.domain.Product;

@Repository
public class MybatisProductDao implements ProductDao {
	@Autowired
	private ProductMapper productMapper;

	public List<Product> getProductListByCategory(String categoryId) 
			throws DataAccessException {
	    return productMapper.getProductListByCategory(categoryId);
	}

	public Product getProduct(String productId) throws DataAccessException {
	    return productMapper.getProduct(productId);
	}

	/* Inner Classes */
	public static class ProductSearch {

		private List<String> keywordList = new ArrayList<String>();

		public ProductSearch(String keywords) {
			StringTokenizer splitter = new StringTokenizer(keywords," ",false);
			while (splitter.hasMoreTokens()) {
				this.keywordList.add("%" + splitter.nextToken() + "%");
			}
		}
		public List<String> getKeywordList() {
			return keywordList;
		}
	}

	@Override
	public List<String> productNameList(String categoryId) throws DataAccessException {
		// TODO Auto-generated method stub
		return productMapper.productNameList(categoryId);

	}

	@Override
	public String getProductIdByName(String name) throws DataAccessException {
		// TODO Auto-generated method stub
		return productMapper.getProductIdByName(name);
	}	
}
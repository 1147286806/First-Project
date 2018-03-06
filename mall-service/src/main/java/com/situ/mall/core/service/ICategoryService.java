package com.situ.mall.core.service;

import java.util.List;

import com.situ.mall.common.response.ServerResponse;
import com.situ.mall.core.entity.Category;
import com.situ.mall.core.entity.Product;

public interface ICategoryService {

	ServerResponse selectTopCategory();

	ServerResponse selectSecondCategory(Integer topCategoryId);

	Integer selectParentCategoryId(Integer categoryId);

	ServerResponse<List<Category>> pageList(Integer page, Integer limit, Category category);

	List<Category> selectTopCategoryList();

	List<Category> selectSecondCategoryList();

}


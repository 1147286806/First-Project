package com.situ.mall.portal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.mall.common.response.ServerResponse;
import com.situ.mall.core.entity.Category;
import com.situ.mall.core.entity.Product;
import com.situ.mall.core.service.ICategoryService;
import com.situ.mall.core.service.IProductService;

@Controller
@RequestMapping("/product")
public class ProductManagerController {
	@Autowired
	private IProductService productService;
	@Autowired
	private ICategoryService categoryService;
	
	
	
	@RequestMapping("/getProductListPage")
	public String getProductPage(Model model,Integer categoryId) {
		List<Product> productList = productService.selectBycategoryId(categoryId);
		model.addAttribute("productList", productList);
		return "my-all";
	}
	
	@RequestMapping("/Page")
	public String getPage(Model model,Integer id) {
		Product product = productService.selectById(id);
		model.addAttribute("product", product);
		return "my-page";
	}
	
}

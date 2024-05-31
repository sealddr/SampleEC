package com.example.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.conversion.DbAction.Delete;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.goods.model.MGoods;
import com.example.domain.goods.model.MGoodsCategory;
import com.example.domain.goods.model.MGoodsSearchKeys;
import com.example.domain.goods.service.GoodsService;
import com.example.form.DeleteGoodsForm;
import com.example.form.GroupOrder;
import com.example.form.RegisterGoodsForm;
import com.example.form.SearchGoodsForm;
import com.example.form.UpdateGoodsForm;

import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping("/admin")
public class AdminGoodsController {
    
	@Autowired
	private GoodsService goodsService;

   	@Autowired
	private ModelMapper modelMapper;


    @GetMapping("/goods")
    public String getAdminProducts(
		@ModelAttribute SearchGoodsForm goodsSearchForm,
		@ModelAttribute RegisterGoodsForm registerGoodsForm,
		@ModelAttribute UpdateGoodsForm updateGoodsForm,
		@ModelAttribute DeleteGoodsForm deleteGoodsForm,
		Model model) {

		List<MGoodsCategory> goodsCategoryList = goodsService.getGoodsCategories();		
		model.addAttribute("goodsCategoryList", goodsCategoryList);
		
		MGoodsSearchKeys searchKeys = modelMapper.map(goodsSearchForm, MGoodsSearchKeys.class);
		
		List<MGoods> goodsList = goodsService.getGoods(searchKeys);
		model.addAttribute("goodsList", goodsList);

            return "admin/goods";
    }

    @PostMapping("/goods")
    public String postAdminProducts(@ModelAttribute SearchGoodsForm goodsSearchForm, Model model) {
		List<MGoodsCategory> goodsCategoryList = goodsService.getGoodsCategories();		
		model.addAttribute("goodsCategoryList", goodsCategoryList);
		
		MGoodsSearchKeys searchKeys = modelMapper.map(goodsSearchForm, MGoodsSearchKeys.class);
		
		List<MGoods> goodsList = goodsService.getGoods(searchKeys);
		model.addAttribute("goodsList", goodsList);
        
        return "admin/goods";
    }
    
	@PostMapping("/goods/register")
	public String postAdminRegisterGoods(
		@ModelAttribute SearchGoodsForm goodsSearchForm,
		@ModelAttribute @Validated(GroupOrder.class) RegisterGoodsForm registerGoodsForm,
		Model model) {
		MGoods goods = new MGoods();

		goods.setGoodsName(registerGoodsForm.getGoodsName());
		goods.setGoodsDescription(registerGoodsForm.getGoodsDescription());
		goods.setGoodsCategoryId(registerGoodsForm.getGoodsCategoryId());
		goods.setPrice(registerGoodsForm.getPrice());
		goods.setServiceURL(registerGoodsForm.getServiceURL());

		goodsService.registerGoods(goods);
		return "redirect:/admin/goods";
	}
    
	@PostMapping("/goods/update")
	public String postAdminUpdateGoods(
		@ModelAttribute SearchGoodsForm goodsSearchForm,
		@ModelAttribute @Validated(GroupOrder.class) UpdateGoodsForm updateGoodsForm,
		Model model) {
		MGoods goods = new MGoods();

		goods.setGoodsId(updateGoodsForm.getGoodsId());
		goods.setGoodsName(updateGoodsForm.getGoodsName());
		goods.setGoodsDescription(updateGoodsForm.getGoodsDescription());
		goods.setGoodsCategoryId(updateGoodsForm.getGoodsCategoryId());
		goods.setPrice(updateGoodsForm.getPrice());
		goods.setServiceURL(updateGoodsForm.getServiceURL());

		goodsService.updateGoods(goods);
		return "redirect:/admin/goods";
	}

	@PostMapping("/goods/delete")
	public String postAdminDeleteGoods(
		@ModelAttribute SearchGoodsForm goodsSearchForm,
		@ModelAttribute DeleteGoodsForm deleteGoodsForm,
		Model model) {
		goodsService.deleteGoods(deleteGoodsForm.getGoodsId());
		return "redirect:/admin/goods";
	}
	
}

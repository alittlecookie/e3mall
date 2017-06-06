package cn.e3mall.service;

import cn.e3mall.common.pojo.E3Result;
import cn.e3mall.common.pojo.EasyUIDatagridResult;
import cn.e3mall.pojo.TbItem;

public interface ItemService {

	TbItem getItemById(long itemId);
	 EasyUIDatagridResult getItemList(int page, int rows);
	 
	 //参数TbItem，String desc
		//返回值：E3Result
		E3Result addItem(TbItem item, String desc);
	
}

package cn.e3mall.service;

import cn.e3mall.common.pojo.EasyUIDatagridResult;
import cn.e3mall.pojo.TbItem;

public interface ItemService {

	TbItem getItemById(long itemId);
	 EasyUIDatagridResult getItemList(int page, int rows);
}

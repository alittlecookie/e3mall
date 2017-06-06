package cn.e3mall.service;

import java.util.List;

import cn.e3mall.common.pojo.EasyUITreeNode;

public interface ItemCatService {
	// 父节点的话返回的是父节点(list集合)
	
	List<EasyUITreeNode> getCatList(long parentId);
	

}

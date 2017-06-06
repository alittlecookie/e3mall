package cn.e3mall.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.e3mall.common.pojo.EasyUITreeNode;
import cn.e3mall.mapper.TbItemCatMapper;
import cn.e3mall.pojo.TbItemCat;
import cn.e3mall.pojo.TbItemCatExample;
import cn.e3mall.pojo.TbItemCatExample.Criteria;
import cn.e3mall.service.ItemCatService;
@Service
public class ItemCatServiceImpl implements ItemCatService {
	@Autowired
	private TbItemCatMapper tbItemCatMapper;
	/**
	 * 服务层数据:
	 * 通过父节点查询树节点列表
	 * 返回值是 List<EasyUITreeNode>
	 * 参数是父节点
	 * */
	public List<EasyUITreeNode> getCatList(long parentId) {
		// 设置查询条件
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria(); // 获取离线缓存对象
		criteria.andParentIdEqualTo(parentId);
		// 执行查询
		List<TbItemCat> list = tbItemCatMapper.selectByExample(example);
		// 把list集合结果转化 List<EasyUITreeNode>列表
		// 创建一个arraylist集合,遍历
		List<EasyUITreeNode> resuleList = new ArrayList<>();
		for (TbItemCat tbItemCat : list) {
			EasyUITreeNode node = new EasyUITreeNode();
			node.setId(tbItemCat.getId());
			node.setText(tbItemCat.getName());// 几点内容
			node.setState(tbItemCat.getIsParent()?"closed":"open");// 判断是否是父节点
			// 添加到列表
			resuleList.add(node);
		}
		// 返回结果
		return resuleList;
	}

}

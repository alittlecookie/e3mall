package cn.e3mall.common.pojo;

import java.io.Serializable;

public class EasyUITreeNode implements Serializable{// 网络传输的话需要实现序列化接口

	private long id;// 选中的节点id
	private String text;// 节点中的内容
	private String state;// 节点的状态(子节点open  父节点closed)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}

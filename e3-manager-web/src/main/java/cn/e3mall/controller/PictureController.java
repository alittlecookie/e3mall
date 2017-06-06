package cn.e3mall.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.e3mall.common.utils.FastDFSClient;
import cn.e3mall.common.utils.JsonUtils;

/**
 * 图片上传Controller
 * <p>Title: PictureController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p> 
 * @version 1.0
 */
@Controller
public class PictureController {
	
	@Value("${image.server.url}")
	private String imageServerURL;

	@RequestMapping("/pic/upload")
	@ResponseBody
	public String uploadFile(MultipartFile uploadFile) {
		try {
			//取文件原始名称
			String originalFilename = uploadFile.getOriginalFilename();
			//取文件的扩展名
			String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
			//把文件上传到图片服务器，应该封装到一个工具类中。
			FastDFSClient fastDFSClient = new FastDFSClient("classpath:conf/client.conf");
			//接收服务端返回的url，并拼装成完整的url
			String url = fastDFSClient.uploadFile(uploadFile.getBytes(), extName);
			url = imageServerURL + url;
			//创建一个Map对象
			Map map = new HashMap<>();
			//设置属性
			map.put("error", 0);
			map.put("url", url);
			//返回Map
			return JsonUtils.objectToJson(map);
		} catch (Exception e) {
			e.printStackTrace();
			//创建一个Map对象
			Map map = new HashMap<>();
			//设置属性
			map.put("error", 1);
			map.put("message", "文件上传失败");
			//返回Map
			return JsonUtils.objectToJson(map);
		}
	}
}

package cn.e3mall.fastdfs;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import cn.e3mall.common.utils.FastDFSClient;

public class FastDfsTest {

	@Test
	public void upload() throws Exception {
		//创建一个配置文件，配置文件中包含的tracker服务器的地址。
		//读取配置文件的信息。
		ClientGlobal.init("C:/gitRepository/mygit/e3-manager-web/src/main/resources/conf/client.conf");
		//创建一个TrackerClient对象
		TrackerClient trackerClient = new TrackerClient();
		//通过trackerClient获得TrackerServer对象
		TrackerServer trackerServer = trackerClient.getConnection();
		//创建一个StorageClient对象，需要两个参数一个是TrackerServer，StorageServer（可以为null）
		StorageServer storageServer = null;
		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
		//使用StorageClient对象上传文件，返回文件的路径和文件名。
		//参数1：本地文件路径 参数2：文件的扩展名，不能包含“.” 参数3：元数据，可以为null
		String[] strings = storageClient.upload_file("C:/Users/mbpy/Pictures/Saved Pictures/2017-03-01_180227.jpg", "jpg", null);
		for (String string : strings) {
			System.out.println(string);
		}
	}
	
	@Test
	public void testFastDfsClient() throws Exception {
		FastDFSClient fastDFSClient = new FastDFSClient("C:/gitRepository/mygit/e3-manager-web/src/main/resources/conf/client.conf");
		String string = fastDFSClient.uploadFile("C:/Users/mbpy/Pictures/Saved Pictures/2017-03-01_180227.jpg");
		System.out.println(string);
	}
}

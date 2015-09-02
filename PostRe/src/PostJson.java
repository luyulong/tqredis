import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class PostJson {
	public static void main(String[] args) throws Exception {

		String path = "http://localhost:20880/informationDubboService/addInformation";

		// 创建浏览器
		HttpClient client = new DefaultHttpClient();
		// 输入地址
		HttpPost post = new HttpPost(path);
		// 将需要的参数封装进jsonObject中
		StringEntity se = new StringEntity(getJsonObject());
		se.setContentType("application/json");// 表格采用的编码是utf-8
		post.setEntity(se);
		// 敲回车
		HttpResponse response = client.execute(post);
		int code = response.getStatusLine().getStatusCode();
		if (code == 201) {
			System.out.println("请求成功==" + code);

		} else {
			// 请求失败
			System.out.println("请求失败==" + code);
		}
	}

	public static String getJsonObject() {
         return "{\"concernState\":\"1\"}";
	}
}

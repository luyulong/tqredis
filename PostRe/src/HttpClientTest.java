import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

public class HttpClientTest {

	public static void main(String[] args) throws Exception {
		String url = "http://localhost:20880/informationDubboService/addDemo";
		HttpClient httpClient = new HttpClient();
		PostMethod post = new PostMethod(url);
		//application/x-www-form-urlencoded
		post.setRequestHeader("Content-Type", "multipart/form-data");
		NameValuePair[] param = { new NameValuePair("concernState", "1")};
		post.setRequestBody(param);
		int statusCode=httpClient.executeMethod(post);
		System.out.println(statusCode);
	}


}
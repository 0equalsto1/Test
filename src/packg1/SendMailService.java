package packg1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SendMailService {
public static void main(String[] args) {
	for(int i=0;i<500;i++){
	ExecutorService service = Executors.newFixedThreadPool(5);
	service.submit(new TaskEcec());
	}
}



public static void processSendMail() {}

}

 class TaskEcec implements Runnable{

	@Override
	public void run() {/*

		StringEntity mEntity = null;
		JSONObject jsonBody;
		HttpPost post = null;
		String springUrl= "http://localhost:8080/Spring4MVCHelloWorldRestServiceDemo/index";
		String playUrl= "http://localhost:9000/index";
		try (CloseableHttpClient client = HttpClientBuilder.create().build();) {
			jsonBody = new JSONObject();
			jsonBody.put("id", "000000000000");
			jsonBody.put("name", "M S Rawat");
			post = new HttpPost(springUrl);
			post.setHeader("Content-Type", "application/json");
			mEntity = new StringEntity(jsonBody.toString());
			mEntity.setContentType("application/json");
			post.setEntity(mEntity);
			try (CloseableHttpResponse response = client.execute(post);) {
				response.getStatusLine().getStatusCode();
			}

		} catch (NullPointerException e) {
		} catch (UnsupportedOperationException | IOException e) {
		} catch (JSONException e) {
		}


	*/}
	 
	
}

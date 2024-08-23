package json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Snippet {
	public static void main(String[] args) throws IOException {

		Map<String, String> payload = new HashMap<>();
//		payload.put("key1", "value1");
//		payload.put("key2", "value2");

		ObjectMapper objectMapper = new ObjectMapper();
		FavoriteParam param1 = new FavoriteParam("2019-01-29 12:25:05", 1);
		String writeValueAsString = objectMapper.writeValueAsString(param1);
		System.out.println(writeValueAsString);
		System.out.println(objectMapper.readValue(writeValueAsString, FavoriteParam.class));

	}
}

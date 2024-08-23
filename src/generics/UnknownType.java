package generics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnknownType {

	public static void main(String[] args) {
		List<?> list = new ArrayList<>();
		list.add(null);
		Map<String, FavoriteParam> map = new HashMap<>();
		FavoriteParam value = new FavoriteParam("2019-01-29 12:25:05", 1);
		map.put("1", value);
//		process(map);
	}

	static void process(Map<?, ?> map) {
		System.out.println(FavoriteParam.class.cast(map.get("1")).getModified());

	}

}

class FavoriteParam implements Serializable {
	private static final long serialVersionUID = 1L;
	private String modified;
	private int status;

	public FavoriteParam() {
	}

	public FavoriteParam(String modified, int status) {
		super();
		this.modified = modified;
		this.status = status;
	}

	public String getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}

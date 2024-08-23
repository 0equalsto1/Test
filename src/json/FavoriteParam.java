package json;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FavoriteParam implements Serializable {

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

	@Override
	public String toString() {
		return "FavoriteParam [modified=" + modified + ", status=" + status + "]";
	}


}

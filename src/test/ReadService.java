package test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public interface ReadService<T> {
	T read(int n);
}

class ReadServiceUtil {
	public static <T> ReadService<T> wrapWithCache(ReadService<T> service) {
		return new DecorateReadService<T>(service);
	}
}

class DecorateReadService<T> implements ReadService<T> {
	ReadService<T> ser;

	public DecorateReadService(ReadService<T> dec) {
		ser = dec;
	}

	Map<Integer, T> map = new ConcurrentHashMap<>();

	@Override
	public T read(int n) {

		T fromCache = getFromCache(n);
		if (fromCache != null)
			return fromCache;
		T fromDb = ser.read(n);
		putIntoCache(n, fromDb);
		return fromDb;
	}

	public T getFromCache(int n) {
		return map.getOrDefault(n, null);

	}

	public void putIntoCache(int n, T val) {
		map.putIfAbsent(n, val);
	}
}
package application;

public class HashEntry<T extends Comparable<T>> {
	private T value;
	private int status;
	
	public HashEntry(T value, int status) {
		this.value = value;
		this.status = status;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
}

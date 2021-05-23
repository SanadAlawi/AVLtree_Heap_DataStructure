package application;


public class HashTable<T extends Comparable<T>> {
	private HashEntry<T> [] list = new HashEntry [11];
	private int Size;
	
	public HashTable() { // HashTable Constructor

	}
	
	public HashTable(int capcity, int size) { // HashTable Constructor
		this.list = new HashEntry[capcity];
		this.Size = size;
	}
	
	public void insert(T data) { // insert method
		int key = data.hashCode();
		int i = 0, index = key % list.length;
		if(Size >= list.length/2 ) Rehash(); // Rehash the list
		while(list[index] != null && list[index].getStatus() != 2) {
			index = (key + (int)Math.pow(++i, 2)) % list.length;
		}
		list[index] = new HashEntry(data, 1);
		Size++;
	} // end method
	
	public int Search(T data) { // Search method
		int key = data.hashCode();
		int i = 0, index = key % list.length;
		while(list[index] != null) {
			// if list[index].getStatus() = 2 then that mean the data i search for are already deleted so search for another one if exist by same ID
			if(list[index].getValue().compareTo(data) == 0 && list[index].getStatus() != 2)
				return index;
			else
				index = (key + (int)Math.pow(++i, 2)) % list.length;
		}
		return -1;
	} // end method
	
	public int Delete(T data) { // Delete method
		int index = Search(data);
		if(index == -1) 
			return  -1;
		list[index].setStatus(2);
		Size--;
		return index;
	} // end method
	
	public String print() { // Print method
		String string = "";
		for(int i = 0 ; i < list.length ; i++) {
			if(list[i] != null && list[i].getStatus() != 2)
				string += i+"-> "+list[i].getValue()+"\n";
			else
				string += i+"-> "+"\n";
		}
		return string;
	} // end method
	
	public int Size() { // size method
		return list.length;
	} // end method
	
	public String HashFunction() { // Hash Code Function method
		String string = "";
		for(int i = 0 ; i < list.length ; i++) {
			if(list[i] != null && list[i].getStatus() != 2)
				string += "index "+i+"->"+list[i].getValue().hashCode()+"\n";
			else
				string += "index "+i+"->\n";
		}
		return string;
	} // end method
	
	private void Rehash() {
		int prime = list.length * 2;
		while(!isPrime(prime)) {
				prime++;
		}
//		HashEntry [] list2 = new HashEntry[prime];
		HashTable<T> list2 = new HashTable(prime, Size);
		for(int i = 0 ; i < list.length ; i++) {
//			list2[i].insert(list[i].getValue());
			if(list[i] == null) 
				continue;
			list2.insert(list[i].getValue());
		}
		this.list = list2.list;
	}
	
//	private void Rehash() {
//		int prime = list.length * 2;
//		while(!isPrime(prime)) 
//				prime++;
//		HashEntry<T> [] list2 = new HashEntry[prime];
//		for(int i = 0 ; i < list.length ; i++) {
//			if(list[i] == null)
//				continue;
//			list2[i] = list[i];
//		}
//		list = list2;
//	}
	
	 private boolean isPrime(int n) {  
		 for (int i = 2; i < n ; i++) {  
			 if (n % i == 0)   
				 return false;  
		 }
	     return true;  
	 }
	 
	 public void clear() {
		 for(int i = 0 ; i < list.length ; i++)
			 list[i] = null;
		 list = new HashEntry[11];
		 Size = 0;
	 }
	 
	 public boolean isEmpty() {
		 for(int i = 0 ; i < list.length ; i++) {
			 if(list[i] != null && list[i].getStatus() != 2)
				 return false;
		 }
		 return true; 
	 }
	 
	 public T get(int i) {
		 return list[i].getValue();
	 }
	 
	 public int CurrentSize() {
		 return Size;
	 }
	
	
}

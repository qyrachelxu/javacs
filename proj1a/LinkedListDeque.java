public class LinkedListDeque<T> {

	private class LinkedNode {

		private T item;
		private LinkedNode prev;
		private LinkedNode next;

		public LinkedNode(T i, LinkedNode p, LinkedNode n){
			item = i;
			prev = p;
			next = n;
		}

		private T get(int index){
			if(index == 0){
				return this.item;
			}
			return next.get(index -1);
		}
	}

	public LinkedNode sentinel;
	public LinkedNode last;
	private int size;

	public LinkedListDeque(){
		sentinel = new LinkedNode(null, null, null);
		sentinel.prev = sentinel;
		sentinel.next = sentinel;
		last = sentinel;
		size = 0;
	}

	public LinkedListDeque(T i){
		sentinel = new LinkedNode(null, null, null);
		sentinel.next = new LinkedNode(i, sentinel, sentinel);
		sentinel.prev = sentinel.next;
		last = sentinel.next;
		size = 1;
	}

	public void addFirst(T x){
		sentinel.next = new LinkedNode(x, sentinel, sentinel.next);
		sentinel.next.next.prev = sentinel.next;
		size += 1;
	}

	public void addLast(T x){
		last.next = new LinkedNode(x, last, sentinel);
		last = last.next;
		sentinel.prev = last;
		size += 1;
	}

	public T removeFirst(){
		if(isEmpty()){
			System.out.println("empty list!!!");
			return null;
		}
		T result;
		result = sentinel.next.item;
		sentinel.next = sentinel.next.next;
		sentinel.next.next.prev = sentinel;
		size -= 1;
		return result;
	}

	public T removeLast(){
		if(isEmpty()){
			System.out.println("empty list!!!");
			return null;
		}
		T result;
		result = last.item;
		last.prev.next = sentinel;
		last = last.prev;
		sentinel.prev = last;
		size -= 1;
		return result;
	}

	/** */
	public T get(int index){
		if(size() == 0 || index > size()){
			return null;
		}
		return sentinel.next.get(index);
	}

	/** recursive */
	public T getRecursive(int index){
		LinkedNode p = sentinel.next;
		for (int i = 0; i < index; i++){
			p = p.next;
		}
		return p.item;
	}

	public T getFirst(){
		return sentinel.next.item;
	}

	public T getLast(){
		return sentinel.prev.item;
	}

	/** */
	public void printDeque(){
		LinkedNode p = sentinel.next;
		for (int i = 0; i < size(); i++){
			System.out.println(p.item);
			p = p.next;
		}
	}

	/** using caching method, oop programming, everything is controlled by object  */
	public int size(){
		return size;
	}

	/** using caching method, oop programming, everything is controlled by object  */
	public boolean isEmpty(){
		return (size == 0);
	}


//	public static void main(String[] args){
//		LinkedListDeque<Integer> intList = new LinkedListDeque<>(3);
//		intList.addFirst(6);
//		intList.addFirst(29);
//		intList.addFirst(5);
//		intList.addLast(1);
//		intList.addFirst(4);
//		intList.removeFirst();
//		intList.removeLast();
//
//
//		System.out.println(intList.size());
//		System.out.println(intList.getFirst());
//		System.out.println(intList.getLast());
//		intList.printDeque();
//		System.out.println(intList.getrecursive(2));
//		System.out.println(intList.get(2));
//
//	}

}
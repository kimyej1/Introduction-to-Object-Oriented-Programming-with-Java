
public class Node<T> {

	// Variables
	private T data;
    private Node<T> next;
    
    // Constructors
    public Node(T data, Node next)
    {
    	this.data = data;
    	this.next = next;
    }

    public Node(T data)
    {
    	this(data, null);
    }

    // Getters and Setters
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}
}

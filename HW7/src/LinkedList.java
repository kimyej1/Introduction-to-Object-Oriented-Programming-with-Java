import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T> {

	// Variables
	private Node head = null;
	private Node tail = null;
	private int size = 0;
	
	// Constructor
	public LinkedList()
	{
		this.head = null;
		this.tail = null;
	}
	
	// Getters
	public Node getHead() {
		return head;
	}

	public Node getTail() {
		return tail;
	}

	
	@Override
	public void addAtIndex(T data, int index) {
		// TODO Auto-generated method stub
		
		if (index > size() || index < 0) {
            throw new IllegalArgumentException("Your index is out of the list bounds");
        }
        if (data == null) {
            throw new NullPointerException("You cannot add null data to the list");
        }

        Node tempNode = new Node(data, null);
        Node currentNode = head;
        Node previousNode = null;

        if (currentNode != null) {
            for (int i = 0; i < index; i++) {
                previousNode = currentNode;
                currentNode = currentNode.getNext();
            }

            if (previousNode == null) {
                tempNode.setNext(currentNode);
                head = tempNode;
            } else {
                previousNode.setNext(tempNode);
                tempNode.setNext(currentNode);
            }
        } else {
            head = new Node(data, null);
        }
	}

	
	@Override
	public T remove(T data) 
	{
		// TODO Auto-generated method stub
		Node currentNode = head;
        Node previousNode = null;
        
        if(data == null)
        {
        	throw new IllegalArgumentException("You cannot remove null data from the list");
        }
        else
        {
			try {
				for (int i = 0; currentNode != null; i++) 
		        {
		            if (currentNode.getData().equals(data)) 
		            {
		                if (i == 0) 
		                {
		                    head = head.getNext();
		                }
		                previousNode.setNext(currentNode.getNext());		                
		            }
		            previousNode = currentNode;
		            currentNode = currentNode.getNext();
		        }
				return data;
				
			} catch (Exception e) {
				// TODO: handle exception
				throw new NoSuchElementException("The data is not present in the list.");
			}
        }
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		this.head = null;
		this.tail = null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (size() > 0) ? false : true;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		Node tempHead = head;
		
        int counter = 0;
        while (tempHead != null) {
            tempHead = tempHead.getNext();
            counter++;
        }

        return counter;
	}

	@Override
	public T getAtIndex(int index) {
		// TODO Auto-generated method stub
		if (index >= size() || index < 0) {
            throw new IllegalArgumentException("Your index is out of the list bounds");
        }

        Node currentNode = head;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }

        return (T) currentNode.getData();
	}

	@Override
	public T removeAtIndex(int index) {
		// TODO Auto-generated method stub
		if (index >= size() || index < 0) {
            throw new IllegalArgumentException("Your index is out of bounds");
        }

        Node currentNode = head;
        Node previousNode = null;

        for (int i = 0; i < index;) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
            i++;
        }

        if (previousNode == null) {
            head = currentNode.getNext();
            return (T) currentNode.getData();
        }
        previousNode.setNext(currentNode.getNext());

        return (T) currentNode.getData();
	}
	
}

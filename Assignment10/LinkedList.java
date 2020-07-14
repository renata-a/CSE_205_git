// Assignment #: 10
//         Name: MADHAV ARUN SHARMA
//    StudentID: 1216873476
//  Lab Lecture: 4:35 PM MW
//  Description: The LinkedList class has additional methods and use the methods 
//               in the LinkedListIterator class to traverse from the first element 
//               to the last element of the linked list
// A linked list is a sequence of nodes with efficient
// element insertion and removal.
// This class contains a subset of the methods of the
// standard java.util.LinkedList class.

import java.util.NoSuchElementException;

public class LinkedList
{
	//nested class to represent a node
	private class Node
	{
		public Object data;
		public Node next;
	}

	//only instance variable that points to the first node.
	private Node first;

	// Constructs an empty linked list.
	public LinkedList()
	{
		first = null;
	}


	// Returns the first element in the linked list.
	public Object getFirst()
	{
		if (first == null)
		{
			NoSuchElementException ex
			= new NoSuchElementException();
			throw ex;
		}
		else
			return first.data;
	}

	// Removes the first element in the linked list.
	public Object removeFirst()
	{
		if (first == null)
		{
			NoSuchElementException ex = new NoSuchElementException();
			throw ex;
		}
		else
		{
			Object element = first.data;
			first = first.next;  //change the reference since it's removed.
			return element;
		}
	}

	// Adds an element to the front of the linked list.
	public void addFirst(Object element)
	{
		//create a new node
		Node newNode = new Node();
		newNode.data = element;
		newNode.next = first;
		//change the first reference to the new node.
		first = newNode;
	}

	// Returns an iterator for iterating through this list.
	public ListIterator listIterator()
	{
		return new LinkedListIterator();
	}

	/*********************************************************
   Add your methods here
	 *********************************************************/

	//Define the method toString()
	//to concatenate strings in the linked list, and return a string
	public String toString()
	{
		//String str1 to hold the opening bracket
		String str1="{";

		//if the linked list is empty
		if(first==null)
			//return opening and ending bracket with a space in between
			return "{ }\n";

		Node pos=first;
		while(pos!=null)
		{
			//keep adding linked list elements to str1
			str1 += " " + pos.data.toString();
			//move position pos to next position pos.next
			pos=pos.next;
		}
		//return str1 with all the strings in the linked list
		return str1+" }\n";
	}
	
	//-------------------------------------------------------------------------------------------------
	//Define the method size()
	//to find the number of strings that the linked list contains
	public int size()
	{
		LinkedListIterator iterator = new LinkedListIterator();
		//initialize local variable size to be 0
		int size = 0;
		//while loop to count number of strings in the linked list
		//till a next element exists
		while(iterator.hasNext())
		{
			//move to the next position and increment size by 1
			iterator.next();
			size++;
		}
		//returns the number of strings in the linked list contains
		return size;
	}
	//-------------------------------------------------------------------------------------------------
	//Define the method addElement()
	//to add the parameter element into the linked list
	public void addElement(Object element)
	{
		//create newNode
		Node newNode=new Node();
		//Assign element to newNode.data
		newNode.data=element;
		//check first is null
		if(first==null) {
			//set newNode.next to NULL
			newNode.next=null;
			//set newNode as first
			first=newNode;
			//exit
			//no return, type void
			return;
		}
		//if parameter element is alphabetically smaller then
		else if(element.toString(). compareTo(first.data.toString() )<0) {
			//add newNode as the first node
			newNode.next=first;
			first=newNode;
		}
		//if newNode is greater than first.data
		else {
			Node pos = first.next;          
			Node prev = first;
			//Loop to find the position for newNode
			while( pos != null ) {
				//if place found then exit
				if( element.toString().compareTo(pos.data.toString())<0)
					break;
				//else store current position, pos
				prev=pos;
				//move to next position, pos.next
				pos=pos.next;
			}
			//place newNode
			newNode.next=prev.next;
			prev.next=newNode;
		}
	}
	//-------------------------------------------------------------------------------------------------
	//Define the method removeElementsAtEvenIndices()
	//to remove objects at even indices within the linked list
	public void removeElementsAtEvenIndices( )
	{
		//local variable index1 to regulate index location
		//to only be at even indices
		int index1 = 0;

		//while loop to keep removing at even indices
		//till we have reached the end of linked list
		while(index1<=size()-1) 
		{
			//if element to be removed is first element
			if(index1==0) {
				//call removeFirst()
				if (first == null) {
					NoSuchElementException ex = new NoSuchElementException();
					throw ex; }
				else {
					//move first to next position, first.next
					first = first.next; }
			}
			//find the position of index
			else {
				Node pos=first;
				Node prev=pos;
				int count=0;
				//find the index element
				while((pos!=null) &&(count<index1)) {
					prev=pos;
					pos=pos.next;
					count++;
				}
				//check for position, pos, not null and remove the element
				if(pos!=null) {
					Node rem=pos;
					prev.next=pos.next;
					pos=prev;
				}
				//if position, pos, is null
				else
					//throw exception
					throw new IndexOutOfBoundsException();
				//if(index1>size()-1)
				//break;
			}
			//increment index1 by only 1 to move to the next even index
			//of the original linked list before removal of even indices
			index1 ++;
		}
	}
	//-------------------------------------------------------------------------------------------------
	//Define the method removeElementAt()
	//to look for an object at the parameter index, 
	//and remove and return the object at the index location
	public Object removeElementAt(int index)
	{
		//if element to be removed is first element
		if(index==0)
			//call removeFirst()
			return removeFirst();
		//find the position of index
		else {
			Node pos=first;
			Node prev=pos;
			int count=0;
			//find the index element
			while((pos!=null) &&(count<index)) {
				prev=pos;
				pos=pos.next;
				count++;
			}
			//check for position not null and remove the element
			if(pos!=null) {
				Node rem=pos;
				prev.next=pos.next;
				pos=prev;
				//return the deleted node data
				return rem.data;
			}
			//if position, pos, is null
			else
				//throw exception
				throw new IndexOutOfBoundsException();
		}
	}
	//-------------------------------------------------------------------------------------------------
	//Define the method howManyAppearBefore()
	//to search the parameter object in the linked list, and 
	//count how many elements appear before the first occurrence of 
	//the parameter object/element and return it
	public int howManyAppearBefore(Object element)
	{
		ListIterator iterator = listIterator();
		//local variable howMany to store number of elements
		//before the first appearance of parameter element
		//howMany = index of first appearance + 1
		int howMany=-1;
		int index =0;

		int length = size();

		//while loop to keep look for the first appearance
		//till a next element exists
		while(iterator.hasNext())
		{
			//String variable current to hold the current element
			String current = (String)iterator.next();
			//compare parameter element with current element
			if(element.equals(current))
			{
				//if parameter element and current element are equal
				howMany=index;
				//break to return the index of first appearance
				break;
			}
			//increment index to progress through the linked list
			index++;
		}
		//returns number of elements
		//before the first appearance of parameter element
		return howMany;
	}
	//-------------------------------------------------------------------------------------------------
	//Define the method indexOfLast()
	//to look for the last occurrence of the parameter object in the linked list,
	//and return the index of its location
	public int indexOfLast(Object element)
	{
		ListIterator iterator = listIterator();
		//local variable indLast to store index of last appearance
		int indLast=-1;
		int index =0;

		//while loop to keep looking for the last appearance
		//till a next element exists
		while(iterator.hasNext())
		{
			//String variable current to hold the current element
			String current = (String)iterator.next();
			//compare parameter element with current element
			if(element.equals(current))
			{
				//if parameter element and current element are equal
				indLast=index;
			}
			//increment index to progress through the linked list
			index++;
		}
		//returns index of last appearance
		return indLast;
	}
	//-------------------------------------------------------------------------------------------------
	//Define the method getElement()
	//to duplicate get element at the parameter index in the linked list
	public Object getElement(int index)
	{
		LinkedListIterator it = new LinkedListIterator();

		for(int i = 0; i<index; i++)
		{
			//next() until we reach the parameter index
			it.next();
		}
		//returns element at parameter index
		return it.next();
	}
	//-------------------------------------------------------------------------------------------------
	//Node position; 
	//Node previous;

	//Define the method duplicateEach()
	//to duplicate each element in the linked list
	public void duplicateEach( )
	{
		//local variable index3 to store the index location
		int index3 = 0;

		//while loop to duplicate elements
		while(index3<=size()-1) {
			//add the element to duplicate it 
			addElement(getElement(index3));

			//---------------------------------------------------------
			/*if (position == null) //never traversed yet
			{
				addFirst(getElement(index3));
				position = first;
			}
			else
			{
				//making a new node to add
				Node newNode = new Node();
				newNode.data = getElement(index3);
				newNode.next = position.next;
				//change the link to insert the new node
				position.next = newNode;
				//move the position forward to the new node
				position = newNode;
			}
			//this means that we cannot call remove() right after add()
			previous = position;*/
			//---------------------------------------------------------

			//increment index by 2 
			//to move to the next element to be duplicated
			index3 += 2;
		}
	}

	//nested class to define its iterator
	private class LinkedListIterator implements ListIterator
	{
		private Node position; //current position
		private Node previous; //it is used for remove() method

		// Constructs an iterator that points to the front
		// of the linked list.

		public LinkedListIterator()
		{
			position = null;
			previous = null;
		}

		// Tests if there is an element after the iterator position.
		public boolean hasNext()
		{
			if (position == null) //not traversed yet
			{
				if (first != null)
					return true;
				else
					return false;
			}
			else
			{
				if (position.next != null)
					return true;
				else
					return false;
			}
		}

		// Moves the iterator past the next element, and returns
		// the traversed element's data.
		public Object next()
		{
			if (!hasNext())
			{
				NoSuchElementException ex = new NoSuchElementException();
				throw ex;
			}
			else
			{
				previous = position; // Remember for remove

				if (position == null)
					position = first;
				else
					position = position.next;

				return position.data;
			}
		}

		// Adds an element after the iterator position
		// and moves the iterator past the inserted element.
		public void add(Object element)
		{
			if (position == null) //never traversed yet
			{
				addFirst(element);
				position = first;
			}
			else
			{
				//making a new node to add
				Node newNode = new Node();
				newNode.data = element;
				newNode.next = position.next;
				//change the link to insert the new node
				position.next = newNode;
				//move the position forward to the new node
				position = newNode;
			}
			//this means that we cannot call remove() right after add()
			previous = position;
		}

		// Removes the last traversed element. This method may
		// only be called after a call to the next() method.
		public void remove()
		{
			if (previous == position)  //not after next() is called
			{
				IllegalStateException ex = new IllegalStateException();
				throw ex;
			}
			else
			{
				if (position == first)
				{
					removeFirst();
				}
				else
				{
					previous.next = position.next; //removing
				}
				//stepping back
				//this also means that remove() cannot be called twice in a row.
				position = previous;
			}
		}

		// Sets the last traversed element to a different value.
		public void set(Object element)
		{
			if (position == null)
			{
				NoSuchElementException ex = new NoSuchElementException();
				throw ex;
			}
			else
				position.data = element;
		}
	} //end of LinkedListIterator class
} //end of LinkedList class
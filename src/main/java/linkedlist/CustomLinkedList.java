package linkedlist;

public class CustomLinkedList {
  
  private Node head;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public CustomLinkedList() {}
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public int size() {
    if (head != null) {
      int size = 0;
      Node currentNode = head;
      do {
        currentNode = currentNode.next;
        size++;
      } while (currentNode != null);
      
      return size;
    }
    return 0;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public void add(Node node) {
    if (head == null) {
      head = node;
    }
    else {
      Node lastNode = getLast();
      lastNode.next = node;
    }
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public Node getFirst() {
    return head;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public Node getLast() {
    if (head == null) return head;
    
    Node lastNode = head;
    while (lastNode.next != null) {
      lastNode = lastNode.next;
    }
    return lastNode;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public CustomLinkedList copyOfList() {
    CustomLinkedList list = new CustomLinkedList();
    
    if (head != null) {
      Node currentNode = head;
      do {
        Node newNode = new Node(currentNode.data);
        list.add(newNode);
        currentNode = currentNode.next;
      } while (currentNode != null);
    }
    return list;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public int sum() {
    int sum = 0;
    
    if (head != null) {
      Node currentNode = head;
      do {
        sum += currentNode.data;
        currentNode = currentNode.next;
      }  while (currentNode != null);
    }
    return sum;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public void displayList() {
    if (head != null) {
      Node currentNode = head;
      System.out.print(currentNode.data);
      while (currentNode.next != null) {
        currentNode = currentNode.next;
        System.out.print(" -> " + currentNode.data);
      }
      System.out.println();
    }
    else System.out.printf("List is empty\n");
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}

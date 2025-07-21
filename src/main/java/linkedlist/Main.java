package linkedlist;

public class Main {
  
  public static void main(String[] args) {
    CustomLinkedList list = new CustomLinkedList();
    
    Node node1 = new Node(1);
    Node node2 = new Node(2);
    Node node3 = new Node(3);
    Node node4 = new Node(4);
    
    list.add(node1);
    list.add(node2);
    list.add(node3);
    list.add(node4);
    list.displayList();
    
    node2.next = null;
    list.displayList();
    
    System.out.println(list.getLast().data);
    System.out.println(list.getFirst().data);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  //-------------------------------------------------------------------------------------------------------------------
  
  //-------------------------------------------------------------------------------------------------------------------
  
}

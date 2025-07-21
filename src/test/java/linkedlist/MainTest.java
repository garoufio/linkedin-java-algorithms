package linkedlist;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MainTest {
  
  private CustomLinkedList list = new CustomLinkedList();
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @BeforeEach
  public void init() {
    Node node1 = new Node(1);
    Node node2 = new Node(2);
    Node node3 = new Node(3);
    Node node4 = new Node(4);
    
    list.add(node1);
    list.add(node2);
    list.add(node3);
    list.add(node4);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Test the size of the initial list")
  public void testInitSize() {
    assertEquals(list.size(), 4);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Add node and return the new size")
  public void testAddNode() {
    Node newNode = new Node(5);
    list.add(newNode);
    assertEquals(list.size(), 5);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Get last node data")
  public void testGetLast() {
    Node last = list.getLast();
    assertEquals(last.data, 4);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Get first node data")
  public void testGetFirst() {
    Node first = list.getFirst();
    assertEquals(first.data, 1);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Return a copy of the list")
  public void testCopy() {
    CustomLinkedList copy = list.copyOfList();

    assertAll(
        () -> { assertEquals(copy.size(), list.size()); },
        () -> {
          Node node1 = list.getFirst();
          Node node2 = copy.getFirst();
          
          do {
            assertEquals(node1.data, node2.data);
            node1 = node1.next;
            node2 = node2.next;
          } while (node1.next != null && node2.next != null);
        }
    );
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Calculate the sum of list data")
  public void testSum() {
    assertEquals(10, list.sum());
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Truncate list at node 2 and test the new size")
  public void testTruncateNodeAt2() {
    Node node = list.getFirst();
    for (int i = 1; i < 2; i++) {
      node = node.next;
    }
    node.next = null;
    assertEquals(2, list.size());
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}

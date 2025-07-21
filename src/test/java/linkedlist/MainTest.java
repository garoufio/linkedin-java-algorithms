package linkedlist;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MainTest {
  
  CustomLinkedList list = new CustomLinkedList();
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @BeforeAll
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
  
  //-------------------------------------------------------------------------------------------------------------------
  
}

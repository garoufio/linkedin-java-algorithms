package tree;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MainTest {
  
  private BinaryTree binaryTree;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @BeforeAll
  public void init() {
    //           5
    //      2        4
    //   9    10        7
    binaryTree = new BinaryTree();
    
    TreeNode root = new TreeNode(5);
    binaryTree.setRoot(root);
    
    TreeNode node2 = new TreeNode(2);
    TreeNode node4 = new TreeNode(4);
    root.setLeft(node2);
    root.setRight(node4);
    
    TreeNode node7 = new TreeNode(7);
    root.getRight().setRight(node7);
    
    TreeNode node9 = new TreeNode(9);
    root.getLeft().setLeft(node9);
    TreeNode node10 = new TreeNode(10);
    root.getLeft().setRight(node10);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Insert 3 nodes and traverse them with all orders")
  public void testInsert3Nodes() {
    BinaryTree tree = new BinaryTree();
    List<Integer> nodes;
    
    tree.insert(7);
    tree.insert(9);
    tree.insert(3);
    
    // pre-order
    int[] expectedPreOrder = new int[] {7, 3, 9};
    tree.preOrderTraversal();
    nodes = tree.getNodes();
    int[] actualPreOrder = new int[nodes.size()];
    for (int i = 0; i < nodes.size(); i++) {
      actualPreOrder[i] = nodes.get(i);
    }
    
    // post-order
    int[] expectedPostOrder = new int[] {3, 9, 7};
    tree.postOrderTraversal();
    nodes = tree.getNodes();
    int[] actualPostOrder = new int[nodes.size()];
    for (int i = 0; i < nodes.size(); i++) {
      actualPostOrder[i] = nodes.get(i);
    }
    
    // in-order
    int[] expectedInOrder = new int[] {3, 7, 9};
    tree.inOrderTraversal();
    nodes = tree.getNodes();
    int[] actualInOrder = new int[nodes.size()];
    for (int i = 0; i < nodes.size(); i++) {
      actualInOrder[i] = nodes.get(i);
    }
    
    assertAll(
        () -> assertArrayEquals(expectedPreOrder, actualPreOrder, "Pre order failed"),
        () -> assertArrayEquals(expectedPostOrder, actualPostOrder, "Post order failed"),
        ()  -> assertArrayEquals(expectedInOrder, actualInOrder, "In order failed")
    );
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Insert 5 nodes and traverse them with all orders")
  public void testInsert5Nodes() {
    BinaryTree tree = new BinaryTree();
    List<Integer> nodes;
    
    tree.insert(7);
    tree.insert(3);
    tree.insert(2);
    tree.insert(5);
    tree.insert(9);
    
    // pre-order
    int[] expectedPreOrder = new int[] {7, 3, 2, 5, 9};
    tree.preOrderTraversal();
    nodes = tree.getNodes();
    int[] actualPreOrder = new int[nodes.size()];
    for (int i = 0; i < nodes.size(); i++) {
      actualPreOrder[i] = nodes.get(i);
    }
    
    // post-order
    int[] expectedPostOrder = new int[] {2, 5, 3, 9, 7};
    tree.postOrderTraversal();
    nodes = tree.getNodes();
    int[] actualPostOrder = new int[nodes.size()];
    for (int i = 0; i < nodes.size(); i++) {
      actualPostOrder[i] = nodes.get(i);
    }
    
    // in-order
    int[] expectedInOrder = new int[] {2, 3, 5, 7, 9};
    tree.inOrderTraversal();
    nodes = tree.getNodes();
    int[] actualInOrder = new int[nodes.size()];
    for (int i = 0; i < nodes.size(); i++) {
      actualInOrder[i] = nodes.get(i);
    }
    
    assertAll(
        () -> assertArrayEquals(expectedPreOrder, actualPreOrder, "Pre order failed"),
        () -> assertArrayEquals(expectedPostOrder, actualPostOrder, "Post order failed"),
        ()  -> assertArrayEquals(expectedInOrder, actualInOrder, "In order failed")
    );
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Insert 8 nodes and traverse them with all orders")
  public void testInsert8Nodes() {
    BinaryTree tree = new BinaryTree();
    List<Integer> nodes;
    
    tree.insert(7);
    tree.insert(3);
    tree.insert(2);
    tree.insert(5);
    tree.insert(9);
    tree.insert(11);
    tree.insert(10);
    
    // pre-order
    int[] expectedPreOrder = new int[] {7, 3, 2, 5, 9, 11, 10};
    tree.preOrderTraversal();
    nodes = tree.getNodes();
    int[] actualPreOrder = new int[nodes.size()];
    for (int i = 0; i < nodes.size(); i++) {
      actualPreOrder[i] = nodes.get(i);
    }
    
    // post-order
    int[] expectedPostOrder = new int[] {2, 5, 3, 10, 11, 9, 7};
    tree.postOrderTraversal();
    nodes = tree.getNodes();
    int[] actualPostOrder = new int[nodes.size()];
    for (int i = 0; i < nodes.size(); i++) {
      actualPostOrder[i] = nodes.get(i);
    }
    
    // in-order
    int[] expectedInOrder = new int[] {2, 3, 5, 7, 9, 10, 11};
    tree.inOrderTraversal();
    nodes = tree.getNodes();
    int[] actualInOrder = new int[nodes.size()];
    for (int i = 0; i < nodes.size(); i++) {
      actualInOrder[i] = nodes.get(i);
    }
    
    assertAll(
        () -> assertArrayEquals(expectedPreOrder, actualPreOrder, "Pre order failed"),
        () -> assertArrayEquals(expectedPostOrder, actualPostOrder, "Post order failed"),
        ()  -> assertArrayEquals(expectedInOrder, actualInOrder, "In order failed")
    );
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Traverse the binary tree with pre-order algorithm")
  public void testPreOrderTraversal() {
    int[] expected = { 5, 2, 9, 10, 4, 7 };
    
    binaryTree.preOrderTraversal();
    List<Integer> nodes = binaryTree.getNodes();
    
    int[] actual = new int[nodes.size()];
    for (int i = 0; i < nodes.size(); i++) {
      actual[i] = nodes.get(i);
    }
    assertArrayEquals(expected, actual);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Traverse the binary tree with post-order algorithm")
  public void testPostOrderTraversal() {
    int[] expected = { 9, 10, 2, 7, 4, 5 };
    
    binaryTree.postOrderTraversal();
    List<Integer> nodes = binaryTree.getNodes();
    
    int[] actual = new int[nodes.size()];
    for (int i = 0; i < nodes.size(); i++) {
      actual[i] = nodes.get(i);
    }
    assertArrayEquals(expected, actual);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Traverse the binary tree with in-order algorithm")
  public void testInOrderTraversal() {
    int[] expected = { 9, 2, 10, 5, 4, 7 };
    
    binaryTree.inOrderTraversal();
    List<Integer> nodes = binaryTree.getNodes();
    
    int[] actual = new int[nodes.size()];
    for (int i = 0; i < nodes.size(); i++) {
      actual[i] = nodes.get(i);
    }
    assertArrayEquals(expected, actual);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  @Test
  @DisplayName("Get the height of the tree")
  public void testTreeHeight() {
    assertEquals(3, binaryTree.findHeight());
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}

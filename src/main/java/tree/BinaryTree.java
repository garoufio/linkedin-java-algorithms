package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
  
  private TreeNode root;
  private List<Integer> nodes;
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public TreeNode getRoot() {
    return root;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public void setRoot(TreeNode root) {
    this.root = root;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public List<Integer> getNodes() {
    return nodes;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public void insert(int value) {
    insert(this.root, value);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  private TreeNode insert(TreeNode node, int value) {
    if (node == null) {
      node = new TreeNode(value);
      if (root == null) {
        root = node;
      }
    }
    else if (node.getData() > value) {
      node.setLeft(insert(node.getLeft(), value));
    }
    else if (node.getData() < value) {
      node.setRight(insert(node.getRight(), value));
    }
    return node;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  /** Visit root first, recursively visit left subtree, recursively visit right subtree */
  public void preOrderTraversal() {
    nodes = new ArrayList<>();
    preOrderTraversal(this.root);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  private void preOrderTraversal(TreeNode root) {
    if (root == null) return;
    
    nodes.add(root.getData());
    preOrderTraversal(root.getLeft());
    preOrderTraversal(root.getRight());
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  /** Recursively visit left subtree, recursively visit right subtree and then visit root */
  public void postOrderTraversal() {
    nodes = new ArrayList<>();
    postOrderTraversal(this.root);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  private void postOrderTraversal(TreeNode root) {
    if (root == null) return;
    
    postOrderTraversal(root.getLeft());
    postOrderTraversal(root.getRight());
    nodes.add(root.getData());
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  /** Recursively visit left subtree, visit root and then recursively visit right subtree */
  public void inOrderTraversal() {
    nodes = new ArrayList<>();
    inOrderTraversal(this.root);
  }
  
  
  //-------------------------------------------------------------------------------------------------------------------
  
  private void inOrderTraversal(TreeNode root) {
    if (root == null) return;
    
    inOrderTraversal(root.getLeft());
    nodes.add(root.getData());
    inOrderTraversal(root.getRight());
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public void clear() {
    this.root = null;
    this.nodes = null;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  public int findHeight() {
    if (root == null) return 0;
    
    int heightLeft = 1;
    int heightRight = 1;
    heightLeft += findHeight(root.getLeft(), heightLeft);
    heightRight += findHeight(root.getRight(), heightRight);
    
    return Math.max(heightLeft, heightRight);
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  private int findHeight(TreeNode node, int height) {
    if (node == null) return 0;
    
    return hasChildren(node) ? ++height : 0;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
  private boolean hasChildren(TreeNode node) {
    if (node == null) return false;
    
    return node.getLeft() != null || node.getRight() != null;
  }
  
  //-------------------------------------------------------------------------------------------------------------------
  
}

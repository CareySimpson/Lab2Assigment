class Node{
   int value;
   Node left, right;
   
   public Node(int value){
      this.value = value;
      left = null;
      right = null;
   }

}

class BinarySearchTree{

   Node root;
   
   
   /*
   recursive insert method
   */
   public Node insert(Node root, int value){
      //base case
      if(root == null){
         root = new Node(value);
         return root;
      }
      
      //recursive step
      if(value < root.value){
         root.left = insert(root.left, value); 
      }else{
         root.right = insert(root.right, value);
      }
      
      return root;
   }
   
   /**
   *	pre-order traversal
   *	Lists the nodes in the binary search tree in preorder (Node, left, right)
   */
   public void preOrderTraversal(Node root){
      //implement me
	   if(root == null) {return;}
	   
	   System.out.print(root.value + " ");
	   preOrderTraversal(root.left);
	   preOrderTraversal(root.right);
   }

   
   
   /**
    *	in-order traversal
    *	Lists the nodes in the binary search tree in order (Left, node, right)
    */
   public void inOrderTraversal(Node root){
      //implement me
	   if(root == null) {return;}
	   
	   preOrderTraversal(root.left);
	   System.out.print(root.value + " ");
	   preOrderTraversal(root.right);
   }
   
   
   
   /**
    *	post-order traversal
    *	Lists the nodes in the binary search tree in post-order (Left, right, node)
    */
   public void postOrderTraversal(Node root){
      //implement me
	   if(root == null) {return;}
	   
	   preOrderTraversal(root.left);
	   preOrderTraversal(root.right);
	   System.out.print(root.value + " ");
   }
   
   
   
   /**
   *	a method to find the node in the tree with a specific value
   *	Takes the arguments of the root of the tree and the key to find.
   */
   public boolean find(Node root, int key){
	   
	   if(root == null) {return false;}
	   
	   if(root.value == key) {return true;}
	   
	   if(root.value < key)
	   {
		  return find(root.right, key); 
	   }
	   else
	   {
		  return find(root.left, key); 
	   }         
   }
   
   
   
   /**
   *	a method to find the node in the tree with a smallest key
   *	Takes the root node of a tree as argument
   */
   public int getMin(Node root){
	   while(root.left != null)
		   root = root.left;
	   return root.value;
      //implement me
   }
  
  
  
   /**
   *	a method to find the node in the tree with a largest key
   *	Takes the root node of a tree as argument
   */
   public int getMax(Node root){
	   while(root.right != null)
		   root = root.right;
	   return root.value;
	  //implement me
   }
   
   
   
   /*
   this method will not compile until getMax
   is implemented
   */
   public Node delete(Node root, int key){
      
      if(root == null){
         return root;
      }else if(key < root.value){
         root.left = delete(root.left, key);
      }else if(key > root.value){
         root.right = delete(root.right, key);
      }else{
         //node has been found
         if(root.left==null && root.right==null){
            //case #1: leaf node
            root = null;
         }else if(root.right == null){
            //case #2 : only left child
            root = root.left;
         }else if(root.left == null){
            //case #2 : only right child
            root = root.right;
         }else{
            //case #3 : 2 children
            root.value = getMax(root.left);
            root.left = delete(root.left, root.value);
         }
      }
      return root;  
   }
   
   
   
}



public class TreeDemo{
   public static void main(String[] args){
      BinarySearchTree t1  = new BinarySearchTree();
      t1.insert(24);
      t1.insert(80);
      t1.insert(18);
      t1.insert(9);
      t1.insert(90);
      t1.insert(22);
            
      System.out.print("in-order :   ");
      t1.inOrderTraversal(t1.root);
      System.out.println();
           
      
   }  
}
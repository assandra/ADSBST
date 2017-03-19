import java.util.Set;
import java.util.TreeSet;

public class BSTRelation<X extends Comparable<X>,Y extends Comparable<Y>> implements Relation<X,Y> {
	//Each BSTRelation object is a binary relation which ....
	
	//The relation is represented as follows : root is a link to the root node of a 
	//BST containing the pairs
	
	private BSTNode root;
	private String bstData ="";
	private Set<X> setX = new TreeSet<X>();
	private Set<Y> setY = new TreeSet<Y>();
 	
	
	////// Inner Class /////
	private class BSTNode {
		protected BSTNode left, right; //Left and right subtrees
		protected X x;						//X objects
		protected Y y;						//Y objects
		
		///// Constructor /////
		public BSTNode(X x, Y y) {
			this.x = x;
			this.y = y;
			left = null;
			right = null;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
		}
		
		public BSTNode deleteTopMost() {
			//Delete the topmost element in the subtree whose topmost node is this node.
			//Return a link to the modified subtree.
			if (left == null){
				return right;
			}
			else if (right == null) {
				return left;
			}
			else {  //this node has both a left child and a right child
				BSTNode newNode = right.getLeftmost();	
				this.x = newNode.x;
				this.y = newNode.y;
			
				right = right.deleteLeftmost();
				return this;
				
			}
		}
	
		private BSTNode getLeftmost() {
			//Return the leftmost element in the (nonempty) subtree whose
			//topmost node is this node.
			BSTNode curr = this;
			while(curr.left != null) {
				curr = curr.left;
			}
			return curr;
		}
		
		
		private BSTNode deleteLeftmost() {
			//Delete the leftmost element in the (nonempty) subtree whose topmost node is
			//this node. Return a link to the modified subtree.
			BSTNode parent = null, curr = this;
				while(curr.left != null) {
					parent = curr; curr = curr.left;
				}
				if (curr == this) {
					return this.right;
				}
				else {
					parent.left = curr.right;
					return this;
			}
		}
		
	}
	
	////// Constructor /////
	public BSTRelation() {
		//Construct a relation, initally empty.
		root = null;
	}
	
	////// Accessors //////
    public boolean contains(X xTarget, Y yTarget) {
        //Return true if and only if any node of the BST contains a pair
        //equal to x,y. Using the BST search algorithm which at best, i.e. when the
        //BST is balanced, has time complexity of O(logn)
         
        int xDirection = 0;     //0 is here, <0 left, >0 is right
        int yDirection = 0;
        BSTNode curr = root;
        for(;;) {
            //Case where BST is empty
            if (curr == null)
            {
                return false;
            }
            //Case where found right x and y at same time
            xDirection = xTarget.compareTo(curr.x);
            if (xDirection == 0) {
                yDirection = yTarget.compareTo(curr.y);
                if (yDirection == 0)
                {
                    return true;
                }
                else if (yDirection < 0) {
                    curr = curr.left;
                }
                else {
                    curr = curr.right;
                }
            }
            else if (xDirection < 0) {
                curr = curr.left;
            }
            else {
                curr = curr.right;
            }
                         
        }
             
    }
    public Set<Y> makeYSet(X xTarget) {
        //Given x return a set containing all values of y
        //associated with x. Using the BST search algorithm which at best, i.e. when the
        //BST is balanced, has time complexity of O(logn)
     
        int xDirection = 0;         //0 is here, <0 left, >0 is right
        int yDirection = 0;
       
        BSTNode curr = root;
     
        for(;;) {
            //Case where BST is empty
            if (curr == null) {
                return null;
            }
            xDirection = xTarget.compareTo(curr.x);
            if (xDirection == 0) { 
                setY.add(curr.y);
                inOrderYSearch2(curr);
           /*      if (curr.left!=null) {
                	 yDirection = curr.left.y.compareTo(curr.y);
                	
                	 if (yDirection <0) {
                		 setY.add(curr.left.y);
                	 }
                	
                 }
                 if (curr.right!=null) {
                  	 yDirection = curr.right.y.compareTo(curr.y);
                 	
                	 if (yDirection <0) {
                		 setY.add(curr.right.y);
                	 }
                	
                 }*/
                 
            
                return setY;
         
                 
            }   
             
            else if (xDirection < 0) {
                curr = curr.left;
            }
            else {
                curr = curr.right;
            }
             
             
        }
         
         
    }
	
/*	private Y recursiveSearch(X xTarget) {
		int xDirection = 0;			//0 is here, <0 left, >0 is right
		
		
		BSTNode curr = root;
	
		for(;;) {
			//Case where BST is empty
			if (curr == null) {
				return null;
			}
			xDirection = xTarget.compareTo(curr.x);
			if (xDirection == 0) {
				recursiveSearch(xTarget);
				return curr.y;
				
			//setY.add(curr.left.y);
				setY.add(curr.right.y);
				return setY;
		
				
			}	
			
			else if (xDirection < 0) {
				curr = curr.left;
			}
			else {
				curr = curr.right;
			}
			
			
		}
		
		
	}*/

	public Set<X> makeXSet(Y yTarget) {
		//Given y return a set containing all values of x
		//associated with y. Using the BST search algorithm which at best, i.e. when the
		//BST is balanced, has time complexity of O(log n)
		
		BSTNode curr = root;
		inOrderYSearch(curr, yTarget);
		return setX;
	}


	
	

	public void clear() {
		//Make the relation empty.
		root = null;
	}
	
	public void add(X xElem, Y yElem) {
		//Add the given pair x,y to the relation. Using the BST insertion algorithm which at best,
		//i.e. when the BST is balanced, has time complexity of O(log n).
	
		int xDirection = 0; // ...0 for here, <0 for left, >0 for right.
		int yDirection = 0;
		
		boolean test = false;
		BSTNode parent = null, curr = root;
		for (;;) {
			if (curr == null) {
				BSTNode ins = new BSTNode(xElem, yElem);
				if (root == null) {
					root = ins;
				}
				else if (xDirection < 0) {
					parent.left = ins;
				}
				else if (xDirection > 0) {
					parent.right = ins;
				}
				//else if (xDirection == 0) {
				else if (yDirection < 0) {
						parent.left = ins;
					}
				else {
						parent.right = ins;
					}
				
				return;
			}
			xDirection = xElem.compareTo(curr.x);
			test = false;
			if (xDirection == 0) {
				yDirection = yElem.compareTo(curr.y);
				
				if (yDirection == 0)
				{
					return;
					
				}
				parent = curr;
				
				if (yDirection < 0) {
					curr = curr.left;
				}
				else {
					
					curr = curr.right;
				}	
				test = true;
			}
			if (test== false) {
			parent = curr;
			
			if (xDirection < 0) {
				curr = curr.left;
			}
			else {
				
				curr = curr.right;
			}		
			}
		}
	}
	
	public void remove(X xElem, Y yElem) {
		//Remove the given pair x,y from the relation. Using the BST deletion algorithm which is 
		//at best, i.e. when the BST is balanced, has time complexity of O(log n).
	
		int xDirection = 0;	//...0 for here, <0 for left, >0 for right.
		int yDirection = 0;
		BSTNode parent = null, curr = root;
		boolean test=false;

		
		for(;;) {
			//Case where we have an empty tree
			if (curr == null) {
				return;
			}
			xDirection = xElem.compareTo(curr.x);
			//System.out.println("x direction" +xDirection);
			if (xDirection == 0) {
				yDirection = yElem.compareTo(curr.y);
				//System.out.println(yDirection);
				if (yDirection == 0)
				{
					//System.out.println("Found a match"+(String)curr.y + (String)curr.x);
					BSTNode del = curr.deleteTopMost();
								
				if (curr == root) {
					root = del;
				}
				else if (curr == parent.left) {
					parent.left = del;
				}
				else { //curr == parent.right
					parent.right = del;
				}
				return;
	
			
				}
				 if (yDirection < 0){
						parent = curr;
						curr = parent.left;
						//System.out.println("Left y"+(String)curr.y + (String)curr.x);
						test =true;
						
					}
					 else if (yDirection > 0) {
						parent = curr;
						curr = parent.right;
					//System.out.println("Right y"+(String)curr.y + (String)curr.x);
						test = true;
						}
				}
			
			
	

			if (test == false) {
			parent = curr;
			if (xDirection < 0) {
				
				
				curr = parent.left;
				//System.out.println("Left x"+(String)curr.y + (String)curr.x);
			}
			else { // xDirection > 0
				curr = parent.right;
				//System.out.println("Right x"+(String)curr.y + (String)curr.x);
			}
			}
}
}
	
	
	public void removeAllX(X xTarget) {
	//Remove all pairs x,y from the relation which contain the given x.
		
		//Search for x value, return node
		//delete node
		
		for(;;) {
		BSTNode del = searchX(xTarget);
		if (del!=null) 
		{
			remove(del.x,del.y);
		}
		else // del ==null
		{
			return;
		}
		}
		
		
		
	}

		

	
	public void removeAllY(Y yTarget) {
		
	
		searchY(yTarget, root);

		
	}
	
	public String toString() {

		inOrderTraversal(root);
		return bstData;
	}
	
	
	
	//////// Auxilary Methods ///////
	
	//Inorder traversal - used for toString to print in
	//alphabetical order according to x
    //Inorder traversal - used for toString to print in
    //alphabetical order according to x
    private void inOrderTraversal(BSTNode top) {
   
      
      //  System.out.println((String)curr.y);
        if(top!= null) {
        	
            inOrderTraversal(top.left);
           // bstData = bstData +(String)root.x+" "+(String)root.y+"\n";
           System.out.println((String)top.x+(String)top.y);
            inOrderTraversal(top.right);
        }
    }
	
	private void inOrderYSearch(BSTNode root, Y yTarget) {
	
		if(root!= null) {
			inOrderYSearch(root.left, yTarget);
			
			if (yTarget == root.y) {
				//setX.add(root.x);
				
			}
			//System.out.println((String)root.y);
			inOrderYSearch(root.right, yTarget);
		}
	}

		
	
	private void inOrderYSearch2(BSTNode root) {
		
		if(root!= null) {
			inOrderYSearch2(root.left);
			
			
				setY.add(root.y);
			
			//System.out.println((String)root.y);
			inOrderYSearch2(root.right);
		}
	}
	
	
	private void searchY(Y yTarget, BSTNode root) {
		if(root!= null) {
			searchY( yTarget,root.left);
			if (yTarget == root.y){
			
			remove(root.x,root.y);
			}
			//System.out.println((String)root.y);
			searchY( yTarget, root.right);
		}
	}
	
	//BST search algorithm, passing an x value will return the corresponding
	//node, if it exists
	private BSTNode searchX(X xTarget) {
		int xDirection = 0;
		BSTNode curr = root;
		for(;;) {
			if (curr == null) {
				return null;
			} 
			xDirection = xTarget.compareTo(curr.x);
			if (xDirection == 0) {
				return curr;
			}
			else if (xDirection < 0){
				curr = curr.left;
			}
			else { // xDirection > 0
				curr = curr.right;	
			}
		}
	}
		

}
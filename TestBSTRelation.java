import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TestBSTRelation {
	public static void main(String[] args) {
		
	
	//Instantiate binary relation
	BSTRelation<String, String> binaryRelation = new BSTRelation<String, String>();
	
	//Construct all nodes for binary relation
/* 	BSTNode<String, String> node1 = new BSTNode<String, String>("FR", "French");
	BSTNode<String, String> node2 = new BSTNode<String, String>("DE", "German");
	BSTNode<String, String> node3 = new BSTNode<String, String>("IT", "Italy");
	BSTNode<String, String> node4 = new BSTNode<String, String>("BE", "French");
	BSTNode<String, String> node5 = new BSTNode<String, String>("BE", "Flemish");
	BSTNode<String, String> node6 = new BSTNode<String, String>("NL", "Dutch");
	BSTNode<String, String> node7 = new BSTNode<String, String>("UK", "English");
	BSTNode<String, String> node8 = new BSTNode<String, String>("IE", "English");
	BSTNode<String, String> node9 = new BSTNode<String, String>("IE", "Irish"); */
	
	
	//Code to insert Nodes in correct order in binary relation
	//create put method in BSTRelation
	binaryRelation.add("FR","French");
	binaryRelation.add("DE","German");
	binaryRelation.add("IT","Italy");
	binaryRelation.add("BE","French");
	binaryRelation.add("BE","Flemish");
	binaryRelation.add("NL","Dutch");  
	binaryRelation.add("UK","English");
	binaryRelation.add("UR", "French");
	binaryRelation.add("UK", "French");
	binaryRelation.add("IE","English"); 
	binaryRelation.add("IE","Irish");
	binaryRelation.add("IE","Zlpha");
	binaryRelation.add("IE","Elpha");
	binaryRelation.add("IE","Jlpha");
	
	//binaryRelation.toString();
	
	//Call each method, with appropriate print statements to the console
	
/*	////////// Condition 1 Tests /////////
	//Test for a pair it contains, should be true
	boolean test1 = binaryRelation.contains("IE","Irish");
	System.out.println("Test1.1 " + test1);
	
	//Test for a pair it doesn't contain, should be false
	boolean test2 = binaryRelation.contains("DK","Danish");
	System.out.println("Test1.2 " + test2);
	
	//Test where x is contained but y is not, should be false
	boolean test3 = binaryRelation.contains("BE","Dutch");
	System.out.println("Test1.3 " + test3);
	
	//Test where y is contained but x is not, should be false
	boolean test4 = binaryRelation.contains("US","English");
	System.out.println("Test1.4 " + test4);
	
	

	///////// Condition 2 Tests ////////
	Set<String> ySet = binaryRelation.makeYSet("IE");
	System.out.println();
	System.out.println("Test 2: ySet given target x");
	System.out.println(ySet);
	System.out.println();
	//System.out.println("Test 2 size of set"+ySet.size());

	
	////// Condition 3 Tests ////////
	Set<String> xSet = binaryRelation.makeXSet("French");
	System.out.println();
	System.out.println("Test 3: xSet given target y");
	System.out.println(xSet);
	System.out.println();
	
	///// Condition 4 Tests ///////
	//binaryRelation.clear();
	//System.out.println("To String method");
	//System.out.println(binaryRelation.toString());
	
	//// Condition 5 Tests ////////
	//Does not add if pair already exists
	System.out.println("Test 5.1: add pair which already exists ");
	binaryRelation.add("FR", "French");
	
	binaryRelation.toString();
	System.out.println();
	
	//Add pair even if y already exists
	System.out.println("Test 5.2: add pair where y  already exists ");
	binaryRelation.add("UR", "French");
	System.out.println("To String method");
	System.out.println(binaryRelation.toString());
	System.out.println();
	
	//Add pair even if x already exists
	System.out.println("Test 5.3: add pair where x  already exists ");
	binaryRelation.add("UK", "French");
	System.out.println("To String method");
	System.out.println(binaryRelation.toString());
	System.out.println();
	
	
	System.out.println("Test 5.3: add pair where x  already exists ");
	binaryRelation.add("UK", "English");
	System.out.println("To String method");
	System.out.println(binaryRelation.toString());
	System.out.println();
	*/
	
	System.out.println("To String method1");
	System.out.println(binaryRelation.toString());
	//System.out.println("Work"+bst);
	System.out.println();
	
//	binaryRelation.remove("IE","Zlpha");
	//binaryRelation.removeAllY("French");
	Set<String> ySet = binaryRelation.makeYSet("UK");
	System.out.println();
	System.out.println("Test 2: ySet given target x");
	System.out.println(ySet);
	System.out.println();
	//System.out.println("Test 2 size of set"+ySet.size());
	
	///// Condition 6 Tests /////
	//binaryRelation.removeAllX("NL");

	System.out.println("To String method2");
	System.out.println(binaryRelation.toString());
	//System.out.println("Work"+bst);
	System.out.println();


	}

}

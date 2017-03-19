import java.util.Set;

public interface Relation<X,Y> {
	//Each Relation<X,Y> object is a homogeneous binary relation which is a collection of pairs (x,y). 
	//Where x values are of type X and y values are of type y.
		
	/////// Accessors ///////
	public boolean contains(X x, Y y);
	//Return true if and only if the relation contains the pair x,y.
	
	public Set<Y> makeYSet(X x);
	//Given x return a set containing all values of y
	//associated with x.
	
	public Set<X> makeXSet(Y y);
	//Given y return a set containing all values of x
	//associated with y.
	
	/////// Transformers /////
	public void clear();
	//Make the relation empty.
	
	public void add(X x, Y y);
	//Add the given pair x,y to the relation.
		
	public void remove(X x, Y y);
	//Remove the given pair x,y from the relation.
	
	public void removeAllX(X x);
	//Remove all pairs x,y from the relation which contain the given x.
	
	public void removeAllY(Y y);
	//Remove all pairs x,y from the relation which contain the given y.
	
	public String toString();
	//Renders the content of the relation as a string in  a suitable format.
	

	
}

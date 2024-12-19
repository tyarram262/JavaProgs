public class dupeRemove {
	public String[] removeDuplicates(String[] a){
        String[] dupelessStrings = new String[a.length];
        for(int i=0;i<a.length;i++){
            if(!contains(dupelessStrings,a[i])){
                dupelessStrings[i] = a[i];
            }
        }
        return dupelessStrings;
	}
    public boolean contains(String[] x, String y){
        for(int i=0;i<x.length;i++){
            if(x[i].equals(y)){
                return true;
            }
        }
        return false;
    }
}
//supposed to use a hashset but instead requires another list without null vals
//hashset automaticall removes duplicate values, can add to the set with add() and toArray converts back


//Generics allow you to specify the type of elements that a collection can hold ensuring type safety at compile time.
//It includes compile time type checking and explicit type declaration during conversions.
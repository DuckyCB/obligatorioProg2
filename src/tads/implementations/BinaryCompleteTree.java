package tads.implementations;

import tads.interfaces.MyBinaryCompleteTree;

import java.util.ArrayList;

public class BinaryCompleteTree<T> implements MyBinaryCompleteTree<T> {

	private ArrayList<T> values;

	public BinaryCompleteTree(){

		this.values=new ArrayList<>();

	}

	@Override
	public void insert(T data) {

		values.add(data);

	}

	@Override
	public void delete(T data) {

		values.remove(data);
        
	}

	public String toString (){
        String toReturn = new String();
        int level=0;

        for (int i=0; i<values.size();i++){

            for(int j=1; j<=Math.pow(2,level);j++){

                String value = values.get(i).toString();
                toReturn = toReturn.concat(value+" ");

                if(i+1< values.size()&&j+1<=Math.pow(2,level)){
                    i=i+1;

                }else{

                    break;
                }
            }

            toReturn= toReturn.concat("\n");
            level=level+1;
        }

        return toReturn;
    }
}

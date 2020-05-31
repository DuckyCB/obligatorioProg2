package TADs.implementations;

import TADs.interfaces.MyBinaryCompleteTree;

import java.util.ArrayList;

public class BinaryCompleteTree<T> implements MyBinaryCompleteTree<T> {

	private ArrayList<T> values;

	public BinaryCompleteTree(){

		this.values=new ArrayList<>();

	}

	@Override // Sin verificar
	public void insert(T data) {

		values.add(data);

	}

	@Override // Sin verificar
	public void delete(T data) {

		values.remove(data);

	}
}

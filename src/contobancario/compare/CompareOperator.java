package contobancario.compare;

import java.util.Comparator;

import contobancario.model.Operator;

public class CompareOperator implements Comparator<Operator>{
	public int compare(Operator o1, Operator o2) {
		return o1.getSerialNumber().compareTo(o2.getSerialNumber());
	};
}

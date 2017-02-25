package contobancario.compare;

import java.util.Comparator;

import contobancario.model.Operator;

/**
 * The Class CompareOperator.
 *
 */
public class CompareOperator implements Comparator<Operator> {

	public int compare(Operator operator1, Operator operator2) {
		return operator1.getSerialNumber().compareTo(operator2.getSerialNumber());
	}
}

package contobancario.compare;

import java.util.Comparator;

import contobancario.model.Transition;

/**
 * The Class CompareTransitions.
 *
 */
public class CompareTransitions implements Comparator<Transition> {

	public int compare(Transition transition1, Transition transition2) {
		if (transition1.getAmount() == transition2.getAmount())
			return 0;
		else if (transition1.getAmount() < transition2.getAmount())
			return -1;
		else
			return 1;
	}
}

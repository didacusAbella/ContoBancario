package contobancario.utils;

import java.util.Comparator;

import contobancario.model.Transition;

public class CompareTransitions implements Comparator<Transition>{
	public int compare(Transition transition1, Transition transition2) {
		if (transition1.getAmount() == transition2.getAmount())
			return 0;

		if (transition1.getAmount() < transition2.getAmount())
			return -1;

		if (transition1.getAmount() > transition2.getAmount())
			return 1;

		return 0;
	}
}

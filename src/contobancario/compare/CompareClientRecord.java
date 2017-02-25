package contobancario.compare;

import java.util.Comparator;

import contobancario.model.ClientRecord;

/**
 * The Class CompareClientRecord.
 *
 */
public class CompareClientRecord implements Comparator<ClientRecord> {

	public int compare(ClientRecord clientRecord1, ClientRecord clientRecord2) {
		return clientRecord1.getName().compareTo(clientRecord2.getName());
	}
}

package contobancario.bankaccounts;

import contobancario.model.ClientRecord;

public class DebitCard extends CreditCard implements Cloneable {
	public DebitCard(){
	}
	
	public DebitCard(ClientRecord client, double balance, String iban){
			super(client,balance,iban);
	}

	
}
package client.mainUI.pictureUI;

import client.mainUI.UserTable;

public class CardTable extends UserTable {
	private Mediator mediator;
	
	public CardTable(CardMediator mediator) {
		super();
		this.mediator = mediator;
	}
}
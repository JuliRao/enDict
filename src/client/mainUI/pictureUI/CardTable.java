package client.mainUI.pictureUI;

import client.mainUI.UserTable;

@SuppressWarnings("serial")
public class CardTable extends UserTable {
	private Mediator mediator;
	
	public CardTable(CardMediator mediator) {
		super();
		this.setMediator(mediator);
	}

	public Mediator getMediator() {
		return mediator;
	}

	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}
}
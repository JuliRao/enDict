package client.mainUI.functionUI;

import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import client.common.Send;
import client.theme.MyTheme;

public class FunctionPanel extends JPanel {
	
	public FunctionPanel() {
		this.setBackground(MyTheme.Instance().getBackgroundColor());
		this.setLayout(new FlowLayout());
	}
	
	public void setSend(Send send) {
		for(Component component : this.getComponents()) {
			if(component instanceof FunctionButton) {
				((FunctionButton) component).setSend(send);
			}
		}
	}
}

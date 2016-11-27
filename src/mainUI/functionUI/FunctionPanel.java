package mainUI.functionUI;

import java.awt.FlowLayout;

import javax.swing.JPanel;

import theme.MyTheme;

public class FunctionPanel extends JPanel {
	public FunctionPanel() {
		this.setBackground(MyTheme.Instance().getBackgroundColor());
		this.setLayout(new FlowLayout());
	}
}

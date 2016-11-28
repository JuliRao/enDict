package client.mainUI.functionUI;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JPanel;

import client.theme.MyTheme;

public class FunctionPanelCreator {
/*	public FunctionButton createFunctionButton(String iconPath) {
		FunctionButton functionButton = new FunctionButton(iconPath);
		return functionButton;
	}
	
	public FunctionMenu createFunctionMenu() {
		return new FunctionMenu();
	}
	*/
	public FunctionPanel createFunctionPanel() {
		FunctionPanel functionPanel = new FunctionPanel();
		functionPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		
		FunctionMenu menu = new FunctionMenu();
		FunctionButton userButton = new UserButton(MyTheme.Instance().getUserIcon());
		FunctionButton picButton = new PicButton(MyTheme.Instance().getPicIcon());
		FunctionButton noteButton = new NoteButton(MyTheme.Instance().getNoteIcon());
		noteButton.setToolTipText("生词本");
		
		functionPanel.add(menu);
		functionPanel.add(userButton);
		functionPanel.add(picButton);
		functionPanel.add(noteButton);
		
		return functionPanel;
	}
}

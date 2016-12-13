package client.mainUI.functionUI;

import javax.swing.JLabel;

import client.theme.MyTheme;

public class FunctionPanelCreator {
	
	public FunctionPanel createFunctionPanel() {
		FunctionPanel functionPanel = new FunctionPanel();
		functionPanel.setLayout(null);
		
		FunctionMenu menu = new FunctionMenu();
		FunctionButton userButton = new UserButton(MyTheme.Instance().getUserIcon());
		FunctionButton picButton = new PicButton(MyTheme.Instance().getPicIcon());
		FunctionButton noteButton = new NoteButton(MyTheme.Instance().getNoteIcon());
		JLabel userInfo = new JLabel("未登录");
		
		int gap = 50;
		
		userButton.setBounds(5, -5, gap, gap);
		picButton.setBounds(5 + gap, -5, gap, gap);
		noteButton.setBounds(5 + gap * 2, -5, gap, gap);
		userInfo.setBounds(20 + gap * 3, 0, 200, 35);
		
		functionPanel.add(menu);
		functionPanel.add(userButton);
		functionPanel.add(picButton);
		functionPanel.add(noteButton);
		functionPanel.add(userInfo);
		
		return functionPanel;
	}
}
package client.mainUI.noteUI;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import client.common.Info;
import client.theme.MyTheme;

/**
 * 
 * @author marao
 * 用于显示生词本的表格
 *
 */
@SuppressWarnings("serial")
public class NoteTable extends JTable {
	public boolean isCellEditable(int row, int column) {
		return false;
	}
	
	public NoteTable() {
		super(100, 2);
		String[] columnName = {"单词", "解释"};
		
		Object[][] data = Info.getWordNotes();
		System.out.println(data.length);
		
		DefaultTableModel tableModel = new DefaultTableModel(data, columnName);
		setBackground(MyTheme.Instance().getBackgroundColor());
		setOpaque(false);
		
		this.setModel(tableModel);
		this.setRowHeight(25);
		setEnabled(true);
		setDragEnabled(false);
		setCellSelectionEnabled(false);
	}
}

package client.mainUI.wordUI;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import client.theme.MyTheme;

/**
 * 
 * @author marao
 * 用户输入框
 *
 */
@SuppressWarnings("serial")
public class WordText extends JTextField {
	
	private static int width = 500;
	private static int height = 30;
	
	private boolean isLegal = true;
	
	public WordText() {
		this.setLayout(null);
		this.setSize(width, height);
		getDocument().addDocumentListener(new TextDocumentListener());
	}
	
	public WordText(int x, int y) {
		this.setBounds(x, y, width, height);
		this.setLayout(null);
		getDocument().addDocumentListener(new TextDocumentListener());
	}
	
	// 参考：http://javapub.iteye.com/blog/680793
	private static final boolean isChinese(char c) {  
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);  
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS  
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS  
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A  
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION  
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION  
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {  
            return true;  
        }  
        return false;  
    }  
	
	private static boolean isLegalChar(char c) {
		if(isChinese(c))
			return false;
		
		if(Character.isAlphabetic(c) || Character.isSpaceChar(c))
			return true;
		
		return false;
	}
	
	public boolean isLegal() {
		return isLegal;
	}

	public void setLegal(boolean isLegal) {
		this.isLegal = isLegal;
	}

	class TextDocumentListener implements DocumentListener {
		public void insertUpdate(DocumentEvent e) {
			
	        String word = getText();
			for(int i = 0; i < word.length(); ++ i) {
				if(!isLegalChar(word.charAt(i))) {
					setLegal(false);
					setFont(MyTheme.Instance().getErrorFont());
					setForeground(MyTheme.Instance().getErrorColor());
					repaint();
					return;
				}
			}
			
			setLegal(true);
			setForeground(Color.black);
			setFont(MyTheme.Instance().getFont());
			repaint();
        }
		
		/*
         * 文本内容减少时出发这个方法
         */    
        public void removeUpdate(DocumentEvent e) {
        	
	        String word = getText();
			for(int i = 0; i < word.length(); ++ i) {
				if(!isLegalChar(word.charAt(i))) {
					setLegal(false);
					setFont(MyTheme.Instance().getErrorFont());
					setForeground(MyTheme.Instance().getErrorColor());
					repaint();
					return;
				}
			}
			
			setLegal(true);
			setForeground(Color.black);
			setFont(MyTheme.Instance().getFont());
			repaint();
        }
        
        // ???
        public void changedUpdate(DocumentEvent e) {

        }
	}
}

package client.common;

import java.util.Vector;

/**
 * 
 * @author marao
 * 分别显示三个词典的释义
 *
 */
public interface Displayable {
	void displayBing(Vector<String> strings);
	void displayBaidu(Vector<String> strings);
	void displayYoudao(Vector<String> strings);
}
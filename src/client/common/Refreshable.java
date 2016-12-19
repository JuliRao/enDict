package client.common;

import java.util.ArrayList;

import common.Dictionary;

/**
 * 
 * @author marao
 * 可刷新
 *
 */
public interface Refreshable {
	public void refresh(ArrayList<Dictionary> dictionaries);
}

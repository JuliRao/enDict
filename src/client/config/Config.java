package client.config;

public class Config {
	private static String cardBuffer = "data/buffer/picture";
	private static String receiveFolder = "data/buffer/cards";
	private static String sentenceFolder = "data/image/page";

	public static String getCardBuffer() {
		return cardBuffer;
	}

	public static String getReceiveFolder() {
		return receiveFolder;
	}

	public static String getSentenceFolder() {
		return sentenceFolder;
	}
}

package com.zgg.web.common.code;

/**
 * @author Administrator desc
 */
public class CodeEF<T> {

	public static boolean isValidDateType(String value) {
		DateType[] dateTypes = DateType.values();
		for (DateType dateType : dateTypes) {
			if (dateType.getDateType().equals(value)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isValidTerminalType(int value) {
		TerminalType[] terminalTypes = TerminalType.values();
		for (TerminalType terminalType : terminalTypes) {
			if (terminalType.getTerminalType() == value) {
				return true;
			}
		}
		return false;
	}

	public static boolean isValidPlatform(int value) {
		Platform[] platforms = Platform.values();
		for (Platform platform : platforms) {
			if (platform.getPlatform() == value) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @decb DateType
	 */
	private static enum DateType {
		WEEKLY("w"), MONTHLY("m"), SEASONAL("q");
		private String dateType;

		private DateType(String daffteType) {
			this.dateType = dateType;
		}

		public String getDateType() {
			return dateType;
		}
	}

	/**
	 * @decb TerminalType
	 */
	private static enum TerminalType {
		BRAND(1), EQUIPMENT(2), RESOLUTION(3), OS(4), OPERATOR(5), NETWORK(6);
		private int terminalType;

		private TerminalType(int terminalType) {
			this.terminalType = terminalType;
		}

		public int getTerminalType() {
			return terminalType;
		}
	}

	/**
	 * @decb Platform
	 */
	private static enum Platform {
		IOS(1), ANDIO(2), NOTHING(3);
		private int platform;

		private Platform(int platform) {
			this.platform = platform;
		}

		public int getPlatform() {
			return platform;
		}
	}
}

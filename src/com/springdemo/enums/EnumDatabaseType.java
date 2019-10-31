package com.springdemo.enums;

public enum EnumDatabaseType {
	MSSQL("MSSQL", "MSSQL"), ORACLE("ORACLE", "ORACLE"), MYSQL("MYSQL", "MYSQL");

	private String key;
	private String value;

	EnumDatabaseType(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

}

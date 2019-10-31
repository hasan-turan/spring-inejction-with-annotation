package com.springdemo.helpers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;

public class PropertyFileHelper {
	private String propertyFile;

	public PropertyFileHelper(String propertyFile) {
		this.propertyFile = propertyFile;
		System.out.println("Propert file path: " + this.propertyFile);
	}

	public String getProperty(String propertyName) {
		try (InputStream inputStream = new FileInputStream(this.propertyFile)) {

			Properties prop = new Properties();
			prop.load(inputStream);
			return prop.getProperty(propertyName);

		} catch (IOException io) {
			io.printStackTrace();
			return "";
		}
	}

	public void setProperty(String propertyName, String propertyValue) {
		try (OutputStream outputStream = new FileOutputStream(this.propertyFile)) {

			Properties prop = new Properties();
			prop.setProperty(propertyName, propertyValue);
			prop.store(outputStream, "");

		} catch (IOException io) {
			io.printStackTrace();
		}
	}

	public ArrayList<Object> getKeys() {
		try (InputStream inputStream = new FileInputStream(this.propertyFile)) {

			Properties prop = new Properties();
			prop.load(inputStream);
			return Collections.list(prop.keys());

		} catch (IOException io) {
			io.printStackTrace();
			return null;
		}
	}

}

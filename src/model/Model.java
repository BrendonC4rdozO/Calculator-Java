package model;

import java.math.BigDecimal;

public class Model {

	private String[] tempArray;
	private String result = "";

	public String resultEquation(String equation) {

		tempArray = equation.split("(?=[-+*/()])|(?<=[^-+*/][-+*/])|(?<=[()])");

		if (tempArray[tempArray.length - 1] != "*") {
			for (int i = 0; i < tempArray.length; i++) {
				// Primeiro Mult e Divs

				if (tempArray[i].equals("*")) {
					tempArray[i + 1] = String
							.valueOf(Double.parseDouble(tempArray[i - 1]) * Double.parseDouble(tempArray[i + 1]));
					tempArray[i] = "";
					tempArray[i - 1] = "";
				} else if (tempArray[i].equals("/")) {
					tempArray[i + 1] = String
							.valueOf(Double.parseDouble(tempArray[i - 1]) / Double.parseDouble(tempArray[i + 1]));
					tempArray[i] = "";
					tempArray[i - 1] = "";
				}
			}

			equation = "";
			for (int i = 0; i < tempArray.length; i++) {
				equation = equation + tempArray[i];
			}
			tempArray = equation.split("(?=[-+*/()])|(?<=[^-+*/][-+*/])|(?<=[()])");

			for (int i = 0; i < tempArray.length; i++) {
				// Agora Soma e Subt

				if (tempArray[i].equals("+")) {
					tempArray[i + 1] = String
							.valueOf(Double.parseDouble(tempArray[i - 1]) + Double.parseDouble(tempArray[i + 1]));
					tempArray[i] = "";
					tempArray[i - 1] = "";
				} else if (tempArray[i].equals("-")) {
					tempArray[i + 1] = String
							.valueOf(Double.parseDouble(tempArray[i - 1]) - Double.parseDouble(tempArray[i + 1]));
					tempArray[i] = "";
					tempArray[i - 1] = "";
				}
			}

			result = "";
			for (int i = 0; i < tempArray.length; i++) {
				result = result + tempArray[i];
			}

			if (result.length() > 0) {
				result = String.valueOf(Float.parseFloat(result));
			}
		}

		return result;

	}

}

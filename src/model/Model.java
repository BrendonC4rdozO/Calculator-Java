package model;

public class Model {

	// private String[] tempArrayX;
	private String result = "";

	public String resultEquation(String equation) {

		String[] tempArray;
		StringBuilder newEquation = new StringBuilder("");
		int countPrth = 0;
		String equationPrth = "";

		tempArray = equation.split("(?=[-+*/()])|(?<=[^-+*/][-+*/])|(?<=[()])");

		for (int i = 0; i < tempArray.length; i++) {

			if (tempArray[i].equals("(")) {

				countPrth++;
				tempArray[i] = "";
				for (int j = (i + 1); j < tempArray.length; j++) {

					// Cocatenação
					newEquation.append(tempArray[j]);

					if (tempArray[j].equals("(")) {
						countPrth++;
					}
					if (tempArray[j].equals(")"))
						countPrth--;

					if (countPrth == 0) {
						newEquation.setLength(newEquation.length() - 1);
						equationPrth = resultEquation(newEquation.toString());
						tempArray[j] = equationPrth;
						System.out.println(newEquation.toString());
						break;
					} else
						tempArray[j] = "";
				}
			}
		}

		equation = "";
		for (int i = 0; i < tempArray.length; i++) {
			equation = equation + tempArray[i];
		}
		
		tempArray = equation.split("(?=[-+*/()])|(?<=[^-+*/][-+*/])|(?<=[()])");

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

		return result;

	}

}

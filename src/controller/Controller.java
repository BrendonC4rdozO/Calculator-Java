package controller;

import model.Model;
import view.View;

public class Controller {

	public static void main(String[] args) {

		new View();
	
	}

	public String counEquation(String equation) {

		Model model = new Model();

		return model.resultEquation(equation);

	}

}

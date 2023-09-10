package entities;

import entities.enums.Color;

public abstract class Shape { 
	//classes abstratas nao podem ser instanciadas
	private Color color;
	
	public Shape() {
	}
	
	public Shape(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public abstract double area();
		//metodos abstratos nao possuem implementação
		//metodos abstratos obrigatoriamente fazem parte de uma classe abstrata
}

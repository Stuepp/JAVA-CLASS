package exercicio1.aula2.dados;

public class Pessoa {
	//Atributos
	private int age;
	private String name;
	private float height;
	private float weight;
	//Gettes and Setters
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public float getHeight() {
		return height;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public float getWeight() {
		return weight;
	}
	//métodos
	public float calculate_imc(float height, float weight) {
		float imc = (float) (this.weight / Math.pow(this.height,2));
		return imc;
	}
	public String toString() {
		return "Name: "+name +"Age: "+age 
				+"Height: "+height +"Weight: "+weight
				+"IMC: "+ calculate_imc(height, weight);
	}
}

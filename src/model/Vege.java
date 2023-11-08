package model;

public class Vege extends Food{

	public Vege(String name, String dish,String type, int price, String side,String id) {
		super(name, dish,type, price, side,id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int Hitung() {
		 int price = 0;
		 if (side.equalsIgnoreCase("Potato")) {
			price += getName().length() * 2000;
		}else if (side.equalsIgnoreCase("Tomato")) {
			price += getName().length() * 1000;
		} 
		return dprice() + price + getPrice();
	}

}

package model;

public class NonVege extends Food {
	public String add;
	public NonVege(String name, String dish, String type,int price, String side,String id,String add) {
		super(name, dish,type, price, side,id);
		this.add = add;
	}
	@Override
	public int Hitung() {
		int aprice = 0;
		
		if (add.equalsIgnoreCase("Meatballs")) {
			aprice += 4000;
		}else if (add.equalsIgnoreCase("Fishballs")) {
			aprice += 3000;
		}else if (add.equalsIgnoreCase("Fried Potato")) {
			aprice += 5000;
		}
		
		int price = 0;
		if (side.equalsIgnoreCase("Beef")) {
			price += getName().length()* 2500;
		}else if (side.equalsIgnoreCase("Chicken")) {
			price += getName().length() * 1000;
		}else if (side.equalsIgnoreCase("Pork")) {
			price += getName().length() * 2000;
		}
		return getPrice() + price + aprice + dprice() ;
	}

}

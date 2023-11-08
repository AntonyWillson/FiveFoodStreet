package model;

public abstract class Food {
	protected String name;
	protected String dish;
	protected String type;
	protected int price;
	protected String side;
	protected String id;
	
	public Food(String name, String dish,String type, int price, String side,String id) {
		super();
		this.name = name;
		this.dish = dish;
		this.type = type;
		this.price = price;
		this.side = side;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDish() {
		return dish;
	}
	public void setDish(String dish) {
		this.dish = dish;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getSide() {
		return side;
	}
	public void setSide(String side) {
		this.side = side;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public abstract int Hitung();
	
	public int dprice() {
		if (dish.equals("Rice")) {
			return 5000;
		}else if (dish.equals("Noodle")) {
			return 3000;
		}
		return 0;
	}
	
	
}

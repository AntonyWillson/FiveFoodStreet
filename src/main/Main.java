package main;

import java.util.ArrayList;
import java.util.Scanner;

import model.Food;
import model.NonVege;
import model.Vege;

public class Main {
	Scanner s = new Scanner(System.in);
	ArrayList<Food> foodList = new ArrayList<>();
	
	int i= 1;
	public Main() {
		while (true) {
			System.out.println("Five Food Street");
			System.out.println("=====================");
			System.out.println("1. Insert New Menu");
			System.out.println("2. View All Menu");
			System.out.println("3. Sekk Menu Item");
			System.out.println("4. Exit");
			int choose;
			do {
				try {
					System.out.print(">>> ");
					choose = s.nextInt();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					choose = 0;
				}
				s.nextLine();
			} while (choose < 1 || choose > 4);
			switch (choose) {
			case 1:
				menu1();
				break;
			case 2:
				menu2();
				break;
			case 3:
				menu3();
				break;
			case 4:
				System.exit(0);
				break;
			}
		}
	}
	
	void menu1() {
		String name;
		do {
			System.out.print("Input name : ");
			name = s.nextLine();
		} while (name.length() < 8 || name.length() > 20);
		
		String main;
		do {
			System.out.print("Input main dish : ");
			main = s.nextLine();
		} while (!main.equalsIgnoreCase("Rice") && !main.equalsIgnoreCase("Noodle"));
		
		String type;
		do {
			System.out.print("Input type : ");
			type = s.nextLine();
		} while (!type.equals("Vege") && !type.equals("Non-Vege"));
		
		int price;
		do {
			System.out.print("Input base price : ");
			try {
				price = s.nextInt();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				price = 1;
			}s.nextLine();
		} while (price < 5000 || price > 25000 || price % 1000 != 0);
		
		if (type.equals("Vege")) {
			String side;
			do {
				System.out.print("Input side dish : ");
				side = s.nextLine();
			} while (!side.equalsIgnoreCase("Potato") && !side.equalsIgnoreCase("Tomato"));	
			String id = String.format("VV%03d",(i));
			i++;
			Food v = new Vege(name, main,type, price, side, id);
			foodList.add(v);
			
			System.out.println("Vege food added succesfully");
		} else if (type.equals("Non-Vege")) {
			String side;
			do {
				System.out.print("Input side dish : ");
				side = s.nextLine();
			} while (!side.equalsIgnoreCase("Beef") && !side.equalsIgnoreCase("Chicken") && !side.equalsIgnoreCase("Pork"));
			
			String add;
			do {
				System.out.print("Input add ons : ");
				add = s.nextLine();
			} while (!add.equalsIgnoreCase("Meatballs") && !add.equalsIgnoreCase("Fishballs") && !add.equalsIgnoreCase("Fried Potato"));
			
			String id = String.format("NV%03d", (i));
			i++;
			Food n = new NonVege(name, main,type, price, side, id, add);
			foodList.add(n);
			System.out.println("Vege food added succesfully");
		}
	}
	
	void menu2() {
		if (foodList.isEmpty()) {
			System.out.print("Kosong! ");
			System.out.println(" ");
		}else {
			System.out.println("========================================================");
			System.out.printf("|%-5s|%-5s|%-20s|%-10s|%-10s|\n","No","ID","Name","Price","Type");
			System.out.println("========================================================");
			for (int i = 0; i < foodList.size(); i++) {
				Food f = foodList.get(i);
				System.out.printf("|%-5s|%-5s|%-20s|%-10s|%-10s|\n",(i+1),f.getId(),f.getName(),f.Hitung(),f.getType());
			}
		}
	}
	
	void menu3() {
		if (foodList.isEmpty()) {
			System.out.println("Kosong");
		}else {
			System.out.println("========================================================");
			System.out.printf("|%-5s|%-5s|%-20s|%-10s|%-10s|\n","No","ID","Name","Price","Type");
			System.out.println("========================================================");
			for (int i = 0; i < foodList.size(); i++) {
				Food f = foodList.get(i);
				System.out.printf("|%-5s|%-5s|%-20s|%-10s|%-10s|\n",(i+1),f.getId(),f.getName(),f.Hitung(),f.getType());
		}
			int choose,quantity;
			do {
				System.out.print("Input number [1 - " + foodList.size() + "] : ");
				try {
					choose = s.nextInt();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					choose = -1;
				}
				s.nextLine();
			} while (choose < 0 || choose > foodList.size());
			
			do {
				System.out.print("Input Quantiy : ");
				try {
					quantity = s.nextInt();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					quantity = -1;
				}
				s.nextLine();
			} while (choose < 0 );
			
			System.out.println("ID: "+foodList.get(choose -1).getId());
			System.out.println("Menu name : "+foodList.get(choose -1).getName());
			System.out.println("Main Dish: "+foodList.get(choose -1).getDish());
			System.out.println("Price : "+foodList.get(choose -1).Hitung());
			System.out.println("Grand Total: "+foodList.get(choose -1).Hitung() * quantity);
			
			System.out.println(" ");
			System.out.println(" ");
			System.out.println(" ");
			System.out.println("Food Sold");
			foodList.remove(choose -1);
			
		}
	}

	public static void main(String[] args) {
		new Main();

	}

}

interface Food { // 食物
	public abstract int getWeight();
}

class Deer implements Food { // 鹿
	public Deer(int w) {
		weight = w;
	}

	public int getWeight() {
		return weight;
	}

	private int weight;
}

interface Dragon { // 龍
	public abstract int eat(Food food);
};

class Dinosaur implements Dragon { // 恐龍
	public Dinosaur() {
		quantity = 0;
	}

	public int eat(Food f) {
		quantity += f.getWeight();
		return quantity;
	}

	private int quantity;
};

class Tyrannosaurus extends Dinosaur { // 暴龍
	public Tyrannosaurus(Food f) {
		food = f;
	}

	public String hunt(Food f) {
		eat(food);
		food = f;
		int q = eat(f);
		return food.getWeight() + ":" + q;
	}

	private Food food;
};

public class Hunt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Food f1 = new Deer(3);
		Food f2 = new Deer(5);
		//Dragon d1 = new Dragon(); //程式問題
		Dragon d2 = new Dinosaur();
		Dragon t1 = new Tyrannosaurus(f1);
		Tyrannosaurus t2 = new Tyrannosaurus(f1);
		System.out.println("Dinosaur eat: "+d2.eat(f1));
		//System.out.println("Tyrannosaurus eat: "+t1.hunt(f2)); //程式問題
		System.out.println("Tyrannosaurus eat: "+t2.hunt(f2));


	}

}

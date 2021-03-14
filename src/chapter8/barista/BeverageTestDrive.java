package chapter8.barista;

public class BeverageTestDrive {
	public static void main(String[] args) {
 
		Tea tea = new Tea();
		Coffee coffee = new Coffee();
 
		System.out.println("\nMaking tea...");
		tea.prepareRecipe();
 
		System.out.println("\nMaking coffee...");
		coffee.prepareRecipe();

 
		TeaWithHook teaHook = new TeaWithHook();
		CoffeeWithHook coffeeHook = new CoffeeWithHook();

		teaHook.prepareRecipe();
		System.out.println("\nMaking tea...");

		System.out.println("\nMaking coffee...");
		coffeeHook.prepareRecipe();
	}
}

package com.candemirhan.recipeapp.server.dbo.init;

import com.candemirhan.recipeapp.server.controller.AllergenController;
import com.candemirhan.recipeapp.server.controller.IngredientController;
import com.candemirhan.recipeapp.server.controller.RecipeController;
import com.candemirhan.recipeapp.server.controller.RecipeIngredientController;
import com.candemirhan.recipeapp.server.controller.RecipeTagController;
import com.candemirhan.recipeapp.server.controller.RecipeTypeController;
import com.candemirhan.recipeapp.server.controller.RoleController;
import com.candemirhan.recipeapp.server.controller.StepController;
import com.candemirhan.recipeapp.server.controller.TagController;
import com.candemirhan.recipeapp.server.controller.UnitController;
import com.candemirhan.recipeapp.server.controller.UserController;
import com.candemirhan.recipeapp.server.controller.UserRoleController;
import com.candemirhan.recipeapp.server.dbo.Allergen;
import com.candemirhan.recipeapp.server.dbo.Ingredient;
import com.candemirhan.recipeapp.server.dbo.Recipe;
import com.candemirhan.recipeapp.server.dbo.RecipeIngredient;
import com.candemirhan.recipeapp.server.dbo.RecipeTag;
import com.candemirhan.recipeapp.server.dbo.RecipeType;
import com.candemirhan.recipeapp.server.dbo.Role;
import com.candemirhan.recipeapp.server.dbo.Step;
import com.candemirhan.recipeapp.server.dbo.Tag;
import com.candemirhan.recipeapp.server.dbo.Unit;
import com.candemirhan.recipeapp.server.dbo.User;
import com.candemirhan.recipeapp.server.dbo.UserRole;

public class InitiazeData {

	public static void main(String[] args) {
				
		AllergenController         allergenController         = new AllergenController();
		IngredientController       ingredientController       = new IngredientController();
		StepController             stepController             = new StepController();
		RecipeController           recipeController           = new RecipeController();
		RecipeTypeController       recipeTypeController       = new RecipeTypeController();
		UnitController             unitController             = new UnitController();
		RecipeIngredientController recipeIngredientController = new RecipeIngredientController();
		UserController             userController             = new UserController();
		RoleController             roleController             = new RoleController();
		UserRoleController         userRoleController         = new UserRoleController();
		TagController              tagController              = new TagController();
		RecipeTagController        recipeTagController        = new RecipeTagController();
		
		Allergen allergen1 = new Allergen("Süt");
		Allergen allergen2 = new Allergen("Yumurta");
		Allergen allergen3 = new Allergen("Fındık");
		Allergen allergen4 = new Allergen("Yer Fıstığı");
		Allergen allergen5 = new Allergen("Fıstık");
		Allergen allergen6 = new Allergen("Buğday");
		Allergen allergen7 = new Allergen("Ceviz");
		Allergen allergen8 = new Allergen("Soya");
		Allergen allergen9 = new Allergen("Gluten");
		Allergen allergen10 = new Allergen("Balık");
		Allergen allergen11 = new Allergen("Avenin");
		Allergen allergen12 = new Allergen("Kabuklu Deniz Ürünleri");
		
		Ingredient ingredient1 = new Ingredient("Tavuk");
		Ingredient ingredient2 = new Ingredient("Prinç");
		Ingredient ingredient3 = new Ingredient("Bulgur");
		Ingredient ingredient4 = new Ingredient("Bonfile");
		Ingredient ingredient5 = new Ingredient("Buğday");
		Ingredient ingredient6 = new Ingredient("Mercimek");
		Ingredient ingredient7 = new Ingredient("Bulgur");
		Ingredient ingredient8 = new Ingredient("Un");
		Ingredient ingredient9 = new Ingredient("Tuz");
		Ingredient ingredient10 = new Ingredient("Biber");
		Ingredient ingredient11 = new Ingredient("Havuç");
		Ingredient ingredient12 = new Ingredient("Domates");
		Ingredient ingredient13 = new Ingredient("Soğan");
		Ingredient ingredient14 = new Ingredient("Bamya");
		Ingredient ingredient15 = new Ingredient("Yeşil Biber");
		Ingredient ingredient16 = new Ingredient("Barbunya");
		Ingredient ingredient17 = new Ingredient("Zeytinyağı");
		Ingredient ingredient18 = new Ingredient("Sıvı Yağ");
		Ingredient ingredient19 = new Ingredient("Sucuk");
		Ingredient ingredient20 = new Ingredient("Kıyma");
		Ingredient ingredient21 = new Ingredient("Tereyağ");
		
		Step step1 = new Step(1, "Soğanları Doğra", 1, "Dakika");
		Step step2 = new Step(2, "Soğanları Kavur", 10, "Dakika");
		Step step3 = new Step(3, "Bulguru Kavur", 10, "Dakika");
		Step step4 = new Step(4, "Pişir", 30, "Dakika");
		
		Recipe recipe1 = new Recipe("Bulgur Pilavı", "Soğanlı Bulgur Pilavı", 4, 150, true);
		Recipe recipe2 = new Recipe("Pirinç Pilavı", "Şehriyeli Pirin. Pilavı", 4, 165, true);
		
		RecipeType rtype1 = new RecipeType("Vegan");
		RecipeType rtype2 = new RecipeType("Vejeteryan");
		RecipeType rtype3 = new RecipeType("Et Sevenlere");
		RecipeType rtype4 = new RecipeType("Deniz Mahsülü");
		RecipeType rtype5 = new RecipeType("Glutensiz");
		
		Unit unit1 = new Unit("Aldığı Kadar");
		Unit unit2 = new Unit("Tutam");
		Unit unit3 = new Unit("Milimetre");
		Unit unit4 = new Unit("Çay Kaşığı");
		Unit unit5 = new Unit("Çorba Kaşığı");
		Unit unit6 = new Unit("Su Bardağı");
		Unit unit7 = new Unit("Fincan");
		Unit unit8 = new Unit("Çay Bardağı");
		Unit unit9 = new Unit("Gram");
		Unit unit10 = new Unit("Litre");
		
		RecipeIngredient recipeIngredient1 = new RecipeIngredient(2);
		RecipeIngredient recipeIngredient2 = new RecipeIngredient(1);
		RecipeIngredient recipeIngredient3 = new RecipeIngredient(150);
		RecipeIngredient recipeIngredient4 = new RecipeIngredient(100);
		
		User user1 = new User("Berna Baykan", "Dere");
		User user2 = new User("Can", "Demirhan");
		User user3 = new User("Semih", "Biyiğit");
		User user4 = new User("Elif", "Yıldırım");
		User user5 = new User("Eralp", "Nitelik");
		User user6 = new User("Gözde Saygılı", "Yalçın");
		User user7 = new User("Hande", "Hüdaioğlu");
		User user8 = new User("Olgu", "Başak");
		User user9 = new User("Olgu", "Başak");
		User user10 = new User("Recep", "Kabakçı");
		User user11 = new User("Talha", "Çamlıca");
		User user12 = new User("Veysel Karani", "Yazıcı");
		User user13 = new User("Yusuf", "Yardımcıel");
		User user14 = new User("Babür", "Somer");
		
		Role role1 = new Role("Super Admin");
		Role role2 = new Role("Admin");
		Role role3 = new Role("User");
		Role role4 = new Role("Cordon Blue");
		
		Tag tag1 = new Tag("Super", "Çok Leziz");
		Tag tag2 = new Tag("Yeme de yanında yat", "Harika");
		Tag tag3 = new Tag("Kahvaltılık", "Kahvaltıda yenir");
		Tag tag4 = new Tag("Amanıınnn", "Uzak dur");
		Tag tag5 = new Tag("Çay vakti", "Çayın yanına iyi gider");
		
		RecipeTag recipeTag1 = new RecipeTag();
		RecipeTag recipeTag2 = new RecipeTag();
		RecipeTag recipeTag3 = new RecipeTag();
		RecipeTag recipeTag4 = new RecipeTag();
		
		UserRole userRole1 = new UserRole();
		UserRole userRole2 = new UserRole();
		UserRole userRole3 = new UserRole();
		UserRole userRole4 = new UserRole();
		UserRole userRole5 = new UserRole();
		UserRole userRole6 = new UserRole();
		UserRole userRole7 = new UserRole();
		UserRole userRole8 = new UserRole();
		UserRole userRole9 = new UserRole();
		UserRole userRole10 = new UserRole();
		UserRole userRole11 = new UserRole();
		UserRole userRole12 = new UserRole();
		UserRole userRole13 = new UserRole();
		UserRole userRole14 = new UserRole();
		UserRole userRole15 = new UserRole();
		UserRole userRole16 = new UserRole();
		UserRole userRole17 = new UserRole();
		UserRole userRole18 = new UserRole();
		
		// User Role
		
		user3.addRecipeTagSet(recipeTag1);
		user4.addRecipeTagSet(recipeTag2);
		user7.addRecipeTagSet(recipeTag3);
		user6.addRecipeTagSet(recipeTag4);
		
		tag1.addRecipeTagSet(recipeTag1);
		tag2.addRecipeTagSet(recipeTag2);
		tag1.addRecipeTagSet(recipeTag3);
		tag5.addRecipeTagSet(recipeTag4);
		
		recipeTag1.setUser(user3);
		recipeTag1.setTag(tag1);
		recipeTag2.setUser(user4);
		recipeTag2.setTag(tag2);
		recipeTag3.setUser(user7);
		recipeTag4.setTag(tag1);
		recipeTag4.setUser(user6);
		recipeTag4.setTag(tag5);
		
		
		user1.addUserRoleSet(userRole1);
		user2.addUserRoleSet(userRole2);
		user2.addUserRoleSet(userRole3);
		user3.addUserRoleSet(userRole4);
		user4.addUserRoleSet(userRole5);
		user5.addUserRoleSet(userRole6);
		user6.addUserRoleSet(userRole7);
		user7.addUserRoleSet(userRole8);
		user7.addUserRoleSet(userRole9);
		user8.addUserRoleSet(userRole10);
		user9.addUserRoleSet(userRole11);
		user10.addUserRoleSet(userRole12);
		user11.addUserRoleSet(userRole13);
		user12.addUserRoleSet(userRole14);
		user13.addUserRoleSet(userRole15);
		user14.addUserRoleSet(userRole16);
		user14.addUserRoleSet(userRole17);
		user14.addUserRoleSet(userRole18);
		
		role1.addUserRoleSet(userRole1);
		role1.addUserRoleSet(userRole16);
		role2.addUserRoleSet(userRole9);
		role2.addUserRoleSet(userRole17);
		role3.addUserRoleSet(userRole2);
		role3.addUserRoleSet(userRole4);
		role3.addUserRoleSet(userRole5);
		role3.addUserRoleSet(userRole6);
		role3.addUserRoleSet(userRole7);
		role3.addUserRoleSet(userRole8);
		role3.addUserRoleSet(userRole10);
		role3.addUserRoleSet(userRole11);
		role3.addUserRoleSet(userRole12);
		role3.addUserRoleSet(userRole13);
		role3.addUserRoleSet(userRole14);
		role3.addUserRoleSet(userRole15);
		role3.addUserRoleSet(userRole18);
		role4.addUserRoleSet(userRole3);
		
		userRole1.setUser(user1);
		userRole1.setRole(role1);
		userRole2.setUser(user2);
		userRole2.setRole(role3);
		userRole3.setUser(user2);
		userRole3.setRole(role4);
		userRole4.setUser(user3);
		userRole4.setRole(role3);
		userRole5.setUser(user4);
		userRole5.setRole(role3);
		userRole6.setUser(user5);
		userRole6.setRole(role3);
		userRole7.setUser(user6);
		userRole7.setRole(role3);
		userRole8.setUser(user7);
		userRole8.setRole(role3);
		userRole9.setUser(user7);
		userRole9.setRole(role2);
		userRole10.setUser(user8);
		userRole10.setRole(role3);
		userRole11.setUser(user9);
		userRole11.setRole(role3);
		userRole12.setUser(user10);
		userRole12.setRole(role3);
		userRole13.setUser(user11);
		userRole13.setRole(role3);
		userRole14.setUser(user12);
		userRole14.setRole(role3);
		userRole15.setUser(user13);
		userRole15.setRole(role3);
		userRole16.setUser(user14);
		userRole16.setRole(role1);
		userRole17.setUser(user14);
		userRole17.setRole(role2);
		userRole18.setUser(user14);
		userRole18.setRole(role3);
		
		// User Tag
		
		
		
		// Allergen Ingredient
		
		ingredient1.addAllergens(allergen1);
		ingredient1.addAllergens(allergen8);
		ingredient3.addAllergens(allergen12);
		ingredient3.addAllergens(allergen8);
		ingredient3.addAllergens(allergen10);
		ingredient4.addAllergens(allergen11);
		ingredient7.addAllergens(allergen6);
		ingredient7.addAllergens(allergen7);
		ingredient7.addAllergens(allergen11);
		ingredient20.addAllergens(allergen3);
		ingredient20.addAllergens(allergen4);
		ingredient20.addAllergens(allergen7);
		ingredient19.addAllergens(allergen6);
		ingredient19.addAllergens(allergen9);
		
		recipe1.addRecipeIngredientSet(recipeIngredient1);
		recipe1.addRecipeIngredientSet(recipeIngredient2);
		recipe1.addRecipeIngredientSet(recipeIngredient3);
		recipe1.addRecipeIngredientSet(recipeIngredient4);
		
		unit6.addRecipeIngredients(recipeIngredient1);
		unit1.addRecipeIngredients(recipeIngredient2);
		unit9.addRecipeIngredients(recipeIngredient3);
		unit9.addRecipeIngredients(recipeIngredient4);
		
		ingredient3.addRecipeIngredients(recipeIngredient1);
		ingredient9.addRecipeIngredients(recipeIngredient2);
		ingredient13.addRecipeIngredients(recipeIngredient3);
		ingredient21.addRecipeIngredients(recipeIngredient4);
		
		tagController.create(tag1);
		tagController.create(tag2);
		tagController.create(tag3);
		tagController.create(tag4);
		tagController.create(tag5);
		
		step1.setRecipe(recipe1);
		step2.setRecipe(recipe1);
		step3.setRecipe(recipe1);
		step4.setRecipe(recipe1);
		
		recipe1.addStepSet(step1);
		recipe1.addStepSet(step2);
		recipe1.addStepSet(step3);
		recipe1.addStepSet(step4);
		
		rtype5.addRecipes(recipe1);
		rtype5.addRecipes(recipe2);
		
		recipe1.setRecipeType(rtype5);
		recipe2.setRecipeType(rtype5);
		
		recipeIngredient1.setRecipe(recipe1);
		recipeIngredient1.setIngredient(ingredient3);
		recipeIngredient1.setUnit(unit6);
		recipeIngredient2.setRecipe(recipe1);
		recipeIngredient2.setIngredient(ingredient9);
		recipeIngredient2.setUnit(unit1);
		recipeIngredient3.setRecipe(recipe1);
		recipeIngredient3.setIngredient(ingredient13);
		recipeIngredient3.setUnit(unit9);
		recipeIngredient4.setRecipe(recipe1);
		recipeIngredient4.setIngredient(ingredient21);
		recipeIngredient4.setUnit(unit9);
		
		unitController.create(unit1);
		unitController.create(unit2);
		unitController.create(unit3);
		unitController.create(unit4);
		unitController.create(unit5);
		unitController.create(unit6);
		unitController.create(unit7);
		unitController.create(unit8);
		unitController.create(unit9);
		unitController.create(unit10);
		
		recipeTypeController.create(rtype1);
		recipeTypeController.create(rtype2);
		recipeTypeController.create(rtype3);
		recipeTypeController.create(rtype4);
		recipeTypeController.create(rtype5);
				
		allergenController.create(allergen1);
		allergenController.create(allergen2);
		allergenController.create(allergen3);
		allergenController.create(allergen4);
		allergenController.create(allergen5);
		allergenController.create(allergen6);
		allergenController.create(allergen7);
		allergenController.create(allergen8);
		allergenController.create(allergen9);
		allergenController.create(allergen10);
		allergenController.create(allergen11);
		allergenController.create(allergen12);
		
		
		ingredientController.create(ingredient1);
		ingredientController.create(ingredient2);
		ingredientController.create(ingredient3);
		ingredientController.create(ingredient4);
		ingredientController.create(ingredient5);
		ingredientController.create(ingredient6);
		ingredientController.create(ingredient7);
		ingredientController.create(ingredient8);
		ingredientController.create(ingredient9);
		ingredientController.create(ingredient10);
		ingredientController.create(ingredient11);
		ingredientController.create(ingredient12);
		ingredientController.create(ingredient13);
		ingredientController.create(ingredient14);
		ingredientController.create(ingredient15);
		ingredientController.create(ingredient16);
		ingredientController.create(ingredient17);
		ingredientController.create(ingredient18);
		ingredientController.create(ingredient19);
		ingredientController.create(ingredient20);
		ingredientController.create(ingredient21);
		

		recipeController.create(recipe1);
		recipeController.create(recipe2);
		
		
		stepController.create(step1);
		stepController.create(step2);
		stepController.create(step3);
		stepController.create(step4);
	
		recipeIngredientController.create(recipeIngredient1);
		recipeIngredientController.create(recipeIngredient2);
		recipeIngredientController.create(recipeIngredient3);
		recipeIngredientController.create(recipeIngredient4);	
		
		roleController.create(role1);
		roleController.create(role2);
		roleController.create(role3);
		roleController.create(role4);
		
		userController.create(user1);
		userController.create(user2);
		userController.create(user3);
		userController.create(user4);
		userController.create(user5);
		userController.create(user6);
		userController.create(user7);
		userController.create(user8);
		userController.create(user9);
		userController.create(user10);
		userController.create(user11);
		userController.create(user12);
		userController.create(user13);
		userController.create(user14);
		
		userRoleController.create(userRole1);
		userRoleController.create(userRole2);
		userRoleController.create(userRole3);
		userRoleController.create(userRole4);
		userRoleController.create(userRole5);
		userRoleController.create(userRole6);
		userRoleController.create(userRole7);
		userRoleController.create(userRole8);
		userRoleController.create(userRole9);
		userRoleController.create(userRole10);
		userRoleController.create(userRole11);
		userRoleController.create(userRole12);
		userRoleController.create(userRole13);
		userRoleController.create(userRole14);
		userRoleController.create(userRole15);
		userRoleController.create(userRole16);
		userRoleController.create(userRole17);
		userRoleController.create(userRole18);
		
		recipeTagController.create(recipeTag1);
		recipeTagController.create(recipeTag2);
		recipeTagController.create(recipeTag3);
		recipeTagController.create(recipeTag4);
	}
}

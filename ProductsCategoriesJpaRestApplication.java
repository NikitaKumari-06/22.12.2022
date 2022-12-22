/*
 * 1.	Write a program by using spring boot data jap REST for the following requirements

1.	Create table categories and products with the following structures.

categories
	id int(11) unsigned not null, and the same column is the primary key
	name nvarchar(50) not null
	description nvarchar(100)

products
	id int(11) unsigned not null, and the same column is the primary key
	name nvarchar(50) not null
	price double not null
	unitsInStock int (at present how many units are there?)
	discontinued bool(whether the product is still doing business or not)
	category_id int(11) (foreign key to categories(id))

2.	Create a spring core application to achieve the following requirements

CategoryRepository

public void save(Category category);

public Category getById(int id);
// select * from categories where id=1;
	
public void update(Category category);
	
public void deleteById(int id);

public List<Category> getAll();

public Category getByName(String name);

// select * from Categories where name = ‘Beverages’;

public List<Category> getByNames(String substring);

//select * from Categories where name like ‘Con%’;


===========================================================================

ProductRepository

public void save(Product product);

public Product getById(int id);
	
public void update(Product product);
	
public void deleteById(int id);

public List< Product > getAll();

public Product getByName(String name);

public List< Product > getByNames(String substring);


public List<Product> getByBetweenPrice(double iPrice, double oPrice);
// select * from products where price between 300 and 1200;

public List<Product> getDiscontinuedProducts();

3.	Write some methods by @Query() and @Query() with nativeQuery = true

4.	Implement sorting and paging.

 */
package com.project.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.project.demo.controller.CategoryController;
import com.project.demo.controller.ProductController;
import com.project.demo.model.Category;
import com.project.demo.model.Product;

@SpringBootApplication
public class ProductsCategoriesJpaRestApplication implements CommandLineRunner {
	
	@Autowired
	private ProductController productController;
	
	@Autowired
	private CategoryController categoryController;

	public static void main(String[] args) {
		SpringApplication.run(ProductsCategoriesJpaRestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("\n\n Data of Products Entity\n\n");
		addProducts(createProducts());
		
		System.out.println("\n\n Data of Categories Entity\n\n");
		addCategories(createCategories());
	}

	//method to add Product
	private void addProducts(List<Product> products) {
		for(Product product : products) {	
			productController.save(product);
		}
	}
	
	//method to create List of Product
	private List<Product> createProducts(){
		List<Product> products = new ArrayList<Product>();
		
		Product p1 = new Product("Kit-Kat", 25, 50, false, null);
		
		Product p2 = new Product("Choco Jewels", 5, 200, false, null);
		
		Product p3 = new Product("Burbon",25,30,false,null);
		
		Product p4 = new Product("Butter Bake",5,70,false,null);
		
		Product p5 = new Product("Saree",2400,300,false,null);
		
		Product p6 = new Product("Sharara",5000,20,true,null);
		
		Product p7 = new Product("Sherwaani",12000,80,false,null);
		
		Product p8 = new Product("Boots for women",1000,86,false,null);
		
		Product p9 = new Product("Ankle shoes",1200,63,true,null);
		
		Product p10 = new Product("Oreo",20,50,false,null);
		
		Product p11 = new Product("Dairy Milk",80,20,false,null);
		
		Product p12 = new Product("Sandals",2500,115,false,null);
		
	
		products.add(p1);
		products.add(p2);
		products.add(p3);
		products.add(p4);
		products.add(p5);
		products.add(p6);
		products.add(p7);
		products.add(p8);
		products.add(p9);
		products.add(p10);
		products.add(p11);
		products.add(p12);
		
		return products;
	}

	//method to add Category
	private void addCategories(List<Category> categories) {
		for(Category category : categories) {	
			categoryController.save(category);
		}
	}
	
	//method to create List of Category
	private List<Category> createCategories(){
		List<Category> categories = new ArrayList<Category>();
		
		Category c1 = new Category("Chocolates", "Sweet and delicious delicacy", null);
		
		Category c2 = new Category("Biscuits", "Sweet-salty and crispy cookies", null);
		
		Category c3 = new Category("Ethenic Wear", "Suitable for all occasions", null);
		
		Category c4 = new Category("Footwear", "rough-tough and durable", null);
		
		categories.add(c1);
		categories.add(c2);
		categories.add(c3);
		categories.add(c4);
		
		return categories;
	}
}

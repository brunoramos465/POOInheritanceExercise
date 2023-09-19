package Application;

import java.util.Scanner;
import java.util.Locale;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;

import Entities.ImportedProduct;
import Entities.Product;
import Entities.UsedProduct;

public class Program {
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
			
		List<Product> list = new ArrayList<>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for(int i = 1 ; i <= n; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Commom, used or imported (c/u/i)? ");
			char type = sc.next().charAt(0);
			
			System.out.print("Name: ");
			String name = sc.next();
			
			System.out.print("Price: ");
			Double price = sc.nextDouble();
					
			if (type == 'i') {
				System.out.print("Customs fee:");
				Double customsFee = sc.nextDouble();
				
				Product imported = new ImportedProduct(name, price, customsFee);
				
				list.add(imported);
						
			} else if (type == 'u'){
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				String manufactureString = sc.next();
				Date manufacture = sdf.parse(manufactureString);
				
				Product used = new UsedProduct(name,price,manufacture);
				
				list.add(used);
				
			} else if(type == 'c') {
				 Product product = new Product(name,price);	
				list.add(product);
			}
			     
		}
		
		System.out.println("PRICE TAGS");
		for(Product product : list) {
			System.out.println(product.priceTag());
		}	
				
		sc.close();
	}
	

}

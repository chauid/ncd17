package day1212;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class baseIO {
	public static class Product {
		public String name;
		public int count;
		public int price;

		public Product(String name, int count, int price) {
			this.name = name;
			this.count = count;
			this.price = price;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int totalPrice = 0;
		int totalCount = 0;

		List<Product> productList = new ArrayList<Product>();
		String name_buffer = "";
		int count_buffer = 0;
		int price_buffer = 0;

		while (true) {
			System.out.print("상품 추가하기(y/n): ");
			name_buffer = sc.next();
			if (name_buffer.equals("n") || name_buffer.equals("N")) {
				sc.close();
				break;
			}

			System.out.print("상품명: ");
			name_buffer = sc.next();

			while (true) {
				try {
					System.out.print("수량: ");
					count_buffer = sc.nextInt();
					break;
				} catch (InputMismatchException e) {
					System.out.println("수량은 숫자만 입력가능합니다.");
					sc.nextLine();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
			totalCount += count_buffer;

			while (true) {
				try {
					System.out.print("가격: ");
					price_buffer = sc.nextInt();
					break;
				} catch (InputMismatchException e) {
					System.out.println("가격은 숫자만 입력가능합니다.");
					sc.nextLine();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
			totalPrice += price_buffer * count_buffer;
			productList.add(new Product(name_buffer, count_buffer, price_buffer));
		}

		HashMap<String, Product> productMap = new HashMap<String, Product>();
		for (Iterator<Product> iterator = productList.iterator(); iterator.hasNext();) {
			Product product = (Product) iterator.next();
			if (productMap.containsKey(product.name)) {
				Product value = productMap.get(product.name);
				int avgPrice = (value.count * value.price + product.count * product.price) / (value.count + product.count);
				productMap.replace(product.name, new Product(value.name, value.count + product.count, avgPrice));
			} else {
				productMap.put(product.name, new Product(product.name, product.count, product.price));
			}
		}

		System.out.println("====================================");
		System.out.println("상품 목록");
		System.out.println("------------------------------------");
		Set<String> keySet = productMap.keySet();
		for (String key : keySet) {
			Product product = productMap.get(key);
			System.out.println("상품명: " + product.name);
			System.out.println("수량: " + product.count);
			System.out.println("개당 가격: " + product.price);
			System.out.println("------------------------------------");
		}
		if (totalCount >= 5) {
			double resultPrice = (double)totalPrice / 10.0 * 9.0;
			System.out.printf("총 금액: %d원 -> %d원 (5개 이상 구매시 10%% 할인)\n", totalPrice, (int)resultPrice);
		} else {
			System.out.println("총 금액: " + totalPrice + "원");
		}
		System.out.println("====================================");
	}
}

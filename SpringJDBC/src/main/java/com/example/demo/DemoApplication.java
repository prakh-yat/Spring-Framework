package com.example.demo;
import java.util.Map;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	private Create create;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception{
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose option number:");
		System.out.println("1. Insert");
		System.out.println("2. Read");
		System.out.println("3. Update");
		System.out.println("4. Delete");
		int n = sc.nextInt();

		switch(n){
			case 1:
				System.out.println("Number of rows you wish to add?");
				int insert = sc.nextInt();
				for (int i = 0; i<insert; i++){
					String name = sc.next();
					String city = sc.next();
					this.create.insertData(name,city);
				}
				break;
			case 2:
				System.out.println("View\n1.Single\n2.Multiple");
				int choice = sc.nextInt();
				switch (choice){
					case 1:
						System.out.println("Number of rows you wish to read?");
						int read = sc.nextInt();

						for (int i = 0; i < read; i++) {
							System.out.println("Mention ID of the row you wish to see:");
							int id = sc.nextInt();
							Map<String, Object> result = this.create.readData(id);

							if (!result.isEmpty()) {
								System.out.println("Name: " + result.get("name"));
								System.out.println("City: " + result.get("city"));
								System.out.println();
							} else {
								System.out.println("No data found for the provided ID.");
							}
						}
						break;
					case 2:
						List<Map<String, Object>> rows = this.create.readAll();
						for (Map<String, Object> row : rows) {
							for (Map.Entry<String, Object> entry : row.entrySet()) {
								System.out.println(entry.getKey() + ": " + entry.getValue());
							}
							System.out.println();
						}

						break;
				}


				break;

			case 3:
				System.out.println("Number of rows you wish to update?");
				int update = sc.nextInt();
				for (int i = 0; i<update; i++){
							String name = sc.next();
							String city = sc.next();
							this.create.updateData(name,city);
				}
				break;
			case 4:
				System.out.println("Number of rows you wish to delete?");
				int delete = sc.nextInt();
				for (int i = 0; i<delete; i++) {
					int id = sc.nextInt();
					this.create.deleteData(id);
				}
				break;
		}


	}
}

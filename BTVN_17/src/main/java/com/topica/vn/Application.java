package com.topica.vn;

import com.topica.vn.model.Category;
import com.topica.vn.model.Item;
import com.topica.vn.service.CategoryService;
import com.topica.vn.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    CategoryService categoryService;

    @Autowired
    ItemService itemService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            System.out.println("Start : find categories by type name");
            System.out.print("Input name (vd : type1, type2 ) : ");
            String fType = ((new Scanner(System.in)).nextLine());
            List<Category> categories = categoryService.findByType(fType, 0, 3);
            for (Category category : categories) {
                System.out.println("Category's name : " + category.getName());
            }
        }catch (Exception e){
            System.err.println(e);
        }finally {
            System.out.println("End : find categories by type name");
            System.out.println("---------------------------------");
        }

        try {
            System.out.println("Start : find items by category’s name");
            System.out.print("Input name (vd : name1, name2 ) : ");
            String fName = ((new Scanner(System.in)).nextLine());
            List<Item> items = itemService.findByCategory(fName, 0, 3);
            for (Item i : items) {
                System.out.println("Item's name : " + i.getName());
            }
        }catch (Exception e){
            System.err.println(e);
        }finally {
            System.out.println("End : find items by category’s name");
            System.out.println("---------------------------------");
        }

        try {
            System.out.println("Start : updateCategory(Long id, String name)");
            System.out.printf("Update category");
            System.out.print("ID : ");
            long uId = ((new Scanner(System.in)).nextLong());
            System.out.print("Input name (vd : name1, name2 ) : ");
            String uName = ((new Scanner(System.in)).nextLine());
            categoryService.updateCategory(uId, uName);
        }catch (Exception e){
            System.err.println(e);
        }finally {
            System.out.println("End : updateCategory(Long id, String name)");
            System.out.println("---------------------------------");
        }

        System.out.println(">>> Finish, thanks a lot !");
    }
}

package com.example.many2many.service;

import com.example.many2many.entity.Order;
import com.example.many2many.entity.Product;
import com.example.many2many.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeService {

    public void getManyToManyInsert() throws ParseException {
        String[] arr = {"세탁기", "청소기"};
        
        List<Product> productList = new ArrayList<Product>();

        Order order = new Order();
        order.setOrderDate(new Date());

        for(int i = 0; i < 2; i++) {
            Product product = new Product();

            product.setName(arr[i]);
            productList.add(product);
            order.getProductList().add(product);
        }

        EmployeeRepository empRepo = new EmployeeRepository();
        empRepo.getManyToManyInsert(productList, order);
    }

    public void getManyToManyFind() {
        EmployeeRepository empRepo = new EmployeeRepository();
        empRepo.getManyToManyFind(1L);
    }
}

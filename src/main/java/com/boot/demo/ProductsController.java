package com.boot.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProductsController {

	@RequestMapping("/getProducts")
	public List<ProductData> getProducts()
	{
		ProductData product1 = new ProductData();
		product1.setCode("A00001");
		product1.setName("Pureit Ultima Mineral RO + UV");
		product1.setDesc("Pureit brings to you a water purifier that looks stunning and comes with an advanced RO + UV purification technology that not only gives you pure water but also adds minerals to enhance the taste of water.");
		
		RestTemplate restTemplate = new RestTemplate();
		
		
		String stockAndPriceUrl = "http://localhost:8023/getStockAndPrice";
		
		ResponseEntity<StockAndPriceData> resp = restTemplate.postForEntity(stockAndPriceUrl, product1.getCode(),StockAndPriceData.class);
		
		System.out.println("resp from StockAndPrice MS >> "+resp.getBody().getOfflineStock());
		
		product1.setStockAndPrice(resp.getBody());
		
		List<ProductData> dataList = new ArrayList<>();
		
		dataList.add(product1);
		
		return dataList;
	}
	
}

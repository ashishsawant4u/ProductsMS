package com.boot.demo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ProductsController {
	
	private static final Logger LOG = LoggerFactory.getLogger(ProductsController.class);
	
	@LoadBalanced
	@Bean
	public RestTemplate template() {
	    return new RestTemplate();
	}
	
	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getProductsFallbackImpl")
	@RequestMapping("/getProducts")
	public List<ProductData> getProducts()
	{
		LOG.info("inside getProducts...");
		
		
		ProductData product1 = new ProductData();
		product1.setCode("A00001");
		product1.setName("Pureit Ultima Mineral RO + UV");
		product1.setDesc("Pureit brings to you a water purifier that looks stunning and comes with an advanced RO + UV purification technology that not only gives you pure water but also adds minerals to enhance the taste of water.");
		
		String stockAndPriceUrl = "http://STOCKANDPRICEMS/stockandpriceMS/getStockAndPrice";
		
		ResponseEntity<StockAndPriceData> resp = restTemplate.postForEntity(stockAndPriceUrl, product1.getCode(),StockAndPriceData.class);
		
		LOG.info("resp from StockAndPrice MS >> "+resp.getBody().getOfflineStock());
		
		product1.setStockAndPrice(resp.getBody());
		
		List<ProductData> dataList = new ArrayList<>();
		
		dataList.add(product1);
		
		return dataList;
	}
	
	public List<ProductData> getProductsFallbackImpl()
	{
		ProductData product1 = new ProductData();
		product1.setCode("A00001");
		product1.setName("Pureit Ultima Mineral RO + UV");
		product1.setDesc("Pureit brings to you a water purifier that looks stunning and comes with an advanced RO + UV purification technology that not only gives you pure water but also adds minerals to enhance the taste of water.");
		
		StockAndPriceData stockAndPriceData = new StockAndPriceData();
		stockAndPriceData.setOfflineStock(0);
		stockAndPriceData.setOnlineStock(0);
		stockAndPriceData.setUnitPrice(0.00);
		stockAndPriceData.setUom("");
		product1.setStockAndPrice(stockAndPriceData);
		
		List<ProductData> dataList = new ArrayList<>();
		
		dataList.add(product1);
		
		return dataList;
	}
	
}

package org.springframework.samples.petclinic.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class ProductService {
	
	private ProductRepository productrepo;
	
	@Autowired
	public ProductService(ProductRepository productrepo) {
		this.productrepo = productrepo;
	}
	@Transactional(readOnly = true)
	public List<Product> getAllProducts(){
        return productrepo.findAll();
    }

    public List<Product> getProductsCheaperThan(double price) {
        return productrepo.findByPriceLessThan(price);
    }

    public ProductType getProductType(String typeName) {
        return productrepo.getProductType(typeName);
    }

    public Product save(Product p){
        return productrepo.save(p);       
    }
	public List<ProductType> findAllProductTypes() {
		
		return productrepo.findAllProductTypes();
	}

    
}

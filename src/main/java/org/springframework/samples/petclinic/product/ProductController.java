package org.springframework.samples.petclinic.product;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/product")
public class ProductController {
	
	private ProductService productService;
	
	private final String PRODUCT_LISTING = "products/productList";
	private final String EDIT_PRODUCT = "products/createOrUpdateProductForm";
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping(value = "/")
	public ModelAndView showAllProducts() {
		ModelAndView result = new ModelAndView(PRODUCT_LISTING);
		result.addObject("product", productService.getAllProducts());
		return result;
		
	}
	@GetMapping(value = "/create")
	public ModelAndView createRoom() {
		ModelAndView result = new ModelAndView(EDIT_PRODUCT);
		Product product = new Product();
		result.addObject("product", product);
		return result;
		
	}
	@PostMapping(value = "/create")
	public ModelAndView showProductsById(@Valid Product product, BindingResult br) {
		ModelAndView result = null;
		if(br.hasErrors()) {
			result = new ModelAndView(EDIT_PRODUCT);
			result.addAllObjects(br.getModel());
		}else {
			productService.save(product);
			result= new ModelAndView("welcome");
		}
		return result;
	}
	
	
	
    
}

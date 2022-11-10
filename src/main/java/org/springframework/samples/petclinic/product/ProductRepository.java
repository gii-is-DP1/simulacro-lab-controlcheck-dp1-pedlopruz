package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{
    public List<Product> findAll();
    @Query("SELECT prtype FROM ProductType prtype")
    public List<ProductType> findAllProductTypes();
    @Query("SELECT prtype FROM ProductType prtype WHERE prtype.name = :name")
    public ProductType getProductType(@Param("name") String name);
    @Query("SELECT pr FROM Product pr WHERE pr.price < :price")
    public List<Product> findByPriceLessThan(@Param("price") double price);
    public Optional<Product> findById(int id);
    public Product findByName(String name);
    public Product save(Product p);
}

package org.springframework.samples.petclinic.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "products_types")
@Entity
public class ProductType extends BaseEntity{
    @Column(unique = true, name="name")
    @Size(min = 3, max = 50)
    private String name;
}

package com.devsuperior.dscommerce.repositories;
import com.devsuperior.dscommerce.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//the name of interface is the entity name and suffix repository
//this component product repository is responsible operations on database of product
public interface ProductRepository extends JpaRepository <Product, Long>{

    //query customized with JPQL
    //'UPPER' to received uppercase or lowercase
    //last argument is pageable, so will return query pageable
    //CONCAT will be to bring together before and after the name
    @Query("SELECT obj FROM Product obj " +
            "WHERE UPPER(obj.name) LIKE UPPER(CONCAT('%', :name, '%')) ")
    Page<Product> searchByName(String name, Pageable pageable);

}

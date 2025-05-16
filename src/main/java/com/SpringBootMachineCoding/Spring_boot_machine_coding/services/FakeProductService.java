package com.SpringBootMachineCoding.Spring_boot_machine_coding.services;

import com.SpringBootMachineCoding.Spring_boot_machine_coding.dtos.FakeStoreProductDTO;
import com.SpringBootMachineCoding.Spring_boot_machine_coding.models.Category;
import com.SpringBootMachineCoding.Spring_boot_machine_coding.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FakeProductService implements ProductService {


    RestTemplate restTemplate;

    public FakeProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }



    private  Product ConvertFakeProductDTOToProduct(FakeStoreProductDTO dto){
        if (dto == null){
            return  null;

        }

        Product product = new Product();

        product.setId(dto.getId());
        product.setName(dto.getTitle());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());


        Category  category = new Category();

        category.setTitle(dto.getTitle());
        product.setCategory(category);

        return  product;


    }

    @Override
    public Product getProductById(Long id) {
        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.getForObject("https://fakestoreapi.com/products/"+id , FakeStoreProductDTO.class);
        return ConvertFakeProductDTOToProduct(fakeStoreProductDTO);
    }

    @Override
    public List<Product> getAllProducts(){
        FakeStoreProductDTO[] fakeStoreProductDTOsList =
                restTemplate.getForEntity("https://fakestoreapi.com/products/", FakeStoreProductDTO[].class);

        List<Product> ProductList = new ArrayList<>();
        assert fakeStoreProductDTOsList != null;
        for (FakeStoreProductDTO fspDto : fakeStoreProductDTOsList){
            ProductList.add(ConvertFakeProductDTOToProduct(fspDto));
        }
        return  ProductList;
    }


}

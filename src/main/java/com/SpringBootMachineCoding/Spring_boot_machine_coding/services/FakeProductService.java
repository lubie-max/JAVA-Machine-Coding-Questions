package com.SpringBootMachineCoding.Spring_boot_machine_coding.services;

import com.SpringBootMachineCoding.Spring_boot_machine_coding.dtos.FakeStoreProductDTO;
import com.SpringBootMachineCoding.Spring_boot_machine_coding.models.Category;
import com.SpringBootMachineCoding.Spring_boot_machine_coding.models.Product;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
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
                restTemplate.getForObject("https://fakestoreapi.com/products/", FakeStoreProductDTO[].class);

        List<Product> ProductList = new ArrayList<>();
        assert fakeStoreProductDTOsList != null;
        for (FakeStoreProductDTO fspDto : fakeStoreProductDTOsList){
            ProductList.add(ConvertFakeProductDTOToProduct(fspDto));
        }
        return  ProductList;
    }


    @Override
    public Product updateProduct(Long id, Product product) {
        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setTitle(product.getName());
        fakeStoreProductDTO.setDescription(product.getDescription());
        fakeStoreProductDTO.setPrice(product.getPrice());

        RequestCallback requestCallback = restTemplate.httpEntityCallback(fakeStoreProductDTO , FakeStoreProductDTO.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDTO>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDTO.class);

        FakeStoreProductDTO fakeStoreProductDTO1 =
        restTemplate.execute("https://fakestoreapi.com/products/"+id , HttpMethod.PUT, requestCallback, responseExtractor).getBody();

        return ConvertFakeProductDTOToProduct(fakeStoreProductDTO1);

    }



}

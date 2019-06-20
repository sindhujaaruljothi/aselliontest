package com.sindhu.aselliontest.aselliontest.controller;

import com.sindhu.aselliontest.aselliontest.model.Product;
import com.sindhu.aselliontest.aselliontest.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    private static final String BASE_URL = "/product/";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    public void test_find_all_products() throws Exception {
        //Given
        Product product = new Product();
        product.setId(1l);
        product.setName("asellion");
        product.setCurrentPrice(BigDecimal.valueOf(100.10));
        product.setLastUpdate(Timestamp.valueOf("2019-06-20 11:30:25"));

        List<Product> products = Collections.singletonList(product);
        given(productService.getProducts()).willReturn(products);

        //When then
        mockMvc.perform(get(BASE_URL + "/getProducts"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[{'id': 1,'name': 'asellion','currentPrice': 100.10,'lastUpdate': '2019-06-20T09:30:25.000+0000'}]"));
    }
}
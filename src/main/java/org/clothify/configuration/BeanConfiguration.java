package org.clothify.configuration;

import org.clothify.entity.OrderDetail;
import org.clothify.entity.OrderDetailKey;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    ModelMapper setUp(){
        return new ModelMapper();
    }

    @Bean
    OrderDetail orderDetailEntityCreation(){return new OrderDetail();}

    @Bean
    OrderDetailKey orderDetailKeyCreation(){return new OrderDetailKey();}
}

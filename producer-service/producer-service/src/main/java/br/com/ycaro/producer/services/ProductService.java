package br.com.ycaro.producer.services;

import constants.RabbitmqConstants;
import dtos.ProductDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class ProductService {

    @Autowired
    private final RabbitTemplate rabbitTemplate;

    public void createProduct(ProductDto dto) {
        log.info("Sending a message to exchange " + dto.toString());

        rabbitTemplate.convertAndSend(
                RabbitmqConstants.EXG_NAME_MARKETPLACE,
                RabbitmqConstants.RK_PRODUCT_LOG,
                dto);
    }
}

package br.com.ycaro.consumer.rabbitmq.consumers;

import constants.RabbitmqConstants;
import dtos.ProductDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class ProductConsumer {

    @RabbitListener(queues = RabbitmqConstants.RK_PRODUCT_LOG)

    public void consumerLog(ProductDto dto) {
        log.info("Received message " + dto.toString());
    }
}

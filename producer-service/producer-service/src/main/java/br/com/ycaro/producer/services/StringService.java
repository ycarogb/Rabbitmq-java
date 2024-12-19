package br.com.ycaro.producer.services;

import br.com.ycaro.producer.RabbitMQConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor //cimplementa construtor para realizar dependencia
public class StringService {

    private final RabbitTemplate rabbitTemplate;

    public void produce(String message){
        log.info("Receveid message " + message);

        //cria um template rabbimq e produz mensagem
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXG_NAME_MARKETPLACE, RabbitMQConfig.RK_PRODUCT_LOG, message);
    }
}

package br.com.ycaro.producer;

import constants.RabbitmqConstants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {

    @Bean //sempre que subir a aplicação vai chamar esse método
    public Queue queue(){
        return new Queue(RabbitmqConstants.QUEUE_PRODUCT_LOG, true, false, false);
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(RabbitmqConstants.EXG_NAME_MARKETPLACE, true, false);
    }

    @Bean
    public Binding binding(){
        return BindingBuilder
                .bind(queue())
                .to(directExchange())
                .with(RabbitmqConstants.RK_PRODUCT_LOG);
    }
}

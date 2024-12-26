package br.com.ycaro.producer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {

    public static final String EXG_NAME_MARKETPLACE = "test.direct"; //nome da exchange
    public static final String QUEUE_PRODUCT_LOG = "product.log"; //nome da fila
    public static final String RK_PRODUCT_LOG = "product.log"; //nome da routing key

    @Bean //sempre que subir a aplicação vai chamar esse método
    public Queue queue(){
        return new Queue(QUEUE_PRODUCT_LOG, true, false, false);
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(EXG_NAME_MARKETPLACE, true, false);
    }

    @Bean
    public Binding binding(){
        return BindingBuilder
                .bind(queue())
                .to(directExchange())
                .with(RK_PRODUCT_LOG);
    }
}

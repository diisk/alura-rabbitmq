package br.com.alurafood.pedidos.amqp;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PedidoAmqpConfiguration {
    
    @Bean
    public Jackson2JsonMessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory conn, Jackson2JsonMessageConverter messageConverter){
        var rabbitTemplate = new RabbitTemplate(conn);
        rabbitTemplate.setMessageConverter(messageConverter);
        return rabbitTemplate;
    }

}
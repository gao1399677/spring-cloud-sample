package pl.piomin.services.department.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@EnableBinding(Source.class)
@RestController
public class MessageOutput {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageOutput.class);

    @Autowired
    private Source source;

    @RequestMapping("/sendMessage")
    public String sendMessage(@RequestBody MqMsg message) {
        source.output().send(MessageBuilder.withPayload(message).build());
        LOGGER.info("make a great meal: {}", message.toString());
        return message.toString();
    }
}

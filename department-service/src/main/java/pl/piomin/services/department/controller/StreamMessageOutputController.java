package pl.piomin.services.department.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.piomin.services.department.model.MqMsg;

@EnableBinding(Processor.class)
@RestController
public class StreamMessageOutputController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StreamMessageOutputController.class);

    @Autowired
    private Processor processor;

    @RequestMapping("/sendMessage")
    public String sendMessage(@RequestBody MqMsg message) {
        boolean send = processor.output().send(MessageBuilder.withPayload(message).build());
        /*Input or output is just a name of channel, which is the build-in channel of Spring Stream*/
//        boolean sendIn = processor.input().send(MessageBuilder.withPayload(message).build());
        LOGGER.info("make a great meal: {}", message.toString());
        return message.toString();
    }
}

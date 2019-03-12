package pl.piomin.services.employee.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;


@RestController
@EnableBinding(Processor.class)
public class StreamMessageInputController {

    AtomicInteger msgCount = new AtomicInteger(0);

    private static final Logger LOGGER = LoggerFactory.getLogger(StreamMessageInputController.class);

    @StreamListener(target = Processor.INPUT)
    // There must has a "@SendTo", When has a return value under "@StreamListener"
    @SendTo(Processor.OUTPUT)
    public String processCheapMeals(String meal){
        System.out.println("This was a great meal!: "+meal);
        return "get great meal A:" + msgCount.addAndGet(1);
    }

    @StreamListener(target = Processor.OUTPUT)
    @SendTo(Processor.INPUT)
    public String OutputBack(String meal){
        System.out.println("This was a great meal back!: "+meal);
        return "get great meal b:" + msgCount.addAndGet(1);
    }
}
package pl.piomin.services.department;

import org.springframework.cloud.stream.annotation.EnableBinding;
 
@EnableBinding(FoodOrderSource.class)
public class FoodOrderPublisher {
}
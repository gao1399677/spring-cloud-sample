package pl.piomin.services.department.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
//这里面的属性有可能会更新的，git中的配置中心变化的话就要刷新，没有这个注解内，配置就不能及时更新
@RefreshScope
public class CloudBusController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CloudBusController.class);

    @Value("${age}")
    private Integer age;

    /**
     * @Descrition spring cloud bus test
     * @Author SGao 2019/03/12
     * @param
     * @Return java.lang.Integer
     */
    @GetMapping("/test")
    public Integer test() {
        LOGGER.info(age.toString());
        return this.age;
    }
}
package pl.piomin.services.gateway.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.GatewayFilterFactory;
import org.springframework.stereotype.Component;

@Component
public class GatewayTokenFilter implements GatewayFilterFactory<GatewayTokenFilter.Config> {

    private static final Logger LOGGER = LoggerFactory.getLogger(GatewayTokenFilter.class);


    @Override
    public Config newConfig() {
        return new Config("GatewayTokenFilter");
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            System.out.println("gateway filter name " + config.getName());
            return chain.filter(exchange);
        };
    }

    public static class Config {

        public Config(String name) {
            this.name = name;
        }

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

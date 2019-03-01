package pl.piomin.services.department.rabbitmq;

import java.io.Serializable;

public class MqMsg implements Serializable {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MqMsg{" +
                "message='" + message + '\'' +
                '}';
    }
}

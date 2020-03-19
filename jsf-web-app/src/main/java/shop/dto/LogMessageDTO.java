package shop.dto;

import java.sql.Timestamp;

public class LogMessageDTO {
    private Long id;
    private String message;
    private Timestamp dataTime;

    public LogMessageDTO() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getDataTime() {
        return dataTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dataTime = dateTime;
    }
}

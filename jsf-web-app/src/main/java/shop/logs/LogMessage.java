package shop.logs;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "logs")
public class LogMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    private Timestamp dataTime;

    public LogMessage() {
    }

    public LogMessage(String message, Timestamp dataTime) {
        this.message = message;
        this.dataTime = dataTime;
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

    public void setDataTime(Timestamp dataTime) {
        this.dataTime = dataTime;
    }
}

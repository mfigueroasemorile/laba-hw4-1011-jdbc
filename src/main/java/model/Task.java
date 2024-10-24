package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Task {

    @JsonProperty("id_task")
    private int idTask;
    @JsonProperty("description")
    private String description;

    public Task (int idTask, String description) {
        this.idTask = idTask;
        this.description = description;
    }
    
}

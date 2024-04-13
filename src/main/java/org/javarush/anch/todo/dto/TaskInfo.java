package org.javarush.anch.todo.dto;

import lombok.Builder;
import lombok.Data;
import org.javarush.anch.todo.domain.Status;

@Data
@Builder(setterPrefix = "with")
public class TaskInfo {

    private String description;
    private Status status;

}

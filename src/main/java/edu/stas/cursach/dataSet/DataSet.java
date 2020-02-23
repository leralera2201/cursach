package edu.stas.cursach.dataSet;

import edu.stas.cursach.model.Group;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataSet {
    private List<Group> groups = new ArrayList<>(Arrays.asList(
            new Group("1", "243", "description",
                    LocalDateTime.now(), LocalDateTime.now()),
            new Group("2", "243sk", "description",
                    LocalDateTime.now(), LocalDateTime.now())
    ));

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}

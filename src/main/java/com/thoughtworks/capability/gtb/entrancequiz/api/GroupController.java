package com.thoughtworks.capability.gtb.entrancequiz.api;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Group;
import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import com.thoughtworks.capability.gtb.entrancequiz.service.GroupService;
import com.thoughtworks.capability.gtb.entrancequiz.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class GroupController {
    private GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping("/groups")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Group> getRandomGroups() {
        return groupService.getGroups();
    }

    @GetMapping("/groups")
    @ResponseStatus(HttpStatus.OK)
    public List<Group> getHistoryGroups() {
        return groupService.showGroups();
    }
}

package com.can.springbootmssql.controllers;




import com.can.springbootmssql.models.Group;
import com.can.springbootmssql.services.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @GetMapping("")
    public List<Group> getAllGroups() {
        return groupService.getAllGroups();
    }

}

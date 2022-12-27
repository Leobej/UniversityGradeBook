package com.can.springbootmssql.controllers;

import com.can.springbootmssql.models.GroupType;
import com.can.springbootmssql.services.GroupTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/grouptypes")
@RequiredArgsConstructor
public class GroupTypeController {
    private final GroupTypeService groupTypeService;

    @GetMapping("")
    public List<GroupType> getAllGroupTypes() {
        return groupTypeService.getAllGroupTypes();
    }
}

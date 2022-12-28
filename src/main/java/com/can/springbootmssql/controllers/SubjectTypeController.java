package com.can.springbootmssql.controllers;

import com.can.springbootmssql.interfaces.SubjectService;
import com.can.springbootmssql.interfaces.SubjectTypeService;
import com.can.springbootmssql.models.Subject;
import com.can.springbootmssql.models.SubjectType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/subjecttypes")
@RequiredArgsConstructor
public class SubjectTypeController {

    private final SubjectTypeService subjectTypeService;

    @GetMapping("")
    public List<SubjectType> getAllSubjectTypes() {
        return subjectTypeService.getAllSubjectTypes();
    }
}

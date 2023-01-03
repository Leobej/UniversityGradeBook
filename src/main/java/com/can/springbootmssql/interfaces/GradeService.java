package com.can.springbootmssql.interfaces;

import com.can.springbootmssql.dtos.GradeDTO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface GradeService {
    List<GradeDTO> getAllGrades();

    GradeDTO addGrade(@RequestBody GradeDTO gradeDTO);

    GradeDTO updateGrade(int gradeId, @RequestBody GradeDTO gradeDTO);

    Boolean deleteGrade(int gradeId);


}

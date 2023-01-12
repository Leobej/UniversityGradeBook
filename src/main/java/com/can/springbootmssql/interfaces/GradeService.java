package com.can.springbootmssql.interfaces;

import com.can.springbootmssql.dtos.GradeDTO;
import com.can.springbootmssql.exceptions.ApiException;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface GradeService {
    List<GradeDTO> getAllGrades();

    GradeDTO addGrade(@RequestBody GradeDTO gradeDTO);

    GradeDTO updateGrade(@RequestBody GradeDTO gradeDTO) throws ApiException;

    Boolean deleteGrade(int gradeId) throws ApiException;


}

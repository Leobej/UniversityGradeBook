package com.can.springbootmssql.interfaces;

import com.can.springbootmssql.models.Grade;
import com.can.springbootmssql.models.Group;

import java.util.List;

public interface GradeService {
    List<Grade> getAllGrades();
}
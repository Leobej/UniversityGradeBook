package com.can.springbootmssql.mappers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;

@ComponentScan
public class Mapper {
    private final ModelMapper modelMapper;
    private final Logger logger = LoggerFactory.getLogger(ModelMapper.class);


    public Mapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public <T> T convertToType(Object sourceObject,Class<T> resultClass)
    {
        logger.debug("Converted object from "+sourceObject.getClass().getSimpleName() + " to "+resultClass.getSimpleName());
    return modelMapper.map(sourceObject,resultClass);
    }
}

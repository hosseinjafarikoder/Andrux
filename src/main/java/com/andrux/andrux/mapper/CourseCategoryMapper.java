package com.andrux.andrux.mapper;

import com.andrux.andrux.dto.CourseCategoryDto;
import com.andrux.andrux.entity.CourseCategory;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CourseCategoryMapper {

    CourseCategory convertDtoToT(CourseCategoryDto courseCategoryDto);

    CourseCategoryDto convertTToDto(CourseCategory courseCategory);

    List<CourseCategory> convertListDtoToListEntity(List<CourseCategoryDto> courseCategoryDtoList);

    List<CourseCategoryDto> convertListEntityToListDto(List<CourseCategory> courseCategoryList);
}

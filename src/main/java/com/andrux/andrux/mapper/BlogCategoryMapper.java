package com.andrux.andrux.mapper;

import com.andrux.andrux.dto.BlogCategoryDto;
import com.andrux.andrux.entity.BlogCategory;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface BlogCategoryMapper {

    BlogCategory convertDtoToT(BlogCategoryDto blogCategoryDto);

    BlogCategoryDto convertTToDto(BlogCategory blogCategory);

    List<BlogCategory> convertListDtoToListEntity(List<BlogCategoryDto> blogCategoryDtoList);

    List<BlogCategoryDto> convertListEntityToListDto(List<BlogCategory> blogCategoryList);
}

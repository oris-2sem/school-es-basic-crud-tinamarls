package com.example.mappers;

import com.example.dto.parent.NewOrUpdateParentDto;
import com.example.dto.parent.ParentDto;
import com.example.models.Parent;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ParentMapper {
    ParentDto toDto(Parent parent);
    Parent toParent(ParentDto parentDto);
    Parent toParent(NewOrUpdateParentDto parentDto);
}

package com.example.services;

import com.example.dto.parent.NewOrUpdateParentDto;
import com.example.dto.parent.ParentDto;
import com.example.models.Parent;

public interface ParentService {

    Parent findById(Long id);

    ParentDto getParentById(Long id);

    ParentDto addParent(NewOrUpdateParentDto newParent);

    ParentDto update(Long id, NewOrUpdateParentDto updateParentDto);

    void deleteParent(Long id);
}

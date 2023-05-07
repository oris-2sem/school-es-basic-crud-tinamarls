package com.example.services.impl;

import com.example.dto.parent.NewOrUpdateParentDto;
import com.example.dto.parent.ParentDto;
import com.example.exceptions.NotFoundException;
import com.example.mappers.ParentMapper;
import com.example.models.Lesson;
import com.example.models.Parent;
import com.example.repositories.ParentRepository;
import com.example.services.ParentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ParentServiceImpl implements ParentService {

    private final ParentRepository parentRepository;

    private final ParentMapper parentMapper;

    @Override
    public Parent findById(Long id) {
        return getParentOrThrow(id);
    }

    @Override
    public ParentDto getParentById(Long id) {
        return parentMapper.toDto(getParentOrThrow(id));
    }

    @Override
    public ParentDto addParent(NewOrUpdateParentDto newParent) {
        Parent parent = parentRepository.save(parentMapper.toParent(newParent));
        return parentMapper.toDto(parent);
    }

    @Override
    public ParentDto update(Long id, NewOrUpdateParentDto updateParentDto) {
        Parent parent = getParentOrThrow(id);

        parent.setAge(updateParentDto.getAge());
        parent.setFirstName(updateParentDto.getFirstName());
        parent.setFirstName(updateParentDto.getLastName());

        return parentMapper.toDto(parentRepository.save(parent));
    }

    @Override
    public void deleteParent(Long id) {
        parentRepository.delete(getParentOrThrow(id));
    }

    private Parent getParentOrThrow(Long id) {
        return parentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Родитель с идентификатором <" + id + "> не найден"));
    }
}

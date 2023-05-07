package com.example.controllers;

import com.example.dto.parent.NewOrUpdateParentDto;
import com.example.dto.parent.ParentDto;
import com.example.services.ParentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/parent")
public class ParentController {

    private final ParentService parentService;

    @GetMapping({"/{id}"})
    public ResponseEntity<ParentDto> getParent(@PathVariable("id") Long id){
        return ResponseEntity.ok(parentService.getParentById(id));
    }

    @PostMapping
    public ResponseEntity<ParentDto> addParent(@RequestBody NewOrUpdateParentDto newParent){
        return ResponseEntity.status(HttpStatus.CREATED).body(parentService.addParent(newParent));
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<ParentDto> updateParent(@PathVariable("id") Long id,
                                                  @RequestBody NewOrUpdateParentDto updateParentDto){
        return ResponseEntity.accepted().body(parentService.update(id, updateParentDto));
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<?> deleteParent(@PathVariable("id") Long id){
        parentService.deleteParent(id);
        return ResponseEntity.accepted().build();
    }

}

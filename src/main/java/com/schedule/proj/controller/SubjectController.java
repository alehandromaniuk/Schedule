package com.schedule.proj.controller;

import com.schedule.proj.model.DTO.TeacherGeneralResponseDTO;
import com.schedule.proj.model.Subject;
import com.schedule.proj.security.jwt.JwtProvider;
import com.schedule.proj.service.SubjectService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/subject")
public class SubjectController {
    private final SubjectService subjectService;
    @Autowired
    JwtProvider jwtProvider;

    @GetMapping
    @ResponseBody
    public List<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    @GetMapping(path = "{subjectId}")
    @ResponseBody
    public Subject getSubject(@PathVariable Integer subjectId) {
        return subjectService.getSubject(subjectId);
    }

    @PostMapping
    @ResponseBody
    public Subject addSubject(@RequestBody @Valid Subject subject) {
        return subjectService.createSubject(subject);
    }

    @PutMapping(path = "{subjectId}")
    public Subject updateSubject(@RequestBody Subject subject) {
        return subjectService.updateSubject(subject);
    }

    @DeleteMapping(path = "{subjectId}")
    public void deleteSubject(@PathVariable Integer subjectId) {
        subjectService.deleteSubject(subjectId);
    }

    // todo: add students, getStudents(subjId), getTeacher(subjId), deleteStudent(subjId, studentId) ???

    @GetMapping("/teachersSubject")
    public ResponseEntity<?> findTeachersSubjectByToken(HttpServletRequest request){

        return ResponseEntity.ok(subjectService.findTeachersSubjectByToken(request));
    }


}

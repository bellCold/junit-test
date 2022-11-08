package com.example.javatest.study;

import com.example.javatest.domain.Member;
import com.example.javatest.domain.Study;
import com.example.javatest.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudyServiceTest {

    @Mock
    MemberService memberService;
    @Mock
    StudyRepository studyRepository;

    @Test
    @DisplayName("유저 생성 테스트")
    void createStudyService() {
        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);

        Member member = new Member();
        member.setId(1L);
        member.setName("kimjongchan");

        when(memberService.findById(any())).thenReturn(Optional.of(member));

        Optional<Member> findById = memberService.findById(2L);
        assertEquals("kimjongchan", findById.get().getName());

        Study study = new Study(1, "jongchan");

        verify(memberService, times(any())).notify(study);
    }

    @Test
    @DisplayName("Stubbing")
    void stubTest() {
        Member member = new Member();
        member.setId(1L);
        member.setName("jongchan");

        when(memberService.findById(1L)).thenReturn(Optional.of(member));
        Optional<Member> findById = memberService.findById(1L);
        assertEquals("jongchan", findById.get().getName());

        Study study = new Study(10, "bellCold");

        when(studyRepository.save(study)).thenReturn(study);
        Study save = studyRepository.save(study);
        assertAll(
                () -> assertEquals(10, save.getLimit()),
                () -> assertEquals("bellCold", save.getName())
        );
    }

}
package com.example.javatest.study;

import com.example.javatest.domain.Member;
import com.example.javatest.domain.Study;
import com.example.javatest.member.MemberService;

public class StudyService {

    private final MemberService memberService;
    private final StudyRepository studyRepository;

    public StudyService(MemberService memberService, StudyRepository studyRepository) {
        assert memberService != null;
        assert studyRepository != null;
        this.memberService = memberService;
        this.studyRepository = studyRepository;
    }

    public Study createNewStudy(Long memberId, Study study) {
        Member member = memberService.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Member does not exist"));
        study.setOwner(member);

        Study newStudy = studyRepository.save(study);
        memberService.notify(newStudy);
        return newStudy;
    }
}

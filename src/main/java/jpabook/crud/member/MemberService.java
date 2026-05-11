package jpabook.crud.member;

import jpabook.crud.member.dto.CreateMemberRequest;
import jpabook.crud.member.dto.MemberResponse;
import jpabook.crud.member.dto.UpdateMemberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public MemberResponse createMember(CreateMemberRequest request) {
        Member member = new Member();
        member.setName(request.getName());
        member.setEmail(request.getEmail());
        return new MemberResponse(memberRepository.save(member));
    }

    public List<MemberResponse> findAllMembers() {
        return memberRepository.findAll().stream()
                .map(MemberResponse::new)
                .collect(Collectors.toList());
    }

    public MemberResponse findMember(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("회원을 찾을 수 없습니다. id=" + id));
        return new MemberResponse(member);
    }

    @Transactional
    public MemberResponse updateMember(Long id, UpdateMemberRequest request) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("회원을 찾을 수 없습니다. id=" + id));
        member.setName(request.getName());
        member.setEmail(request.getEmail());
        return new MemberResponse(member);
    }

    @Transactional
    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }
}

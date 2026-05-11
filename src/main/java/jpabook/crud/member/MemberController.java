package jpabook.crud.member;

import jpabook.crud.member.dto.CreateMemberRequest;
import jpabook.crud.member.dto.MemberResponse;
import jpabook.crud.member.dto.UpdateMemberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MemberResponse createMember(@RequestBody CreateMemberRequest request) {
        return memberService.createMember(request);
    }

    @GetMapping
    public List<MemberResponse> findAllMembers() {
        return memberService.findAllMembers();
    }

    @GetMapping("/{id}")
    public MemberResponse findMember(@PathVariable Long id) {
        return memberService.findMember(id);
    }

    @PutMapping("/{id}")
    public MemberResponse updateMember(@PathVariable Long id, @RequestBody UpdateMemberRequest request) {
        return memberService.updateMember(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
    }
}

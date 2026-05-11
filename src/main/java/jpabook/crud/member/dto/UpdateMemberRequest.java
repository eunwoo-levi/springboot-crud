package jpabook.crud.member.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter @NoArgsConstructor
public class UpdateMemberRequest {
    private String name;
    private String email;
}

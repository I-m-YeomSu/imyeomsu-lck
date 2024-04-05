package imyeom_lck.member.controller;

import imyeom_lck.member.domain.dto.MemberDetailsResponseDTO;
import imyeom_lck.member.persistence.querydsl.QueryMemberRepository;
import imyeom_lck.member.service.inter.QueryMemberService;
import imyeom_lck.pointusage.domain.entity.PointUsage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
@Slf4j
public class QueryMemberRestController {

    private final QueryMemberRepository queryMemberRepository;

    private final QueryMemberService queryMemberService;

    @GetMapping(value = "/findall")
    public List<MemberDetailsResponseDTO> findall(){
        return queryMemberService.findall();
    }


    @GetMapping(value = "/findone")
    public MemberDetailsResponseDTO findById(Long id){
        return queryMemberService.findById(id);
    }

    @GetMapping(value = "/findpu")
    public List<PointUsage> findByPointUsage(Long id){
        return queryMemberService.queryDSLFindAllPUByMemberId(id);
    }

}
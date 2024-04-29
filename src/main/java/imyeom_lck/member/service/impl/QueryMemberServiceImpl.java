package imyeom_lck.member.service.impl;

import imyeom_lck.member.domain.dto.MemberDetailsResponseDTO;
import imyeom_lck.member.domain.entity.Member;
import imyeom_lck.member.persistence.querydsl.inter.QueryMemberRepository;
import imyeom_lck.member.service.inter.QueryMemberService;
import imyeom_lck.pointusage.domain.entity.PointUsage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class QueryMemberServiceImpl implements QueryMemberService {

    private final QueryMemberRepository queryMemberRepository;

    public List<MemberDetailsResponseDTO> findall() {
        List<Member> memberList = queryMemberRepository.queryDSLFindAll();
        List<MemberDetailsResponseDTO> responseList = new ArrayList<>(){};
        for(Member member : memberList){
            responseList.add(MemberDetailsResponseDTO.fromEntity(member));
        }
        return responseList;
    }

    public MemberDetailsResponseDTO findById(Long id){
        Member member = queryMemberRepository.queryDSLFindByMemberId(id).orElseThrow();

        return MemberDetailsResponseDTO.fromEntity(member);
    }

    public List<PointUsage> queryDSLFindAllPUByMemberId(Long id){
        List<PointUsage> tmplist = queryMemberRepository.queryDSLFindAllPUByMemberId(id);
        log.info("{}:",tmplist.get(0).getPointHistory());
        return tmplist;
    }

}

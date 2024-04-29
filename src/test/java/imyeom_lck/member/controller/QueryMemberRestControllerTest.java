package imyeom_lck.member.controller;

import imyeom_lck.member.domain.dto.MemberDetailsResponseDTO;
import imyeom_lck.member.domain.dto.MemberUpdateDTO;
import imyeom_lck.member.domain.entity.Member;
import imyeom_lck.member.persistence.querydsl.inter.QueryMemberRepository;
import imyeom_lck.member.service.impl.QueryMemberServiceImpl;
import imyeom_lck.pointusage.domain.entity.PointUsage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(QueryMemberRestController.class)
public class QueryMemberRestControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private QueryMemberServiceImpl qdslService;

    @MockBean
    private QueryMemberRepository queryMemberRepository;

    MemberUpdateDTO memberUpdateDTO;

    @BeforeEach
    void setUp(){

        memberUpdateDTO = MemberUpdateDTO.builder()
                .loginId("update")
                .password("update")
                .name("update")
                .phoneNumber("update")
                .cheeringTeam("update")
                .build();

    }


    @DisplayName("모든 멤버찾기")
    @Test
    public void findAll() throws Exception{
        MemberDetailsResponseDTO dummyMemberDetails1 = new MemberDetailsResponseDTO("id1", "mem1", "1234567891", "password1", "TeamA", true, 101, false);
        MemberDetailsResponseDTO dummyMemberDetails2 = new MemberDetailsResponseDTO("id2", "mem2", "1234567892", "password2", "TeamB", true, 102, false);
        List<MemberDetailsResponseDTO> dummyList = new ArrayList<>(){};
        dummyList.add(dummyMemberDetails1);
        dummyList.add(dummyMemberDetails2);

        given(this.qdslService.findall())
                .willReturn(dummyList);
        this.mvc.perform(get("/api/query/members/findall")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].memberName").value("mem1"))
                .andExpect(jsonPath("$[0].memberPhone").value("1234567891"))
                .andExpect(jsonPath("$[0].memberPassword").value("password1"))
                .andExpect(jsonPath("$[0].cheeringTeam").value("TeamA"))
                .andExpect(jsonPath("$[0].memberPoint").value(101))
                .andExpect(jsonPath("$[1].memberName").value("mem2"))
                .andExpect(jsonPath("$[1].memberPhone").value("1234567892"))
                .andExpect(jsonPath("$[1].memberPassword").value("password2"))
                .andExpect(jsonPath("$[1].cheeringTeam").value("TeamB"))
                .andExpect(jsonPath("$[1].memberPoint").value(102));
    }

    @DisplayName("멤버id로 멤버찾기")
    @Test
    public void findByIdTest() throws Exception {
        MemberDetailsResponseDTO dummyMemberDetails = new MemberDetailsResponseDTO("id", "mem1", "123456789", "password1", "TeamA", true, 100, false);
        given(this.qdslService.findById(anyLong()))
                .willReturn(dummyMemberDetails);

        this.mvc.perform(get("/api/query/members/findone/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.memberName").value("mem1"))
                .andExpect(jsonPath("$.memberPhone").value("123456789"))
                .andExpect(jsonPath("$.memberPassword").value("password1"))
                .andExpect(jsonPath("$.cheeringTeam").value("TeamA"))
                .andExpect(jsonPath("$.memberPoint").value(100));
    }

    @DisplayName("멤버id로 포인트 내역 찾기")
    @Test
    public void findPointUsage() throws Exception{
        Member dummymember = new Member(){};
        dummymember.updateMember(memberUpdateDTO);

        PointUsage pointUsage1 = new PointUsage(1L, dummymember, 1L, LocalDateTime.of(2020, 4, 3, 0, 0),"History1");
        System.out.print(LocalDateTime.now());
        List<PointUsage> dummyList = new ArrayList<>(){};
        dummyList.add(pointUsage1);

        given(this.qdslService.queryDSLFindAllPUByMemberId(anyLong())).willReturn(dummyList);

        this.mvc.perform(get("/api/query/members/findpu/{id}",1L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].pointUsageId").value(1))
                .andExpect(jsonPath("$[0].usageClassification").value(1))
                .andExpect(jsonPath("$[0].pointHistory").value("History1"));
    }

}

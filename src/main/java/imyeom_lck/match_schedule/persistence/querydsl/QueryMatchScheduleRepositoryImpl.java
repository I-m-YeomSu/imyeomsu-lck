package imyeom_lck.match_schedule.persistence.querydsl;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import imyeom_lck.match_schedule.domain.dto.MatchesResponseDTO;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class QueryMatchScheduleRepositoryImpl implements QueryMatchScheduleRepository{

	private final JPAQueryFactory jpaQueryFactory;

	@Override
	public Page<MatchesResponseDTO> findMatchScheduleByMonth(String month) {
		return null;
	}
}

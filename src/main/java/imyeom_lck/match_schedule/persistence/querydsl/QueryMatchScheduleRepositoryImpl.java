package imyeom_lck.match_schedule.persistence.querydsl;

import com.querydsl.jpa.impl.JPAQuery;
import imyeom_lck.match_schedule.domain.entity.MatchSchedule;
import imyeom_lck.match_schedule.domain.entity.QMatchSchedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import imyeom_lck.match_schedule.domain.dto.MatchesResponseDTO;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class QueryMatchScheduleRepositoryImpl implements QueryMatchScheduleRepository{

	private final JPAQueryFactory jpaQueryFactory;

	@Override
	public Page<MatchSchedule> findMatchScheduleByMonth(String month, Pageable pageable) {
		QMatchSchedule matchSchedule = QMatchSchedule.matchSchedule;
		List<MatchSchedule> results = jpaQueryFactory.selectFrom(matchSchedule).where(matchSchedule.matchDate.substring(4, 6).eq(month)).fetch();

		return new PageImpl<>(results, pageable, results.size());
	}

	@Override
	public List<MatchSchedule> findMatchScheduleByMonth(String month) {
		QMatchSchedule matchSchedule = QMatchSchedule.matchSchedule;
		return jpaQueryFactory.selectFrom(matchSchedule).where(matchSchedule.matchDate.substring(4, 6).eq(month)).fetch();
	}

	@Override
	public List<MatchSchedule> findMatchScheduleByMonthDay(String month, String day) {
		QMatchSchedule matchSchedule = QMatchSchedule.matchSchedule;
		return jpaQueryFactory.selectFrom(matchSchedule)
			.where(matchSchedule.matchDate.substring(6, matchSchedule.matchDate.length()).eq(day).and(matchSchedule.matchDate.substring(4, 6).eq(month)))
			.fetch();

	}
}

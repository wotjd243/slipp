package net.slipp.service.summary;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import net.slipp.domain.summary.SiteSummary;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(MockitoJUnitRunner.class)
public class SummarykServiceTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@InjectMocks
	private SummaryService summaryService = new SummaryService();

	@Before
	public void setUp() {
	}

	@Test
	public final void testFindOneThumnail_ArcheAge() throws Exception {
		SiteSummary siteSummary = summaryService
				.findOneThumbnail("http://board.archeage.com/community/openboards/290656");
		assertThat(siteSummary.getTitle(), is("[기자단]페가수스를 타고 세계 일주를 | 열린게시판 | ArcheAge"));
		logger.debug("\ntestFindOneThumnail_ArcheAge-------------------------------------------------------------------------------------");
		logger.debug(siteSummary.getTitle());
		logger.debug(siteSummary.getThumbnailImage());
		logger.debug(siteSummary.getContents());
		logger.debug("\ntestFindOneThumnail_ArcheAge-------------------------------------------------------------------------------------");

	}

	@Test
	public final void testFindOneThumnail_Tistory() throws Exception {
		SiteSummary siteSummary = summaryService.findOneThumbnail("http://eclipse4j.tistory.com/172");
		assertThat(siteSummary.getTitle(),
				is("0.2%의 짜증과 함께.. 개발은 언제나 즐겁다. | eclipse static import 등록과 Organize Import시 예외 처리."));

		logger.debug("\ntestFindOneThumnail_Tistory-------------------------------------------------------------------------------------");
		logger.debug(siteSummary.getTitle());
		logger.debug(siteSummary.getThumbnailImage());
		logger.debug(siteSummary.getContents());
		logger.debug(siteSummary.getTargetUrl());
		logger.debug("\ntestFindOneThumnail_Tistory-------------------------------------------------------------------------------------");

	}

	@Test
	public final void testFindOneThumnail_WindtaleNet() throws Exception {
		SiteSummary siteSummary = summaryService.findOneThumbnail("http://windtale.net/blog/sublime-text-tip/");
		assertThat(siteSummary.getTitle(), is("Sublime Text 2 유용한 기능과 단축키 정리 - WindTale"));
		logger.debug("\ntestFindOneThumnail_Tistory-------------------------------------------------------------------------------------");
		logger.debug(siteSummary.getTitle());
		logger.debug(siteSummary.getThumbnailImage());
		logger.debug(siteSummary.getContents());
		logger.debug(siteSummary.getTargetUrl());
		logger.debug("\ntestFindOneThumnail_Tistory-------------------------------------------------------------------------------------");

	}
}

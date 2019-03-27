package dao.dtt.inProcessCard;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class InProcessCardDAO 
{
	ApplicationContext context;
	public JdbcTemplate temp;
	public InProcessCardDAO()
	{
		context = new ClassPathXmlApplicationContext("spring-config.xml");
		temp = (JdbcTemplate)context.getBean("jtemp");
	}
	public List<InProcessCard> getInProcessCardList()
	{
		List<InProcessCard> InProcessCardList =  temp.query("select tr.training_request_id,e.first_name,"
				+ "e.last_name,tr.request_training_module,"
				+ "tr.request_training_type,ts.training_start_date,ts.training_end_date,tr.request_approx_participant,"
				+ "ts.training_city,s.status,dtr.dtt_training_id "
				+ "from DEVELOP_TEAM_TRAINING_REQUEST dtr "
				+ "join TRAINING_REQUEST tr on dtr.training_request_id = tr.training_request_id "
				+ "join TRAINING_SCHEDULE ts on dtr.schedule_id = ts.training_schedule_id "
				+ "join TRAINING_MANAGEMENT_STATUS s on tr.training_request_id = s.training_request_id "
				+ "join EMPLOYEE e on e.employee_id = tr.requester_id "
				+ "where s.status=203 or s.status=204 or s.status=205 or s.status=206 or s.status=207 "
				+ "or s.status=208 or s.status=209 ", 
				new Object[]{},new InProcessCardMapper());
		return InProcessCardList;
	}
	public InProcessCard getInProcessCard(int id)
	{
		List<InProcessCard> inProcessCard =  temp.query("select tr.training_request_id,e.first_name,"
				+ "e.last_name,tr.request_training_module,"
				+ "tr.request_training_type,ts.training_start_date,ts.training_end_date,tr.request_approx_participant,"
				+ "ts.training_city,s.status,dtr.dtt_training_id "
				+ "from DEVELOP_TEAM_TRAINING_REQUEST dtr "
				+ "join TRAINING_REQUEST tr on dtr.training_request_id = tr.training_request_id "
				+ "join TRAINING_SCHEDULE ts on dtr.schedule_id = ts.training_schedule_id "
				+ "join TRAINING_MANAGEMENT_STATUS s on tr.training_request_id = s.training_request_id "
				+ "join EMPLOYEE e on e.employee_id = tr.requester_id "
				+ "where s.status=203 or s.status=204 or s.status=205 or s.status=206 or s.status=207 "
				+ "or s.status=208 or s.status=209 ", 
				new Object[]{},new InProcessCardMapper());
		return inProcessCard.get(0);
	}
}

package dao.dtt.trainingSchedule;

import java.net.URL;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TrainingScheduleDAO 
{
	ApplicationContext context;
	public JdbcTemplate temp;
	public TrainingScheduleDAO()
	{
		context = new ClassPathXmlApplicationContext("spring-config.xml");
		temp = (JdbcTemplate)context.getBean("jtemp");
	}
	public List<TrainingSchedule> getTrainingSchedule()
	{
		List<TrainingSchedule> trainingScheduleList =  temp.query("select * from Training_Schedule", 
				new Object[]{},new TrainingScheduleMapper());
		return trainingScheduleList;
	}
	public void updateTrainingRequest(int training_schedule_id, String training_city, 
			String training_state, String training_country,	int training_zipcode, 
			String training_time_zone, String training_location, String training_room_number,
			Timestamp training_start_date, Timestamp training_end_date, String training_break_down, 
			URL training_url, String training_phone)
	{
		temp.update("update Training_Schedule set training_schedule_id=?,training_city=?,training_state=?"
				+ ",training_country=?,training_zipcode=?,training_time_zone=?"
				+ ",training_location=?,training_room_number=?training_start_date=?,training_end_date=?,"
				+ "training_break_down=?,training_url=?,training_phone=?", 
				new Object[]{training_city, training_state, 
						training_country, training_zipcode, training_time_zone, training_location,
						training_room_number, training_start_date, training_end_date, training_break_down, 
						training_url, training_phone,training_schedule_id});
	}
	public void insertTrainingSchedule( String training_city, 
			String training_state, String training_country,	int training_zipcode, 
			String training_time_zone, String training_location, String training_room_number,
			Timestamp training_start_date, Timestamp training_end_date, String training_break_down, 
			URL training_url, String training_phone)
	{
		temp.update("insert into Training_Schedule values"
				+ "(training_schedule_id_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?)",
				new Object[]{training_city, training_state, 
				training_country, training_zipcode, training_time_zone, training_location,
				training_room_number, training_start_date, training_end_date, training_break_down, 
				training_url, training_phone});
	}
	public void deleteTrainingSchedule(int training_schedule_id)
	{
		temp.update("delete from Training_Schedule where training_schedule_id=?",
				new Object[]{training_schedule_id});
	}
	public TrainingSchedule getTrainingSchedule(int training_schedule_id)
	{
		List<TrainingSchedule> trainingSchedule =  temp.query("select * from Training_Schedule where training_schedule_id=?", 
				new Object[]{training_schedule_id},new TrainingScheduleMapper());
		return trainingSchedule.get(0);
	}
}

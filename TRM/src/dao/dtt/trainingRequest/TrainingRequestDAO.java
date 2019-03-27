package dao.dtt.trainingRequest;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TrainingRequestDAO 
{
	ApplicationContext context;
	public JdbcTemplate temp;
	public TrainingRequestDAO()
	{
		context = new ClassPathXmlApplicationContext("spring-config.xml");
		temp = (JdbcTemplate)context.getBean("jtemp");
	}
	public List<TrainingRequest> getTrainingRequests()
	{
		List<TrainingRequest> trainingRequestList =  temp.query("select * from Training_Request", 
				new Object[]{},new TrainingRequestMapper());
		return trainingRequestList;
	}
	public void updateTrainingRequest(int requester_id,String request_training_type,
			String request_training_module,String request_training_module_scope,String request_training_mode,
			Timestamp request_start_date,Timestamp request_end_date,String request_location,
			String request_time_zone,int request_approx_participant,
			Timestamp time_requested,String justification_of_request,int training_request_id)
	{
		temp.update("update Training_Request set request_training_type=?"
				+ ",request_training_module=?,request_training_module_scope=?,request_training_mode=?"
				+ ",request_start_date=?,request_end_date=?request_location=?,request_time_zone=?,"
				+ "request_approx_participant=?,time_requested=?,"
				+ "justification_of_request=? where training_request_id=?", 
				new Object[]{request_training_type,request_training_module,
				request_training_module_scope,request_training_mode,request_start_date,request_end_date,
				request_location,request_time_zone,request_approx_participant,
				time_requested,justification_of_request,training_request_id});
	}
	public void insertTrainingRequest(int requester_id,String vertical,String request_training_type,
			String request_training_module,String request_training_module_scope,String request_training_mode,
			Timestamp request_start_date,Timestamp request_end_date,String request_location,
			String request_time_zone,int request_approx_participant,int request_project_spoc,
			Timestamp time_requested,String justification_of_request)
	{
		temp.update("insert into Training_Request values(training_id_request_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
				new Object[]{requester_id,vertical,request_training_type,request_training_module,
				request_training_module_scope,request_training_mode,request_start_date,request_end_date,
				request_location,request_time_zone,request_approx_participant,request_project_spoc,
				time_requested,justification_of_request});
	}
	public void deleteTrainingRequest(int training_request_id)
	{
		temp.update("delete from Training_Request where training_request_id=?",new Object[]{
				training_request_id});
	}
	public TrainingRequest getTrainingRequest(int training_request_id)
	{
		List<TrainingRequest> trainingRequest =  temp.query("select * from Training_Request where training_request_id=?", 
				new Object[]{training_request_id},new TrainingRequestMapper());
		return trainingRequest.get(0);
	}
}

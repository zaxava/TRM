package dao.dtt.summary;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dao.dtt.developTeamTrainingRequest.DDTTraining;
import dao.dtt.developTeamTrainerRequest.DDTTrainer;
import dao.dtt.employee.Employee;
import dao.dtt.trainingManagementStatus.ManagmentStatus;
import dao.dtt.trainingRequest.TrainingRequest;
import dao.dtt.trainingSchedule.TrainingSchedule;
import dao.dtt.trainingSchedule.TrainingScheduleMapper;

public class SummaryMapper implements RowMapper<Summary> 
{

	@Override
	public Summary mapRow(ResultSet result, int arg1) throws SQLException {
		Summary sl = new Summary();
		
		DDTTraining training = new DDTTraining();
		training.setDtt_training_id(result.getInt("dtt_training_id"));
		sl.setTraining(training);
		
		TrainingRequest request = new TrainingRequest();
		request.setTraining_request_id(result.getInt("training_request_id"));
		request.setRequest_training_type(result.getString("request_training_type"));
		request.setRequest_training_module(result.getString("request_training_module"));
		sl.setRequest(request);
		
		TrainingSchedule schedule = new TrainingSchedule();
		schedule = new TrainingScheduleMapper().mapRow(result, arg1);
		sl.setSchedule(schedule);
		
		Employee projectManager = new Employee();
		projectManager.setFirst_name(result.getString("first_name"));
		projectManager.setLast_name(result.getString("last_name"));
		sl.setProjectManager(projectManager);
		
		DDTTrainer trainer = new DDTTrainer();
		trainer.setRequest_sent_date(result.getString("request_sent_date"));
		trainer.setResponse(result.getString("response"));
		trainer.setActive_status(result.getInt("active_status"));
		sl.setTrainer(trainer);
		
		Employee currentTrainer = new Employee();
		currentTrainer.setFirst_name(result.getString("first_name"));
		currentTrainer.setLast_name(result.getString("last_name"));
		sl.setCurrentTrainer(currentTrainer);
		
		ManagmentStatus status = new ManagmentStatus();
		status.setStatus(result.getInt("status"));
		sl.setStatus(status);
		
		
		
		
		
		
		
		return sl;
	}

}

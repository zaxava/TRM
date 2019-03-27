package dao.dtt.inTrainingCard;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dao.dtt.developTeamTrainingRequest.DDTTraining;
import dao.dtt.employee.Employee;
import dao.dtt.executiveWorkflowStatus.ExecutiveWorkflow;
import dao.dtt.executiveWorkflowStatus.ExecutiveWorkflowMapper;
import dao.dtt.trainingManagementStatus.ManagmentStatus;
import dao.dtt.trainingRequest.TrainingRequest;
import dao.dtt.trainingSchedule.TrainingSchedule;

public class InTrainingCardMapper implements RowMapper<InTrainingCard>
{

	@Override
	public InTrainingCard mapRow(ResultSet result, int arg1) throws SQLException {
		InTrainingCard itc = new InTrainingCard();
		
		DDTTraining training = new DDTTraining();
		training.setDtt_training_id(result.getInt("dtt_training_id"));
		itc.setTraining(training);
		
		TrainingRequest request = new TrainingRequest();
		request.setTraining_request_id(result.getInt("training_request_id"));
		request.setRequest_training_module(result.getString("request_training_module"));
		itc.setRequest(request);
		
		TrainingSchedule schedule = new TrainingSchedule();
		schedule.setTraining_start_date(result.getString("training_start_date"));
		schedule.setTraining_end_date(result.getString("training_end_date"));
		itc.setSchedule(schedule);
		
		ManagmentStatus status =  new ManagmentStatus();
		status.setStatus(result.getInt("status"));
		itc.setStatus(status);
		
		Employee pm = new Employee();
		pm.setFirst_name(result.getString("first_name"));
		pm.setLast_name(result.getString("last_name"));
		itc.setPm(pm);
		
		Employee ct = new Employee();
		ct.setFirst_name(result.getString("first_name"));
		ct.setLast_name(result.getString("last_name"));
		itc.setCt(ct);
		
		ExecutiveWorkflow workflow = new ExecutiveWorkflow();
		workflow = new ExecutiveWorkflowMapper().mapRow(result, arg1);
		itc.setWorkflow(workflow);

		return itc;
	}

}

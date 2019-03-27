package dao.dtt.developTeamTrainingRequest;

import dao.dtt.developTeamTrainerRequest.DDTTrainer;
import dao.dtt.developTeamTrainerRequest.DDTTrainerDOA;
import dao.dtt.employee.Employee;
import dao.dtt.employee.EmployeeDAO;
import dao.dtt.trainingRequest.TrainingRequest;
import dao.dtt.trainingRequest.TrainingRequestDAO;
import dao.dtt.trainingSchedule.TrainingSchedule;
import dao.dtt.trainingSchedule.TrainingScheduleDAO;

public class DDTTraining {
	private int Dtt_training_id;
	private int training_request_id;
	private int trainer_request_id;
	private int schedule_id;
	private int executive_id;
	private String trainer_approval_mail;
	private String trainer_manager_approval_mail;
	private String description_of_status;
	
	public Employee getEmployeeDetails(int employee_id)
	{
		EmployeeDAO ed = new EmployeeDAO();
		Employee e = ed.getEmployee(employee_id);
		return e;	
	}
	
	public TrainingRequest getRequest(int training_request_id)
	{
		TrainingRequestDAO trd = new TrainingRequestDAO();
		TrainingRequest tr = trd.getTrainingRequest(training_request_id);
		return tr;		
	}
	
	public TrainingSchedule getSchedule(int schedule_id)
	{
		TrainingScheduleDAO tsd = new TrainingScheduleDAO();
		TrainingSchedule ts = tsd.getTrainingSchedule(schedule_id);
		return ts;
	}
	
	public DDTTrainer getTrainer(int trainer_request_id)
	{
		DDTTrainerDOA trnd = new DDTTrainerDOA();
		DDTTrainer trn = trnd.getDDTTrainer(trainer_request_id);
		return trn;
	}
	
	public int getDtt_training_id() {
		return Dtt_training_id;
	}
	public void setDtt_training_id(int setDtt_training_id) {
		this.Dtt_training_id = setDtt_training_id;
	}
	public int getTraining_request_id() {
		return training_request_id;
	}
	public void setTraining_request_id(int training_request_id) {
		this.training_request_id = training_request_id;
	}
	public int getTrainer_request_id() {
		return trainer_request_id;
	}
	public void setTrainer_request_id(int trainer_request_id) {
		this.trainer_request_id = trainer_request_id;
	}
	public int getSchedule_id() {
		return schedule_id;
	}
	public void setSchedule_id(int schedule_id) {
		this.schedule_id = schedule_id;
	}
	public int getExecutive_id() {
		return executive_id;
	}
	public void setExecutive_id(int executive_id) {
		this.executive_id = executive_id;
	}
	public String getTrainer_approval_mail() {
		return trainer_approval_mail;
	}
	public void setTrainer_approval_mail(String trainer_approval_mail) {
		this.trainer_approval_mail = trainer_approval_mail;
	}
	public String getTrainer_manager_approval_mail() {
		return trainer_manager_approval_mail;
	}
	public void setTrainer_manager_approval_mail(
			String trainer_manager_approval_mail) {
		this.trainer_manager_approval_mail = trainer_manager_approval_mail;
	}
	public String getDescription_of_status() {
		return description_of_status;
	}
	public void setDescription_of_status(String description_of_status) {
		this.description_of_status = description_of_status;
	}
}

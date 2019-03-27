package dao.dtt.trainingManagementStatus;

import dao.dtt.trainingRequest.TrainingRequest;
import dao.dtt.trainingRequest.TrainingRequestDAO;

public class ManagmentStatus {
	private int training_management_status_id;
	private int training_request_id;
	private int status;
	
	public TrainingRequest getRequest(int training_request_id)
	{
		TrainingRequestDAO trd = new TrainingRequestDAO();
		TrainingRequest tr = trd.getTrainingRequest(training_request_id);
		return tr;		
	}
	
	public int getTraining_management_status_id() {
		return training_management_status_id;
	}
	public void setTraining_management_status_id(int training_management_status_id) {
		this.training_management_status_id = training_management_status_id;
	}
	public int getTraining_request_id() {
		return training_request_id;
	}
	public void setTraining_request_id(int training_request_id) {
		this.training_request_id = training_request_id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}

package Model;

public class SpendRecord {
	protected String UserName;
	protected String TaskName;
	protected String CreateTime;
	protected double Value;
	
	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getTaskName() {
		return TaskName;
	}

	public void setTaskName(String taskName) {
		TaskName = taskName;
	}

	public String getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}


	public double getValue() {
		return Value;
	}

	public void setValue(double value) {
		Value = value;
	}

	public SpendRecord(String UserName, String TaskName, String CreateTime, double Value){
		this.UserName = UserName;
		this.TaskName = TaskName;
		this.CreateTime = CreateTime;
		this.Value = Value;
	}
	
	
}

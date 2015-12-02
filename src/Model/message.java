package Model;

public class message {
	protected String SourceName;
	protected String TargetName;
	protected String SendTime;
	protected String Title;
	protected String Content;
	
	public message (String SourceName, String TargetName, String SendTime, String Title, String Content){
		this.SourceName = SourceName;
		this.TargetName = TargetName;
		this.SendTime = SendTime;
		this.Title = Title;
		this.Content = Content;
	}

	public String getSourceName() {
		return SourceName;
	}

	public void setSourceName(String sourceName) {
		SourceName = sourceName;
	}

	public String getTargetName() {
		return TargetName;
	}

	public void setTargetName(String targetName) {
		TargetName = targetName;
	}

	public String getSendTime() {
		return SendTime;
	}

	public void setSendTime(String sendTime) {
		SendTime = sendTime;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
}

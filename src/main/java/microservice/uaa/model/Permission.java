package microservice.uaa.model;

public class Permission {
		Boolean canLog;
		Boolean canPost;
		public Boolean getCanLog() {
			return canLog;
		}
		public void setCanLog(Boolean canLog) {
			this.canLog = canLog;
		}
		public Boolean getCanPost() {
			return canPost;
		}
		public void setCanPost(Boolean canPost) {
			this.canPost = canPost;
		}
} 
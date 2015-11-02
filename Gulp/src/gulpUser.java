import java.io.Serializable;


public class gulpUser implements Serializable {
private int  gulpUserId;
private String gulpUserEmail;
private String  gulpUserZipcode;
private String gulpUserName;
private String gulpUserUsername;
private String gulpUserPassword;

public gulpUser(){
	
}
public int getGulpUserId() {
	return gulpUserId;
}
public void setgulpUserId(int gulpUserId) {
	this.gulpUserId = gulpUserId;
}
public String getGulpUserEmail() {
	return gulpUserEmail;
}
public void setgulpUserEmail(String gulpUserEmail) {
	this.gulpUserEmail = gulpUserEmail;
}
public String getgulpUserZipcode() {
	return gulpUserZipcode;
}
public void setgulpUserZipcode(String gulpUserZipcode) {
	this.gulpUserZipcode = gulpUserZipcode;
}
public String getgulpUserName() {
	return gulpUserName;
}
public void setgulpUserName(String gulpUserName) {
	this.gulpUserName = gulpUserName;
}
public String getgulpUserUsername() {
	return gulpUserUsername;
}
public void setgulpUserUsername(String gulpUserUsername) {
	this.gulpUserUsername = gulpUserUsername;
}
public String getgulpUserPassword() {
	return gulpUserPassword;
}
public void setgulpUserPassword(String gulpUserPassword) {
	this.gulpUserPassword = gulpUserPassword;
}


}

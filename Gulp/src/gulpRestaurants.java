import java.io.Serializable;


public class gulpRestaurants implements Serializable {
	private int   gulpRestaurantsid;
	private String  gulpRestaurantsName;
	private String  gulpRestaurantsDescription;
	
	public gulpRestaurants(){
		
	}
	public int getGulpRestaurantsid() {
		return gulpRestaurantsid;
	}
	public void setGulpRestaurantsid(int gulpRestaurantsid) {
		this.gulpRestaurantsid = gulpRestaurantsid;
	}
	public String getGulpRestaurantsName() {
		return gulpRestaurantsName;
	}
	public void setGulpRestaurantsName(String gulpRestaurantsName) {
		this.gulpRestaurantsName = gulpRestaurantsName;
	}
	public String getGulpRestaurantsDescription() {
		return gulpRestaurantsDescription;
	}
	public void setGulpRestaurantsDescription(String gulpRestaurantsDescription) {
		this.gulpRestaurantsDescription = gulpRestaurantsDescription;
	}
	
	
	

}

import java.io.Serializable;


public class ListRestaurants implements Serializable {
	private String name;
	private String description;
	private String avgRate;
	
	public ListRestaurants(){
		
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAvgRate() {
		return avgRate;
	}

	public void setAvgRate(String avgRate) {
		this.avgRate = avgRate;
	}

}

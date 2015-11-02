import java.io.Serializable;
import java.util.ArrayList;

public class RateReview implements Serializable {
	private String avgRate;
	private ArrayList<Review> reviews;
	
	public RateReview(){
		
	}

	public String getAvgRate() {
		return avgRate;
	}

	public void setAvgRate(String avgRate) {
		this.avgRate = avgRate;
	}

	public ArrayList<Review> getReviews() {
		return reviews;
	}

	public void setReviews(ArrayList<Review> reviews) {
		this.reviews = reviews;
	}
	

}
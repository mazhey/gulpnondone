import java.io.Serializable;

public class Review implements Serializable {
	private String review;
	private String reviewDate;
	
	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}

	public Review(){
		
	}

}
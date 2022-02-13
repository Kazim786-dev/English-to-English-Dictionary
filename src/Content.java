
public class Content implements Comparable {

	private String word, meaning;

	//getters and setters
	
	
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	public Content(String word, String meaning) {
		
		this.word = word;
		this.meaning = meaning;
	}


	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String toString() {
		return "Content [word=" + word + ", meaning=" + meaning + "]\n";
	}

	
	
	
}

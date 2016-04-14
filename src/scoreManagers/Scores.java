package scoreManagers;

public class Scores {
	private  String pseudo;
	private  int score;
	
	public Scores(String pseudo, int score){
		this.pseudo = pseudo;
		this.score = score;
	}
	
	
//	public void saveScore(){
//		try {
//			fM.writeScore(this);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	public String getPseudo() {
		return pseudo;
	}


	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Pseudo: "+pseudo)
		.append(" - "+score);
		return sb.toString();
	}
	
	
}

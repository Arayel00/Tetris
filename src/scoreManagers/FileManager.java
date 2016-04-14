package scoreManagers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {
	private File scoresFile = new File("scores.txt");
	
	public FileManager() {
		// TODO Auto-generated constructor stub
	}
	
	public void writeScore(Scores score) throws Exception {
		// Test if file exists
		String ScoreString = score.getPseudo() +"~"+ score.getScore() + "\n";	
		FileWriter fileWriter = new FileWriter(scoresFile, true);
		fileWriter.append(ScoreString);
		fileWriter.close();
	}
	
	public ArrayList<Scores> getScores() throws IOException{
		
		String line;
		ArrayList<Scores> scores = new ArrayList<Scores>();
		FileReader fileReader = new FileReader(scoresFile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		while((line = bufferedReader.readLine()) != null) {
			scores.add(new Scores(line.split("~")[0], Integer.valueOf(line.split("~")[1])));
		}
		bufferedReader.close();
		return scores;
	}
}

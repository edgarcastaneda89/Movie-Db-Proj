package semesterprojectmain;
import java.util.ArrayList;
import java.util.*;
import java.io.*;

public class FileIO {
	 private String fileName;

	    public FileIO(String fileName) {
	        this.fileName = fileName;
	    }

	    public ArrayList<Movie> loadMovies() {
	        ArrayList<Movie> movies = new ArrayList<>();
	        try {
	            BufferedReader br = new BufferedReader(new FileReader(fileName));
	            String line;
	            while ((line = br.readLine()) != null) {
	                StringTokenizer st = new StringTokenizer(line, "|");
	                String title = st.nextToken();
	                int year = Integer.parseInt(st.nextToken());
	                int runtime = Integer.parseInt(st.nextToken());
	                String actor1 = st.nextToken();
	                String actor2 = st.nextToken();
	                String director = st.nextToken();
	                movies.add(new Movie(title, year, runtime, actor1, actor2, director));
	            }
	            br.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return movies;
	    }

	    public void saveMovies(ArrayList<Movie> movies) {
	        try {
	            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
	            for (Movie movie : movies) {
	                bw.write(movie.getTitle() + "|" + movie.getYear() + "|" + movie.getRuntime() + "|" + movie.getActor1() + "|" + movie.getActor2() + "|" + movie.getDirector());
	                bw.newLine();
	            }
	            bw.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}
	 
	

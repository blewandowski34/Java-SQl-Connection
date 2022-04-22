//Ben Lewandowski
//11/11/2021


import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Main {
	
	private static String username="root";
	private static String password = "aetna123";
	private static String servername = "localhost";
	private static int portnumber = 3306;
	private static String dbname = "cinema";
	private static Connection conn = null;
	
	// call to get a database connection
	public static Connection getConnection() throws SQLException {
		conn=null;
		Properties connectionProps = new Properties();
		connectionProps.put("user",  username);
		connectionProps.put("password",  password);
		conn = DriverManager.getConnection("jdbc:mysql://" +
		        servername + ":" + portnumber + "/" + dbname,  connectionProps);
		return conn;
	}
	

	
	
	//Scanner for user input
	public static Scanner keyboard = new Scanner(System.in);
	
	/*This is the menu class that shows the user the options for their 
	 * selection. It uses the scanner to get the user input for their
	   option choice */ 
	public static int menu() {
		try {
			int option = 0;
			while (option < 1 || option > 7){
				System.out.println("\n\nVIDEO RENTAL LIBRARY");
				System.out.println("OPTION\t\t\tTASK");
				System.out.println("1\tLIST TITLES FOR A PARTICULAR STAR");
				System.out.println("2\tLIST THE MOVIE TITLES AND STAR NAMES OF ALL MOVIES OF A PARTICULAR GENRE");
				System.out.println("3\tLIST THE MOVIES TITLES FOR THOSE MOVIES RELEASED IN A PARTICULAR YEAR");
				System.out.println("4\tLIST THE MOVIE GENRES");
				System.out.println("5\tLIST THE NAMES OF THE STARS FOR MOVIES OF A PARTICULAR GENRE");
				System.out.println("6\tLIST THE MOVIES THAT CONTAIN PARTICULAR WORDS OR PHRASES");
				System.out.println("7\tQUIT");
				System.out.println("ENTER CHOICE:");
				option = keyboard.nextInt();
			}
		
			return option;
		}	catch(Exception e) { e.printStackTrace(); }
		
		return -1;
	}

	public static void main(String[] args) {
		
		
		//calls the connection method
		try {
			conn=getConnection();
			System.out.println("debugging, connected to the database");
		} catch(SQLException e) {
			System.out.println("ERROR Could not connect to the database");
			e.printStackTrace();
			return;
		}
		
		
		//intitializes user input variables
		int menuoption, whichYear = 0;
		String whichStar, whichGenre, whichPhrase = "";
		
		
		
		
		menuoption = menu();
		
		//user selection menu
		while(menuoption != 7) {
		switch (menuoption) {
		case 1: // List stars for single movie
			System.out.println("Which Star?: ");
			keyboard.nextLine();
			whichStar = keyboard.nextLine();
	    	listStarMovies(whichStar);
	    	break;
	    case 2: // List movies and their stars for particular genre
	    	System.out.println("Which genre?: ");
	    	keyboard.nextLine();
	    	whichGenre = keyboard.nextLine();
	    	listStarsMoviesByGenre(whichGenre);
	    	break;
	    case 3: // List movie title for a particular year
	    	System.out.println("Which year?: ");
	    	keyboard.nextLine();
	    	whichYear = keyboard.nextInt();
	     	listMoviesInYear(whichYear);
	     	break;
	    case 4: // List each of the movie genres
	    	listGenres();
	    	break;
	    case 5: // List stars of movies in a particular genre
	    	System.out.println("Which Genre?: ");
	    	keyboard.nextLine();
	    	whichGenre = keyboard.nextLine();
	    	listGenreStars(whichGenre);
	    	break;
		case 6: //List movies with particular phrase
			System.out.println("Which word or phrase?:");
			keyboard.nextLine();
			whichPhrase = keyboard.nextLine();
			listMoviesWithPhrase(whichPhrase);
			break;
		case 7: //ends the program
			System.out.println("QUIT");
			System.exit(0);
			
			
		default: System.out.println("Exception error!");
		

	}
		
		menuoption = menu();
		}
		
	}
	
	//lists all the movie titles that a selected star appears in.
	public static void listStarMovies(String whichStar) {
		try { 
			String query = "SELECT movies.movieTitle FROM stars " +
		        " INNER JOIN movies ON stars.starID=movies.starID " +		
					" WHERE stars.star_name =  '" + whichStar + "';"  ;
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(query);
			System.out.println("\nTHESE ARE THE MOVIES " + whichStar + " IS IN:");
			while (rs.next()) {
				String movieTitle = rs.getString("movieTitle");
				System.out.println(movieTitle);
			}
		} catch (SQLException e) { e.printStackTrace();}
		
	}
	
	//lists the movie titles and the stars in them within a given genre
	public static void listStarsMoviesByGenre(String whichGenre) {
		try { 
			String query = "SELECT movieTitle, star_name FROM Movies " +
	        " INNER JOIN stars ON movies.starID = stars.starID " +		
					" WHERE genre = '" + whichGenre + "';"  ;
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(query);
			System.out.println("\nTHESE ARE THE MOVIES AND THEIR STARS IN THE GENRE '" + whichGenre + "':");
			while (rs.next()) {
				String movieTitle = rs.getString("movieTitle");
				String starName = rs.getString("star_name");
			System.out.println(movieTitle);
			System.out.println(starName);
			}
		} catch (SQLException e) { e.printStackTrace();}
		
	}
	
	//Lists all of the movies released in a specific year
	public static void listMoviesInYear(int whichYear) {
		try { 
			String query = "SELECT movieTitle FROM movies " +
		      	" WHERE dateReleased = " + whichYear + ";";
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(query);
			System.out.println("\nTHESE ARE THE MOVIES RELEASED IN " + whichYear + ":");
			while (rs.next()) {
				String movieTitle = rs.getString("movieTitle");
				System.out.println(movieTitle);
			}
		} catch (SQLException e) { e.printStackTrace();}
		
	}
	
	//Lists all of the distinct genres of movies within the database
	public static void listGenres() {
		try { 
			String query = "SELECT DISTINCT genre FROM movies;";
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(query);
			System.out.println("\nTHESE ARE ALL THE GENRES OF MOVIES:");
			while (rs.next()) {
				String genre = rs.getString("genre");
				System.out.println(genre);
			}
		} catch (SQLException e) { e.printStackTrace();}
		
	}
	
	//lists stars of movies of a particular genre
	public static void listGenreStars(String whichGenre) {
		try { 
			String query = "SELECT stars.star_name FROM movies " +
					" INNER JOIN stars ON movies.starID=stars.starID " +
		      	" WHERE genre = '" + whichGenre + "';";
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(query);
			System.out.println("\nTHESE ARE THE STARS IN MOVIES OF GENRE " + whichGenre + ":");
			while (rs.next()) {
				String starName = rs.getString("star_name");
				System.out.println(starName);
			}
		} catch (SQLException e) { e.printStackTrace();}
		
	}
	
	//list movies containing the phrase entered by the user
	public static void listMoviesWithPhrase(String whichPhrase) {
		try { 
			String query = "SELECT movieTitle FROM movies " +
				" WHERE movieTitle LIKE '%" + whichPhrase + "%';";
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(query);
			System.out.println("\nTHESE ARE THE MOVIES WITH THE PHRASE '" + whichPhrase + "':");
			while (rs.next()) {
				String movieTitle = rs.getString("movieTitle");
				System.out.println(movieTitle);
			}
		} catch (SQLException e) { e.printStackTrace();}
		
	}
}



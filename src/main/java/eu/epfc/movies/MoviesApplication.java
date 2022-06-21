package eu.epfc.movies;
import eu.epfc.movies.entities.Movie;
import eu.epfc.movies.repositories.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MoviesApplication implements CommandLineRunner {
	private MovieRepository movieRepository;

	public MoviesApplication(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Movie> movies = new ArrayList<>();
		movies.add(new Movie(null, "Forrest Gump", "Quelques décennies d'histoire américaine, des années 1940 à la fin du XXème siècle, à travers le regard et l'étrange odyssée d'un homme simple et pur, Forrest Gump.", 2015, "Tom Hanks, Gary Sinise, Robin Wright", "Robert Zemeckis"));
		movies.add(new Movie(null,"La Liste de Schindler", "Evocation des années de guerre d'Oskar Schindler, industriel autrichien rentré à Cracovie en 1939 avec les troupes allemandes. Il va, tout au long de la guerre, protéger des juifs en les faisant travailler dans sa fabrique.", 2019, "Liam Neeson, Ben Kingsley, Ralph Fiennes", "Steven Spielberg"));
		movies.add(new Movie(null,"12 hommes en colère","Lors d'un procès, un juré émet l'hypothèse que l'homme qu'il doit juger n'est peut-être pas coupable. Il va tenter de convaincre les onze autres jurés.",2007,"Henry Fonda, Martin Balsam, John Fiedler","Sidney Lumet"));
		movies.add(new Movie(null,"Le Roi Lion","Le long combat de Simba le lionceau pour accéder à son rang de roi des animaux, après que le fourbe Scar, son oncle, a tué son père et pris sa place.",2012,"Emmanuel Curtil, Matthew Broderick, Dimitri Rougeul","Roger Allers, Rob Minkoff"));
		movies.add(new Movie(null,"Vol au-dessus d'un nid de coucou","Rebellion dans un hôpital psychiatrique à l'instigation d'un malade qui se révolte contre la dureté d'une infirmière.",2009,"Michael Berryman, Dean R. Brooks, Jack Nicholson","Milos Forman"));
		movies.add(new Movie(null,"Star Wars : Episode V - L'Empire contre-attaque","Malgré la destruction de l'Etoile Noire, l'Empire maintient son emprise sur la galaxie, et poursuit sans relâche sa lutte contre l'Alliance rebelle. Basés sur la planète glacée de Hoth, les rebelles essuient un assaut des troupes impériales...",1997,"Mark Hamill, Harrison Ford, Carrie Fisher"," Irvin Kershner"));
		movies.add(new Movie(null,"Les Sentiers de la gloire","Durant la Première Guerre mondiale, le général français Mireau lance une offensive suicidaire contre une position allemande imprenable. Au moment de l'attaque, les soldats tombent par dizaines et leurs compagnons refusent d'avancer...",2011,"Avec Kirk Douglas, Ralph Meeker, Adolphe Menjou","Stanley Kubrick"));
		movies.add(new Movie(null,"La Grande Vadrouille","En 1942, un avion anglais est abattu par les Allemands au-dessus de Paris. Les trois pilotes sautent en parachute et atterrissent dans différents endroits de la capitale",2016,"Bourvil, Louis de Funès, Claudio Brook"," Gérard Oury"));
		movies.add(new Movie(null,"La Nuit du chasseur","Un prêcheur inquiétant poursuit dans l'Amérique rurale deux enfants dont le père vient d'être condamné pour vol et meurtre. Avant son incarcération, le père leur avait confié dix mille dollars, dont ils ne doivent révéler l'existence à personne...",2011,"obert Mitchum, Shelley Winters, Lillian Gish","harles Laughton"));
//	    movieRepository.saveAll(movies);
	}
}

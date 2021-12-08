package com.anthony.MovieDB;

import com.anthony.MovieDB.model.Genre;
import com.anthony.MovieDB.model.Title;
import com.anthony.MovieDB.model.Poster;
import com.anthony.MovieDB.repo.GenreRepo;
import com.anthony.MovieDB.repo.TitleRepo;
import com.anthony.MovieDB.repo.PosterRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MovieDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieDbApplication.class, args);
	}

	@Bean
	CommandLineRunner run(TitleRepo titleRepo,
						  PosterRepo posterRepo,
						  GenreRepo genreRepo) {
		return args -> {
			Title title = new Title(null, "Spider-Man", "Tobey Maguire returns", null, true, null, null, null);
			Title title1 = new Title(null, "Iron-Man", "Tony Stark is the best", null, false, null, null, null);
			titleRepo.save(title);
			titleRepo.save(title1);


			posterRepo.save(new Poster(null, "https://www.themoviedb.org/t/p/original/fVzXp3NwovUlLe7fvoRynCmBPNc.jpg", title));
			posterRepo.save(new Poster(null, "https://www.themoviedb.org/t/p/original/kxFxtYdaIaGsp3N9KEtPSj7yqEE.jpg", title));

			Genre genre2 = new Genre(null, "Drama", null);
			Genre genre3 = new Genre(null, "Crime", null);
			Genre genre4 = new Genre(null, "Horror", null);
			genreRepo.save(genre2);
			genreRepo.save(genre3);
			genreRepo.save(genre4);

		};
	}

}

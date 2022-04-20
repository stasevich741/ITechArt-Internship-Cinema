package cinema.service;

import cinema.dao.FilmDao;
import cinema.entity.Film;

import java.util.List;

public class FilmService {

   private FilmDao filmDao;

    public FilmService(FilmDao filmDao) {
        this.filmDao = filmDao;
    }

    public void showFilms() {
        List<Film> films = filmDao.findAll();
        for (Film film : films) {
            System.out.println(film);
        }
    }
}

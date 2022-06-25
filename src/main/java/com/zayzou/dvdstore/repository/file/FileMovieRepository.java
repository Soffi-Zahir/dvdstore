package com.zayzou.dvdstore.repository.file;

import com.zayzou.dvdstore.entity.Movie;
import com.zayzou.dvdstore.repository.MovieRepositoryInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Repository
public class FileMovieRepository implements MovieRepositoryInterface {

    @Value("${movies.file.location}")
    private File file;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void add(Movie movie) {
        FileWriter writer;
        try {
            writer = new FileWriter(this.getFile(), true);
            String info = movie.getTitle() + ";" + movie.getGenre();
            writer.write(info + "\n");
            writer.close();
            System.out.println(info + " Added successfully to file");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
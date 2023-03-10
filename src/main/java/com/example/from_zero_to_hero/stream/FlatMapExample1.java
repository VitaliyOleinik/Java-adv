package com.example.from_zero_to_hero.stream;

import java.util.Optional;

public class FlatMapExample1 {
    public String getAlbumCoverDesigner(){
        Musician musician = new Musician();

        return Optional.ofNullable(musician)
                .flatMap(Musician::getAlbum)
                .flatMap(Album::getCoverArt)
                .map(CoverArt::getDesigner)
                .orElse("No cover designed");
    }
}
class Musician {
    private Optional<Album> album;
    public Optional<Album> getAlbum() {
        return album;
    }
}

class Album {
    private Optional<CoverArt> art;
    public Optional<CoverArt> getCoverArt() {
        return art;
    }
}

class CoverArt {
    private String designer;
    public String getDesigner() {
        return designer;
    }
}

package stubailey18.stuflix.programs;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import stubailey18.stuflix.json.CsvDeserializer;
import stubailey18.stuflix.json.IntegerWithCommasDeserializer;
import stubailey18.stuflix.json.MonetaryAmountDeserializer;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProgramDetail {

    @JsonProperty("Title")
    private String title;

    @JsonProperty("Year")
    private String year;

    @JsonProperty("Rated")
    private String rating;

    @JsonProperty("Released")
    @JsonFormat(pattern = "dd MMM yyyy")
    private LocalDate releaseDate;

    @JsonProperty("Runtime")
    private String runtime;

    @JsonProperty("Genre")
    private String genre;

    @JsonProperty("Director")
    private String director;

    @JsonProperty("Writer")
    private String writer;

    @JsonProperty("Actors")
    @JsonDeserialize(using = CsvDeserializer.class)
    private String[] actors;

    @JsonProperty("Plot")
    private String plot;

    @JsonProperty("Language")
    private String language;

    @JsonProperty("Country")
    private String country;

    @JsonProperty("Awards")
    private String awards;

    @JsonProperty("Poster")
    private String poster;

    @JsonProperty("Ratings")
    private Rating[] ratings;

    @JsonProperty("Metascore")
    private String metascore;

    private double imdbRating;

    @JsonDeserialize(using = IntegerWithCommasDeserializer.class)
    private int imdbVotes;

    private String imdbId;

    @JsonProperty("Type")
    private String type;

    @JsonProperty("DVD")
    @JsonFormat(pattern = "dd MMM yyyy")
    private LocalDate toDvdDate;

    @JsonProperty("BoxOffice")
    @JsonDeserialize(using = MonetaryAmountDeserializer.class)
    private BigDecimal boxOfficeTake;

    public ProgramDetail() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String[] getActors() {
        return actors;
    }

    public void setActors(String[] actors) {
        this.actors = actors;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Rating[] getRatings() {
        return ratings;
    }

    public void setRatings(Rating[] ratings) {
        this.ratings = ratings;
    }

    public String getMetascore() {
        return metascore;
    }

    public void setMetascore(String metascore) {
        this.metascore = metascore;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }

    public int getImdbVotes() {
        return imdbVotes;
    }

    public void setImdbVotes(int imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getToDvdDate() {
        return toDvdDate;
    }

    public void setToDvdDate(LocalDate toDvdDate) {
        this.toDvdDate = toDvdDate;
    }

    public BigDecimal getBoxOfficeTake() {
        return boxOfficeTake;
    }

    public void setBoxOfficeTake(BigDecimal boxOfficeTake) {
        this.boxOfficeTake = boxOfficeTake;
    }
}

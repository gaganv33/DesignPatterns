package movie;

import java.time.LocalDate;
import java.time.LocalTime;

public class MovieDetails {
    private final String movieTheaterId;
    private final String movieScreenId;
    private final String movieName;
    private final LocalDate startDate;
    private final LocalTime startTime;
    private final LocalTime duration;

    public MovieDetails(Builder builder) {
        this.movieTheaterId = builder.movieTheaterId;
        this.movieScreenId = builder.movieScreenId;
        this.movieName = builder.movieName;
        this.startDate = builder.startDate;
        this.startTime = builder.startTime;
        this.duration = builder.duration;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getMovieTheaterId() {
        return movieTheaterId;
    }

    public String getMovieScreenId() {
        return movieScreenId;
    }

    public String getMovieName() {
        return movieName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public static class Builder {
        private String movieTheaterId;
        private String movieScreenId;
        private String movieName;
        private LocalDate startDate;
        private LocalTime startTime;
        private LocalTime duration;

        public Builder movieTheaterId(String movieTheaterId) {
            this.movieTheaterId = movieTheaterId;
            return this;
        }

        public Builder movieScreenId(String movieScreenId) {
            this.movieScreenId = movieScreenId;
            return this;
        }

        public Builder movieName(String movieName) {
            this.movieName = movieName;
            return this;
        }

        public Builder startDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder startTime(LocalTime startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder duration(LocalTime duration) {
            this.duration = duration;
            return this;
        }

        public MovieDetails build() {
            return new MovieDetails(this);
        }
    }
}

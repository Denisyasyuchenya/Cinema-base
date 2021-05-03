package info.movietrash.cinemabase.repository;

import info.movietrash.cinemabase.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}

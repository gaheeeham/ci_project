package org.example.ci_project.domain.shorturl;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ShortUrlRepository extends JpaRepository<ShortUrl, String> {

    // 1. WHERE code = ? (기본 findById로 해결 가능)

    // 2. WHERE url = ? LIMIT 1
    Optional<ShortUrl> findFirstByUrl(String url);
}
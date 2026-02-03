package org.example.ci_project.domain.shorturl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ShortUrlRepositoryTest {

    @Autowired
    private ShortUrlRepository shortUrlRepository;

    @Test
    @DisplayName("코드로 URL 정보를 조회한다")
    void find_by_code() {
        // Given
        ShortUrl sample = new ShortUrl("2D8EUd", "/original-path");
        shortUrlRepository.save(sample);

        // When
        ShortUrl found = shortUrlRepository.findById("2D8EUd").orElseThrow();

        // Then
        assertThat(found.getUrl()).isEqualTo("/original-path");
    }

    @Test
    @DisplayName("긴 URL로 단축 정보 하나를 조회한다 (LIMIT 1)")
    void find_by_url() {
        // Given
        String targetUrl = "/conts-copy?conts_info=20251105,4,20251105,4,ko,erter345324";
        shortUrlRepository.save(new ShortUrl("ABC123", targetUrl));

        // When
        ShortUrl found = shortUrlRepository.findFirstByUrl(targetUrl).orElseThrow();

        // Then
        assertThat(found.getCode()).isEqualTo("ABC123");
    }
}
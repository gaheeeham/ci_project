package org.example.ci_project.domain.shorturl;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "tbl_short_url", schema = "cms180") // 요청하신 테이블명과 스키마 적용
public class ShortUrl {

    @Id
    @Column(length = 10)
    private String code; // 2D8EUd 같은 단축 코드

    @Column(nullable = false, length = 500)
    private String url;  // 원래의 긴 URL

    @Column(name = "crt_dt")
    private LocalDateTime crtDt; // 생성일시

    public ShortUrl(String code, String url) {
        this.code = code;
        this.url = url;
        this.crtDt = LocalDateTime.now();
    }
}
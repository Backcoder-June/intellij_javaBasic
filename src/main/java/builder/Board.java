package builder;

import lombok.*;

@Setter @Getter @ToString
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode
@Builder // 빌더패턴
public class Board {
    private String title;
    private String content;
    private Long id;
    private String writer;

}

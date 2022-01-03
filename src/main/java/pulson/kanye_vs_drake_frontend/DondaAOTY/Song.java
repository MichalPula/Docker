package pulson.kanye_vs_drake_frontend.DondaAOTY;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Song {

    private Long id;
    private String title;

    public Song(String title) {
        this.title = title;
    }
}

package pulson.kanye_api.Kanye;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class DondaController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DondaController.class);
    private final SongService songService;

    @Autowired
    public DondaController(SongService songService){
        this.songService = songService;
        songService.saveSongs(getDondaSongs());
    }

    @GetMapping("/donda")
    public ResponseEntity<List<Song>> donda(){
        LOGGER.info("GET DONDA REQUEST");
        return ResponseEntity.ok().body(songService.getAllSongs());
    }



    private List<String> getDondaSongs(){
        return Stream.of("Donda Chant", "Jail", "God Breathed", "Off the Grid",
                        "Hurricane", "Praise God", "Jonah", "Ok Ok", "Junya", "Believe What I Say", "24",
                        "Remote Control", "Moon", "Heaven and Hell", "Donda", "Keep My Spirit Alive", "Jesus Lord",
                        "New Again", "Tell the Vision", "Lord I Need You", "Pure Souls", "Come to Life",
                        "No Child Left Behind", "Jail, Pt. 2", "Ok Ok, Pt. 2", "Junya, Pt. 2", "Jesus Lord, Pt. 2")
                .collect(Collectors.toList());
    }
}

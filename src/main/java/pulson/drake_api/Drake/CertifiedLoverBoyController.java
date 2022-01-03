package pulson.drake_api.Drake;

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
public class CertifiedLoverBoyController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CertifiedLoverBoyController.class);
    private final SongService songService;

    @Autowired
    public CertifiedLoverBoyController(SongService songService){
        this.songService = songService;
        songService.saveSongs(getCLBSongs());
    }

    @GetMapping("/clb")
    public ResponseEntity<List<Song>> donda(){
        LOGGER.info("GET CLB REQUEST");
        return ResponseEntity.ok().body(songService.getAllSongs());
    }



    private List<String> getCLBSongs(){
        return Stream.of("Champagne Poetry", "Papi's Home", "Girls Want Girls", "In the Bible", "Love All", "Fair Trade",
                        "Way 2 Sexy", "TSU", "N 2 Deep", "Pipe Down", "Yebba's Heartbreak", "No Friends in the Industry",
                        "Knife Talk", "7AM on Bridle Path", "Race My Mind", "Fountains", "Get Along Better",
                        "You Only Live Twice", "IMY2", "Fucking Fans", "The Remorse")
                .collect(Collectors.toList());
    }
}

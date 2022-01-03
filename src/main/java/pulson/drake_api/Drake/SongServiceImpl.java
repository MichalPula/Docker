package pulson.drake_api.Drake;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;

    @Autowired
    public SongServiceImpl(SongRepository songRepository){
        this.songRepository = songRepository;
    }

    @Override
    public void saveSongs(List<String> songsTitles) {
        List<Song> songsList = songsTitles.stream().map(Song::new).collect(Collectors.toList());
        songRepository.saveAll(songsList);
    }

    @Override
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }
}

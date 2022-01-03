package pulson.kanye_api.Kanye;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SongService {
    void saveSongs(List<String> songsTitles);
    List<Song> getAllSongs();
}

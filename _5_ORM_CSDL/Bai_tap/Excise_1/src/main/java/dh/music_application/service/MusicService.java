package dh.music_application.service;

import dh.music_application.model.Music;
import dh.music_application.repository.IMusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService {

    @Autowired
    private IMusicRepository iMusicRepository;

    public List<Music> findAll() {
        return this.iMusicRepository.findAll();
    }

    public void save(Music music) {

    }

    public Music findByID(int id) {
        return null;
    }

    public void update(int id, Music music) {

    }

    public void remove(int id) {

    }
}

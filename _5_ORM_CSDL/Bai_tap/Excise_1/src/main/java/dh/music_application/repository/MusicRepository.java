package dh.music_application.repository;

import dh.music_application.model.Music;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class MusicRepository implements IMusicRepository
{

    @Override
    public List<Music> findAll() {
        String queryStr = "select M from Music as M";
        TypedQuery<Music> query = ConnectionUtil.entityManager.createQuery(queryStr,Music.class);

        return query.getResultList();
    }

    @Override
    public void save(Music music) {

    }

    @Override
    public Music findByID(int id) {
        return null;
    }

    @Override
    public void update(int id, Music music) {

    }

    @Override
    public void remove(int id) {

    }
}

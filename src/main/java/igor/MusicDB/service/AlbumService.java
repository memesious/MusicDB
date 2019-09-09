package igor.MusicDB.service;


import igor.MusicDB.entity.AlbumEntity;
import igor.MusicDB.repository.AlbumRepository;
import igor.MusicDB.repository.SongRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlbumService {
  private final SongRepository songRepository;
  private final AlbumRepository albumRepository;

  public List<AlbumEntity> getAll(){
    return albumRepository.findAll();
  }
}

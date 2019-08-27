package igor.MusicDB.service;

import igor.MusicDB.entity.SongEntity;
import igor.MusicDB.repository.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SongService {

  private final SongRepository songRepository;

}

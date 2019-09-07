package igor.MusicDB.service;

import igor.MusicDB.dto.SongDto;
import igor.MusicDB.entity.SongEntity;
import igor.MusicDB.repository.AlbumRepository;
import igor.MusicDB.repository.ArtistRepository;
import igor.MusicDB.repository.SongRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SongService {

  private final SongRepository songRepository;
  private final AlbumRepository albumRepository;
  private final ArtistRepository artistRepository;

  public SongEntity toEntity(SongDto dto){
    return SongEntity.builder()
        .id(dto.getId())
        .name(dto.getName())
        .lyrics(dto.getLyrics())
        .albumEntityList(albumRepository.findAllById(dto.getAlbumId()))
        .artistEntityList(artistRepository.findAllById(dto.getArtistId()))
        .build();
  }

  public void save (SongDto song){
    songRepository.save(toEntity(song));
  }

  public List<SongDto> getAll(){
    return songRepository.findAll().stream()
        .map(SongEntity::toDto)
        .collect(Collectors.toList());
  }
}

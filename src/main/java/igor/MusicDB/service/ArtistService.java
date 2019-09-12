package igor.MusicDB.service;

import igor.MusicDB.dto.ArtistDto;
import igor.MusicDB.entity.ArtistEntity;
import igor.MusicDB.repository.ArtistRepository;
import igor.MusicDB.repository.SongRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArtistService {
private final ArtistRepository artistRepository;
private final SongRepository songRepository;
  //public List<ArtistEntity> getAll(){return artistRepository.findAll();}
  public List<ArtistDto> getAll(){
    return artistRepository.findAll().stream().map(ArtistEntity::toDto).collect(Collectors.toList());
  }

  public void save(ArtistDto artistDto){artistRepository.save(toEntity(artistDto));}

  private ArtistEntity toEntity(ArtistDto artistDto) {
    return ArtistEntity.builder()
        .id(artistDto.getId())
        .name(artistDto.getName())
        .songEntityList(songRepository.findAllById(artistDto.getSongIdList()))
        .build();

  }
  public void delete(Long id){artistRepository.deleteById(id);}
}

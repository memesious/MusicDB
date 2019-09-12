package igor.MusicDB.service;


import igor.MusicDB.dto.AlbumDto;
import igor.MusicDB.entity.AlbumEntity;
import igor.MusicDB.repository.AlbumRepository;
import igor.MusicDB.repository.SongRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlbumService {
  private final SongRepository songRepository;
  private final AlbumRepository albumRepository;

  public List<AlbumDto> getAll(){
    return albumRepository.findAll().stream()
        .map(AlbumEntity::toDto)
        .collect(Collectors.toList());
  }
  public AlbumEntity toEntity(AlbumDto dto){
    return AlbumEntity.builder()
        .id(dto.getId())
        .name(dto.getName())
        .year(dto.getYear())
        .songEntityList(songRepository.findAllById(dto.getSongIdList()))

        .build();
  }
  public void save(AlbumDto albumDto){albumRepository.save(toEntity(albumDto));}

  public void delete(Long id){albumRepository.deleteById(id);}
}

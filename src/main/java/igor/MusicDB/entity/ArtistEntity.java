package igor.MusicDB.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import igor.MusicDB.dto.AlbumDto;
import igor.MusicDB.dto.ArtistDto;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "artist")
public class ArtistEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @JsonIgnoreProperties("artistEntityList")
  @ManyToMany
  @JoinTable(
      name = "artist_jt",
      joinColumns = @JoinColumn(name = "artist_id"),
      inverseJoinColumns = @JoinColumn(name = "song_id"))
  List<SongEntity> songEntityList;

  public ArtistDto toDto(){
    return ArtistDto.builder()
        .id(id)
        .name(name)
        .songIdList(songEntityList.stream() .map(SongEntity::getId).collect(Collectors.toList()))
        .build();
  }

}

package igor.MusicDB.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import igor.MusicDB.dto.AlbumDto;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "album")
public class AlbumEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "year")
  private Integer year;

  @JsonIgnoreProperties("albumEntityList")
  @ManyToMany
  @JoinTable(
      name = "album_jt",
      joinColumns = @JoinColumn(name = "album_id"),
      inverseJoinColumns = @JoinColumn(name = "song_id"))
  List<SongEntity> songEntityList;

  public AlbumDto toDto(){
    return AlbumDto.builder()
        .id(id)
        .name(name)
        .year(year)
        .songIdList(songEntityList.stream() .map(SongEntity::getId).collect(Collectors.toList()))
        .build();
  }
}

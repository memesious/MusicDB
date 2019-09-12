package igor.MusicDB.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import igor.MusicDB.dto.SongDto;
import java.util.List;
import java.util.Set;
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
import lombok.ToString;
import lombok.ToString.Exclude;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "song")
//@ToString(exclude = {"albumEntityList"})

public class SongEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "year")
  private Integer year;

  @Column(name = "lyrics")
  private String lyrics;

  @JsonIgnoreProperties("songEntity")
  @ManyToMany
  @JoinTable(
      name = "artist_jt",
      joinColumns = @JoinColumn(name = "song_id"),
      inverseJoinColumns = @JoinColumn(name = "artist_id"))
  List<ArtistEntity> artistEntityList;

  @JsonIgnoreProperties("songEntityList")
  @ManyToMany
  @JoinTable(
      name = "album_jt",
      joinColumns = @JoinColumn(name = "song_id"),
      inverseJoinColumns = @JoinColumn(name = "album_id"))
  List<AlbumEntity> albumEntityList;

  public SongDto toDto () {
    return SongDto.builder()
        .id(id)
        .name(name)
        .lyrics(lyrics)

        .albumId(albumEntityList.stream()
            .map(AlbumEntity::getId)
            .collect(Collectors.toList()))

        .artistId(artistEntityList.stream()
            .map(ArtistEntity::getId)
            .collect(Collectors.toList()))

        .build();



  }

}

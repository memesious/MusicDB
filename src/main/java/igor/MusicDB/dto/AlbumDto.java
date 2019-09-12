package igor.MusicDB.dto;

import igor.MusicDB.entity.SongEntity;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class AlbumDto {
  private Long id;
  private String name;
  private Integer year;
  private List<Long> songIdList;
 // private List<Long> artistIdList;
}

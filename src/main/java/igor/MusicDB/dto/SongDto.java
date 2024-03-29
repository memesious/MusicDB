package igor.MusicDB.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SongDto {
  private Long id;
  private  String name;
  private String lyrics;
  private List<Long> albumId;
  private List<Long> artistId;
  private Integer year;

}

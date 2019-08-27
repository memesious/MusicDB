package igor.MusicDB.dto;

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
  private Long albumId;
  private Long artistId;

}

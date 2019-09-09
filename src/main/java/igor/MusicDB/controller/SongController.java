package igor.MusicDB.controller;

import igor.MusicDB.dto.SongDto;
import igor.MusicDB.entity.AlbumEntity;
import igor.MusicDB.service.AlbumService;
import igor.MusicDB.service.SongService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mdb")
public class SongController {
  private final SongService songService;
  private final AlbumService albumService;

  @PostMapping("/add")
  public void add(@RequestBody SongDto song) {songService.save(song);}

  @GetMapping("/songs")
  public List<SongDto> getAll(){return songService.getAll();}

  @GetMapping("/albums")
  public List<AlbumEntity> getAllEntities(){return albumService.getAll();}

}

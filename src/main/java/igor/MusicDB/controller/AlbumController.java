package igor.MusicDB.controller;


import igor.MusicDB.dto.AlbumDto;
import igor.MusicDB.entity.AlbumEntity;
import igor.MusicDB.service.AlbumService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/albums")

public class AlbumController {

  private final AlbumService albumService;

  @GetMapping
  public List<AlbumDto> getAllEntities() {
    return albumService.getAll();
  }

  @PostMapping("/add")
  public void add(@RequestBody AlbumDto album) {
    albumService.save(album);
  }

  @DeleteMapping("/delete/{id}")
  public void delete(@PathVariable Long id) {
    albumService.delete(id);
  }
}
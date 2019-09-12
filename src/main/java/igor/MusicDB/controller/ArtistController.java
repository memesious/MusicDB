package igor.MusicDB.controller;

import igor.MusicDB.dto.ArtistDto;
import igor.MusicDB.entity.ArtistEntity;
import igor.MusicDB.service.ArtistService;
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
@RequestMapping("/artists")
public class ArtistController {
  private final ArtistService artistService;
  @GetMapping
  public List<ArtistDto> getAll() {return artistService.getAll();}

  @PostMapping("/add")
  public void add(@RequestBody ArtistDto artist) {artistService.save(artist);}

  @DeleteMapping("/delete/{id}")
  public void delete(@PathVariable Long id){artistService.delete(id);}
}

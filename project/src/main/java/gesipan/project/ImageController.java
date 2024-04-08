package gesipan.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/images")
@CrossOrigin(origins = "*")
public class ImageController {
    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping
    public ResponseEntity<?> uploadImage(@RequestBody Image image) {
        imageService.saveData(image);
        return ResponseEntity.ok("이미지가 업로드되었습니다.");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteImage(@PathVariable Long id) {
        imageService.delete(id);
        return ResponseEntity.ok("이미지가 삭제되었습니다.");
    }
}
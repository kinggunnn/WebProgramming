package gesipan.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    private final ImageRepository imageRepository;

    @Autowired

    public ImageService(ImageRepository imageRepository){
        this.imageRepository= imageRepository;
    }
    public void saveData(Image image){
        imageRepository.save(image);
    }
    public void delete(Long id){
        imageRepository.deleteById(id);
    }

}

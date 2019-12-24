package lv.helloit.switter;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class SwitService {
    private List<Swit> swits = new ArrayList<>();
    private Long idCounter = 1L;

    public List<Swit> getAllSwits() {
        return swits;
    }

    public Swit getSwitById(Long switId) {
        return swits.stream()
                .filter(s -> s.getId().equals(switId))
                .findFirst()
                .get();
    }

    public void deleteSwitById(Long id) {
        swits.remove(getSwitById(id));
    }

    public void deleteAllSwits() {
        swits.clear();
    }

    public Swit addSwit(ChangeSwitDTO switDTO) {
        Swit swit = new Swit();
        swit.setAuthor(switDTO.getAuthor());
        swit.setContent(switDTO.getContent());
        swit.setId(idCounter);
        idCounter++;
        var currentTime = LocalDateTime.now();
        swit.setPublishDate(currentTime);
        swit.setLastUpdateDate(currentTime);
        swits.add(swit);
        return swit;
    }

    public void update(Long id, String newContent) {
        Swit targetSwit = getSwitById(id);
        targetSwit.setContent(newContent);
        targetSwit.setLastUpdateDate(LocalDateTime.now());

    }
}

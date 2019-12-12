package lv.helloit.switter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SwitService {
    private List<Swit> swits = new ArrayList<>();
    private Long idCounter = 1L;

    public List<Swit> getAllSwits() {
        return swits;
    }

    public void deleteAllSwits() {
        swits.clear();
    }

    public void addSwit(Swit newSwit) {
        newSwit.setId(idCounter);
        idCounter++;
        var currentTime = LocalDateTime.now();
        newSwit.setPublishDate(currentTime);
        newSwit.setLastUpdateDate(currentTime);
        swits.add(newSwit);
    }

    public void update(Long id, Swit newSwit) {
        for (Swit existingSwit : swits) {
            if (existingSwit.getId().equals(id)) {
                existingSwit.setAuthor(newSwit.getAuthor());
                existingSwit.setContent(newSwit.getContent());
                existingSwit.setLastUpdateDate(LocalDateTime.now());
                break;
            }
        }
    }
}

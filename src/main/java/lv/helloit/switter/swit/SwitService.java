package lv.helloit.switter.swit;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SwitService {
    private List<Swit> swits = new ArrayList<>();
    private Long idCounter = 1L;

    public List<Swit> getAllSwits() {
        return swits;
    }

    public Optional<Swit> getSwitById(Long switId) {
        return swits.stream()
                .filter(s -> s.getId().equals(switId))
                .findFirst();
    }

    public void deleteSwitById(Long id) {
        if (getSwitById(id).isPresent()) {
            swits.remove(getSwitById(id).get());
        }
    }

    public void deleteAllSwits() {
        swits.clear();
    }

    public Swit addSwit(ChangeSwitDTO switDTO) {
        Swit swit = new Swit();
        swit.setAuthor(switDTO.getUserId());
        swit.setContent(switDTO.getContent());
        swit.setId(idCounter);
        idCounter++;
        var currentTime = LocalDateTime.now();
        swit.setPublishDate(currentTime);
        swit.setLastUpdateDate(currentTime);
        swits.add(swit);
        return swit;
    }

    public void update(UpdateSwitDTO updateSwitDTO) {
        Optional<Swit> targetSwit = getSwitById(updateSwitDTO.getId());

        if (targetSwit.isPresent()) {
            targetSwit.get().setContent(updateSwitDTO.getContent());
            targetSwit.get().setLastUpdateDate(LocalDateTime.now());
        }
    }
}

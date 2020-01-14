package lv.helloit.switter.swit;

import lv.helloit.switter.user.User;
import lv.helloit.switter.user.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SwitService {
    private UserService userService;
    private List<Swit> swits = new ArrayList<>();
    private Long idCounter = 1L;

    public SwitService(UserService userService) {
        this.userService = userService;
    }

    public List<SwitDTO> getAllSwits() {
        List<SwitDTO> result = new ArrayList<>();

        for (Swit swit : swits) {
            SwitDTO switDTO = buildSwit(swit);
            result.add(switDTO);
        }

        return result;
    }

    public SwitDTO getSwitByIdToShow(Long switId) {
        Optional<Swit> possibleSwit = getSwitById(switId);

        if (possibleSwit.isPresent()) {
            Swit swit = possibleSwit.get();
            return buildSwit(swit);
        }
        return null;
    }

    private SwitDTO buildSwit(Swit swit) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return new SwitDTO.Builder()
                .id(swit.getId())
                .userId(swit.getUserId())
                .content(swit.getContent())
                .lastUpdateDate(swit.getLastUpdateDate().format(formatter))
                .publishDate(swit.getPublishDate().format(formatter))
                .userEmail(userService.getUserById(swit.getUserId()).getEmail())
                .build();
    }

    public void deleteSwitById(Long id) {
        if (getSwitById(id).isPresent()) {
            swits.remove(getSwitById(id).get());
        }
    }

    public Optional<Swit> getSwitById(Long switId) {
        return swits.stream()
                .filter(s -> s.getId().equals(switId))
                .findFirst();
    }

    public void deleteAllSwits() {
        swits.clear();
    }

    public Swit addSwit(ChangeSwitDTO switDTO, String userEmail) {
        Swit swit = new Swit();
        Optional<User> user = userService.getUserByEmail(userEmail);
        user.ifPresent(value -> swit.setAuthor(value.getId()));
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

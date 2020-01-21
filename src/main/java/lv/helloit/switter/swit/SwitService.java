package lv.helloit.switter.swit;

import lv.helloit.switter.user.User;
import lv.helloit.switter.user.UserService;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SwitService {
    private UserService userService;
    private SwitDao switDao;

    public SwitService(UserService userService, SwitDao switDao) {
        this.userService = userService;
        this.switDao = switDao;
    }


    public List<SwitDTO> getAllSwits() {
        List<SwitDTO> result = new ArrayList<>();

        for (Swit swit : switDao.findAll()) {
            SwitDTO switDTO = buildSwit(swit);
            result.add(switDTO);
        }

        return result;
    }


    public SwitDTO getSwitByIdToShow(String switId) {
        Optional<Swit> possibleSwit = getSwitById(switId);

        if (possibleSwit.isPresent()) {
            Swit swit = possibleSwit.get();
            return buildSwit(swit);
        }
        return null;
    }


    public void deleteSwitById(String id) {
        if (getSwitById(id).isPresent()) {
            switDao.deleteById(id);
        }
    }


    public Optional<Swit> getSwitById(String id) {
        return switDao.findById(id);
    }


    public void deleteAllSwits() {
        switDao.deleteAll();
    }


    public Swit addSwit(ChangeSwitDTO newSwit, String authorEmail) {

        Swit swit = new Swit();
        swit.setId(UUID.randomUUID().toString());
        swit.setContent(newSwit.getContent());
        Optional<User> possibleUser = userService.getUserByEmail(authorEmail);
        possibleUser.ifPresent(user -> swit.setUserId(user.getId()));

        var currentTime = LocalDateTime.now();
        swit.setPublishDate(currentTime);
        swit.setLastUpdateDate(currentTime);
        switDao.save(swit);
        return swit;
    }


    public void update(UpdateSwitDTO updateSwitDTO) {


        Optional<Swit> targetSwit = switDao.findById(updateSwitDTO.getId());

        if (targetSwit.isPresent()) {
            Swit swit = targetSwit.get();
            swit.setContent(updateSwitDTO.getContent());
            var currentTime = LocalDateTime.now();
            swit.setLastUpdateDate(currentTime);
            switDao.save(swit);
        }

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

}

package lv.helloit.switter.swit;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface SwitDao extends CrudRepository<Swit, String> {
    List<Swit> findAllByUserId(String userId);
}

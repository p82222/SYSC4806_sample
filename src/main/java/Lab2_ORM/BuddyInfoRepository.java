package Lab2_ORM;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Long> {

    List<BuddyInfo> findByName(String name);
    BuddyInfo findById(long id);
}
package online.advertisement.system.repository;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import online.advertisement.system.model.Message;

/**
 * 
 * repository for Message functionalities
 *
 */

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO message_adv (msgid,userid, advid, text_message) VALUES(:msgid,:userid, :advid, :text_message) ", nativeQuery = true)

	public abstract void inserteds(int msgid, int userid, int advid, String text_message);

}
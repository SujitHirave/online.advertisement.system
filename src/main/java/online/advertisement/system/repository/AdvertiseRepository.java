package online.advertisement.system.repository;

import online.advertisement.system.model.Advertise;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertiseRepository extends JpaRepository<Advertise, Integer> {

//	Search Advertise by text entered in textbox(seller)
	public abstract List<Advertise> findByadvertisetitle(String advertisetitle);

//	Read the specific advertise by id(seller)
	public abstract Advertise getByadvid(int advid);

//	Delete product by id
	@Modifying
	@Transactional
	@Query("DELETE from Advertise a WHERE a.advid = :advid")
	public abstract void deleteById(int advid);

//	show approved advertise for buyer
	@Modifying
	@Transactional
	@Query(value = "SELECT * FROM advertise_adv WHERE status IN ( 'OPEN', 'APPROVED')", nativeQuery = true)
	public abstract List<Advertise> viewApprovedAdv();

//	Post New Advertise(Selling)
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO advertise_adv (advid, advertisetitle, price, description, advownername, catid) VALUES(:advid, :advertisetitle, :price, :description, :advownername, :catid) ", nativeQuery = true)
	public abstract void addSellerAdv(int advid, String advertisetitle, double price, String description,
			String advownername, int catid);

//	User will update advertise details (seller)
	@Modifying
	@Transactional
	@Query(value = "UPDATE Advertise SET advertisetitle = :advertisetitle, price = :price, description = :description, advownername = :advownername,  catid = :catid WHERE advid = :advid ")
	public abstract void updateSellerAdv(@Param(value = "advertisetitle") String advertisetitle,
			@Param(value = "price") double price, @Param(value = "description") String description,
			@Param(value = "advownername") String advownername, @Param(value = "catid") int catid,
			@Param(value = "advid") int advid);

//	Admin will update status of advertise
	@Modifying
	@Transactional
	@Query("UPDATE Advertise a SET a.status = :status  WHERE a.advid = :advid")
	public abstract void updateStatusAdv(@Param(value = "status") String status, @Param(value = "advid") int advid);
//	 method that works with custom exception	
	public abstract Optional<Advertise> findByAdvertisetitle(String advertisetitle);

//search product by text
//	@Modifying
//	@Transactional
//	@Query(value = "SELECT * FROM advertise_adv WHERE advertisetitle = :advertisetitle, price = :price, description = :description, category=:category", nativeQuery = true)
//	
//	public abstract List<Advertise> searchproductByText();

}

package online.advertisement.system.repository;

import online.advertisement.system.model.Advertise;
import online.advertisement.system.model.AppUser;
import online.advertisement.system.model.Category;
import online.advertisement.system.model.Message;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertiseRepository extends JpaRepository<Advertise, Integer> {

	// List<Advertise> findByName(String advertisetitle);

	public abstract List<Advertise> findByadvertisetitle(String advertisetitle);

	public abstract Advertise getByadvid(int advid);

//	Delete product by id
	@Modifying
	@Transactional
	@Query("DELETE from Advertise a WHERE a.advid = :advid")
	public abstract void deleteById(int advid);

//	show approved advertise for buyer
	@Modifying
	@Transactional
	@Query( value = "SELECT * FROM advertise_adv WHERE status IN ( 'OPEN', 'APPROVED')", nativeQuery = true)
	public abstract List<Advertise> viewApprovedAdv();

	
//	Post New Advertise(Selling)
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO advertise_adv (advid, advertisetitle, price, description, advownername, catid) VALUES(:advid, :advertisetitle, :price, :description, :advownername, :catid) ", nativeQuery = true)
	public abstract void addSellerAdv(int advid, String advertisetitle, double price, String description, String advownername, int catid);

//	Admin will update status of advertise
	@Modifying
	@Transactional
//	@Query(value = "UPDATE advertise_adv (advid, status) VALUES(:advid, :status)", nativeQuery = true)
	@Query("UPDATE advertise_adv a SET a.status = :status  WHERE a.advid = :advid")
	public abstract void updateStatusAdv(@Param(value = "status") String status, @Param(value = "advid") int advid);
//	void updatePhone(@Param(value = "id") long id, @Param(value = "phone") String phone);
//	public abstract void updateStatusAdv(int advid, String status);



}

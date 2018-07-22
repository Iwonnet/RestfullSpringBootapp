package pl.lukasziwon;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.lukasziwon.io.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
	
	UserEntity findByEmail(String email) ;

	UserEntity findByUserId(String userID);

}

package dio.desafio.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dio.desafio.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}

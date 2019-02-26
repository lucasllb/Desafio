package DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, String>{

	public Cidade findByIbgeid(String ibgeid);
	
}

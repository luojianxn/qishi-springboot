package qishi.repositoryInterface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface BaseRepositoryITF <T,ID extends Serializable> {
   public List<Object[]>  listBySQL(String sql);
}

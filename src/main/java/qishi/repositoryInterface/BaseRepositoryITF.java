package qishi.repositoryInterface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@NoRepositoryBean
public interface BaseRepositoryITF <T,ID extends Serializable> {
   public List<Object[]>  listBySQL(String sql);
   public List<Map>  listMapBySQL(String sql);
   public Map  excuteSp(String spName);
}

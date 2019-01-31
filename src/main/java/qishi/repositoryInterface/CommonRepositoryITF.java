package qishi.repositoryInterface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface CommonRepositoryITF<T,ID extends Serializable> extends BaseRepositoryITF<T, ID>  , JpaRepository<T,ID>  {

}

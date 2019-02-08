package qishi.repositoryInterface;

import org.springframework.data.repository.NoRepositoryBean;
import qishi.entity.SpParam;
import qishi.entity.User;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Created by ljx on 2019/2/7.
 */
@NoRepositoryBean
public interface SpParaRepositoryITF extends CommonRepositoryITF<SpParam,Integer>  {
}

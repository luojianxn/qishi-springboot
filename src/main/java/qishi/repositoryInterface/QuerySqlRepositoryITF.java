package qishi.repositoryInterface;

import org.springframework.data.repository.NoRepositoryBean;
import qishi.entity.QuerySql;
import qishi.entity.User;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Created by ljx on 2019/2/7.
 */
@NoRepositoryBean
public interface QuerySqlRepositoryITF extends CommonRepositoryITF<QuerySql,Integer> {

}

package qishi.repositoryInterface;

import org.springframework.context.annotation.Scope;
import org.springframework.data.repository.NoRepositoryBean;
import qishi.entity.QuerySql;
import qishi.entity.User;

import java.util.Map;

/**
 * Created by ljx on 2019/2/5.
 */
@Scope("singleton")
public interface SettingRepositoryITF  extends CommonRepositoryITF<QuerySql,Integer>  {
}

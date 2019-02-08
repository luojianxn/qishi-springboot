package qishi.repositoryInterface;


import org.springframework.context.annotation.Scope;
import qishi.entity.User;
@Scope("singleton")
public interface UserRepositoryITF extends CommonRepositoryITF<User,Integer> {
}

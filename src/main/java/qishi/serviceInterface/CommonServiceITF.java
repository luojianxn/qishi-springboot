package qishi.serviceInterface;

import java.util.List;
import java.util.Map;

public interface CommonServiceITF {
    public void loginIn();
    public void loginOut();
    public List<Map> test();
    public List<Map> getData(String sqlId);

}

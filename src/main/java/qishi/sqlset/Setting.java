package qishi.sqlset;

import java.util.List;
import java.util.Map;

/**
 * Created by ljx on 2019/2/4.
 */
public interface Setting {

   boolean initialize();
   boolean isInited();
   boolean  refresh();
   boolean  read();
   List  printCache();
   String getSqlText(String sqlId);
   List getParamsMap(String spName);
}

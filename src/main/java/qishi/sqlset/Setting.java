package qishi.sqlset;

import qishi.entity.QuerySql;
import qishi.entity.SpParam;

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
   QuerySql getQuerySql(String sqlName);
   List<SpParam> getParamsMap(String spName);
}

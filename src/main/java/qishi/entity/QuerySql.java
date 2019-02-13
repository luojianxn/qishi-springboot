package qishi.entity;

import javax.persistence.*;

/**
 * Created by ljx on 2019/2/7.
 */
@Entity
@Table(name = "tsql")
public class QuerySql {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sqlid")
    private Integer sqlid;
    @Column(name = "sqlname", nullable = false)
    private String sqlname;
   @Column(name = "sqltext", nullable = false)
    private String sqltext;
    @Column(name = "pagesize", nullable = false)
    private int pagesize;

    public QuerySql() {

    }

    public Integer getSqlid() {
        return sqlid;
    }

    public void setSqlid(Integer sqlid) {
        this.sqlid = sqlid;
    }

    public String getSqlname() {
        return sqlname;
    }

    public void setSqlname(String sqlname) {
        this.sqlname = sqlname;
    }

    public String getSqltext() {
        return sqltext;
    }

    public void setSqltext(String sqltext) {
        this.sqltext = sqltext;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }
}

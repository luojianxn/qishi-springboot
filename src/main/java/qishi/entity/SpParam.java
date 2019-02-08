package qishi.entity;

import javax.persistence.*;

/**
 * Created by ljx on 2019/2/7.
 */
//@Entity
//@Table(name = "tsppara")
public class SpParam {

   // @Column(name = "parasspname",nullable = false)
    private String  parasspname;
   // @Column(name = "paraName", nullable = false)
    private String paraName;
    //@Column(name = "paraLine", nullable = false)
    private int  paraLine;

    public String getParasspname() {
        return parasspname;
    }

    public void setParasspname(String parasspname) {
        this.parasspname = parasspname;
    }

    public String getParaName() {
        return paraName;
    }

    public void setParaName(String paraName) {
        this.paraName = paraName;
    }

    public int getParaLine() {
        return paraLine;
    }

    public void setParaLine(int paraLine) {
        this.paraLine = paraLine;
    }
}
